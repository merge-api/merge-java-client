package dev.merge.api.services.blocking.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.SyncStatus
import dev.merge.api.models.ats.SyncStatusListPage
import dev.merge.api.models.ats.SyncStatusListParams
import dev.merge.api.models.ats.SyncStatusResyncParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class SyncStatusServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : SyncStatusService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<SyncStatusListPage.Response> =
        jsonHandler<SyncStatusListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Get syncing status. Possible values: `DISABLED`, `DONE`, `FAILED`, `PAUSED`, `SYNCING` */
    override fun list(
        params: SyncStatusListParams,
        requestOptions: RequestOptions
    ): SyncStatusListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "sync-status")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { SyncStatusListPage.of(this, params, it) }
        }
    }

    private val resyncHandler: Handler<List<SyncStatus>> =
        jsonHandler<List<SyncStatus>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Force re-sync of all models. This is available for all organizations via the dashboard. Force
     * re-sync is also available programmatically via API for monthly, quarterly, and highest sync
     * frequency customers on the Core, Professional, or Enterprise plans. Doing so will consume a
     * sync credit for the relevant linked account.
     */
    override fun resync(
        params: SyncStatusResyncParams,
        requestOptions: RequestOptions
    ): List<SyncStatus> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "sync-status", "resync")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { resyncHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        forEach { it.validate() }
                    }
                }
        }
    }
}

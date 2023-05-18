package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.SyncStatus
import dev.merge.api.models.fileStorage.SyncStatusListPageAsync
import dev.merge.api.models.fileStorage.SyncStatusListParams
import dev.merge.api.models.fileStorage.SyncStatusResyncParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class SyncStatusServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : SyncStatusServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<SyncStatusListPageAsync.Response> =
        jsonHandler<SyncStatusListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Get syncing status. Possible values: `DISABLED`, `DONE`, `FAILED`, `PAUSED`, `SYNCING` */
    override fun list(
        params: SyncStatusListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<SyncStatusListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "sync-status")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { SyncStatusListPageAsync.of(this, params, it) }
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
    ): CompletableFuture<List<SyncStatus>> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("filestorage", "v1", "sync-status", "resync")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
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

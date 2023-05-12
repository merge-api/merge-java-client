package dev.merge.api.services.blocking.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.SelectiveSyncListMetadataPage
import dev.merge.api.models.hris.SelectiveSyncListMetadataParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class SelectiveSyncServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : SelectiveSyncService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val listMetadataHandler: Handler<SelectiveSyncListMetadataPage.Response> =
        jsonHandler<SelectiveSyncListMetadataPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Get metadata for the conditions available to a linked account. */
    override fun listMetadata(
        params: SelectiveSyncListMetadataParams,
        requestOptions: RequestOptions
    ): SelectiveSyncListMetadataPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "selective-sync", "meta")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listMetadataHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { SelectiveSyncListMetadataPage.of(this, params, it) }
        }
    }
}

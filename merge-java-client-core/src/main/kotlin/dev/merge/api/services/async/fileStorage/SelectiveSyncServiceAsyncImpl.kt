package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.fileStorage.SelectiveSyncListMetadataPageAsync
import dev.merge.api.models.fileStorage.SelectiveSyncListMetadataParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class SelectiveSyncServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : SelectiveSyncServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val listMetadataHandler: Handler<SelectiveSyncListMetadataPageAsync.Response> =
        jsonHandler<SelectiveSyncListMetadataPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Get metadata for the conditions available to a linked account. */
    override fun listMetadata(
        params: SelectiveSyncListMetadataParams,
        requestOptions: RequestOptions
    ): CompletableFuture<SelectiveSyncListMetadataPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "selective-sync", "meta")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listMetadataHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { SelectiveSyncListMetadataPageAsync.of(this, params, it) }
        }
    }
}

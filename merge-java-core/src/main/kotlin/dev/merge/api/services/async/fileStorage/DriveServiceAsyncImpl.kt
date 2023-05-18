package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.fileStorage.Drive
import dev.merge.api.models.fileStorage.DriveListPageAsync
import dev.merge.api.models.fileStorage.DriveListParams
import dev.merge.api.models.fileStorage.DriveRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class DriveServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : DriveServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Drive> =
        jsonHandler<Drive>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Drive` object with the given `id`. */
    override fun retrieve(
        params: DriveRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Drive> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "drives", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<DriveListPageAsync.Response> =
        jsonHandler<DriveListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Drive` objects. */
    override fun list(
        params: DriveListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<DriveListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "drives")
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
                .let { DriveListPageAsync.of(this, params, it) }
        }
    }
}

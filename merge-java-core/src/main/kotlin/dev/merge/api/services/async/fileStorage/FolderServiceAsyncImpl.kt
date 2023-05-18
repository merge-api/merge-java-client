package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.fileStorage.Folder
import dev.merge.api.models.fileStorage.FolderCreateParams
import dev.merge.api.models.fileStorage.FolderListPageAsync
import dev.merge.api.models.fileStorage.FolderListParams
import dev.merge.api.models.fileStorage.FolderResponse
import dev.merge.api.models.fileStorage.FolderRetrieveParams
import dev.merge.api.services.async.fileStorage.folders.MetaServiceAsync
import dev.merge.api.services.async.fileStorage.folders.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class FolderServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : FolderServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<FolderResponse> =
        jsonHandler<FolderResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Folder` object with the given values. */
    override fun create(
        params: FolderCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<FolderResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("filestorage", "v1", "folders")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<Folder> =
        jsonHandler<Folder>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Folder` object with the given `id`. */
    override fun retrieve(
        params: FolderRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Folder> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "folders", params.getPathParam(0))
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

    private val listHandler: Handler<FolderListPageAsync.Response> =
        jsonHandler<FolderListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Folder` objects. */
    override fun list(
        params: FolderListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<FolderListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "folders")
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
                .let { FolderListPageAsync.of(this, params, it) }
        }
    }
}

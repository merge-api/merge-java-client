package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.fileStorage.Folder
import dev.merge.api.models.fileStorage.FolderCreateParams
import dev.merge.api.models.fileStorage.FolderListPage
import dev.merge.api.models.fileStorage.FolderListParams
import dev.merge.api.models.fileStorage.FolderResponse
import dev.merge.api.models.fileStorage.FolderRetrieveParams
import dev.merge.api.services.blocking.fileStorage.folders.MetaService
import dev.merge.api.services.blocking.fileStorage.folders.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class FolderServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : FolderService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<FolderResponse> =
        jsonHandler<FolderResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Folder` object with the given values. */
    override fun create(
        params: FolderCreateParams,
        requestOptions: RequestOptions
    ): FolderResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("filestorage", "v1", "folders")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
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
    override fun retrieve(params: FolderRetrieveParams, requestOptions: RequestOptions): Folder {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "folders", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<FolderListPage.Response> =
        jsonHandler<FolderListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Folder` objects. */
    override fun list(params: FolderListParams, requestOptions: RequestOptions): FolderListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "folders")
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
                .let { FolderListPage.of(this, params, it) }
        }
    }
}

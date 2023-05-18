package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.fileStorage.File
import dev.merge.api.models.fileStorage.FileCreateParams
import dev.merge.api.models.fileStorage.FileDownloadParams
import dev.merge.api.models.fileStorage.FileListPage
import dev.merge.api.models.fileStorage.FileListParams
import dev.merge.api.models.fileStorage.FileResponse
import dev.merge.api.models.fileStorage.FileRetrieveParams
import dev.merge.api.services.blocking.fileStorage.files.MetaService
import dev.merge.api.services.blocking.fileStorage.files.MetaServiceImpl
import dev.merge.api.services.emptyHandler
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class FileServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : FileService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<FileResponse> =
        jsonHandler<FileResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `File` object with the given values. */
    override fun create(params: FileCreateParams, requestOptions: RequestOptions): FileResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("filestorage", "v1", "files")
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

    private val retrieveHandler: Handler<File> =
        jsonHandler<File>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `File` object with the given `id`. */
    override fun retrieve(params: FileRetrieveParams, requestOptions: RequestOptions): File {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "files", params.getPathParam(0))
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

    private val listHandler: Handler<FileListPage.Response> =
        jsonHandler<FileListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of `File` objects. */
    override fun list(params: FileListParams, requestOptions: RequestOptions): FileListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "files")
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
                .let { FileListPage.of(this, params, it) }
        }
    }

    private val downloadHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /** Returns a `File` object with the given `id`. */
    override fun download(params: FileDownloadParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "files", params.getPathParam(0), "download")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response.let { downloadHandler.handle(it) }
        }
    }
}

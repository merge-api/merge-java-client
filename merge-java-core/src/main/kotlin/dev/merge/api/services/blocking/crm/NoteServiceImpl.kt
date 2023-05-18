package dev.merge.api.services.blocking.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.Note
import dev.merge.api.models.crm.NoteCreateParams
import dev.merge.api.models.crm.NoteListPage
import dev.merge.api.models.crm.NoteListParams
import dev.merge.api.models.crm.NoteListRemoteFieldClassesPage
import dev.merge.api.models.crm.NoteListRemoteFieldClassesParams
import dev.merge.api.models.crm.NoteResponse
import dev.merge.api.models.crm.NoteRetrieveParams
import dev.merge.api.services.blocking.crm.notes.MetaService
import dev.merge.api.services.blocking.crm.notes.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class NoteServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : NoteService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<NoteResponse> =
        jsonHandler<NoteResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Note` object with the given values. */
    override fun create(params: NoteCreateParams, requestOptions: RequestOptions): NoteResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("crm", "v1", "notes")
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

    private val retrieveHandler: Handler<Note> =
        jsonHandler<Note>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Note` object with the given `id`. */
    override fun retrieve(params: NoteRetrieveParams, requestOptions: RequestOptions): Note {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "notes", params.getPathParam(0))
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

    private val listHandler: Handler<NoteListPage.Response> =
        jsonHandler<NoteListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of `Note` objects. */
    override fun list(params: NoteListParams, requestOptions: RequestOptions): NoteListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "notes")
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
                .let { NoteListPage.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler: Handler<NoteListRemoteFieldClassesPage.Response> =
        jsonHandler<NoteListRemoteFieldClassesPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: NoteListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): NoteListRemoteFieldClassesPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "notes", "remote-field-classes")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listRemoteFieldClassesHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { NoteListRemoteFieldClassesPage.of(this, params, it) }
        }
    }
}

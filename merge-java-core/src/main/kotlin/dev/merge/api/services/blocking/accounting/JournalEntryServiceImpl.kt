package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.JournalEntry
import dev.merge.api.models.accounting.JournalEntryCreateParams
import dev.merge.api.models.accounting.JournalEntryListPage
import dev.merge.api.models.accounting.JournalEntryListParams
import dev.merge.api.models.accounting.JournalEntryResponse
import dev.merge.api.models.accounting.JournalEntryRetrieveParams
import dev.merge.api.services.blocking.accounting.journalEntries.MetaService
import dev.merge.api.services.blocking.accounting.journalEntries.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class JournalEntryServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : JournalEntryService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<JournalEntryResponse> =
        jsonHandler<JournalEntryResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `JournalEntry` object with the given values. */
    override fun create(
        params: JournalEntryCreateParams,
        requestOptions: RequestOptions
    ): JournalEntryResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "journal-entries")
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

    private val retrieveHandler: Handler<JournalEntry> =
        jsonHandler<JournalEntry>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `JournalEntry` object with the given `id`. */
    override fun retrieve(
        params: JournalEntryRetrieveParams,
        requestOptions: RequestOptions
    ): JournalEntry {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "journal-entries", params.getPathParam(0))
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

    private val listHandler: Handler<JournalEntryListPage.Response> =
        jsonHandler<JournalEntryListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `JournalEntry` objects. */
    override fun list(
        params: JournalEntryListParams,
        requestOptions: RequestOptions
    ): JournalEntryListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "journal-entries")
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
                .let { JournalEntryListPage.of(this, params, it) }
        }
    }
}

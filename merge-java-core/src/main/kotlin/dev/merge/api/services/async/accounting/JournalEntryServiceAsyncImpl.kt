package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.JournalEntry
import dev.merge.api.models.accounting.JournalEntryCreateParams
import dev.merge.api.models.accounting.JournalEntryListPageAsync
import dev.merge.api.models.accounting.JournalEntryListParams
import dev.merge.api.models.accounting.JournalEntryResponse
import dev.merge.api.models.accounting.JournalEntryRetrieveParams
import dev.merge.api.services.async.accounting.journalEntries.MetaServiceAsync
import dev.merge.api.services.async.accounting.journalEntries.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class JournalEntryServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : JournalEntryServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<JournalEntryResponse> =
        jsonHandler<JournalEntryResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `JournalEntry` object with the given values. */
    override fun create(
        params: JournalEntryCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<JournalEntryResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "journal-entries")
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

    private val retrieveHandler: Handler<JournalEntry> =
        jsonHandler<JournalEntry>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `JournalEntry` object with the given `id`. */
    override fun retrieve(
        params: JournalEntryRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<JournalEntry> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "journal-entries", params.getPathParam(0))
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

    private val listHandler: Handler<JournalEntryListPageAsync.Response> =
        jsonHandler<JournalEntryListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `JournalEntry` objects. */
    override fun list(
        params: JournalEntryListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<JournalEntryListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "journal-entries")
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
                .let { JournalEntryListPageAsync.of(this, params, it) }
        }
    }
}

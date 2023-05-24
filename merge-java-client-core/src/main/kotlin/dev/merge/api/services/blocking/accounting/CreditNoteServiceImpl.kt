package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.CreditNote
import dev.merge.api.models.accounting.CreditNoteListPage
import dev.merge.api.models.accounting.CreditNoteListParams
import dev.merge.api.models.accounting.CreditNoteRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class CreditNoteServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : CreditNoteService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<CreditNote> =
        jsonHandler<CreditNote>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `CreditNote` object with the given `id`. */
    override fun retrieve(
        params: CreditNoteRetrieveParams,
        requestOptions: RequestOptions
    ): CreditNote {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "credit-notes", params.getPathParam(0))
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

    private val listHandler: Handler<CreditNoteListPage.Response> =
        jsonHandler<CreditNoteListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `CreditNote` objects. */
    override fun list(
        params: CreditNoteListParams,
        requestOptions: RequestOptions
    ): CreditNoteListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "credit-notes")
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
                .let { CreditNoteListPage.of(this, params, it) }
        }
    }
}

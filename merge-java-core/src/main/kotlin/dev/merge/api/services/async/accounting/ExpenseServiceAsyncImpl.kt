package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.Expense
import dev.merge.api.models.accounting.ExpenseCreateParams
import dev.merge.api.models.accounting.ExpenseListPageAsync
import dev.merge.api.models.accounting.ExpenseListParams
import dev.merge.api.models.accounting.ExpenseResponse
import dev.merge.api.models.accounting.ExpenseRetrieveParams
import dev.merge.api.services.async.accounting.expenses.MetaServiceAsync
import dev.merge.api.services.async.accounting.expenses.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class ExpenseServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ExpenseServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<ExpenseResponse> =
        jsonHandler<ExpenseResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Expense` object with the given values. */
    override fun create(
        params: ExpenseCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ExpenseResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "expenses")
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

    private val retrieveHandler: Handler<Expense> =
        jsonHandler<Expense>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Expense` object with the given `id`. */
    override fun retrieve(
        params: ExpenseRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Expense> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "expenses", params.getPathParam(0))
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

    private val listHandler: Handler<ExpenseListPageAsync.Response> =
        jsonHandler<ExpenseListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Expense` objects. */
    override fun list(
        params: ExpenseListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ExpenseListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "expenses")
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
                .let { ExpenseListPageAsync.of(this, params, it) }
        }
    }
}

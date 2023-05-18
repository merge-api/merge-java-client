package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.IncomeStatement
import dev.merge.api.models.accounting.IncomeStatementListPageAsync
import dev.merge.api.models.accounting.IncomeStatementListParams
import dev.merge.api.models.accounting.IncomeStatementRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class IncomeStatementServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : IncomeStatementServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<IncomeStatement> =
        jsonHandler<IncomeStatement>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `IncomeStatement` object with the given `id`. */
    override fun retrieve(
        params: IncomeStatementRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<IncomeStatement> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "income-statements", params.getPathParam(0))
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

    private val listHandler: Handler<IncomeStatementListPageAsync.Response> =
        jsonHandler<IncomeStatementListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `IncomeStatement` objects. */
    override fun list(
        params: IncomeStatementListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<IncomeStatementListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "income-statements")
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
                .let { IncomeStatementListPageAsync.of(this, params, it) }
        }
    }
}

package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.CashFlowStatement
import dev.merge.api.models.accounting.CashFlowStatementListPageAsync
import dev.merge.api.models.accounting.CashFlowStatementListParams
import dev.merge.api.models.accounting.CashFlowStatementRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class CashFlowStatementServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CashFlowStatementServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<CashFlowStatement> =
        jsonHandler<CashFlowStatement>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `CashFlowStatement` object with the given `id`. */
    override fun retrieve(
        params: CashFlowStatementRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CashFlowStatement> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "cash-flow-statements", params.getPathParam(0))
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

    private val listHandler: Handler<CashFlowStatementListPageAsync.Response> =
        jsonHandler<CashFlowStatementListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `CashFlowStatement` objects. */
    override fun list(
        params: CashFlowStatementListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CashFlowStatementListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "cash-flow-statements")
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
                .let { CashFlowStatementListPageAsync.of(this, params, it) }
        }
    }
}

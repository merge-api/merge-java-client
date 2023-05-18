package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.BalanceSheet
import dev.merge.api.models.accounting.BalanceSheetListPageAsync
import dev.merge.api.models.accounting.BalanceSheetListParams
import dev.merge.api.models.accounting.BalanceSheetRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class BalanceSheetServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : BalanceSheetServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<BalanceSheet> =
        jsonHandler<BalanceSheet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `BalanceSheet` object with the given `id`. */
    override fun retrieve(
        params: BalanceSheetRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<BalanceSheet> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "balance-sheets", params.getPathParam(0))
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

    private val listHandler: Handler<BalanceSheetListPageAsync.Response> =
        jsonHandler<BalanceSheetListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `BalanceSheet` objects. */
    override fun list(
        params: BalanceSheetListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<BalanceSheetListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "balance-sheets")
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
                .let { BalanceSheetListPageAsync.of(this, params, it) }
        }
    }
}

package dev.merge.api.services.async.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.TimeOffBalance
import dev.merge.api.models.hris.TimeOffBalanceListPageAsync
import dev.merge.api.models.hris.TimeOffBalanceListParams
import dev.merge.api.models.hris.TimeOffBalanceRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class TimeOffBalanceServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TimeOffBalanceServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<TimeOffBalance> =
        jsonHandler<TimeOffBalance>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `TimeOffBalance` object with the given `id`. */
    override fun retrieve(
        params: TimeOffBalanceRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TimeOffBalance> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "time-off-balances", params.getPathParam(0))
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

    private val listHandler: Handler<TimeOffBalanceListPageAsync.Response> =
        jsonHandler<TimeOffBalanceListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `TimeOffBalance` objects. */
    override fun list(
        params: TimeOffBalanceListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TimeOffBalanceListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "time-off-balances")
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
                .let { TimeOffBalanceListPageAsync.of(this, params, it) }
        }
    }
}

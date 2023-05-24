package dev.merge.api.services.async.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.PayrollRun
import dev.merge.api.models.hris.PayrollRunListPageAsync
import dev.merge.api.models.hris.PayrollRunListParams
import dev.merge.api.models.hris.PayrollRunRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class PayrollRunServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : PayrollRunServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<PayrollRun> =
        jsonHandler<PayrollRun>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `PayrollRun` object with the given `id`. */
    override fun retrieve(
        params: PayrollRunRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PayrollRun> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "payroll-runs", params.getPathParam(0))
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

    private val listHandler: Handler<PayrollRunListPageAsync.Response> =
        jsonHandler<PayrollRunListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `PayrollRun` objects. */
    override fun list(
        params: PayrollRunListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PayrollRunListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "payroll-runs")
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
                .let { PayrollRunListPageAsync.of(this, params, it) }
        }
    }
}

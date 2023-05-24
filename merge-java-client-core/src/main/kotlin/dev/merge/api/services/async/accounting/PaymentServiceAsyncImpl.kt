package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.Payment
import dev.merge.api.models.accounting.PaymentCreateParams
import dev.merge.api.models.accounting.PaymentListPageAsync
import dev.merge.api.models.accounting.PaymentListParams
import dev.merge.api.models.accounting.PaymentResponse
import dev.merge.api.models.accounting.PaymentRetrieveParams
import dev.merge.api.services.async.accounting.payments.MetaServiceAsync
import dev.merge.api.services.async.accounting.payments.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class PaymentServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : PaymentServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<PaymentResponse> =
        jsonHandler<PaymentResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Payment` object with the given values. */
    override fun create(
        params: PaymentCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PaymentResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "payments")
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

    private val retrieveHandler: Handler<Payment> =
        jsonHandler<Payment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Payment` object with the given `id`. */
    override fun retrieve(
        params: PaymentRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Payment> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "payments", params.getPathParam(0))
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

    private val listHandler: Handler<PaymentListPageAsync.Response> =
        jsonHandler<PaymentListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Payment` objects. */
    override fun list(
        params: PaymentListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PaymentListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "payments")
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
                .let { PaymentListPageAsync.of(this, params, it) }
        }
    }
}

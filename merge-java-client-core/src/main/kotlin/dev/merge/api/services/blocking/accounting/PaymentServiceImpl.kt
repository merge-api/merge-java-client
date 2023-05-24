package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.Payment
import dev.merge.api.models.accounting.PaymentCreateParams
import dev.merge.api.models.accounting.PaymentListPage
import dev.merge.api.models.accounting.PaymentListParams
import dev.merge.api.models.accounting.PaymentResponse
import dev.merge.api.models.accounting.PaymentRetrieveParams
import dev.merge.api.services.blocking.accounting.payments.MetaService
import dev.merge.api.services.blocking.accounting.payments.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class PaymentServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : PaymentService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<PaymentResponse> =
        jsonHandler<PaymentResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Payment` object with the given values. */
    override fun create(
        params: PaymentCreateParams,
        requestOptions: RequestOptions
    ): PaymentResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "payments")
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

    private val retrieveHandler: Handler<Payment> =
        jsonHandler<Payment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Payment` object with the given `id`. */
    override fun retrieve(params: PaymentRetrieveParams, requestOptions: RequestOptions): Payment {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "payments", params.getPathParam(0))
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

    private val listHandler: Handler<PaymentListPage.Response> =
        jsonHandler<PaymentListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Payment` objects. */
    override fun list(params: PaymentListParams, requestOptions: RequestOptions): PaymentListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "payments")
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
                .let { PaymentListPage.of(this, params, it) }
        }
    }
}

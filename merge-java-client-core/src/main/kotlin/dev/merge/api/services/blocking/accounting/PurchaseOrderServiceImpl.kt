package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.PurchaseOrder
import dev.merge.api.models.accounting.PurchaseOrderCreateParams
import dev.merge.api.models.accounting.PurchaseOrderListPage
import dev.merge.api.models.accounting.PurchaseOrderListParams
import dev.merge.api.models.accounting.PurchaseOrderResponse
import dev.merge.api.models.accounting.PurchaseOrderRetrieveParams
import dev.merge.api.services.blocking.accounting.purchaseOrders.MetaService
import dev.merge.api.services.blocking.accounting.purchaseOrders.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class PurchaseOrderServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : PurchaseOrderService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<PurchaseOrderResponse> =
        jsonHandler<PurchaseOrderResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `PurchaseOrder` object with the given values. */
    override fun create(
        params: PurchaseOrderCreateParams,
        requestOptions: RequestOptions
    ): PurchaseOrderResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "purchase-orders")
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

    private val retrieveHandler: Handler<PurchaseOrder> =
        jsonHandler<PurchaseOrder>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `PurchaseOrder` object with the given `id`. */
    override fun retrieve(
        params: PurchaseOrderRetrieveParams,
        requestOptions: RequestOptions
    ): PurchaseOrder {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "purchase-orders", params.getPathParam(0))
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

    private val listHandler: Handler<PurchaseOrderListPage.Response> =
        jsonHandler<PurchaseOrderListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `PurchaseOrder` objects. */
    override fun list(
        params: PurchaseOrderListParams,
        requestOptions: RequestOptions
    ): PurchaseOrderListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "purchase-orders")
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
                .let { PurchaseOrderListPage.of(this, params, it) }
        }
    }
}

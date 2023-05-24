package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.PurchaseOrder
import dev.merge.api.models.accounting.PurchaseOrderCreateParams
import dev.merge.api.models.accounting.PurchaseOrderListPageAsync
import dev.merge.api.models.accounting.PurchaseOrderListParams
import dev.merge.api.models.accounting.PurchaseOrderResponse
import dev.merge.api.models.accounting.PurchaseOrderRetrieveParams
import dev.merge.api.services.async.accounting.purchaseOrders.MetaServiceAsync
import dev.merge.api.services.async.accounting.purchaseOrders.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class PurchaseOrderServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : PurchaseOrderServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<PurchaseOrderResponse> =
        jsonHandler<PurchaseOrderResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `PurchaseOrder` object with the given values. */
    override fun create(
        params: PurchaseOrderCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PurchaseOrderResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "purchase-orders")
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

    private val retrieveHandler: Handler<PurchaseOrder> =
        jsonHandler<PurchaseOrder>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `PurchaseOrder` object with the given `id`. */
    override fun retrieve(
        params: PurchaseOrderRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PurchaseOrder> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "purchase-orders", params.getPathParam(0))
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

    private val listHandler: Handler<PurchaseOrderListPageAsync.Response> =
        jsonHandler<PurchaseOrderListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `PurchaseOrder` objects. */
    override fun list(
        params: PurchaseOrderListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PurchaseOrderListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "purchase-orders")
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
                .let { PurchaseOrderListPageAsync.of(this, params, it) }
        }
    }
}

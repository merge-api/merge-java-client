package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.TaxRate
import dev.merge.api.models.accounting.TaxRateListPageAsync
import dev.merge.api.models.accounting.TaxRateListParams
import dev.merge.api.models.accounting.TaxRateRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class TaxRateServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TaxRateServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<TaxRate> =
        jsonHandler<TaxRate>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `TaxRate` object with the given `id`. */
    override fun retrieve(
        params: TaxRateRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TaxRate> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "tax-rates", params.getPathParam(0))
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

    private val listHandler: Handler<TaxRateListPageAsync.Response> =
        jsonHandler<TaxRateListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `TaxRate` objects. */
    override fun list(
        params: TaxRateListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TaxRateListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "tax-rates")
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
                .let { TaxRateListPageAsync.of(this, params, it) }
        }
    }
}

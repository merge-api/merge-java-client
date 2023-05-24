package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.TaxRate
import dev.merge.api.models.accounting.TaxRateListPage
import dev.merge.api.models.accounting.TaxRateListParams
import dev.merge.api.models.accounting.TaxRateRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class TaxRateServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : TaxRateService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<TaxRate> =
        jsonHandler<TaxRate>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `TaxRate` object with the given `id`. */
    override fun retrieve(params: TaxRateRetrieveParams, requestOptions: RequestOptions): TaxRate {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "tax-rates", params.getPathParam(0))
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

    private val listHandler: Handler<TaxRateListPage.Response> =
        jsonHandler<TaxRateListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `TaxRate` objects. */
    override fun list(params: TaxRateListParams, requestOptions: RequestOptions): TaxRateListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "tax-rates")
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
                .let { TaxRateListPage.of(this, params, it) }
        }
    }
}

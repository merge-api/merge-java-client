package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.VendorCredit
import dev.merge.api.models.accounting.VendorCreditListPage
import dev.merge.api.models.accounting.VendorCreditListParams
import dev.merge.api.models.accounting.VendorCreditRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class VendorCreditServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : VendorCreditService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<VendorCredit> =
        jsonHandler<VendorCredit>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `VendorCredit` object with the given `id`. */
    override fun retrieve(
        params: VendorCreditRetrieveParams,
        requestOptions: RequestOptions
    ): VendorCredit {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "vendor-credits", params.getPathParam(0))
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

    private val listHandler: Handler<VendorCreditListPage.Response> =
        jsonHandler<VendorCreditListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `VendorCredit` objects. */
    override fun list(
        params: VendorCreditListParams,
        requestOptions: RequestOptions
    ): VendorCreditListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "vendor-credits")
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
                .let { VendorCreditListPage.of(this, params, it) }
        }
    }
}

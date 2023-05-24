package dev.merge.api.services.blocking.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.BankInfo
import dev.merge.api.models.hris.BankListPage
import dev.merge.api.models.hris.BankListParams
import dev.merge.api.models.hris.BankRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class BankServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : BankService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<BankInfo> =
        jsonHandler<BankInfo>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `BankInfo` object with the given `id`. */
    override fun retrieve(params: BankRetrieveParams, requestOptions: RequestOptions): BankInfo {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "bank-info", params.getPathParam(0))
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

    private val listHandler: Handler<BankListPage.Response> =
        jsonHandler<BankListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of `BankInfo` objects. */
    override fun list(params: BankListParams, requestOptions: RequestOptions): BankListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "bank-info")
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
                .let { BankListPage.of(this, params, it) }
        }
    }
}

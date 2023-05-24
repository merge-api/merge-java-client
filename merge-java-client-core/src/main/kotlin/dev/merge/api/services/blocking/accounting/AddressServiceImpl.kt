package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.Address
import dev.merge.api.models.accounting.AddressRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class AddressServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AddressService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Address> =
        jsonHandler<Address>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Address` object with the given `id`. */
    override fun retrieve(params: AddressRetrieveParams, requestOptions: RequestOptions): Address {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "addresses", params.getPathParam(0))
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
}

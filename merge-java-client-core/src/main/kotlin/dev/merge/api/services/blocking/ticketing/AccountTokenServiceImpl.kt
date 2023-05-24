package dev.merge.api.services.blocking.ticketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.AccountToken
import dev.merge.api.models.ticketing.AccountTokenRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class AccountTokenServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AccountTokenService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<AccountToken> =
        jsonHandler<AccountToken>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns the account token for the end user with the provided public token. */
    override fun retrieve(
        params: AccountTokenRetrieveParams,
        requestOptions: RequestOptions
    ): AccountToken {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "account-token", params.getPathParam(0))
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

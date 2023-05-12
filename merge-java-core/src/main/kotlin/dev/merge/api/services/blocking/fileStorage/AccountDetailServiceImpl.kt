package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.AccountDetail
import dev.merge.api.models.fileStorage.AccountDetailRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class AccountDetailServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AccountDetailService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<AccountDetail> =
        jsonHandler<AccountDetail>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get details for a linked account. */
    override fun retrieve(
        params: AccountDetailRetrieveParams,
        requestOptions: RequestOptions
    ): AccountDetail {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "account-details")
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

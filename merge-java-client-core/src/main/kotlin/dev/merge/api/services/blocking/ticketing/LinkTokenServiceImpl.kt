package dev.merge.api.services.blocking.ticketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.LinkToken
import dev.merge.api.models.ticketing.LinkTokenCreateParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class LinkTokenServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : LinkTokenService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<LinkToken> =
        jsonHandler<LinkToken>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a link token to be used when linking a new end user. */
    override fun create(params: LinkTokenCreateParams, requestOptions: RequestOptions): LinkToken {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ticketing", "v1", "link-token")
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
}

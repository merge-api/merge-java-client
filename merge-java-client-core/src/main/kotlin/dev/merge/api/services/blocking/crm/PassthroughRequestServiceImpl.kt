package dev.merge.api.services.blocking.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.RemoteResponse
import dev.merge.api.models.crm.PassthroughRequestSendParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class PassthroughRequestServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : PassthroughRequestService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val sendHandler: Handler<RemoteResponse> =
        jsonHandler<RemoteResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Pull data from an endpoint not currently supported by Merge. */
    override fun send(
        params: PassthroughRequestSendParams,
        requestOptions: RequestOptions
    ): RemoteResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("crm", "v1", "passthrough")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { sendHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}

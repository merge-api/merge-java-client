package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.RemoteKey
import dev.merge.api.models.accounting.RemoteKeyGenerateParams
import dev.merge.api.models.accounting.RemoteKeyRegenerateParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class RemoteKeyServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : RemoteKeyService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val generateHandler: Handler<RemoteKey> =
        jsonHandler<RemoteKey>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a remote key. */
    override fun generate(
        params: RemoteKeyGenerateParams,
        requestOptions: RequestOptions
    ): RemoteKey {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "generate-key")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { generateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val regenerateHandler: Handler<RemoteKey> =
        jsonHandler<RemoteKey>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Exchange remote keys. */
    override fun regenerate(
        params: RemoteKeyRegenerateParams,
        requestOptions: RequestOptions
    ): RemoteKey {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "regenerate-key")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { regenerateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}

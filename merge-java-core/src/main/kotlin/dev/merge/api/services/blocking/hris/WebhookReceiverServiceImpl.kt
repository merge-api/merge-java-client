package dev.merge.api.services.blocking.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.WebhookReceiver
import dev.merge.api.models.hris.WebhookReceiverCreateParams
import dev.merge.api.models.hris.WebhookReceiverListParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class WebhookReceiverServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : WebhookReceiverService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<WebhookReceiver> =
        jsonHandler<WebhookReceiver>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `WebhookReceiver` object with the given values. */
    override fun create(
        params: WebhookReceiverCreateParams,
        requestOptions: RequestOptions
    ): WebhookReceiver {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("hris", "v1", "webhook-receivers")
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

    private val listHandler: Handler<List<WebhookReceiver>> =
        jsonHandler<List<WebhookReceiver>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of `WebhookReceiver` objects. */
    override fun list(
        params: WebhookReceiverListParams,
        requestOptions: RequestOptions
    ): List<WebhookReceiver> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "webhook-receivers")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        forEach { it.validate() }
                    }
                }
        }
    }
}

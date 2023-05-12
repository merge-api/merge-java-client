package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.WebhookReceiver
import dev.merge.api.models.ats.WebhookReceiverCreateParams
import dev.merge.api.models.ats.WebhookReceiverListParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class WebhookReceiverServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : WebhookReceiverServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<WebhookReceiver> =
        jsonHandler<WebhookReceiver>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `WebhookReceiver` object with the given values. */
    override fun create(
        params: WebhookReceiverCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<WebhookReceiver> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "webhook-receivers")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
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
    ): CompletableFuture<List<WebhookReceiver>> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "webhook-receivers")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
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

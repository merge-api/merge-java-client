package dev.merge.api.services.async.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.PayGroup
import dev.merge.api.models.hris.PayGroupListPageAsync
import dev.merge.api.models.hris.PayGroupListParams
import dev.merge.api.models.hris.PayGroupRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class PayGroupServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : PayGroupServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<PayGroup> =
        jsonHandler<PayGroup>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `PayGroup` object with the given `id`. */
    override fun retrieve(
        params: PayGroupRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PayGroup> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "pay-groups", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<PayGroupListPageAsync.Response> =
        jsonHandler<PayGroupListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `PayGroup` objects. */
    override fun list(
        params: PayGroupListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<PayGroupListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "pay-groups")
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
                        validate()
                    }
                }
                .let { PayGroupListPageAsync.of(this, params, it) }
        }
    }
}

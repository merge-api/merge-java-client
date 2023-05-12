package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.RejectReason
import dev.merge.api.models.ats.RejectReasonListPageAsync
import dev.merge.api.models.ats.RejectReasonListParams
import dev.merge.api.models.ats.RejectReasonRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class RejectReasonServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : RejectReasonServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<RejectReason> =
        jsonHandler<RejectReason>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `RejectReason` object with the given `id`. */
    override fun retrieve(
        params: RejectReasonRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<RejectReason> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "reject-reasons", params.getPathParam(0))
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

    private val listHandler: Handler<RejectReasonListPageAsync.Response> =
        jsonHandler<RejectReasonListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RejectReason` objects. */
    override fun list(
        params: RejectReasonListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<RejectReasonListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "reject-reasons")
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
                .let { RejectReasonListPageAsync.of(this, params, it) }
        }
    }
}

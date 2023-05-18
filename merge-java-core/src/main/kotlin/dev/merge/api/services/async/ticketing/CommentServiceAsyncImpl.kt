package dev.merge.api.services.async.ticketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ticketing.Comment
import dev.merge.api.models.ticketing.CommentCreateParams
import dev.merge.api.models.ticketing.CommentListPageAsync
import dev.merge.api.models.ticketing.CommentListParams
import dev.merge.api.models.ticketing.CommentResponse
import dev.merge.api.models.ticketing.CommentRetrieveParams
import dev.merge.api.services.async.ticketing.comments.MetaServiceAsync
import dev.merge.api.services.async.ticketing.comments.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class CommentServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CommentServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<CommentResponse> =
        jsonHandler<CommentResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Comment` object with the given values. */
    override fun create(
        params: CommentCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CommentResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ticketing", "v1", "comments")
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

    private val retrieveHandler: Handler<Comment> =
        jsonHandler<Comment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Comment` object with the given `id`. */
    override fun retrieve(
        params: CommentRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Comment> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "comments", params.getPathParam(0))
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

    private val listHandler: Handler<CommentListPageAsync.Response> =
        jsonHandler<CommentListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Comment` objects. */
    override fun list(
        params: CommentListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CommentListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "comments")
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
                .let { CommentListPageAsync.of(this, params, it) }
        }
    }
}

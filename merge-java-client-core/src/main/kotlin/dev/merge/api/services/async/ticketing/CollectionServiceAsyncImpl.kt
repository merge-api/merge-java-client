package dev.merge.api.services.async.ticketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ticketing.Collection
import dev.merge.api.models.ticketing.CollectionListPageAsync
import dev.merge.api.models.ticketing.CollectionListParams
import dev.merge.api.models.ticketing.CollectionListUsersPageAsync
import dev.merge.api.models.ticketing.CollectionListUsersParams
import dev.merge.api.models.ticketing.CollectionRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class CollectionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CollectionServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Collection> =
        jsonHandler<Collection>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Collection` object with the given `id`. */
    override fun retrieve(
        params: CollectionRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Collection> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "collections", params.getPathParam(0))
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

    private val listHandler: Handler<CollectionListPageAsync.Response> =
        jsonHandler<CollectionListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Collection` objects. */
    override fun list(
        params: CollectionListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CollectionListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "collections")
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
                .let { CollectionListPageAsync.of(this, params, it) }
        }
    }

    private val listUsersHandler: Handler<CollectionListUsersPageAsync.Response> =
        jsonHandler<CollectionListUsersPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `User` objects. */
    override fun listUsers(
        params: CollectionListUsersParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CollectionListUsersPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "collections", params.getPathParam(0), "users")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listUsersHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { CollectionListUsersPageAsync.of(this, params, it) }
        }
    }
}

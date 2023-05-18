package dev.merge.api.services.blocking.ticketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ticketing.Collection
import dev.merge.api.models.ticketing.CollectionListPage
import dev.merge.api.models.ticketing.CollectionListParams
import dev.merge.api.models.ticketing.CollectionListUsersPage
import dev.merge.api.models.ticketing.CollectionListUsersParams
import dev.merge.api.models.ticketing.CollectionRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class CollectionServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : CollectionService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Collection> =
        jsonHandler<Collection>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Collection` object with the given `id`. */
    override fun retrieve(
        params: CollectionRetrieveParams,
        requestOptions: RequestOptions
    ): Collection {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "collections", params.getPathParam(0))
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

    private val listHandler: Handler<CollectionListPage.Response> =
        jsonHandler<CollectionListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Collection` objects. */
    override fun list(
        params: CollectionListParams,
        requestOptions: RequestOptions
    ): CollectionListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "collections")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { CollectionListPage.of(this, params, it) }
        }
    }

    private val listUsersHandler: Handler<CollectionListUsersPage.Response> =
        jsonHandler<CollectionListUsersPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `User` objects. */
    override fun listUsers(
        params: CollectionListUsersParams,
        requestOptions: RequestOptions
    ): CollectionListUsersPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "collections", params.getPathParam(0), "users")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listUsersHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { CollectionListUsersPage.of(this, params, it) }
        }
    }
}

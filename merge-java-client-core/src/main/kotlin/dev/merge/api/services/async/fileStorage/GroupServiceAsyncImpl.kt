package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.fileStorage.Group
import dev.merge.api.models.fileStorage.GroupListPageAsync
import dev.merge.api.models.fileStorage.GroupListParams
import dev.merge.api.models.fileStorage.GroupRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class GroupServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : GroupServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Group> =
        jsonHandler<Group>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Group` object with the given `id`. */
    override fun retrieve(
        params: GroupRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Group> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "groups", params.getPathParam(0))
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

    private val listHandler: Handler<GroupListPageAsync.Response> =
        jsonHandler<GroupListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Group` objects. */
    override fun list(
        params: GroupListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<GroupListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("filestorage", "v1", "groups")
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
                .let { GroupListPageAsync.of(this, params, it) }
        }
    }
}

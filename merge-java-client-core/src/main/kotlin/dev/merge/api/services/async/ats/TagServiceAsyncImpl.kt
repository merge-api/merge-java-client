package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.TagListPageAsync
import dev.merge.api.models.ats.TagListParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class TagServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TagServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<TagListPageAsync.Response> =
        jsonHandler<TagListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Tag` objects. */
    override fun list(
        params: TagListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TagListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "tags")
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
                .let { TagListPageAsync.of(this, params, it) }
        }
    }
}

package dev.merge.api.services.async.crm.tasks

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.TaskMetaForCreateParams
import dev.merge.api.models.crm.TaskMetaForUpdateParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class MetaServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : MetaServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val forCreateHandler: Handler<MetaResponse> =
        jsonHandler<MetaResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns metadata for `Task` POSTs. */
    override fun forCreate(
        params: TaskMetaForCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<MetaResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "tasks", "meta", "post")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { forCreateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val forUpdateHandler: Handler<MetaResponse> =
        jsonHandler<MetaResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns metadata for `Task` PATCHs. */
    override fun forUpdate(
        params: TaskMetaForUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<MetaResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "tasks", "meta", "patch", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { forUpdateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}

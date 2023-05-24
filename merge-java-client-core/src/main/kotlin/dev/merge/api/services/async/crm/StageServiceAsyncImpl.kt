package dev.merge.api.services.async.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.Stage
import dev.merge.api.models.crm.StageListPageAsync
import dev.merge.api.models.crm.StageListParams
import dev.merge.api.models.crm.StageListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.StageListRemoteFieldClassesParams
import dev.merge.api.models.crm.StageRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class StageServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : StageServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Stage> =
        jsonHandler<Stage>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Stage` object with the given `id`. */
    override fun retrieve(
        params: StageRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Stage> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "stages", params.getPathParam(0))
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

    private val listHandler: Handler<StageListPageAsync.Response> =
        jsonHandler<StageListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Stage` objects. */
    override fun list(
        params: StageListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<StageListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "stages")
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
                .let { StageListPageAsync.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler:
        Handler<StageListRemoteFieldClassesPageAsync.Response> =
        jsonHandler<StageListRemoteFieldClassesPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: StageListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): CompletableFuture<StageListRemoteFieldClassesPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "stages", "remote-field-classes")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listRemoteFieldClassesHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { StageListRemoteFieldClassesPageAsync.of(this, params, it) }
        }
    }
}

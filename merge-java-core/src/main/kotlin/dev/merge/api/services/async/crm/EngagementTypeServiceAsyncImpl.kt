package dev.merge.api.services.async.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.EngagementType
import dev.merge.api.models.crm.EngagementTypeListPageAsync
import dev.merge.api.models.crm.EngagementTypeListParams
import dev.merge.api.models.crm.EngagementTypeListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.EngagementTypeListRemoteFieldClassesParams
import dev.merge.api.models.crm.EngagementTypeRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class EngagementTypeServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : EngagementTypeServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<EngagementType> =
        jsonHandler<EngagementType>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `EngagementType` object with the given `id`. */
    override fun retrieve(
        params: EngagementTypeRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EngagementType> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "engagement-types", params.getPathParam(0))
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

    private val listHandler: Handler<EngagementTypeListPageAsync.Response> =
        jsonHandler<EngagementTypeListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `EngagementType` objects. */
    override fun list(
        params: EngagementTypeListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EngagementTypeListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "engagement-types")
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
                .let { EngagementTypeListPageAsync.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler:
        Handler<EngagementTypeListRemoteFieldClassesPageAsync.Response> =
        jsonHandler<EngagementTypeListRemoteFieldClassesPageAsync.Response>(
                clientOptions.jsonMapper
            )
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: EngagementTypeListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EngagementTypeListRemoteFieldClassesPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "engagement-types", "remote-field-classes")
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
                .let { EngagementTypeListRemoteFieldClassesPageAsync.of(this, params, it) }
        }
    }
}

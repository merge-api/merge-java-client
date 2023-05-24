package dev.merge.api.services.async.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.Engagement
import dev.merge.api.models.crm.EngagementCreateParams
import dev.merge.api.models.crm.EngagementListPageAsync
import dev.merge.api.models.crm.EngagementListParams
import dev.merge.api.models.crm.EngagementListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.EngagementListRemoteFieldClassesParams
import dev.merge.api.models.crm.EngagementResponse
import dev.merge.api.models.crm.EngagementRetrieveParams
import dev.merge.api.models.crm.EngagementUpdateParams
import dev.merge.api.services.async.crm.engagements.MetaServiceAsync
import dev.merge.api.services.async.crm.engagements.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class EngagementServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : EngagementServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<EngagementResponse> =
        jsonHandler<EngagementResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Engagement` object with the given values. */
    override fun create(
        params: EngagementCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EngagementResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("crm", "v1", "engagements")
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

    private val retrieveHandler: Handler<Engagement> =
        jsonHandler<Engagement>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Engagement` object with the given `id`. */
    override fun retrieve(
        params: EngagementRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Engagement> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "engagements", params.getPathParam(0))
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

    private val updateHandler: Handler<EngagementResponse> =
        jsonHandler<EngagementResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates an `Engagement` object with the given `id`. */
    override fun update(
        params: EngagementUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EngagementResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("crm", "v1", "engagements", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<EngagementListPageAsync.Response> =
        jsonHandler<EngagementListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Engagement` objects. */
    override fun list(
        params: EngagementListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EngagementListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "engagements")
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
                .let { EngagementListPageAsync.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler:
        Handler<EngagementListRemoteFieldClassesPageAsync.Response> =
        jsonHandler<EngagementListRemoteFieldClassesPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: EngagementListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EngagementListRemoteFieldClassesPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "engagements", "remote-field-classes")
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
                .let { EngagementListRemoteFieldClassesPageAsync.of(this, params, it) }
        }
    }
}

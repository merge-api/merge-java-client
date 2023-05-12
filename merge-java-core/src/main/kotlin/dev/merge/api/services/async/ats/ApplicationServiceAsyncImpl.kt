package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Application
import dev.merge.api.models.ats.ApplicationChangeStageParams
import dev.merge.api.models.ats.ApplicationCreateParams
import dev.merge.api.models.ats.ApplicationListPageAsync
import dev.merge.api.models.ats.ApplicationListParams
import dev.merge.api.models.ats.ApplicationResponse
import dev.merge.api.models.ats.ApplicationRetrieveParams
import dev.merge.api.services.async.ats.applications.MetaServiceAsync
import dev.merge.api.services.async.ats.applications.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class ApplicationServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ApplicationServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<ApplicationResponse> =
        jsonHandler<ApplicationResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Application` object with the given values. */
    override fun create(
        params: ApplicationCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ApplicationResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "applications")
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

    private val retrieveHandler: Handler<Application> =
        jsonHandler<Application>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Application` object with the given `id`. */
    override fun retrieve(
        params: ApplicationRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Application> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "applications", params.getPathParam(0))
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

    private val listHandler: Handler<ApplicationListPageAsync.Response> =
        jsonHandler<ApplicationListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Application` objects. */
    override fun list(
        params: ApplicationListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ApplicationListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "applications")
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
                .let { ApplicationListPageAsync.of(this, params, it) }
        }
    }

    private val changeStageHandler: Handler<ApplicationResponse> =
        jsonHandler<ApplicationResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates the `current_stage` field of an `Application` object */
    override fun changeStage(
        params: ApplicationChangeStageParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ApplicationResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "ats",
                    "v1",
                    "applications",
                    params.getPathParam(0),
                    "change-stage"
                )
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { changeStageHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}

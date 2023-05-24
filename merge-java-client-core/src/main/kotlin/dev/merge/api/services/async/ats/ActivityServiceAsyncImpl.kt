package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Activity
import dev.merge.api.models.ats.ActivityCreateParams
import dev.merge.api.models.ats.ActivityCreateResponse
import dev.merge.api.models.ats.ActivityListPageAsync
import dev.merge.api.models.ats.ActivityListParams
import dev.merge.api.models.ats.ActivityRetrieveParams
import dev.merge.api.services.async.ats.activities.MetaServiceAsync
import dev.merge.api.services.async.ats.activities.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class ActivityServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ActivityServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<ActivityCreateResponse> =
        jsonHandler<ActivityCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Activity` object with the given values. */
    override fun create(
        params: ActivityCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ActivityCreateResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "activities")
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

    private val retrieveHandler: Handler<Activity> =
        jsonHandler<Activity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Activity` object with the given `id`. */
    override fun retrieve(
        params: ActivityRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Activity> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "activities", params.getPathParam(0))
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

    private val listHandler: Handler<ActivityListPageAsync.Response> =
        jsonHandler<ActivityListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Activity` objects. */
    override fun list(
        params: ActivityListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ActivityListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "activities")
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
                .let { ActivityListPageAsync.of(this, params, it) }
        }
    }
}

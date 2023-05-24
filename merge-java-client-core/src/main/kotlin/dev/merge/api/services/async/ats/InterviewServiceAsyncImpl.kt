package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.InterviewCreateParams
import dev.merge.api.models.ats.InterviewListPageAsync
import dev.merge.api.models.ats.InterviewListParams
import dev.merge.api.models.ats.InterviewRetrieveParams
import dev.merge.api.models.ats.ScheduledInterview
import dev.merge.api.models.ats.ScheduledInterviewResponse
import dev.merge.api.services.async.ats.interviews.MetaServiceAsync
import dev.merge.api.services.async.ats.interviews.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class InterviewServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : InterviewServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<ScheduledInterviewResponse> =
        jsonHandler<ScheduledInterviewResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates a `ScheduledInterview` object with the given values. */
    override fun create(
        params: InterviewCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ScheduledInterviewResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "interviews")
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

    private val retrieveHandler: Handler<ScheduledInterview> =
        jsonHandler<ScheduledInterview>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `ScheduledInterview` object with the given `id`. */
    override fun retrieve(
        params: InterviewRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ScheduledInterview> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "interviews", params.getPathParam(0))
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

    private val listHandler: Handler<InterviewListPageAsync.Response> =
        jsonHandler<InterviewListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `ScheduledInterview` objects. */
    override fun list(
        params: InterviewListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<InterviewListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "interviews")
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
                .let { InterviewListPageAsync.of(this, params, it) }
        }
    }
}

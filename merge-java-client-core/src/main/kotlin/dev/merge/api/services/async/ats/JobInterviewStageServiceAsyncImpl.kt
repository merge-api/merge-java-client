package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.JobInterviewStage
import dev.merge.api.models.ats.JobInterviewStageListPageAsync
import dev.merge.api.models.ats.JobInterviewStageListParams
import dev.merge.api.models.ats.JobInterviewStageRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class JobInterviewStageServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : JobInterviewStageServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<JobInterviewStage> =
        jsonHandler<JobInterviewStage>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `JobInterviewStage` object with the given `id`. */
    override fun retrieve(
        params: JobInterviewStageRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<JobInterviewStage> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "job-interview-stages", params.getPathParam(0))
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

    private val listHandler: Handler<JobInterviewStageListPageAsync.Response> =
        jsonHandler<JobInterviewStageListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `JobInterviewStage` objects. */
    override fun list(
        params: JobInterviewStageListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<JobInterviewStageListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "job-interview-stages")
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
                .let { JobInterviewStageListPageAsync.of(this, params, it) }
        }
    }
}

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.InterviewCreateParams
import dev.merge.api.models.ats.InterviewListPage
import dev.merge.api.models.ats.InterviewListParams
import dev.merge.api.models.ats.InterviewRetrieveParams
import dev.merge.api.models.ats.ScheduledInterview
import dev.merge.api.models.ats.ScheduledInterviewResponse
import dev.merge.api.services.blocking.ats.interviews.MetaService
import dev.merge.api.services.blocking.ats.interviews.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class InterviewServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : InterviewService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<ScheduledInterviewResponse> =
        jsonHandler<ScheduledInterviewResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates a `ScheduledInterview` object with the given values. */
    override fun create(
        params: InterviewCreateParams,
        requestOptions: RequestOptions
    ): ScheduledInterviewResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "interviews")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
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
    ): ScheduledInterview {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "interviews", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<InterviewListPage.Response> =
        jsonHandler<InterviewListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `ScheduledInterview` objects. */
    override fun list(
        params: InterviewListParams,
        requestOptions: RequestOptions
    ): InterviewListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "interviews")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { InterviewListPage.of(this, params, it) }
        }
    }
}

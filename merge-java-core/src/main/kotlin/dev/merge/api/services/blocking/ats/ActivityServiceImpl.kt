package dev.merge.api.services.blocking.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Activity
import dev.merge.api.models.ats.ActivityCreateParams
import dev.merge.api.models.ats.ActivityCreateResponse
import dev.merge.api.models.ats.ActivityListPage
import dev.merge.api.models.ats.ActivityListParams
import dev.merge.api.models.ats.ActivityRetrieveParams
import dev.merge.api.services.blocking.ats.activities.MetaService
import dev.merge.api.services.blocking.ats.activities.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class ActivityServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ActivityService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<ActivityCreateResponse> =
        jsonHandler<ActivityCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Activity` object with the given values. */
    override fun create(
        params: ActivityCreateParams,
        requestOptions: RequestOptions
    ): ActivityCreateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "activities")
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

    private val retrieveHandler: Handler<Activity> =
        jsonHandler<Activity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Activity` object with the given `id`. */
    override fun retrieve(
        params: ActivityRetrieveParams,
        requestOptions: RequestOptions
    ): Activity {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "activities", params.getPathParam(0))
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

    private val listHandler: Handler<ActivityListPage.Response> =
        jsonHandler<ActivityListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Activity` objects. */
    override fun list(
        params: ActivityListParams,
        requestOptions: RequestOptions
    ): ActivityListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "activities")
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
                .let { ActivityListPage.of(this, params, it) }
        }
    }
}

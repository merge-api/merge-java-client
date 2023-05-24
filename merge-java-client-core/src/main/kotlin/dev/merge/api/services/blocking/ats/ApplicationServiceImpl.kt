package dev.merge.api.services.blocking.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Application
import dev.merge.api.models.ats.ApplicationChangeStageParams
import dev.merge.api.models.ats.ApplicationCreateParams
import dev.merge.api.models.ats.ApplicationListPage
import dev.merge.api.models.ats.ApplicationListParams
import dev.merge.api.models.ats.ApplicationResponse
import dev.merge.api.models.ats.ApplicationRetrieveParams
import dev.merge.api.services.blocking.ats.applications.MetaService
import dev.merge.api.services.blocking.ats.applications.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class ApplicationServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ApplicationService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<ApplicationResponse> =
        jsonHandler<ApplicationResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Application` object with the given values. */
    override fun create(
        params: ApplicationCreateParams,
        requestOptions: RequestOptions
    ): ApplicationResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "applications")
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

    private val retrieveHandler: Handler<Application> =
        jsonHandler<Application>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Application` object with the given `id`. */
    override fun retrieve(
        params: ApplicationRetrieveParams,
        requestOptions: RequestOptions
    ): Application {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "applications", params.getPathParam(0))
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

    private val listHandler: Handler<ApplicationListPage.Response> =
        jsonHandler<ApplicationListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Application` objects. */
    override fun list(
        params: ApplicationListParams,
        requestOptions: RequestOptions
    ): ApplicationListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "applications")
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
                .let { ApplicationListPage.of(this, params, it) }
        }
    }

    private val changeStageHandler: Handler<ApplicationResponse> =
        jsonHandler<ApplicationResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates the `current_stage` field of an `Application` object */
    override fun changeStage(
        params: ApplicationChangeStageParams,
        requestOptions: RequestOptions
    ): ApplicationResponse {
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
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
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

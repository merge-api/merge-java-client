package dev.merge.api.services.blocking.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.TimeOff
import dev.merge.api.models.hris.TimeOffCreateParams
import dev.merge.api.models.hris.TimeOffListPage
import dev.merge.api.models.hris.TimeOffListParams
import dev.merge.api.models.hris.TimeOffResponse
import dev.merge.api.models.hris.TimeOffRetrieveParams
import dev.merge.api.services.blocking.hris.timeOff.MetaService
import dev.merge.api.services.blocking.hris.timeOff.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class TimeOffServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : TimeOffService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<TimeOffResponse> =
        jsonHandler<TimeOffResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `TimeOff` object with the given values. */
    override fun create(
        params: TimeOffCreateParams,
        requestOptions: RequestOptions
    ): TimeOffResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("hris", "v1", "time-off")
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

    private val retrieveHandler: Handler<TimeOff> =
        jsonHandler<TimeOff>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `TimeOff` object with the given `id`. */
    override fun retrieve(params: TimeOffRetrieveParams, requestOptions: RequestOptions): TimeOff {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "time-off", params.getPathParam(0))
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

    private val listHandler: Handler<TimeOffListPage.Response> =
        jsonHandler<TimeOffListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `TimeOff` objects. */
    override fun list(params: TimeOffListParams, requestOptions: RequestOptions): TimeOffListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "time-off")
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
                .let { TimeOffListPage.of(this, params, it) }
        }
    }
}

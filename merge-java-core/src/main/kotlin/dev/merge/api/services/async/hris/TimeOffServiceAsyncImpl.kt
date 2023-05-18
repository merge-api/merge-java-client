package dev.merge.api.services.async.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.TimeOff
import dev.merge.api.models.hris.TimeOffCreateParams
import dev.merge.api.models.hris.TimeOffListPageAsync
import dev.merge.api.models.hris.TimeOffListParams
import dev.merge.api.models.hris.TimeOffResponse
import dev.merge.api.models.hris.TimeOffRetrieveParams
import dev.merge.api.services.async.hris.timeOff.MetaServiceAsync
import dev.merge.api.services.async.hris.timeOff.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class TimeOffServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TimeOffServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<TimeOffResponse> =
        jsonHandler<TimeOffResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `TimeOff` object with the given values. */
    override fun create(
        params: TimeOffCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TimeOffResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("hris", "v1", "time-off")
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

    private val retrieveHandler: Handler<TimeOff> =
        jsonHandler<TimeOff>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `TimeOff` object with the given `id`. */
    override fun retrieve(
        params: TimeOffRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TimeOff> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "time-off", params.getPathParam(0))
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

    private val listHandler: Handler<TimeOffListPageAsync.Response> =
        jsonHandler<TimeOffListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `TimeOff` objects. */
    override fun list(
        params: TimeOffListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TimeOffListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "time-off")
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
                .let { TimeOffListPageAsync.of(this, params, it) }
        }
    }
}

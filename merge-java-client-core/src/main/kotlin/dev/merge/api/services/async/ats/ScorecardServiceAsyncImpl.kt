package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Scorecard
import dev.merge.api.models.ats.ScorecardListPageAsync
import dev.merge.api.models.ats.ScorecardListParams
import dev.merge.api.models.ats.ScorecardRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class ScorecardServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ScorecardServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Scorecard> =
        jsonHandler<Scorecard>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Scorecard` object with the given `id`. */
    override fun retrieve(
        params: ScorecardRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Scorecard> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "scorecards", params.getPathParam(0))
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

    private val listHandler: Handler<ScorecardListPageAsync.Response> =
        jsonHandler<ScorecardListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Scorecard` objects. */
    override fun list(
        params: ScorecardListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ScorecardListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "scorecards")
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
                .let { ScorecardListPageAsync.of(this, params, it) }
        }
    }
}

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Scorecard
import dev.merge.api.models.ats.ScorecardListPage
import dev.merge.api.models.ats.ScorecardListParams
import dev.merge.api.models.ats.ScorecardRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class ScorecardServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ScorecardService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Scorecard> =
        jsonHandler<Scorecard>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Scorecard` object with the given `id`. */
    override fun retrieve(
        params: ScorecardRetrieveParams,
        requestOptions: RequestOptions
    ): Scorecard {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "scorecards", params.getPathParam(0))
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

    private val listHandler: Handler<ScorecardListPage.Response> =
        jsonHandler<ScorecardListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Scorecard` objects. */
    override fun list(
        params: ScorecardListParams,
        requestOptions: RequestOptions
    ): ScorecardListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "scorecards")
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
                .let { ScorecardListPage.of(this, params, it) }
        }
    }
}

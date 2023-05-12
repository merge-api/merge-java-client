package dev.merge.api.services.blocking.ticketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.Team
import dev.merge.api.models.ticketing.TeamListPage
import dev.merge.api.models.ticketing.TeamListParams
import dev.merge.api.models.ticketing.TeamRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class TeamServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : TeamService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Team> =
        jsonHandler<Team>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Team` object with the given `id`. */
    override fun retrieve(params: TeamRetrieveParams, requestOptions: RequestOptions): Team {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "teams", params.getPathParam(0))
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

    private val listHandler: Handler<TeamListPage.Response> =
        jsonHandler<TeamListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of `Team` objects. */
    override fun list(params: TeamListParams, requestOptions: RequestOptions): TeamListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "teams")
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
                .let { TeamListPage.of(this, params, it) }
        }
    }
}

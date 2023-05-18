package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.Issue
import dev.merge.api.models.marketing.IssueListPage
import dev.merge.api.models.marketing.IssueListParams
import dev.merge.api.models.marketing.IssueRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class IssueServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : IssueService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Issue> =
        jsonHandler<Issue>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get a specific issue. */
    override fun retrieve(params: IssueRetrieveParams, requestOptions: RequestOptions): Issue {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "issues", params.getPathParam(0))
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

    private val listHandler: Handler<IssueListPage.Response> =
        jsonHandler<IssueListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Gets issues. */
    override fun list(params: IssueListParams, requestOptions: RequestOptions): IssueListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "issues")
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
                .let { IssueListPage.of(this, params, it) }
        }
    }
}

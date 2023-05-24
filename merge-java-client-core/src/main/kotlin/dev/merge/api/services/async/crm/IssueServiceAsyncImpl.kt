package dev.merge.api.services.async.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.Issue
import dev.merge.api.models.crm.IssueListPageAsync
import dev.merge.api.models.crm.IssueListParams
import dev.merge.api.models.crm.IssueRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class IssueServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : IssueServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Issue> =
        jsonHandler<Issue>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get a specific issue. */
    override fun retrieve(
        params: IssueRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Issue> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "issues", params.getPathParam(0))
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

    private val listHandler: Handler<IssueListPageAsync.Response> =
        jsonHandler<IssueListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Gets issues. */
    override fun list(
        params: IssueListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<IssueListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "issues")
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
                .let { IssueListPageAsync.of(this, params, it) }
        }
    }
}

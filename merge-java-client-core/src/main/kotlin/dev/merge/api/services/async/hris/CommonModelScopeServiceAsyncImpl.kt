package dev.merge.api.services.async.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.CommonModelScope
import dev.merge.api.models.hris.CommonModelScopeRetrieveParams
import dev.merge.api.models.hris.CommonModelScopeUpdateParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class CommonModelScopeServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CommonModelScopeServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<CommonModelScope> =
        jsonHandler<CommonModelScope>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Fetch the configuration of what data is saved by Merge when syncing. Common model scopes are
     * set as a default across all linked accounts, but can be updated to have greater granularity
     * per account.
     */
    override fun retrieve(
        params: CommonModelScopeRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CommonModelScope> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "common-model-scopes")
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

    private val updateHandler: Handler<CommonModelScope> =
        jsonHandler<CommonModelScope>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Update the configuration of what data is saved by Merge when syncing. Common model scopes are
     * set as a default across all linked accounts, but can be updated to have greater granularity
     * per account.
     */
    override fun update(
        params: CommonModelScopeUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CommonModelScope> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("hris", "v1", "common-model-scopes")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}

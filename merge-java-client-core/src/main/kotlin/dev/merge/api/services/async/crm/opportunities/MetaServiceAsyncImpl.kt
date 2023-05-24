package dev.merge.api.services.async.crm.opportunities

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.OpportunityMetaForCreateParams
import dev.merge.api.models.crm.OpportunityMetaForUpdateParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class MetaServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : MetaServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val forCreateHandler: Handler<MetaResponse> =
        jsonHandler<MetaResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns metadata for `Opportunity` POSTs. */
    override fun forCreate(
        params: OpportunityMetaForCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<MetaResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "opportunities", "meta", "post")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { forCreateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val forUpdateHandler: Handler<MetaResponse> =
        jsonHandler<MetaResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns metadata for `Opportunity` PATCHs. */
    override fun forUpdate(
        params: OpportunityMetaForUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<MetaResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "crm",
                    "v1",
                    "opportunities",
                    "meta",
                    "patch",
                    params.getPathParam(0)
                )
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { forUpdateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}

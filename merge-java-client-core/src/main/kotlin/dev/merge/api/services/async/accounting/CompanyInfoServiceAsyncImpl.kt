package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.CompanyInfo
import dev.merge.api.models.accounting.CompanyInfoListPageAsync
import dev.merge.api.models.accounting.CompanyInfoListParams
import dev.merge.api.models.accounting.CompanyInfoRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class CompanyInfoServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CompanyInfoServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<CompanyInfo> =
        jsonHandler<CompanyInfo>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `CompanyInfo` object with the given `id`. */
    override fun retrieve(
        params: CompanyInfoRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CompanyInfo> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "company-info", params.getPathParam(0))
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

    private val listHandler: Handler<CompanyInfoListPageAsync.Response> =
        jsonHandler<CompanyInfoListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `CompanyInfo` objects. */
    override fun list(
        params: CompanyInfoListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CompanyInfoListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "company-info")
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
                .let { CompanyInfoListPageAsync.of(this, params, it) }
        }
    }
}

package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Office
import dev.merge.api.models.ats.OfficeListPageAsync
import dev.merge.api.models.ats.OfficeListParams
import dev.merge.api.models.ats.OfficeRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class OfficeServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : OfficeServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Office> =
        jsonHandler<Office>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Office` object with the given `id`. */
    override fun retrieve(
        params: OfficeRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Office> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "offices", params.getPathParam(0))
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

    private val listHandler: Handler<OfficeListPageAsync.Response> =
        jsonHandler<OfficeListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Office` objects. */
    override fun list(
        params: OfficeListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<OfficeListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "offices")
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
                .let { OfficeListPageAsync.of(this, params, it) }
        }
    }
}

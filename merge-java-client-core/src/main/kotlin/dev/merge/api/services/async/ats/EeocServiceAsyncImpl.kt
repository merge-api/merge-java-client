package dev.merge.api.services.async.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Eeoc
import dev.merge.api.models.ats.EeocListPageAsync
import dev.merge.api.models.ats.EeocListParams
import dev.merge.api.models.ats.EeocRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class EeocServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : EeocServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Eeoc> =
        jsonHandler<Eeoc>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `EEOC` object with the given `id`. */
    override fun retrieve(
        params: EeocRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Eeoc> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "eeocs", params.getPathParam(0))
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

    private val listHandler: Handler<EeocListPageAsync.Response> =
        jsonHandler<EeocListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `EEOC` objects. */
    override fun list(
        params: EeocListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EeocListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "eeocs")
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
                .let { EeocListPageAsync.of(this, params, it) }
        }
    }
}

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.TrackingCategory
import dev.merge.api.models.accounting.TrackingCategoryListPage
import dev.merge.api.models.accounting.TrackingCategoryListParams
import dev.merge.api.models.accounting.TrackingCategoryRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class TrackingCategoryServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : TrackingCategoryService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<TrackingCategory> =
        jsonHandler<TrackingCategory>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `TrackingCategory` object with the given `id`. */
    override fun retrieve(
        params: TrackingCategoryRetrieveParams,
        requestOptions: RequestOptions
    ): TrackingCategory {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "tracking-categories", params.getPathParam(0))
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

    private val listHandler: Handler<TrackingCategoryListPage.Response> =
        jsonHandler<TrackingCategoryListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `TrackingCategory` objects. */
    override fun list(
        params: TrackingCategoryListParams,
        requestOptions: RequestOptions
    ): TrackingCategoryListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "tracking-categories")
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
                .let { TrackingCategoryListPage.of(this, params, it) }
        }
    }
}

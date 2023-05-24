package dev.merge.api.services.blocking.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Department
import dev.merge.api.models.ats.DepartmentListPage
import dev.merge.api.models.ats.DepartmentListParams
import dev.merge.api.models.ats.DepartmentRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class DepartmentServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : DepartmentService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Department> =
        jsonHandler<Department>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Department` object with the given `id`. */
    override fun retrieve(
        params: DepartmentRetrieveParams,
        requestOptions: RequestOptions
    ): Department {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "departments", params.getPathParam(0))
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

    private val listHandler: Handler<DepartmentListPage.Response> =
        jsonHandler<DepartmentListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Department` objects. */
    override fun list(
        params: DepartmentListParams,
        requestOptions: RequestOptions
    ): DepartmentListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "departments")
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
                .let { DepartmentListPage.of(this, params, it) }
        }
    }
}

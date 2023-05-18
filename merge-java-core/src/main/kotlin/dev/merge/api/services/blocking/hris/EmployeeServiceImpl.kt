package dev.merge.api.services.blocking.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.CreatedEmployeeResponse
import dev.merge.api.models.hris.Employee
import dev.merge.api.models.hris.EmployeeCreateParams
import dev.merge.api.models.hris.EmployeeIgnoreParams
import dev.merge.api.models.hris.EmployeeListPage
import dev.merge.api.models.hris.EmployeeListParams
import dev.merge.api.models.hris.EmployeeRetrieveParams
import dev.merge.api.services.blocking.hris.employees.MetaService
import dev.merge.api.services.blocking.hris.employees.MetaServiceImpl
import dev.merge.api.services.emptyHandler
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class EmployeeServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : EmployeeService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<CreatedEmployeeResponse> =
        jsonHandler<CreatedEmployeeResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates an `Employee` object with the given values. */
    override fun create(
        params: EmployeeCreateParams,
        requestOptions: RequestOptions
    ): CreatedEmployeeResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("hris", "v1", "employees")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<Employee> =
        jsonHandler<Employee>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Employee` object with the given `id`. */
    override fun retrieve(
        params: EmployeeRetrieveParams,
        requestOptions: RequestOptions
    ): Employee {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "employees", params.getPathParam(0))
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

    private val listHandler: Handler<EmployeeListPage.Response> =
        jsonHandler<EmployeeListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Employee` objects. */
    override fun list(
        params: EmployeeListParams,
        requestOptions: RequestOptions
    ): EmployeeListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "employees")
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
                .let { EmployeeListPage.of(this, params, it) }
        }
    }

    private val ignoreHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /**
     * Ignores a specific row based on the `model_id` in the url. These records will have their
     * properties set to null, and will not be updated in future syncs. The "reason" and "message"
     * fields in the request body will be stored for audit purposes.
     */
    override fun ignore(params: EmployeeIgnoreParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("hris", "v1", "employees", "ignore", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response.let { ignoreHandler.handle(it) }
        }
    }
}

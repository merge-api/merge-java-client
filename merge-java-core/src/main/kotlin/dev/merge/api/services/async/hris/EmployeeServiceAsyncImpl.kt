package dev.merge.api.services.async.hris

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
import dev.merge.api.models.hris.EmployeeListPageAsync
import dev.merge.api.models.hris.EmployeeListParams
import dev.merge.api.models.hris.EmployeeRetrieveParams
import dev.merge.api.services.async.hris.employees.MetaServiceAsync
import dev.merge.api.services.async.hris.employees.MetaServiceAsyncImpl
import dev.merge.api.services.emptyHandler
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class EmployeeServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : EmployeeServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<CreatedEmployeeResponse> =
        jsonHandler<CreatedEmployeeResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates an `Employee` object with the given values. */
    override fun create(
        params: EmployeeCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CreatedEmployeeResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("hris", "v1", "employees")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
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
    ): CompletableFuture<Employee> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "employees", params.getPathParam(0))
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

    private val listHandler: Handler<EmployeeListPageAsync.Response> =
        jsonHandler<EmployeeListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Employee` objects. */
    override fun list(
        params: EmployeeListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EmployeeListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "employees")
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
                .let { EmployeeListPageAsync.of(this, params, it) }
        }
    }

    private val ignoreHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /**
     * Ignores a specific row based on the `model_id` in the url. These records will have their
     * properties set to null, and will not be updated in future syncs. The "reason" and "message"
     * fields in the request body will be stored for audit purposes.
     */
    override fun ignore(
        params: EmployeeIgnoreParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Void> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("hris", "v1", "employees", "ignore", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response.let { ignoreHandler.handle(it) }
        }
    }
}

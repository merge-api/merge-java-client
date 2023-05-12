package dev.merge.api.services.async.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.EmployeePayrollRun
import dev.merge.api.models.hris.EmployeePayrollRunListPageAsync
import dev.merge.api.models.hris.EmployeePayrollRunListParams
import dev.merge.api.models.hris.EmployeePayrollRunRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class EmployeePayrollRunServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : EmployeePayrollRunServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<EmployeePayrollRun> =
        jsonHandler<EmployeePayrollRun>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `EmployeePayrollRun` object with the given `id`. */
    override fun retrieve(
        params: EmployeePayrollRunRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EmployeePayrollRun> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "employee-payroll-runs", params.getPathParam(0))
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

    private val listHandler: Handler<EmployeePayrollRunListPageAsync.Response> =
        jsonHandler<EmployeePayrollRunListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `EmployeePayrollRun` objects. */
    override fun list(
        params: EmployeePayrollRunListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EmployeePayrollRunListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "employee-payroll-runs")
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
                .let { EmployeePayrollRunListPageAsync.of(this, params, it) }
        }
    }
}

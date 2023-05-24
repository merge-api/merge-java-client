package dev.merge.api.services.blocking.hris

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.hris.PayrollRun
import dev.merge.api.models.hris.PayrollRunListPage
import dev.merge.api.models.hris.PayrollRunListParams
import dev.merge.api.models.hris.PayrollRunRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class PayrollRunServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : PayrollRunService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<PayrollRun> =
        jsonHandler<PayrollRun>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `PayrollRun` object with the given `id`. */
    override fun retrieve(
        params: PayrollRunRetrieveParams,
        requestOptions: RequestOptions
    ): PayrollRun {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "payroll-runs", params.getPathParam(0))
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

    private val listHandler: Handler<PayrollRunListPage.Response> =
        jsonHandler<PayrollRunListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `PayrollRun` objects. */
    override fun list(
        params: PayrollRunListParams,
        requestOptions: RequestOptions
    ): PayrollRunListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("hris", "v1", "payroll-runs")
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
                .let { PayrollRunListPage.of(this, params, it) }
        }
    }
}

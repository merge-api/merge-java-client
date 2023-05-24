package dev.merge.api.services.blocking.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.Lead
import dev.merge.api.models.crm.LeadCreateParams
import dev.merge.api.models.crm.LeadListPage
import dev.merge.api.models.crm.LeadListParams
import dev.merge.api.models.crm.LeadListRemoteFieldClassesPage
import dev.merge.api.models.crm.LeadListRemoteFieldClassesParams
import dev.merge.api.models.crm.LeadResponse
import dev.merge.api.models.crm.LeadRetrieveParams
import dev.merge.api.services.blocking.crm.leads.MetaService
import dev.merge.api.services.blocking.crm.leads.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class LeadServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : LeadService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<LeadResponse> =
        jsonHandler<LeadResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Lead` object with the given values. */
    override fun create(params: LeadCreateParams, requestOptions: RequestOptions): LeadResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("crm", "v1", "leads")
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

    private val retrieveHandler: Handler<Lead> =
        jsonHandler<Lead>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Lead` object with the given `id`. */
    override fun retrieve(params: LeadRetrieveParams, requestOptions: RequestOptions): Lead {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "leads", params.getPathParam(0))
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

    private val listHandler: Handler<LeadListPage.Response> =
        jsonHandler<LeadListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of `Lead` objects. */
    override fun list(params: LeadListParams, requestOptions: RequestOptions): LeadListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "leads")
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
                .let { LeadListPage.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler: Handler<LeadListRemoteFieldClassesPage.Response> =
        jsonHandler<LeadListRemoteFieldClassesPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: LeadListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): LeadListRemoteFieldClassesPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "leads", "remote-field-classes")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listRemoteFieldClassesHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { LeadListRemoteFieldClassesPage.of(this, params, it) }
        }
    }
}

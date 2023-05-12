package dev.merge.api.services.blocking.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.Opportunity
import dev.merge.api.models.crm.OpportunityCreateParams
import dev.merge.api.models.crm.OpportunityListPage
import dev.merge.api.models.crm.OpportunityListParams
import dev.merge.api.models.crm.OpportunityListRemoteFieldClassesPage
import dev.merge.api.models.crm.OpportunityListRemoteFieldClassesParams
import dev.merge.api.models.crm.OpportunityResponse
import dev.merge.api.models.crm.OpportunityRetrieveParams
import dev.merge.api.models.crm.OpportunityUpdateParams
import dev.merge.api.services.blocking.crm.opportunities.MetaService
import dev.merge.api.services.blocking.crm.opportunities.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class OpportunityServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : OpportunityService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<OpportunityResponse> =
        jsonHandler<OpportunityResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Opportunity` object with the given values. */
    override fun create(
        params: OpportunityCreateParams,
        requestOptions: RequestOptions
    ): OpportunityResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("crm", "v1", "opportunities")
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

    private val retrieveHandler: Handler<Opportunity> =
        jsonHandler<Opportunity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Opportunity` object with the given `id`. */
    override fun retrieve(
        params: OpportunityRetrieveParams,
        requestOptions: RequestOptions
    ): Opportunity {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "opportunities", params.getPathParam(0))
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

    private val updateHandler: Handler<OpportunityResponse> =
        jsonHandler<OpportunityResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates an `Opportunity` object with the given `id`. */
    override fun update(
        params: OpportunityUpdateParams,
        requestOptions: RequestOptions
    ): OpportunityResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("crm", "v1", "opportunities", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<OpportunityListPage.Response> =
        jsonHandler<OpportunityListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Opportunity` objects. */
    override fun list(
        params: OpportunityListParams,
        requestOptions: RequestOptions
    ): OpportunityListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "opportunities")
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
                .let { OpportunityListPage.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler:
        Handler<OpportunityListRemoteFieldClassesPage.Response> =
        jsonHandler<OpportunityListRemoteFieldClassesPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: OpportunityListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): OpportunityListRemoteFieldClassesPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "opportunities", "remote-field-classes")
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
                .let { OpportunityListRemoteFieldClassesPage.of(this, params, it) }
        }
    }
}

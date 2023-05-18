package dev.merge.api.services.blocking.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.EngagementType
import dev.merge.api.models.crm.EngagementTypeListPage
import dev.merge.api.models.crm.EngagementTypeListParams
import dev.merge.api.models.crm.EngagementTypeListRemoteFieldClassesPage
import dev.merge.api.models.crm.EngagementTypeListRemoteFieldClassesParams
import dev.merge.api.models.crm.EngagementTypeRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class EngagementTypeServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : EngagementTypeService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<EngagementType> =
        jsonHandler<EngagementType>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `EngagementType` object with the given `id`. */
    override fun retrieve(
        params: EngagementTypeRetrieveParams,
        requestOptions: RequestOptions
    ): EngagementType {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "engagement-types", params.getPathParam(0))
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

    private val listHandler: Handler<EngagementTypeListPage.Response> =
        jsonHandler<EngagementTypeListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `EngagementType` objects. */
    override fun list(
        params: EngagementTypeListParams,
        requestOptions: RequestOptions
    ): EngagementTypeListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "engagement-types")
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
                .let { EngagementTypeListPage.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler:
        Handler<EngagementTypeListRemoteFieldClassesPage.Response> =
        jsonHandler<EngagementTypeListRemoteFieldClassesPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: EngagementTypeListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): EngagementTypeListRemoteFieldClassesPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "engagement-types", "remote-field-classes")
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
                .let { EngagementTypeListRemoteFieldClassesPage.of(this, params, it) }
        }
    }
}

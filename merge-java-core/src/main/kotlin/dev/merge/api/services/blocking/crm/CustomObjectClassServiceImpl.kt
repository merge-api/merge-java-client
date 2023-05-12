package dev.merge.api.services.blocking.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.CustomObjectClass
import dev.merge.api.models.crm.CustomObjectClassListPage
import dev.merge.api.models.crm.CustomObjectClassListParams
import dev.merge.api.models.crm.CustomObjectClassRetrieveParams
import dev.merge.api.services.blocking.crm.customObjectClasses.AssociationTypeService
import dev.merge.api.services.blocking.crm.customObjectClasses.AssociationTypeServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class CustomObjectClassServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : CustomObjectClassService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val associationTypes: AssociationTypeService by lazy {
        AssociationTypeServiceImpl(clientOptions)
    }

    override fun associationTypes(): AssociationTypeService = associationTypes

    private val retrieveHandler: Handler<CustomObjectClass> =
        jsonHandler<CustomObjectClass>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `CustomObjectClass` object with the given `id`. */
    override fun retrieve(
        params: CustomObjectClassRetrieveParams,
        requestOptions: RequestOptions
    ): CustomObjectClass {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "custom-object-classes", params.getPathParam(0))
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

    private val listHandler: Handler<CustomObjectClassListPage.Response> =
        jsonHandler<CustomObjectClassListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `CustomObjectClass` objects. */
    override fun list(
        params: CustomObjectClassListParams,
        requestOptions: RequestOptions
    ): CustomObjectClassListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "custom-object-classes")
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
                .let { CustomObjectClassListPage.of(this, params, it) }
        }
    }
}

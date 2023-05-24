package dev.merge.api.services.blocking.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.CustomObject
import dev.merge.api.models.crm.CustomObjectCreateParams
import dev.merge.api.models.crm.CustomObjectListPage
import dev.merge.api.models.crm.CustomObjectListParams
import dev.merge.api.models.crm.CustomObjectResponse
import dev.merge.api.models.crm.CustomObjectRetrieveParams
import dev.merge.api.models.crm.CustomObjectUpdateParams
import dev.merge.api.services.blocking.crm.customObjects.GeneratorService
import dev.merge.api.services.blocking.crm.customObjects.GeneratorServiceImpl
import dev.merge.api.services.blocking.crm.customObjects.MetaService
import dev.merge.api.services.blocking.crm.customObjects.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class CustomObjectServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : CustomObjectService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    private val generators: GeneratorService by lazy { GeneratorServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    override fun generators(): GeneratorService = generators

    private val createHandler: Handler<CustomObjectResponse> =
        jsonHandler<CustomObjectResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `CustomObject` object with the given values. */
    override fun create(
        params: CustomObjectCreateParams,
        requestOptions: RequestOptions
    ): CustomObjectResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "crm",
                    "v1",
                    "custom-object-classes",
                    params.getPathParam(0),
                    "custom-objects"
                )
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

    private val retrieveHandler: Handler<CustomObject> =
        jsonHandler<CustomObject>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `CustomObject` object with the given `id`. */
    override fun retrieve(
        params: CustomObjectRetrieveParams,
        requestOptions: RequestOptions
    ): CustomObject {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "crm",
                    "v1",
                    "custom-object-classes",
                    params.getPathParam(0),
                    "custom-objects",
                    params.getPathParam(1)
                )
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

    private val updateHandler: Handler<CustomObjectResponse> =
        jsonHandler<CustomObjectResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates a `CustomObject` object with the given `id`. */
    override fun update(
        params: CustomObjectUpdateParams,
        requestOptions: RequestOptions
    ): CustomObjectResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments(
                    "crm",
                    "v1",
                    "custom-object-classes",
                    params.getPathParam(0),
                    "custom-objects",
                    params.getPathParam(1)
                )
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

    private val listHandler: Handler<CustomObjectListPage.Response> =
        jsonHandler<CustomObjectListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `CustomObject` objects. */
    override fun list(
        params: CustomObjectListParams,
        requestOptions: RequestOptions
    ): CustomObjectListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "crm",
                    "v1",
                    "custom-object-classes",
                    params.getPathParam(0),
                    "custom-objects"
                )
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
                .let { CustomObjectListPage.of(this, params, it) }
        }
    }
}

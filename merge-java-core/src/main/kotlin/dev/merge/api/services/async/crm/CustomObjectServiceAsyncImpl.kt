package dev.merge.api.services.async.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.CustomObject
import dev.merge.api.models.crm.CustomObjectCreateParams
import dev.merge.api.models.crm.CustomObjectListPageAsync
import dev.merge.api.models.crm.CustomObjectListParams
import dev.merge.api.models.crm.CustomObjectResponse
import dev.merge.api.models.crm.CustomObjectRetrieveParams
import dev.merge.api.models.crm.CustomObjectUpdateParams
import dev.merge.api.services.async.crm.customObjects.GeneratorServiceAsync
import dev.merge.api.services.async.crm.customObjects.GeneratorServiceAsyncImpl
import dev.merge.api.services.async.crm.customObjects.MetaServiceAsync
import dev.merge.api.services.async.crm.customObjects.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class CustomObjectServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CustomObjectServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    private val generators: GeneratorServiceAsync by lazy {
        GeneratorServiceAsyncImpl(clientOptions)
    }

    override fun meta(): MetaServiceAsync = meta

    override fun generators(): GeneratorServiceAsync = generators

    private val createHandler: Handler<CustomObjectResponse> =
        jsonHandler<CustomObjectResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `CustomObject` object with the given values. */
    override fun create(
        params: CustomObjectCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CustomObjectResponse> {
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

    private val retrieveHandler: Handler<CustomObject> =
        jsonHandler<CustomObject>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `CustomObject` object with the given `id`. */
    override fun retrieve(
        params: CustomObjectRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CustomObject> {
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

    private val updateHandler: Handler<CustomObjectResponse> =
        jsonHandler<CustomObjectResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates a `CustomObject` object with the given `id`. */
    override fun update(
        params: CustomObjectUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CustomObjectResponse> {
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
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<CustomObjectListPageAsync.Response> =
        jsonHandler<CustomObjectListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `CustomObject` objects. */
    override fun list(
        params: CustomObjectListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CustomObjectListPageAsync> {
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
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { CustomObjectListPageAsync.of(this, params, it) }
        }
    }
}

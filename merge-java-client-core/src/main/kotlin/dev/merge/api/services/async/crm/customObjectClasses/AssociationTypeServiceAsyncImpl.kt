package dev.merge.api.services.async.crm.customObjectClasses

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.AssociationType
import dev.merge.api.models.crm.AssociationTypeResponse
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeCreateParams
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeListPageAsync
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeListParams
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeRetrieveParams
import dev.merge.api.services.async.crm.customObjectClasses.associationTypes.MetaServiceAsync
import dev.merge.api.services.async.crm.customObjectClasses.associationTypes.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class AssociationTypeServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AssociationTypeServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<AssociationTypeResponse> =
        jsonHandler<AssociationTypeResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates an `AssociationType` object with the given values. */
    override fun create(
        params: CustomObjectClassAssociationTypeCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AssociationTypeResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "crm",
                    "v1",
                    "custom-object-classes",
                    params.getPathParam(0),
                    "association-types"
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

    private val retrieveHandler: Handler<AssociationType> =
        jsonHandler<AssociationType>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `AssociationType` object with the given `id`. */
    override fun retrieve(
        params: CustomObjectClassAssociationTypeRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AssociationType> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "crm",
                    "v1",
                    "custom-object-classes",
                    params.getPathParam(0),
                    "association-types",
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

    private val listHandler: Handler<CustomObjectClassAssociationTypeListPageAsync.Response> =
        jsonHandler<CustomObjectClassAssociationTypeListPageAsync.Response>(
                clientOptions.jsonMapper
            )
            .withErrorHandler(errorHandler)

    /** Returns a list of `AssociationType` objects. */
    override fun list(
        params: CustomObjectClassAssociationTypeListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CustomObjectClassAssociationTypeListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "crm",
                    "v1",
                    "custom-object-classes",
                    params.getPathParam(0),
                    "association-types"
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
                .let { CustomObjectClassAssociationTypeListPageAsync.of(this, params, it) }
        }
    }
}

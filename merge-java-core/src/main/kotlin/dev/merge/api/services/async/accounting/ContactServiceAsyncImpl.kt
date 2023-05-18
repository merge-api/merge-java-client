package dev.merge.api.services.async.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.Contact
import dev.merge.api.models.accounting.ContactCreateParams
import dev.merge.api.models.accounting.ContactListPageAsync
import dev.merge.api.models.accounting.ContactListParams
import dev.merge.api.models.accounting.ContactResponse
import dev.merge.api.models.accounting.ContactRetrieveParams
import dev.merge.api.services.async.accounting.contacts.MetaServiceAsync
import dev.merge.api.services.async.accounting.contacts.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class ContactServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ContactServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<ContactResponse> =
        jsonHandler<ContactResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Contact` object with the given values. */
    override fun create(
        params: ContactCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ContactResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "contacts")
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

    private val retrieveHandler: Handler<Contact> =
        jsonHandler<Contact>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Contact` object with the given `id`. */
    override fun retrieve(
        params: ContactRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Contact> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "contacts", params.getPathParam(0))
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

    private val listHandler: Handler<ContactListPageAsync.Response> =
        jsonHandler<ContactListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Contact` objects. */
    override fun list(
        params: ContactListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ContactListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "contacts")
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
                .let { ContactListPageAsync.of(this, params, it) }
        }
    }
}

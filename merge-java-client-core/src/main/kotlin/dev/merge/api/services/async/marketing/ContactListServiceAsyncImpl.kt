package dev.merge.api.services.async.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.marketing.ContactList
import dev.merge.api.models.marketing.ContactListCreateParams
import dev.merge.api.models.marketing.ContactListCreateResponse
import dev.merge.api.models.marketing.ContactListListPageAsync
import dev.merge.api.models.marketing.ContactListListParams
import dev.merge.api.models.marketing.ContactListListSubscribersPageAsync
import dev.merge.api.models.marketing.ContactListListSubscribersParams
import dev.merge.api.models.marketing.ContactListRetrieveParams
import dev.merge.api.services.async.marketing.contactLists.MetaServiceAsync
import dev.merge.api.services.async.marketing.contactLists.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class ContactListServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ContactListServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<ContactListCreateResponse> =
        jsonHandler<ContactListCreateResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates a `List` object with the given values. */
    override fun create(
        params: ContactListCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ContactListCreateResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("mktg", "v1", "lists")
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

    private val retrieveHandler: Handler<ContactList> =
        jsonHandler<ContactList>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `List` object with the given `id`. */
    override fun retrieve(
        params: ContactListRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ContactList> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "lists", params.getPathParam(0))
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

    private val listHandler: Handler<ContactListListPageAsync.Response> =
        jsonHandler<ContactListListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `List` objects. */
    override fun list(
        params: ContactListListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ContactListListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "lists")
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
                .let { ContactListListPageAsync.of(this, params, it) }
        }
    }

    private val listSubscribersHandler: Handler<ContactListListSubscribersPageAsync.Response> =
        jsonHandler<ContactListListSubscribersPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Contact` objects. */
    override fun listSubscribers(
        params: ContactListListSubscribersParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ContactListListSubscribersPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "lists", params.getPathParam(0), "subscribers")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listSubscribersHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { ContactListListSubscribersPageAsync.of(this, params, it) }
        }
    }
}

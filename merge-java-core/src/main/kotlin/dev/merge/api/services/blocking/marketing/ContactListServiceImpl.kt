package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.marketing.ContactList
import dev.merge.api.models.marketing.ContactListCreateParams
import dev.merge.api.models.marketing.ContactListCreateResponse
import dev.merge.api.models.marketing.ContactListListPage
import dev.merge.api.models.marketing.ContactListListParams
import dev.merge.api.models.marketing.ContactListListSubscribersPage
import dev.merge.api.models.marketing.ContactListListSubscribersParams
import dev.merge.api.models.marketing.ContactListRetrieveParams
import dev.merge.api.services.blocking.marketing.contactLists.MetaService
import dev.merge.api.services.blocking.marketing.contactLists.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class ContactListServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ContactListService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<ContactListCreateResponse> =
        jsonHandler<ContactListCreateResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates a `List` object with the given values. */
    override fun create(
        params: ContactListCreateParams,
        requestOptions: RequestOptions
    ): ContactListCreateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("mktg", "v1", "lists")
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

    private val retrieveHandler: Handler<ContactList> =
        jsonHandler<ContactList>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `List` object with the given `id`. */
    override fun retrieve(
        params: ContactListRetrieveParams,
        requestOptions: RequestOptions
    ): ContactList {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "lists", params.getPathParam(0))
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

    private val listHandler: Handler<ContactListListPage.Response> =
        jsonHandler<ContactListListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `List` objects. */
    override fun list(
        params: ContactListListParams,
        requestOptions: RequestOptions
    ): ContactListListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "lists")
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
                .let { ContactListListPage.of(this, params, it) }
        }
    }

    private val listSubscribersHandler: Handler<ContactListListSubscribersPage.Response> =
        jsonHandler<ContactListListSubscribersPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Contact` objects. */
    override fun listSubscribers(
        params: ContactListListSubscribersParams,
        requestOptions: RequestOptions
    ): ContactListListSubscribersPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "lists", params.getPathParam(0), "subscribers")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listSubscribersHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { ContactListListSubscribersPage.of(this, params, it) }
        }
    }
}

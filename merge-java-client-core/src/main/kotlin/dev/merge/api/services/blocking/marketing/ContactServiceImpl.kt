package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.Contact
import dev.merge.api.models.marketing.ContactCreateParams
import dev.merge.api.models.marketing.ContactListPage
import dev.merge.api.models.marketing.ContactListParams
import dev.merge.api.models.marketing.ContactResponse
import dev.merge.api.models.marketing.ContactRetrieveParams
import dev.merge.api.services.blocking.marketing.contacts.MetaService
import dev.merge.api.services.blocking.marketing.contacts.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class ContactServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ContactService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<ContactResponse> =
        jsonHandler<ContactResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Contact` object with the given values. */
    override fun create(
        params: ContactCreateParams,
        requestOptions: RequestOptions
    ): ContactResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("mktg", "v1", "contacts")
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

    private val retrieveHandler: Handler<Contact> =
        jsonHandler<Contact>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Contact` object with the given `id`. */
    override fun retrieve(params: ContactRetrieveParams, requestOptions: RequestOptions): Contact {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "contacts", params.getPathParam(0))
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

    private val listHandler: Handler<ContactListPage.Response> =
        jsonHandler<ContactListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Contact` objects. */
    override fun list(params: ContactListParams, requestOptions: RequestOptions): ContactListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "contacts")
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
                .let { ContactListPage.of(this, params, it) }
        }
    }
}

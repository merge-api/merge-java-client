package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.marketing.Automation
import dev.merge.api.models.marketing.AutomationCreateParams
import dev.merge.api.models.marketing.AutomationListPage
import dev.merge.api.models.marketing.AutomationListParams
import dev.merge.api.models.marketing.AutomationListRecipientsPage
import dev.merge.api.models.marketing.AutomationListRecipientsParams
import dev.merge.api.models.marketing.AutomationResponse
import dev.merge.api.models.marketing.AutomationRetrieveParams
import dev.merge.api.services.blocking.marketing.automations.MetaService
import dev.merge.api.services.blocking.marketing.automations.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class AutomationServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AutomationService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<AutomationResponse> =
        jsonHandler<AutomationResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Automation` object with the given values. */
    override fun create(
        params: AutomationCreateParams,
        requestOptions: RequestOptions
    ): AutomationResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("mktg", "v1", "automations")
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

    private val retrieveHandler: Handler<Automation> =
        jsonHandler<Automation>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Automation` object with the given `id`. */
    override fun retrieve(
        params: AutomationRetrieveParams,
        requestOptions: RequestOptions
    ): Automation {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "automations", params.getPathParam(0))
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

    private val listHandler: Handler<AutomationListPage.Response> =
        jsonHandler<AutomationListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Automation` objects. */
    override fun list(
        params: AutomationListParams,
        requestOptions: RequestOptions
    ): AutomationListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "automations")
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
                .let { AutomationListPage.of(this, params, it) }
        }
    }

    private val listRecipientsHandler: Handler<AutomationListRecipientsPage.Response> =
        jsonHandler<AutomationListRecipientsPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Contact` objects. */
    override fun listRecipients(
        params: AutomationListRecipientsParams,
        requestOptions: RequestOptions
    ): AutomationListRecipientsPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "automations", params.getPathParam(0), "recipients")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listRecipientsHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { AutomationListRecipientsPage.of(this, params, it) }
        }
    }
}

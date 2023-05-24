package dev.merge.api.services.async.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.marketing.Campaign
import dev.merge.api.models.marketing.CampaignCreateParams
import dev.merge.api.models.marketing.CampaignListContactsPageAsync
import dev.merge.api.models.marketing.CampaignListContactsParams
import dev.merge.api.models.marketing.CampaignListPageAsync
import dev.merge.api.models.marketing.CampaignListParams
import dev.merge.api.models.marketing.CampaignResponse
import dev.merge.api.models.marketing.CampaignRetrieveParams
import dev.merge.api.services.async.marketing.campaigns.MetaServiceAsync
import dev.merge.api.services.async.marketing.campaigns.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class CampaignServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CampaignServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<CampaignResponse> =
        jsonHandler<CampaignResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Campaign` object with the given values. */
    override fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CampaignResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("mktg", "v1", "campaigns")
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

    private val retrieveHandler: Handler<Campaign> =
        jsonHandler<Campaign>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Campaign` object with the given `id`. */
    override fun retrieve(
        params: CampaignRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Campaign> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "campaigns", params.getPathParam(0))
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

    private val listHandler: Handler<CampaignListPageAsync.Response> =
        jsonHandler<CampaignListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Campaign` objects. */
    override fun list(
        params: CampaignListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CampaignListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "campaigns")
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
                .let { CampaignListPageAsync.of(this, params, it) }
        }
    }

    private val listContactsHandler: Handler<CampaignListContactsPageAsync.Response> =
        jsonHandler<CampaignListContactsPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Contact` objects. */
    override fun listContacts(
        params: CampaignListContactsParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CampaignListContactsPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "campaigns", params.getPathParam(0), "contacts")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listContactsHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { CampaignListContactsPageAsync.of(this, params, it) }
        }
    }
}

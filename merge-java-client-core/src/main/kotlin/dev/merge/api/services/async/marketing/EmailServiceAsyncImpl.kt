package dev.merge.api.services.async.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.marketing.Email
import dev.merge.api.models.marketing.EmailListPageAsync
import dev.merge.api.models.marketing.EmailListParams
import dev.merge.api.models.marketing.EmailListRecipientsPageAsync
import dev.merge.api.models.marketing.EmailListRecipientsParams
import dev.merge.api.models.marketing.EmailRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class EmailServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : EmailServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Email> =
        jsonHandler<Email>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `MarketingEmail` object with the given `id`. */
    override fun retrieve(
        params: EmailRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Email> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "emails", params.getPathParam(0))
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

    private val listHandler: Handler<EmailListPageAsync.Response> =
        jsonHandler<EmailListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `MarketingEmail` objects. */
    override fun list(
        params: EmailListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EmailListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "emails")
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
                .let { EmailListPageAsync.of(this, params, it) }
        }
    }

    private val listRecipientsHandler: Handler<EmailListRecipientsPageAsync.Response> =
        jsonHandler<EmailListRecipientsPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Contact` objects. */
    override fun listRecipients(
        params: EmailListRecipientsParams,
        requestOptions: RequestOptions
    ): CompletableFuture<EmailListRecipientsPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "emails", params.getPathParam(0), "recipients")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listRecipientsHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { EmailListRecipientsPageAsync.of(this, params, it) }
        }
    }
}

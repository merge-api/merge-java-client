package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.marketing.Email
import dev.merge.api.models.marketing.EmailListPage
import dev.merge.api.models.marketing.EmailListParams
import dev.merge.api.models.marketing.EmailListRecipientsPage
import dev.merge.api.models.marketing.EmailListRecipientsParams
import dev.merge.api.models.marketing.EmailRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class EmailServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : EmailService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Email> =
        jsonHandler<Email>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `MarketingEmail` object with the given `id`. */
    override fun retrieve(params: EmailRetrieveParams, requestOptions: RequestOptions): Email {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "emails", params.getPathParam(0))
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

    private val listHandler: Handler<EmailListPage.Response> =
        jsonHandler<EmailListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of `MarketingEmail` objects. */
    override fun list(params: EmailListParams, requestOptions: RequestOptions): EmailListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "emails")
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
                .let { EmailListPage.of(this, params, it) }
        }
    }

    private val listRecipientsHandler: Handler<EmailListRecipientsPage.Response> =
        jsonHandler<EmailListRecipientsPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Contact` objects. */
    override fun listRecipients(
        params: EmailListRecipientsParams,
        requestOptions: RequestOptions
    ): EmailListRecipientsPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "emails", params.getPathParam(0), "recipients")
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
                .let { EmailListRecipientsPage.of(this, params, it) }
        }
    }
}

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.accounting.AccountingAttachment
import dev.merge.api.models.accounting.AccountingAttachmentResponse
import dev.merge.api.models.accounting.AttachmentCreateParams
import dev.merge.api.models.accounting.AttachmentListPage
import dev.merge.api.models.accounting.AttachmentListParams
import dev.merge.api.models.accounting.AttachmentRetrieveParams
import dev.merge.api.services.blocking.accounting.attachments.MetaService
import dev.merge.api.services.blocking.accounting.attachments.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class AttachmentServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AttachmentService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<AccountingAttachmentResponse> =
        jsonHandler<AccountingAttachmentResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates an `AccountingAttachment` object with the given values. */
    override fun create(
        params: AttachmentCreateParams,
        requestOptions: RequestOptions
    ): AccountingAttachmentResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("accounting", "v1", "attachments")
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

    private val retrieveHandler: Handler<AccountingAttachment> =
        jsonHandler<AccountingAttachment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `AccountingAttachment` object with the given `id`. */
    override fun retrieve(
        params: AttachmentRetrieveParams,
        requestOptions: RequestOptions
    ): AccountingAttachment {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "attachments", params.getPathParam(0))
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

    private val listHandler: Handler<AttachmentListPage.Response> =
        jsonHandler<AttachmentListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `AccountingAttachment` objects. */
    override fun list(
        params: AttachmentListParams,
        requestOptions: RequestOptions
    ): AttachmentListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("accounting", "v1", "attachments")
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
                .let { AttachmentListPage.of(this, params, it) }
        }
    }
}

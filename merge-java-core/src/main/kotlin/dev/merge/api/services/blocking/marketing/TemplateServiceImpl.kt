package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.marketing.Template
import dev.merge.api.models.marketing.TemplateCreateParams
import dev.merge.api.models.marketing.TemplateListPage
import dev.merge.api.models.marketing.TemplateListParams
import dev.merge.api.models.marketing.TemplateResponse
import dev.merge.api.models.marketing.TemplateRetrieveParams
import dev.merge.api.services.blocking.marketing.templates.MetaService
import dev.merge.api.services.blocking.marketing.templates.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class TemplateServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : TemplateService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<TemplateResponse> =
        jsonHandler<TemplateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Template` object with the given values. */
    override fun create(
        params: TemplateCreateParams,
        requestOptions: RequestOptions
    ): TemplateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("mktg", "v1", "templates")
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

    private val retrieveHandler: Handler<Template> =
        jsonHandler<Template>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Template` object with the given `id`. */
    override fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions
    ): Template {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "templates", params.getPathParam(0))
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

    private val listHandler: Handler<TemplateListPage.Response> =
        jsonHandler<TemplateListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Template` objects. */
    override fun list(
        params: TemplateListParams,
        requestOptions: RequestOptions
    ): TemplateListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "templates")
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
                .let { TemplateListPage.of(this, params, it) }
        }
    }
}

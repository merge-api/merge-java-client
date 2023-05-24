package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.marketing.Action
import dev.merge.api.models.marketing.ActionCreateParams
import dev.merge.api.models.marketing.ActionListPage
import dev.merge.api.models.marketing.ActionListParams
import dev.merge.api.models.marketing.ActionResponse
import dev.merge.api.models.marketing.ActionRetrieveParams
import dev.merge.api.services.blocking.marketing.actions.MetaService
import dev.merge.api.services.blocking.marketing.actions.MetaServiceImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class ActionServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ActionService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<ActionResponse> =
        jsonHandler<ActionResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Action` object with the given values. */
    override fun create(
        params: ActionCreateParams,
        requestOptions: RequestOptions
    ): ActionResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("mktg", "v1", "actions")
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

    private val retrieveHandler: Handler<Action> =
        jsonHandler<Action>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Action` object with the given `id`. */
    override fun retrieve(params: ActionRetrieveParams, requestOptions: RequestOptions): Action {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "actions", params.getPathParam(0))
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

    private val listHandler: Handler<ActionListPage.Response> =
        jsonHandler<ActionListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Action` objects. */
    override fun list(params: ActionListParams, requestOptions: RequestOptions): ActionListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("mktg", "v1", "actions")
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
                .let { ActionListPage.of(this, params, it) }
        }
    }
}

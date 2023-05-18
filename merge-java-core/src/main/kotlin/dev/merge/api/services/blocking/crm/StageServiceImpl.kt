package dev.merge.api.services.blocking.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.Stage
import dev.merge.api.models.crm.StageListPage
import dev.merge.api.models.crm.StageListParams
import dev.merge.api.models.crm.StageListRemoteFieldClassesPage
import dev.merge.api.models.crm.StageListRemoteFieldClassesParams
import dev.merge.api.models.crm.StageRetrieveParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class StageServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : StageService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Stage> =
        jsonHandler<Stage>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Stage` object with the given `id`. */
    override fun retrieve(params: StageRetrieveParams, requestOptions: RequestOptions): Stage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "stages", params.getPathParam(0))
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

    private val listHandler: Handler<StageListPage.Response> =
        jsonHandler<StageListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of `Stage` objects. */
    override fun list(params: StageListParams, requestOptions: RequestOptions): StageListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "stages")
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
                .let { StageListPage.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler: Handler<StageListRemoteFieldClassesPage.Response> =
        jsonHandler<StageListRemoteFieldClassesPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: StageListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): StageListRemoteFieldClassesPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "stages", "remote-field-classes")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { listRemoteFieldClassesHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { StageListRemoteFieldClassesPage.of(this, params, it) }
        }
    }
}

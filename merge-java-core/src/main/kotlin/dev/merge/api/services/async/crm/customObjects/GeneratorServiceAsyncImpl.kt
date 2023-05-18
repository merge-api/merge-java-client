package dev.merge.api.services.async.crm.customObjects

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.CustomObjectClass
import dev.merge.api.models.crm.CustomObjectGeneratorUpdateParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class GeneratorServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : GeneratorServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val updateHandler: Handler<CustomObjectClass> =
        jsonHandler<CustomObjectClass>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates a `CustomObjectClass` object with the given `id`. */
    override fun update(
        params: CustomObjectGeneratorUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CustomObjectClass> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PUT)
                .addPathSegments(
                    "crm",
                    "v1",
                    "custom-object-classes",
                    "generator",
                    params.getPathParam(0)
                )
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}

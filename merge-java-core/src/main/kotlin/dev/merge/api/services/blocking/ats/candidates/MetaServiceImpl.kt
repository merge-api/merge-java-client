package dev.merge.api.services.blocking.ats.candidates

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.ats.CandidateMetaForCreateParams
import dev.merge.api.services.errorHandler
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class MetaServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : MetaService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val forCreateHandler: Handler<MetaResponse> =
        jsonHandler<MetaResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns metadata for `Candidate` POSTs. */
    override fun forCreate(
        params: CandidateMetaForCreateParams,
        requestOptions: RequestOptions
    ): MetaResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "candidates", "meta", "post")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { forCreateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}

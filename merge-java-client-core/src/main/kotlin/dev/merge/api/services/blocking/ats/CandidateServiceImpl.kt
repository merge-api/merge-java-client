package dev.merge.api.services.blocking.ats

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ats.Candidate
import dev.merge.api.models.ats.CandidateCreateParams
import dev.merge.api.models.ats.CandidateIgnoreRowParams
import dev.merge.api.models.ats.CandidateListPage
import dev.merge.api.models.ats.CandidateListParams
import dev.merge.api.models.ats.CandidateResponse
import dev.merge.api.models.ats.CandidateRetrieveParams
import dev.merge.api.services.blocking.ats.candidates.MetaService
import dev.merge.api.services.blocking.ats.candidates.MetaServiceImpl
import dev.merge.api.services.emptyHandler
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class CandidateServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : CandidateService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaService by lazy { MetaServiceImpl(clientOptions) }

    override fun meta(): MetaService = meta

    private val createHandler: Handler<CandidateResponse> =
        jsonHandler<CandidateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Candidate` object with the given values. */
    override fun create(
        params: CandidateCreateParams,
        requestOptions: RequestOptions
    ): CandidateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "candidates")
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

    private val retrieveHandler: Handler<Candidate> =
        jsonHandler<Candidate>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Candidate` object with the given `id`. */
    override fun retrieve(
        params: CandidateRetrieveParams,
        requestOptions: RequestOptions
    ): Candidate {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "candidates", params.getPathParam(0))
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

    private val listHandler: Handler<CandidateListPage.Response> =
        jsonHandler<CandidateListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Candidate` objects. */
    override fun list(
        params: CandidateListParams,
        requestOptions: RequestOptions
    ): CandidateListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ats", "v1", "candidates")
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
                .let { CandidateListPage.of(this, params, it) }
        }
    }

    private val ignoreRowHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /**
     * Ignores a specific row based on the `model_id` in the url. These records will have their
     * properties set to null, and will not be updated in future syncs. The "reason" and "message"
     * fields in the request body will be stored for audit purposes.
     */
    override fun ignoreRow(params: CandidateIgnoreRowParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ats", "v1", "candidates", "ignore", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response.let { ignoreRowHandler.handle(it) }
        }
    }
}

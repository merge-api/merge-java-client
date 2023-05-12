package dev.merge.api.services.async.ticketing

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.ticketing.Ticket
import dev.merge.api.models.ticketing.TicketCreateParams
import dev.merge.api.models.ticketing.TicketListCollaboratorsPageAsync
import dev.merge.api.models.ticketing.TicketListCollaboratorsParams
import dev.merge.api.models.ticketing.TicketListPageAsync
import dev.merge.api.models.ticketing.TicketListParams
import dev.merge.api.models.ticketing.TicketListRemoteFieldClassesPageAsync
import dev.merge.api.models.ticketing.TicketListRemoteFieldClassesParams
import dev.merge.api.models.ticketing.TicketResponse
import dev.merge.api.models.ticketing.TicketRetrieveParams
import dev.merge.api.models.ticketing.TicketUpdateParams
import dev.merge.api.services.async.ticketing.tickets.MetaServiceAsync
import dev.merge.api.services.async.ticketing.tickets.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class TicketServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TicketServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<TicketResponse> =
        jsonHandler<TicketResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Ticket` object with the given values. */
    override fun create(
        params: TicketCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TicketResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ticketing", "v1", "tickets")
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

    private val retrieveHandler: Handler<Ticket> =
        jsonHandler<Ticket>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Ticket` object with the given `id`. */
    override fun retrieve(
        params: TicketRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Ticket> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "tickets", params.getPathParam(0))
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

    private val updateHandler: Handler<TicketResponse> =
        jsonHandler<TicketResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates a `Ticket` object with the given `id`. */
    override fun update(
        params: TicketUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TicketResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("ticketing", "v1", "tickets", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
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

    private val listHandler: Handler<TicketListPageAsync.Response> =
        jsonHandler<TicketListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Ticket` objects. */
    override fun list(
        params: TicketListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TicketListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "tickets")
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
                .let { TicketListPageAsync.of(this, params, it) }
        }
    }

    private val listCollaboratorsHandler: Handler<TicketListCollaboratorsPageAsync.Response> =
        jsonHandler<TicketListCollaboratorsPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `User` objects. */
    override fun listCollaborators(
        params: TicketListCollaboratorsParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TicketListCollaboratorsPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "ticketing",
                    "v1",
                    "tickets",
                    params.getPathParam(0),
                    "collaborators"
                )
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listCollaboratorsHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { TicketListCollaboratorsPageAsync.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler:
        Handler<TicketListRemoteFieldClassesPageAsync.Response> =
        jsonHandler<TicketListRemoteFieldClassesPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: TicketListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TicketListRemoteFieldClassesPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ticketing", "v1", "tickets", "remote-field-classes")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { listRemoteFieldClassesHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { TicketListRemoteFieldClassesPageAsync.of(this, params, it) }
        }
    }
}

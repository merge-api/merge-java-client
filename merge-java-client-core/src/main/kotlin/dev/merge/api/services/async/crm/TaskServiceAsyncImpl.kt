package dev.merge.api.services.async.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.Task
import dev.merge.api.models.crm.TaskCreateParams
import dev.merge.api.models.crm.TaskCreateResponse
import dev.merge.api.models.crm.TaskListPageAsync
import dev.merge.api.models.crm.TaskListParams
import dev.merge.api.models.crm.TaskListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.TaskListRemoteFieldClassesParams
import dev.merge.api.models.crm.TaskRetrieveParams
import dev.merge.api.models.crm.TaskUpdateParams
import dev.merge.api.services.async.crm.tasks.MetaServiceAsync
import dev.merge.api.services.async.crm.tasks.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class TaskServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TaskServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<TaskCreateResponse> =
        jsonHandler<TaskCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a `Task` object with the given values. */
    override fun create(
        params: TaskCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TaskCreateResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("crm", "v1", "tasks")
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

    private val retrieveHandler: Handler<Task> =
        jsonHandler<Task>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `Task` object with the given `id`. */
    override fun retrieve(
        params: TaskRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Task> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "tasks", params.getPathParam(0))
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

    private val updateHandler: Handler<TaskCreateResponse> =
        jsonHandler<TaskCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates a `Task` object with the given `id`. */
    override fun update(
        params: TaskUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TaskCreateResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("crm", "v1", "tasks", params.getPathParam(0))
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

    private val listHandler: Handler<TaskListPageAsync.Response> =
        jsonHandler<TaskListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Task` objects. */
    override fun list(
        params: TaskListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TaskListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "tasks")
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
                .let { TaskListPageAsync.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler:
        Handler<TaskListRemoteFieldClassesPageAsync.Response> =
        jsonHandler<TaskListRemoteFieldClassesPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: TaskListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): CompletableFuture<TaskListRemoteFieldClassesPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "tasks", "remote-field-classes")
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
                .let { TaskListRemoteFieldClassesPageAsync.of(this, params, it) }
        }
    }
}

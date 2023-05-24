package dev.merge.api.services.blocking.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.crm.User
import dev.merge.api.models.crm.UserIgnoreRowParams
import dev.merge.api.models.crm.UserListPage
import dev.merge.api.models.crm.UserListParams
import dev.merge.api.models.crm.UserListRemoteFieldClassesPage
import dev.merge.api.models.crm.UserListRemoteFieldClassesParams
import dev.merge.api.models.crm.UserRetrieveParams
import dev.merge.api.services.emptyHandler
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler

class UserServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : UserService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<User> =
        jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a `User` object with the given `id`. */
    override fun retrieve(params: UserRetrieveParams, requestOptions: RequestOptions): User {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "users", params.getPathParam(0))
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

    private val listHandler: Handler<UserListPage.Response> =
        jsonHandler<UserListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a list of `User` objects. */
    override fun list(params: UserListParams, requestOptions: RequestOptions): UserListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "users")
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
                .let { UserListPage.of(this, params, it) }
        }
    }

    private val ignoreRowHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /**
     * Ignores a specific row based on the `model_id` in the url. These records will have their
     * properties set to null, and will not be updated in future syncs. The "reason" and "message"
     * fields in the request body will be stored for audit purposes.
     */
    override fun ignoreRow(params: UserIgnoreRowParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("crm", "v1", "users", "ignore", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response.let { ignoreRowHandler.handle(it) }
        }
    }

    private val listRemoteFieldClassesHandler: Handler<UserListRemoteFieldClassesPage.Response> =
        jsonHandler<UserListRemoteFieldClassesPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: UserListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): UserListRemoteFieldClassesPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "users", "remote-field-classes")
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
                .let { UserListRemoteFieldClassesPage.of(this, params, it) }
        }
    }
}

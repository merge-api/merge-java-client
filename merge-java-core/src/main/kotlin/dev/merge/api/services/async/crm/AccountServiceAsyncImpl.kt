package dev.merge.api.services.async.crm

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.RequestOptions
import dev.merge.api.core.http.HttpMethod
import dev.merge.api.core.http.HttpRequest
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.Account
import dev.merge.api.models.crm.AccountCreateParams
import dev.merge.api.models.crm.AccountListPageAsync
import dev.merge.api.models.crm.AccountListParams
import dev.merge.api.models.crm.AccountListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.AccountListRemoteFieldClassesParams
import dev.merge.api.models.crm.AccountResponse
import dev.merge.api.models.crm.AccountRetrieveParams
import dev.merge.api.models.crm.AccountUpdateParams
import dev.merge.api.services.async.crm.accounts.MetaServiceAsync
import dev.merge.api.services.async.crm.accounts.MetaServiceAsyncImpl
import dev.merge.api.services.errorHandler
import dev.merge.api.services.json
import dev.merge.api.services.jsonHandler
import dev.merge.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class AccountServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AccountServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val meta: MetaServiceAsync by lazy { MetaServiceAsyncImpl(clientOptions) }

    override fun meta(): MetaServiceAsync = meta

    private val createHandler: Handler<AccountResponse> =
        jsonHandler<AccountResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates an `Account` object with the given values. */
    override fun create(
        params: AccountCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AccountResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("crm", "v1", "accounts")
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

    private val retrieveHandler: Handler<Account> =
        jsonHandler<Account>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns an `Account` object with the given `id`. */
    override fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Account> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "accounts", params.getPathParam(0))
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

    private val updateHandler: Handler<AccountResponse> =
        jsonHandler<AccountResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Updates an `Account` object with the given `id`. */
    override fun update(
        params: AccountUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AccountResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("crm", "v1", "accounts", params.getPathParam(0))
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

    private val listHandler: Handler<AccountListPageAsync.Response> =
        jsonHandler<AccountListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `Account` objects. */
    override fun list(
        params: AccountListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AccountListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "accounts")
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
                .let { AccountListPageAsync.of(this, params, it) }
        }
    }

    private val listRemoteFieldClassesHandler:
        Handler<AccountListRemoteFieldClassesPageAsync.Response> =
        jsonHandler<AccountListRemoteFieldClassesPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of `RemoteFieldClass` objects. */
    override fun listRemoteFieldClasses(
        params: AccountListRemoteFieldClassesParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AccountListRemoteFieldClassesPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("crm", "v1", "accounts", "remote-field-classes")
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
                .let { AccountListRemoteFieldClassesPageAsync.of(this, params, it) }
        }
    }
}

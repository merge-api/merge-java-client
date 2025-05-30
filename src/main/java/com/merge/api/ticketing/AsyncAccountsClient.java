/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.ticketing.types.Account;
import com.merge.api.ticketing.types.AccountsListRequest;
import com.merge.api.ticketing.types.AccountsRetrieveRequest;
import java.util.concurrent.CompletableFuture;

public class AsyncAccountsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawAccountsClient rawClient;

    public AsyncAccountsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawAccountsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawAccountsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Account</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Account>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Account</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Account>> list(AccountsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Account</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Account>> list(
            AccountsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Account</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Account> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Account</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Account> retrieve(String id, AccountsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Account</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Account> retrieve(
            String id, AccountsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }
}

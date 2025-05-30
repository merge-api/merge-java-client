/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting;

import com.merge.api.accounting.types.BankFeedAccount;
import com.merge.api.accounting.types.BankFeedAccountEndpointRequest;
import com.merge.api.accounting.types.BankFeedAccountResponse;
import com.merge.api.accounting.types.BankFeedAccountsListRequest;
import com.merge.api.accounting.types.BankFeedAccountsRetrieveRequest;
import com.merge.api.accounting.types.MetaResponse;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.util.concurrent.CompletableFuture;

public class AsyncBankFeedAccountsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawBankFeedAccountsClient rawClient;

    public AsyncBankFeedAccountsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawBankFeedAccountsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawBankFeedAccountsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>BankFeedAccount</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<BankFeedAccount>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>BankFeedAccount</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<BankFeedAccount>> list(BankFeedAccountsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>BankFeedAccount</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<BankFeedAccount>> list(
            BankFeedAccountsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Creates a <code>BankFeedAccount</code> object with the given values.
     */
    public CompletableFuture<BankFeedAccountResponse> create(BankFeedAccountEndpointRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Creates a <code>BankFeedAccount</code> object with the given values.
     */
    public CompletableFuture<BankFeedAccountResponse> create(
            BankFeedAccountEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>BankFeedAccount</code> object with the given <code>id</code>.
     */
    public CompletableFuture<BankFeedAccount> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>BankFeedAccount</code> object with the given <code>id</code>.
     */
    public CompletableFuture<BankFeedAccount> retrieve(String id, BankFeedAccountsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>BankFeedAccount</code> object with the given <code>id</code>.
     */
    public CompletableFuture<BankFeedAccount> retrieve(
            String id, BankFeedAccountsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>BankFeedAccount</code> POSTs.
     */
    public CompletableFuture<MetaResponse> metaPostRetrieve() {
        return this.rawClient.metaPostRetrieve().thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>BankFeedAccount</code> POSTs.
     */
    public CompletableFuture<MetaResponse> metaPostRetrieve(RequestOptions requestOptions) {
        return this.rawClient.metaPostRetrieve(requestOptions).thenApply(response -> response.body());
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting;

import com.merge.api.accounting.types.BalanceSheet;
import com.merge.api.accounting.types.BalanceSheetsListRequest;
import com.merge.api.accounting.types.BalanceSheetsRetrieveRequest;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.util.concurrent.CompletableFuture;

public class AsyncBalanceSheetsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawBalanceSheetsClient rawClient;

    public AsyncBalanceSheetsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawBalanceSheetsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawBalanceSheetsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>BalanceSheet</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<BalanceSheet>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>BalanceSheet</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<BalanceSheet>> list(BalanceSheetsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>BalanceSheet</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<BalanceSheet>> list(
            BalanceSheetsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>BalanceSheet</code> object with the given <code>id</code>.
     */
    public CompletableFuture<BalanceSheet> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>BalanceSheet</code> object with the given <code>id</code>.
     */
    public CompletableFuture<BalanceSheet> retrieve(String id, BalanceSheetsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>BalanceSheet</code> object with the given <code>id</code>.
     */
    public CompletableFuture<BalanceSheet> retrieve(
            String id, BalanceSheetsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }
}

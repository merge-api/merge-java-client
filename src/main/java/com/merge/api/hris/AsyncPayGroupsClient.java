/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.hris.types.PayGroup;
import com.merge.api.hris.types.PayGroupsListRequest;
import com.merge.api.hris.types.PayGroupsRetrieveRequest;
import java.util.concurrent.CompletableFuture;

public class AsyncPayGroupsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawPayGroupsClient rawClient;

    public AsyncPayGroupsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawPayGroupsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawPayGroupsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>PayGroup</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<PayGroup>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>PayGroup</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<PayGroup>> list(PayGroupsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>PayGroup</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<PayGroup>> list(
            PayGroupsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>PayGroup</code> object with the given <code>id</code>.
     */
    public CompletableFuture<PayGroup> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>PayGroup</code> object with the given <code>id</code>.
     */
    public CompletableFuture<PayGroup> retrieve(String id, PayGroupsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>PayGroup</code> object with the given <code>id</code>.
     */
    public CompletableFuture<PayGroup> retrieve(
            String id, PayGroupsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }
}

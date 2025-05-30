/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.hris.types.Employment;
import com.merge.api.hris.types.EmploymentsListRequest;
import com.merge.api.hris.types.EmploymentsRetrieveRequest;
import java.util.concurrent.CompletableFuture;

public class AsyncEmploymentsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawEmploymentsClient rawClient;

    public AsyncEmploymentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawEmploymentsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawEmploymentsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Employment</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Employment>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Employment</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Employment>> list(EmploymentsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Employment</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Employment>> list(
            EmploymentsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Employment</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Employment> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Employment</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Employment> retrieve(String id, EmploymentsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Employment</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Employment> retrieve(
            String id, EmploymentsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting;

import com.merge.api.accounting.types.Item;
import com.merge.api.accounting.types.ItemsListRequest;
import com.merge.api.accounting.types.ItemsRetrieveRequest;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.util.concurrent.CompletableFuture;

public class AsyncItemsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawItemsClient rawClient;

    public AsyncItemsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawItemsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawItemsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Item</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Item>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Item</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Item>> list(ItemsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Item</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Item>> list(ItemsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Item</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Item> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Item</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Item> retrieve(String id, ItemsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Item</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Item> retrieve(String id, ItemsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats;

import com.merge.api.ats.types.Attachment;
import com.merge.api.ats.types.AttachmentEndpointRequest;
import com.merge.api.ats.types.AttachmentResponse;
import com.merge.api.ats.types.AttachmentsListRequest;
import com.merge.api.ats.types.AttachmentsRetrieveRequest;
import com.merge.api.ats.types.MetaResponse;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.util.concurrent.CompletableFuture;

public class AsyncAttachmentsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawAttachmentsClient rawClient;

    public AsyncAttachmentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawAttachmentsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawAttachmentsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Attachment</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Attachment>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Attachment</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Attachment>> list(AttachmentsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Attachment</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Attachment>> list(
            AttachmentsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Creates an <code>Attachment</code> object with the given values.
     */
    public CompletableFuture<AttachmentResponse> create(AttachmentEndpointRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Creates an <code>Attachment</code> object with the given values.
     */
    public CompletableFuture<AttachmentResponse> create(
            AttachmentEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Attachment</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Attachment> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Attachment</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Attachment> retrieve(String id, AttachmentsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns an <code>Attachment</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Attachment> retrieve(
            String id, AttachmentsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>Attachment</code> POSTs.
     */
    public CompletableFuture<MetaResponse> metaPostRetrieve() {
        return this.rawClient.metaPostRetrieve().thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>Attachment</code> POSTs.
     */
    public CompletableFuture<MetaResponse> metaPostRetrieve(RequestOptions requestOptions) {
        return this.rawClient.metaPostRetrieve(requestOptions).thenApply(response -> response.body());
    }
}

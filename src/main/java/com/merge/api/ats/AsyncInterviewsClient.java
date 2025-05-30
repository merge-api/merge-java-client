/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats;

import com.merge.api.ats.types.InterviewsListRequest;
import com.merge.api.ats.types.InterviewsRetrieveRequest;
import com.merge.api.ats.types.MetaResponse;
import com.merge.api.ats.types.ScheduledInterview;
import com.merge.api.ats.types.ScheduledInterviewEndpointRequest;
import com.merge.api.ats.types.ScheduledInterviewResponse;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.util.concurrent.CompletableFuture;

public class AsyncInterviewsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawInterviewsClient rawClient;

    public AsyncInterviewsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawInterviewsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawInterviewsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>ScheduledInterview</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<ScheduledInterview>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>ScheduledInterview</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<ScheduledInterview>> list(InterviewsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>ScheduledInterview</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<ScheduledInterview>> list(
            InterviewsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Creates a <code>ScheduledInterview</code> object with the given values.
     */
    public CompletableFuture<ScheduledInterviewResponse> create(ScheduledInterviewEndpointRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Creates a <code>ScheduledInterview</code> object with the given values.
     */
    public CompletableFuture<ScheduledInterviewResponse> create(
            ScheduledInterviewEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>ScheduledInterview</code> object with the given <code>id</code>.
     */
    public CompletableFuture<ScheduledInterview> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>ScheduledInterview</code> object with the given <code>id</code>.
     */
    public CompletableFuture<ScheduledInterview> retrieve(String id, InterviewsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>ScheduledInterview</code> object with the given <code>id</code>.
     */
    public CompletableFuture<ScheduledInterview> retrieve(
            String id, InterviewsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>ScheduledInterview</code> POSTs.
     */
    public CompletableFuture<MetaResponse> metaPostRetrieve() {
        return this.rawClient.metaPostRetrieve().thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>ScheduledInterview</code> POSTs.
     */
    public CompletableFuture<MetaResponse> metaPostRetrieve(RequestOptions requestOptions) {
        return this.rawClient.metaPostRetrieve(requestOptions).thenApply(response -> response.body());
    }
}

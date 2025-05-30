/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats;

import com.merge.api.ats.types.JobInterviewStage;
import com.merge.api.ats.types.JobInterviewStagesListRequest;
import com.merge.api.ats.types.JobInterviewStagesRetrieveRequest;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.util.concurrent.CompletableFuture;

public class AsyncJobInterviewStagesClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawJobInterviewStagesClient rawClient;

    public AsyncJobInterviewStagesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawJobInterviewStagesClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawJobInterviewStagesClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>JobInterviewStage</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<JobInterviewStage>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>JobInterviewStage</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<JobInterviewStage>> list(JobInterviewStagesListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>JobInterviewStage</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<JobInterviewStage>> list(
            JobInterviewStagesListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>JobInterviewStage</code> object with the given <code>id</code>.
     */
    public CompletableFuture<JobInterviewStage> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>JobInterviewStage</code> object with the given <code>id</code>.
     */
    public CompletableFuture<JobInterviewStage> retrieve(String id, JobInterviewStagesRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>JobInterviewStage</code> object with the given <code>id</code>.
     */
    public CompletableFuture<JobInterviewStage> retrieve(
            String id, JobInterviewStagesRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }
}

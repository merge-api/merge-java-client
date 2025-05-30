/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats;

import com.merge.api.ats.types.Candidate;
import com.merge.api.ats.types.CandidateEndpointRequest;
import com.merge.api.ats.types.CandidateResponse;
import com.merge.api.ats.types.CandidatesListRequest;
import com.merge.api.ats.types.CandidatesRetrieveRequest;
import com.merge.api.ats.types.IgnoreCommonModelRequest;
import com.merge.api.ats.types.MetaResponse;
import com.merge.api.ats.types.PatchedCandidateEndpointRequest;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.util.concurrent.CompletableFuture;

public class AsyncCandidatesClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawCandidatesClient rawClient;

    public AsyncCandidatesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawCandidatesClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawCandidatesClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Candidate</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Candidate>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Candidate</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Candidate>> list(CandidatesListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Candidate</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Candidate>> list(
            CandidatesListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Creates a <code>Candidate</code> object with the given values.
     */
    public CompletableFuture<CandidateResponse> create(CandidateEndpointRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Creates a <code>Candidate</code> object with the given values.
     */
    public CompletableFuture<CandidateResponse> create(
            CandidateEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>Candidate</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Candidate> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>Candidate</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Candidate> retrieve(String id, CandidatesRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>Candidate</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Candidate> retrieve(
            String id, CandidatesRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Updates a <code>Candidate</code> object with the given <code>id</code>.
     */
    public CompletableFuture<CandidateResponse> partialUpdate(String id, PatchedCandidateEndpointRequest request) {
        return this.rawClient.partialUpdate(id, request).thenApply(response -> response.body());
    }

    /**
     * Updates a <code>Candidate</code> object with the given <code>id</code>.
     */
    public CompletableFuture<CandidateResponse> partialUpdate(
            String id, PatchedCandidateEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.partialUpdate(id, request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Ignores a specific row based on the <code>model_id</code> in the url. These records will have their properties set to null, and will not be updated in future syncs. The &quot;reason&quot; and &quot;message&quot; fields in the request body will be stored for audit purposes.
     */
    public CompletableFuture<Void> ignoreCreate(String modelId, IgnoreCommonModelRequest request) {
        return this.rawClient.ignoreCreate(modelId, request).thenApply(response -> response.body());
    }

    /**
     * Ignores a specific row based on the <code>model_id</code> in the url. These records will have their properties set to null, and will not be updated in future syncs. The &quot;reason&quot; and &quot;message&quot; fields in the request body will be stored for audit purposes.
     */
    public CompletableFuture<Void> ignoreCreate(
            String modelId, IgnoreCommonModelRequest request, RequestOptions requestOptions) {
        return this.rawClient.ignoreCreate(modelId, request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>Candidate</code> PATCHs.
     */
    public CompletableFuture<MetaResponse> metaPatchRetrieve(String id) {
        return this.rawClient.metaPatchRetrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>Candidate</code> PATCHs.
     */
    public CompletableFuture<MetaResponse> metaPatchRetrieve(String id, RequestOptions requestOptions) {
        return this.rawClient.metaPatchRetrieve(id, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>Candidate</code> POSTs.
     */
    public CompletableFuture<MetaResponse> metaPostRetrieve() {
        return this.rawClient.metaPostRetrieve().thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>Candidate</code> POSTs.
     */
    public CompletableFuture<MetaResponse> metaPostRetrieve(RequestOptions requestOptions) {
        return this.rawClient.metaPostRetrieve(requestOptions).thenApply(response -> response.body());
    }
}

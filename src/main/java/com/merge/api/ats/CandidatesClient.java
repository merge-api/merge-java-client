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

public class CandidatesClient {
    protected final ClientOptions clientOptions;

    private final RawCandidatesClient rawClient;

    public CandidatesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawCandidatesClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawCandidatesClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Candidate</code> objects.
     */
    public SyncPagingIterable<Candidate> list() {
        return this.rawClient.list().body();
    }

    /**
     * Returns a list of <code>Candidate</code> objects.
     */
    public SyncPagingIterable<Candidate> list(CandidatesListRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Returns a list of <code>Candidate</code> objects.
     */
    public SyncPagingIterable<Candidate> list(CandidatesListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Creates a <code>Candidate</code> object with the given values.
     */
    public CandidateResponse create(CandidateEndpointRequest request) {
        return this.rawClient.create(request).body();
    }

    /**
     * Creates a <code>Candidate</code> object with the given values.
     */
    public CandidateResponse create(CandidateEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).body();
    }

    /**
     * Returns a <code>Candidate</code> object with the given <code>id</code>.
     */
    public Candidate retrieve(String id) {
        return this.rawClient.retrieve(id).body();
    }

    /**
     * Returns a <code>Candidate</code> object with the given <code>id</code>.
     */
    public Candidate retrieve(String id, CandidatesRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).body();
    }

    /**
     * Returns a <code>Candidate</code> object with the given <code>id</code>.
     */
    public Candidate retrieve(String id, CandidatesRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).body();
    }

    /**
     * Updates a <code>Candidate</code> object with the given <code>id</code>.
     */
    public CandidateResponse partialUpdate(String id, PatchedCandidateEndpointRequest request) {
        return this.rawClient.partialUpdate(id, request).body();
    }

    /**
     * Updates a <code>Candidate</code> object with the given <code>id</code>.
     */
    public CandidateResponse partialUpdate(
            String id, PatchedCandidateEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.partialUpdate(id, request, requestOptions).body();
    }

    /**
     * Ignores a specific row based on the <code>model_id</code> in the url. These records will have their properties set to null, and will not be updated in future syncs. The &quot;reason&quot; and &quot;message&quot; fields in the request body will be stored for audit purposes.
     */
    public void ignoreCreate(String modelId, IgnoreCommonModelRequest request) {
        this.rawClient.ignoreCreate(modelId, request).body();
    }

    /**
     * Ignores a specific row based on the <code>model_id</code> in the url. These records will have their properties set to null, and will not be updated in future syncs. The &quot;reason&quot; and &quot;message&quot; fields in the request body will be stored for audit purposes.
     */
    public void ignoreCreate(String modelId, IgnoreCommonModelRequest request, RequestOptions requestOptions) {
        this.rawClient.ignoreCreate(modelId, request, requestOptions).body();
    }

    /**
     * Returns metadata for <code>Candidate</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id) {
        return this.rawClient.metaPatchRetrieve(id).body();
    }

    /**
     * Returns metadata for <code>Candidate</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id, RequestOptions requestOptions) {
        return this.rawClient.metaPatchRetrieve(id, requestOptions).body();
    }

    /**
     * Returns metadata for <code>Candidate</code> POSTs.
     */
    public MetaResponse metaPostRetrieve() {
        return this.rawClient.metaPostRetrieve().body();
    }

    /**
     * Returns metadata for <code>Candidate</code> POSTs.
     */
    public MetaResponse metaPostRetrieve(RequestOptions requestOptions) {
        return this.rawClient.metaPostRetrieve(requestOptions).body();
    }
}

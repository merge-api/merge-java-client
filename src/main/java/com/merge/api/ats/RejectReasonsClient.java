/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats;

import com.merge.api.ats.types.RejectReason;
import com.merge.api.ats.types.RejectReasonsListRequest;
import com.merge.api.ats.types.RejectReasonsRetrieveRequest;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;

public class RejectReasonsClient {
    protected final ClientOptions clientOptions;

    private final RawRejectReasonsClient rawClient;

    public RejectReasonsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawRejectReasonsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawRejectReasonsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>RejectReason</code> objects.
     */
    public SyncPagingIterable<RejectReason> list() {
        return this.rawClient.list().body();
    }

    /**
     * Returns a list of <code>RejectReason</code> objects.
     */
    public SyncPagingIterable<RejectReason> list(RejectReasonsListRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Returns a list of <code>RejectReason</code> objects.
     */
    public SyncPagingIterable<RejectReason> list(RejectReasonsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Returns a <code>RejectReason</code> object with the given <code>id</code>.
     */
    public RejectReason retrieve(String id) {
        return this.rawClient.retrieve(id).body();
    }

    /**
     * Returns a <code>RejectReason</code> object with the given <code>id</code>.
     */
    public RejectReason retrieve(String id, RejectReasonsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).body();
    }

    /**
     * Returns a <code>RejectReason</code> object with the given <code>id</code>.
     */
    public RejectReason retrieve(String id, RejectReasonsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).body();
    }
}

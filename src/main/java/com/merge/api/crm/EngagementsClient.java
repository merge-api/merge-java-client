/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.crm;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.crm.types.Engagement;
import com.merge.api.crm.types.EngagementEndpointRequest;
import com.merge.api.crm.types.EngagementResponse;
import com.merge.api.crm.types.EngagementsListRequest;
import com.merge.api.crm.types.EngagementsRemoteFieldClassesListRequest;
import com.merge.api.crm.types.EngagementsRetrieveRequest;
import com.merge.api.crm.types.MetaResponse;
import com.merge.api.crm.types.PatchedEngagementEndpointRequest;
import com.merge.api.crm.types.RemoteFieldClass;

public class EngagementsClient {
    protected final ClientOptions clientOptions;

    private final RawEngagementsClient rawClient;

    public EngagementsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawEngagementsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawEngagementsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Engagement</code> objects.
     */
    public SyncPagingIterable<Engagement> list() {
        return this.rawClient.list().body();
    }

    /**
     * Returns a list of <code>Engagement</code> objects.
     */
    public SyncPagingIterable<Engagement> list(EngagementsListRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Returns a list of <code>Engagement</code> objects.
     */
    public SyncPagingIterable<Engagement> list(EngagementsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Creates an <code>Engagement</code> object with the given values.
     */
    public EngagementResponse create(EngagementEndpointRequest request) {
        return this.rawClient.create(request).body();
    }

    /**
     * Creates an <code>Engagement</code> object with the given values.
     */
    public EngagementResponse create(EngagementEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).body();
    }

    /**
     * Returns an <code>Engagement</code> object with the given <code>id</code>.
     */
    public Engagement retrieve(String id) {
        return this.rawClient.retrieve(id).body();
    }

    /**
     * Returns an <code>Engagement</code> object with the given <code>id</code>.
     */
    public Engagement retrieve(String id, EngagementsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).body();
    }

    /**
     * Returns an <code>Engagement</code> object with the given <code>id</code>.
     */
    public Engagement retrieve(String id, EngagementsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).body();
    }

    /**
     * Updates an <code>Engagement</code> object with the given <code>id</code>.
     */
    public EngagementResponse partialUpdate(String id, PatchedEngagementEndpointRequest request) {
        return this.rawClient.partialUpdate(id, request).body();
    }

    /**
     * Updates an <code>Engagement</code> object with the given <code>id</code>.
     */
    public EngagementResponse partialUpdate(
            String id, PatchedEngagementEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.partialUpdate(id, request, requestOptions).body();
    }

    /**
     * Returns metadata for <code>Engagement</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id) {
        return this.rawClient.metaPatchRetrieve(id).body();
    }

    /**
     * Returns metadata for <code>Engagement</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id, RequestOptions requestOptions) {
        return this.rawClient.metaPatchRetrieve(id, requestOptions).body();
    }

    /**
     * Returns metadata for <code>Engagement</code> POSTs.
     */
    public MetaResponse metaPostRetrieve() {
        return this.rawClient.metaPostRetrieve().body();
    }

    /**
     * Returns metadata for <code>Engagement</code> POSTs.
     */
    public MetaResponse metaPostRetrieve(RequestOptions requestOptions) {
        return this.rawClient.metaPostRetrieve(requestOptions).body();
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public SyncPagingIterable<RemoteFieldClass> remoteFieldClassesList() {
        return this.rawClient.remoteFieldClassesList().body();
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public SyncPagingIterable<RemoteFieldClass> remoteFieldClassesList(
            EngagementsRemoteFieldClassesListRequest request) {
        return this.rawClient.remoteFieldClassesList(request).body();
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public SyncPagingIterable<RemoteFieldClass> remoteFieldClassesList(
            EngagementsRemoteFieldClassesListRequest request, RequestOptions requestOptions) {
        return this.rawClient.remoteFieldClassesList(request, requestOptions).body();
    }
}

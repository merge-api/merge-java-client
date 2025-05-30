/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.crm;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.crm.types.AssociationType;
import com.merge.api.crm.types.CrmAssociationTypeEndpointRequest;
import com.merge.api.crm.types.CrmAssociationTypeResponse;
import com.merge.api.crm.types.CustomObjectClassesAssociationTypesListRequest;
import com.merge.api.crm.types.CustomObjectClassesAssociationTypesRetrieveRequest;
import com.merge.api.crm.types.MetaResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncAssociationTypesClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawAssociationTypesClient rawClient;

    public AsyncAssociationTypesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawAssociationTypesClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawAssociationTypesClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>AssociationType</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<AssociationType>> customObjectClassesAssociationTypesList(
            String customObjectClassId) {
        return this.rawClient
                .customObjectClassesAssociationTypesList(customObjectClassId)
                .thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>AssociationType</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<AssociationType>> customObjectClassesAssociationTypesList(
            String customObjectClassId, CustomObjectClassesAssociationTypesListRequest request) {
        return this.rawClient
                .customObjectClassesAssociationTypesList(customObjectClassId, request)
                .thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>AssociationType</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<AssociationType>> customObjectClassesAssociationTypesList(
            String customObjectClassId,
            CustomObjectClassesAssociationTypesListRequest request,
            RequestOptions requestOptions) {
        return this.rawClient
                .customObjectClassesAssociationTypesList(customObjectClassId, request, requestOptions)
                .thenApply(response -> response.body());
    }

    /**
     * Creates an <code>AssociationType</code> object with the given values.
     */
    public CompletableFuture<CrmAssociationTypeResponse> customObjectClassesAssociationTypesCreate(
            String customObjectClassId, CrmAssociationTypeEndpointRequest request) {
        return this.rawClient
                .customObjectClassesAssociationTypesCreate(customObjectClassId, request)
                .thenApply(response -> response.body());
    }

    /**
     * Creates an <code>AssociationType</code> object with the given values.
     */
    public CompletableFuture<CrmAssociationTypeResponse> customObjectClassesAssociationTypesCreate(
            String customObjectClassId, CrmAssociationTypeEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient
                .customObjectClassesAssociationTypesCreate(customObjectClassId, request, requestOptions)
                .thenApply(response -> response.body());
    }

    /**
     * Returns an <code>AssociationType</code> object with the given <code>id</code>.
     */
    public CompletableFuture<AssociationType> customObjectClassesAssociationTypesRetrieve(
            String customObjectClassId, String id) {
        return this.rawClient
                .customObjectClassesAssociationTypesRetrieve(customObjectClassId, id)
                .thenApply(response -> response.body());
    }

    /**
     * Returns an <code>AssociationType</code> object with the given <code>id</code>.
     */
    public CompletableFuture<AssociationType> customObjectClassesAssociationTypesRetrieve(
            String customObjectClassId, String id, CustomObjectClassesAssociationTypesRetrieveRequest request) {
        return this.rawClient
                .customObjectClassesAssociationTypesRetrieve(customObjectClassId, id, request)
                .thenApply(response -> response.body());
    }

    /**
     * Returns an <code>AssociationType</code> object with the given <code>id</code>.
     */
    public CompletableFuture<AssociationType> customObjectClassesAssociationTypesRetrieve(
            String customObjectClassId,
            String id,
            CustomObjectClassesAssociationTypesRetrieveRequest request,
            RequestOptions requestOptions) {
        return this.rawClient
                .customObjectClassesAssociationTypesRetrieve(customObjectClassId, id, request, requestOptions)
                .thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>CRMAssociationType</code> POSTs.
     */
    public CompletableFuture<MetaResponse> customObjectClassesAssociationTypesMetaPostRetrieve(
            String customObjectClassId) {
        return this.rawClient
                .customObjectClassesAssociationTypesMetaPostRetrieve(customObjectClassId)
                .thenApply(response -> response.body());
    }

    /**
     * Returns metadata for <code>CRMAssociationType</code> POSTs.
     */
    public CompletableFuture<MetaResponse> customObjectClassesAssociationTypesMetaPostRetrieve(
            String customObjectClassId, RequestOptions requestOptions) {
        return this.rawClient
                .customObjectClassesAssociationTypesMetaPostRetrieve(customObjectClassId, requestOptions)
                .thenApply(response -> response.body());
    }
}

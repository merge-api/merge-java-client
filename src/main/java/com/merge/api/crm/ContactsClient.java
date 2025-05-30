/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.crm;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.crm.types.Contact;
import com.merge.api.crm.types.ContactsListRequest;
import com.merge.api.crm.types.ContactsRemoteFieldClassesListRequest;
import com.merge.api.crm.types.ContactsRetrieveRequest;
import com.merge.api.crm.types.CrmContactEndpointRequest;
import com.merge.api.crm.types.CrmContactResponse;
import com.merge.api.crm.types.IgnoreCommonModelRequest;
import com.merge.api.crm.types.MetaResponse;
import com.merge.api.crm.types.PatchedCrmContactEndpointRequest;
import com.merge.api.crm.types.RemoteFieldClass;

public class ContactsClient {
    protected final ClientOptions clientOptions;

    private final RawContactsClient rawClient;

    public ContactsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawContactsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawContactsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Contact</code> objects.
     */
    public SyncPagingIterable<Contact> list() {
        return this.rawClient.list().body();
    }

    /**
     * Returns a list of <code>Contact</code> objects.
     */
    public SyncPagingIterable<Contact> list(ContactsListRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Returns a list of <code>Contact</code> objects.
     */
    public SyncPagingIterable<Contact> list(ContactsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Creates a <code>Contact</code> object with the given values.
     */
    public CrmContactResponse create(CrmContactEndpointRequest request) {
        return this.rawClient.create(request).body();
    }

    /**
     * Creates a <code>Contact</code> object with the given values.
     */
    public CrmContactResponse create(CrmContactEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).body();
    }

    /**
     * Returns a <code>Contact</code> object with the given <code>id</code>.
     */
    public Contact retrieve(String id) {
        return this.rawClient.retrieve(id).body();
    }

    /**
     * Returns a <code>Contact</code> object with the given <code>id</code>.
     */
    public Contact retrieve(String id, ContactsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).body();
    }

    /**
     * Returns a <code>Contact</code> object with the given <code>id</code>.
     */
    public Contact retrieve(String id, ContactsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).body();
    }

    /**
     * Updates a <code>Contact</code> object with the given <code>id</code>.
     */
    public CrmContactResponse partialUpdate(String id, PatchedCrmContactEndpointRequest request) {
        return this.rawClient.partialUpdate(id, request).body();
    }

    /**
     * Updates a <code>Contact</code> object with the given <code>id</code>.
     */
    public CrmContactResponse partialUpdate(
            String id, PatchedCrmContactEndpointRequest request, RequestOptions requestOptions) {
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
     * Returns metadata for <code>CRMContact</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id) {
        return this.rawClient.metaPatchRetrieve(id).body();
    }

    /**
     * Returns metadata for <code>CRMContact</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id, RequestOptions requestOptions) {
        return this.rawClient.metaPatchRetrieve(id, requestOptions).body();
    }

    /**
     * Returns metadata for <code>CRMContact</code> POSTs.
     */
    public MetaResponse metaPostRetrieve() {
        return this.rawClient.metaPostRetrieve().body();
    }

    /**
     * Returns metadata for <code>CRMContact</code> POSTs.
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
    public SyncPagingIterable<RemoteFieldClass> remoteFieldClassesList(ContactsRemoteFieldClassesListRequest request) {
        return this.rawClient.remoteFieldClassesList(request).body();
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public SyncPagingIterable<RemoteFieldClass> remoteFieldClassesList(
            ContactsRemoteFieldClassesListRequest request, RequestOptions requestOptions) {
        return this.rawClient.remoteFieldClassesList(request, requestOptions).body();
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting;

import com.merge.api.accounting.types.Invoice;
import com.merge.api.accounting.types.InvoiceEndpointRequest;
import com.merge.api.accounting.types.InvoiceResponse;
import com.merge.api.accounting.types.InvoicesLineItemsRemoteFieldClassesListRequest;
import com.merge.api.accounting.types.InvoicesListRequest;
import com.merge.api.accounting.types.InvoicesRemoteFieldClassesListRequest;
import com.merge.api.accounting.types.InvoicesRetrieveRequest;
import com.merge.api.accounting.types.MetaResponse;
import com.merge.api.accounting.types.PatchedInvoiceEndpointRequest;
import com.merge.api.accounting.types.RemoteFieldClass;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;

public class InvoicesClient {
    protected final ClientOptions clientOptions;

    private final RawInvoicesClient rawClient;

    public InvoicesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawInvoicesClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawInvoicesClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Invoice</code> objects.
     */
    public SyncPagingIterable<Invoice> list() {
        return this.rawClient.list().body();
    }

    /**
     * Returns a list of <code>Invoice</code> objects.
     */
    public SyncPagingIterable<Invoice> list(InvoicesListRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Returns a list of <code>Invoice</code> objects.
     */
    public SyncPagingIterable<Invoice> list(InvoicesListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Creates an <code>Invoice</code> object with the given values.
     * Including a <code>PurchaseOrder</code> id in the <code>purchase_orders</code> property will generate an Accounts Payable Invoice from the specified Purchase Order(s).
     */
    public InvoiceResponse create(InvoiceEndpointRequest request) {
        return this.rawClient.create(request).body();
    }

    /**
     * Creates an <code>Invoice</code> object with the given values.
     * Including a <code>PurchaseOrder</code> id in the <code>purchase_orders</code> property will generate an Accounts Payable Invoice from the specified Purchase Order(s).
     */
    public InvoiceResponse create(InvoiceEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).body();
    }

    /**
     * Returns an <code>Invoice</code> object with the given <code>id</code>.
     */
    public Invoice retrieve(String id) {
        return this.rawClient.retrieve(id).body();
    }

    /**
     * Returns an <code>Invoice</code> object with the given <code>id</code>.
     */
    public Invoice retrieve(String id, InvoicesRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).body();
    }

    /**
     * Returns an <code>Invoice</code> object with the given <code>id</code>.
     */
    public Invoice retrieve(String id, InvoicesRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).body();
    }

    /**
     * Updates an <code>Invoice</code> object with the given <code>id</code>.
     */
    public InvoiceResponse partialUpdate(String id, PatchedInvoiceEndpointRequest request) {
        return this.rawClient.partialUpdate(id, request).body();
    }

    /**
     * Updates an <code>Invoice</code> object with the given <code>id</code>.
     */
    public InvoiceResponse partialUpdate(
            String id, PatchedInvoiceEndpointRequest request, RequestOptions requestOptions) {
        return this.rawClient.partialUpdate(id, request, requestOptions).body();
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public SyncPagingIterable<RemoteFieldClass> lineItemsRemoteFieldClassesList() {
        return this.rawClient.lineItemsRemoteFieldClassesList().body();
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public SyncPagingIterable<RemoteFieldClass> lineItemsRemoteFieldClassesList(
            InvoicesLineItemsRemoteFieldClassesListRequest request) {
        return this.rawClient.lineItemsRemoteFieldClassesList(request).body();
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public SyncPagingIterable<RemoteFieldClass> lineItemsRemoteFieldClassesList(
            InvoicesLineItemsRemoteFieldClassesListRequest request, RequestOptions requestOptions) {
        return this.rawClient
                .lineItemsRemoteFieldClassesList(request, requestOptions)
                .body();
    }

    /**
     * Returns metadata for <code>Invoice</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id) {
        return this.rawClient.metaPatchRetrieve(id).body();
    }

    /**
     * Returns metadata for <code>Invoice</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id, RequestOptions requestOptions) {
        return this.rawClient.metaPatchRetrieve(id, requestOptions).body();
    }

    /**
     * Returns metadata for <code>Invoice</code> POSTs.
     */
    public MetaResponse metaPostRetrieve() {
        return this.rawClient.metaPostRetrieve().body();
    }

    /**
     * Returns metadata for <code>Invoice</code> POSTs.
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
    public SyncPagingIterable<RemoteFieldClass> remoteFieldClassesList(InvoicesRemoteFieldClassesListRequest request) {
        return this.rawClient.remoteFieldClassesList(request).body();
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public SyncPagingIterable<RemoteFieldClass> remoteFieldClassesList(
            InvoicesRemoteFieldClassesListRequest request, RequestOptions requestOptions) {
        return this.rawClient.remoteFieldClassesList(request, requestOptions).body();
    }
}

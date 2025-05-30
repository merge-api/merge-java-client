/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting;

import com.merge.api.accounting.types.BalanceSheet;
import com.merge.api.accounting.types.BalanceSheetsListRequest;
import com.merge.api.accounting.types.BalanceSheetsRetrieveRequest;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;

public class BalanceSheetsClient {
    protected final ClientOptions clientOptions;

    private final RawBalanceSheetsClient rawClient;

    public BalanceSheetsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawBalanceSheetsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawBalanceSheetsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>BalanceSheet</code> objects.
     */
    public SyncPagingIterable<BalanceSheet> list() {
        return this.rawClient.list().body();
    }

    /**
     * Returns a list of <code>BalanceSheet</code> objects.
     */
    public SyncPagingIterable<BalanceSheet> list(BalanceSheetsListRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Returns a list of <code>BalanceSheet</code> objects.
     */
    public SyncPagingIterable<BalanceSheet> list(BalanceSheetsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Returns a <code>BalanceSheet</code> object with the given <code>id</code>.
     */
    public BalanceSheet retrieve(String id) {
        return this.rawClient.retrieve(id).body();
    }

    /**
     * Returns a <code>BalanceSheet</code> object with the given <code>id</code>.
     */
    public BalanceSheet retrieve(String id, BalanceSheetsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).body();
    }

    /**
     * Returns a <code>BalanceSheet</code> object with the given <code>id</code>.
     */
    public BalanceSheet retrieve(String id, BalanceSheetsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).body();
    }
}

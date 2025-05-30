/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.hris.types.BankInfo;
import com.merge.api.hris.types.BankInfoListRequest;
import com.merge.api.hris.types.BankInfoRetrieveRequest;

public class BankInfoClient {
    protected final ClientOptions clientOptions;

    private final RawBankInfoClient rawClient;

    public BankInfoClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawBankInfoClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawBankInfoClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>BankInfo</code> objects.
     */
    public SyncPagingIterable<BankInfo> list() {
        return this.rawClient.list().body();
    }

    /**
     * Returns a list of <code>BankInfo</code> objects.
     */
    public SyncPagingIterable<BankInfo> list(BankInfoListRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Returns a list of <code>BankInfo</code> objects.
     */
    public SyncPagingIterable<BankInfo> list(BankInfoListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Returns a <code>BankInfo</code> object with the given <code>id</code>.
     */
    public BankInfo retrieve(String id) {
        return this.rawClient.retrieve(id).body();
    }

    /**
     * Returns a <code>BankInfo</code> object with the given <code>id</code>.
     */
    public BankInfo retrieve(String id, BankInfoRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).body();
    }

    /**
     * Returns a <code>BankInfo</code> object with the given <code>id</code>.
     */
    public BankInfo retrieve(String id, BankInfoRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).body();
    }
}

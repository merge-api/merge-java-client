/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.filestorage;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.filestorage.types.DataPassthroughRequest;
import com.merge.api.filestorage.types.RemoteResponse;

public class PassthroughClient {
    protected final ClientOptions clientOptions;

    private final RawPassthroughClient rawClient;

    public PassthroughClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawPassthroughClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawPassthroughClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Pull data from an endpoint not currently supported by Merge.
     */
    public RemoteResponse create(DataPassthroughRequest request) {
        return this.rawClient.create(request).body();
    }

    /**
     * Pull data from an endpoint not currently supported by Merge.
     */
    public RemoteResponse create(DataPassthroughRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).body();
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting;

import com.merge.api.accounting.types.GenerateRemoteKeyRequest;
import com.merge.api.accounting.types.RemoteKey;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import java.util.concurrent.CompletableFuture;

public class AsyncGenerateKeyClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawGenerateKeyClient rawClient;

    public AsyncGenerateKeyClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawGenerateKeyClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawGenerateKeyClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Create a remote key.
     */
    public CompletableFuture<RemoteKey> create(GenerateRemoteKeyRequest request) {
        return this.rawClient.create(request).thenApply(response -> response.body());
    }

    /**
     * Create a remote key.
     */
    public CompletableFuture<RemoteKey> create(GenerateRemoteKeyRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).thenApply(response -> response.body());
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting;

import com.merge.api.accounting.types.AsyncPostTask;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;

public class AsyncTasksClient {
    protected final ClientOptions clientOptions;

    private final RawAsyncTasksClient rawClient;

    public AsyncTasksClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawAsyncTasksClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawAsyncTasksClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns an <code>AsyncPostTask</code> object with the given <code>id</code>.
     */
    public AsyncPostTask retrieve(String id) {
        return this.rawClient.retrieve(id).body();
    }

    /**
     * Returns an <code>AsyncPostTask</code> object with the given <code>id</code>.
     */
    public AsyncPostTask retrieve(String id, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, requestOptions).body();
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats;

import com.merge.api.ats.types.Scorecard;
import com.merge.api.ats.types.ScorecardsListRequest;
import com.merge.api.ats.types.ScorecardsRetrieveRequest;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.util.concurrent.CompletableFuture;

public class AsyncScorecardsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawScorecardsClient rawClient;

    public AsyncScorecardsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawScorecardsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawScorecardsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Scorecard</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Scorecard>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Scorecard</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Scorecard>> list(ScorecardsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Scorecard</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Scorecard>> list(
            ScorecardsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>Scorecard</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Scorecard> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>Scorecard</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Scorecard> retrieve(String id, ScorecardsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>Scorecard</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Scorecard> retrieve(
            String id, ScorecardsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }
}

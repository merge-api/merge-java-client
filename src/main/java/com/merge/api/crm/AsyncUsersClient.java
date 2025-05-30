/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.crm;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.crm.types.IgnoreCommonModelRequest;
import com.merge.api.crm.types.RemoteFieldClass;
import com.merge.api.crm.types.User;
import com.merge.api.crm.types.UsersListRequest;
import com.merge.api.crm.types.UsersRemoteFieldClassesListRequest;
import com.merge.api.crm.types.UsersRetrieveRequest;
import java.util.concurrent.CompletableFuture;

public class AsyncUsersClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawUsersClient rawClient;

    public AsyncUsersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawUsersClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawUsersClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>User</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<User>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>User</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<User>> list(UsersListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>User</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<User>> list(UsersListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>User</code> object with the given <code>id</code>.
     */
    public CompletableFuture<User> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>User</code> object with the given <code>id</code>.
     */
    public CompletableFuture<User> retrieve(String id, UsersRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>User</code> object with the given <code>id</code>.
     */
    public CompletableFuture<User> retrieve(String id, UsersRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Ignores a specific row based on the <code>model_id</code> in the url. These records will have their properties set to null, and will not be updated in future syncs. The &quot;reason&quot; and &quot;message&quot; fields in the request body will be stored for audit purposes.
     */
    public CompletableFuture<Void> ignoreCreate(String modelId, IgnoreCommonModelRequest request) {
        return this.rawClient.ignoreCreate(modelId, request).thenApply(response -> response.body());
    }

    /**
     * Ignores a specific row based on the <code>model_id</code> in the url. These records will have their properties set to null, and will not be updated in future syncs. The &quot;reason&quot; and &quot;message&quot; fields in the request body will be stored for audit purposes.
     */
    public CompletableFuture<Void> ignoreCreate(
            String modelId, IgnoreCommonModelRequest request, RequestOptions requestOptions) {
        return this.rawClient.ignoreCreate(modelId, request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<RemoteFieldClass>> remoteFieldClassesList() {
        return this.rawClient.remoteFieldClassesList().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<RemoteFieldClass>> remoteFieldClassesList(
            UsersRemoteFieldClassesListRequest request) {
        return this.rawClient.remoteFieldClassesList(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<RemoteFieldClass>> remoteFieldClassesList(
            UsersRemoteFieldClassesListRequest request, RequestOptions requestOptions) {
        return this.rawClient.remoteFieldClassesList(request, requestOptions).thenApply(response -> response.body());
    }
}

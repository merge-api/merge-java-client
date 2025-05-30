/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.ticketing.types.Project;
import com.merge.api.ticketing.types.ProjectsListRequest;
import com.merge.api.ticketing.types.ProjectsRetrieveRequest;
import com.merge.api.ticketing.types.ProjectsUsersListRequest;
import com.merge.api.ticketing.types.User;
import java.util.concurrent.CompletableFuture;

public class AsyncProjectsClient {
    protected final ClientOptions clientOptions;

    private final AsyncRawProjectsClient rawClient;

    public AsyncProjectsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new AsyncRawProjectsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public AsyncRawProjectsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>Project</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Project>> list() {
        return this.rawClient.list().thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Project</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Project>> list(ProjectsListRequest request) {
        return this.rawClient.list(request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>Project</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<Project>> list(
            ProjectsListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>Project</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Project> retrieve(String id) {
        return this.rawClient.retrieve(id).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>Project</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Project> retrieve(String id, ProjectsRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).thenApply(response -> response.body());
    }

    /**
     * Returns a <code>Project</code> object with the given <code>id</code>.
     */
    public CompletableFuture<Project> retrieve(
            String id, ProjectsRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>User</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<User>> usersList(String parentId) {
        return this.rawClient.usersList(parentId).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>User</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<User>> usersList(String parentId, ProjectsUsersListRequest request) {
        return this.rawClient.usersList(parentId, request).thenApply(response -> response.body());
    }

    /**
     * Returns a list of <code>User</code> objects.
     */
    public CompletableFuture<SyncPagingIterable<User>> usersList(
            String parentId, ProjectsUsersListRequest request, RequestOptions requestOptions) {
        return this.rawClient.usersList(parentId, request, requestOptions).thenApply(response -> response.body());
    }
}

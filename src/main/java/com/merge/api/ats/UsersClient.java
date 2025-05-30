/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats;

import com.merge.api.ats.types.RemoteUser;
import com.merge.api.ats.types.UsersListRequest;
import com.merge.api.ats.types.UsersRetrieveRequest;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;

public class UsersClient {
    protected final ClientOptions clientOptions;

    private final RawUsersClient rawClient;

    public UsersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawUsersClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawUsersClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>RemoteUser</code> objects.
     */
    public SyncPagingIterable<RemoteUser> list() {
        return this.rawClient.list().body();
    }

    /**
     * Returns a list of <code>RemoteUser</code> objects.
     */
    public SyncPagingIterable<RemoteUser> list(UsersListRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Returns a list of <code>RemoteUser</code> objects.
     */
    public SyncPagingIterable<RemoteUser> list(UsersListRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Returns a <code>RemoteUser</code> object with the given <code>id</code>.
     */
    public RemoteUser retrieve(String id) {
        return this.rawClient.retrieve(id).body();
    }

    /**
     * Returns a <code>RemoteUser</code> object with the given <code>id</code>.
     */
    public RemoteUser retrieve(String id, UsersRetrieveRequest request) {
        return this.rawClient.retrieve(id, request).body();
    }

    /**
     * Returns a <code>RemoteUser</code> object with the given <code>id</code>.
     */
    public RemoteUser retrieve(String id, UsersRetrieveRequest request, RequestOptions requestOptions) {
        return this.rawClient.retrieve(id, request, requestOptions).body();
    }
}

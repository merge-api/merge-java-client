/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ticketing.tickets;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MediaTypes;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.ticketing.tickets.requests.PatchedTicketEndpointRequest;
import com.merge.api.resources.ticketing.tickets.requests.TicketEndpointRequest;
import com.merge.api.resources.ticketing.tickets.requests.TicketsCollaboratorsListRequest;
import com.merge.api.resources.ticketing.tickets.requests.TicketsListRequest;
import com.merge.api.resources.ticketing.tickets.requests.TicketsRemoteFieldClassesListRequest;
import com.merge.api.resources.ticketing.tickets.requests.TicketsRetrieveRequest;
import com.merge.api.resources.ticketing.types.MetaResponse;
import com.merge.api.resources.ticketing.types.PaginatedRemoteFieldClassList;
import com.merge.api.resources.ticketing.types.PaginatedTicketList;
import com.merge.api.resources.ticketing.types.PaginatedUserList;
import com.merge.api.resources.ticketing.types.Ticket;
import com.merge.api.resources.ticketing.types.TicketResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TicketsClient {
    protected final ClientOptions clientOptions;

    public TicketsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>Ticket</code> objects.
     */
    public PaginatedTicketList list() {
        return list(TicketsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>Ticket</code> objects.
     */
    public PaginatedTicketList list(TicketsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>Ticket</code> objects.
     */
    public PaginatedTicketList list(TicketsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/tickets");
        if (request.getAccountId().isPresent()) {
            httpUrl.addQueryParameter("account_id", request.getAccountId().get());
        }
        if (request.getAssigneeIds().isPresent()) {
            httpUrl.addQueryParameter("assignee_ids", request.getAssigneeIds().get());
        }
        if (request.getCollectionIds().isPresent()) {
            httpUrl.addQueryParameter(
                    "collection_ids", request.getCollectionIds().get());
        }
        if (request.getCompletedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "completed_after", request.getCompletedAfter().get().toString());
        }
        if (request.getCompletedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "completed_before", request.getCompletedBefore().get().toString());
        }
        if (request.getContactId().isPresent()) {
            httpUrl.addQueryParameter("contact_id", request.getContactId().get());
        }
        if (request.getCreatedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "created_after", request.getCreatedAfter().get().toString());
        }
        if (request.getCreatedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "created_before", request.getCreatedBefore().get().toString());
        }
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getDueAfter().isPresent()) {
            httpUrl.addQueryParameter("due_after", request.getDueAfter().get().toString());
        }
        if (request.getDueBefore().isPresent()) {
            httpUrl.addQueryParameter("due_before", request.getDueBefore().get().toString());
        }
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeDeletedData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getIncludeRemoteFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_fields",
                    request.getIncludeRemoteFields().get().toString());
        }
        if (request.getModifiedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "modified_after", request.getModifiedAfter().get().toString());
        }
        if (request.getModifiedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "modified_before", request.getModifiedBefore().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getParentTicketId().isPresent()) {
            httpUrl.addQueryParameter(
                    "parent_ticket_id", request.getParentTicketId().get());
        }
        if (request.getPriority().isPresent()) {
            httpUrl.addQueryParameter("priority", request.getPriority().get().toString());
        }
        if (request.getRemoteCreatedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_created_after",
                    request.getRemoteCreatedAfter().get().toString());
        }
        if (request.getRemoteCreatedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_created_before",
                    request.getRemoteCreatedBefore().get().toString());
        }
        if (request.getRemoteFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get().toString());
        }
        if (request.getRemoteId().isPresent()) {
            httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
        }
        if (request.getRemoteUpdatedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_updated_after",
                    request.getRemoteUpdatedAfter().get().toString());
        }
        if (request.getRemoteUpdatedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_updated_before",
                    request.getRemoteUpdatedBefore().get().toString());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get().toString());
        }
        if (request.getStatus().isPresent()) {
            httpUrl.addQueryParameter("status", request.getStatus().get().toString());
        }
        if (request.getTags().isPresent()) {
            httpUrl.addQueryParameter("tags", request.getTags().get());
        }
        if (request.getTicketType().isPresent()) {
            httpUrl.addQueryParameter("ticket_type", request.getTicketType().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), PaginatedTicketList.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a <code>Ticket</code> object with the given values.
     */
    public TicketResponse create(TicketEndpointRequest request) {
        return create(request, null);
    }

    /**
     * Creates a <code>Ticket</code> object with the given values.
     */
    public TicketResponse create(TicketEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/tickets");
        if (request.getIsDebugMode().isPresent()) {
            httpUrl.addQueryParameter(
                    "is_debug_mode", request.getIsDebugMode().get().toString());
        }
        if (request.getRunAsync().isPresent()) {
            httpUrl.addQueryParameter("run_async", request.getRunAsync().get().toString());
        }
        Map<String, Object> properties = new HashMap<>();
        properties.put("model", request.getModel());
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(properties), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), TicketResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a <code>Ticket</code> object with the given <code>id</code>.
     */
    public Ticket retrieve(String id) {
        return retrieve(id, TicketsRetrieveRequest.builder().build());
    }

    /**
     * Returns a <code>Ticket</code> object with the given <code>id</code>.
     */
    public Ticket retrieve(String id, TicketsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns a <code>Ticket</code> object with the given <code>id</code>.
     */
    public Ticket retrieve(String id, TicketsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/tickets")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getIncludeRemoteFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_fields",
                    request.getIncludeRemoteFields().get().toString());
        }
        if (request.getRemoteFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get().toString());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Ticket.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates a <code>Ticket</code> object with the given <code>id</code>.
     */
    public TicketResponse partialUpdate(String id, PatchedTicketEndpointRequest request) {
        return partialUpdate(id, request, null);
    }

    /**
     * Updates a <code>Ticket</code> object with the given <code>id</code>.
     */
    public TicketResponse partialUpdate(
            String id, PatchedTicketEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/tickets")
                .addPathSegment(id);
        if (request.getIsDebugMode().isPresent()) {
            httpUrl.addQueryParameter(
                    "is_debug_mode", request.getIsDebugMode().get().toString());
        }
        if (request.getRunAsync().isPresent()) {
            httpUrl.addQueryParameter("run_async", request.getRunAsync().get().toString());
        }
        Map<String, Object> properties = new HashMap<>();
        properties.put("model", request.getModel());
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(properties), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("PATCH", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), TicketResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a list of <code>User</code> objects.
     */
    public PaginatedUserList collaboratorsList(String parentId) {
        return collaboratorsList(
                parentId, TicketsCollaboratorsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>User</code> objects.
     */
    public PaginatedUserList collaboratorsList(String parentId, TicketsCollaboratorsListRequest request) {
        return collaboratorsList(parentId, request, null);
    }

    /**
     * Returns a list of <code>User</code> objects.
     */
    public PaginatedUserList collaboratorsList(
            String parentId, TicketsCollaboratorsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/tickets")
                .addPathSegment(parentId)
                .addPathSegments("collaborators");
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeDeletedData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), PaginatedUserList.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns metadata for <code>Ticket</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id) {
        return metaPatchRetrieve(id, null);
    }

    /**
     * Returns metadata for <code>Ticket</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/tickets/meta/patch")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), MetaResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns metadata for <code>Ticket</code> POSTs.
     */
    public MetaResponse metaPostRetrieve() {
        return metaPostRetrieve(null);
    }

    /**
     * Returns metadata for <code>Ticket</code> POSTs.
     */
    public MetaResponse metaPostRetrieve(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/tickets/meta/post")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), MetaResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public PaginatedRemoteFieldClassList remoteFieldClassesList() {
        return remoteFieldClassesList(
                TicketsRemoteFieldClassesListRequest.builder().build());
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public PaginatedRemoteFieldClassList remoteFieldClassesList(TicketsRemoteFieldClassesListRequest request) {
        return remoteFieldClassesList(request, null);
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public PaginatedRemoteFieldClassList remoteFieldClassesList(
            TicketsRemoteFieldClassesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/tickets/remote-field-classes");
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getIncludeDeletedData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        response.body().string(), PaginatedRemoteFieldClassList.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

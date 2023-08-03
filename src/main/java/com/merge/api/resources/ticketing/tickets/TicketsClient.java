package com.merge.api.resources.ticketing.tickets;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
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
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TicketsClient {
    protected final ClientOptions clientOptions;

    public TicketsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedTicketList list(TicketsListRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ticketing/v1/tickets");
        if (request.getAccountId().isPresent()) {
            _httpUrl.addQueryParameter("account_id", request.getAccountId().get());
        }
        if (request.getAssigneeIds().isPresent()) {
            _httpUrl.addQueryParameter("assignee_ids", request.getAssigneeIds().get());
        }
        if (request.getCollectionIds().isPresent()) {
            _httpUrl.addQueryParameter(
                    "collection_ids", request.getCollectionIds().get());
        }
        if (request.getCompletedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "completed_after", request.getCompletedAfter().get().toString());
        }
        if (request.getCompletedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "completed_before", request.getCompletedBefore().get().toString());
        }
        if (request.getContactId().isPresent()) {
            _httpUrl.addQueryParameter("contact_id", request.getContactId().get());
        }
        if (request.getCreatedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "created_after", request.getCreatedAfter().get().toString());
        }
        if (request.getCreatedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "created_before", request.getCreatedBefore().get().toString());
        }
        if (request.getCursor().isPresent()) {
            _httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getDueAfter().isPresent()) {
            _httpUrl.addQueryParameter("due_after", request.getDueAfter().get().toString());
        }
        if (request.getDueBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "due_before", request.getDueBefore().get().toString());
        }
        if (request.getExpand().isPresent()) {
            _httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeDeletedData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getIncludeRemoteFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_fields",
                    request.getIncludeRemoteFields().get().toString());
        }
        if (request.getModifiedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "modified_after", request.getModifiedAfter().get().toString());
        }
        if (request.getModifiedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "modified_before", request.getModifiedBefore().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            _httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getParentTicketId().isPresent()) {
            _httpUrl.addQueryParameter(
                    "parent_ticket_id", request.getParentTicketId().get());
        }
        if (request.getPriority().isPresent()) {
            _httpUrl.addQueryParameter("priority", request.getPriority().get().toString());
        }
        if (request.getProjectId().isPresent()) {
            _httpUrl.addQueryParameter("project_id", request.getProjectId().get());
        }
        if (request.getRemoteCreatedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_created_after",
                    request.getRemoteCreatedAfter().get().toString());
        }
        if (request.getRemoteCreatedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_created_before",
                    request.getRemoteCreatedBefore().get().toString());
        }
        if (request.getRemoteFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get().toString());
        }
        if (request.getRemoteId().isPresent()) {
            _httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
        }
        if (request.getRemoteUpdatedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_updated_after",
                    request.getRemoteUpdatedAfter().get().toString());
        }
        if (request.getRemoteUpdatedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_updated_before",
                    request.getRemoteUpdatedBefore().get().toString());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            _httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get().toString());
        }
        if (request.getStatus().isPresent()) {
            _httpUrl.addQueryParameter("status", request.getStatus().get().toString());
        }
        if (request.getTags().isPresent()) {
            _httpUrl.addQueryParameter("tags", request.getTags().get());
        }
        if (request.getTicketType().isPresent()) {
            _httpUrl.addQueryParameter("ticket_type", request.getTicketType().get());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PaginatedTicketList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TicketResponse create(TicketEndpointRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ticketing/v1/tickets");
        if (request.getIsDebugMode().isPresent()) {
            _httpUrl.addQueryParameter(
                    "is_debug_mode", request.getIsDebugMode().get().toString());
        }
        if (request.getRunAsync().isPresent()) {
            _httpUrl.addQueryParameter("run_async", request.getRunAsync().get().toString());
        }
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("model", request.getModel());
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), TicketResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Ticket retrieve(String id, TicketsRetrieveRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ticketing/v1/tickets")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            _httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getIncludeRemoteFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_fields",
                    request.getIncludeRemoteFields().get().toString());
        }
        if (request.getRemoteFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get().toString());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            _httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Ticket.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TicketResponse partialUpdate(String id, PatchedTicketEndpointRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ticketing/v1/tickets")
                .addPathSegment(id);
        if (request.getIsDebugMode().isPresent()) {
            _httpUrl.addQueryParameter(
                    "is_debug_mode", request.getIsDebugMode().get().toString());
        }
        if (request.getRunAsync().isPresent()) {
            _httpUrl.addQueryParameter("run_async", request.getRunAsync().get().toString());
        }
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("model", request.getModel());
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("PATCH", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), TicketResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PaginatedUserList collaboratorsList(String parentId, TicketsCollaboratorsListRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ticketing/v1/tickets")
                .addPathSegment(parentId)
                .addPathSegments("collaborators");
        if (request.getCursor().isPresent()) {
            _httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getExpand().isPresent()) {
            _httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeDeletedData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            _httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PaginatedUserList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MetaResponse metaPatchRetrieve(String id) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ticketing/v1/tickets/meta/patch")
                .addPathSegment(id)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), MetaResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MetaResponse metaPostRetrieve() {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ticketing/v1/tickets/meta/post")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), MetaResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PaginatedRemoteFieldClassList remoteFieldClassesList(TicketsRemoteFieldClassesListRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ticketing/v1/tickets/remote-field-classes");
        if (request.getCursor().isPresent()) {
            _httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getIncludeDeletedData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            _httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), PaginatedRemoteFieldClassList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

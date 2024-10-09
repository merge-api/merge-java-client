/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ticketing.attachments;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MediaTypes;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.ticketing.attachments.requests.AttachmentsDownloadRetrieveRequest;
import com.merge.api.resources.ticketing.attachments.requests.AttachmentsListRequest;
import com.merge.api.resources.ticketing.attachments.requests.AttachmentsRetrieveRequest;
import com.merge.api.resources.ticketing.attachments.requests.TicketingAttachmentEndpointRequest;
import com.merge.api.resources.ticketing.types.Attachment;
import com.merge.api.resources.ticketing.types.MetaResponse;
import com.merge.api.resources.ticketing.types.PaginatedAttachmentList;
import com.merge.api.resources.ticketing.types.TicketingAttachmentResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AttachmentsClient {
    protected final ClientOptions clientOptions;

    public AttachmentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>Attachment</code> objects.
     */
    public PaginatedAttachmentList list() {
        return list(AttachmentsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>Attachment</code> objects.
     */
    public PaginatedAttachmentList list(AttachmentsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>Attachment</code> objects.
     */
    public PaginatedAttachmentList list(AttachmentsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/attachments");
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
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get());
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
        if (request.getIncludeShellData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_shell_data", request.getIncludeShellData().get().toString());
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
        if (request.getRemoteCreatedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_created_after",
                    request.getRemoteCreatedAfter().get().toString());
        }
        if (request.getRemoteId().isPresent()) {
            httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
        }
        if (request.getTicketId().isPresent()) {
            httpUrl.addQueryParameter("ticket_id", request.getTicketId().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedAttachmentList.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }

    /**
     * Creates an <code>Attachment</code> object with the given values.
     */
    public TicketingAttachmentResponse create(TicketingAttachmentEndpointRequest request) {
        return create(request, null);
    }

    /**
     * Creates an <code>Attachment</code> object with the given values.
     */
    public TicketingAttachmentResponse create(
            TicketingAttachmentEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/attachments");
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
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), TicketingAttachmentResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }

    /**
     * Returns an <code>Attachment</code> object with the given <code>id</code>.
     */
    public Attachment retrieve(String id) {
        return retrieve(id, AttachmentsRetrieveRequest.builder().build());
    }

    /**
     * Returns an <code>Attachment</code> object with the given <code>id</code>.
     */
    public Attachment retrieve(String id, AttachmentsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns an <code>Attachment</code> object with the given <code>id</code>.
     */
    public Attachment retrieve(String id, AttachmentsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/attachments")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Attachment.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }

    /**
     * Returns the <code>File</code> content with the given <code>id</code> as a stream of bytes.
     */
    public InputStream downloadRetrieve(String id) {
        return downloadRetrieve(id, AttachmentsDownloadRetrieveRequest.builder().build());
    }

    /**
     * Returns the <code>File</code> content with the given <code>id</code> as a stream of bytes.
     */
    public InputStream downloadRetrieve(String id, AttachmentsDownloadRetrieveRequest request) {
        return downloadRetrieve(id, request, null);
    }

    /**
     * Returns the <code>File</code> content with the given <code>id</code> as a stream of bytes.
     */
    public InputStream downloadRetrieve(
            String id, AttachmentsDownloadRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/attachments")
                .addPathSegment(id)
                .addPathSegments("download");
        if (request.getMimeType().isPresent()) {
            httpUrl.addQueryParameter("mime_type", request.getMimeType().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return responseBody.byteStream();
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }

    /**
     * Returns metadata for <code>TicketingAttachment</code> POSTs.
     */
    public MetaResponse metaPostRetrieve() {
        return metaPostRetrieve(null);
    }

    /**
     * Returns metadata for <code>TicketingAttachment</code> POSTs.
     */
    public MetaResponse metaPostRetrieve(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ticketing/v1/attachments/meta/post")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), MetaResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }
}

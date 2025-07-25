/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting;

import com.merge.api.accounting.types.AccountingAttachment;
import com.merge.api.accounting.types.AccountingAttachmentEndpointRequest;
import com.merge.api.accounting.types.AccountingAttachmentResponse;
import com.merge.api.accounting.types.AttachmentsListRequest;
import com.merge.api.accounting.types.AttachmentsRetrieveRequest;
import com.merge.api.accounting.types.MetaResponse;
import com.merge.api.accounting.types.PaginatedAccountingAttachmentList;
import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MediaTypes;
import com.merge.api.core.MergeApiHttpResponse;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.QueryStringMapper;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RawAttachmentsClient {
    protected final ClientOptions clientOptions;

    public RawAttachmentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>AccountingAttachment</code> objects.
     */
    public MergeApiHttpResponse<SyncPagingIterable<AccountingAttachment>> list() {
        return list(AttachmentsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>AccountingAttachment</code> objects.
     */
    public MergeApiHttpResponse<SyncPagingIterable<AccountingAttachment>> list(AttachmentsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>AccountingAttachment</code> objects.
     */
    public MergeApiHttpResponse<SyncPagingIterable<AccountingAttachment>> list(
            AttachmentsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/attachments");
        if (request.getCompanyId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "company_id", request.getCompanyId().get(), false);
        }
        if (request.getCreatedAfter().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "created_after", request.getCreatedAfter().get().toString(), false);
        }
        if (request.getCreatedBefore().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "created_before", request.getCreatedBefore().get().toString(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getIncludeDeletedData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString(),
                    false);
        }
        if (request.getIncludeRemoteData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_remote_data",
                    request.getIncludeRemoteData().get().toString(),
                    false);
        }
        if (request.getIncludeShellData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_shell_data",
                    request.getIncludeShellData().get().toString(),
                    false);
        }
        if (request.getModifiedAfter().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "modified_after", request.getModifiedAfter().get().toString(), false);
        }
        if (request.getModifiedBefore().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "modified_before",
                    request.getModifiedBefore().get().toString(),
                    false);
        }
        if (request.getPageSize().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "page_size", request.getPageSize().get().toString(), false);
        }
        if (request.getRemoteId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "remote_id", request.getRemoteId().get(), false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                PaginatedAccountingAttachmentList parsedResponse = ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), PaginatedAccountingAttachmentList.class);
                Optional<String> startingAfter = parsedResponse.getNext();
                AttachmentsListRequest nextRequest = AttachmentsListRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<AccountingAttachment> result = parsedResponse.getResults().orElse(Collections.emptyList());
                return new MergeApiHttpResponse<>(
                        new SyncPagingIterable<AccountingAttachment>(
                                startingAfter.isPresent(), result, () -> list(nextRequest, requestOptions)
                                        .body()),
                        response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }

    /**
     * Creates an <code>AccountingAttachment</code> object with the given values.
     */
    public MergeApiHttpResponse<AccountingAttachmentResponse> create(AccountingAttachmentEndpointRequest request) {
        return create(request, null);
    }

    /**
     * Creates an <code>AccountingAttachment</code> object with the given values.
     */
    public MergeApiHttpResponse<AccountingAttachmentResponse> create(
            AccountingAttachmentEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/attachments");
        if (request.getIsDebugMode().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "is_debug_mode", request.getIsDebugMode().get().toString(), false);
        }
        if (request.getRunAsync().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "run_async", request.getRunAsync().get().toString(), false);
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
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new MergeApiHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), AccountingAttachmentResponse.class),
                        response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }

    /**
     * Returns an <code>AccountingAttachment</code> object with the given <code>id</code>.
     */
    public MergeApiHttpResponse<AccountingAttachment> retrieve(String id) {
        return retrieve(id, AttachmentsRetrieveRequest.builder().build());
    }

    /**
     * Returns an <code>AccountingAttachment</code> object with the given <code>id</code>.
     */
    public MergeApiHttpResponse<AccountingAttachment> retrieve(String id, AttachmentsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns an <code>AccountingAttachment</code> object with the given <code>id</code>.
     */
    public MergeApiHttpResponse<AccountingAttachment> retrieve(
            String id, AttachmentsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/attachments")
                .addPathSegment(id);
        if (request.getIncludeRemoteData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_remote_data",
                    request.getIncludeRemoteData().get().toString(),
                    false);
        }
        if (request.getIncludeShellData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_shell_data",
                    request.getIncludeShellData().get().toString(),
                    false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new MergeApiHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), AccountingAttachment.class),
                        response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }

    /**
     * Returns metadata for <code>AccountingAttachment</code> POSTs.
     */
    public MergeApiHttpResponse<MetaResponse> metaPostRetrieve() {
        return metaPostRetrieve(null);
    }

    /**
     * Returns metadata for <code>AccountingAttachment</code> POSTs.
     */
    public MergeApiHttpResponse<MetaResponse> metaPostRetrieve(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/attachments/meta/post")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new MergeApiHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), MetaResponse.class), response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }
}

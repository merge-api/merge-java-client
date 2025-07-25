/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats;

import com.merge.api.ats.types.Eeoc;
import com.merge.api.ats.types.EeocsListRequest;
import com.merge.api.ats.types.EeocsRetrieveRequest;
import com.merge.api.ats.types.PaginatedEeocList;
import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeApiHttpResponse;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.QueryStringMapper;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RawEeocsClient {
    protected final ClientOptions clientOptions;

    public RawEeocsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>EEOC</code> objects.
     */
    public MergeApiHttpResponse<SyncPagingIterable<Eeoc>> list() {
        return list(EeocsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>EEOC</code> objects.
     */
    public MergeApiHttpResponse<SyncPagingIterable<Eeoc>> list(EeocsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>EEOC</code> objects.
     */
    public MergeApiHttpResponse<SyncPagingIterable<Eeoc>> list(
            EeocsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ats/v1/eeocs");
        if (request.getCandidateId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "candidate_id", request.getCandidateId().get(), false);
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
        if (request.getRemoteFields().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "remote_fields", request.getRemoteFields().get().toString(), false);
        }
        if (request.getRemoteId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "remote_id", request.getRemoteId().get(), false);
        }
        if (request.getShowEnumOrigins().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "show_enum_origins",
                    request.getShowEnumOrigins().get().toString(),
                    false);
        }
        if (request.getExpand().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "expand", request.getExpand().get().toString(), false);
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
                PaginatedEeocList parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedEeocList.class);
                Optional<String> startingAfter = parsedResponse.getNext();
                EeocsListRequest nextRequest = EeocsListRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<Eeoc> result = parsedResponse.getResults().orElse(Collections.emptyList());
                return new MergeApiHttpResponse<>(
                        new SyncPagingIterable<Eeoc>(
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
     * Returns an <code>EEOC</code> object with the given <code>id</code>.
     */
    public MergeApiHttpResponse<Eeoc> retrieve(String id) {
        return retrieve(id, EeocsRetrieveRequest.builder().build());
    }

    /**
     * Returns an <code>EEOC</code> object with the given <code>id</code>.
     */
    public MergeApiHttpResponse<Eeoc> retrieve(String id, EeocsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns an <code>EEOC</code> object with the given <code>id</code>.
     */
    public MergeApiHttpResponse<Eeoc> retrieve(String id, EeocsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ats/v1/eeocs")
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
        if (request.getRemoteFields().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "remote_fields", request.getRemoteFields().get().toString(), false);
        }
        if (request.getShowEnumOrigins().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "show_enum_origins",
                    request.getShowEnumOrigins().get().toString(),
                    false);
        }
        if (request.getExpand().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "expand", request.getExpand().get().toString(), false);
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
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Eeoc.class), response);
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

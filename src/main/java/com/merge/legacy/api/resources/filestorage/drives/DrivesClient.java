/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.filestorage.drives;

import com.merge.legacy.api.core.*;
import com.merge.legacy.api.resources.filestorage.drives.requests.DrivesListRequest;
import com.merge.legacy.api.resources.filestorage.drives.requests.DrivesRetrieveRequest;
import com.merge.legacy.api.resources.filestorage.types.Drive;
import com.merge.legacy.api.resources.filestorage.types.PaginatedDriveList;
import java.io.IOException;
import okhttp3.*;

public class DrivesClient {
    protected final ClientOptions clientOptions;

    public DrivesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>Drive</code> objects.
     */
    public PaginatedDriveList list() {
        return list(DrivesListRequest.builder().build());
    }

    /**
     * Returns a list of <code>Drive</code> objects.
     */
    public PaginatedDriveList list(DrivesListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>Drive</code> objects.
     */
    public PaginatedDriveList list(DrivesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("filestorage/v1/drives");
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
        if (request.getName().isPresent()) {
            httpUrl.addQueryParameter("name", request.getName().get());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getRemoteId().isPresent()) {
            httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedDriveList.class);
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
     * Returns a <code>Drive</code> object with the given <code>id</code>.
     */
    public Drive retrieve(String id) {
        return retrieve(id, DrivesRetrieveRequest.builder().build());
    }

    /**
     * Returns a <code>Drive</code> object with the given <code>id</code>.
     */
    public Drive retrieve(String id, DrivesRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns a <code>Drive</code> object with the given <code>id</code>.
     */
    public Drive retrieve(String id, DrivesRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("filestorage/v1/drives")
                .addPathSegment(id);
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Drive.class);
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

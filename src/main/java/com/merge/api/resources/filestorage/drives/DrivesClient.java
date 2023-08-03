package com.merge.api.resources.filestorage.drives;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.filestorage.drives.requests.DrivesListRequest;
import com.merge.api.resources.filestorage.drives.requests.DrivesRetrieveRequest;
import com.merge.api.resources.filestorage.types.Drive;
import com.merge.api.resources.filestorage.types.PaginatedDriveList;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DrivesClient {
    protected final ClientOptions clientOptions;

    public DrivesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedDriveList list(DrivesListRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/filestorage/v1/drives");
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
        if (request.getIncludeDeletedData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getModifiedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "modified_after", request.getModifiedAfter().get().toString());
        }
        if (request.getModifiedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "modified_before", request.getModifiedBefore().get().toString());
        }
        if (request.getName().isPresent()) {
            _httpUrl.addQueryParameter("name", request.getName().get());
        }
        if (request.getPageSize().isPresent()) {
            _httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getRemoteId().isPresent()) {
            _httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PaginatedDriveList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Drive retrieve(String id, DrivesRetrieveRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/filestorage/v1/drives")
                .addPathSegment(id);
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Drive.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

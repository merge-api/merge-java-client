package com.merge.api.resources.crm.syncstatus;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.crm.syncstatus.requests.SyncStatusListRequest;
import com.merge.api.resources.crm.types.PaginatedSyncStatusList;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SyncStatusClient {
    protected final ClientOptions clientOptions;

    public SyncStatusClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedSyncStatusList list(SyncStatusListRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/crm/v1/sync-status");
        if (request.getCursor().isPresent()) {
            _httpUrl.addQueryParameter("cursor", request.getCursor().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PaginatedSyncStatusList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.merge.api.resources.crm.forceresync;

import com.fasterxml.jackson.core.type.TypeReference;
import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.crm.types.SyncStatus;
import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ForceResyncClient {
    protected final ClientOptions clientOptions;

    public ForceResyncClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public List<SyncStatus> syncStatusResyncCreate() {
        return syncStatusResyncCreate(null);
    }

    public List<SyncStatus> syncStatusResyncCreate(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("sync-status/resync")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<SyncStatus>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

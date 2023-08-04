package com.merge.api.resources.ats.forceresync;

import com.fasterxml.jackson.core.type.TypeReference;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.ats.types.SyncStatus;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
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
                .addPathSegments("api/ats/v1/sync-status/resync")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<SyncStatus>>() {});
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

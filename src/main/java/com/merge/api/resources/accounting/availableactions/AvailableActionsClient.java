package com.merge.api.resources.accounting.availableactions;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.accounting.types.AvailableActions;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class AvailableActionsClient {
    protected final ClientOptions clientOptions;

    public AvailableActionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public AvailableActions retrieve() {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/accounting/v1/available-actions")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AvailableActions.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

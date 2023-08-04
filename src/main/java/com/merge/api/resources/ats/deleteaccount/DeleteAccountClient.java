package com.merge.api.resources.ats.deleteaccount;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class DeleteAccountClient {
    protected final ClientOptions clientOptions;

    public DeleteAccountClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public void create() {
        create(null);
    }

    public void create(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ats/v1/delete-account")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return;
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

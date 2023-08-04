package com.merge.api.resources.accounting.accounttoken;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.accounting.types.AccountToken;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class AccountTokenClient {
    protected final ClientOptions clientOptions;

    public AccountTokenClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public AccountToken retrieve(String publicToken) {
        return retrieve(publicToken, null);
    }

    public AccountToken retrieve(String publicToken, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/accounting/v1/account-token")
                .addPathSegment(publicToken)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AccountToken.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

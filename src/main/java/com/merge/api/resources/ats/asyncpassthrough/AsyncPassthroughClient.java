package com.merge.api.resources.ats.asyncpassthrough;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.ats.types.AsyncPassthroughReciept;
import com.merge.api.resources.ats.types.DataPassthroughRequest;
import com.merge.api.resources.ats.types.RemoteResponse;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AsyncPassthroughClient {
    protected final ClientOptions clientOptions;

    public AsyncPassthroughClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public AsyncPassthroughReciept create(DataPassthroughRequest request) {
        return create(request, null);
    }

    public AsyncPassthroughReciept create(DataPassthroughRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ats/v1/async-passthrough")
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AsyncPassthroughReciept.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public RemoteResponse retrieve(String asyncPassthroughReceiptId) {
        return retrieve(asyncPassthroughReceiptId, null);
    }

    public RemoteResponse retrieve(String asyncPassthroughReceiptId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ats/v1/async-passthrough")
                .addPathSegment(asyncPassthroughReceiptId)
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), RemoteResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

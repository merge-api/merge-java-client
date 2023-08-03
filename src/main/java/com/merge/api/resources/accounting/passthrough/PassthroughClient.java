package com.merge.api.resources.accounting.passthrough;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.accounting.passthrough.requests.DataPassthroughRequest;
import com.merge.api.resources.accounting.types.RemoteResponse;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PassthroughClient {
    protected final ClientOptions clientOptions;

    public PassthroughClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public RemoteResponse create(DataPassthroughRequest request) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/accounting/v1/passthrough")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("method", request.getMethod());
        _requestBodyProperties.put("path", request.getPath());
        if (request.getBaseUrlOverride().isPresent()) {
            _requestBodyProperties.put("base_url_override", request.getBaseUrlOverride());
        }
        if (request.getData().isPresent()) {
            _requestBodyProperties.put("data", request.getData());
        }
        if (request.getMultipartFormData().isPresent()) {
            _requestBodyProperties.put("multipart_form_data", request.getMultipartFormData());
        }
        if (request.getHeaders().isPresent()) {
            _requestBodyProperties.put("headers", request.getHeaders());
        }
        if (request.getRequestFormat().isPresent()) {
            _requestBodyProperties.put("request_format", request.getRequestFormat());
        }
        if (request.getNormalizeResponse().isPresent()) {
            _requestBodyProperties.put("normalize_response", request.getNormalizeResponse());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
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

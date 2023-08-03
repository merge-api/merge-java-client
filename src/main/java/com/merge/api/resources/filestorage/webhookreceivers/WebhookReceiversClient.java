package com.merge.api.resources.filestorage.webhookreceivers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.filestorage.types.WebhookReceiver;
import com.merge.api.resources.filestorage.webhookreceivers.requests.WebhookReceiverRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebhookReceiversClient {
    protected final ClientOptions clientOptions;

    public WebhookReceiversClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public List<WebhookReceiver> list() {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/filestorage/v1/webhook-receivers")
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<WebhookReceiver>>() {});
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WebhookReceiver create(WebhookReceiverRequest request) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/filestorage/v1/webhook-receivers")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("event", request.getEvent());
        _requestBodyProperties.put("is_active", request.getIsActive());
        if (request.getKey().isPresent()) {
            _requestBodyProperties.put("key", request.getKey());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), WebhookReceiver.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

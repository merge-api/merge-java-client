package com.merge.api.resources.filestorage.linktoken;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.filestorage.linktoken.requests.EndUserDetailsRequest;
import com.merge.api.resources.filestorage.types.LinkToken;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LinkTokenClient {
    protected final ClientOptions clientOptions;

    public LinkTokenClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public LinkToken create(EndUserDetailsRequest request) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/filestorage/v1/link-token")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("end_user_email_address", request.getEndUserEmailAddress());
        _requestBodyProperties.put("end_user_organization_name", request.getEndUserOrganizationName());
        _requestBodyProperties.put("end_user_origin_id", request.getEndUserOriginId());
        _requestBodyProperties.put("categories", request.getCategories());
        if (request.getIntegration().isPresent()) {
            _requestBodyProperties.put("integration", request.getIntegration());
        }
        if (request.getLinkExpiryMins().isPresent()) {
            _requestBodyProperties.put("link_expiry_mins", request.getLinkExpiryMins());
        }
        if (request.getShouldCreateMagicLinkUrl().isPresent()) {
            _requestBodyProperties.put("should_create_magic_link_url", request.getShouldCreateMagicLinkUrl());
        }
        if (request.getCommonModels().isPresent()) {
            _requestBodyProperties.put("common_models", request.getCommonModels());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), LinkToken.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

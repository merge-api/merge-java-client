package com.merge.api.resources.ats.linkedaccounts;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.ats.linkedaccounts.requests.LinkedAccountsListRequest;
import com.merge.api.resources.ats.types.PaginatedAccountDetailsAndActionsList;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LinkedAccountsClient {
    protected final ClientOptions clientOptions;

    public LinkedAccountsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedAccountDetailsAndActionsList list(LinkedAccountsListRequest request) {
        return list(request, null);
    }

    public PaginatedAccountDetailsAndActionsList list(
            LinkedAccountsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ats/v1/linked-accounts");
        if (request.getCategory().isPresent()) {
            _httpUrl.addQueryParameter("category", request.getCategory().get().toString());
        }
        if (request.getCursor().isPresent()) {
            _httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getEndUserEmailAddress().isPresent()) {
            _httpUrl.addQueryParameter(
                    "end_user_email_address", request.getEndUserEmailAddress().get());
        }
        if (request.getEndUserOrganizationName().isPresent()) {
            _httpUrl.addQueryParameter(
                    "end_user_organization_name",
                    request.getEndUserOrganizationName().get());
        }
        if (request.getEndUserOriginId().isPresent()) {
            _httpUrl.addQueryParameter(
                    "end_user_origin_id", request.getEndUserOriginId().get());
        }
        if (request.getEndUserOriginIds().isPresent()) {
            _httpUrl.addQueryParameter(
                    "end_user_origin_ids", request.getEndUserOriginIds().get());
        }
        if (request.getId().isPresent()) {
            _httpUrl.addQueryParameter("id", request.getId().get());
        }
        if (request.getIds().isPresent()) {
            _httpUrl.addQueryParameter("ids", request.getIds().get());
        }
        if (request.getIncludeDuplicates().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_duplicates", request.getIncludeDuplicates().get().toString());
        }
        if (request.getIntegrationName().isPresent()) {
            _httpUrl.addQueryParameter(
                    "integration_name", request.getIntegrationName().get());
        }
        if (request.getIsTestAccount().isPresent()) {
            _httpUrl.addQueryParameter(
                    "is_test_account", request.getIsTestAccount().get());
        }
        if (request.getPageSize().isPresent()) {
            _httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getStatus().isPresent()) {
            _httpUrl.addQueryParameter("status", request.getStatus().get());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), PaginatedAccountDetailsAndActionsList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.filestorage.linkedaccounts;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.filestorage.linkedaccounts.requests.LinkedAccountsListRequest;
import com.merge.api.resources.filestorage.types.PaginatedAccountDetailsAndActionsList;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LinkedAccountsClient {
    protected final ClientOptions clientOptions;

    public LinkedAccountsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * List linked accounts for your organization.
     */
    public PaginatedAccountDetailsAndActionsList list() {
        return list(LinkedAccountsListRequest.builder().build());
    }

    /**
     * List linked accounts for your organization.
     */
    public PaginatedAccountDetailsAndActionsList list(LinkedAccountsListRequest request) {
        return list(request, null);
    }

    /**
     * List linked accounts for your organization.
     */
    public PaginatedAccountDetailsAndActionsList list(
            LinkedAccountsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("filestorage/v1/linked-accounts");
        if (request.getCategory().isPresent()) {
            httpUrl.addQueryParameter("category", request.getCategory().get().toString());
        }
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getEndUserEmailAddress().isPresent()) {
            httpUrl.addQueryParameter(
                    "end_user_email_address", request.getEndUserEmailAddress().get());
        }
        if (request.getEndUserOrganizationName().isPresent()) {
            httpUrl.addQueryParameter(
                    "end_user_organization_name",
                    request.getEndUserOrganizationName().get());
        }
        if (request.getEndUserOriginId().isPresent()) {
            httpUrl.addQueryParameter(
                    "end_user_origin_id", request.getEndUserOriginId().get());
        }
        if (request.getEndUserOriginIds().isPresent()) {
            httpUrl.addQueryParameter(
                    "end_user_origin_ids", request.getEndUserOriginIds().get());
        }
        if (request.getId().isPresent()) {
            httpUrl.addQueryParameter("id", request.getId().get());
        }
        if (request.getIds().isPresent()) {
            httpUrl.addQueryParameter("ids", request.getIds().get());
        }
        if (request.getIncludeDuplicates().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_duplicates", request.getIncludeDuplicates().get().toString());
        }
        if (request.getIntegrationName().isPresent()) {
            httpUrl.addQueryParameter(
                    "integration_name", request.getIntegrationName().get());
        }
        if (request.getIsTestAccount().isPresent()) {
            httpUrl.addQueryParameter(
                    "is_test_account", request.getIsTestAccount().get());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getStatus().isPresent()) {
            httpUrl.addQueryParameter("status", request.getStatus().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .addHeader("Accept", "application/json")
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), PaginatedAccountDetailsAndActionsList.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }
}

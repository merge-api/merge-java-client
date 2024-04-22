/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.crm.scopes;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MediaTypes;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.crm.scopes.requests.LinkedAccountCommonModelScopeDeserializerRequest;
import com.merge.api.resources.crm.types.CommonModelScopeApi;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ScopesClient {
    protected final ClientOptions clientOptions;

    public ScopesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Get the default permissions for Merge Common Models and fields across all Linked Accounts of a given category. <a href="https://help.merge.dev/en/articles/8828211-common-model-and-field-scopes">Learn more</a>.
     */
    public CommonModelScopeApi defaultScopesRetrieve() {
        return defaultScopesRetrieve(null);
    }

    /**
     * Get the default permissions for Merge Common Models and fields across all Linked Accounts of a given category. <a href="https://help.merge.dev/en/articles/8828211-common-model-and-field-scopes">Learn more</a>.
     */
    public CommonModelScopeApi defaultScopesRetrieve(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("crm/v1/default-scopes")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), CommonModelScopeApi.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get all available permissions for Merge Common Models and fields for a single Linked Account. <a href="https://help.merge.dev/en/articles/8828211-common-model-and-field-scopes">Learn more</a>.
     */
    public CommonModelScopeApi linkedAccountScopesRetrieve() {
        return linkedAccountScopesRetrieve(null);
    }

    /**
     * Get all available permissions for Merge Common Models and fields for a single Linked Account. <a href="https://help.merge.dev/en/articles/8828211-common-model-and-field-scopes">Learn more</a>.
     */
    public CommonModelScopeApi linkedAccountScopesRetrieve(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("crm/v1/linked-account-scopes")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), CommonModelScopeApi.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update permissions for any Common Model or field for a single Linked Account. Any Scopes not set in this POST request will inherit the default Scopes. <a href="https://help.merge.dev/en/articles/8828211-common-model-and-field-scopes">Learn more</a>
     */
    public CommonModelScopeApi linkedAccountScopesCreate(LinkedAccountCommonModelScopeDeserializerRequest request) {
        return linkedAccountScopesCreate(request, null);
    }

    /**
     * Update permissions for any Common Model or field for a single Linked Account. Any Scopes not set in this POST request will inherit the default Scopes. <a href="https://help.merge.dev/en/articles/8828211-common-model-and-field-scopes">Learn more</a>
     */
    public CommonModelScopeApi linkedAccountScopesCreate(
            LinkedAccountCommonModelScopeDeserializerRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("crm/v1/linked-account-scopes")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), CommonModelScopeApi.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

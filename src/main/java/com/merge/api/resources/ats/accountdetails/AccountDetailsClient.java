/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ats.accountdetails;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeApiApiError;
import com.merge.api.core.MergeApiError;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.ats.types.AccountDetails;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AccountDetailsClient {
    protected final ClientOptions clientOptions;

    public AccountDetailsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Get details for a linked account.
     */
    public AccountDetails retrieve() {
        return retrieve(null);
    }

    /**
     * Get details for a linked account.
     */
    public AccountDetails retrieve(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("ats/v1/account-details")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), AccountDetails.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new MergeApiApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new MergeApiError("Network error executing HTTP request", e);
        }
    }
}

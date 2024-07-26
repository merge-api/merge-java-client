/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.phonenumbers;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.accounting.phonenumbers.requests.PhoneNumbersRetrieveRequest;
import com.merge.api.resources.accounting.types.AccountingPhoneNumber;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class PhoneNumbersClient {
    protected final ClientOptions clientOptions;

    public PhoneNumbersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns an <code>AccountingPhoneNumber</code> object with the given <code>id</code>.
     */
    public AccountingPhoneNumber retrieve(String id) {
        return retrieve(id, PhoneNumbersRetrieveRequest.builder().build());
    }

    /**
     * Returns an <code>AccountingPhoneNumber</code> object with the given <code>id</code>.
     */
    public AccountingPhoneNumber retrieve(String id, PhoneNumbersRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns an <code>AccountingPhoneNumber</code> object with the given <code>id</code>.
     */
    public AccountingPhoneNumber retrieve(
            String id, PhoneNumbersRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/phone-numbers")
                .addPathSegment(id);
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), AccountingPhoneNumber.class);
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

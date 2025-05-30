/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.accounting.accountingperiods;

import com.merge.legacy.api.core.*;
import com.merge.legacy.api.resources.accounting.accountingperiods.requests.AccountingPeriodsListRequest;
import com.merge.legacy.api.resources.accounting.accountingperiods.requests.AccountingPeriodsRetrieveRequest;
import com.merge.legacy.api.resources.accounting.types.AccountingPeriod;
import com.merge.legacy.api.resources.accounting.types.PaginatedAccountingPeriodList;
import java.io.IOException;
import okhttp3.*;

public class AccountingPeriodsClient {
    protected final ClientOptions clientOptions;

    public AccountingPeriodsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>AccountingPeriod</code> objects.
     */
    public PaginatedAccountingPeriodList list() {
        return list(AccountingPeriodsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>AccountingPeriod</code> objects.
     */
    public PaginatedAccountingPeriodList list(AccountingPeriodsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>AccountingPeriod</code> objects.
     */
    public PaginatedAccountingPeriodList list(AccountingPeriodsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/accounting-periods");
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getIncludeDeletedData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getIncludeShellData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_shell_data", request.getIncludeShellData().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedAccountingPeriodList.class);
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

    /**
     * Returns an <code>AccountingPeriod</code> object with the given <code>id</code>.
     */
    public AccountingPeriod retrieve(String id) {
        return retrieve(id, AccountingPeriodsRetrieveRequest.builder().build());
    }

    /**
     * Returns an <code>AccountingPeriod</code> object with the given <code>id</code>.
     */
    public AccountingPeriod retrieve(String id, AccountingPeriodsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns an <code>AccountingPeriod</code> object with the given <code>id</code>.
     */
    public AccountingPeriod retrieve(
            String id, AccountingPeriodsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/accounting-periods")
                .addPathSegment(id);
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), AccountingPeriod.class);
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

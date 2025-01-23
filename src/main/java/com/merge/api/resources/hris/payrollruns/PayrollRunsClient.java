/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.hris.payrollruns;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.hris.payrollruns.requests.PayrollRunsListRequest;
import com.merge.api.resources.hris.payrollruns.requests.PayrollRunsRetrieveRequest;
import com.merge.api.resources.hris.types.PaginatedPayrollRunList;
import com.merge.api.resources.hris.types.PayrollRun;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class PayrollRunsClient {
    protected final ClientOptions clientOptions;

    public PayrollRunsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>PayrollRun</code> objects.
     */
    public PaginatedPayrollRunList list() {
        return list(PayrollRunsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>PayrollRun</code> objects.
     */
    public PaginatedPayrollRunList list(PayrollRunsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>PayrollRun</code> objects.
     */
    public PaginatedPayrollRunList list(PayrollRunsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/payroll-runs");
        if (request.getCreatedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "created_after", request.getCreatedAfter().get().toString());
        }
        if (request.getCreatedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "created_before", request.getCreatedBefore().get().toString());
        }
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getEndedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "ended_after", request.getEndedAfter().get().toString());
        }
        if (request.getEndedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "ended_before", request.getEndedBefore().get().toString());
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
        if (request.getModifiedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "modified_after", request.getModifiedAfter().get().toString());
        }
        if (request.getModifiedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "modified_before", request.getModifiedBefore().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getRemoteFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get().toString());
        }
        if (request.getRemoteId().isPresent()) {
            httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
        }
        if (request.getRunType().isPresent()) {
            httpUrl.addQueryParameter("run_type", request.getRunType().get().toString());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get().toString());
        }
        if (request.getStartedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "started_after", request.getStartedAfter().get().toString());
        }
        if (request.getStartedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "started_before", request.getStartedBefore().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedPayrollRunList.class);
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
     * Returns a <code>PayrollRun</code> object with the given <code>id</code>.
     */
    public PayrollRun retrieve(String id) {
        return retrieve(id, PayrollRunsRetrieveRequest.builder().build());
    }

    /**
     * Returns a <code>PayrollRun</code> object with the given <code>id</code>.
     */
    public PayrollRun retrieve(String id, PayrollRunsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns a <code>PayrollRun</code> object with the given <code>id</code>.
     */
    public PayrollRun retrieve(String id, PayrollRunsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/payroll-runs")
                .addPathSegment(id);
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getRemoteFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get().toString());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PayrollRun.class);
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

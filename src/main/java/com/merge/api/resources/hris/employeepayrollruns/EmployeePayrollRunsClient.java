/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.hris.employeepayrollruns;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.hris.employeepayrollruns.requests.EmployeePayrollRunsListRequest;
import com.merge.api.resources.hris.employeepayrollruns.requests.EmployeePayrollRunsRetrieveRequest;
import com.merge.api.resources.hris.types.EmployeePayrollRun;
import com.merge.api.resources.hris.types.PaginatedEmployeePayrollRunList;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class EmployeePayrollRunsClient {
    protected final ClientOptions clientOptions;

    public EmployeePayrollRunsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>EmployeePayrollRun</code> objects.
     */
    public PaginatedEmployeePayrollRunList list() {
        return list(EmployeePayrollRunsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>EmployeePayrollRun</code> objects.
     */
    public PaginatedEmployeePayrollRunList list(EmployeePayrollRunsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>EmployeePayrollRun</code> objects.
     */
    public PaginatedEmployeePayrollRunList list(EmployeePayrollRunsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/employee-payroll-runs");
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
        if (request.getEmployeeId().isPresent()) {
            httpUrl.addQueryParameter("employee_id", request.getEmployeeId().get());
        }
        if (request.getEndedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "ended_after", request.getEndedAfter().get().toString());
        }
        if (request.getEndedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "ended_before", request.getEndedBefore().get().toString());
        }
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
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
        if (request.getPayrollRunId().isPresent()) {
            httpUrl.addQueryParameter(
                    "payroll_run_id", request.getPayrollRunId().get());
        }
        if (request.getRemoteId().isPresent()) {
            httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
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
                        responseBody.string(), PaginatedEmployeePayrollRunList.class);
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
     * Returns an <code>EmployeePayrollRun</code> object with the given <code>id</code>.
     */
    public EmployeePayrollRun retrieve(String id, EmployeePayrollRunsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns an <code>EmployeePayrollRun</code> object with the given <code>id</code>.
     */
    public EmployeePayrollRun retrieve(
            String id, EmployeePayrollRunsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/employee-payroll-runs")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), EmployeePayrollRun.class);
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

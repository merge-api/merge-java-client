package com.merge.api.resources.hris.employeepayrollruns;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.hris.employeepayrollruns.requests.EmployeePayrollRunsListRequest;
import com.merge.api.resources.hris.employeepayrollruns.requests.EmployeePayrollRunsRetrieveRequest;
import com.merge.api.resources.hris.types.EmployeePayrollRun;
import com.merge.api.resources.hris.types.PaginatedEmployeePayrollRunList;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EmployeePayrollRunsClient {
    protected final ClientOptions clientOptions;

    public EmployeePayrollRunsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedEmployeePayrollRunList list(EmployeePayrollRunsListRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/hris/v1/employee-payroll-runs");
        if (request.getCreatedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "created_after", request.getCreatedAfter().get().toString());
        }
        if (request.getCreatedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "created_before", request.getCreatedBefore().get().toString());
        }
        if (request.getCursor().isPresent()) {
            _httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getEmployeeId().isPresent()) {
            _httpUrl.addQueryParameter("employee_id", request.getEmployeeId().get());
        }
        if (request.getEndedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "ended_after", request.getEndedAfter().get().toString());
        }
        if (request.getEndedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "ended_before", request.getEndedBefore().get().toString());
        }
        if (request.getExpand().isPresent()) {
            _httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeDeletedData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getModifiedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "modified_after", request.getModifiedAfter().get().toString());
        }
        if (request.getModifiedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "modified_before", request.getModifiedBefore().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            _httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getPayrollRunId().isPresent()) {
            _httpUrl.addQueryParameter(
                    "payroll_run_id", request.getPayrollRunId().get());
        }
        if (request.getRemoteId().isPresent()) {
            _httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
        }
        if (request.getStartedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "started_after", request.getStartedAfter().get().toString());
        }
        if (request.getStartedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "started_before", request.getStartedBefore().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), PaginatedEmployeePayrollRunList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeePayrollRun retrieve(String id, EmployeePayrollRunsRetrieveRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/hris/v1/employee-payroll-runs")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            _httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), EmployeePayrollRun.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.merge.api.resources.hris.employees;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.hris.employees.requests.EmployeeEndpointRequest;
import com.merge.api.resources.hris.employees.requests.EmployeesListRequest;
import com.merge.api.resources.hris.employees.requests.EmployeesRetrieveRequest;
import com.merge.api.resources.hris.employees.requests.IgnoreCommonModelRequest;
import com.merge.api.resources.hris.types.Employee;
import com.merge.api.resources.hris.types.EmployeeResponse;
import com.merge.api.resources.hris.types.MetaResponse;
import com.merge.api.resources.hris.types.PaginatedEmployeeList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EmployeesClient {
    protected final ClientOptions clientOptions;

    public EmployeesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedEmployeeList list(EmployeesListRequest request) {
        return list(request, null);
    }

    public PaginatedEmployeeList list(EmployeesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/hris/v1/employees");
        if (request.getCompanyId().isPresent()) {
            _httpUrl.addQueryParameter("company_id", request.getCompanyId().get());
        }
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
        if (request.getDisplayFullName().isPresent()) {
            _httpUrl.addQueryParameter(
                    "display_full_name", request.getDisplayFullName().get());
        }
        if (request.getEmploymentStatus().isPresent()) {
            _httpUrl.addQueryParameter(
                    "employment_status", request.getEmploymentStatus().get().toString());
        }
        if (request.getExpand().isPresent()) {
            _httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getFirstName().isPresent()) {
            _httpUrl.addQueryParameter("first_name", request.getFirstName().get());
        }
        if (request.getGroups().isPresent()) {
            _httpUrl.addQueryParameter("groups", request.getGroups().get());
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
        if (request.getIncludeSensitiveFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_sensitive_fields",
                    request.getIncludeSensitiveFields().get().toString());
        }
        if (request.getLastName().isPresent()) {
            _httpUrl.addQueryParameter("last_name", request.getLastName().get());
        }
        if (request.getManagerId().isPresent()) {
            _httpUrl.addQueryParameter("manager_id", request.getManagerId().get());
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
        if (request.getPayGroupId().isPresent()) {
            _httpUrl.addQueryParameter("pay_group_id", request.getPayGroupId().get());
        }
        if (request.getPersonalEmail().isPresent()) {
            _httpUrl.addQueryParameter(
                    "personal_email", request.getPersonalEmail().get());
        }
        if (request.getRemoteFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get().toString());
        }
        if (request.getRemoteId().isPresent()) {
            _httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            _httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get().toString());
        }
        if (request.getStartedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "started_after", request.getStartedAfter().get().toString());
        }
        if (request.getStartedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "started_before", request.getStartedBefore().get().toString());
        }
        if (request.getTeamId().isPresent()) {
            _httpUrl.addQueryParameter("team_id", request.getTeamId().get());
        }
        if (request.getTerminatedAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "terminated_after", request.getTerminatedAfter().get().toString());
        }
        if (request.getTerminatedBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "terminated_before", request.getTerminatedBefore().get().toString());
        }
        if (request.getWorkEmail().isPresent()) {
            _httpUrl.addQueryParameter("work_email", request.getWorkEmail().get());
        }
        if (request.getWorkLocationId().isPresent()) {
            _httpUrl.addQueryParameter(
                    "work_location_id", request.getWorkLocationId().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PaginatedEmployeeList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeResponse create(EmployeeEndpointRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/hris/v1/employees");
        if (request.getIsDebugMode().isPresent()) {
            _httpUrl.addQueryParameter(
                    "is_debug_mode", request.getIsDebugMode().get().toString());
        }
        if (request.getRunAsync().isPresent()) {
            _httpUrl.addQueryParameter("run_async", request.getRunAsync().get().toString());
        }
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("model", request.getModel());
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), EmployeeResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Employee retrieve(String id, EmployeesRetrieveRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/hris/v1/employees")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            _httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getIncludeSensitiveFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_sensitive_fields",
                    request.getIncludeSensitiveFields().get().toString());
        }
        if (request.getRemoteFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get().toString());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            _httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Employee.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ignoreCreate(String modelId, IgnoreCommonModelRequest request) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/hris/v1/employees/ignore")
                .addPathSegment(modelId)
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("reason", request.getReason());
        if (request.getMessage().isPresent()) {
            _requestBodyProperties.put("message", request.getMessage());
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
                return;
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MetaResponse metaPostRetrieve() {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/hris/v1/employees/meta/post")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers()))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), MetaResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

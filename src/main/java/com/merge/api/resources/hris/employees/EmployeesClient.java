/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.hris.employees;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MediaTypes;
import com.merge.api.core.MergeException;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class EmployeesClient {
    protected final ClientOptions clientOptions;

    public EmployeesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>Employee</code> objects.
     */
    public PaginatedEmployeeList list() {
        return list(EmployeesListRequest.builder().build());
    }

    /**
     * Returns a list of <code>Employee</code> objects.
     */
    public PaginatedEmployeeList list(EmployeesListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>Employee</code> objects.
     */
    public PaginatedEmployeeList list(EmployeesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/employees");
        if (request.getCompanyId().isPresent()) {
            httpUrl.addQueryParameter("company_id", request.getCompanyId().get());
        }
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
        if (request.getDisplayFullName().isPresent()) {
            httpUrl.addQueryParameter(
                    "display_full_name", request.getDisplayFullName().get());
        }
        if (request.getEmploymentStatus().isPresent()) {
            httpUrl.addQueryParameter(
                    "employment_status", request.getEmploymentStatus().get().toString());
        }
        if (request.getEmploymentType().isPresent()) {
            httpUrl.addQueryParameter(
                    "employment_type", request.getEmploymentType().get());
        }
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getFirstName().isPresent()) {
            httpUrl.addQueryParameter("first_name", request.getFirstName().get());
        }
        if (request.getGroups().isPresent()) {
            httpUrl.addQueryParameter("groups", request.getGroups().get());
        }
        if (request.getHomeLocationId().isPresent()) {
            httpUrl.addQueryParameter(
                    "home_location_id", request.getHomeLocationId().get());
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
        if (request.getIncludeSensitiveFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_sensitive_fields",
                    request.getIncludeSensitiveFields().get().toString());
        }
        if (request.getIncludeShellData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_shell_data", request.getIncludeShellData().get().toString());
        }
        if (request.getJobTitle().isPresent()) {
            httpUrl.addQueryParameter("job_title", request.getJobTitle().get());
        }
        if (request.getLastName().isPresent()) {
            httpUrl.addQueryParameter("last_name", request.getLastName().get());
        }
        if (request.getManagerId().isPresent()) {
            httpUrl.addQueryParameter("manager_id", request.getManagerId().get());
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
        if (request.getPayGroupId().isPresent()) {
            httpUrl.addQueryParameter("pay_group_id", request.getPayGroupId().get());
        }
        if (request.getPersonalEmail().isPresent()) {
            httpUrl.addQueryParameter(
                    "personal_email", request.getPersonalEmail().get());
        }
        if (request.getRemoteFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get().toString());
        }
        if (request.getRemoteId().isPresent()) {
            httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
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
        if (request.getTeamId().isPresent()) {
            httpUrl.addQueryParameter("team_id", request.getTeamId().get());
        }
        if (request.getTerminatedAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "terminated_after", request.getTerminatedAfter().get().toString());
        }
        if (request.getTerminatedBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "terminated_before", request.getTerminatedBefore().get().toString());
        }
        if (request.getWorkEmail().isPresent()) {
            httpUrl.addQueryParameter("work_email", request.getWorkEmail().get());
        }
        if (request.getWorkLocationId().isPresent()) {
            httpUrl.addQueryParameter(
                    "work_location_id", request.getWorkLocationId().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedEmployeeList.class);
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
     * Creates an <code>Employee</code> object with the given values.
     */
    public EmployeeResponse create(EmployeeEndpointRequest request) {
        return create(request, null);
    }

    /**
     * Creates an <code>Employee</code> object with the given values.
     */
    public EmployeeResponse create(EmployeeEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/employees");
        if (request.getIsDebugMode().isPresent()) {
            httpUrl.addQueryParameter(
                    "is_debug_mode", request.getIsDebugMode().get().toString());
        }
        if (request.getRunAsync().isPresent()) {
            httpUrl.addQueryParameter("run_async", request.getRunAsync().get().toString());
        }
        Map<String, Object> properties = new HashMap<>();
        properties.put("model", request.getModel());
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(properties), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("POST", body)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), EmployeeResponse.class);
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
     * Returns an <code>Employee</code> object with the given <code>id</code>.
     */
    public Employee retrieve(String id, EmployeesRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns an <code>Employee</code> object with the given <code>id</code>.
     */
    public Employee retrieve(String id, EmployeesRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/employees")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getIncludeSensitiveFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_sensitive_fields",
                    request.getIncludeSensitiveFields().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Employee.class);
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
     * Ignores a specific row based on the <code>model_id</code> in the url. These records will have their properties set to null, and will not be updated in future syncs. The &quot;reason&quot; and &quot;message&quot; fields in the request body will be stored for audit purposes.
     */
    public void ignoreCreate(String modelId, IgnoreCommonModelRequest request) {
        ignoreCreate(modelId, request, null);
    }

    /**
     * Ignores a specific row based on the <code>model_id</code> in the url. These records will have their properties set to null, and will not be updated in future syncs. The &quot;reason&quot; and &quot;message&quot; fields in the request body will be stored for audit purposes.
     */
    public void ignoreCreate(String modelId, IgnoreCommonModelRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/employees/ignore")
                .addPathSegment(modelId)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new MergeException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
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
                return;
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
     * Returns metadata for <code>Employee</code> POSTs.
     */
    public MetaResponse metaPostRetrieve() {
        return metaPostRetrieve(null);
    }

    /**
     * Returns metadata for <code>Employee</code> POSTs.
     */
    public MetaResponse metaPostRetrieve(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/employees/meta/post")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), MetaResponse.class);
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

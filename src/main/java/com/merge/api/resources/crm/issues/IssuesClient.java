package com.merge.api.resources.crm.issues;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.crm.issues.requests.IssuesListRequest;
import com.merge.api.resources.crm.types.Issue;
import com.merge.api.resources.crm.types.PaginatedIssueList;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class IssuesClient {
    protected final ClientOptions clientOptions;

    public IssuesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedIssueList list(IssuesListRequest request) {
        return list(request, null);
    }

    public PaginatedIssueList list(IssuesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("issues");
        if (request.getAccountToken().isPresent()) {
            _httpUrl.addQueryParameter(
                    "account_token", request.getAccountToken().get());
        }
        if (request.getCursor().isPresent()) {
            _httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getEndDate().isPresent()) {
            _httpUrl.addQueryParameter("end_date", request.getEndDate().get());
        }
        if (request.getEndUserOrganizationName().isPresent()) {
            _httpUrl.addQueryParameter(
                    "end_user_organization_name",
                    request.getEndUserOrganizationName().get());
        }
        if (request.getFirstIncidentTimeAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "first_incident_time_after",
                    request.getFirstIncidentTimeAfter().get().toString());
        }
        if (request.getFirstIncidentTimeBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "first_incident_time_before",
                    request.getFirstIncidentTimeBefore().get().toString());
        }
        if (request.getIncludeMuted().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_muted", request.getIncludeMuted().get());
        }
        if (request.getIntegrationName().isPresent()) {
            _httpUrl.addQueryParameter(
                    "integration_name", request.getIntegrationName().get());
        }
        if (request.getLastIncidentTimeAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "last_incident_time_after",
                    request.getLastIncidentTimeAfter().get().toString());
        }
        if (request.getLastIncidentTimeBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "last_incident_time_before",
                    request.getLastIncidentTimeBefore().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            _httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getStartDate().isPresent()) {
            _httpUrl.addQueryParameter("start_date", request.getStartDate().get());
        }
        if (request.getStatus().isPresent()) {
            _httpUrl.addQueryParameter("status", request.getStatus().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PaginatedIssueList.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Issue retrieve(String id) {
        return retrieve(id, null);
    }

    public Issue retrieve(String id, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("issues")
                .addPathSegment(id)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Issue.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

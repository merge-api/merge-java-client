/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.issues;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.accounting.issues.requests.IssuesListRequest;
import com.merge.api.resources.accounting.types.Issue;
import com.merge.api.resources.accounting.types.PaginatedIssueList;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class IssuesClient {
    protected final ClientOptions clientOptions;

    public IssuesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Gets all issues for Organization.
     */
    public PaginatedIssueList list() {
        return list(IssuesListRequest.builder().build());
    }

    /**
     * Gets all issues for Organization.
     */
    public PaginatedIssueList list(IssuesListRequest request) {
        return list(request, null);
    }

    /**
     * Gets all issues for Organization.
     */
    public PaginatedIssueList list(IssuesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/issues");
        if (request.getAccountToken().isPresent()) {
            httpUrl.addQueryParameter("account_token", request.getAccountToken().get());
        }
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getEndDate().isPresent()) {
            httpUrl.addQueryParameter("end_date", request.getEndDate().get());
        }
        if (request.getEndUserOrganizationName().isPresent()) {
            httpUrl.addQueryParameter(
                    "end_user_organization_name",
                    request.getEndUserOrganizationName().get());
        }
        if (request.getFirstIncidentTimeAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "first_incident_time_after",
                    request.getFirstIncidentTimeAfter().get().toString());
        }
        if (request.getFirstIncidentTimeBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "first_incident_time_before",
                    request.getFirstIncidentTimeBefore().get().toString());
        }
        if (request.getIncludeMuted().isPresent()) {
            httpUrl.addQueryParameter("include_muted", request.getIncludeMuted().get());
        }
        if (request.getIntegrationName().isPresent()) {
            httpUrl.addQueryParameter(
                    "integration_name", request.getIntegrationName().get());
        }
        if (request.getLastIncidentTimeAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "last_incident_time_after",
                    request.getLastIncidentTimeAfter().get().toString());
        }
        if (request.getLastIncidentTimeBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "last_incident_time_before",
                    request.getLastIncidentTimeBefore().get().toString());
        }
        if (request.getLinkedAccountId().isPresent()) {
            httpUrl.addQueryParameter(
                    "linked_account_id", request.getLinkedAccountId().get());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getStartDate().isPresent()) {
            httpUrl.addQueryParameter("start_date", request.getStartDate().get());
        }
        if (request.getStatus().isPresent()) {
            httpUrl.addQueryParameter("status", request.getStatus().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedIssueList.class);
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
     * Get a specific issue.
     */
    public Issue retrieve(String id) {
        return retrieve(id, null);
    }

    /**
     * Get a specific issue.
     */
    public Issue retrieve(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/issues")
                .addPathSegment(id)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Issue.class);
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

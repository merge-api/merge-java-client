/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting;

import com.merge.api.accounting.types.Issue;
import com.merge.api.accounting.types.IssuesListRequest;
import com.merge.api.accounting.types.PaginatedIssueList;
import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeApiHttpResponse;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.QueryStringMapper;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RawIssuesClient {
    protected final ClientOptions clientOptions;

    public RawIssuesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Gets all issues for Organization.
     */
    public MergeApiHttpResponse<SyncPagingIterable<Issue>> list() {
        return list(IssuesListRequest.builder().build());
    }

    /**
     * Gets all issues for Organization.
     */
    public MergeApiHttpResponse<SyncPagingIterable<Issue>> list(IssuesListRequest request) {
        return list(request, null);
    }

    /**
     * Gets all issues for Organization.
     */
    public MergeApiHttpResponse<SyncPagingIterable<Issue>> list(
            IssuesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/issues");
        if (request.getAccountToken().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "account_token", request.getAccountToken().get(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getEndDate().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "end_date", request.getEndDate().get(), false);
        }
        if (request.getEndUserOrganizationName().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "end_user_organization_name",
                    request.getEndUserOrganizationName().get(),
                    false);
        }
        if (request.getFirstIncidentTimeAfter().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "first_incident_time_after",
                    request.getFirstIncidentTimeAfter().get().toString(),
                    false);
        }
        if (request.getFirstIncidentTimeBefore().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "first_incident_time_before",
                    request.getFirstIncidentTimeBefore().get().toString(),
                    false);
        }
        if (request.getIncludeMuted().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "include_muted", request.getIncludeMuted().get(), false);
        }
        if (request.getIntegrationName().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "integration_name", request.getIntegrationName().get(), false);
        }
        if (request.getLastIncidentTimeAfter().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "last_incident_time_after",
                    request.getLastIncidentTimeAfter().get().toString(),
                    false);
        }
        if (request.getLastIncidentTimeBefore().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "last_incident_time_before",
                    request.getLastIncidentTimeBefore().get().toString(),
                    false);
        }
        if (request.getLinkedAccountId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "linked_account_id", request.getLinkedAccountId().get(), false);
        }
        if (request.getPageSize().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "page_size", request.getPageSize().get().toString(), false);
        }
        if (request.getStartDate().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "start_date", request.getStartDate().get(), false);
        }
        if (request.getStatus().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "status", request.getStatus().get().toString(), false);
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
                PaginatedIssueList parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedIssueList.class);
                Optional<String> startingAfter = parsedResponse.getNext();
                IssuesListRequest nextRequest = IssuesListRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<Issue> result = parsedResponse.getResults().orElse(Collections.emptyList());
                return new MergeApiHttpResponse<>(
                        new SyncPagingIterable<Issue>(
                                startingAfter.isPresent(), result, () -> list(nextRequest, requestOptions)
                                        .body()),
                        response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }

    /**
     * Get a specific issue.
     */
    public MergeApiHttpResponse<Issue> retrieve(String id) {
        return retrieve(id, null);
    }

    /**
     * Get a specific issue.
     */
    public MergeApiHttpResponse<Issue> retrieve(String id, RequestOptions requestOptions) {
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
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new MergeApiHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Issue.class), response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new ApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new MergeException("Network error executing HTTP request", e);
        }
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ats.scorecards;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.ats.scorecards.requests.ScorecardsListRequest;
import com.merge.api.resources.ats.scorecards.requests.ScorecardsRetrieveRequest;
import com.merge.api.resources.ats.types.PaginatedScorecardList;
import com.merge.api.resources.ats.types.Scorecard;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class ScorecardsClient {
    protected final ClientOptions clientOptions;

    public ScorecardsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>Scorecard</code> objects.
     */
    public PaginatedScorecardList list() {
        return list(ScorecardsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>Scorecard</code> objects.
     */
    public PaginatedScorecardList list(ScorecardsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>Scorecard</code> objects.
     */
    public PaginatedScorecardList list(ScorecardsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ats/v1/scorecards");
        if (request.getApplicationId().isPresent()) {
            httpUrl.addQueryParameter(
                    "application_id", request.getApplicationId().get());
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
        if (request.getInterviewId().isPresent()) {
            httpUrl.addQueryParameter("interview_id", request.getInterviewId().get());
        }
        if (request.getInterviewerId().isPresent()) {
            httpUrl.addQueryParameter(
                    "interviewer_id", request.getInterviewerId().get());
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
            httpUrl.addQueryParameter("remote_fields", request.getRemoteFields().get());
        }
        if (request.getRemoteId().isPresent()) {
            httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), PaginatedScorecardList.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a <code>Scorecard</code> object with the given <code>id</code>.
     */
    public Scorecard retrieve(String id) {
        return retrieve(id, ScorecardsRetrieveRequest.builder().build());
    }

    /**
     * Returns a <code>Scorecard</code> object with the given <code>id</code>.
     */
    public Scorecard retrieve(String id, ScorecardsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns a <code>Scorecard</code> object with the given <code>id</code>.
     */
    public Scorecard retrieve(String id, ScorecardsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ats/v1/scorecards")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getRemoteFields().isPresent()) {
            httpUrl.addQueryParameter("remote_fields", request.getRemoteFields().get());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Scorecard.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

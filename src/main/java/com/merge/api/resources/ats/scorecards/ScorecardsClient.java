package com.merge.api.resources.ats.scorecards;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.ats.scorecards.requests.ScorecardsListRequest;
import com.merge.api.resources.ats.scorecards.requests.ScorecardsRetrieveRequest;
import com.merge.api.resources.ats.types.PaginatedScorecardList;
import com.merge.api.resources.ats.types.Scorecard;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ScorecardsClient {
    protected final ClientOptions clientOptions;

    public ScorecardsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedScorecardList list(ScorecardsListRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ats/v1/scorecards");
        if (request.getApplicationId().isPresent()) {
            _httpUrl.addQueryParameter(
                    "application_id", request.getApplicationId().get());
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
        if (request.getInterviewId().isPresent()) {
            _httpUrl.addQueryParameter("interview_id", request.getInterviewId().get());
        }
        if (request.getInterviewerId().isPresent()) {
            _httpUrl.addQueryParameter(
                    "interviewer_id", request.getInterviewerId().get());
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
        if (request.getRemoteFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get());
        }
        if (request.getRemoteId().isPresent()) {
            _httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            _httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PaginatedScorecardList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Scorecard retrieve(String id, ScorecardsRetrieveRequest request) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/ats/v1/scorecards")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            _httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getRemoteFields().isPresent()) {
            _httpUrl.addQueryParameter(
                    "remote_fields", request.getRemoteFields().get());
        }
        if (request.getShowEnumOrigins().isPresent()) {
            _httpUrl.addQueryParameter(
                    "show_enum_origins", request.getShowEnumOrigins().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Scorecard.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

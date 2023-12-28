package com.merge.api.resources.ticketing.audittrail;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.ticketing.audittrail.requests.AuditTrailListRequest;
import com.merge.api.resources.ticketing.types.PaginatedAuditLogEventList;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuditTrailClient {
    protected final ClientOptions clientOptions;

    public AuditTrailClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedAuditLogEventList list(AuditTrailListRequest request) {
        return list(request, null);
    }

    public PaginatedAuditLogEventList list(AuditTrailListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("audit-trail");
        if (request.getCursor().isPresent()) {
            _httpUrl.addQueryParameter("cursor", request.getCursor().get());
        }
        if (request.getEndDate().isPresent()) {
            _httpUrl.addQueryParameter("end_date", request.getEndDate().get());
        }
        if (request.getEventType().isPresent()) {
            _httpUrl.addQueryParameter("event_type", request.getEventType().get());
        }
        if (request.getPageSize().isPresent()) {
            _httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
        }
        if (request.getStartDate().isPresent()) {
            _httpUrl.addQueryParameter("start_date", request.getStartDate().get());
        }
        if (request.getUserEmail().isPresent()) {
            _httpUrl.addQueryParameter("user_email", request.getUserEmail().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PaginatedAuditLogEventList.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.merge.api.resources.accounting.creditnotes;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.accounting.creditnotes.requests.CreditNotesListRequest;
import com.merge.api.resources.accounting.creditnotes.requests.CreditNotesRetrieveRequest;
import com.merge.api.resources.accounting.types.CreditNote;
import com.merge.api.resources.accounting.types.PaginatedCreditNoteList;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CreditNotesClient {
    protected final ClientOptions clientOptions;

    public CreditNotesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedCreditNoteList list(CreditNotesListRequest request) {
        return list(request, null);
    }

    public PaginatedCreditNoteList list(CreditNotesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/accounting/v1/credit-notes");
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
        if (request.getTransactionDateAfter().isPresent()) {
            _httpUrl.addQueryParameter(
                    "transaction_date_after",
                    request.getTransactionDateAfter().get().toString());
        }
        if (request.getTransactionDateBefore().isPresent()) {
            _httpUrl.addQueryParameter(
                    "transaction_date_before",
                    request.getTransactionDateBefore().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PaginatedCreditNoteList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CreditNote retrieve(String id, CreditNotesRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    public CreditNote retrieve(String id, CreditNotesRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/accounting/v1/credit-notes")
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
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CreditNote.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

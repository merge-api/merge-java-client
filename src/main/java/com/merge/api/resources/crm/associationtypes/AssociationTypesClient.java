package com.merge.api.resources.crm.associationtypes;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.crm.associationtypes.requests.CrmAssociationTypeEndpointRequest;
import com.merge.api.resources.crm.associationtypes.requests.CustomObjectClassesAssociationTypesListRequest;
import com.merge.api.resources.crm.associationtypes.requests.CustomObjectClassesAssociationTypesRetrieveRequest;
import com.merge.api.resources.crm.types.AssociationType;
import com.merge.api.resources.crm.types.CrmAssociationTypeResponse;
import com.merge.api.resources.crm.types.MetaResponse;
import com.merge.api.resources.crm.types.PaginatedAssociationTypeList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AssociationTypesClient {
    protected final ClientOptions clientOptions;

    public AssociationTypesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PaginatedAssociationTypeList customObjectClassesAssociationTypesList(
            String customObjectClassId, CustomObjectClassesAssociationTypesListRequest request) {
        return customObjectClassesAssociationTypesList(customObjectClassId, request, null);
    }

    public PaginatedAssociationTypeList customObjectClassesAssociationTypesList(
            String customObjectClassId,
            CustomObjectClassesAssociationTypesListRequest request,
            RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/crm/v1/custom-object-classes")
                .addPathSegment(customObjectClassId)
                .addPathSegments("association-types");
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
            _httpUrl.addQueryParameter("expand", request.getExpand().get());
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
        if (request.getRemoteId().isPresent()) {
            _httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), PaginatedAssociationTypeList.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CrmAssociationTypeResponse customObjectClassesAssociationTypesCreate(
            String customObjectClassId, CrmAssociationTypeEndpointRequest request) {
        return customObjectClassesAssociationTypesCreate(customObjectClassId, request, null);
    }

    public CrmAssociationTypeResponse customObjectClassesAssociationTypesCreate(
            String customObjectClassId, CrmAssociationTypeEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/crm/v1/custom-object-classes")
                .addPathSegment(customObjectClassId)
                .addPathSegments("association-types");
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
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), CrmAssociationTypeResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AssociationType customObjectClassesAssociationTypesRetrieve(
            String customObjectClassId, String id, CustomObjectClassesAssociationTypesRetrieveRequest request) {
        return customObjectClassesAssociationTypesRetrieve(customObjectClassId, id, request, null);
    }

    public AssociationType customObjectClassesAssociationTypesRetrieve(
            String customObjectClassId,
            String id,
            CustomObjectClassesAssociationTypesRetrieveRequest request,
            RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/crm/v1/custom-object-classes")
                .addPathSegment(customObjectClassId)
                .addPathSegments("association-types")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            _httpUrl.addQueryParameter("expand", request.getExpand().get());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            _httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AssociationType.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MetaResponse customObjectClassesAssociationTypesMetaPostRetrieve(String customObjectClassId) {
        return customObjectClassesAssociationTypesMetaPostRetrieve(customObjectClassId, null);
    }

    public MetaResponse customObjectClassesAssociationTypesMetaPostRetrieve(
            String customObjectClassId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/crm/v1/custom-object-classes")
                .addPathSegment(customObjectClassId)
                .addPathSegments("association-types/meta/post")
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), MetaResponse.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

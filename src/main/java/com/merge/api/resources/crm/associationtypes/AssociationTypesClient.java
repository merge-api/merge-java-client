/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.crm.associationtypes;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MediaTypes;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.crm.associationtypes.requests.CrmAssociationTypeEndpointRequest;
import com.merge.api.resources.crm.associationtypes.requests.CustomObjectClassesAssociationTypesListRequest;
import com.merge.api.resources.crm.associationtypes.requests.CustomObjectClassesAssociationTypesRetrieveRequest;
import com.merge.api.resources.crm.types.AssociationType;
import com.merge.api.resources.crm.types.CrmAssociationTypeResponse;
import com.merge.api.resources.crm.types.MetaResponse;
import com.merge.api.resources.crm.types.PaginatedAssociationTypeList;
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

public class AssociationTypesClient {
    protected final ClientOptions clientOptions;

    public AssociationTypesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>AssociationType</code> objects.
     */
    public PaginatedAssociationTypeList customObjectClassesAssociationTypesList(String customObjectClassId) {
        return customObjectClassesAssociationTypesList(
                customObjectClassId,
                CustomObjectClassesAssociationTypesListRequest.builder().build());
    }

    /**
     * Returns a list of <code>AssociationType</code> objects.
     */
    public PaginatedAssociationTypeList customObjectClassesAssociationTypesList(
            String customObjectClassId, CustomObjectClassesAssociationTypesListRequest request) {
        return customObjectClassesAssociationTypesList(customObjectClassId, request, null);
    }

    /**
     * Returns a list of <code>AssociationType</code> objects.
     */
    public PaginatedAssociationTypeList customObjectClassesAssociationTypesList(
            String customObjectClassId,
            CustomObjectClassesAssociationTypesListRequest request,
            RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("crm/v1/custom-object-classes")
                .addPathSegment(customObjectClassId)
                .addPathSegments("association-types");
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
            httpUrl.addQueryParameter("expand", request.getExpand().get());
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
        if (request.getIncludeShellData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_shell_data", request.getIncludeShellData().get().toString());
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
        if (request.getRemoteId().isPresent()) {
            httpUrl.addQueryParameter("remote_id", request.getRemoteId().get());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedAssociationTypeList.class);
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
     * Creates an <code>AssociationType</code> object with the given values.
     */
    public CrmAssociationTypeResponse customObjectClassesAssociationTypesCreate(
            String customObjectClassId, CrmAssociationTypeEndpointRequest request) {
        return customObjectClassesAssociationTypesCreate(customObjectClassId, request, null);
    }

    /**
     * Creates an <code>AssociationType</code> object with the given values.
     */
    public CrmAssociationTypeResponse customObjectClassesAssociationTypesCreate(
            String customObjectClassId, CrmAssociationTypeEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("crm/v1/custom-object-classes")
                .addPathSegment(customObjectClassId)
                .addPathSegments("association-types");
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CrmAssociationTypeResponse.class);
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
     * Returns an <code>AssociationType</code> object with the given <code>id</code>.
     */
    public AssociationType customObjectClassesAssociationTypesRetrieve(String customObjectClassId, String id) {
        return customObjectClassesAssociationTypesRetrieve(
                customObjectClassId,
                id,
                CustomObjectClassesAssociationTypesRetrieveRequest.builder().build());
    }

    /**
     * Returns an <code>AssociationType</code> object with the given <code>id</code>.
     */
    public AssociationType customObjectClassesAssociationTypesRetrieve(
            String customObjectClassId, String id, CustomObjectClassesAssociationTypesRetrieveRequest request) {
        return customObjectClassesAssociationTypesRetrieve(customObjectClassId, id, request, null);
    }

    /**
     * Returns an <code>AssociationType</code> object with the given <code>id</code>.
     */
    public AssociationType customObjectClassesAssociationTypesRetrieve(
            String customObjectClassId,
            String id,
            CustomObjectClassesAssociationTypesRetrieveRequest request,
            RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("crm/v1/custom-object-classes")
                .addPathSegment(customObjectClassId)
                .addPathSegments("association-types")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), AssociationType.class);
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
     * Returns metadata for <code>CRMAssociationType</code> POSTs.
     */
    public MetaResponse customObjectClassesAssociationTypesMetaPostRetrieve(String customObjectClassId) {
        return customObjectClassesAssociationTypesMetaPostRetrieve(customObjectClassId, null);
    }

    /**
     * Returns metadata for <code>CRMAssociationType</code> POSTs.
     */
    public MetaResponse customObjectClassesAssociationTypesMetaPostRetrieve(
            String customObjectClassId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("crm/v1/custom-object-classes")
                .addPathSegment(customObjectClassId)
                .addPathSegments("association-types/meta/post")
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

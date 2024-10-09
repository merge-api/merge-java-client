/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.payments;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MediaTypes;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.RequestOptions;
import com.merge.api.resources.accounting.payments.requests.PatchedPaymentEndpointRequest;
import com.merge.api.resources.accounting.payments.requests.PaymentEndpointRequest;
import com.merge.api.resources.accounting.payments.requests.PaymentsLineItemsRemoteFieldClassesListRequest;
import com.merge.api.resources.accounting.payments.requests.PaymentsListRequest;
import com.merge.api.resources.accounting.payments.requests.PaymentsRemoteFieldClassesListRequest;
import com.merge.api.resources.accounting.payments.requests.PaymentsRetrieveRequest;
import com.merge.api.resources.accounting.types.MetaResponse;
import com.merge.api.resources.accounting.types.PaginatedPaymentList;
import com.merge.api.resources.accounting.types.PaginatedRemoteFieldClassList;
import com.merge.api.resources.accounting.types.Payment;
import com.merge.api.resources.accounting.types.PaymentResponse;
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

public class PaymentsClient {
    protected final ClientOptions clientOptions;

    public PaymentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>Payment</code> objects.
     */
    public PaginatedPaymentList list() {
        return list(PaymentsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>Payment</code> objects.
     */
    public PaginatedPaymentList list(PaymentsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>Payment</code> objects.
     */
    public PaginatedPaymentList list(PaymentsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/payments");
        if (request.getAccountId().isPresent()) {
            httpUrl.addQueryParameter("account_id", request.getAccountId().get());
        }
        if (request.getCompanyId().isPresent()) {
            httpUrl.addQueryParameter("company_id", request.getCompanyId().get());
        }
        if (request.getContactId().isPresent()) {
            httpUrl.addQueryParameter("contact_id", request.getContactId().get());
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
        if (request.getIncludeRemoteFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_fields",
                    request.getIncludeRemoteFields().get().toString());
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
        if (request.getTransactionDateAfter().isPresent()) {
            httpUrl.addQueryParameter(
                    "transaction_date_after",
                    request.getTransactionDateAfter().get().toString());
        }
        if (request.getTransactionDateBefore().isPresent()) {
            httpUrl.addQueryParameter(
                    "transaction_date_before",
                    request.getTransactionDateBefore().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedPaymentList.class);
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
     * Creates a <code>Payment</code> object with the given values.
     */
    public PaymentResponse create(PaymentEndpointRequest request) {
        return create(request, null);
    }

    /**
     * Creates a <code>Payment</code> object with the given values.
     */
    public PaymentResponse create(PaymentEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/payments");
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaymentResponse.class);
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
     * Returns a <code>Payment</code> object with the given <code>id</code>.
     */
    public Payment retrieve(String id) {
        return retrieve(id, PaymentsRetrieveRequest.builder().build());
    }

    /**
     * Returns a <code>Payment</code> object with the given <code>id</code>.
     */
    public Payment retrieve(String id, PaymentsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns a <code>Payment</code> object with the given <code>id</code>.
     */
    public Payment retrieve(String id, PaymentsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/payments")
                .addPathSegment(id);
        if (request.getExpand().isPresent()) {
            httpUrl.addQueryParameter("expand", request.getExpand().get().toString());
        }
        if (request.getIncludeRemoteData().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_data", request.getIncludeRemoteData().get().toString());
        }
        if (request.getIncludeRemoteFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "include_remote_fields",
                    request.getIncludeRemoteFields().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Payment.class);
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
     * Updates a <code>Payment</code> object with the given <code>id</code>.
     */
    public PaymentResponse partialUpdate(String id, PatchedPaymentEndpointRequest request) {
        return partialUpdate(id, request, null);
    }

    /**
     * Updates a <code>Payment</code> object with the given <code>id</code>.
     */
    public PaymentResponse partialUpdate(
            String id, PatchedPaymentEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/payments")
                .addPathSegment(id);
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
                .method("PATCH", body)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaymentResponse.class);
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
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public PaginatedRemoteFieldClassList lineItemsRemoteFieldClassesList() {
        return lineItemsRemoteFieldClassesList(
                PaymentsLineItemsRemoteFieldClassesListRequest.builder().build());
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public PaginatedRemoteFieldClassList lineItemsRemoteFieldClassesList(
            PaymentsLineItemsRemoteFieldClassesListRequest request) {
        return lineItemsRemoteFieldClassesList(request, null);
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public PaginatedRemoteFieldClassList lineItemsRemoteFieldClassesList(
            PaymentsLineItemsRemoteFieldClassesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/payments/line-items/remote-field-classes");
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
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
        if (request.getIsCommonModelField().isPresent()) {
            httpUrl.addQueryParameter(
                    "is_common_model_field",
                    request.getIsCommonModelField().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedRemoteFieldClassList.class);
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
     * Returns metadata for <code>Payment</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id) {
        return metaPatchRetrieve(id, null);
    }

    /**
     * Returns metadata for <code>Payment</code> PATCHs.
     */
    public MetaResponse metaPatchRetrieve(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/payments/meta/patch")
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

    /**
     * Returns metadata for <code>Payment</code> POSTs.
     */
    public MetaResponse metaPostRetrieve() {
        return metaPostRetrieve(null);
    }

    /**
     * Returns metadata for <code>Payment</code> POSTs.
     */
    public MetaResponse metaPostRetrieve(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/payments/meta/post")
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

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public PaginatedRemoteFieldClassList remoteFieldClassesList() {
        return remoteFieldClassesList(
                PaymentsRemoteFieldClassesListRequest.builder().build());
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public PaginatedRemoteFieldClassList remoteFieldClassesList(PaymentsRemoteFieldClassesListRequest request) {
        return remoteFieldClassesList(request, null);
    }

    /**
     * Returns a list of <code>RemoteFieldClass</code> objects.
     */
    public PaginatedRemoteFieldClassList remoteFieldClassesList(
            PaymentsRemoteFieldClassesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("accounting/v1/payments/remote-field-classes");
        if (request.getCursor().isPresent()) {
            httpUrl.addQueryParameter("cursor", request.getCursor().get());
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
        if (request.getIsCommonModelField().isPresent()) {
            httpUrl.addQueryParameter(
                    "is_common_model_field",
                    request.getIsCommonModelField().get().toString());
        }
        if (request.getPageSize().isPresent()) {
            httpUrl.addQueryParameter("page_size", request.getPageSize().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PaginatedRemoteFieldClassList.class);
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

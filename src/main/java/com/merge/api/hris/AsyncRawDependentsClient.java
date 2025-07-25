/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeApiHttpResponse;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.QueryStringMapper;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.hris.types.Dependent;
import com.merge.api.hris.types.DependentsListRequest;
import com.merge.api.hris.types.DependentsRetrieveRequest;
import com.merge.api.hris.types.PaginatedDependentList;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public class AsyncRawDependentsClient {
    protected final ClientOptions clientOptions;

    public AsyncRawDependentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>Dependent</code> objects.
     */
    public CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<Dependent>>> list() {
        return list(DependentsListRequest.builder().build());
    }

    /**
     * Returns a list of <code>Dependent</code> objects.
     */
    public CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<Dependent>>> list(DependentsListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>Dependent</code> objects.
     */
    public CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<Dependent>>> list(
            DependentsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/dependents");
        if (request.getCreatedAfter().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "created_after", request.getCreatedAfter().get().toString(), false);
        }
        if (request.getCreatedBefore().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "created_before", request.getCreatedBefore().get().toString(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getIncludeDeletedData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_deleted_data",
                    request.getIncludeDeletedData().get().toString(),
                    false);
        }
        if (request.getIncludeRemoteData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_remote_data",
                    request.getIncludeRemoteData().get().toString(),
                    false);
        }
        if (request.getIncludeSensitiveFields().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_sensitive_fields",
                    request.getIncludeSensitiveFields().get().toString(),
                    false);
        }
        if (request.getIncludeShellData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_shell_data",
                    request.getIncludeShellData().get().toString(),
                    false);
        }
        if (request.getModifiedAfter().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "modified_after", request.getModifiedAfter().get().toString(), false);
        }
        if (request.getModifiedBefore().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "modified_before",
                    request.getModifiedBefore().get().toString(),
                    false);
        }
        if (request.getPageSize().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "page_size", request.getPageSize().get().toString(), false);
        }
        if (request.getRemoteId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "remote_id", request.getRemoteId().get(), false);
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
        CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<Dependent>>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        PaginatedDependentList parsedResponse = ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), PaginatedDependentList.class);
                        Optional<String> startingAfter = parsedResponse.getNext();
                        DependentsListRequest nextRequest = DependentsListRequest.builder()
                                .from(request)
                                .cursor(startingAfter)
                                .build();
                        List<Dependent> result = parsedResponse.getResults().orElse(Collections.emptyList());
                        future.complete(new MergeApiHttpResponse<>(
                                new SyncPagingIterable<Dependent>(startingAfter.isPresent(), result, () -> {
                                    try {
                                        return list(nextRequest, requestOptions)
                                                .get()
                                                .body();
                                    } catch (InterruptedException | ExecutionException e) {
                                        throw new RuntimeException(e);
                                    }
                                }),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new ApiError(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new MergeException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new MergeException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Returns a <code>Dependent</code> object with the given <code>id</code>.
     */
    public CompletableFuture<MergeApiHttpResponse<Dependent>> retrieve(String id) {
        return retrieve(id, DependentsRetrieveRequest.builder().build());
    }

    /**
     * Returns a <code>Dependent</code> object with the given <code>id</code>.
     */
    public CompletableFuture<MergeApiHttpResponse<Dependent>> retrieve(String id, DependentsRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns a <code>Dependent</code> object with the given <code>id</code>.
     */
    public CompletableFuture<MergeApiHttpResponse<Dependent>> retrieve(
            String id, DependentsRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/dependents")
                .addPathSegment(id);
        if (request.getIncludeRemoteData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_remote_data",
                    request.getIncludeRemoteData().get().toString(),
                    false);
        }
        if (request.getIncludeSensitiveFields().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_sensitive_fields",
                    request.getIncludeSensitiveFields().get().toString(),
                    false);
        }
        if (request.getIncludeShellData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_shell_data",
                    request.getIncludeShellData().get().toString(),
                    false);
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
        CompletableFuture<MergeApiHttpResponse<Dependent>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new MergeApiHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Dependent.class), response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new ApiError(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new MergeException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new MergeException("Network error executing HTTP request", e));
            }
        });
        return future;
    }
}

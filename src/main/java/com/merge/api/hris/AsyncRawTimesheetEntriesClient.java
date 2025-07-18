/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MediaTypes;
import com.merge.api.core.MergeApiHttpResponse;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.QueryStringMapper;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.hris.types.MetaResponse;
import com.merge.api.hris.types.PaginatedTimesheetEntryList;
import com.merge.api.hris.types.TimesheetEntriesListRequest;
import com.merge.api.hris.types.TimesheetEntriesRetrieveRequest;
import com.merge.api.hris.types.TimesheetEntry;
import com.merge.api.hris.types.TimesheetEntryEndpointRequest;
import com.merge.api.hris.types.TimesheetEntryResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public class AsyncRawTimesheetEntriesClient {
    protected final ClientOptions clientOptions;

    public AsyncRawTimesheetEntriesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns a list of <code>TimesheetEntry</code> objects.
     */
    public CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<TimesheetEntry>>> list() {
        return list(TimesheetEntriesListRequest.builder().build());
    }

    /**
     * Returns a list of <code>TimesheetEntry</code> objects.
     */
    public CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<TimesheetEntry>>> list(
            TimesheetEntriesListRequest request) {
        return list(request, null);
    }

    /**
     * Returns a list of <code>TimesheetEntry</code> objects.
     */
    public CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<TimesheetEntry>>> list(
            TimesheetEntriesListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/timesheet-entries");
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
        if (request.getEmployeeId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "employee_id", request.getEmployeeId().get(), false);
        }
        if (request.getEndedAfter().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "ended_after", request.getEndedAfter().get().toString(), false);
        }
        if (request.getEndedBefore().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "ended_before", request.getEndedBefore().get().toString(), false);
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
        if (request.getOrderBy().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "order_by", request.getOrderBy().get().toString(), false);
        }
        if (request.getPageSize().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "page_size", request.getPageSize().get().toString(), false);
        }
        if (request.getRemoteId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "remote_id", request.getRemoteId().get(), false);
        }
        if (request.getStartedAfter().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "started_after", request.getStartedAfter().get().toString(), false);
        }
        if (request.getStartedBefore().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "started_before", request.getStartedBefore().get().toString(), false);
        }
        if (request.getExpand().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "expand", request.getExpand().get().toString(), false);
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
        CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<TimesheetEntry>>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        PaginatedTimesheetEntryList parsedResponse = ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), PaginatedTimesheetEntryList.class);
                        Optional<String> startingAfter = parsedResponse.getNext();
                        TimesheetEntriesListRequest nextRequest = TimesheetEntriesListRequest.builder()
                                .from(request)
                                .cursor(startingAfter)
                                .build();
                        List<TimesheetEntry> result =
                                parsedResponse.getResults().orElse(Collections.emptyList());
                        future.complete(new MergeApiHttpResponse<>(
                                new SyncPagingIterable<TimesheetEntry>(startingAfter.isPresent(), result, () -> {
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
     * Creates a <code>TimesheetEntry</code> object with the given values.
     */
    public CompletableFuture<MergeApiHttpResponse<TimesheetEntryResponse>> create(
            TimesheetEntryEndpointRequest request) {
        return create(request, null);
    }

    /**
     * Creates a <code>TimesheetEntry</code> object with the given values.
     */
    public CompletableFuture<MergeApiHttpResponse<TimesheetEntryResponse>> create(
            TimesheetEntryEndpointRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/timesheet-entries");
        if (request.getIsDebugMode().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "is_debug_mode", request.getIsDebugMode().get().toString(), false);
        }
        if (request.getRunAsync().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "run_async", request.getRunAsync().get().toString(), false);
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
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<MergeApiHttpResponse<TimesheetEntryResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new MergeApiHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(
                                        responseBody.string(), TimesheetEntryResponse.class),
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
     * Returns a <code>TimesheetEntry</code> object with the given <code>id</code>.
     */
    public CompletableFuture<MergeApiHttpResponse<TimesheetEntry>> retrieve(String id) {
        return retrieve(id, TimesheetEntriesRetrieveRequest.builder().build());
    }

    /**
     * Returns a <code>TimesheetEntry</code> object with the given <code>id</code>.
     */
    public CompletableFuture<MergeApiHttpResponse<TimesheetEntry>> retrieve(
            String id, TimesheetEntriesRetrieveRequest request) {
        return retrieve(id, request, null);
    }

    /**
     * Returns a <code>TimesheetEntry</code> object with the given <code>id</code>.
     */
    public CompletableFuture<MergeApiHttpResponse<TimesheetEntry>> retrieve(
            String id, TimesheetEntriesRetrieveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/timesheet-entries")
                .addPathSegment(id);
        if (request.getIncludeRemoteData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_remote_data",
                    request.getIncludeRemoteData().get().toString(),
                    false);
        }
        if (request.getIncludeShellData().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_shell_data",
                    request.getIncludeShellData().get().toString(),
                    false);
        }
        if (request.getExpand().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "expand", request.getExpand().get().toString(), false);
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
        CompletableFuture<MergeApiHttpResponse<TimesheetEntry>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new MergeApiHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), TimesheetEntry.class),
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
     * Returns metadata for <code>TimesheetEntry</code> POSTs.
     */
    public CompletableFuture<MergeApiHttpResponse<MetaResponse>> metaPostRetrieve() {
        return metaPostRetrieve(null);
    }

    /**
     * Returns metadata for <code>TimesheetEntry</code> POSTs.
     */
    public CompletableFuture<MergeApiHttpResponse<MetaResponse>> metaPostRetrieve(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("hris/v1/timesheet-entries/meta/post")
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
        CompletableFuture<MergeApiHttpResponse<MetaResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new MergeApiHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), MetaResponse.class),
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
}

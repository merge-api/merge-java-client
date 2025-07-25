/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.crm;

import com.merge.api.core.ApiError;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.MergeApiHttpResponse;
import com.merge.api.core.MergeException;
import com.merge.api.core.ObjectMappers;
import com.merge.api.core.QueryStringMapper;
import com.merge.api.core.RequestOptions;
import com.merge.api.core.SyncPagingIterable;
import com.merge.api.crm.types.AccountDetailsAndActions;
import com.merge.api.crm.types.LinkedAccountsListRequest;
import com.merge.api.crm.types.PaginatedAccountDetailsAndActionsList;
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

public class AsyncRawLinkedAccountsClient {
    protected final ClientOptions clientOptions;

    public AsyncRawLinkedAccountsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * List linked accounts for your organization.
     */
    public CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<AccountDetailsAndActions>>> list() {
        return list(LinkedAccountsListRequest.builder().build());
    }

    /**
     * List linked accounts for your organization.
     */
    public CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<AccountDetailsAndActions>>> list(
            LinkedAccountsListRequest request) {
        return list(request, null);
    }

    /**
     * List linked accounts for your organization.
     */
    public CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<AccountDetailsAndActions>>> list(
            LinkedAccountsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("crm/v1/linked-accounts");
        if (request.getCategory().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "category", request.getCategory().get().toString(), false);
        }
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getEndUserEmailAddress().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "end_user_email_address",
                    request.getEndUserEmailAddress().get(),
                    false);
        }
        if (request.getEndUserOrganizationName().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "end_user_organization_name",
                    request.getEndUserOrganizationName().get(),
                    false);
        }
        if (request.getEndUserOriginId().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "end_user_origin_id", request.getEndUserOriginId().get(), false);
        }
        if (request.getEndUserOriginIds().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "end_user_origin_ids",
                    request.getEndUserOriginIds().get(),
                    false);
        }
        if (request.getId().isPresent()) {
            QueryStringMapper.addQueryParameter(httpUrl, "id", request.getId().get(), false);
        }
        if (request.getIds().isPresent()) {
            QueryStringMapper.addQueryParameter(httpUrl, "ids", request.getIds().get(), false);
        }
        if (request.getIncludeDuplicates().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl,
                    "include_duplicates",
                    request.getIncludeDuplicates().get().toString(),
                    false);
        }
        if (request.getIntegrationName().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "integration_name", request.getIntegrationName().get(), false);
        }
        if (request.getIsTestAccount().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "is_test_account", request.getIsTestAccount().get(), false);
        }
        if (request.getPageSize().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "page_size", request.getPageSize().get().toString(), false);
        }
        if (request.getStatus().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "status", request.getStatus().get(), false);
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
        CompletableFuture<MergeApiHttpResponse<SyncPagingIterable<AccountDetailsAndActions>>> future =
                new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        PaginatedAccountDetailsAndActionsList parsedResponse = ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(), PaginatedAccountDetailsAndActionsList.class);
                        Optional<String> startingAfter = parsedResponse.getNext();
                        LinkedAccountsListRequest nextRequest = LinkedAccountsListRequest.builder()
                                .from(request)
                                .cursor(startingAfter)
                                .build();
                        List<AccountDetailsAndActions> result =
                                parsedResponse.getResults().orElse(Collections.emptyList());
                        future.complete(new MergeApiHttpResponse<>(
                                new SyncPagingIterable<AccountDetailsAndActions>(
                                        startingAfter.isPresent(), result, () -> {
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
}

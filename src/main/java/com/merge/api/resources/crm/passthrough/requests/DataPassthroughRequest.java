package com.merge.api.resources.crm.passthrough.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.resources.crm.types.MethodEnum;
import com.merge.api.resources.crm.types.MultipartFormFieldRequest;
import com.merge.api.resources.crm.types.RequestFormatEnum;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DataPassthroughRequest.Builder.class)
public final class DataPassthroughRequest {
    private final MethodEnum method;

    private final String path;

    private final Optional<String> baseUrlOverride;

    private final Optional<String> data;

    private final Optional<List<MultipartFormFieldRequest>> multipartFormData;

    private final Optional<Map<String, JsonNode>> headers;

    private final Optional<RequestFormatEnum> requestFormat;

    private final Optional<Boolean> normalizeResponse;

    private DataPassthroughRequest(
            MethodEnum method,
            String path,
            Optional<String> baseUrlOverride,
            Optional<String> data,
            Optional<List<MultipartFormFieldRequest>> multipartFormData,
            Optional<Map<String, JsonNode>> headers,
            Optional<RequestFormatEnum> requestFormat,
            Optional<Boolean> normalizeResponse) {
        this.method = method;
        this.path = path;
        this.baseUrlOverride = baseUrlOverride;
        this.data = data;
        this.multipartFormData = multipartFormData;
        this.headers = headers;
        this.requestFormat = requestFormat;
        this.normalizeResponse = normalizeResponse;
    }

    @JsonProperty("method")
    public MethodEnum getMethod() {
        return method;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("base_url_override")
    public Optional<String> getBaseUrlOverride() {
        return baseUrlOverride;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("data")
    public Optional<String> getData() {
        return data;
    }

    /**
     * @return Pass an array of <code>MultipartFormField</code> objects in here instead of using the <code>data</code> param if <code>request_format</code> is set to <code>MULTIPART</code>.
     */
    @JsonProperty("multipart_form_data")
    public Optional<List<MultipartFormFieldRequest>> getMultipartFormData() {
        return multipartFormData;
    }

    /**
     * @return The headers to use for the request (Merge will handle the account's authorization headers). <code>Content-Type</code> header is required for passthrough. Choose content type corresponding to expected format of receiving server.
     */
    @JsonProperty("headers")
    public Optional<Map<String, JsonNode>> getHeaders() {
        return headers;
    }

    @JsonProperty("request_format")
    public Optional<RequestFormatEnum> getRequestFormat() {
        return requestFormat;
    }

    /**
     * @return Optional. If true, the response will always be an object of the form <code>{&quot;type&quot;: T, &quot;value&quot;: ...}</code> where <code>T</code> will be one of <code>string, boolean, number, null, array, object</code>.
     */
    @JsonProperty("normalize_response")
    public Optional<Boolean> getNormalizeResponse() {
        return normalizeResponse;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DataPassthroughRequest && equalTo((DataPassthroughRequest) other);
    }

    private boolean equalTo(DataPassthroughRequest other) {
        return method.equals(other.method)
                && path.equals(other.path)
                && baseUrlOverride.equals(other.baseUrlOverride)
                && data.equals(other.data)
                && multipartFormData.equals(other.multipartFormData)
                && headers.equals(other.headers)
                && requestFormat.equals(other.requestFormat)
                && normalizeResponse.equals(other.normalizeResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.method,
                this.path,
                this.baseUrlOverride,
                this.data,
                this.multipartFormData,
                this.headers,
                this.requestFormat,
                this.normalizeResponse);
    }

    @Override
    public String toString() {
        return "DataPassthroughRequest{" + "method: " + method + ", path: " + path + ", baseUrlOverride: "
                + baseUrlOverride + ", data: " + data + ", multipartFormData: " + multipartFormData + ", headers: "
                + headers + ", requestFormat: " + requestFormat + ", normalizeResponse: " + normalizeResponse + "}";
    }

    public static MethodStage builder() {
        return new Builder();
    }

    public interface MethodStage {
        PathStage method(MethodEnum method);

        Builder from(DataPassthroughRequest other);
    }

    public interface PathStage {
        _FinalStage path(String path);
    }

    public interface _FinalStage {
        DataPassthroughRequest build();

        _FinalStage baseUrlOverride(Optional<String> baseUrlOverride);

        _FinalStage baseUrlOverride(String baseUrlOverride);

        _FinalStage data(Optional<String> data);

        _FinalStage data(String data);

        _FinalStage multipartFormData(Optional<List<MultipartFormFieldRequest>> multipartFormData);

        _FinalStage multipartFormData(List<MultipartFormFieldRequest> multipartFormData);

        _FinalStage headers(Optional<Map<String, JsonNode>> headers);

        _FinalStage headers(Map<String, JsonNode> headers);

        _FinalStage requestFormat(Optional<RequestFormatEnum> requestFormat);

        _FinalStage requestFormat(RequestFormatEnum requestFormat);

        _FinalStage normalizeResponse(Optional<Boolean> normalizeResponse);

        _FinalStage normalizeResponse(Boolean normalizeResponse);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MethodStage, PathStage, _FinalStage {
        private MethodEnum method;

        private String path;

        private Optional<Boolean> normalizeResponse = Optional.empty();

        private Optional<RequestFormatEnum> requestFormat = Optional.empty();

        private Optional<Map<String, JsonNode>> headers = Optional.empty();

        private Optional<List<MultipartFormFieldRequest>> multipartFormData = Optional.empty();

        private Optional<String> data = Optional.empty();

        private Optional<String> baseUrlOverride = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(DataPassthroughRequest other) {
            method(other.getMethod());
            path(other.getPath());
            baseUrlOverride(other.getBaseUrlOverride());
            data(other.getData());
            multipartFormData(other.getMultipartFormData());
            headers(other.getHeaders());
            requestFormat(other.getRequestFormat());
            normalizeResponse(other.getNormalizeResponse());
            return this;
        }

        @Override
        @JsonSetter("method")
        public PathStage method(MethodEnum method) {
            this.method = method;
            return this;
        }

        /**
         * <p>&lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("path")
        public _FinalStage path(String path) {
            this.path = path;
            return this;
        }

        /**
         * <p>Optional. If true, the response will always be an object of the form <code>{&quot;type&quot;: T, &quot;value&quot;: ...}</code> where <code>T</code> will be one of <code>string, boolean, number, null, array, object</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage normalizeResponse(Boolean normalizeResponse) {
            this.normalizeResponse = Optional.of(normalizeResponse);
            return this;
        }

        @Override
        @JsonSetter(value = "normalize_response", nulls = Nulls.SKIP)
        public _FinalStage normalizeResponse(Optional<Boolean> normalizeResponse) {
            this.normalizeResponse = normalizeResponse;
            return this;
        }

        @Override
        public _FinalStage requestFormat(RequestFormatEnum requestFormat) {
            this.requestFormat = Optional.of(requestFormat);
            return this;
        }

        @Override
        @JsonSetter(value = "request_format", nulls = Nulls.SKIP)
        public _FinalStage requestFormat(Optional<RequestFormatEnum> requestFormat) {
            this.requestFormat = requestFormat;
            return this;
        }

        /**
         * <p>The headers to use for the request (Merge will handle the account's authorization headers). <code>Content-Type</code> header is required for passthrough. Choose content type corresponding to expected format of receiving server.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage headers(Map<String, JsonNode> headers) {
            this.headers = Optional.of(headers);
            return this;
        }

        @Override
        @JsonSetter(value = "headers", nulls = Nulls.SKIP)
        public _FinalStage headers(Optional<Map<String, JsonNode>> headers) {
            this.headers = headers;
            return this;
        }

        /**
         * <p>Pass an array of <code>MultipartFormField</code> objects in here instead of using the <code>data</code> param if <code>request_format</code> is set to <code>MULTIPART</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage multipartFormData(List<MultipartFormFieldRequest> multipartFormData) {
            this.multipartFormData = Optional.of(multipartFormData);
            return this;
        }

        @Override
        @JsonSetter(value = "multipart_form_data", nulls = Nulls.SKIP)
        public _FinalStage multipartFormData(Optional<List<MultipartFormFieldRequest>> multipartFormData) {
            this.multipartFormData = multipartFormData;
            return this;
        }

        /**
         * <p>&lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage data(String data) {
            this.data = Optional.of(data);
            return this;
        }

        @Override
        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public _FinalStage data(Optional<String> data) {
            this.data = data;
            return this;
        }

        /**
         * <p>&lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage baseUrlOverride(String baseUrlOverride) {
            this.baseUrlOverride = Optional.of(baseUrlOverride);
            return this;
        }

        @Override
        @JsonSetter(value = "base_url_override", nulls = Nulls.SKIP)
        public _FinalStage baseUrlOverride(Optional<String> baseUrlOverride) {
            this.baseUrlOverride = baseUrlOverride;
            return this;
        }

        @Override
        public DataPassthroughRequest build() {
            return new DataPassthroughRequest(
                    method, path, baseUrlOverride, data, multipartFormData, headers, requestFormat, normalizeResponse);
        }
    }
}

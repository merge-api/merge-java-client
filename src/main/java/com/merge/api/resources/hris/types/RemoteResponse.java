package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RemoteResponse.Builder.class)
public final class RemoteResponse {
    private final String method;

    private final String path;

    private final int status;

    private final JsonNode response;

    private final Optional<Map<String, JsonNode>> responseHeaders;

    private final Optional<RemoteResponseResponseType> responseType;

    private final Optional<Map<String, JsonNode>> headers;

    private RemoteResponse(
            String method,
            String path,
            int status,
            JsonNode response,
            Optional<Map<String, JsonNode>> responseHeaders,
            Optional<RemoteResponseResponseType> responseType,
            Optional<Map<String, JsonNode>> headers) {
        this.method = method;
        this.path = path;
        this.status = status;
        this.response = response;
        this.responseHeaders = responseHeaders;
        this.responseType = responseType;
        this.headers = headers;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    @JsonProperty("response")
    public JsonNode getResponse() {
        return response;
    }

    @JsonProperty("response_headers")
    public Optional<Map<String, JsonNode>> getResponseHeaders() {
        return responseHeaders;
    }

    @JsonProperty("response_type")
    public Optional<RemoteResponseResponseType> getResponseType() {
        return responseType;
    }

    @JsonProperty("headers")
    public Optional<Map<String, JsonNode>> getHeaders() {
        return headers;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteResponse && equalTo((RemoteResponse) other);
    }

    private boolean equalTo(RemoteResponse other) {
        return method.equals(other.method)
                && path.equals(other.path)
                && status == other.status
                && response.equals(other.response)
                && responseHeaders.equals(other.responseHeaders)
                && responseType.equals(other.responseType)
                && headers.equals(other.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.method,
                this.path,
                this.status,
                this.response,
                this.responseHeaders,
                this.responseType,
                this.headers);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MethodStage builder() {
        return new Builder();
    }

    public interface MethodStage {
        PathStage method(String method);

        Builder from(RemoteResponse other);
    }

    public interface PathStage {
        StatusStage path(String path);
    }

    public interface StatusStage {
        ResponseStage status(int status);
    }

    public interface ResponseStage {
        _FinalStage response(JsonNode response);
    }

    public interface _FinalStage {
        RemoteResponse build();

        _FinalStage responseHeaders(Optional<Map<String, JsonNode>> responseHeaders);

        _FinalStage responseHeaders(Map<String, JsonNode> responseHeaders);

        _FinalStage responseType(Optional<RemoteResponseResponseType> responseType);

        _FinalStage responseType(RemoteResponseResponseType responseType);

        _FinalStage headers(Optional<Map<String, JsonNode>> headers);

        _FinalStage headers(Map<String, JsonNode> headers);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MethodStage, PathStage, StatusStage, ResponseStage, _FinalStage {
        private String method;

        private String path;

        private int status;

        private JsonNode response;

        private Optional<Map<String, JsonNode>> headers = Optional.empty();

        private Optional<RemoteResponseResponseType> responseType = Optional.empty();

        private Optional<Map<String, JsonNode>> responseHeaders = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RemoteResponse other) {
            method(other.getMethod());
            path(other.getPath());
            status(other.getStatus());
            response(other.getResponse());
            responseHeaders(other.getResponseHeaders());
            responseType(other.getResponseType());
            headers(other.getHeaders());
            return this;
        }

        @Override
        @JsonSetter("method")
        public PathStage method(String method) {
            this.method = method;
            return this;
        }

        @Override
        @JsonSetter("path")
        public StatusStage path(String path) {
            this.path = path;
            return this;
        }

        @Override
        @JsonSetter("status")
        public ResponseStage status(int status) {
            this.status = status;
            return this;
        }

        @Override
        @JsonSetter("response")
        public _FinalStage response(JsonNode response) {
            this.response = response;
            return this;
        }

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

        @Override
        public _FinalStage responseType(RemoteResponseResponseType responseType) {
            this.responseType = Optional.of(responseType);
            return this;
        }

        @Override
        @JsonSetter(value = "response_type", nulls = Nulls.SKIP)
        public _FinalStage responseType(Optional<RemoteResponseResponseType> responseType) {
            this.responseType = responseType;
            return this;
        }

        @Override
        public _FinalStage responseHeaders(Map<String, JsonNode> responseHeaders) {
            this.responseHeaders = Optional.of(responseHeaders);
            return this;
        }

        @Override
        @JsonSetter(value = "response_headers", nulls = Nulls.SKIP)
        public _FinalStage responseHeaders(Optional<Map<String, JsonNode>> responseHeaders) {
            this.responseHeaders = responseHeaders;
            return this;
        }

        @Override
        public RemoteResponse build() {
            return new RemoteResponse(method, path, status, response, responseHeaders, responseType, headers);
        }
    }
}

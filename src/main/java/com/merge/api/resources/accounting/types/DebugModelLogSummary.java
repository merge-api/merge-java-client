package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DebugModelLogSummary.Builder.class)
public final class DebugModelLogSummary {
    private final String url;

    private final String method;

    private final int statusCode;

    private DebugModelLogSummary(String url, String method, int statusCode) {
        this.url = url;
        this.method = method;
        this.statusCode = statusCode;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("status_code")
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DebugModelLogSummary && equalTo((DebugModelLogSummary) other);
    }

    private boolean equalTo(DebugModelLogSummary other) {
        return url.equals(other.url) && method.equals(other.method) && statusCode == other.statusCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url, this.method, this.statusCode);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UrlStage builder() {
        return new Builder();
    }

    public interface UrlStage {
        MethodStage url(String url);

        Builder from(DebugModelLogSummary other);
    }

    public interface MethodStage {
        StatusCodeStage method(String method);
    }

    public interface StatusCodeStage {
        _FinalStage statusCode(int statusCode);
    }

    public interface _FinalStage {
        DebugModelLogSummary build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UrlStage, MethodStage, StatusCodeStage, _FinalStage {
        private String url;

        private String method;

        private int statusCode;

        private Builder() {}

        @Override
        public Builder from(DebugModelLogSummary other) {
            url(other.getUrl());
            method(other.getMethod());
            statusCode(other.getStatusCode());
            return this;
        }

        @Override
        @JsonSetter("url")
        public MethodStage url(String url) {
            this.url = url;
            return this;
        }

        @Override
        @JsonSetter("method")
        public StatusCodeStage method(String method) {
            this.method = method;
            return this;
        }

        @Override
        @JsonSetter("status_code")
        public _FinalStage statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        @Override
        public DebugModelLogSummary build() {
            return new DebugModelLogSummary(url, method, statusCode);
        }
    }
}

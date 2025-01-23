/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = RemoteEndpointInfo.Builder.class)
public final class RemoteEndpointInfo {
    private final String method;

    private final String urlPath;

    private final List<JsonNode> fieldTraversalPath;

    private final Map<String, Object> additionalProperties;

    private RemoteEndpointInfo(
            String method,
            String urlPath,
            List<JsonNode> fieldTraversalPath,
            Map<String, Object> additionalProperties) {
        this.method = method;
        this.urlPath = urlPath;
        this.fieldTraversalPath = fieldTraversalPath;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("url_path")
    public String getUrlPath() {
        return urlPath;
    }

    @JsonProperty("field_traversal_path")
    public List<JsonNode> getFieldTraversalPath() {
        return fieldTraversalPath;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteEndpointInfo && equalTo((RemoteEndpointInfo) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RemoteEndpointInfo other) {
        return method.equals(other.method)
                && urlPath.equals(other.urlPath)
                && fieldTraversalPath.equals(other.fieldTraversalPath);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.method, this.urlPath, this.fieldTraversalPath);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MethodStage builder() {
        return new Builder();
    }

    public interface MethodStage {
        UrlPathStage method(@NotNull String method);

        Builder from(RemoteEndpointInfo other);
    }

    public interface UrlPathStage {
        _FinalStage urlPath(@NotNull String urlPath);
    }

    public interface _FinalStage {
        RemoteEndpointInfo build();

        _FinalStage fieldTraversalPath(List<JsonNode> fieldTraversalPath);

        _FinalStage addFieldTraversalPath(JsonNode fieldTraversalPath);

        _FinalStage addAllFieldTraversalPath(List<JsonNode> fieldTraversalPath);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MethodStage, UrlPathStage, _FinalStage {
        private String method;

        private String urlPath;

        private List<JsonNode> fieldTraversalPath = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(RemoteEndpointInfo other) {
            method(other.getMethod());
            urlPath(other.getUrlPath());
            fieldTraversalPath(other.getFieldTraversalPath());
            return this;
        }

        @java.lang.Override
        @JsonSetter("method")
        public UrlPathStage method(@NotNull String method) {
            this.method = method;
            return this;
        }

        @java.lang.Override
        @JsonSetter("url_path")
        public _FinalStage urlPath(@NotNull String urlPath) {
            this.urlPath = urlPath;
            return this;
        }

        @java.lang.Override
        public _FinalStage addAllFieldTraversalPath(List<JsonNode> fieldTraversalPath) {
            this.fieldTraversalPath.addAll(fieldTraversalPath);
            return this;
        }

        @java.lang.Override
        public _FinalStage addFieldTraversalPath(JsonNode fieldTraversalPath) {
            this.fieldTraversalPath.add(fieldTraversalPath);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "field_traversal_path", nulls = Nulls.SKIP)
        public _FinalStage fieldTraversalPath(List<JsonNode> fieldTraversalPath) {
            this.fieldTraversalPath.clear();
            this.fieldTraversalPath.addAll(fieldTraversalPath);
            return this;
        }

        @java.lang.Override
        public RemoteEndpointInfo build() {
            return new RemoteEndpointInfo(method, urlPath, fieldTraversalPath, additionalProperties);
        }
    }
}

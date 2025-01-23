/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.crm.fieldmapping.requests;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PatchedEditFieldMappingRequest.Builder.class)
public final class PatchedEditFieldMappingRequest {
    private final Optional<List<JsonNode>> remoteFieldTraversalPath;

    private final Optional<String> remoteMethod;

    private final Optional<String> remoteUrlPath;

    private final Map<String, Object> additionalProperties;

    private PatchedEditFieldMappingRequest(
            Optional<List<JsonNode>> remoteFieldTraversalPath,
            Optional<String> remoteMethod,
            Optional<String> remoteUrlPath,
            Map<String, Object> additionalProperties) {
        this.remoteFieldTraversalPath = remoteFieldTraversalPath;
        this.remoteMethod = remoteMethod;
        this.remoteUrlPath = remoteUrlPath;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The field traversal path of the remote field listed when you hit the GET /remote-fields endpoint.
     */
    @JsonProperty("remote_field_traversal_path")
    public Optional<List<JsonNode>> getRemoteFieldTraversalPath() {
        return remoteFieldTraversalPath;
    }

    /**
     * @return The method of the remote endpoint where the remote field is coming from.
     */
    @JsonProperty("remote_method")
    public Optional<String> getRemoteMethod() {
        return remoteMethod;
    }

    /**
     * @return The path of the remote endpoint where the remote field is coming from.
     */
    @JsonProperty("remote_url_path")
    public Optional<String> getRemoteUrlPath() {
        return remoteUrlPath;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PatchedEditFieldMappingRequest && equalTo((PatchedEditFieldMappingRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PatchedEditFieldMappingRequest other) {
        return remoteFieldTraversalPath.equals(other.remoteFieldTraversalPath)
                && remoteMethod.equals(other.remoteMethod)
                && remoteUrlPath.equals(other.remoteUrlPath);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.remoteFieldTraversalPath, this.remoteMethod, this.remoteUrlPath);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<JsonNode>> remoteFieldTraversalPath = Optional.empty();

        private Optional<String> remoteMethod = Optional.empty();

        private Optional<String> remoteUrlPath = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(PatchedEditFieldMappingRequest other) {
            remoteFieldTraversalPath(other.getRemoteFieldTraversalPath());
            remoteMethod(other.getRemoteMethod());
            remoteUrlPath(other.getRemoteUrlPath());
            return this;
        }

        @JsonSetter(value = "remote_field_traversal_path", nulls = Nulls.SKIP)
        public Builder remoteFieldTraversalPath(Optional<List<JsonNode>> remoteFieldTraversalPath) {
            this.remoteFieldTraversalPath = remoteFieldTraversalPath;
            return this;
        }

        public Builder remoteFieldTraversalPath(List<JsonNode> remoteFieldTraversalPath) {
            this.remoteFieldTraversalPath = Optional.ofNullable(remoteFieldTraversalPath);
            return this;
        }

        @JsonSetter(value = "remote_method", nulls = Nulls.SKIP)
        public Builder remoteMethod(Optional<String> remoteMethod) {
            this.remoteMethod = remoteMethod;
            return this;
        }

        public Builder remoteMethod(String remoteMethod) {
            this.remoteMethod = Optional.ofNullable(remoteMethod);
            return this;
        }

        @JsonSetter(value = "remote_url_path", nulls = Nulls.SKIP)
        public Builder remoteUrlPath(Optional<String> remoteUrlPath) {
            this.remoteUrlPath = remoteUrlPath;
            return this;
        }

        public Builder remoteUrlPath(String remoteUrlPath) {
            this.remoteUrlPath = Optional.ofNullable(remoteUrlPath);
            return this;
        }

        public PatchedEditFieldMappingRequest build() {
            return new PatchedEditFieldMappingRequest(
                    remoteFieldTraversalPath, remoteMethod, remoteUrlPath, additionalProperties);
        }
    }
}

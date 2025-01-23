/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ticketing.types;

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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = MetaResponse.Builder.class)
public final class MetaResponse {
    private final Map<String, JsonNode> requestSchema;

    private final Optional<Map<String, JsonNode>> remoteFieldClasses;

    private final Optional<LinkedAccountStatus> status;

    private final boolean hasConditionalParams;

    private final boolean hasRequiredLinkedAccountParams;

    private final Map<String, Object> additionalProperties;

    private MetaResponse(
            Map<String, JsonNode> requestSchema,
            Optional<Map<String, JsonNode>> remoteFieldClasses,
            Optional<LinkedAccountStatus> status,
            boolean hasConditionalParams,
            boolean hasRequiredLinkedAccountParams,
            Map<String, Object> additionalProperties) {
        this.requestSchema = requestSchema;
        this.remoteFieldClasses = remoteFieldClasses;
        this.status = status;
        this.hasConditionalParams = hasConditionalParams;
        this.hasRequiredLinkedAccountParams = hasRequiredLinkedAccountParams;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("request_schema")
    public Map<String, JsonNode> getRequestSchema() {
        return requestSchema;
    }

    @JsonProperty("remote_field_classes")
    public Optional<Map<String, JsonNode>> getRemoteFieldClasses() {
        return remoteFieldClasses;
    }

    @JsonProperty("status")
    public Optional<LinkedAccountStatus> getStatus() {
        return status;
    }

    @JsonProperty("has_conditional_params")
    public boolean getHasConditionalParams() {
        return hasConditionalParams;
    }

    @JsonProperty("has_required_linked_account_params")
    public boolean getHasRequiredLinkedAccountParams() {
        return hasRequiredLinkedAccountParams;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MetaResponse && equalTo((MetaResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(MetaResponse other) {
        return requestSchema.equals(other.requestSchema)
                && remoteFieldClasses.equals(other.remoteFieldClasses)
                && status.equals(other.status)
                && hasConditionalParams == other.hasConditionalParams
                && hasRequiredLinkedAccountParams == other.hasRequiredLinkedAccountParams;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.requestSchema,
                this.remoteFieldClasses,
                this.status,
                this.hasConditionalParams,
                this.hasRequiredLinkedAccountParams);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static HasConditionalParamsStage builder() {
        return new Builder();
    }

    public interface HasConditionalParamsStage {
        HasRequiredLinkedAccountParamsStage hasConditionalParams(boolean hasConditionalParams);

        Builder from(MetaResponse other);
    }

    public interface HasRequiredLinkedAccountParamsStage {
        _FinalStage hasRequiredLinkedAccountParams(boolean hasRequiredLinkedAccountParams);
    }

    public interface _FinalStage {
        MetaResponse build();

        _FinalStage requestSchema(Map<String, JsonNode> requestSchema);

        _FinalStage putAllRequestSchema(Map<String, JsonNode> requestSchema);

        _FinalStage requestSchema(String key, JsonNode value);

        _FinalStage remoteFieldClasses(Optional<Map<String, JsonNode>> remoteFieldClasses);

        _FinalStage remoteFieldClasses(Map<String, JsonNode> remoteFieldClasses);

        _FinalStage status(Optional<LinkedAccountStatus> status);

        _FinalStage status(LinkedAccountStatus status);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements HasConditionalParamsStage, HasRequiredLinkedAccountParamsStage, _FinalStage {
        private boolean hasConditionalParams;

        private boolean hasRequiredLinkedAccountParams;

        private Optional<LinkedAccountStatus> status = Optional.empty();

        private Optional<Map<String, JsonNode>> remoteFieldClasses = Optional.empty();

        private Map<String, JsonNode> requestSchema = new LinkedHashMap<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(MetaResponse other) {
            requestSchema(other.getRequestSchema());
            remoteFieldClasses(other.getRemoteFieldClasses());
            status(other.getStatus());
            hasConditionalParams(other.getHasConditionalParams());
            hasRequiredLinkedAccountParams(other.getHasRequiredLinkedAccountParams());
            return this;
        }

        @java.lang.Override
        @JsonSetter("has_conditional_params")
        public HasRequiredLinkedAccountParamsStage hasConditionalParams(boolean hasConditionalParams) {
            this.hasConditionalParams = hasConditionalParams;
            return this;
        }

        @java.lang.Override
        @JsonSetter("has_required_linked_account_params")
        public _FinalStage hasRequiredLinkedAccountParams(boolean hasRequiredLinkedAccountParams) {
            this.hasRequiredLinkedAccountParams = hasRequiredLinkedAccountParams;
            return this;
        }

        @java.lang.Override
        public _FinalStage status(LinkedAccountStatus status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public _FinalStage status(Optional<LinkedAccountStatus> status) {
            this.status = status;
            return this;
        }

        @java.lang.Override
        public _FinalStage remoteFieldClasses(Map<String, JsonNode> remoteFieldClasses) {
            this.remoteFieldClasses = Optional.ofNullable(remoteFieldClasses);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "remote_field_classes", nulls = Nulls.SKIP)
        public _FinalStage remoteFieldClasses(Optional<Map<String, JsonNode>> remoteFieldClasses) {
            this.remoteFieldClasses = remoteFieldClasses;
            return this;
        }

        @java.lang.Override
        public _FinalStage requestSchema(String key, JsonNode value) {
            this.requestSchema.put(key, value);
            return this;
        }

        @java.lang.Override
        public _FinalStage putAllRequestSchema(Map<String, JsonNode> requestSchema) {
            this.requestSchema.putAll(requestSchema);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "request_schema", nulls = Nulls.SKIP)
        public _FinalStage requestSchema(Map<String, JsonNode> requestSchema) {
            this.requestSchema.clear();
            this.requestSchema.putAll(requestSchema);
            return this;
        }

        @java.lang.Override
        public MetaResponse build() {
            return new MetaResponse(
                    requestSchema,
                    remoteFieldClasses,
                    status,
                    hasConditionalParams,
                    hasRequiredLinkedAccountParams,
                    additionalProperties);
        }
    }
}

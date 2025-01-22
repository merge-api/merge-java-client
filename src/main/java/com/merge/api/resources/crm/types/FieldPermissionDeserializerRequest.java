/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.crm.types;

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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FieldPermissionDeserializerRequest.Builder.class)
public final class FieldPermissionDeserializerRequest {
    private final Optional<List<JsonNode>> enabledFields;

    private final Optional<List<JsonNode>> disabledFields;

    private final Map<String, Object> additionalProperties;

    private FieldPermissionDeserializerRequest(
            Optional<List<JsonNode>> enabledFields,
            Optional<List<JsonNode>> disabledFields,
            Map<String, Object> additionalProperties) {
        this.enabledFields = enabledFields;
        this.disabledFields = disabledFields;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("enabled_fields")
    public Optional<List<JsonNode>> getEnabledFields() {
        return enabledFields;
    }

    @JsonProperty("disabled_fields")
    public Optional<List<JsonNode>> getDisabledFields() {
        return disabledFields;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FieldPermissionDeserializerRequest
                && equalTo((FieldPermissionDeserializerRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FieldPermissionDeserializerRequest other) {
        return enabledFields.equals(other.enabledFields) && disabledFields.equals(other.disabledFields);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.enabledFields, this.disabledFields);
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
        private Optional<List<JsonNode>> enabledFields = Optional.empty();

        private Optional<List<JsonNode>> disabledFields = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(FieldPermissionDeserializerRequest other) {
            enabledFields(other.getEnabledFields());
            disabledFields(other.getDisabledFields());
            return this;
        }

        @JsonSetter(value = "enabled_fields", nulls = Nulls.SKIP)
        public Builder enabledFields(Optional<List<JsonNode>> enabledFields) {
            this.enabledFields = enabledFields;
            return this;
        }

        public Builder enabledFields(List<JsonNode> enabledFields) {
            this.enabledFields = Optional.of(enabledFields);
            return this;
        }

        @JsonSetter(value = "disabled_fields", nulls = Nulls.SKIP)
        public Builder disabledFields(Optional<List<JsonNode>> disabledFields) {
            this.disabledFields = disabledFields;
            return this;
        }

        public Builder disabledFields(List<JsonNode> disabledFields) {
            this.disabledFields = Optional.of(disabledFields);
            return this;
        }

        public FieldPermissionDeserializerRequest build() {
            return new FieldPermissionDeserializerRequest(enabledFields, disabledFields, additionalProperties);
        }
    }
}

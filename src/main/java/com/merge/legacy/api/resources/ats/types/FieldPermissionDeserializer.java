/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.ats.types;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.legacy.api.core.ObjectMappers;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = FieldPermissionDeserializer.Builder.class)
public final class FieldPermissionDeserializer {
    private final Optional<List<JsonNode>> enabledFields;

    private final Optional<List<JsonNode>> disabledFields;

    private final Map<String, Object> additionalProperties;

    private FieldPermissionDeserializer(
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FieldPermissionDeserializer && equalTo((FieldPermissionDeserializer) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FieldPermissionDeserializer other) {
        return enabledFields.equals(other.enabledFields) && disabledFields.equals(other.disabledFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.enabledFields, this.disabledFields);
    }

    @Override
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

        public Builder from(FieldPermissionDeserializer other) {
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
            this.enabledFields = Optional.ofNullable(enabledFields);
            return this;
        }

        @JsonSetter(value = "disabled_fields", nulls = Nulls.SKIP)
        public Builder disabledFields(Optional<List<JsonNode>> disabledFields) {
            this.disabledFields = disabledFields;
            return this;
        }

        public Builder disabledFields(List<JsonNode> disabledFields) {
            this.disabledFields = Optional.ofNullable(disabledFields);
            return this;
        }

        public FieldPermissionDeserializer build() {
            return new FieldPermissionDeserializer(enabledFields, disabledFields, additionalProperties);
        }
    }
}

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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ModelPermissionDeserializerRequest.Builder.class)
public final class ModelPermissionDeserializerRequest {
    private final Optional<Boolean> isEnabled;

    private final Map<String, Object> additionalProperties;

    private ModelPermissionDeserializerRequest(Optional<Boolean> isEnabled, Map<String, Object> additionalProperties) {
        this.isEnabled = isEnabled;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("is_enabled")
    public Optional<Boolean> getIsEnabled() {
        return isEnabled;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ModelPermissionDeserializerRequest
                && equalTo((ModelPermissionDeserializerRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ModelPermissionDeserializerRequest other) {
        return isEnabled.equals(other.isEnabled);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.isEnabled);
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
        private Optional<Boolean> isEnabled = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ModelPermissionDeserializerRequest other) {
            isEnabled(other.getIsEnabled());
            return this;
        }

        @JsonSetter(value = "is_enabled", nulls = Nulls.SKIP)
        public Builder isEnabled(Optional<Boolean> isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public Builder isEnabled(Boolean isEnabled) {
            this.isEnabled = Optional.ofNullable(isEnabled);
            return this;
        }

        public ModelPermissionDeserializerRequest build() {
            return new ModelPermissionDeserializerRequest(isEnabled, additionalProperties);
        }
    }
}

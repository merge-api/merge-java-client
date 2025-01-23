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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = RemoteFieldClassForCustomObjectClassFieldChoicesItem.Builder.class)
public final class RemoteFieldClassForCustomObjectClassFieldChoicesItem {
    private final Optional<JsonNode> value;

    private final Optional<String> displayName;

    private final Map<String, Object> additionalProperties;

    private RemoteFieldClassForCustomObjectClassFieldChoicesItem(
            Optional<JsonNode> value, Optional<String> displayName, Map<String, Object> additionalProperties) {
        this.value = value;
        this.displayName = displayName;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("value")
    public Optional<JsonNode> getValue() {
        return value;
    }

    @JsonProperty("display_name")
    public Optional<String> getDisplayName() {
        return displayName;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteFieldClassForCustomObjectClassFieldChoicesItem
                && equalTo((RemoteFieldClassForCustomObjectClassFieldChoicesItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RemoteFieldClassForCustomObjectClassFieldChoicesItem other) {
        return value.equals(other.value) && displayName.equals(other.displayName);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value, this.displayName);
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
        private Optional<JsonNode> value = Optional.empty();

        private Optional<String> displayName = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(RemoteFieldClassForCustomObjectClassFieldChoicesItem other) {
            value(other.getValue());
            displayName(other.getDisplayName());
            return this;
        }

        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public Builder value(Optional<JsonNode> value) {
            this.value = value;
            return this;
        }

        public Builder value(JsonNode value) {
            this.value = Optional.ofNullable(value);
            return this;
        }

        @JsonSetter(value = "display_name", nulls = Nulls.SKIP)
        public Builder displayName(Optional<String> displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = Optional.ofNullable(displayName);
            return this;
        }

        public RemoteFieldClassForCustomObjectClassFieldChoicesItem build() {
            return new RemoteFieldClassForCustomObjectClassFieldChoicesItem(value, displayName, additionalProperties);
        }
    }
}

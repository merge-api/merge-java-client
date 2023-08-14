package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RemoteFieldClassFieldChoicesItem.Builder.class)
public final class RemoteFieldClassFieldChoicesItem {
    private final Optional<JsonNode> value;

    private final Optional<String> displayName;

    private RemoteFieldClassFieldChoicesItem(Optional<JsonNode> value, Optional<String> displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    @JsonProperty("value")
    public Optional<JsonNode> getValue() {
        return value;
    }

    @JsonProperty("display_name")
    public Optional<String> getDisplayName() {
        return displayName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteFieldClassFieldChoicesItem && equalTo((RemoteFieldClassFieldChoicesItem) other);
    }

    private boolean equalTo(RemoteFieldClassFieldChoicesItem other) {
        return value.equals(other.value) && displayName.equals(other.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.displayName);
    }

    @Override
    public String toString() {
        return "RemoteFieldClassFieldChoicesItem{" + "value: " + value + ", displayName: " + displayName + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<JsonNode> value = Optional.empty();

        private Optional<String> displayName = Optional.empty();

        private Builder() {}

        public Builder from(RemoteFieldClassFieldChoicesItem other) {
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
            this.value = Optional.of(value);
            return this;
        }

        @JsonSetter(value = "display_name", nulls = Nulls.SKIP)
        public Builder displayName(Optional<String> displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = Optional.of(displayName);
            return this;
        }

        public RemoteFieldClassFieldChoicesItem build() {
            return new RemoteFieldClassFieldChoicesItem(value, displayName);
        }
    }
}

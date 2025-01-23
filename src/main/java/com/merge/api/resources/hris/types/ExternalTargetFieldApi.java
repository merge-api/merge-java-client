/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.hris.types;

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
@JsonDeserialize(builder = ExternalTargetFieldApi.Builder.class)
public final class ExternalTargetFieldApi {
    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<String> isMapped;

    private final Map<String, Object> additionalProperties;

    private ExternalTargetFieldApi(
            Optional<String> name,
            Optional<String> description,
            Optional<String> isMapped,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.description = description;
        this.isMapped = isMapped;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("is_mapped")
    public Optional<String> getIsMapped() {
        return isMapped;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExternalTargetFieldApi && equalTo((ExternalTargetFieldApi) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ExternalTargetFieldApi other) {
        return name.equals(other.name) && description.equals(other.description) && isMapped.equals(other.isMapped);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name, this.description, this.isMapped);
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
        private Optional<String> name = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> isMapped = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ExternalTargetFieldApi other) {
            name(other.getName());
            description(other.getDescription());
            isMapped(other.getIsMapped());
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        @JsonSetter(value = "is_mapped", nulls = Nulls.SKIP)
        public Builder isMapped(Optional<String> isMapped) {
            this.isMapped = isMapped;
            return this;
        }

        public Builder isMapped(String isMapped) {
            this.isMapped = Optional.ofNullable(isMapped);
            return this;
        }

        public ExternalTargetFieldApi build() {
            return new ExternalTargetFieldApi(name, description, isMapped, additionalProperties);
        }
    }
}

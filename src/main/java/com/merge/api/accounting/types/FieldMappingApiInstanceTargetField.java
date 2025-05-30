/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = FieldMappingApiInstanceTargetField.Builder.class)
public final class FieldMappingApiInstanceTargetField {
    private final String name;

    private final String description;

    private final boolean isOrganizationWide;

    private final Map<String, Object> additionalProperties;

    private FieldMappingApiInstanceTargetField(
            String name, String description, boolean isOrganizationWide, Map<String, Object> additionalProperties) {
        this.name = name;
        this.description = description;
        this.isOrganizationWide = isOrganizationWide;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("is_organization_wide")
    public boolean getIsOrganizationWide() {
        return isOrganizationWide;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FieldMappingApiInstanceTargetField
                && equalTo((FieldMappingApiInstanceTargetField) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FieldMappingApiInstanceTargetField other) {
        return name.equals(other.name)
                && description.equals(other.description)
                && isOrganizationWide == other.isOrganizationWide;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name, this.description, this.isOrganizationWide);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        DescriptionStage name(@NotNull String name);

        Builder from(FieldMappingApiInstanceTargetField other);
    }

    public interface DescriptionStage {
        IsOrganizationWideStage description(@NotNull String description);
    }

    public interface IsOrganizationWideStage {
        _FinalStage isOrganizationWide(boolean isOrganizationWide);
    }

    public interface _FinalStage {
        FieldMappingApiInstanceTargetField build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, DescriptionStage, IsOrganizationWideStage, _FinalStage {
        private String name;

        private String description;

        private boolean isOrganizationWide;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(FieldMappingApiInstanceTargetField other) {
            name(other.getName());
            description(other.getDescription());
            isOrganizationWide(other.getIsOrganizationWide());
            return this;
        }

        @java.lang.Override
        @JsonSetter("name")
        public DescriptionStage name(@NotNull String name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        @JsonSetter("description")
        public IsOrganizationWideStage description(@NotNull String description) {
            this.description = description;
            return this;
        }

        @java.lang.Override
        @JsonSetter("is_organization_wide")
        public _FinalStage isOrganizationWide(boolean isOrganizationWide) {
            this.isOrganizationWide = isOrganizationWide;
            return this;
        }

        @java.lang.Override
        public FieldMappingApiInstanceTargetField build() {
            return new FieldMappingApiInstanceTargetField(name, description, isOrganizationWide, additionalProperties);
        }
    }
}

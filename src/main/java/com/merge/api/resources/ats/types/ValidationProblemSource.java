/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ats.types;

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
@JsonDeserialize(builder = ValidationProblemSource.Builder.class)
public final class ValidationProblemSource {
    private final String pointer;

    private final Map<String, Object> additionalProperties;

    private ValidationProblemSource(String pointer, Map<String, Object> additionalProperties) {
        this.pointer = pointer;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("pointer")
    public String getPointer() {
        return pointer;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ValidationProblemSource && equalTo((ValidationProblemSource) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ValidationProblemSource other) {
        return pointer.equals(other.pointer);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.pointer);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PointerStage builder() {
        return new Builder();
    }

    public interface PointerStage {
        _FinalStage pointer(@NotNull String pointer);

        Builder from(ValidationProblemSource other);
    }

    public interface _FinalStage {
        ValidationProblemSource build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PointerStage, _FinalStage {
        private String pointer;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ValidationProblemSource other) {
            pointer(other.getPointer());
            return this;
        }

        @java.lang.Override
        @JsonSetter("pointer")
        public _FinalStage pointer(@NotNull String pointer) {
            this.pointer = pointer;
            return this;
        }

        @java.lang.Override
        public ValidationProblemSource build() {
            return new ValidationProblemSource(pointer, additionalProperties);
        }
    }
}

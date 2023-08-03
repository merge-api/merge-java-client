package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ValidationProblemSource.Builder.class)
public final class ValidationProblemSource {
    private final String pointer;

    private ValidationProblemSource(String pointer) {
        this.pointer = pointer;
    }

    @JsonProperty("pointer")
    public String getPointer() {
        return pointer;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ValidationProblemSource && equalTo((ValidationProblemSource) other);
    }

    private boolean equalTo(ValidationProblemSource other) {
        return pointer.equals(other.pointer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pointer);
    }

    @Override
    public String toString() {
        return "ValidationProblemSource{" + "pointer: " + pointer + "}";
    }

    public static PointerStage builder() {
        return new Builder();
    }

    public interface PointerStage {
        _FinalStage pointer(String pointer);

        Builder from(ValidationProblemSource other);
    }

    public interface _FinalStage {
        ValidationProblemSource build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PointerStage, _FinalStage {
        private String pointer;

        private Builder() {}

        @Override
        public Builder from(ValidationProblemSource other) {
            pointer(other.getPointer());
            return this;
        }

        @Override
        @JsonSetter("pointer")
        public _FinalStage pointer(String pointer) {
            this.pointer = pointer;
            return this;
        }

        @Override
        public ValidationProblemSource build() {
            return new ValidationProblemSource(pointer);
        }
    }
}

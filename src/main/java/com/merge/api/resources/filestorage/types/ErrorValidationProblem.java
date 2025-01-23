/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.filestorage.types;

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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ErrorValidationProblem.Builder.class)
public final class ErrorValidationProblem {
    private final Optional<ValidationProblemSource> source;

    private final String title;

    private final String detail;

    private final String problemType;

    private final Map<String, Object> additionalProperties;

    private ErrorValidationProblem(
            Optional<ValidationProblemSource> source,
            String title,
            String detail,
            String problemType,
            Map<String, Object> additionalProperties) {
        this.source = source;
        this.title = title;
        this.detail = detail;
        this.problemType = problemType;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("source")
    public Optional<ValidationProblemSource> getSource() {
        return source;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    @JsonProperty("problem_type")
    public String getProblemType() {
        return problemType;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ErrorValidationProblem && equalTo((ErrorValidationProblem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ErrorValidationProblem other) {
        return source.equals(other.source)
                && title.equals(other.title)
                && detail.equals(other.detail)
                && problemType.equals(other.problemType);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.source, this.title, this.detail, this.problemType);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TitleStage builder() {
        return new Builder();
    }

    public interface TitleStage {
        DetailStage title(@NotNull String title);

        Builder from(ErrorValidationProblem other);
    }

    public interface DetailStage {
        ProblemTypeStage detail(@NotNull String detail);
    }

    public interface ProblemTypeStage {
        _FinalStage problemType(@NotNull String problemType);
    }

    public interface _FinalStage {
        ErrorValidationProblem build();

        _FinalStage source(Optional<ValidationProblemSource> source);

        _FinalStage source(ValidationProblemSource source);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TitleStage, DetailStage, ProblemTypeStage, _FinalStage {
        private String title;

        private String detail;

        private String problemType;

        private Optional<ValidationProblemSource> source = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ErrorValidationProblem other) {
            source(other.getSource());
            title(other.getTitle());
            detail(other.getDetail());
            problemType(other.getProblemType());
            return this;
        }

        @java.lang.Override
        @JsonSetter("title")
        public DetailStage title(@NotNull String title) {
            this.title = title;
            return this;
        }

        @java.lang.Override
        @JsonSetter("detail")
        public ProblemTypeStage detail(@NotNull String detail) {
            this.detail = detail;
            return this;
        }

        @java.lang.Override
        @JsonSetter("problem_type")
        public _FinalStage problemType(@NotNull String problemType) {
            this.problemType = problemType;
            return this;
        }

        @java.lang.Override
        public _FinalStage source(ValidationProblemSource source) {
            this.source = Optional.ofNullable(source);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "source", nulls = Nulls.SKIP)
        public _FinalStage source(Optional<ValidationProblemSource> source) {
            this.source = source;
            return this;
        }

        @java.lang.Override
        public ErrorValidationProblem build() {
            return new ErrorValidationProblem(source, title, detail, problemType, additionalProperties);
        }
    }
}

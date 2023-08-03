package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = WarningValidationProblem.Builder.class)
public final class WarningValidationProblem {
    private final Optional<ValidationProblemSource> source;

    private final String title;

    private final String detail;

    private final String problemType;

    private WarningValidationProblem(
            Optional<ValidationProblemSource> source, String title, String detail, String problemType) {
        this.source = source;
        this.title = title;
        this.detail = detail;
        this.problemType = problemType;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WarningValidationProblem && equalTo((WarningValidationProblem) other);
    }

    private boolean equalTo(WarningValidationProblem other) {
        return source.equals(other.source)
                && title.equals(other.title)
                && detail.equals(other.detail)
                && problemType.equals(other.problemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.title, this.detail, this.problemType);
    }

    @Override
    public String toString() {
        return "WarningValidationProblem{" + "source: " + source + ", title: " + title + ", detail: " + detail
                + ", problemType: " + problemType + "}";
    }

    public static TitleStage builder() {
        return new Builder();
    }

    public interface TitleStage {
        DetailStage title(String title);

        Builder from(WarningValidationProblem other);
    }

    public interface DetailStage {
        ProblemTypeStage detail(String detail);
    }

    public interface ProblemTypeStage {
        _FinalStage problemType(String problemType);
    }

    public interface _FinalStage {
        WarningValidationProblem build();

        _FinalStage source(Optional<ValidationProblemSource> source);

        _FinalStage source(ValidationProblemSource source);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TitleStage, DetailStage, ProblemTypeStage, _FinalStage {
        private String title;

        private String detail;

        private String problemType;

        private Optional<ValidationProblemSource> source = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(WarningValidationProblem other) {
            source(other.getSource());
            title(other.getTitle());
            detail(other.getDetail());
            problemType(other.getProblemType());
            return this;
        }

        @Override
        @JsonSetter("title")
        public DetailStage title(String title) {
            this.title = title;
            return this;
        }

        @Override
        @JsonSetter("detail")
        public ProblemTypeStage detail(String detail) {
            this.detail = detail;
            return this;
        }

        @Override
        @JsonSetter("problem_type")
        public _FinalStage problemType(String problemType) {
            this.problemType = problemType;
            return this;
        }

        @Override
        public _FinalStage source(ValidationProblemSource source) {
            this.source = Optional.of(source);
            return this;
        }

        @Override
        @JsonSetter(value = "source", nulls = Nulls.SKIP)
        public _FinalStage source(Optional<ValidationProblemSource> source) {
            this.source = source;
            return this;
        }

        @Override
        public WarningValidationProblem build() {
            return new WarningValidationProblem(source, title, detail, problemType);
        }
    }
}
package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PaginatedJobList.Builder.class)
public final class PaginatedJobList {
    private final Optional<String> next;

    private final Optional<String> previous;

    private final Optional<List<Job>> results;

    private PaginatedJobList(Optional<String> next, Optional<String> previous, Optional<List<Job>> results) {
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    @JsonProperty("next")
    public Optional<String> getNext() {
        return next;
    }

    @JsonProperty("previous")
    public Optional<String> getPrevious() {
        return previous;
    }

    @JsonProperty("results")
    public Optional<List<Job>> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaginatedJobList && equalTo((PaginatedJobList) other);
    }

    private boolean equalTo(PaginatedJobList other) {
        return next.equals(other.next) && previous.equals(other.previous) && results.equals(other.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.next, this.previous, this.results);
    }

    @Override
    public String toString() {
        return "PaginatedJobList{" + "next: " + next + ", previous: " + previous + ", results: " + results + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> next = Optional.empty();

        private Optional<String> previous = Optional.empty();

        private Optional<List<Job>> results = Optional.empty();

        private Builder() {}

        public Builder from(PaginatedJobList other) {
            next(other.getNext());
            previous(other.getPrevious());
            results(other.getResults());
            return this;
        }

        @JsonSetter(value = "next", nulls = Nulls.SKIP)
        public Builder next(Optional<String> next) {
            this.next = next;
            return this;
        }

        public Builder next(String next) {
            this.next = Optional.of(next);
            return this;
        }

        @JsonSetter(value = "previous", nulls = Nulls.SKIP)
        public Builder previous(Optional<String> previous) {
            this.previous = previous;
            return this;
        }

        public Builder previous(String previous) {
            this.previous = Optional.of(previous);
            return this;
        }

        @JsonSetter(value = "results", nulls = Nulls.SKIP)
        public Builder results(Optional<List<Job>> results) {
            this.results = results;
            return this;
        }

        public Builder results(List<Job> results) {
            this.results = Optional.of(results);
            return this;
        }

        public PaginatedJobList build() {
            return new PaginatedJobList(next, previous, results);
        }
    }
}

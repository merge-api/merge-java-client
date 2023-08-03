package com.merge.api.resources.crm.types;

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
@JsonDeserialize(builder = PaginatedEngagementList.Builder.class)
public final class PaginatedEngagementList {
    private final Optional<String> next;

    private final Optional<String> previous;

    private final Optional<List<Engagement>> results;

    private PaginatedEngagementList(
            Optional<String> next, Optional<String> previous, Optional<List<Engagement>> results) {
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
    public Optional<List<Engagement>> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaginatedEngagementList && equalTo((PaginatedEngagementList) other);
    }

    private boolean equalTo(PaginatedEngagementList other) {
        return next.equals(other.next) && previous.equals(other.previous) && results.equals(other.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.next, this.previous, this.results);
    }

    @Override
    public String toString() {
        return "PaginatedEngagementList{" + "next: " + next + ", previous: " + previous + ", results: " + results + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> next = Optional.empty();

        private Optional<String> previous = Optional.empty();

        private Optional<List<Engagement>> results = Optional.empty();

        private Builder() {}

        public Builder from(PaginatedEngagementList other) {
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
        public Builder results(Optional<List<Engagement>> results) {
            this.results = results;
            return this;
        }

        public Builder results(List<Engagement> results) {
            this.results = Optional.of(results);
            return this;
        }

        public PaginatedEngagementList build() {
            return new PaginatedEngagementList(next, previous, results);
        }
    }
}

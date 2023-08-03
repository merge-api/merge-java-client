package com.merge.api.resources.accounting.types;

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
@JsonDeserialize(builder = PaginatedAccountingAttachmentList.Builder.class)
public final class PaginatedAccountingAttachmentList {
    private final Optional<String> next;

    private final Optional<String> previous;

    private final Optional<List<AccountingAttachment>> results;

    private PaginatedAccountingAttachmentList(
            Optional<String> next, Optional<String> previous, Optional<List<AccountingAttachment>> results) {
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
    public Optional<List<AccountingAttachment>> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaginatedAccountingAttachmentList && equalTo((PaginatedAccountingAttachmentList) other);
    }

    private boolean equalTo(PaginatedAccountingAttachmentList other) {
        return next.equals(other.next) && previous.equals(other.previous) && results.equals(other.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.next, this.previous, this.results);
    }

    @Override
    public String toString() {
        return "PaginatedAccountingAttachmentList{" + "next: " + next + ", previous: " + previous + ", results: "
                + results + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> next = Optional.empty();

        private Optional<String> previous = Optional.empty();

        private Optional<List<AccountingAttachment>> results = Optional.empty();

        private Builder() {}

        public Builder from(PaginatedAccountingAttachmentList other) {
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
        public Builder results(Optional<List<AccountingAttachment>> results) {
            this.results = results;
            return this;
        }

        public Builder results(List<AccountingAttachment> results) {
            this.results = Optional.of(results);
            return this;
        }

        public PaginatedAccountingAttachmentList build() {
            return new PaginatedAccountingAttachmentList(next, previous, results);
        }
    }
}

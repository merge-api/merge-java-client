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
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PaginatedPaymentMethodList.Builder.class)
public final class PaginatedPaymentMethodList {
    private final Optional<String> next;

    private final Optional<String> previous;

    private final Optional<List<PaymentMethod>> results;

    private final Map<String, Object> additionalProperties;

    private PaginatedPaymentMethodList(
            Optional<String> next,
            Optional<String> previous,
            Optional<List<PaymentMethod>> results,
            Map<String, Object> additionalProperties) {
        this.next = next;
        this.previous = previous;
        this.results = results;
        this.additionalProperties = additionalProperties;
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
    public Optional<List<PaymentMethod>> getResults() {
        return results;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaginatedPaymentMethodList && equalTo((PaginatedPaymentMethodList) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PaginatedPaymentMethodList other) {
        return next.equals(other.next) && previous.equals(other.previous) && results.equals(other.results);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.next, this.previous, this.results);
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
        private Optional<String> next = Optional.empty();

        private Optional<String> previous = Optional.empty();

        private Optional<List<PaymentMethod>> results = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(PaginatedPaymentMethodList other) {
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
            this.next = Optional.ofNullable(next);
            return this;
        }

        @JsonSetter(value = "previous", nulls = Nulls.SKIP)
        public Builder previous(Optional<String> previous) {
            this.previous = previous;
            return this;
        }

        public Builder previous(String previous) {
            this.previous = Optional.ofNullable(previous);
            return this;
        }

        @JsonSetter(value = "results", nulls = Nulls.SKIP)
        public Builder results(Optional<List<PaymentMethod>> results) {
            this.results = results;
            return this;
        }

        public Builder results(List<PaymentMethod> results) {
            this.results = Optional.ofNullable(results);
            return this;
        }

        public PaginatedPaymentMethodList build() {
            return new PaginatedPaymentMethodList(next, previous, results, additionalProperties);
        }
    }
}

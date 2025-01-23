/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = AsyncPostTaskResult.Builder.class)
public final class AsyncPostTaskResult {
    private final Optional<Integer> statusCode;

    private final Optional<Map<String, JsonNode>> response;

    private final Map<String, Object> additionalProperties;

    private AsyncPostTaskResult(
            Optional<Integer> statusCode,
            Optional<Map<String, JsonNode>> response,
            Map<String, Object> additionalProperties) {
        this.statusCode = statusCode;
        this.response = response;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("status_code")
    public Optional<Integer> getStatusCode() {
        return statusCode;
    }

    @JsonProperty("response")
    public Optional<Map<String, JsonNode>> getResponse() {
        return response;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AsyncPostTaskResult && equalTo((AsyncPostTaskResult) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(AsyncPostTaskResult other) {
        return statusCode.equals(other.statusCode) && response.equals(other.response);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.statusCode, this.response);
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
        private Optional<Integer> statusCode = Optional.empty();

        private Optional<Map<String, JsonNode>> response = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(AsyncPostTaskResult other) {
            statusCode(other.getStatusCode());
            response(other.getResponse());
            return this;
        }

        @JsonSetter(value = "status_code", nulls = Nulls.SKIP)
        public Builder statusCode(Optional<Integer> statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder statusCode(Integer statusCode) {
            this.statusCode = Optional.ofNullable(statusCode);
            return this;
        }

        @JsonSetter(value = "response", nulls = Nulls.SKIP)
        public Builder response(Optional<Map<String, JsonNode>> response) {
            this.response = response;
            return this;
        }

        public Builder response(Map<String, JsonNode> response) {
            this.response = Optional.ofNullable(response);
            return this;
        }

        public AsyncPostTaskResult build() {
            return new AsyncPostTaskResult(statusCode, response, additionalProperties);
        }
    }
}

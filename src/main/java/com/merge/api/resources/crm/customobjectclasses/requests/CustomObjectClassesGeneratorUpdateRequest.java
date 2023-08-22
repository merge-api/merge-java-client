package com.merge.api.resources.crm.customobjectclasses.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CustomObjectClassesGeneratorUpdateRequest.Builder.class)
public final class CustomObjectClassesGeneratorUpdateRequest {
    private final Optional<Boolean> isDebugMode;

    private final Optional<Boolean> runAsync;

    private CustomObjectClassesGeneratorUpdateRequest(Optional<Boolean> isDebugMode, Optional<Boolean> runAsync) {
        this.isDebugMode = isDebugMode;
        this.runAsync = runAsync;
    }

    /**
     * @return Whether to include debug fields (such as log file links) in the response.
     */
    @JsonProperty("is_debug_mode")
    public Optional<Boolean> getIsDebugMode() {
        return isDebugMode;
    }

    /**
     * @return Whether or not third-party updates should be run asynchronously.
     */
    @JsonProperty("run_async")
    public Optional<Boolean> getRunAsync() {
        return runAsync;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CustomObjectClassesGeneratorUpdateRequest
                && equalTo((CustomObjectClassesGeneratorUpdateRequest) other);
    }

    private boolean equalTo(CustomObjectClassesGeneratorUpdateRequest other) {
        return isDebugMode.equals(other.isDebugMode) && runAsync.equals(other.runAsync);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isDebugMode, this.runAsync);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> isDebugMode = Optional.empty();

        private Optional<Boolean> runAsync = Optional.empty();

        private Builder() {}

        public Builder from(CustomObjectClassesGeneratorUpdateRequest other) {
            isDebugMode(other.getIsDebugMode());
            runAsync(other.getRunAsync());
            return this;
        }

        @JsonSetter(value = "is_debug_mode", nulls = Nulls.SKIP)
        public Builder isDebugMode(Optional<Boolean> isDebugMode) {
            this.isDebugMode = isDebugMode;
            return this;
        }

        public Builder isDebugMode(Boolean isDebugMode) {
            this.isDebugMode = Optional.of(isDebugMode);
            return this;
        }

        @JsonSetter(value = "run_async", nulls = Nulls.SKIP)
        public Builder runAsync(Optional<Boolean> runAsync) {
            this.runAsync = runAsync;
            return this;
        }

        public Builder runAsync(Boolean runAsync) {
            this.runAsync = Optional.of(runAsync);
            return this;
        }

        public CustomObjectClassesGeneratorUpdateRequest build() {
            return new CustomObjectClassesGeneratorUpdateRequest(isDebugMode, runAsync);
        }
    }
}

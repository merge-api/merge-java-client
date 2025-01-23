/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ticketing.comments.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.ticketing.types.CommentRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CommentEndpointRequest.Builder.class)
public final class CommentEndpointRequest {
    private final Optional<Boolean> isDebugMode;

    private final Optional<Boolean> runAsync;

    private final CommentRequest model;

    private final Map<String, Object> additionalProperties;

    private CommentEndpointRequest(
            Optional<Boolean> isDebugMode,
            Optional<Boolean> runAsync,
            CommentRequest model,
            Map<String, Object> additionalProperties) {
        this.isDebugMode = isDebugMode;
        this.runAsync = runAsync;
        this.model = model;
        this.additionalProperties = additionalProperties;
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

    @JsonProperty("model")
    public CommentRequest getModel() {
        return model;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CommentEndpointRequest && equalTo((CommentEndpointRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CommentEndpointRequest other) {
        return isDebugMode.equals(other.isDebugMode) && runAsync.equals(other.runAsync) && model.equals(other.model);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.isDebugMode, this.runAsync, this.model);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelStage builder() {
        return new Builder();
    }

    public interface ModelStage {
        _FinalStage model(@NotNull CommentRequest model);

        Builder from(CommentEndpointRequest other);
    }

    public interface _FinalStage {
        CommentEndpointRequest build();

        _FinalStage isDebugMode(Optional<Boolean> isDebugMode);

        _FinalStage isDebugMode(Boolean isDebugMode);

        _FinalStage runAsync(Optional<Boolean> runAsync);

        _FinalStage runAsync(Boolean runAsync);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModelStage, _FinalStage {
        private CommentRequest model;

        private Optional<Boolean> runAsync = Optional.empty();

        private Optional<Boolean> isDebugMode = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CommentEndpointRequest other) {
            isDebugMode(other.getIsDebugMode());
            runAsync(other.getRunAsync());
            model(other.getModel());
            return this;
        }

        @java.lang.Override
        @JsonSetter("model")
        public _FinalStage model(@NotNull CommentRequest model) {
            this.model = model;
            return this;
        }

        /**
         * <p>Whether or not third-party updates should be run asynchronously.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage runAsync(Boolean runAsync) {
            this.runAsync = Optional.ofNullable(runAsync);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "run_async", nulls = Nulls.SKIP)
        public _FinalStage runAsync(Optional<Boolean> runAsync) {
            this.runAsync = runAsync;
            return this;
        }

        /**
         * <p>Whether to include debug fields (such as log file links) in the response.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage isDebugMode(Boolean isDebugMode) {
            this.isDebugMode = Optional.ofNullable(isDebugMode);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "is_debug_mode", nulls = Nulls.SKIP)
        public _FinalStage isDebugMode(Optional<Boolean> isDebugMode) {
            this.isDebugMode = isDebugMode;
            return this;
        }

        @java.lang.Override
        public CommentEndpointRequest build() {
            return new CommentEndpointRequest(isDebugMode, runAsync, model, additionalProperties);
        }
    }
}

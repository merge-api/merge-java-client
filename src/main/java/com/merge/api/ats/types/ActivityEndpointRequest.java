/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

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
@JsonDeserialize(builder = ActivityEndpointRequest.Builder.class)
public final class ActivityEndpointRequest {
    private final Optional<Boolean> isDebugMode;

    private final Optional<Boolean> runAsync;

    private final ActivityRequest model;

    private final String remoteUserId;

    private final Map<String, Object> additionalProperties;

    private ActivityEndpointRequest(
            Optional<Boolean> isDebugMode,
            Optional<Boolean> runAsync,
            ActivityRequest model,
            String remoteUserId,
            Map<String, Object> additionalProperties) {
        this.isDebugMode = isDebugMode;
        this.runAsync = runAsync;
        this.model = model;
        this.remoteUserId = remoteUserId;
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
    public ActivityRequest getModel() {
        return model;
    }

    @JsonProperty("remote_user_id")
    public String getRemoteUserId() {
        return remoteUserId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ActivityEndpointRequest && equalTo((ActivityEndpointRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ActivityEndpointRequest other) {
        return isDebugMode.equals(other.isDebugMode)
                && runAsync.equals(other.runAsync)
                && model.equals(other.model)
                && remoteUserId.equals(other.remoteUserId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.isDebugMode, this.runAsync, this.model, this.remoteUserId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelStage builder() {
        return new Builder();
    }

    public interface ModelStage {
        RemoteUserIdStage model(@NotNull ActivityRequest model);

        Builder from(ActivityEndpointRequest other);
    }

    public interface RemoteUserIdStage {
        _FinalStage remoteUserId(@NotNull String remoteUserId);
    }

    public interface _FinalStage {
        ActivityEndpointRequest build();

        /**
         * <p>Whether to include debug fields (such as log file links) in the response.</p>
         */
        _FinalStage isDebugMode(Optional<Boolean> isDebugMode);

        _FinalStage isDebugMode(Boolean isDebugMode);

        /**
         * <p>Whether or not third-party updates should be run asynchronously.</p>
         */
        _FinalStage runAsync(Optional<Boolean> runAsync);

        _FinalStage runAsync(Boolean runAsync);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModelStage, RemoteUserIdStage, _FinalStage {
        private ActivityRequest model;

        private String remoteUserId;

        private Optional<Boolean> runAsync = Optional.empty();

        private Optional<Boolean> isDebugMode = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ActivityEndpointRequest other) {
            isDebugMode(other.getIsDebugMode());
            runAsync(other.getRunAsync());
            model(other.getModel());
            remoteUserId(other.getRemoteUserId());
            return this;
        }

        @java.lang.Override
        @JsonSetter("model")
        public RemoteUserIdStage model(@NotNull ActivityRequest model) {
            this.model = model;
            return this;
        }

        @java.lang.Override
        @JsonSetter("remote_user_id")
        public _FinalStage remoteUserId(@NotNull String remoteUserId) {
            this.remoteUserId = remoteUserId;
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

        /**
         * <p>Whether or not third-party updates should be run asynchronously.</p>
         */
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

        /**
         * <p>Whether to include debug fields (such as log file links) in the response.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "is_debug_mode", nulls = Nulls.SKIP)
        public _FinalStage isDebugMode(Optional<Boolean> isDebugMode) {
            this.isDebugMode = isDebugMode;
            return this;
        }

        @java.lang.Override
        public ActivityEndpointRequest build() {
            return new ActivityEndpointRequest(isDebugMode, runAsync, model, remoteUserId, additionalProperties);
        }
    }
}

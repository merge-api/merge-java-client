package com.merge.api.resources.crm.opportunities.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.resources.crm.types.PatchedOpportunityRequest;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PatchedOpportunityEndpointRequest.Builder.class)
public final class PatchedOpportunityEndpointRequest {
    private final Optional<Boolean> isDebugMode;

    private final Optional<Boolean> runAsync;

    private final PatchedOpportunityRequest model;

    private PatchedOpportunityEndpointRequest(
            Optional<Boolean> isDebugMode, Optional<Boolean> runAsync, PatchedOpportunityRequest model) {
        this.isDebugMode = isDebugMode;
        this.runAsync = runAsync;
        this.model = model;
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
    public PatchedOpportunityRequest getModel() {
        return model;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PatchedOpportunityEndpointRequest && equalTo((PatchedOpportunityEndpointRequest) other);
    }

    private boolean equalTo(PatchedOpportunityEndpointRequest other) {
        return isDebugMode.equals(other.isDebugMode) && runAsync.equals(other.runAsync) && model.equals(other.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isDebugMode, this.runAsync, this.model);
    }

    @Override
    public String toString() {
        return "PatchedOpportunityEndpointRequest{" + "isDebugMode: " + isDebugMode + ", runAsync: " + runAsync
                + ", model: " + model + "}";
    }

    public static ModelStage builder() {
        return new Builder();
    }

    public interface ModelStage {
        _FinalStage model(PatchedOpportunityRequest model);

        Builder from(PatchedOpportunityEndpointRequest other);
    }

    public interface _FinalStage {
        PatchedOpportunityEndpointRequest build();

        _FinalStage isDebugMode(Optional<Boolean> isDebugMode);

        _FinalStage isDebugMode(Boolean isDebugMode);

        _FinalStage runAsync(Optional<Boolean> runAsync);

        _FinalStage runAsync(Boolean runAsync);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModelStage, _FinalStage {
        private PatchedOpportunityRequest model;

        private Optional<Boolean> runAsync = Optional.empty();

        private Optional<Boolean> isDebugMode = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(PatchedOpportunityEndpointRequest other) {
            isDebugMode(other.getIsDebugMode());
            runAsync(other.getRunAsync());
            model(other.getModel());
            return this;
        }

        @Override
        @JsonSetter("model")
        public _FinalStage model(PatchedOpportunityRequest model) {
            this.model = model;
            return this;
        }

        /**
         * <p>Whether or not third-party updates should be run asynchronously.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage runAsync(Boolean runAsync) {
            this.runAsync = Optional.of(runAsync);
            return this;
        }

        @Override
        @JsonSetter(value = "run_async", nulls = Nulls.SKIP)
        public _FinalStage runAsync(Optional<Boolean> runAsync) {
            this.runAsync = runAsync;
            return this;
        }

        /**
         * <p>Whether to include debug fields (such as log file links) in the response.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isDebugMode(Boolean isDebugMode) {
            this.isDebugMode = Optional.of(isDebugMode);
            return this;
        }

        @Override
        @JsonSetter(value = "is_debug_mode", nulls = Nulls.SKIP)
        public _FinalStage isDebugMode(Optional<Boolean> isDebugMode) {
            this.isDebugMode = isDebugMode;
            return this;
        }

        @Override
        public PatchedOpportunityEndpointRequest build() {
            return new PatchedOpportunityEndpointRequest(isDebugMode, runAsync, model);
        }
    }
}

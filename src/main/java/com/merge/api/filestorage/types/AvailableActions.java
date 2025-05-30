/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.filestorage.types;

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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = AvailableActions.Builder.class)
public final class AvailableActions {
    private final AccountIntegration integration;

    private final boolean passthroughAvailable;

    private final Optional<List<ModelOperation>> availableModelOperations;

    private final Map<String, Object> additionalProperties;

    private AvailableActions(
            AccountIntegration integration,
            boolean passthroughAvailable,
            Optional<List<ModelOperation>> availableModelOperations,
            Map<String, Object> additionalProperties) {
        this.integration = integration;
        this.passthroughAvailable = passthroughAvailable;
        this.availableModelOperations = availableModelOperations;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("integration")
    public AccountIntegration getIntegration() {
        return integration;
    }

    @JsonProperty("passthrough_available")
    public boolean getPassthroughAvailable() {
        return passthroughAvailable;
    }

    @JsonProperty("available_model_operations")
    public Optional<List<ModelOperation>> getAvailableModelOperations() {
        return availableModelOperations;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AvailableActions && equalTo((AvailableActions) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(AvailableActions other) {
        return integration.equals(other.integration)
                && passthroughAvailable == other.passthroughAvailable
                && availableModelOperations.equals(other.availableModelOperations);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.integration, this.passthroughAvailable, this.availableModelOperations);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IntegrationStage builder() {
        return new Builder();
    }

    public interface IntegrationStage {
        PassthroughAvailableStage integration(@NotNull AccountIntegration integration);

        Builder from(AvailableActions other);
    }

    public interface PassthroughAvailableStage {
        _FinalStage passthroughAvailable(boolean passthroughAvailable);
    }

    public interface _FinalStage {
        AvailableActions build();

        _FinalStage availableModelOperations(Optional<List<ModelOperation>> availableModelOperations);

        _FinalStage availableModelOperations(List<ModelOperation> availableModelOperations);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IntegrationStage, PassthroughAvailableStage, _FinalStage {
        private AccountIntegration integration;

        private boolean passthroughAvailable;

        private Optional<List<ModelOperation>> availableModelOperations = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(AvailableActions other) {
            integration(other.getIntegration());
            passthroughAvailable(other.getPassthroughAvailable());
            availableModelOperations(other.getAvailableModelOperations());
            return this;
        }

        @java.lang.Override
        @JsonSetter("integration")
        public PassthroughAvailableStage integration(@NotNull AccountIntegration integration) {
            this.integration = integration;
            return this;
        }

        @java.lang.Override
        @JsonSetter("passthrough_available")
        public _FinalStage passthroughAvailable(boolean passthroughAvailable) {
            this.passthroughAvailable = passthroughAvailable;
            return this;
        }

        @java.lang.Override
        public _FinalStage availableModelOperations(List<ModelOperation> availableModelOperations) {
            this.availableModelOperations = Optional.ofNullable(availableModelOperations);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "available_model_operations", nulls = Nulls.SKIP)
        public _FinalStage availableModelOperations(Optional<List<ModelOperation>> availableModelOperations) {
            this.availableModelOperations = availableModelOperations;
            return this;
        }

        @java.lang.Override
        public AvailableActions build() {
            return new AvailableActions(
                    integration, passthroughAvailable, availableModelOperations, additionalProperties);
        }
    }
}

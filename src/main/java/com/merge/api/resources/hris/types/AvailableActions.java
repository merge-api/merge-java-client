package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AvailableActions.Builder.class)
public final class AvailableActions {
    private final AccountIntegration integration;

    private final boolean passthroughAvailable;

    private final Optional<List<ModelOperation>> availableModelOperations;

    private AvailableActions(
            AccountIntegration integration,
            boolean passthroughAvailable,
            Optional<List<ModelOperation>> availableModelOperations) {
        this.integration = integration;
        this.passthroughAvailable = passthroughAvailable;
        this.availableModelOperations = availableModelOperations;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AvailableActions && equalTo((AvailableActions) other);
    }

    private boolean equalTo(AvailableActions other) {
        return integration.equals(other.integration)
                && passthroughAvailable == other.passthroughAvailable
                && availableModelOperations.equals(other.availableModelOperations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.integration, this.passthroughAvailable, this.availableModelOperations);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IntegrationStage builder() {
        return new Builder();
    }

    public interface IntegrationStage {
        PassthroughAvailableStage integration(AccountIntegration integration);

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

        private Builder() {}

        @Override
        public Builder from(AvailableActions other) {
            integration(other.getIntegration());
            passthroughAvailable(other.getPassthroughAvailable());
            availableModelOperations(other.getAvailableModelOperations());
            return this;
        }

        @Override
        @JsonSetter("integration")
        public PassthroughAvailableStage integration(AccountIntegration integration) {
            this.integration = integration;
            return this;
        }

        @Override
        @JsonSetter("passthrough_available")
        public _FinalStage passthroughAvailable(boolean passthroughAvailable) {
            this.passthroughAvailable = passthroughAvailable;
            return this;
        }

        @Override
        public _FinalStage availableModelOperations(List<ModelOperation> availableModelOperations) {
            this.availableModelOperations = Optional.of(availableModelOperations);
            return this;
        }

        @Override
        @JsonSetter(value = "available_model_operations", nulls = Nulls.SKIP)
        public _FinalStage availableModelOperations(Optional<List<ModelOperation>> availableModelOperations) {
            this.availableModelOperations = availableModelOperations;
            return this;
        }

        @Override
        public AvailableActions build() {
            return new AvailableActions(integration, passthroughAvailable, availableModelOperations);
        }
    }
}

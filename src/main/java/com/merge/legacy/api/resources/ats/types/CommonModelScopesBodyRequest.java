/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.ats.types;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.legacy.api.core.ObjectMappers;
import java.util.*;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CommonModelScopesBodyRequest.Builder.class)
public final class CommonModelScopesBodyRequest {
    private final String modelId;

    private final List<EnabledActionsEnum> enabledActions;

    private final List<String> disabledFields;

    private final Map<String, Object> additionalProperties;

    private CommonModelScopesBodyRequest(
            String modelId,
            List<EnabledActionsEnum> enabledActions,
            List<String> disabledFields,
            Map<String, Object> additionalProperties) {
        this.modelId = modelId;
        this.enabledActions = enabledActions;
        this.disabledFields = disabledFields;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("model_id")
    public String getModelId() {
        return modelId;
    }

    @JsonProperty("enabled_actions")
    public List<EnabledActionsEnum> getEnabledActions() {
        return enabledActions;
    }

    @JsonProperty("disabled_fields")
    public List<String> getDisabledFields() {
        return disabledFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CommonModelScopesBodyRequest && equalTo((CommonModelScopesBodyRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CommonModelScopesBodyRequest other) {
        return modelId.equals(other.modelId)
                && enabledActions.equals(other.enabledActions)
                && disabledFields.equals(other.disabledFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.modelId, this.enabledActions, this.disabledFields);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelIdStage builder() {
        return new Builder();
    }

    public interface ModelIdStage {
        _FinalStage modelId(@NotNull String modelId);

        Builder from(CommonModelScopesBodyRequest other);
    }

    public interface _FinalStage {
        CommonModelScopesBodyRequest build();

        _FinalStage enabledActions(List<EnabledActionsEnum> enabledActions);

        _FinalStage addEnabledActions(EnabledActionsEnum enabledActions);

        _FinalStage addAllEnabledActions(List<EnabledActionsEnum> enabledActions);

        _FinalStage disabledFields(List<String> disabledFields);

        _FinalStage addDisabledFields(String disabledFields);

        _FinalStage addAllDisabledFields(List<String> disabledFields);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModelIdStage, _FinalStage {
        private String modelId;

        private List<String> disabledFields = new ArrayList<>();

        private List<EnabledActionsEnum> enabledActions = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(CommonModelScopesBodyRequest other) {
            modelId(other.getModelId());
            enabledActions(other.getEnabledActions());
            disabledFields(other.getDisabledFields());
            return this;
        }

        @Override
        @JsonSetter("model_id")
        public _FinalStage modelId(@NotNull String modelId) {
            this.modelId = modelId;
            return this;
        }

        @Override
        public _FinalStage addAllDisabledFields(List<String> disabledFields) {
            this.disabledFields.addAll(disabledFields);
            return this;
        }

        @Override
        public _FinalStage addDisabledFields(String disabledFields) {
            this.disabledFields.add(disabledFields);
            return this;
        }

        @Override
        @JsonSetter(value = "disabled_fields", nulls = Nulls.SKIP)
        public _FinalStage disabledFields(List<String> disabledFields) {
            this.disabledFields.clear();
            this.disabledFields.addAll(disabledFields);
            return this;
        }

        @Override
        public _FinalStage addAllEnabledActions(List<EnabledActionsEnum> enabledActions) {
            this.enabledActions.addAll(enabledActions);
            return this;
        }

        @Override
        public _FinalStage addEnabledActions(EnabledActionsEnum enabledActions) {
            this.enabledActions.add(enabledActions);
            return this;
        }

        @Override
        @JsonSetter(value = "enabled_actions", nulls = Nulls.SKIP)
        public _FinalStage enabledActions(List<EnabledActionsEnum> enabledActions) {
            this.enabledActions.clear();
            this.enabledActions.addAll(enabledActions);
            return this;
        }

        @Override
        public CommonModelScopesBodyRequest build() {
            return new CommonModelScopesBodyRequest(modelId, enabledActions, disabledFields, additionalProperties);
        }
    }
}

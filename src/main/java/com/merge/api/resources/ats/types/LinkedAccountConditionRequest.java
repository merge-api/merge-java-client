package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LinkedAccountConditionRequest.Builder.class)
public final class LinkedAccountConditionRequest {
    private final String conditionSchemaId;

    private final String operator;

    private final JsonNode value;

    private LinkedAccountConditionRequest(String conditionSchemaId, String operator, JsonNode value) {
        this.conditionSchemaId = conditionSchemaId;
        this.operator = operator;
        this.value = value;
    }

    /**
     * @return The ID indicating which condition schema to use for a specific condition.
     */
    @JsonProperty("condition_schema_id")
    public String getConditionSchemaId() {
        return conditionSchemaId;
    }

    /**
     * @return The operator for a specific condition.
     */
    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    @JsonProperty("value")
    public JsonNode getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LinkedAccountConditionRequest && equalTo((LinkedAccountConditionRequest) other);
    }

    private boolean equalTo(LinkedAccountConditionRequest other) {
        return conditionSchemaId.equals(other.conditionSchemaId)
                && operator.equals(other.operator)
                && value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.conditionSchemaId, this.operator, this.value);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ConditionSchemaIdStage builder() {
        return new Builder();
    }

    public interface ConditionSchemaIdStage {
        OperatorStage conditionSchemaId(String conditionSchemaId);

        Builder from(LinkedAccountConditionRequest other);
    }

    public interface OperatorStage {
        ValueStage operator(String operator);
    }

    public interface ValueStage {
        _FinalStage value(JsonNode value);
    }

    public interface _FinalStage {
        LinkedAccountConditionRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ConditionSchemaIdStage, OperatorStage, ValueStage, _FinalStage {
        private String conditionSchemaId;

        private String operator;

        private JsonNode value;

        private Builder() {}

        @Override
        public Builder from(LinkedAccountConditionRequest other) {
            conditionSchemaId(other.getConditionSchemaId());
            operator(other.getOperator());
            value(other.getValue());
            return this;
        }

        /**
         * <p>The ID indicating which condition schema to use for a specific condition.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("condition_schema_id")
        public OperatorStage conditionSchemaId(String conditionSchemaId) {
            this.conditionSchemaId = conditionSchemaId;
            return this;
        }

        /**
         * <p>The operator for a specific condition.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("operator")
        public ValueStage operator(String operator) {
            this.operator = operator;
            return this;
        }

        @Override
        @JsonSetter("value")
        public _FinalStage value(JsonNode value) {
            this.value = value;
            return this;
        }

        @Override
        public LinkedAccountConditionRequest build() {
            return new LinkedAccountConditionRequest(conditionSchemaId, operator, value);
        }
    }
}

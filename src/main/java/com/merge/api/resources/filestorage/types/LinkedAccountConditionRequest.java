/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.filestorage.types;

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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LinkedAccountConditionRequest.Builder.class)
public final class LinkedAccountConditionRequest {
    private final Optional<String> id;

    private final String conditionSchemaId;

    private final String operator;

    private final JsonNode value;

    private final Map<String, Object> additionalProperties;

    private LinkedAccountConditionRequest(
            Optional<String> id,
            String conditionSchemaId,
            String operator,
            JsonNode value,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.conditionSchemaId = conditionSchemaId;
        this.operator = operator;
        this.value = value;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID indicating which Linked Account Condition this is.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
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

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LinkedAccountConditionRequest && equalTo((LinkedAccountConditionRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LinkedAccountConditionRequest other) {
        return id.equals(other.id)
                && conditionSchemaId.equals(other.conditionSchemaId)
                && operator.equals(other.operator)
                && value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.conditionSchemaId, this.operator, this.value);
    }

    @java.lang.Override
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

        _FinalStage id(Optional<String> id);

        _FinalStage id(String id);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ConditionSchemaIdStage, OperatorStage, ValueStage, _FinalStage {
        private String conditionSchemaId;

        private String operator;

        private JsonNode value;

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LinkedAccountConditionRequest other) {
            id(other.getId());
            conditionSchemaId(other.getConditionSchemaId());
            operator(other.getOperator());
            value(other.getValue());
            return this;
        }

        /**
         * <p>The ID indicating which condition schema to use for a specific condition.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("condition_schema_id")
        public OperatorStage conditionSchemaId(String conditionSchemaId) {
            this.conditionSchemaId = conditionSchemaId;
            return this;
        }

        /**
         * <p>The operator for a specific condition.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("operator")
        public ValueStage operator(String operator) {
            this.operator = operator;
            return this;
        }

        @java.lang.Override
        @JsonSetter("value")
        public _FinalStage value(JsonNode value) {
            this.value = value;
            return this;
        }

        /**
         * <p>The ID indicating which Linked Account Condition this is.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public _FinalStage id(Optional<String> id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        public LinkedAccountConditionRequest build() {
            return new LinkedAccountConditionRequest(id, conditionSchemaId, operator, value, additionalProperties);
        }
    }
}

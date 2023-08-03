package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LinkedAccountCondition.Builder.class)
public final class LinkedAccountCondition {
    private final String conditionSchemaId;

    private final Optional<String> commonModel;

    private final Optional<String> nativeName;

    private final String operator;

    private final Optional<JsonNode> value;

    private final Optional<String> fieldName;

    private LinkedAccountCondition(
            String conditionSchemaId,
            Optional<String> commonModel,
            Optional<String> nativeName,
            String operator,
            Optional<JsonNode> value,
            Optional<String> fieldName) {
        this.conditionSchemaId = conditionSchemaId;
        this.commonModel = commonModel;
        this.nativeName = nativeName;
        this.operator = operator;
        this.value = value;
        this.fieldName = fieldName;
    }

    /**
     * @return The ID indicating which condition schema to use for a specific condition.
     */
    @JsonProperty("condition_schema_id")
    public String getConditionSchemaId() {
        return conditionSchemaId;
    }

    /**
     * @return The common model for a specific condition.
     */
    @JsonProperty("common_model")
    public Optional<String> getCommonModel() {
        return commonModel;
    }

    /**
     * @return User-facing <em>native condition</em> name. e.g. &quot;Skip Manager&quot;.
     */
    @JsonProperty("native_name")
    public Optional<String> getNativeName() {
        return nativeName;
    }

    /**
     * @return The operator for a specific condition.
     */
    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    @JsonProperty("value")
    public Optional<JsonNode> getValue() {
        return value;
    }

    /**
     * @return The name of the field on the common model that this condition corresponds to, if they conceptually match. e.g. &quot;location_type&quot;.
     */
    @JsonProperty("field_name")
    public Optional<String> getFieldName() {
        return fieldName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LinkedAccountCondition && equalTo((LinkedAccountCondition) other);
    }

    private boolean equalTo(LinkedAccountCondition other) {
        return conditionSchemaId.equals(other.conditionSchemaId)
                && commonModel.equals(other.commonModel)
                && nativeName.equals(other.nativeName)
                && operator.equals(other.operator)
                && value.equals(other.value)
                && fieldName.equals(other.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.conditionSchemaId, this.commonModel, this.nativeName, this.operator, this.value, this.fieldName);
    }

    @Override
    public String toString() {
        return "LinkedAccountCondition{" + "conditionSchemaId: " + conditionSchemaId + ", commonModel: " + commonModel
                + ", nativeName: " + nativeName + ", operator: " + operator + ", value: " + value + ", fieldName: "
                + fieldName + "}";
    }

    public static ConditionSchemaIdStage builder() {
        return new Builder();
    }

    public interface ConditionSchemaIdStage {
        OperatorStage conditionSchemaId(String conditionSchemaId);

        Builder from(LinkedAccountCondition other);
    }

    public interface OperatorStage {
        _FinalStage operator(String operator);
    }

    public interface _FinalStage {
        LinkedAccountCondition build();

        _FinalStage commonModel(Optional<String> commonModel);

        _FinalStage commonModel(String commonModel);

        _FinalStage nativeName(Optional<String> nativeName);

        _FinalStage nativeName(String nativeName);

        _FinalStage value(Optional<JsonNode> value);

        _FinalStage value(JsonNode value);

        _FinalStage fieldName(Optional<String> fieldName);

        _FinalStage fieldName(String fieldName);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ConditionSchemaIdStage, OperatorStage, _FinalStage {
        private String conditionSchemaId;

        private String operator;

        private Optional<String> fieldName = Optional.empty();

        private Optional<JsonNode> value = Optional.empty();

        private Optional<String> nativeName = Optional.empty();

        private Optional<String> commonModel = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(LinkedAccountCondition other) {
            conditionSchemaId(other.getConditionSchemaId());
            commonModel(other.getCommonModel());
            nativeName(other.getNativeName());
            operator(other.getOperator());
            value(other.getValue());
            fieldName(other.getFieldName());
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
        public _FinalStage operator(String operator) {
            this.operator = operator;
            return this;
        }

        /**
         * <p>The name of the field on the common model that this condition corresponds to, if they conceptually match. e.g. &quot;location_type&quot;.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage fieldName(String fieldName) {
            this.fieldName = Optional.of(fieldName);
            return this;
        }

        @Override
        @JsonSetter(value = "field_name", nulls = Nulls.SKIP)
        public _FinalStage fieldName(Optional<String> fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        @Override
        public _FinalStage value(JsonNode value) {
            this.value = Optional.of(value);
            return this;
        }

        @Override
        @JsonSetter(value = "value", nulls = Nulls.SKIP)
        public _FinalStage value(Optional<JsonNode> value) {
            this.value = value;
            return this;
        }

        /**
         * <p>User-facing <em>native condition</em> name. e.g. &quot;Skip Manager&quot;.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage nativeName(String nativeName) {
            this.nativeName = Optional.of(nativeName);
            return this;
        }

        @Override
        @JsonSetter(value = "native_name", nulls = Nulls.SKIP)
        public _FinalStage nativeName(Optional<String> nativeName) {
            this.nativeName = nativeName;
            return this;
        }

        /**
         * <p>The common model for a specific condition.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage commonModel(String commonModel) {
            this.commonModel = Optional.of(commonModel);
            return this;
        }

        @Override
        @JsonSetter(value = "common_model", nulls = Nulls.SKIP)
        public _FinalStage commonModel(Optional<String> commonModel) {
            this.commonModel = commonModel;
            return this;
        }

        @Override
        public LinkedAccountCondition build() {
            return new LinkedAccountCondition(conditionSchemaId, commonModel, nativeName, operator, value, fieldName);
        }
    }
}

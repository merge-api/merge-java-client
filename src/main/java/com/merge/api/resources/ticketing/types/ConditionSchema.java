package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ConditionSchema.Builder.class)
public final class ConditionSchema {
    private final String id;

    private final Optional<String> commonModel;

    private final Optional<String> nativeName;

    private final Optional<String> fieldName;

    private final Optional<Boolean> isUnique;

    private final ConditionSchemaConditionType conditionType;

    private final List<OperatorSchema> operators;

    private ConditionSchema(
            String id,
            Optional<String> commonModel,
            Optional<String> nativeName,
            Optional<String> fieldName,
            Optional<Boolean> isUnique,
            ConditionSchemaConditionType conditionType,
            List<OperatorSchema> operators) {
        this.id = id;
        this.commonModel = commonModel;
        this.nativeName = nativeName;
        this.fieldName = fieldName;
        this.isUnique = isUnique;
        this.conditionType = conditionType;
        this.operators = operators;
    }

    /**
     * @return The ID of the condition schema. This ID is used when updating selective syncs for a linked account.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The common model for which a condition schema is defined.
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
     * @return The name of the field on the common model that this condition corresponds to, if they conceptually match. e.g. &quot;location_type&quot;.
     */
    @JsonProperty("field_name")
    public Optional<String> getFieldName() {
        return fieldName;
    }

    /**
     * @return Whether this condition can only be applied once. If false, the condition can be AND'd together multiple times.
     */
    @JsonProperty("is_unique")
    public Optional<Boolean> getIsUnique() {
        return isUnique;
    }

    /**
     * @return The type of value(s) that can be set for this condition.
     * <ul>
     * <li><code>BOOLEAN</code> - BOOLEAN</li>
     * <li><code>DATE</code> - DATE</li>
     * <li><code>DATE_TIME</code> - DATE_TIME</li>
     * <li><code>INTEGER</code> - INTEGER</li>
     * <li><code>FLOAT</code> - FLOAT</li>
     * <li><code>STRING</code> - STRING</li>
     * <li><code>LIST_OF_STRINGS</code> - LIST_OF_STRINGS</li>
     * </ul>
     */
    @JsonProperty("condition_type")
    public ConditionSchemaConditionType getConditionType() {
        return conditionType;
    }

    /**
     * @return The schemas for the operators that can be used on a condition.
     */
    @JsonProperty("operators")
    public List<OperatorSchema> getOperators() {
        return operators;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConditionSchema && equalTo((ConditionSchema) other);
    }

    private boolean equalTo(ConditionSchema other) {
        return id.equals(other.id)
                && commonModel.equals(other.commonModel)
                && nativeName.equals(other.nativeName)
                && fieldName.equals(other.fieldName)
                && isUnique.equals(other.isUnique)
                && conditionType.equals(other.conditionType)
                && operators.equals(other.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.commonModel,
                this.nativeName,
                this.fieldName,
                this.isUnique,
                this.conditionType,
                this.operators);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        ConditionTypeStage id(String id);

        Builder from(ConditionSchema other);
    }

    public interface ConditionTypeStage {
        _FinalStage conditionType(ConditionSchemaConditionType conditionType);
    }

    public interface _FinalStage {
        ConditionSchema build();

        _FinalStage commonModel(Optional<String> commonModel);

        _FinalStage commonModel(String commonModel);

        _FinalStage nativeName(Optional<String> nativeName);

        _FinalStage nativeName(String nativeName);

        _FinalStage fieldName(Optional<String> fieldName);

        _FinalStage fieldName(String fieldName);

        _FinalStage isUnique(Optional<Boolean> isUnique);

        _FinalStage isUnique(Boolean isUnique);

        _FinalStage operators(List<OperatorSchema> operators);

        _FinalStage addOperators(OperatorSchema operators);

        _FinalStage addAllOperators(List<OperatorSchema> operators);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, ConditionTypeStage, _FinalStage {
        private String id;

        private ConditionSchemaConditionType conditionType;

        private List<OperatorSchema> operators = new ArrayList<>();

        private Optional<Boolean> isUnique = Optional.empty();

        private Optional<String> fieldName = Optional.empty();

        private Optional<String> nativeName = Optional.empty();

        private Optional<String> commonModel = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ConditionSchema other) {
            id(other.getId());
            commonModel(other.getCommonModel());
            nativeName(other.getNativeName());
            fieldName(other.getFieldName());
            isUnique(other.getIsUnique());
            conditionType(other.getConditionType());
            operators(other.getOperators());
            return this;
        }

        /**
         * <p>The ID of the condition schema. This ID is used when updating selective syncs for a linked account.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public ConditionTypeStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The type of value(s) that can be set for this condition.</p>
         * <ul>
         * <li><code>BOOLEAN</code> - BOOLEAN</li>
         * <li><code>DATE</code> - DATE</li>
         * <li><code>DATE_TIME</code> - DATE_TIME</li>
         * <li><code>INTEGER</code> - INTEGER</li>
         * <li><code>FLOAT</code> - FLOAT</li>
         * <li><code>STRING</code> - STRING</li>
         * <li><code>LIST_OF_STRINGS</code> - LIST_OF_STRINGS</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("condition_type")
        public _FinalStage conditionType(ConditionSchemaConditionType conditionType) {
            this.conditionType = conditionType;
            return this;
        }

        /**
         * <p>The schemas for the operators that can be used on a condition.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllOperators(List<OperatorSchema> operators) {
            this.operators.addAll(operators);
            return this;
        }

        /**
         * <p>The schemas for the operators that can be used on a condition.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addOperators(OperatorSchema operators) {
            this.operators.add(operators);
            return this;
        }

        @Override
        @JsonSetter(value = "operators", nulls = Nulls.SKIP)
        public _FinalStage operators(List<OperatorSchema> operators) {
            this.operators.clear();
            this.operators.addAll(operators);
            return this;
        }

        /**
         * <p>Whether this condition can only be applied once. If false, the condition can be AND'd together multiple times.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage isUnique(Boolean isUnique) {
            this.isUnique = Optional.of(isUnique);
            return this;
        }

        @Override
        @JsonSetter(value = "is_unique", nulls = Nulls.SKIP)
        public _FinalStage isUnique(Optional<Boolean> isUnique) {
            this.isUnique = isUnique;
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
         * <p>The common model for which a condition schema is defined.</p>
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
        public ConditionSchema build() {
            return new ConditionSchema(id, commonModel, nativeName, fieldName, isUnique, conditionType, operators);
        }
    }
}

package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = OperatorSchema.Builder.class)
public final class OperatorSchema {
    private final Optional<String> operator;

    private final Optional<Boolean> isUnique;

    private OperatorSchema(Optional<String> operator, Optional<Boolean> isUnique) {
        this.operator = operator;
        this.isUnique = isUnique;
    }

    /**
     * @return The operator for which an operator schema is defined.
     */
    @JsonProperty("operator")
    public Optional<String> getOperator() {
        return operator;
    }

    /**
     * @return Whether the operator can be repeated multiple times.
     */
    @JsonProperty("is_unique")
    public Optional<Boolean> getIsUnique() {
        return isUnique;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OperatorSchema && equalTo((OperatorSchema) other);
    }

    private boolean equalTo(OperatorSchema other) {
        return operator.equals(other.operator) && isUnique.equals(other.isUnique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.operator, this.isUnique);
    }

    @Override
    public String toString() {
        return "OperatorSchema{" + "operator: " + operator + ", isUnique: " + isUnique + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> operator = Optional.empty();

        private Optional<Boolean> isUnique = Optional.empty();

        private Builder() {}

        public Builder from(OperatorSchema other) {
            operator(other.getOperator());
            isUnique(other.getIsUnique());
            return this;
        }

        @JsonSetter(value = "operator", nulls = Nulls.SKIP)
        public Builder operator(Optional<String> operator) {
            this.operator = operator;
            return this;
        }

        public Builder operator(String operator) {
            this.operator = Optional.of(operator);
            return this;
        }

        @JsonSetter(value = "is_unique", nulls = Nulls.SKIP)
        public Builder isUnique(Optional<Boolean> isUnique) {
            this.isUnique = isUnique;
            return this;
        }

        public Builder isUnique(Boolean isUnique) {
            this.isUnique = Optional.of(isUnique);
            return this;
        }

        public OperatorSchema build() {
            return new OperatorSchema(operator, isUnique);
        }
    }
}

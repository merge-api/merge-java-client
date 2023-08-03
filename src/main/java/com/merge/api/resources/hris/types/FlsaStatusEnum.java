package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FlsaStatusEnum {
    EXEMPT("EXEMPT"),

    SALARIED_NONEXEMPT("SALARIED_NONEXEMPT"),

    NONEXEMPT("NONEXEMPT"),

    OWNER("OWNER");

    private final String value;

    FlsaStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

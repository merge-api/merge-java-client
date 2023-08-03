package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MaritalStatusEnum {
    SINGLE("SINGLE"),

    MARRIED_FILING_JOINTLY("MARRIED_FILING_JOINTLY"),

    MARRIED_FILING_SEPARATELY("MARRIED_FILING_SEPARATELY"),

    HEAD_OF_HOUSEHOLD("HEAD_OF_HOUSEHOLD"),

    QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD("QUALIFYING_WIDOW_OR_WIDOWER_WITH_DEPENDENT_CHILD");

    private final String value;

    MaritalStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryTypeEnum {
    CLASS("CLASS"),

    DEPARTMENT("DEPARTMENT");

    private final String value;

    CategoryTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
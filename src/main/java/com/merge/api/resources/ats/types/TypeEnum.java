package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnum {
    DATE("DATE"),

    FILE("FILE"),

    SINGLE_SELECT("SINGLE_SELECT"),

    MULTI_SELECT("MULTI_SELECT"),

    SINGLE_LINE_TEXT("SINGLE_LINE_TEXT"),

    MULTI_LINE_TEXT("MULTI_LINE_TEXT"),

    NUMERIC("NUMERIC"),

    BOOLEAN("BOOLEAN");

    private final String value;

    TypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

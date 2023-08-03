package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UnitsEnum {
    HOURS("HOURS"),

    DAYS("DAYS");

    private final String value;

    UnitsEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

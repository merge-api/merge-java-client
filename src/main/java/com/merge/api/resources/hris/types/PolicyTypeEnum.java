package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PolicyTypeEnum {
    VACATION("VACATION"),

    SICK("SICK"),

    PERSONAL("PERSONAL"),

    JURY_DUTY("JURY_DUTY"),

    VOLUNTEER("VOLUNTEER"),

    BEREAVEMENT("BEREAVEMENT");

    private final String value;

    PolicyTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

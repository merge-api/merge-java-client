package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RunTypeEnum {
    REGULAR("REGULAR"),

    OFF_CYCLE("OFF_CYCLE"),

    CORRECTION("CORRECTION"),

    TERMINATION("TERMINATION"),

    SIGN_ON_BONUS("SIGN_ON_BONUS");

    private final String value;

    RunTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RunStateEnum {
    PAID("PAID"),

    DRAFT("DRAFT"),

    APPROVED("APPROVED"),

    FAILED("FAILED"),

    CLOSED("CLOSED");

    private final String value;

    RunStateEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

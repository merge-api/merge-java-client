package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnabledActionsEnum {
    READ("READ"),

    WRITE("WRITE");

    private final String value;

    EnabledActionsEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

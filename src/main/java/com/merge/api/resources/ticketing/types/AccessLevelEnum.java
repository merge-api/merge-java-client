package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccessLevelEnum {
    PRIVATE("PRIVATE"),

    COMPANY("COMPANY"),

    PUBLIC("PUBLIC");

    private final String value;

    AccessLevelEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

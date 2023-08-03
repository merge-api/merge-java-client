package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DirectionEnum {
    INBOUND("INBOUND"),

    OUTBOUND("OUTBOUND");

    private final String value;

    DirectionEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
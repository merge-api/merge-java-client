package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskStatusEnum {
    OPEN("OPEN"),

    CLOSED("CLOSED");

    private final String value;

    TaskStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

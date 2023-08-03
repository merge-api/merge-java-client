package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemTypeEnum {
    STRING("string"),

    NUMBER("number"),

    DATE("date"),

    DATETIME("datetime"),

    BOOL("bool"),

    LIST("list");

    private final String value;

    ItemTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
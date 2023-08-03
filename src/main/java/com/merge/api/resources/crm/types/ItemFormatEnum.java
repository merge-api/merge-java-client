package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemFormatEnum {
    STRING("string"),

    NUMBER("number"),

    DATE("date"),

    DATETIME("datetime"),

    BOOL("bool"),

    LIST("list");

    private final String value;

    ItemFormatEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

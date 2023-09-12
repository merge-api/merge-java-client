package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RolesEnum {
    READ("READ"),

    WRITE("WRITE"),

    OWNER("OWNER");

    private final String value;

    RolesEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VisibilityEnum {
    ADMIN_ONLY("ADMIN_ONLY"),

    PUBLIC("PUBLIC"),

    PRIVATE("PRIVATE");

    private final String value;

    VisibilityEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

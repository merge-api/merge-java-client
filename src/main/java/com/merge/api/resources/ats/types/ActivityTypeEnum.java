package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActivityTypeEnum {
    NOTE("NOTE"),

    EMAIL("EMAIL"),

    OTHER("OTHER");

    private final String value;

    ActivityTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

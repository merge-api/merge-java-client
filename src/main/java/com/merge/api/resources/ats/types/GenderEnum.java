package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GenderEnum {
    MALE("MALE"),

    FEMALE("FEMALE"),

    NON_BINARY("NON-BINARY"),

    OTHER("OTHER"),

    DECLINE_TO_SELF_IDENTIFY("DECLINE_TO_SELF_IDENTIFY");

    private final String value;

    GenderEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
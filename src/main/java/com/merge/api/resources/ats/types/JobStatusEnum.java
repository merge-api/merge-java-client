package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JobStatusEnum {
    OPEN("OPEN"),

    CLOSED("CLOSED"),

    DRAFT("DRAFT"),

    ARCHIVED("ARCHIVED"),

    PENDING("PENDING");

    private final String value;

    JobStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
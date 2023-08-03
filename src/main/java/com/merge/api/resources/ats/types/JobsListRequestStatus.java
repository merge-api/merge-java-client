package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JobsListRequestStatus {
    ARCHIVED("ARCHIVED"),

    CLOSED("CLOSED"),

    DRAFT("DRAFT"),

    OPEN("OPEN"),

    PENDING("PENDING");

    private final String value;

    JobsListRequestStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

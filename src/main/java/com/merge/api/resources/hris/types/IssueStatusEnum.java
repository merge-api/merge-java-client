package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum IssueStatusEnum {
    ONGOING("ONGOING"),

    RESOLVED("RESOLVED");

    private final String value;

    IssueStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

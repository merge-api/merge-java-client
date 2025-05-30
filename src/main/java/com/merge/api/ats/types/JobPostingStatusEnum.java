/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JobPostingStatusEnum {
    PUBLISHED("PUBLISHED"),

    CLOSED("CLOSED"),

    DRAFT("DRAFT"),

    INTERNAL("INTERNAL"),

    PENDING("PENDING");

    private final String value;

    JobPostingStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

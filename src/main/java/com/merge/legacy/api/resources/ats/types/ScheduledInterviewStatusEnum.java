/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ScheduledInterviewStatusEnum {
    SCHEDULED("SCHEDULED"),

    AWAITING_FEEDBACK("AWAITING_FEEDBACK"),

    COMPLETE("COMPLETE");

    private final String value;

    ScheduledInterviewStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

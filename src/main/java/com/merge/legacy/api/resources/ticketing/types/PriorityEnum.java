/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PriorityEnum {
    URGENT("URGENT"),

    HIGH("HIGH"),

    NORMAL("NORMAL"),

    LOW("LOW");

    private final String value;

    PriorityEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TicketsListRequestPriority {
    HIGH("HIGH"),

    LOW("LOW"),

    NORMAL("NORMAL"),

    URGENT("URGENT");

    private final String value;

    TicketsListRequestPriority(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

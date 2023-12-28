package com.merge.api.resources.ticketing.tickets.types;

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
    @Override
    public String toString() {
        return this.value;
    }
}

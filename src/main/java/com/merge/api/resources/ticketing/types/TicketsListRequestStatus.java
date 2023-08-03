package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TicketsListRequestStatus {
    CLOSED("CLOSED"),

    IN_PROGRESS("IN_PROGRESS"),

    ON_HOLD("ON_HOLD"),

    OPEN("OPEN");

    private final String value;

    TicketsListRequestStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

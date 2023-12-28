package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TicketAccessEnum {
    ALL("ALL"),

    ASSIGNED_ONLY("ASSIGNED_ONLY"),

    TEAM_ONLY("TEAM_ONLY");

    private final String value;

    TicketAccessEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

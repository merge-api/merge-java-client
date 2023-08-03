package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TicketsRetrieveRequestRemoteFields {
    PRIORITY("priority"),

    PRIORITY_STATUS("priority,status"),

    PRIORITY_STATUS_TICKET_TYPE("priority,status,ticket_type"),

    PRIORITY_TICKET_TYPE("priority,ticket_type"),

    STATUS("status"),

    STATUS_TICKET_TYPE("status,ticket_type"),

    TICKET_TYPE("ticket_type");

    private final String value;

    TicketsRetrieveRequestRemoteFields(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

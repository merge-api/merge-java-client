package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OpportunitiesListRequestStatus {
    LOST("LOST"),

    OPEN("OPEN"),

    WON("WON");

    private final String value;

    OpportunitiesListRequestStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

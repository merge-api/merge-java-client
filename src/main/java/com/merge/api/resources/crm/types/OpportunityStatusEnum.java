package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OpportunityStatusEnum {
    OPEN("OPEN"),

    WON("WON"),

    LOST("LOST");

    private final String value;

    OpportunityStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

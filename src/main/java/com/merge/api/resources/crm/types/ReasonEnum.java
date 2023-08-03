package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReasonEnum {
    GENERAL_CUSTOMER_REQUEST("GENERAL_CUSTOMER_REQUEST"),

    GDPR("GDPR"),

    OTHER("OTHER");

    private final String value;

    ReasonEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountingPeriodStatusEnum {
    ACTIVE("ACTIVE"),

    INACTIVE("INACTIVE");

    private final String value;

    AccountingPeriodStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

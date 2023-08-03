package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AddressTypeEnum {
    BILLING("BILLING"),

    SHIPPING("SHIPPING");

    private final String value;

    AddressTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

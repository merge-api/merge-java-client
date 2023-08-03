package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmailAddressTypeEnum {
    PERSONAL("PERSONAL"),

    WORK("WORK"),

    OTHER("OTHER");

    private final String value;

    EmailAddressTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

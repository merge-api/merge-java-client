/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

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
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

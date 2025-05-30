/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FieldTypeEnum {
    STRING("string"),

    NUMBER("number"),

    DATE("date"),

    DATETIME("datetime"),

    BOOL("bool"),

    LIST("list");

    private final String value;

    FieldTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

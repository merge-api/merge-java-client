/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CollectionAccessLevelEnum {
    PRIVATE("PRIVATE"),

    COMPANY("COMPANY"),

    PUBLIC("PUBLIC"),

    PARENT_COLLECTION("PARENT_COLLECTION");

    private final String value;

    CollectionAccessLevelEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

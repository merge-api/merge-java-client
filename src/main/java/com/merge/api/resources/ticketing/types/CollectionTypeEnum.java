package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CollectionTypeEnum {
    LIST("LIST"),

    PROJECT("PROJECT");

    private final String value;

    CollectionTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

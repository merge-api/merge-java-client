package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CollectionsListRequestCollectionType {
    LIST("LIST"),

    PROJECT("PROJECT");

    private final String value;

    CollectionsListRequestCollectionType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

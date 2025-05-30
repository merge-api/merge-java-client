/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.ticketing.collections.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CollectionsRetrieveRequestExpand {
    PARENT_COLLECTION("parent_collection"),

    TEAMS("teams"),

    TEAMS_PARENT_COLLECTION("teams,parent_collection");

    private final String value;

    CollectionsRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

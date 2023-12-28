package com.merge.api.resources.ticketing.collections.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CollectionsUsersListRequestExpand {
    ROLES("roles"),

    TEAMS("teams"),

    TEAMS_ROLES("teams,roles");

    private final String value;

    CollectionsUsersListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

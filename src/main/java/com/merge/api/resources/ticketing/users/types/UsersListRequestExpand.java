package com.merge.api.resources.ticketing.users.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UsersListRequestExpand {
    ROLES("roles"),

    TEAMS("teams"),

    TEAMS_ROLES("teams,roles");

    private final String value;

    UsersListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProjectsUsersListRequestExpandItem {
    ROLES("roles"),

    TEAMS("teams");

    private final String value;

    ProjectsUsersListRequestExpandItem(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

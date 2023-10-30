package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleEnum {
    ADMIN("ADMIN"),

    DEVELOPER("DEVELOPER"),

    MEMBER("MEMBER"),

    API("API"),

    SYSTEM("SYSTEM"),

    MERGE_TEAM("MERGE_TEAM");

    private final String value;

    RoleEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountDetailsAndActionsStatusEnum {
    COMPLETE("COMPLETE"),

    INCOMPLETE("INCOMPLETE"),

    RELINK_NEEDED("RELINK_NEEDED");

    private final String value;

    AccountDetailsAndActionsStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

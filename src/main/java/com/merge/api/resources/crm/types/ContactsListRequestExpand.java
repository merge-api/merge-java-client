package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContactsListRequestExpand {
    ACCOUNT("account"),

    ACCOUNT_OWNER("account,owner"),

    OWNER("owner");

    private final String value;

    ContactsListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

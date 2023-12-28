package com.merge.api.resources.crm.contacts.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContactsRetrieveRequestExpand {
    ACCOUNT("account"),

    ACCOUNT_OWNER("account,owner"),

    OWNER("owner");

    private final String value;

    ContactsRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

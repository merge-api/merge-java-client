package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TasksRetrieveRequestExpand {
    ACCOUNT("account"),

    ACCOUNT_OPPORTUNITY("account,opportunity"),

    OPPORTUNITY("opportunity"),

    OWNER("owner"),

    OWNER_ACCOUNT("owner,account"),

    OWNER_ACCOUNT_OPPORTUNITY("owner,account,opportunity"),

    OWNER_OPPORTUNITY("owner,opportunity");

    private final String value;

    TasksRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

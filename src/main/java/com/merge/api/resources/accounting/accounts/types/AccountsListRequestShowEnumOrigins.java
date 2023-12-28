package com.merge.api.resources.accounting.accounts.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountsListRequestShowEnumOrigins {
    CLASSIFICATION("classification"),

    CLASSIFICATION_STATUS("classification,status"),

    STATUS("status");

    private final String value;

    AccountsListRequestShowEnumOrigins(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

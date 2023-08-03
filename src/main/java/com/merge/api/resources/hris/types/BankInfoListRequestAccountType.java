package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BankInfoListRequestAccountType {
    CHECKING("CHECKING"),

    SAVINGS("SAVINGS");

    private final String value;

    BankInfoListRequestAccountType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

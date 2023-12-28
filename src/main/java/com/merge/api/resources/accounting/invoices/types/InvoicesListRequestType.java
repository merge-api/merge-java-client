package com.merge.api.resources.accounting.invoices.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoicesListRequestType {
    ACCOUNTS_PAYABLE("ACCOUNTS_PAYABLE"),

    ACCOUNTS_RECEIVABLE("ACCOUNTS_RECEIVABLE");

    private final String value;

    InvoicesListRequestType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

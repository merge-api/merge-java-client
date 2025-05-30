/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoicesListRequestType {
    ACCOUNTS_PAYABLE("ACCOUNTS_PAYABLE"),

    ACCOUNTS_RECEIVABLE("ACCOUNTS_RECEIVABLE");

    private final String value;

    InvoicesListRequestType(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

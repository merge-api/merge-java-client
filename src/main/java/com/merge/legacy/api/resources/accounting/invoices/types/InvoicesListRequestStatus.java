/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.accounting.invoices.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoicesListRequestStatus {
    DRAFT("DRAFT"),

    OPEN("OPEN"),

    PAID("PAID"),

    PARTIALLY_PAID("PARTIALLY_PAID"),

    SUBMITTED("SUBMITTED"),

    VOID("VOID");

    private final String value;

    InvoicesListRequestStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

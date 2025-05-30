/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ExpensesRetrieveRequestExpandItem {
    ACCOUNT("account"),

    ACCOUNTING_PERIOD("accounting_period"),

    COMPANY("company"),

    CONTACT("contact"),

    EMPLOYEE("employee"),

    TRACKING_CATEGORIES("tracking_categories");

    private final String value;

    ExpensesRetrieveRequestExpandItem(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

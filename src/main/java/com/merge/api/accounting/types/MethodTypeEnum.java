/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MethodTypeEnum {
    CREDIT_CARD("CREDIT_CARD"),

    DEBIT_CARD("DEBIT_CARD"),

    ACH("ACH"),

    CASH("CASH"),

    CHECK("CHECK");

    private final String value;

    MethodTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

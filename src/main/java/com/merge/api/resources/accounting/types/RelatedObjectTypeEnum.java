package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RelatedObjectTypeEnum {
    INVOICE("INVOICE"),

    CREDIT_NOTE("CREDIT_NOTE"),

    JOURNAL_ENTRY("JOURNAL_ENTRY"),

    NONE("NONE");

    private final String value;

    RelatedObjectTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

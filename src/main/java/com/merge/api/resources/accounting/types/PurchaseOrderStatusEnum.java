package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PurchaseOrderStatusEnum {
    DRAFT("DRAFT"),

    SUBMITTED("SUBMITTED"),

    AUTHORIZED("AUTHORIZED"),

    BILLED("BILLED"),

    DELETED("DELETED");

    private final String value;

    PurchaseOrderStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

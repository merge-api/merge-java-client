package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CreditNotesListRequestShowEnumOrigins {
    STATUS("status"),

    STATUS_TYPE("status,type"),

    TYPE("type");

    private final String value;

    CreditNotesListRequestShowEnumOrigins(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

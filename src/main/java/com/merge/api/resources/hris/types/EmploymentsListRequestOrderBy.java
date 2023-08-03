package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmploymentsListRequestOrderBy {
    EFFECTIVE_DATE_DESCENDING("-effective_date"),

    EFFECTIVE_DATE_ASCENDING("effective_date");

    private final String value;

    EmploymentsListRequestOrderBy(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

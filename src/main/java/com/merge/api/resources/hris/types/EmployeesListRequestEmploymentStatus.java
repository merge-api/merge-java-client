package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmployeesListRequestEmploymentStatus {
    ACTIVE("ACTIVE"),

    INACTIVE("INACTIVE"),

    PENDING("PENDING");

    private final String value;

    EmployeesListRequestEmploymentStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

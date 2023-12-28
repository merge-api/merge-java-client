package com.merge.api.resources.hris.employments.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmploymentsListRequestExpand {
    EMPLOYEE("employee"),

    EMPLOYEE_PAY_GROUP("employee,pay_group"),

    PAY_GROUP("pay_group");

    private final String value;

    EmploymentsListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

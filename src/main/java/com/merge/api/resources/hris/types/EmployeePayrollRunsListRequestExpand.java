package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmployeePayrollRunsListRequestExpand {
    EMPLOYEE("employee"),

    EMPLOYEE_PAYROLL_RUN("employee,payroll_run"),

    PAYROLL_RUN("payroll_run");

    private final String value;

    EmployeePayrollRunsListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

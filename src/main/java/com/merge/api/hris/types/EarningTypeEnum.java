/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EarningTypeEnum {
    SALARY("SALARY"),

    REIMBURSEMENT("REIMBURSEMENT"),

    OVERTIME("OVERTIME"),

    BONUS("BONUS");

    private final String value;

    EarningTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TimeOffBalancesListRequestPolicyType {
    BEREAVEMENT("BEREAVEMENT"),

    JURY_DUTY("JURY_DUTY"),

    PERSONAL("PERSONAL"),

    SICK("SICK"),

    VACATION("VACATION"),

    VOLUNTEER("VOLUNTEER");

    private final String value;

    TimeOffBalancesListRequestPolicyType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

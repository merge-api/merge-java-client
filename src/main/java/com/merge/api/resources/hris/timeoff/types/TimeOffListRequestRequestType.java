package com.merge.api.resources.hris.timeoff.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TimeOffListRequestRequestType {
    BEREAVEMENT("BEREAVEMENT"),

    JURY_DUTY("JURY_DUTY"),

    PERSONAL("PERSONAL"),

    SICK("SICK"),

    VACATION("VACATION"),

    VOLUNTEER("VOLUNTEER");

    private final String value;

    TimeOffListRequestRequestType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

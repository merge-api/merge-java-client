package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CardinalityEnum {
    ONE_TO_ONE("ONE_TO_ONE"),

    MANY_TO_ONE("MANY_TO_ONE"),

    MANY_TO_MANY("MANY_TO_MANY"),

    ONE_TO_MANY("ONE_TO_MANY");

    private final String value;

    CardinalityEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EthnicityEnum {
    AMERICAN_INDIAN_OR_ALASKA_NATIVE("AMERICAN_INDIAN_OR_ALASKA_NATIVE"),

    ASIAN_OR_INDIAN_SUBCONTINENT("ASIAN_OR_INDIAN_SUBCONTINENT"),

    BLACK_OR_AFRICAN_AMERICAN("BLACK_OR_AFRICAN_AMERICAN"),

    HISPANIC_OR_LATINO("HISPANIC_OR_LATINO"),

    NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER("NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER"),

    TWO_OR_MORE_RACES("TWO_OR_MORE_RACES"),

    WHITE("WHITE"),

    PREFER_NOT_TO_DISCLOSE("PREFER_NOT_TO_DISCLOSE");

    private final String value;

    EthnicityEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

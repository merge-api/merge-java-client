package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RaceEnum {
    AMERICAN_INDIAN_OR_ALASKAN_NATIVE("AMERICAN_INDIAN_OR_ALASKAN_NATIVE"),

    ASIAN("ASIAN"),

    BLACK_OR_AFRICAN_AMERICAN("BLACK_OR_AFRICAN_AMERICAN"),

    HISPANIC_OR_LATINO("HISPANIC_OR_LATINO"),

    WHITE("WHITE"),

    NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER("NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER"),

    TWO_OR_MORE_RACES("TWO_OR_MORE_RACES"),

    DECLINE_TO_SELF_IDENTIFY("DECLINE_TO_SELF_IDENTIFY");

    private final String value;

    RaceEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

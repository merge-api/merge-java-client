package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PhoneNumberTypeEnum {
    HOME("HOME"),

    WORK("WORK"),

    MOBILE("MOBILE"),

    SKYPE("SKYPE"),

    OTHER("OTHER");

    private final String value;

    PhoneNumberTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

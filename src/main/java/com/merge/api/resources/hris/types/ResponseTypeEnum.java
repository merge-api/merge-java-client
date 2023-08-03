package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseTypeEnum {
    JSON("JSON"),

    BASE_64_GZIP("BASE64_GZIP");

    private final String value;

    ResponseTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

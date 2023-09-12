package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnum {
    USER("USER"),

    GROUP("GROUP"),

    COMPANY("COMPANY"),

    ANYONE("ANYONE");

    private final String value;

    TypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

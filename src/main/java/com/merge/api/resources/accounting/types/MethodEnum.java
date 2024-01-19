/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MethodEnum {
    GET("GET"),

    OPTIONS("OPTIONS"),

    HEAD("HEAD"),

    POST("POST"),

    PUT("PUT"),

    PATCH("PATCH"),

    DELETE("DELETE");

    private final String value;

    MethodEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

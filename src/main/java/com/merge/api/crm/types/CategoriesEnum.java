/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoriesEnum {
    HRIS("hris"),

    ATS("ats"),

    ACCOUNTING("accounting"),

    TICKETING("ticketing"),

    CRM("crm"),

    MKTG("mktg"),

    FILESTORAGE("filestorage");

    private final String value;

    CategoriesEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}

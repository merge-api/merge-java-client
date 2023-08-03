package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LinkedAccountsListRequestCategory {
    ACCOUNTING("accounting"),

    ATS("ats"),

    CRM("crm"),

    FILESTORAGE("filestorage"),

    HRIS("hris"),

    MKTG("mktg"),

    TICKETING("ticketing");

    private final String value;

    LinkedAccountsListRequestCategory(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NotesRetrieveRequestExpand {
    ACCOUNT("account"),

    ACCOUNT_OPPORTUNITY("account,opportunity"),

    CONTACT("contact"),

    CONTACT_ACCOUNT("contact,account"),

    CONTACT_ACCOUNT_OPPORTUNITY("contact,account,opportunity"),

    CONTACT_OPPORTUNITY("contact,opportunity"),

    OPPORTUNITY("opportunity"),

    OWNER("owner"),

    OWNER_ACCOUNT("owner,account"),

    OWNER_ACCOUNT_OPPORTUNITY("owner,account,opportunity"),

    OWNER_CONTACT("owner,contact"),

    OWNER_CONTACT_ACCOUNT("owner,contact,account"),

    OWNER_CONTACT_ACCOUNT_OPPORTUNITY("owner,contact,account,opportunity"),

    OWNER_CONTACT_OPPORTUNITY("owner,contact,opportunity"),

    OWNER_OPPORTUNITY("owner,opportunity");

    private final String value;

    NotesRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

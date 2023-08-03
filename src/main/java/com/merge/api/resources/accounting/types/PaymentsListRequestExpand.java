package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentsListRequestExpand {
    ACCOUNT("account"),

    ACCOUNT_COMPANY("account,company"),

    COMPANY("company"),

    CONTACT("contact"),

    CONTACT_ACCOUNT("contact,account"),

    CONTACT_ACCOUNT_COMPANY("contact,account,company"),

    CONTACT_COMPANY("contact,company"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_ACCOUNT("tracking_categories,account"),

    TRACKING_CATEGORIES_ACCOUNT_COMPANY("tracking_categories,account,company"),

    TRACKING_CATEGORIES_COMPANY("tracking_categories,company"),

    TRACKING_CATEGORIES_CONTACT("tracking_categories,contact"),

    TRACKING_CATEGORIES_CONTACT_ACCOUNT("tracking_categories,contact,account"),

    TRACKING_CATEGORIES_CONTACT_ACCOUNT_COMPANY("tracking_categories,contact,account,company"),

    TRACKING_CATEGORIES_CONTACT_COMPANY("tracking_categories,contact,company");

    private final String value;

    PaymentsListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

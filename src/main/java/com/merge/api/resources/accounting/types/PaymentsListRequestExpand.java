package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentsListRequestExpand {
    ACCOUNT("account"),

    ACCOUNT_COMPANY("account,company"),

    APPLIED_TO_LINES("applied_to_lines"),

    APPLIED_TO_LINES_ACCOUNT("applied_to_lines,account"),

    APPLIED_TO_LINES_ACCOUNT_COMPANY("applied_to_lines,account,company"),

    APPLIED_TO_LINES_COMPANY("applied_to_lines,company"),

    APPLIED_TO_LINES_CONTACT("applied_to_lines,contact"),

    APPLIED_TO_LINES_CONTACT_ACCOUNT("applied_to_lines,contact,account"),

    APPLIED_TO_LINES_CONTACT_ACCOUNT_COMPANY("applied_to_lines,contact,account,company"),

    APPLIED_TO_LINES_CONTACT_COMPANY("applied_to_lines,contact,company"),

    COMPANY("company"),

    CONTACT("contact"),

    CONTACT_ACCOUNT("contact,account"),

    CONTACT_ACCOUNT_COMPANY("contact,account,company"),

    CONTACT_COMPANY("contact,company"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_ACCOUNT("tracking_categories,account"),

    TRACKING_CATEGORIES_ACCOUNT_COMPANY("tracking_categories,account,company"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES("tracking_categories,applied_to_lines"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_ACCOUNT("tracking_categories,applied_to_lines,account"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_ACCOUNT_COMPANY("tracking_categories,applied_to_lines,account,company"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_COMPANY("tracking_categories,applied_to_lines,company"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_CONTACT("tracking_categories,applied_to_lines,contact"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_CONTACT_ACCOUNT("tracking_categories,applied_to_lines,contact,account"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_CONTACT_ACCOUNT_COMPANY(
            "tracking_categories,applied_to_lines,contact,account,company"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_CONTACT_COMPANY("tracking_categories,applied_to_lines,contact,company"),

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

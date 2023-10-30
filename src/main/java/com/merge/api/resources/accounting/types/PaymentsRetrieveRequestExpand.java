package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentsRetrieveRequestExpand {
    ACCOUNT("account"),

    ACCOUNT_ACCOUNTING_PERIOD("account,accounting_period"),

    ACCOUNT_COMPANY("account,company"),

    ACCOUNT_COMPANY_ACCOUNTING_PERIOD("account,company,accounting_period"),

    ACCOUNTING_PERIOD("accounting_period"),

    COMPANY("company"),

    COMPANY_ACCOUNTING_PERIOD("company,accounting_period"),

    CONTACT("contact"),

    CONTACT_ACCOUNT("contact,account"),

    CONTACT_ACCOUNT_ACCOUNTING_PERIOD("contact,account,accounting_period"),

    CONTACT_ACCOUNT_COMPANY("contact,account,company"),

    CONTACT_ACCOUNT_COMPANY_ACCOUNTING_PERIOD("contact,account,company,accounting_period"),

    CONTACT_ACCOUNTING_PERIOD("contact,accounting_period"),

    CONTACT_COMPANY("contact,company"),

    CONTACT_COMPANY_ACCOUNTING_PERIOD("contact,company,accounting_period"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_ACCOUNT("tracking_categories,account"),

    TRACKING_CATEGORIES_ACCOUNT_ACCOUNTING_PERIOD("tracking_categories,account,accounting_period"),

    TRACKING_CATEGORIES_ACCOUNT_COMPANY("tracking_categories,account,company"),

    TRACKING_CATEGORIES_ACCOUNT_COMPANY_ACCOUNTING_PERIOD("tracking_categories,account,company,accounting_period"),

    TRACKING_CATEGORIES_ACCOUNTING_PERIOD("tracking_categories,accounting_period"),

    TRACKING_CATEGORIES_COMPANY("tracking_categories,company"),

    TRACKING_CATEGORIES_COMPANY_ACCOUNTING_PERIOD("tracking_categories,company,accounting_period"),

    TRACKING_CATEGORIES_CONTACT("tracking_categories,contact"),

    TRACKING_CATEGORIES_CONTACT_ACCOUNT("tracking_categories,contact,account"),

    TRACKING_CATEGORIES_CONTACT_ACCOUNT_ACCOUNTING_PERIOD("tracking_categories,contact,account,accounting_period"),

    TRACKING_CATEGORIES_CONTACT_ACCOUNT_COMPANY("tracking_categories,contact,account,company"),

    TRACKING_CATEGORIES_CONTACT_ACCOUNT_COMPANY_ACCOUNTING_PERIOD(
            "tracking_categories,contact,account,company,accounting_period"),

    TRACKING_CATEGORIES_CONTACT_ACCOUNTING_PERIOD("tracking_categories,contact,accounting_period"),

    TRACKING_CATEGORIES_CONTACT_COMPANY("tracking_categories,contact,company"),

    TRACKING_CATEGORIES_CONTACT_COMPANY_ACCOUNTING_PERIOD("tracking_categories,contact,company,accounting_period");

    private final String value;

    PaymentsRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

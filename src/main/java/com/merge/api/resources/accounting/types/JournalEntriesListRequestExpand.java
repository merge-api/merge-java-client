package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JournalEntriesListRequestExpand {
    ACCOUNTING_PERIOD("accounting_period"),

    COMPANY("company"),

    COMPANY_ACCOUNTING_PERIOD("company,accounting_period"),

    LINES("lines"),

    LINES_ACCOUNTING_PERIOD("lines,accounting_period"),

    LINES_COMPANY("lines,company"),

    LINES_COMPANY_ACCOUNTING_PERIOD("lines,company,accounting_period"),

    LINES_PAYMENTS("lines,payments"),

    LINES_PAYMENTS_ACCOUNTING_PERIOD("lines,payments,accounting_period"),

    LINES_PAYMENTS_COMPANY("lines,payments,company"),

    LINES_PAYMENTS_COMPANY_ACCOUNTING_PERIOD("lines,payments,company,accounting_period"),

    LINES_PAYMENTS_TRACKING_CATEGORIES("lines,payments,tracking_categories"),

    LINES_PAYMENTS_TRACKING_CATEGORIES_ACCOUNTING_PERIOD("lines,payments,tracking_categories,accounting_period"),

    LINES_PAYMENTS_TRACKING_CATEGORIES_COMPANY("lines,payments,tracking_categories,company"),

    LINES_PAYMENTS_TRACKING_CATEGORIES_COMPANY_ACCOUNTING_PERIOD(
            "lines,payments,tracking_categories,company,accounting_period"),

    LINES_TRACKING_CATEGORIES("lines,tracking_categories"),

    LINES_TRACKING_CATEGORIES_ACCOUNTING_PERIOD("lines,tracking_categories,accounting_period"),

    LINES_TRACKING_CATEGORIES_COMPANY("lines,tracking_categories,company"),

    LINES_TRACKING_CATEGORIES_COMPANY_ACCOUNTING_PERIOD("lines,tracking_categories,company,accounting_period"),

    PAYMENTS("payments"),

    PAYMENTS_ACCOUNTING_PERIOD("payments,accounting_period"),

    PAYMENTS_COMPANY("payments,company"),

    PAYMENTS_COMPANY_ACCOUNTING_PERIOD("payments,company,accounting_period"),

    PAYMENTS_TRACKING_CATEGORIES("payments,tracking_categories"),

    PAYMENTS_TRACKING_CATEGORIES_ACCOUNTING_PERIOD("payments,tracking_categories,accounting_period"),

    PAYMENTS_TRACKING_CATEGORIES_COMPANY("payments,tracking_categories,company"),

    PAYMENTS_TRACKING_CATEGORIES_COMPANY_ACCOUNTING_PERIOD("payments,tracking_categories,company,accounting_period"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_ACCOUNTING_PERIOD("tracking_categories,accounting_period"),

    TRACKING_CATEGORIES_COMPANY("tracking_categories,company"),

    TRACKING_CATEGORIES_COMPANY_ACCOUNTING_PERIOD("tracking_categories,company,accounting_period");

    private final String value;

    JournalEntriesListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

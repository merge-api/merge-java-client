package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JournalEntriesRetrieveRequestExpand {
    COMPANY("company"),

    LINES("lines"),

    LINES_COMPANY("lines,company"),

    LINES_PAYMENTS("lines,payments"),

    LINES_PAYMENTS_COMPANY("lines,payments,company"),

    LINES_PAYMENTS_TRACKING_CATEGORIES("lines,payments,tracking_categories"),

    LINES_PAYMENTS_TRACKING_CATEGORIES_COMPANY("lines,payments,tracking_categories,company"),

    LINES_TRACKING_CATEGORIES("lines,tracking_categories"),

    LINES_TRACKING_CATEGORIES_COMPANY("lines,tracking_categories,company"),

    PAYMENTS("payments"),

    PAYMENTS_COMPANY("payments,company"),

    PAYMENTS_TRACKING_CATEGORIES("payments,tracking_categories"),

    PAYMENTS_TRACKING_CATEGORIES_COMPANY("payments,tracking_categories,company"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_COMPANY("tracking_categories,company");

    private final String value;

    JournalEntriesRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

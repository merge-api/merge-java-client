package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CreditNotesRetrieveRequestExpand {
    APPLIED_TO_LINES("applied_to_lines"),

    LINE_ITEMS("line_items"),

    LINE_ITEMS_APPLIED_TO_LINES("line_items,applied_to_lines"),

    LINE_ITEMS_TRACKING_CATEGORIES("line_items,tracking_categories"),

    LINE_ITEMS_TRACKING_CATEGORIES_APPLIED_TO_LINES("line_items,tracking_categories,applied_to_lines"),

    PAYMENTS("payments"),

    PAYMENTS_APPLIED_TO_LINES("payments,applied_to_lines"),

    PAYMENTS_LINE_ITEMS("payments,line_items"),

    PAYMENTS_LINE_ITEMS_APPLIED_TO_LINES("payments,line_items,applied_to_lines"),

    PAYMENTS_LINE_ITEMS_TRACKING_CATEGORIES("payments,line_items,tracking_categories"),

    PAYMENTS_LINE_ITEMS_TRACKING_CATEGORIES_APPLIED_TO_LINES(
            "payments,line_items,tracking_categories,applied_to_lines"),

    PAYMENTS_TRACKING_CATEGORIES("payments,tracking_categories"),

    PAYMENTS_TRACKING_CATEGORIES_APPLIED_TO_LINES("payments,tracking_categories,applied_to_lines"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES("tracking_categories,applied_to_lines");

    private final String value;

    CreditNotesRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

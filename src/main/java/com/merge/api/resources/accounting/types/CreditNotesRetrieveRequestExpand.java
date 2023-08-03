package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CreditNotesRetrieveRequestExpand {
    LINE_ITEMS("line_items"),

    LINE_ITEMS_TRACKING_CATEGORIES("line_items,tracking_categories"),

    PAYMENTS("payments"),

    PAYMENTS_LINE_ITEMS("payments,line_items"),

    PAYMENTS_LINE_ITEMS_TRACKING_CATEGORIES("payments,line_items,tracking_categories"),

    PAYMENTS_TRACKING_CATEGORIES("payments,tracking_categories"),

    TRACKING_CATEGORIES("tracking_categories");

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

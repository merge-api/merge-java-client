package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionsListRequestExpand {
    ACCOUNT("account"),

    CONTACT("contact"),

    CONTACT_ACCOUNT("contact,account"),

    LINE_ITEMS("line_items"),

    LINE_ITEMS_ACCOUNT("line_items,account"),

    LINE_ITEMS_CONTACT("line_items,contact"),

    LINE_ITEMS_CONTACT_ACCOUNT("line_items,contact,account"),

    LINE_ITEMS_TRACKING_CATEGORIES("line_items,tracking_categories"),

    LINE_ITEMS_TRACKING_CATEGORIES_ACCOUNT("line_items,tracking_categories,account"),

    LINE_ITEMS_TRACKING_CATEGORIES_CONTACT("line_items,tracking_categories,contact"),

    LINE_ITEMS_TRACKING_CATEGORIES_CONTACT_ACCOUNT("line_items,tracking_categories,contact,account"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_ACCOUNT("tracking_categories,account"),

    TRACKING_CATEGORIES_CONTACT("tracking_categories,contact"),

    TRACKING_CATEGORIES_CONTACT_ACCOUNT("tracking_categories,contact,account");

    private final String value;

    TransactionsListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

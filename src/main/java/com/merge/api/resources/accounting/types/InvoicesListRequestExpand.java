package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoicesListRequestExpand {
    COMPANY("company"),

    CONTACT("contact"),

    CONTACT_COMPANY("contact,company"),

    LINE_ITEMS("line_items"),

    LINE_ITEMS_COMPANY("line_items,company"),

    LINE_ITEMS_CONTACT("line_items,contact"),

    LINE_ITEMS_CONTACT_COMPANY("line_items,contact,company"),

    LINE_ITEMS_TRACKING_CATEGORIES("line_items,tracking_categories"),

    LINE_ITEMS_TRACKING_CATEGORIES_COMPANY("line_items,tracking_categories,company"),

    LINE_ITEMS_TRACKING_CATEGORIES_CONTACT("line_items,tracking_categories,contact"),

    LINE_ITEMS_TRACKING_CATEGORIES_CONTACT_COMPANY("line_items,tracking_categories,contact,company"),

    PAYMENTS("payments"),

    PAYMENTS_COMPANY("payments,company"),

    PAYMENTS_CONTACT("payments,contact"),

    PAYMENTS_CONTACT_COMPANY("payments,contact,company"),

    PAYMENTS_LINE_ITEMS("payments,line_items"),

    PAYMENTS_LINE_ITEMS_COMPANY("payments,line_items,company"),

    PAYMENTS_LINE_ITEMS_CONTACT("payments,line_items,contact"),

    PAYMENTS_LINE_ITEMS_CONTACT_COMPANY("payments,line_items,contact,company"),

    PAYMENTS_LINE_ITEMS_TRACKING_CATEGORIES("payments,line_items,tracking_categories"),

    PAYMENTS_LINE_ITEMS_TRACKING_CATEGORIES_COMPANY("payments,line_items,tracking_categories,company"),

    PAYMENTS_LINE_ITEMS_TRACKING_CATEGORIES_CONTACT("payments,line_items,tracking_categories,contact"),

    PAYMENTS_LINE_ITEMS_TRACKING_CATEGORIES_CONTACT_COMPANY("payments,line_items,tracking_categories,contact,company"),

    PAYMENTS_TRACKING_CATEGORIES("payments,tracking_categories"),

    PAYMENTS_TRACKING_CATEGORIES_COMPANY("payments,tracking_categories,company"),

    PAYMENTS_TRACKING_CATEGORIES_CONTACT("payments,tracking_categories,contact"),

    PAYMENTS_TRACKING_CATEGORIES_CONTACT_COMPANY("payments,tracking_categories,contact,company"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_COMPANY("tracking_categories,company"),

    TRACKING_CATEGORIES_CONTACT("tracking_categories,contact"),

    TRACKING_CATEGORIES_CONTACT_COMPANY("tracking_categories,contact,company");

    private final String value;

    InvoicesListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PurchaseOrdersRetrieveRequestExpand {
    COMPANY("company"),

    DELIVERY_ADDRESS("delivery_address"),

    DELIVERY_ADDRESS_COMPANY("delivery_address,company"),

    DELIVERY_ADDRESS_VENDOR("delivery_address,vendor"),

    DELIVERY_ADDRESS_VENDOR_COMPANY("delivery_address,vendor,company"),

    LINE_ITEMS("line_items"),

    LINE_ITEMS_COMPANY("line_items,company"),

    LINE_ITEMS_DELIVERY_ADDRESS("line_items,delivery_address"),

    LINE_ITEMS_DELIVERY_ADDRESS_COMPANY("line_items,delivery_address,company"),

    LINE_ITEMS_DELIVERY_ADDRESS_VENDOR("line_items,delivery_address,vendor"),

    LINE_ITEMS_DELIVERY_ADDRESS_VENDOR_COMPANY("line_items,delivery_address,vendor,company"),

    LINE_ITEMS_TRACKING_CATEGORIES("line_items,tracking_categories"),

    LINE_ITEMS_TRACKING_CATEGORIES_COMPANY("line_items,tracking_categories,company"),

    LINE_ITEMS_TRACKING_CATEGORIES_DELIVERY_ADDRESS("line_items,tracking_categories,delivery_address"),

    LINE_ITEMS_TRACKING_CATEGORIES_DELIVERY_ADDRESS_COMPANY("line_items,tracking_categories,delivery_address,company"),

    LINE_ITEMS_TRACKING_CATEGORIES_DELIVERY_ADDRESS_VENDOR("line_items,tracking_categories,delivery_address,vendor"),

    LINE_ITEMS_TRACKING_CATEGORIES_DELIVERY_ADDRESS_VENDOR_COMPANY(
            "line_items,tracking_categories,delivery_address,vendor,company"),

    LINE_ITEMS_TRACKING_CATEGORIES_VENDOR("line_items,tracking_categories,vendor"),

    LINE_ITEMS_TRACKING_CATEGORIES_VENDOR_COMPANY("line_items,tracking_categories,vendor,company"),

    LINE_ITEMS_VENDOR("line_items,vendor"),

    LINE_ITEMS_VENDOR_COMPANY("line_items,vendor,company"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_COMPANY("tracking_categories,company"),

    TRACKING_CATEGORIES_DELIVERY_ADDRESS("tracking_categories,delivery_address"),

    TRACKING_CATEGORIES_DELIVERY_ADDRESS_COMPANY("tracking_categories,delivery_address,company"),

    TRACKING_CATEGORIES_DELIVERY_ADDRESS_VENDOR("tracking_categories,delivery_address,vendor"),

    TRACKING_CATEGORIES_DELIVERY_ADDRESS_VENDOR_COMPANY("tracking_categories,delivery_address,vendor,company"),

    TRACKING_CATEGORIES_VENDOR("tracking_categories,vendor"),

    TRACKING_CATEGORIES_VENDOR_COMPANY("tracking_categories,vendor,company"),

    VENDOR("vendor"),

    VENDOR_COMPANY("vendor,company");

    private final String value;

    PurchaseOrdersRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

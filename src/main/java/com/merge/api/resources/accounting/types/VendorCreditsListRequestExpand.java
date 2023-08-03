package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VendorCreditsListRequestExpand {
    COMPANY("company"),

    LINES("lines"),

    LINES_COMPANY("lines,company"),

    LINES_TRACKING_CATEGORIES("lines,tracking_categories"),

    LINES_TRACKING_CATEGORIES_COMPANY("lines,tracking_categories,company"),

    LINES_TRACKING_CATEGORIES_VENDOR("lines,tracking_categories,vendor"),

    LINES_TRACKING_CATEGORIES_VENDOR_COMPANY("lines,tracking_categories,vendor,company"),

    LINES_VENDOR("lines,vendor"),

    LINES_VENDOR_COMPANY("lines,vendor,company"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_COMPANY("tracking_categories,company"),

    TRACKING_CATEGORIES_VENDOR("tracking_categories,vendor"),

    TRACKING_CATEGORIES_VENDOR_COMPANY("tracking_categories,vendor,company"),

    VENDOR("vendor"),

    VENDOR_COMPANY("vendor,company");

    private final String value;

    VendorCreditsListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VendorCreditsRetrieveRequestExpand {
    APPLIED_TO_LINES("applied_to_lines"),

    APPLIED_TO_LINES_COMPANY("applied_to_lines,company"),

    APPLIED_TO_LINES_VENDOR("applied_to_lines,vendor"),

    APPLIED_TO_LINES_VENDOR_COMPANY("applied_to_lines,vendor,company"),

    COMPANY("company"),

    LINES("lines"),

    LINES_APPLIED_TO_LINES("lines,applied_to_lines"),

    LINES_APPLIED_TO_LINES_COMPANY("lines,applied_to_lines,company"),

    LINES_APPLIED_TO_LINES_VENDOR("lines,applied_to_lines,vendor"),

    LINES_APPLIED_TO_LINES_VENDOR_COMPANY("lines,applied_to_lines,vendor,company"),

    LINES_COMPANY("lines,company"),

    LINES_TRACKING_CATEGORIES("lines,tracking_categories"),

    LINES_TRACKING_CATEGORIES_APPLIED_TO_LINES("lines,tracking_categories,applied_to_lines"),

    LINES_TRACKING_CATEGORIES_APPLIED_TO_LINES_COMPANY("lines,tracking_categories,applied_to_lines,company"),

    LINES_TRACKING_CATEGORIES_APPLIED_TO_LINES_VENDOR("lines,tracking_categories,applied_to_lines,vendor"),

    LINES_TRACKING_CATEGORIES_APPLIED_TO_LINES_VENDOR_COMPANY(
            "lines,tracking_categories,applied_to_lines,vendor,company"),

    LINES_TRACKING_CATEGORIES_COMPANY("lines,tracking_categories,company"),

    LINES_TRACKING_CATEGORIES_VENDOR("lines,tracking_categories,vendor"),

    LINES_TRACKING_CATEGORIES_VENDOR_COMPANY("lines,tracking_categories,vendor,company"),

    LINES_VENDOR("lines,vendor"),

    LINES_VENDOR_COMPANY("lines,vendor,company"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES("tracking_categories,applied_to_lines"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_COMPANY("tracking_categories,applied_to_lines,company"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_VENDOR("tracking_categories,applied_to_lines,vendor"),

    TRACKING_CATEGORIES_APPLIED_TO_LINES_VENDOR_COMPANY("tracking_categories,applied_to_lines,vendor,company"),

    TRACKING_CATEGORIES_COMPANY("tracking_categories,company"),

    TRACKING_CATEGORIES_VENDOR("tracking_categories,vendor"),

    TRACKING_CATEGORIES_VENDOR_COMPANY("tracking_categories,vendor,company"),

    VENDOR("vendor"),

    VENDOR_COMPANY("vendor,company");

    private final String value;

    VendorCreditsRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

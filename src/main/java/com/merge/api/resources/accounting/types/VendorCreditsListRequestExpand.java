package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VendorCreditsListRequestExpand {
    ACCOUNTING_PERIOD("accounting_period"),

    COMPANY("company"),

    COMPANY_ACCOUNTING_PERIOD("company,accounting_period"),

    LINES("lines"),

    LINES_ACCOUNTING_PERIOD("lines,accounting_period"),

    LINES_COMPANY("lines,company"),

    LINES_COMPANY_ACCOUNTING_PERIOD("lines,company,accounting_period"),

    LINES_TRACKING_CATEGORIES("lines,tracking_categories"),

    LINES_TRACKING_CATEGORIES_ACCOUNTING_PERIOD("lines,tracking_categories,accounting_period"),

    LINES_TRACKING_CATEGORIES_COMPANY("lines,tracking_categories,company"),

    LINES_TRACKING_CATEGORIES_COMPANY_ACCOUNTING_PERIOD("lines,tracking_categories,company,accounting_period"),

    LINES_TRACKING_CATEGORIES_VENDOR("lines,tracking_categories,vendor"),

    LINES_TRACKING_CATEGORIES_VENDOR_ACCOUNTING_PERIOD("lines,tracking_categories,vendor,accounting_period"),

    LINES_TRACKING_CATEGORIES_VENDOR_COMPANY("lines,tracking_categories,vendor,company"),

    LINES_TRACKING_CATEGORIES_VENDOR_COMPANY_ACCOUNTING_PERIOD(
            "lines,tracking_categories,vendor,company,accounting_period"),

    LINES_VENDOR("lines,vendor"),

    LINES_VENDOR_ACCOUNTING_PERIOD("lines,vendor,accounting_period"),

    LINES_VENDOR_COMPANY("lines,vendor,company"),

    LINES_VENDOR_COMPANY_ACCOUNTING_PERIOD("lines,vendor,company,accounting_period"),

    TRACKING_CATEGORIES("tracking_categories"),

    TRACKING_CATEGORIES_ACCOUNTING_PERIOD("tracking_categories,accounting_period"),

    TRACKING_CATEGORIES_COMPANY("tracking_categories,company"),

    TRACKING_CATEGORIES_COMPANY_ACCOUNTING_PERIOD("tracking_categories,company,accounting_period"),

    TRACKING_CATEGORIES_VENDOR("tracking_categories,vendor"),

    TRACKING_CATEGORIES_VENDOR_ACCOUNTING_PERIOD("tracking_categories,vendor,accounting_period"),

    TRACKING_CATEGORIES_VENDOR_COMPANY("tracking_categories,vendor,company"),

    TRACKING_CATEGORIES_VENDOR_COMPANY_ACCOUNTING_PERIOD("tracking_categories,vendor,company,accounting_period"),

    VENDOR("vendor"),

    VENDOR_ACCOUNTING_PERIOD("vendor,accounting_period"),

    VENDOR_COMPANY("vendor,company"),

    VENDOR_COMPANY_ACCOUNTING_PERIOD("vendor,company,accounting_period");

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

package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemsRetrieveRequestExpand {
    COMPANY("company"),

    PURCHASE_ACCOUNT("purchase_account"),

    PURCHASE_ACCOUNT_COMPANY("purchase_account,company"),

    PURCHASE_ACCOUNT_SALES_ACCOUNT("purchase_account,sales_account"),

    PURCHASE_ACCOUNT_SALES_ACCOUNT_COMPANY("purchase_account,sales_account,company"),

    SALES_ACCOUNT("sales_account"),

    SALES_ACCOUNT_COMPANY("sales_account,company");

    private final String value;

    ItemsRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

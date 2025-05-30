/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.accounting.companyinfo.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CompanyInfoRetrieveRequestExpand {
    ADDRESSES("addresses"),

    ADDRESSES_PHONE_NUMBERS("addresses,phone_numbers"),

    PHONE_NUMBERS("phone_numbers");

    private final String value;

    CompanyInfoRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

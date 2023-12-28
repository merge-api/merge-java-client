package com.merge.api.resources.accounting.contacts.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContactsListRequestExpand {
    ADDRESSES("addresses"),

    ADDRESSES_COMPANY("addresses,company"),

    ADDRESSES_PHONE_NUMBERS("addresses,phone_numbers"),

    ADDRESSES_PHONE_NUMBERS_COMPANY("addresses,phone_numbers,company"),

    COMPANY("company"),

    PHONE_NUMBERS("phone_numbers"),

    PHONE_NUMBERS_COMPANY("phone_numbers,company");

    private final String value;

    ContactsListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PostingStatusEnum {
    UNPOSTED("UNPOSTED"),

    POSTED("POSTED");

    private final String value;

    PostingStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

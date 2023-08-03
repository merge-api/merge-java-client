package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OfferStatusEnum {
    DRAFT("DRAFT"),

    APPROVAL_SENT("APPROVAL-SENT"),

    APPROVED("APPROVED"),

    SENT("SENT"),

    SENT_MANUALLY("SENT-MANUALLY"),

    OPENED("OPENED"),

    DENIED("DENIED"),

    SIGNED("SIGNED"),

    DEPRECATED("DEPRECATED");

    private final String value;

    OfferStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

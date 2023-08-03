package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AttachmentTypeEnum {
    RESUME("RESUME"),

    COVER_LETTER("COVER_LETTER"),

    OFFER_LETTER("OFFER_LETTER"),

    OTHER("OTHER");

    private final String value;

    AttachmentTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CandidatesListRequestExpand {
    APPLICATIONS("applications"),

    APPLICATIONS_ATTACHMENTS("applications,attachments"),

    ATTACHMENTS("attachments");

    private final String value;

    CandidatesListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

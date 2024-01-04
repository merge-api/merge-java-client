package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CandidatesRetrieveRequestExpand {
    APPLICATIONS("applications"),

    APPLICATIONS_ATTACHMENTS("applications,attachments"),

    ATTACHMENTS("attachments");

    private final String value;

    CandidatesRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

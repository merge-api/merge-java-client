package com.merge.api.resources.ats.jobs.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JobsRetrieveRequestExpand {
    DEPARTMENTS("departments"),

    DEPARTMENTS_HIRING_MANAGERS("departments,hiring_managers"),

    DEPARTMENTS_HIRING_MANAGERS_RECRUITERS("departments,hiring_managers,recruiters"),

    DEPARTMENTS_OFFICES("departments,offices"),

    DEPARTMENTS_OFFICES_HIRING_MANAGERS("departments,offices,hiring_managers"),

    DEPARTMENTS_OFFICES_HIRING_MANAGERS_RECRUITERS("departments,offices,hiring_managers,recruiters"),

    DEPARTMENTS_OFFICES_RECRUITERS("departments,offices,recruiters"),

    DEPARTMENTS_RECRUITERS("departments,recruiters"),

    HIRING_MANAGERS("hiring_managers"),

    HIRING_MANAGERS_RECRUITERS("hiring_managers,recruiters"),

    OFFICES("offices"),

    OFFICES_HIRING_MANAGERS("offices,hiring_managers"),

    OFFICES_HIRING_MANAGERS_RECRUITERS("offices,hiring_managers,recruiters"),

    OFFICES_RECRUITERS("offices,recruiters"),

    RECRUITERS("recruiters");

    private final String value;

    JobsRetrieveRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

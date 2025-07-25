/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class JobsListRequestExpandItem {
    public static final JobsListRequestExpandItem JOB_POSTINGS =
            new JobsListRequestExpandItem(Value.JOB_POSTINGS, "job_postings");

    public static final JobsListRequestExpandItem DEPARTMENTS =
            new JobsListRequestExpandItem(Value.DEPARTMENTS, "departments");

    public static final JobsListRequestExpandItem HIRING_MANAGERS =
            new JobsListRequestExpandItem(Value.HIRING_MANAGERS, "hiring_managers");

    public static final JobsListRequestExpandItem RECRUITERS =
            new JobsListRequestExpandItem(Value.RECRUITERS, "recruiters");

    public static final JobsListRequestExpandItem OFFICES = new JobsListRequestExpandItem(Value.OFFICES, "offices");

    private final Value value;

    private final String string;

    JobsListRequestExpandItem(Value value, String string) {
        this.value = value;
        this.string = string;
    }

    public Value getEnumValue() {
        return value;
    }

    @java.lang.Override
    @JsonValue
    public String toString() {
        return this.string;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        return (this == other)
                || (other instanceof JobsListRequestExpandItem
                        && this.string.equals(((JobsListRequestExpandItem) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case JOB_POSTINGS:
                return visitor.visitJobPostings();
            case DEPARTMENTS:
                return visitor.visitDepartments();
            case HIRING_MANAGERS:
                return visitor.visitHiringManagers();
            case RECRUITERS:
                return visitor.visitRecruiters();
            case OFFICES:
                return visitor.visitOffices();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static JobsListRequestExpandItem valueOf(String value) {
        switch (value) {
            case "job_postings":
                return JOB_POSTINGS;
            case "departments":
                return DEPARTMENTS;
            case "hiring_managers":
                return HIRING_MANAGERS;
            case "recruiters":
                return RECRUITERS;
            case "offices":
                return OFFICES;
            default:
                return new JobsListRequestExpandItem(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        DEPARTMENTS,

        HIRING_MANAGERS,

        JOB_POSTINGS,

        OFFICES,

        RECRUITERS,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitDepartments();

        T visitHiringManagers();

        T visitJobPostings();

        T visitOffices();

        T visitRecruiters();

        T visitUnknown(String unknownType);
    }
}

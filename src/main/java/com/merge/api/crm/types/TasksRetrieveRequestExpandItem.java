/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.crm.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class TasksRetrieveRequestExpandItem {
    public static final TasksRetrieveRequestExpandItem OWNER = new TasksRetrieveRequestExpandItem(Value.OWNER, "owner");

    public static final TasksRetrieveRequestExpandItem OPPORTUNITY =
            new TasksRetrieveRequestExpandItem(Value.OPPORTUNITY, "opportunity");

    public static final TasksRetrieveRequestExpandItem ACCOUNT =
            new TasksRetrieveRequestExpandItem(Value.ACCOUNT, "account");

    private final Value value;

    private final String string;

    TasksRetrieveRequestExpandItem(Value value, String string) {
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
                || (other instanceof TasksRetrieveRequestExpandItem
                        && this.string.equals(((TasksRetrieveRequestExpandItem) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case OWNER:
                return visitor.visitOwner();
            case OPPORTUNITY:
                return visitor.visitOpportunity();
            case ACCOUNT:
                return visitor.visitAccount();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TasksRetrieveRequestExpandItem valueOf(String value) {
        switch (value) {
            case "owner":
                return OWNER;
            case "opportunity":
                return OPPORTUNITY;
            case "account":
                return ACCOUNT;
            default:
                return new TasksRetrieveRequestExpandItem(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        ACCOUNT,

        OPPORTUNITY,

        OWNER,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitAccount();

        T visitOpportunity();

        T visitOwner();

        T visitUnknown(String unknownType);
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class BankInfoListRequestOrderBy {
    public static final BankInfoListRequestOrderBy REMOTE_CREATED_AT_DESCENDING =
            new BankInfoListRequestOrderBy(Value.REMOTE_CREATED_AT_DESCENDING, "-remote_created_at");

    public static final BankInfoListRequestOrderBy REMOTE_CREATED_AT_ASCENDING =
            new BankInfoListRequestOrderBy(Value.REMOTE_CREATED_AT_ASCENDING, "remote_created_at");

    private final Value value;

    private final String string;

    BankInfoListRequestOrderBy(Value value, String string) {
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
                || (other instanceof BankInfoListRequestOrderBy
                        && this.string.equals(((BankInfoListRequestOrderBy) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case REMOTE_CREATED_AT_DESCENDING:
                return visitor.visitRemoteCreatedAtDescending();
            case REMOTE_CREATED_AT_ASCENDING:
                return visitor.visitRemoteCreatedAtAscending();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BankInfoListRequestOrderBy valueOf(String value) {
        switch (value) {
            case "-remote_created_at":
                return REMOTE_CREATED_AT_DESCENDING;
            case "remote_created_at":
                return REMOTE_CREATED_AT_ASCENDING;
            default:
                return new BankInfoListRequestOrderBy(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        REMOTE_CREATED_AT_DESCENDING,

        REMOTE_CREATED_AT_ASCENDING,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitRemoteCreatedAtDescending();

        T visitRemoteCreatedAtAscending();

        T visitUnknown(String unknownType);
    }
}

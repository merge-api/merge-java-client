/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class CreditNotesListRequestShowEnumOrigins {
    public static final CreditNotesListRequestShowEnumOrigins STATUS =
            new CreditNotesListRequestShowEnumOrigins(Value.STATUS, "status");

    public static final CreditNotesListRequestShowEnumOrigins STATUS_TYPE =
            new CreditNotesListRequestShowEnumOrigins(Value.STATUS_TYPE, "status,type");

    public static final CreditNotesListRequestShowEnumOrigins TYPE =
            new CreditNotesListRequestShowEnumOrigins(Value.TYPE, "type");

    private final Value value;

    private final String string;

    CreditNotesListRequestShowEnumOrigins(Value value, String string) {
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
                || (other instanceof CreditNotesListRequestShowEnumOrigins
                        && this.string.equals(((CreditNotesListRequestShowEnumOrigins) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case STATUS:
                return visitor.visitStatus();
            case STATUS_TYPE:
                return visitor.visitStatusType();
            case TYPE:
                return visitor.visitType();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CreditNotesListRequestShowEnumOrigins valueOf(String value) {
        switch (value) {
            case "status":
                return STATUS;
            case "status,type":
                return STATUS_TYPE;
            case "type":
                return TYPE;
            default:
                return new CreditNotesListRequestShowEnumOrigins(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        STATUS,

        STATUS_TYPE,

        TYPE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitStatus();

        T visitStatusType();

        T visitType();

        T visitUnknown(String unknownType);
    }
}

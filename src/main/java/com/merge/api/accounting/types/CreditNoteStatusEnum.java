/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class CreditNoteStatusEnum {
    public static final CreditNoteStatusEnum AUTHORIZED = new CreditNoteStatusEnum(Value.AUTHORIZED, "AUTHORIZED");

    public static final CreditNoteStatusEnum SUBMITTED = new CreditNoteStatusEnum(Value.SUBMITTED, "SUBMITTED");

    public static final CreditNoteStatusEnum PAID = new CreditNoteStatusEnum(Value.PAID, "PAID");

    private final Value value;

    private final String string;

    CreditNoteStatusEnum(Value value, String string) {
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
                || (other instanceof CreditNoteStatusEnum && this.string.equals(((CreditNoteStatusEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case AUTHORIZED:
                return visitor.visitAuthorized();
            case SUBMITTED:
                return visitor.visitSubmitted();
            case PAID:
                return visitor.visitPaid();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CreditNoteStatusEnum valueOf(String value) {
        switch (value) {
            case "AUTHORIZED":
                return AUTHORIZED;
            case "SUBMITTED":
                return SUBMITTED;
            case "PAID":
                return PAID;
            default:
                return new CreditNoteStatusEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        SUBMITTED,

        AUTHORIZED,

        PAID,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitSubmitted();

        T visitAuthorized();

        T visitPaid();

        T visitUnknown(String unknownType);
    }
}

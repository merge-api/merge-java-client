/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class InvoiceTypeEnum {
    public static final InvoiceTypeEnum ACCOUNTS_PAYABLE =
            new InvoiceTypeEnum(Value.ACCOUNTS_PAYABLE, "ACCOUNTS_PAYABLE");

    public static final InvoiceTypeEnum ACCOUNTS_RECEIVABLE =
            new InvoiceTypeEnum(Value.ACCOUNTS_RECEIVABLE, "ACCOUNTS_RECEIVABLE");

    private final Value value;

    private final String string;

    InvoiceTypeEnum(Value value, String string) {
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
                || (other instanceof InvoiceTypeEnum && this.string.equals(((InvoiceTypeEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case ACCOUNTS_PAYABLE:
                return visitor.visitAccountsPayable();
            case ACCOUNTS_RECEIVABLE:
                return visitor.visitAccountsReceivable();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static InvoiceTypeEnum valueOf(String value) {
        switch (value) {
            case "ACCOUNTS_PAYABLE":
                return ACCOUNTS_PAYABLE;
            case "ACCOUNTS_RECEIVABLE":
                return ACCOUNTS_RECEIVABLE;
            default:
                return new InvoiceTypeEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        ACCOUNTS_RECEIVABLE,

        ACCOUNTS_PAYABLE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitAccountsReceivable();

        T visitAccountsPayable();

        T visitUnknown(String unknownType);
    }
}

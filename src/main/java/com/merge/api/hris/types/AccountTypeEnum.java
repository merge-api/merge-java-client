/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class AccountTypeEnum {
    public static final AccountTypeEnum SAVINGS = new AccountTypeEnum(Value.SAVINGS, "SAVINGS");

    public static final AccountTypeEnum CHECKING = new AccountTypeEnum(Value.CHECKING, "CHECKING");

    private final Value value;

    private final String string;

    AccountTypeEnum(Value value, String string) {
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
                || (other instanceof AccountTypeEnum && this.string.equals(((AccountTypeEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case SAVINGS:
                return visitor.visitSavings();
            case CHECKING:
                return visitor.visitChecking();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static AccountTypeEnum valueOf(String value) {
        switch (value) {
            case "SAVINGS":
                return SAVINGS;
            case "CHECKING":
                return CHECKING;
            default:
                return new AccountTypeEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        SAVINGS,

        CHECKING,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitSavings();

        T visitChecking();

        T visitUnknown(String unknownType);
    }
}

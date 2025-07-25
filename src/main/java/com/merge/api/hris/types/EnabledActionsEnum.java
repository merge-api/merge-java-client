/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class EnabledActionsEnum {
    public static final EnabledActionsEnum READ = new EnabledActionsEnum(Value.READ, "READ");

    public static final EnabledActionsEnum WRITE = new EnabledActionsEnum(Value.WRITE, "WRITE");

    private final Value value;

    private final String string;

    EnabledActionsEnum(Value value, String string) {
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
                || (other instanceof EnabledActionsEnum && this.string.equals(((EnabledActionsEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case READ:
                return visitor.visitRead();
            case WRITE:
                return visitor.visitWrite();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EnabledActionsEnum valueOf(String value) {
        switch (value) {
            case "READ":
                return READ;
            case "WRITE":
                return WRITE;
            default:
                return new EnabledActionsEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        READ,

        WRITE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitRead();

        T visitWrite();

        T visitUnknown(String unknownType);
    }
}

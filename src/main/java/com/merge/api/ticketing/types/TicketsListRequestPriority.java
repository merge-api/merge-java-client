/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class TicketsListRequestPriority {
    public static final TicketsListRequestPriority URGENT = new TicketsListRequestPriority(Value.URGENT, "URGENT");

    public static final TicketsListRequestPriority NORMAL = new TicketsListRequestPriority(Value.NORMAL, "NORMAL");

    public static final TicketsListRequestPriority LOW = new TicketsListRequestPriority(Value.LOW, "LOW");

    public static final TicketsListRequestPriority HIGH = new TicketsListRequestPriority(Value.HIGH, "HIGH");

    private final Value value;

    private final String string;

    TicketsListRequestPriority(Value value, String string) {
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
                || (other instanceof TicketsListRequestPriority
                        && this.string.equals(((TicketsListRequestPriority) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case URGENT:
                return visitor.visitUrgent();
            case NORMAL:
                return visitor.visitNormal();
            case LOW:
                return visitor.visitLow();
            case HIGH:
                return visitor.visitHigh();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TicketsListRequestPriority valueOf(String value) {
        switch (value) {
            case "URGENT":
                return URGENT;
            case "NORMAL":
                return NORMAL;
            case "LOW":
                return LOW;
            case "HIGH":
                return HIGH;
            default:
                return new TicketsListRequestPriority(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        HIGH,

        LOW,

        NORMAL,

        URGENT,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitHigh();

        T visitLow();

        T visitNormal();

        T visitUrgent();

        T visitUnknown(String unknownType);
    }
}

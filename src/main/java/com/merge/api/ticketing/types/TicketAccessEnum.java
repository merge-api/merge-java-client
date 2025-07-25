/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class TicketAccessEnum {
    public static final TicketAccessEnum ALL = new TicketAccessEnum(Value.ALL, "ALL");

    public static final TicketAccessEnum TEAM_ONLY = new TicketAccessEnum(Value.TEAM_ONLY, "TEAM_ONLY");

    public static final TicketAccessEnum ASSIGNED_ONLY = new TicketAccessEnum(Value.ASSIGNED_ONLY, "ASSIGNED_ONLY");

    private final Value value;

    private final String string;

    TicketAccessEnum(Value value, String string) {
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
                || (other instanceof TicketAccessEnum && this.string.equals(((TicketAccessEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case ALL:
                return visitor.visitAll();
            case TEAM_ONLY:
                return visitor.visitTeamOnly();
            case ASSIGNED_ONLY:
                return visitor.visitAssignedOnly();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TicketAccessEnum valueOf(String value) {
        switch (value) {
            case "ALL":
                return ALL;
            case "TEAM_ONLY":
                return TEAM_ONLY;
            case "ASSIGNED_ONLY":
                return ASSIGNED_ONLY;
            default:
                return new TicketAccessEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        ALL,

        ASSIGNED_ONLY,

        TEAM_ONLY,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitAll();

        T visitAssignedOnly();

        T visitTeamOnly();

        T visitUnknown(String unknownType);
    }
}

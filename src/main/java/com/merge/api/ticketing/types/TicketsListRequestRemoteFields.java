/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class TicketsListRequestRemoteFields {
    public static final TicketsListRequestRemoteFields PRIORITY_TICKET_TYPE =
            new TicketsListRequestRemoteFields(Value.PRIORITY_TICKET_TYPE, "priority,ticket_type");

    public static final TicketsListRequestRemoteFields TICKET_TYPE =
            new TicketsListRequestRemoteFields(Value.TICKET_TYPE, "ticket_type");

    public static final TicketsListRequestRemoteFields PRIORITY_STATUS_TICKET_TYPE =
            new TicketsListRequestRemoteFields(Value.PRIORITY_STATUS_TICKET_TYPE, "priority,status,ticket_type");

    public static final TicketsListRequestRemoteFields STATUS =
            new TicketsListRequestRemoteFields(Value.STATUS, "status");

    public static final TicketsListRequestRemoteFields PRIORITY =
            new TicketsListRequestRemoteFields(Value.PRIORITY, "priority");

    public static final TicketsListRequestRemoteFields STATUS_TICKET_TYPE =
            new TicketsListRequestRemoteFields(Value.STATUS_TICKET_TYPE, "status,ticket_type");

    public static final TicketsListRequestRemoteFields PRIORITY_STATUS =
            new TicketsListRequestRemoteFields(Value.PRIORITY_STATUS, "priority,status");

    private final Value value;

    private final String string;

    TicketsListRequestRemoteFields(Value value, String string) {
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
                || (other instanceof TicketsListRequestRemoteFields
                        && this.string.equals(((TicketsListRequestRemoteFields) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case PRIORITY_TICKET_TYPE:
                return visitor.visitPriorityTicketType();
            case TICKET_TYPE:
                return visitor.visitTicketType();
            case PRIORITY_STATUS_TICKET_TYPE:
                return visitor.visitPriorityStatusTicketType();
            case STATUS:
                return visitor.visitStatus();
            case PRIORITY:
                return visitor.visitPriority();
            case STATUS_TICKET_TYPE:
                return visitor.visitStatusTicketType();
            case PRIORITY_STATUS:
                return visitor.visitPriorityStatus();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TicketsListRequestRemoteFields valueOf(String value) {
        switch (value) {
            case "priority,ticket_type":
                return PRIORITY_TICKET_TYPE;
            case "ticket_type":
                return TICKET_TYPE;
            case "priority,status,ticket_type":
                return PRIORITY_STATUS_TICKET_TYPE;
            case "status":
                return STATUS;
            case "priority":
                return PRIORITY;
            case "status,ticket_type":
                return STATUS_TICKET_TYPE;
            case "priority,status":
                return PRIORITY_STATUS;
            default:
                return new TicketsListRequestRemoteFields(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        PRIORITY,

        PRIORITY_STATUS,

        PRIORITY_STATUS_TICKET_TYPE,

        PRIORITY_TICKET_TYPE,

        STATUS,

        STATUS_TICKET_TYPE,

        TICKET_TYPE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitPriority();

        T visitPriorityStatus();

        T visitPriorityStatusTicketType();

        T visitPriorityTicketType();

        T visitStatus();

        T visitStatusTicketType();

        T visitTicketType();

        T visitUnknown(String unknownType);
    }
}

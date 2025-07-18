/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ActivitiesListRequestShowEnumOrigins {
    public static final ActivitiesListRequestShowEnumOrigins ACTIVITY_TYPE =
            new ActivitiesListRequestShowEnumOrigins(Value.ACTIVITY_TYPE, "activity_type");

    public static final ActivitiesListRequestShowEnumOrigins ACTIVITY_TYPE_VISIBILITY =
            new ActivitiesListRequestShowEnumOrigins(Value.ACTIVITY_TYPE_VISIBILITY, "activity_type,visibility");

    public static final ActivitiesListRequestShowEnumOrigins VISIBILITY =
            new ActivitiesListRequestShowEnumOrigins(Value.VISIBILITY, "visibility");

    private final Value value;

    private final String string;

    ActivitiesListRequestShowEnumOrigins(Value value, String string) {
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
                || (other instanceof ActivitiesListRequestShowEnumOrigins
                        && this.string.equals(((ActivitiesListRequestShowEnumOrigins) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case ACTIVITY_TYPE:
                return visitor.visitActivityType();
            case ACTIVITY_TYPE_VISIBILITY:
                return visitor.visitActivityTypeVisibility();
            case VISIBILITY:
                return visitor.visitVisibility();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ActivitiesListRequestShowEnumOrigins valueOf(String value) {
        switch (value) {
            case "activity_type":
                return ACTIVITY_TYPE;
            case "activity_type,visibility":
                return ACTIVITY_TYPE_VISIBILITY;
            case "visibility":
                return VISIBILITY;
            default:
                return new ActivitiesListRequestShowEnumOrigins(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        ACTIVITY_TYPE,

        ACTIVITY_TYPE_VISIBILITY,

        VISIBILITY,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitActivityType();

        T visitActivityTypeVisibility();

        T visitVisibility();

        T visitUnknown(String unknownType);
    }
}

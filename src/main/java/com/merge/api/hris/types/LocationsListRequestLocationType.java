/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class LocationsListRequestLocationType {
    public static final LocationsListRequestLocationType WORK =
            new LocationsListRequestLocationType(Value.WORK, "WORK");

    public static final LocationsListRequestLocationType HOME =
            new LocationsListRequestLocationType(Value.HOME, "HOME");

    private final Value value;

    private final String string;

    LocationsListRequestLocationType(Value value, String string) {
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
                || (other instanceof LocationsListRequestLocationType
                        && this.string.equals(((LocationsListRequestLocationType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case WORK:
                return visitor.visitWork();
            case HOME:
                return visitor.visitHome();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static LocationsListRequestLocationType valueOf(String value) {
        switch (value) {
            case "WORK":
                return WORK;
            case "HOME":
                return HOME;
            default:
                return new LocationsListRequestLocationType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        HOME,

        WORK,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitHome();

        T visitWork();

        T visitUnknown(String unknownType);
    }
}

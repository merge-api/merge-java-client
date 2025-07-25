/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class LocationsRetrieveRequestShowEnumOrigins {
    public static final LocationsRetrieveRequestShowEnumOrigins COUNTRY =
            new LocationsRetrieveRequestShowEnumOrigins(Value.COUNTRY, "country");

    public static final LocationsRetrieveRequestShowEnumOrigins LOCATION_TYPE =
            new LocationsRetrieveRequestShowEnumOrigins(Value.LOCATION_TYPE, "location_type");

    public static final LocationsRetrieveRequestShowEnumOrigins COUNTRY_LOCATION_TYPE =
            new LocationsRetrieveRequestShowEnumOrigins(Value.COUNTRY_LOCATION_TYPE, "country,location_type");

    private final Value value;

    private final String string;

    LocationsRetrieveRequestShowEnumOrigins(Value value, String string) {
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
                || (other instanceof LocationsRetrieveRequestShowEnumOrigins
                        && this.string.equals(((LocationsRetrieveRequestShowEnumOrigins) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case COUNTRY:
                return visitor.visitCountry();
            case LOCATION_TYPE:
                return visitor.visitLocationType();
            case COUNTRY_LOCATION_TYPE:
                return visitor.visitCountryLocationType();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static LocationsRetrieveRequestShowEnumOrigins valueOf(String value) {
        switch (value) {
            case "country":
                return COUNTRY;
            case "location_type":
                return LOCATION_TYPE;
            case "country,location_type":
                return COUNTRY_LOCATION_TYPE;
            default:
                return new LocationsRetrieveRequestShowEnumOrigins(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        COUNTRY,

        COUNTRY_LOCATION_TYPE,

        LOCATION_TYPE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitCountry();

        T visitCountryLocationType();

        T visitLocationType();

        T visitUnknown(String unknownType);
    }
}

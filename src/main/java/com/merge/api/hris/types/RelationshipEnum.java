/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class RelationshipEnum {
    public static final RelationshipEnum DOMESTIC_PARTNER =
            new RelationshipEnum(Value.DOMESTIC_PARTNER, "DOMESTIC_PARTNER");

    public static final RelationshipEnum SPOUSE = new RelationshipEnum(Value.SPOUSE, "SPOUSE");

    public static final RelationshipEnum CHILD = new RelationshipEnum(Value.CHILD, "CHILD");

    private final Value value;

    private final String string;

    RelationshipEnum(Value value, String string) {
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
                || (other instanceof RelationshipEnum && this.string.equals(((RelationshipEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case DOMESTIC_PARTNER:
                return visitor.visitDomesticPartner();
            case SPOUSE:
                return visitor.visitSpouse();
            case CHILD:
                return visitor.visitChild();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static RelationshipEnum valueOf(String value) {
        switch (value) {
            case "DOMESTIC_PARTNER":
                return DOMESTIC_PARTNER;
            case "SPOUSE":
                return SPOUSE;
            case "CHILD":
                return CHILD;
            default:
                return new RelationshipEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        CHILD,

        SPOUSE,

        DOMESTIC_PARTNER,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitChild();

        T visitSpouse();

        T visitDomesticPartner();

        T visitUnknown(String unknownType);
    }
}

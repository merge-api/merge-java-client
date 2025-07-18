/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class GenderEnum {
    public static final GenderEnum OTHER = new GenderEnum(Value.OTHER, "OTHER");

    public static final GenderEnum NON_BINARY = new GenderEnum(Value.NON_BINARY, "NON-BINARY");

    public static final GenderEnum FEMALE = new GenderEnum(Value.FEMALE, "FEMALE");

    public static final GenderEnum DECLINE_TO_SELF_IDENTIFY =
            new GenderEnum(Value.DECLINE_TO_SELF_IDENTIFY, "DECLINE_TO_SELF_IDENTIFY");

    public static final GenderEnum MALE = new GenderEnum(Value.MALE, "MALE");

    private final Value value;

    private final String string;

    GenderEnum(Value value, String string) {
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
        return (this == other) || (other instanceof GenderEnum && this.string.equals(((GenderEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case OTHER:
                return visitor.visitOther();
            case NON_BINARY:
                return visitor.visitNonBinary();
            case FEMALE:
                return visitor.visitFemale();
            case DECLINE_TO_SELF_IDENTIFY:
                return visitor.visitDeclineToSelfIdentify();
            case MALE:
                return visitor.visitMale();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static GenderEnum valueOf(String value) {
        switch (value) {
            case "OTHER":
                return OTHER;
            case "NON-BINARY":
                return NON_BINARY;
            case "FEMALE":
                return FEMALE;
            case "DECLINE_TO_SELF_IDENTIFY":
                return DECLINE_TO_SELF_IDENTIFY;
            case "MALE":
                return MALE;
            default:
                return new GenderEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        MALE,

        FEMALE,

        NON_BINARY,

        OTHER,

        DECLINE_TO_SELF_IDENTIFY,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitMale();

        T visitFemale();

        T visitNonBinary();

        T visitOther();

        T visitDeclineToSelfIdentify();

        T visitUnknown(String unknownType);
    }
}

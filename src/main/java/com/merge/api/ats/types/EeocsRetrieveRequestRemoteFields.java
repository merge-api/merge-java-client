/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class EeocsRetrieveRequestRemoteFields {
    public static final EeocsRetrieveRequestRemoteFields GENDER =
            new EeocsRetrieveRequestRemoteFields(Value.GENDER, "gender");

    public static final EeocsRetrieveRequestRemoteFields DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS =
            new EeocsRetrieveRequestRemoteFields(
                    Value.DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS, "disability_status,gender,race,veteran_status");

    public static final EeocsRetrieveRequestRemoteFields DISABILITY_STATUS_GENDER_VETERAN_STATUS =
            new EeocsRetrieveRequestRemoteFields(
                    Value.DISABILITY_STATUS_GENDER_VETERAN_STATUS, "disability_status,gender,veteran_status");

    public static final EeocsRetrieveRequestRemoteFields RACE_VETERAN_STATUS =
            new EeocsRetrieveRequestRemoteFields(Value.RACE_VETERAN_STATUS, "race,veteran_status");

    public static final EeocsRetrieveRequestRemoteFields DISABILITY_STATUS_GENDER_RACE =
            new EeocsRetrieveRequestRemoteFields(Value.DISABILITY_STATUS_GENDER_RACE, "disability_status,gender,race");

    public static final EeocsRetrieveRequestRemoteFields DISABILITY_STATUS_VETERAN_STATUS =
            new EeocsRetrieveRequestRemoteFields(
                    Value.DISABILITY_STATUS_VETERAN_STATUS, "disability_status,veteran_status");

    public static final EeocsRetrieveRequestRemoteFields GENDER_RACE =
            new EeocsRetrieveRequestRemoteFields(Value.GENDER_RACE, "gender,race");

    public static final EeocsRetrieveRequestRemoteFields DISABILITY_STATUS_RACE =
            new EeocsRetrieveRequestRemoteFields(Value.DISABILITY_STATUS_RACE, "disability_status,race");

    public static final EeocsRetrieveRequestRemoteFields VETERAN_STATUS =
            new EeocsRetrieveRequestRemoteFields(Value.VETERAN_STATUS, "veteran_status");

    public static final EeocsRetrieveRequestRemoteFields DISABILITY_STATUS_RACE_VETERAN_STATUS =
            new EeocsRetrieveRequestRemoteFields(
                    Value.DISABILITY_STATUS_RACE_VETERAN_STATUS, "disability_status,race,veteran_status");

    public static final EeocsRetrieveRequestRemoteFields DISABILITY_STATUS_GENDER =
            new EeocsRetrieveRequestRemoteFields(Value.DISABILITY_STATUS_GENDER, "disability_status,gender");

    public static final EeocsRetrieveRequestRemoteFields GENDER_RACE_VETERAN_STATUS =
            new EeocsRetrieveRequestRemoteFields(Value.GENDER_RACE_VETERAN_STATUS, "gender,race,veteran_status");

    public static final EeocsRetrieveRequestRemoteFields DISABILITY_STATUS =
            new EeocsRetrieveRequestRemoteFields(Value.DISABILITY_STATUS, "disability_status");

    public static final EeocsRetrieveRequestRemoteFields GENDER_VETERAN_STATUS =
            new EeocsRetrieveRequestRemoteFields(Value.GENDER_VETERAN_STATUS, "gender,veteran_status");

    public static final EeocsRetrieveRequestRemoteFields RACE =
            new EeocsRetrieveRequestRemoteFields(Value.RACE, "race");

    private final Value value;

    private final String string;

    EeocsRetrieveRequestRemoteFields(Value value, String string) {
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
                || (other instanceof EeocsRetrieveRequestRemoteFields
                        && this.string.equals(((EeocsRetrieveRequestRemoteFields) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case GENDER:
                return visitor.visitGender();
            case DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS:
                return visitor.visitDisabilityStatusGenderRaceVeteranStatus();
            case DISABILITY_STATUS_GENDER_VETERAN_STATUS:
                return visitor.visitDisabilityStatusGenderVeteranStatus();
            case RACE_VETERAN_STATUS:
                return visitor.visitRaceVeteranStatus();
            case DISABILITY_STATUS_GENDER_RACE:
                return visitor.visitDisabilityStatusGenderRace();
            case DISABILITY_STATUS_VETERAN_STATUS:
                return visitor.visitDisabilityStatusVeteranStatus();
            case GENDER_RACE:
                return visitor.visitGenderRace();
            case DISABILITY_STATUS_RACE:
                return visitor.visitDisabilityStatusRace();
            case VETERAN_STATUS:
                return visitor.visitVeteranStatus();
            case DISABILITY_STATUS_RACE_VETERAN_STATUS:
                return visitor.visitDisabilityStatusRaceVeteranStatus();
            case DISABILITY_STATUS_GENDER:
                return visitor.visitDisabilityStatusGender();
            case GENDER_RACE_VETERAN_STATUS:
                return visitor.visitGenderRaceVeteranStatus();
            case DISABILITY_STATUS:
                return visitor.visitDisabilityStatus();
            case GENDER_VETERAN_STATUS:
                return visitor.visitGenderVeteranStatus();
            case RACE:
                return visitor.visitRace();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EeocsRetrieveRequestRemoteFields valueOf(String value) {
        switch (value) {
            case "gender":
                return GENDER;
            case "disability_status,gender,race,veteran_status":
                return DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS;
            case "disability_status,gender,veteran_status":
                return DISABILITY_STATUS_GENDER_VETERAN_STATUS;
            case "race,veteran_status":
                return RACE_VETERAN_STATUS;
            case "disability_status,gender,race":
                return DISABILITY_STATUS_GENDER_RACE;
            case "disability_status,veteran_status":
                return DISABILITY_STATUS_VETERAN_STATUS;
            case "gender,race":
                return GENDER_RACE;
            case "disability_status,race":
                return DISABILITY_STATUS_RACE;
            case "veteran_status":
                return VETERAN_STATUS;
            case "disability_status,race,veteran_status":
                return DISABILITY_STATUS_RACE_VETERAN_STATUS;
            case "disability_status,gender":
                return DISABILITY_STATUS_GENDER;
            case "gender,race,veteran_status":
                return GENDER_RACE_VETERAN_STATUS;
            case "disability_status":
                return DISABILITY_STATUS;
            case "gender,veteran_status":
                return GENDER_VETERAN_STATUS;
            case "race":
                return RACE;
            default:
                return new EeocsRetrieveRequestRemoteFields(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        DISABILITY_STATUS,

        DISABILITY_STATUS_GENDER,

        DISABILITY_STATUS_GENDER_RACE,

        DISABILITY_STATUS_GENDER_RACE_VETERAN_STATUS,

        DISABILITY_STATUS_GENDER_VETERAN_STATUS,

        DISABILITY_STATUS_RACE,

        DISABILITY_STATUS_RACE_VETERAN_STATUS,

        DISABILITY_STATUS_VETERAN_STATUS,

        GENDER,

        GENDER_RACE,

        GENDER_RACE_VETERAN_STATUS,

        GENDER_VETERAN_STATUS,

        RACE,

        RACE_VETERAN_STATUS,

        VETERAN_STATUS,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitDisabilityStatus();

        T visitDisabilityStatusGender();

        T visitDisabilityStatusGenderRace();

        T visitDisabilityStatusGenderRaceVeteranStatus();

        T visitDisabilityStatusGenderVeteranStatus();

        T visitDisabilityStatusRace();

        T visitDisabilityStatusRaceVeteranStatus();

        T visitDisabilityStatusVeteranStatus();

        T visitGender();

        T visitGenderRace();

        T visitGenderRaceVeteranStatus();

        T visitGenderVeteranStatus();

        T visitRace();

        T visitRaceVeteranStatus();

        T visitVeteranStatus();

        T visitUnknown(String unknownType);
    }
}

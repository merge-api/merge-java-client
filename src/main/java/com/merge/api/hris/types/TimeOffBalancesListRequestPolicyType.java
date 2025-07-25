/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class TimeOffBalancesListRequestPolicyType {
    public static final TimeOffBalancesListRequestPolicyType VACATION =
            new TimeOffBalancesListRequestPolicyType(Value.VACATION, "VACATION");

    public static final TimeOffBalancesListRequestPolicyType VOLUNTEER =
            new TimeOffBalancesListRequestPolicyType(Value.VOLUNTEER, "VOLUNTEER");

    public static final TimeOffBalancesListRequestPolicyType JURY_DUTY =
            new TimeOffBalancesListRequestPolicyType(Value.JURY_DUTY, "JURY_DUTY");

    public static final TimeOffBalancesListRequestPolicyType BEREAVEMENT =
            new TimeOffBalancesListRequestPolicyType(Value.BEREAVEMENT, "BEREAVEMENT");

    public static final TimeOffBalancesListRequestPolicyType SICK =
            new TimeOffBalancesListRequestPolicyType(Value.SICK, "SICK");

    public static final TimeOffBalancesListRequestPolicyType PERSONAL =
            new TimeOffBalancesListRequestPolicyType(Value.PERSONAL, "PERSONAL");

    private final Value value;

    private final String string;

    TimeOffBalancesListRequestPolicyType(Value value, String string) {
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
                || (other instanceof TimeOffBalancesListRequestPolicyType
                        && this.string.equals(((TimeOffBalancesListRequestPolicyType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case VACATION:
                return visitor.visitVacation();
            case VOLUNTEER:
                return visitor.visitVolunteer();
            case JURY_DUTY:
                return visitor.visitJuryDuty();
            case BEREAVEMENT:
                return visitor.visitBereavement();
            case SICK:
                return visitor.visitSick();
            case PERSONAL:
                return visitor.visitPersonal();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TimeOffBalancesListRequestPolicyType valueOf(String value) {
        switch (value) {
            case "VACATION":
                return VACATION;
            case "VOLUNTEER":
                return VOLUNTEER;
            case "JURY_DUTY":
                return JURY_DUTY;
            case "BEREAVEMENT":
                return BEREAVEMENT;
            case "SICK":
                return SICK;
            case "PERSONAL":
                return PERSONAL;
            default:
                return new TimeOffBalancesListRequestPolicyType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        BEREAVEMENT,

        JURY_DUTY,

        PERSONAL,

        SICK,

        VACATION,

        VOLUNTEER,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitBereavement();

        T visitJuryDuty();

        T visitPersonal();

        T visitSick();

        T visitVacation();

        T visitVolunteer();

        T visitUnknown(String unknownType);
    }
}

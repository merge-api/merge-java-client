/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class PayrollRunsListRequestRunType {
    public static final PayrollRunsListRequestRunType CORRECTION =
            new PayrollRunsListRequestRunType(Value.CORRECTION, "CORRECTION");

    public static final PayrollRunsListRequestRunType REGULAR =
            new PayrollRunsListRequestRunType(Value.REGULAR, "REGULAR");

    public static final PayrollRunsListRequestRunType SIGN_ON_BONUS =
            new PayrollRunsListRequestRunType(Value.SIGN_ON_BONUS, "SIGN_ON_BONUS");

    public static final PayrollRunsListRequestRunType OFF_CYCLE =
            new PayrollRunsListRequestRunType(Value.OFF_CYCLE, "OFF_CYCLE");

    public static final PayrollRunsListRequestRunType TERMINATION =
            new PayrollRunsListRequestRunType(Value.TERMINATION, "TERMINATION");

    private final Value value;

    private final String string;

    PayrollRunsListRequestRunType(Value value, String string) {
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
                || (other instanceof PayrollRunsListRequestRunType
                        && this.string.equals(((PayrollRunsListRequestRunType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case CORRECTION:
                return visitor.visitCorrection();
            case REGULAR:
                return visitor.visitRegular();
            case SIGN_ON_BONUS:
                return visitor.visitSignOnBonus();
            case OFF_CYCLE:
                return visitor.visitOffCycle();
            case TERMINATION:
                return visitor.visitTermination();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PayrollRunsListRequestRunType valueOf(String value) {
        switch (value) {
            case "CORRECTION":
                return CORRECTION;
            case "REGULAR":
                return REGULAR;
            case "SIGN_ON_BONUS":
                return SIGN_ON_BONUS;
            case "OFF_CYCLE":
                return OFF_CYCLE;
            case "TERMINATION":
                return TERMINATION;
            default:
                return new PayrollRunsListRequestRunType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        CORRECTION,

        OFF_CYCLE,

        REGULAR,

        SIGN_ON_BONUS,

        TERMINATION,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitCorrection();

        T visitOffCycle();

        T visitRegular();

        T visitSignOnBonus();

        T visitTermination();

        T visitUnknown(String unknownType);
    }
}

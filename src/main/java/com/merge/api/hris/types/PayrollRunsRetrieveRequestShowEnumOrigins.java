/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class PayrollRunsRetrieveRequestShowEnumOrigins {
    public static final PayrollRunsRetrieveRequestShowEnumOrigins RUN_TYPE =
            new PayrollRunsRetrieveRequestShowEnumOrigins(Value.RUN_TYPE, "run_type");

    public static final PayrollRunsRetrieveRequestShowEnumOrigins RUN_STATE_RUN_TYPE =
            new PayrollRunsRetrieveRequestShowEnumOrigins(Value.RUN_STATE_RUN_TYPE, "run_state,run_type");

    public static final PayrollRunsRetrieveRequestShowEnumOrigins RUN_STATE =
            new PayrollRunsRetrieveRequestShowEnumOrigins(Value.RUN_STATE, "run_state");

    private final Value value;

    private final String string;

    PayrollRunsRetrieveRequestShowEnumOrigins(Value value, String string) {
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
                || (other instanceof PayrollRunsRetrieveRequestShowEnumOrigins
                        && this.string.equals(((PayrollRunsRetrieveRequestShowEnumOrigins) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case RUN_TYPE:
                return visitor.visitRunType();
            case RUN_STATE_RUN_TYPE:
                return visitor.visitRunStateRunType();
            case RUN_STATE:
                return visitor.visitRunState();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PayrollRunsRetrieveRequestShowEnumOrigins valueOf(String value) {
        switch (value) {
            case "run_type":
                return RUN_TYPE;
            case "run_state,run_type":
                return RUN_STATE_RUN_TYPE;
            case "run_state":
                return RUN_STATE;
            default:
                return new PayrollRunsRetrieveRequestShowEnumOrigins(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        RUN_STATE,

        RUN_STATE_RUN_TYPE,

        RUN_TYPE,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitRunState();

        T visitRunStateRunType();

        T visitRunType();

        T visitUnknown(String unknownType);
    }
}

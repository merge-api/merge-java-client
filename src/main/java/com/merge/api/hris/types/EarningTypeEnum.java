/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class EarningTypeEnum {
    public static final EarningTypeEnum SALARY = new EarningTypeEnum(Value.SALARY, "SALARY");

    public static final EarningTypeEnum OVERTIME = new EarningTypeEnum(Value.OVERTIME, "OVERTIME");

    public static final EarningTypeEnum REIMBURSEMENT = new EarningTypeEnum(Value.REIMBURSEMENT, "REIMBURSEMENT");

    public static final EarningTypeEnum BONUS = new EarningTypeEnum(Value.BONUS, "BONUS");

    private final Value value;

    private final String string;

    EarningTypeEnum(Value value, String string) {
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
                || (other instanceof EarningTypeEnum && this.string.equals(((EarningTypeEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case SALARY:
                return visitor.visitSalary();
            case OVERTIME:
                return visitor.visitOvertime();
            case REIMBURSEMENT:
                return visitor.visitReimbursement();
            case BONUS:
                return visitor.visitBonus();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EarningTypeEnum valueOf(String value) {
        switch (value) {
            case "SALARY":
                return SALARY;
            case "OVERTIME":
                return OVERTIME;
            case "REIMBURSEMENT":
                return REIMBURSEMENT;
            case "BONUS":
                return BONUS;
            default:
                return new EarningTypeEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        SALARY,

        REIMBURSEMENT,

        OVERTIME,

        BONUS,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitSalary();

        T visitReimbursement();

        T visitOvertime();

        T visitBonus();

        T visitUnknown(String unknownType);
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class GroupTypeEnum {
    public static final GroupTypeEnum GROUP = new GroupTypeEnum(Value.GROUP, "GROUP");

    public static final GroupTypeEnum COST_CENTER = new GroupTypeEnum(Value.COST_CENTER, "COST_CENTER");

    public static final GroupTypeEnum BUSINESS_UNIT = new GroupTypeEnum(Value.BUSINESS_UNIT, "BUSINESS_UNIT");

    public static final GroupTypeEnum TEAM = new GroupTypeEnum(Value.TEAM, "TEAM");

    public static final GroupTypeEnum DEPARTMENT = new GroupTypeEnum(Value.DEPARTMENT, "DEPARTMENT");

    private final Value value;

    private final String string;

    GroupTypeEnum(Value value, String string) {
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
                || (other instanceof GroupTypeEnum && this.string.equals(((GroupTypeEnum) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case GROUP:
                return visitor.visitGroup();
            case COST_CENTER:
                return visitor.visitCostCenter();
            case BUSINESS_UNIT:
                return visitor.visitBusinessUnit();
            case TEAM:
                return visitor.visitTeam();
            case DEPARTMENT:
                return visitor.visitDepartment();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static GroupTypeEnum valueOf(String value) {
        switch (value) {
            case "GROUP":
                return GROUP;
            case "COST_CENTER":
                return COST_CENTER;
            case "BUSINESS_UNIT":
                return BUSINESS_UNIT;
            case "TEAM":
                return TEAM;
            case "DEPARTMENT":
                return DEPARTMENT;
            default:
                return new GroupTypeEnum(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        TEAM,

        DEPARTMENT,

        COST_CENTER,

        BUSINESS_UNIT,

        GROUP,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitTeam();

        T visitDepartment();

        T visitCostCenter();

        T visitBusinessUnit();

        T visitGroup();

        T visitUnknown(String unknownType);
    }
}

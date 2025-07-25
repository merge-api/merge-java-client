/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.hris.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class EmployeesListRequestExpandItem {
    public static final EmployeesListRequestExpandItem EMPLOYMENTS =
            new EmployeesListRequestExpandItem(Value.EMPLOYMENTS, "employments");

    public static final EmployeesListRequestExpandItem HOME_LOCATION =
            new EmployeesListRequestExpandItem(Value.HOME_LOCATION, "home_location");

    public static final EmployeesListRequestExpandItem PAY_GROUP =
            new EmployeesListRequestExpandItem(Value.PAY_GROUP, "pay_group");

    public static final EmployeesListRequestExpandItem MANAGER =
            new EmployeesListRequestExpandItem(Value.MANAGER, "manager");

    public static final EmployeesListRequestExpandItem WORK_LOCATION =
            new EmployeesListRequestExpandItem(Value.WORK_LOCATION, "work_location");

    public static final EmployeesListRequestExpandItem COMPANY =
            new EmployeesListRequestExpandItem(Value.COMPANY, "company");

    public static final EmployeesListRequestExpandItem GROUPS =
            new EmployeesListRequestExpandItem(Value.GROUPS, "groups");

    public static final EmployeesListRequestExpandItem TEAM = new EmployeesListRequestExpandItem(Value.TEAM, "team");

    private final Value value;

    private final String string;

    EmployeesListRequestExpandItem(Value value, String string) {
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
                || (other instanceof EmployeesListRequestExpandItem
                        && this.string.equals(((EmployeesListRequestExpandItem) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case EMPLOYMENTS:
                return visitor.visitEmployments();
            case HOME_LOCATION:
                return visitor.visitHomeLocation();
            case PAY_GROUP:
                return visitor.visitPayGroup();
            case MANAGER:
                return visitor.visitManager();
            case WORK_LOCATION:
                return visitor.visitWorkLocation();
            case COMPANY:
                return visitor.visitCompany();
            case GROUPS:
                return visitor.visitGroups();
            case TEAM:
                return visitor.visitTeam();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EmployeesListRequestExpandItem valueOf(String value) {
        switch (value) {
            case "employments":
                return EMPLOYMENTS;
            case "home_location":
                return HOME_LOCATION;
            case "pay_group":
                return PAY_GROUP;
            case "manager":
                return MANAGER;
            case "work_location":
                return WORK_LOCATION;
            case "company":
                return COMPANY;
            case "groups":
                return GROUPS;
            case "team":
                return TEAM;
            default:
                return new EmployeesListRequestExpandItem(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        COMPANY,

        EMPLOYMENTS,

        GROUPS,

        HOME_LOCATION,

        MANAGER,

        PAY_GROUP,

        TEAM,

        WORK_LOCATION,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitCompany();

        T visitEmployments();

        T visitGroups();

        T visitHomeLocation();

        T visitManager();

        T visitPayGroup();

        T visitTeam();

        T visitWorkLocation();

        T visitUnknown(String unknownType);
    }
}

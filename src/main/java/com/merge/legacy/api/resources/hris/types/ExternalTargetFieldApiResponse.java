/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.hris.types;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.legacy.api.core.ObjectMappers;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ExternalTargetFieldApiResponse.Builder.class)
public final class ExternalTargetFieldApiResponse {
    private final Optional<List<ExternalTargetFieldApi>> benefit;

    private final Optional<List<ExternalTargetFieldApi>> employerBenefit;

    private final Optional<List<ExternalTargetFieldApi>> company;

    private final Optional<List<ExternalTargetFieldApi>> employeePayrollRun;

    private final Optional<List<ExternalTargetFieldApi>> employee;

    private final Optional<List<ExternalTargetFieldApi>> employment;

    private final Optional<List<ExternalTargetFieldApi>> location;

    private final Optional<List<ExternalTargetFieldApi>> payrollRun;

    private final Optional<List<ExternalTargetFieldApi>> team;

    private final Optional<List<ExternalTargetFieldApi>> timeOff;

    private final Optional<List<ExternalTargetFieldApi>> timeOffBalance;

    private final Optional<List<ExternalTargetFieldApi>> bankInfo;

    private final Optional<List<ExternalTargetFieldApi>> payGroup;

    private final Optional<List<ExternalTargetFieldApi>> group;

    private final Optional<List<ExternalTargetFieldApi>> dependent;

    private final Optional<List<ExternalTargetFieldApi>> timesheetEntry;

    private final Map<String, Object> additionalProperties;

    private ExternalTargetFieldApiResponse(
            Optional<List<ExternalTargetFieldApi>> benefit,
            Optional<List<ExternalTargetFieldApi>> employerBenefit,
            Optional<List<ExternalTargetFieldApi>> company,
            Optional<List<ExternalTargetFieldApi>> employeePayrollRun,
            Optional<List<ExternalTargetFieldApi>> employee,
            Optional<List<ExternalTargetFieldApi>> employment,
            Optional<List<ExternalTargetFieldApi>> location,
            Optional<List<ExternalTargetFieldApi>> payrollRun,
            Optional<List<ExternalTargetFieldApi>> team,
            Optional<List<ExternalTargetFieldApi>> timeOff,
            Optional<List<ExternalTargetFieldApi>> timeOffBalance,
            Optional<List<ExternalTargetFieldApi>> bankInfo,
            Optional<List<ExternalTargetFieldApi>> payGroup,
            Optional<List<ExternalTargetFieldApi>> group,
            Optional<List<ExternalTargetFieldApi>> dependent,
            Optional<List<ExternalTargetFieldApi>> timesheetEntry,
            Map<String, Object> additionalProperties) {
        this.benefit = benefit;
        this.employerBenefit = employerBenefit;
        this.company = company;
        this.employeePayrollRun = employeePayrollRun;
        this.employee = employee;
        this.employment = employment;
        this.location = location;
        this.payrollRun = payrollRun;
        this.team = team;
        this.timeOff = timeOff;
        this.timeOffBalance = timeOffBalance;
        this.bankInfo = bankInfo;
        this.payGroup = payGroup;
        this.group = group;
        this.dependent = dependent;
        this.timesheetEntry = timesheetEntry;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("Benefit")
    public Optional<List<ExternalTargetFieldApi>> getBenefit() {
        return benefit;
    }

    @JsonProperty("EmployerBenefit")
    public Optional<List<ExternalTargetFieldApi>> getEmployerBenefit() {
        return employerBenefit;
    }

    @JsonProperty("Company")
    public Optional<List<ExternalTargetFieldApi>> getCompany() {
        return company;
    }

    @JsonProperty("EmployeePayrollRun")
    public Optional<List<ExternalTargetFieldApi>> getEmployeePayrollRun() {
        return employeePayrollRun;
    }

    @JsonProperty("Employee")
    public Optional<List<ExternalTargetFieldApi>> getEmployee() {
        return employee;
    }

    @JsonProperty("Employment")
    public Optional<List<ExternalTargetFieldApi>> getEmployment() {
        return employment;
    }

    @JsonProperty("Location")
    public Optional<List<ExternalTargetFieldApi>> getLocation() {
        return location;
    }

    @JsonProperty("PayrollRun")
    public Optional<List<ExternalTargetFieldApi>> getPayrollRun() {
        return payrollRun;
    }

    @JsonProperty("Team")
    public Optional<List<ExternalTargetFieldApi>> getTeam() {
        return team;
    }

    @JsonProperty("TimeOff")
    public Optional<List<ExternalTargetFieldApi>> getTimeOff() {
        return timeOff;
    }

    @JsonProperty("TimeOffBalance")
    public Optional<List<ExternalTargetFieldApi>> getTimeOffBalance() {
        return timeOffBalance;
    }

    @JsonProperty("BankInfo")
    public Optional<List<ExternalTargetFieldApi>> getBankInfo() {
        return bankInfo;
    }

    @JsonProperty("PayGroup")
    public Optional<List<ExternalTargetFieldApi>> getPayGroup() {
        return payGroup;
    }

    @JsonProperty("Group")
    public Optional<List<ExternalTargetFieldApi>> getGroup() {
        return group;
    }

    @JsonProperty("Dependent")
    public Optional<List<ExternalTargetFieldApi>> getDependent() {
        return dependent;
    }

    @JsonProperty("TimesheetEntry")
    public Optional<List<ExternalTargetFieldApi>> getTimesheetEntry() {
        return timesheetEntry;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExternalTargetFieldApiResponse && equalTo((ExternalTargetFieldApiResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ExternalTargetFieldApiResponse other) {
        return benefit.equals(other.benefit)
                && employerBenefit.equals(other.employerBenefit)
                && company.equals(other.company)
                && employeePayrollRun.equals(other.employeePayrollRun)
                && employee.equals(other.employee)
                && employment.equals(other.employment)
                && location.equals(other.location)
                && payrollRun.equals(other.payrollRun)
                && team.equals(other.team)
                && timeOff.equals(other.timeOff)
                && timeOffBalance.equals(other.timeOffBalance)
                && bankInfo.equals(other.bankInfo)
                && payGroup.equals(other.payGroup)
                && group.equals(other.group)
                && dependent.equals(other.dependent)
                && timesheetEntry.equals(other.timesheetEntry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.benefit,
                this.employerBenefit,
                this.company,
                this.employeePayrollRun,
                this.employee,
                this.employment,
                this.location,
                this.payrollRun,
                this.team,
                this.timeOff,
                this.timeOffBalance,
                this.bankInfo,
                this.payGroup,
                this.group,
                this.dependent,
                this.timesheetEntry);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<ExternalTargetFieldApi>> benefit = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> employerBenefit = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> company = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> employeePayrollRun = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> employee = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> employment = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> location = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> payrollRun = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> team = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> timeOff = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> timeOffBalance = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> bankInfo = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> payGroup = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> group = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> dependent = Optional.empty();

        private Optional<List<ExternalTargetFieldApi>> timesheetEntry = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ExternalTargetFieldApiResponse other) {
            benefit(other.getBenefit());
            employerBenefit(other.getEmployerBenefit());
            company(other.getCompany());
            employeePayrollRun(other.getEmployeePayrollRun());
            employee(other.getEmployee());
            employment(other.getEmployment());
            location(other.getLocation());
            payrollRun(other.getPayrollRun());
            team(other.getTeam());
            timeOff(other.getTimeOff());
            timeOffBalance(other.getTimeOffBalance());
            bankInfo(other.getBankInfo());
            payGroup(other.getPayGroup());
            group(other.getGroup());
            dependent(other.getDependent());
            timesheetEntry(other.getTimesheetEntry());
            return this;
        }

        @JsonSetter(value = "Benefit", nulls = Nulls.SKIP)
        public Builder benefit(Optional<List<ExternalTargetFieldApi>> benefit) {
            this.benefit = benefit;
            return this;
        }

        public Builder benefit(List<ExternalTargetFieldApi> benefit) {
            this.benefit = Optional.ofNullable(benefit);
            return this;
        }

        @JsonSetter(value = "EmployerBenefit", nulls = Nulls.SKIP)
        public Builder employerBenefit(Optional<List<ExternalTargetFieldApi>> employerBenefit) {
            this.employerBenefit = employerBenefit;
            return this;
        }

        public Builder employerBenefit(List<ExternalTargetFieldApi> employerBenefit) {
            this.employerBenefit = Optional.ofNullable(employerBenefit);
            return this;
        }

        @JsonSetter(value = "Company", nulls = Nulls.SKIP)
        public Builder company(Optional<List<ExternalTargetFieldApi>> company) {
            this.company = company;
            return this;
        }

        public Builder company(List<ExternalTargetFieldApi> company) {
            this.company = Optional.ofNullable(company);
            return this;
        }

        @JsonSetter(value = "EmployeePayrollRun", nulls = Nulls.SKIP)
        public Builder employeePayrollRun(Optional<List<ExternalTargetFieldApi>> employeePayrollRun) {
            this.employeePayrollRun = employeePayrollRun;
            return this;
        }

        public Builder employeePayrollRun(List<ExternalTargetFieldApi> employeePayrollRun) {
            this.employeePayrollRun = Optional.ofNullable(employeePayrollRun);
            return this;
        }

        @JsonSetter(value = "Employee", nulls = Nulls.SKIP)
        public Builder employee(Optional<List<ExternalTargetFieldApi>> employee) {
            this.employee = employee;
            return this;
        }

        public Builder employee(List<ExternalTargetFieldApi> employee) {
            this.employee = Optional.ofNullable(employee);
            return this;
        }

        @JsonSetter(value = "Employment", nulls = Nulls.SKIP)
        public Builder employment(Optional<List<ExternalTargetFieldApi>> employment) {
            this.employment = employment;
            return this;
        }

        public Builder employment(List<ExternalTargetFieldApi> employment) {
            this.employment = Optional.ofNullable(employment);
            return this;
        }

        @JsonSetter(value = "Location", nulls = Nulls.SKIP)
        public Builder location(Optional<List<ExternalTargetFieldApi>> location) {
            this.location = location;
            return this;
        }

        public Builder location(List<ExternalTargetFieldApi> location) {
            this.location = Optional.ofNullable(location);
            return this;
        }

        @JsonSetter(value = "PayrollRun", nulls = Nulls.SKIP)
        public Builder payrollRun(Optional<List<ExternalTargetFieldApi>> payrollRun) {
            this.payrollRun = payrollRun;
            return this;
        }

        public Builder payrollRun(List<ExternalTargetFieldApi> payrollRun) {
            this.payrollRun = Optional.ofNullable(payrollRun);
            return this;
        }

        @JsonSetter(value = "Team", nulls = Nulls.SKIP)
        public Builder team(Optional<List<ExternalTargetFieldApi>> team) {
            this.team = team;
            return this;
        }

        public Builder team(List<ExternalTargetFieldApi> team) {
            this.team = Optional.ofNullable(team);
            return this;
        }

        @JsonSetter(value = "TimeOff", nulls = Nulls.SKIP)
        public Builder timeOff(Optional<List<ExternalTargetFieldApi>> timeOff) {
            this.timeOff = timeOff;
            return this;
        }

        public Builder timeOff(List<ExternalTargetFieldApi> timeOff) {
            this.timeOff = Optional.ofNullable(timeOff);
            return this;
        }

        @JsonSetter(value = "TimeOffBalance", nulls = Nulls.SKIP)
        public Builder timeOffBalance(Optional<List<ExternalTargetFieldApi>> timeOffBalance) {
            this.timeOffBalance = timeOffBalance;
            return this;
        }

        public Builder timeOffBalance(List<ExternalTargetFieldApi> timeOffBalance) {
            this.timeOffBalance = Optional.ofNullable(timeOffBalance);
            return this;
        }

        @JsonSetter(value = "BankInfo", nulls = Nulls.SKIP)
        public Builder bankInfo(Optional<List<ExternalTargetFieldApi>> bankInfo) {
            this.bankInfo = bankInfo;
            return this;
        }

        public Builder bankInfo(List<ExternalTargetFieldApi> bankInfo) {
            this.bankInfo = Optional.ofNullable(bankInfo);
            return this;
        }

        @JsonSetter(value = "PayGroup", nulls = Nulls.SKIP)
        public Builder payGroup(Optional<List<ExternalTargetFieldApi>> payGroup) {
            this.payGroup = payGroup;
            return this;
        }

        public Builder payGroup(List<ExternalTargetFieldApi> payGroup) {
            this.payGroup = Optional.ofNullable(payGroup);
            return this;
        }

        @JsonSetter(value = "Group", nulls = Nulls.SKIP)
        public Builder group(Optional<List<ExternalTargetFieldApi>> group) {
            this.group = group;
            return this;
        }

        public Builder group(List<ExternalTargetFieldApi> group) {
            this.group = Optional.ofNullable(group);
            return this;
        }

        @JsonSetter(value = "Dependent", nulls = Nulls.SKIP)
        public Builder dependent(Optional<List<ExternalTargetFieldApi>> dependent) {
            this.dependent = dependent;
            return this;
        }

        public Builder dependent(List<ExternalTargetFieldApi> dependent) {
            this.dependent = Optional.ofNullable(dependent);
            return this;
        }

        @JsonSetter(value = "TimesheetEntry", nulls = Nulls.SKIP)
        public Builder timesheetEntry(Optional<List<ExternalTargetFieldApi>> timesheetEntry) {
            this.timesheetEntry = timesheetEntry;
            return this;
        }

        public Builder timesheetEntry(List<ExternalTargetFieldApi> timesheetEntry) {
            this.timesheetEntry = Optional.ofNullable(timesheetEntry);
            return this;
        }

        public ExternalTargetFieldApiResponse build() {
            return new ExternalTargetFieldApiResponse(
                    benefit,
                    employerBenefit,
                    company,
                    employeePayrollRun,
                    employee,
                    employment,
                    location,
                    payrollRun,
                    team,
                    timeOff,
                    timeOffBalance,
                    bankInfo,
                    payGroup,
                    group,
                    dependent,
                    timesheetEntry,
                    additionalProperties);
        }
    }
}

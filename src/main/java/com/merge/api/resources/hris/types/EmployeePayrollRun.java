package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EmployeePayrollRun.Builder.class)
public final class EmployeePayrollRun {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<EmployeePayrollRunEmployee> employee;

    private final Optional<EmployeePayrollRunPayrollRun> payrollRun;

    private final Optional<Double> grossPay;

    private final Optional<Double> netPay;

    private final Optional<OffsetDateTime> startDate;

    private final Optional<OffsetDateTime> endDate;

    private final Optional<OffsetDateTime> checkDate;

    private final Optional<List<Earning>> earnings;

    private final Optional<List<Deduction>> deductions;

    private final Optional<List<Tax>> taxes;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private EmployeePayrollRun(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<EmployeePayrollRunEmployee> employee,
            Optional<EmployeePayrollRunPayrollRun> payrollRun,
            Optional<Double> grossPay,
            Optional<Double> netPay,
            Optional<OffsetDateTime> startDate,
            Optional<OffsetDateTime> endDate,
            Optional<OffsetDateTime> checkDate,
            Optional<List<Earning>> earnings,
            Optional<List<Deduction>> deductions,
            Optional<List<Tax>> taxes,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.employee = employee;
        this.payrollRun = payrollRun;
        this.grossPay = grossPay;
        this.netPay = netPay;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkDate = checkDate;
        this.earnings = earnings;
        this.deductions = deductions;
        this.taxes = taxes;
        this.remoteWasDeleted = remoteWasDeleted;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return The employee whose payroll is being run.
     */
    @JsonProperty("employee")
    public Optional<EmployeePayrollRunEmployee> getEmployee() {
        return employee;
    }

    /**
     * @return The payroll being run.
     */
    @JsonProperty("payroll_run")
    public Optional<EmployeePayrollRunPayrollRun> getPayrollRun() {
        return payrollRun;
    }

    /**
     * @return The total earnings throughout a given period for an employee before any deductions are made.
     */
    @JsonProperty("gross_pay")
    public Optional<Double> getGrossPay() {
        return grossPay;
    }

    /**
     * @return The take-home pay throughout a given period for an employee after deductions are made.
     */
    @JsonProperty("net_pay")
    public Optional<Double> getNetPay() {
        return netPay;
    }

    /**
     * @return The day and time the payroll run started.
     */
    @JsonProperty("start_date")
    public Optional<OffsetDateTime> getStartDate() {
        return startDate;
    }

    /**
     * @return The day and time the payroll run ended.
     */
    @JsonProperty("end_date")
    public Optional<OffsetDateTime> getEndDate() {
        return endDate;
    }

    /**
     * @return The day and time the payroll run was checked.
     */
    @JsonProperty("check_date")
    public Optional<OffsetDateTime> getCheckDate() {
        return checkDate;
    }

    @JsonProperty("earnings")
    public Optional<List<Earning>> getEarnings() {
        return earnings;
    }

    @JsonProperty("deductions")
    public Optional<List<Deduction>> getDeductions() {
        return deductions;
    }

    @JsonProperty("taxes")
    public Optional<List<Tax>> getTaxes() {
        return taxes;
    }

    /**
     * @return Indicates whether or not this object has been deleted by third party webhooks.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("field_mappings")
    public Optional<Map<String, JsonNode>> getFieldMappings() {
        return fieldMappings;
    }

    @JsonProperty("remote_data")
    public Optional<List<RemoteData>> getRemoteData() {
        return remoteData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmployeePayrollRun && equalTo((EmployeePayrollRun) other);
    }

    private boolean equalTo(EmployeePayrollRun other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && employee.equals(other.employee)
                && payrollRun.equals(other.payrollRun)
                && grossPay.equals(other.grossPay)
                && netPay.equals(other.netPay)
                && startDate.equals(other.startDate)
                && endDate.equals(other.endDate)
                && checkDate.equals(other.checkDate)
                && earnings.equals(other.earnings)
                && deductions.equals(other.deductions)
                && taxes.equals(other.taxes)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.employee,
                this.payrollRun,
                this.grossPay,
                this.netPay,
                this.startDate,
                this.endDate,
                this.checkDate,
                this.earnings,
                this.deductions,
                this.taxes,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<EmployeePayrollRunEmployee> employee = Optional.empty();

        private Optional<EmployeePayrollRunPayrollRun> payrollRun = Optional.empty();

        private Optional<Double> grossPay = Optional.empty();

        private Optional<Double> netPay = Optional.empty();

        private Optional<OffsetDateTime> startDate = Optional.empty();

        private Optional<OffsetDateTime> endDate = Optional.empty();

        private Optional<OffsetDateTime> checkDate = Optional.empty();

        private Optional<List<Earning>> earnings = Optional.empty();

        private Optional<List<Deduction>> deductions = Optional.empty();

        private Optional<List<Tax>> taxes = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(EmployeePayrollRun other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            employee(other.getEmployee());
            payrollRun(other.getPayrollRun());
            grossPay(other.getGrossPay());
            netPay(other.getNetPay());
            startDate(other.getStartDate());
            endDate(other.getEndDate());
            checkDate(other.getCheckDate());
            earnings(other.getEarnings());
            deductions(other.getDeductions());
            taxes(other.getTaxes());
            remoteWasDeleted(other.getRemoteWasDeleted());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.of(remoteId);
            return this;
        }

        @JsonSetter(value = "employee", nulls = Nulls.SKIP)
        public Builder employee(Optional<EmployeePayrollRunEmployee> employee) {
            this.employee = employee;
            return this;
        }

        public Builder employee(EmployeePayrollRunEmployee employee) {
            this.employee = Optional.of(employee);
            return this;
        }

        @JsonSetter(value = "payroll_run", nulls = Nulls.SKIP)
        public Builder payrollRun(Optional<EmployeePayrollRunPayrollRun> payrollRun) {
            this.payrollRun = payrollRun;
            return this;
        }

        public Builder payrollRun(EmployeePayrollRunPayrollRun payrollRun) {
            this.payrollRun = Optional.of(payrollRun);
            return this;
        }

        @JsonSetter(value = "gross_pay", nulls = Nulls.SKIP)
        public Builder grossPay(Optional<Double> grossPay) {
            this.grossPay = grossPay;
            return this;
        }

        public Builder grossPay(Double grossPay) {
            this.grossPay = Optional.of(grossPay);
            return this;
        }

        @JsonSetter(value = "net_pay", nulls = Nulls.SKIP)
        public Builder netPay(Optional<Double> netPay) {
            this.netPay = netPay;
            return this;
        }

        public Builder netPay(Double netPay) {
            this.netPay = Optional.of(netPay);
            return this;
        }

        @JsonSetter(value = "start_date", nulls = Nulls.SKIP)
        public Builder startDate(Optional<OffsetDateTime> startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder startDate(OffsetDateTime startDate) {
            this.startDate = Optional.of(startDate);
            return this;
        }

        @JsonSetter(value = "end_date", nulls = Nulls.SKIP)
        public Builder endDate(Optional<OffsetDateTime> endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder endDate(OffsetDateTime endDate) {
            this.endDate = Optional.of(endDate);
            return this;
        }

        @JsonSetter(value = "check_date", nulls = Nulls.SKIP)
        public Builder checkDate(Optional<OffsetDateTime> checkDate) {
            this.checkDate = checkDate;
            return this;
        }

        public Builder checkDate(OffsetDateTime checkDate) {
            this.checkDate = Optional.of(checkDate);
            return this;
        }

        @JsonSetter(value = "earnings", nulls = Nulls.SKIP)
        public Builder earnings(Optional<List<Earning>> earnings) {
            this.earnings = earnings;
            return this;
        }

        public Builder earnings(List<Earning> earnings) {
            this.earnings = Optional.of(earnings);
            return this;
        }

        @JsonSetter(value = "deductions", nulls = Nulls.SKIP)
        public Builder deductions(Optional<List<Deduction>> deductions) {
            this.deductions = deductions;
            return this;
        }

        public Builder deductions(List<Deduction> deductions) {
            this.deductions = Optional.of(deductions);
            return this;
        }

        @JsonSetter(value = "taxes", nulls = Nulls.SKIP)
        public Builder taxes(Optional<List<Tax>> taxes) {
            this.taxes = taxes;
            return this;
        }

        public Builder taxes(List<Tax> taxes) {
            this.taxes = Optional.of(taxes);
            return this;
        }

        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.of(remoteWasDeleted);
            return this;
        }

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.of(modifiedAt);
            return this;
        }

        @JsonSetter(value = "field_mappings", nulls = Nulls.SKIP)
        public Builder fieldMappings(Optional<Map<String, JsonNode>> fieldMappings) {
            this.fieldMappings = fieldMappings;
            return this;
        }

        public Builder fieldMappings(Map<String, JsonNode> fieldMappings) {
            this.fieldMappings = Optional.of(fieldMappings);
            return this;
        }

        @JsonSetter(value = "remote_data", nulls = Nulls.SKIP)
        public Builder remoteData(Optional<List<RemoteData>> remoteData) {
            this.remoteData = remoteData;
            return this;
        }

        public Builder remoteData(List<RemoteData> remoteData) {
            this.remoteData = Optional.of(remoteData);
            return this;
        }

        public EmployeePayrollRun build() {
            return new EmployeePayrollRun(
                    id,
                    remoteId,
                    employee,
                    payrollRun,
                    grossPay,
                    netPay,
                    startDate,
                    endDate,
                    checkDate,
                    earnings,
                    deductions,
                    taxes,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

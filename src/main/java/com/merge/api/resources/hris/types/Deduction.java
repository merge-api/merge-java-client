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
@JsonDeserialize(builder = Deduction.Builder.class)
public final class Deduction {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> employeePayrollRun;

    private final Optional<String> name;

    private final Optional<Double> employeeDeduction;

    private final Optional<Double> companyDeduction;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Deduction(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> employeePayrollRun,
            Optional<String> name,
            Optional<Double> employeeDeduction,
            Optional<Double> companyDeduction,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.employeePayrollRun = employeePayrollRun;
        this.name = name;
        this.employeeDeduction = employeeDeduction;
        this.companyDeduction = companyDeduction;
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

    @JsonProperty("employee_payroll_run")
    public Optional<String> getEmployeePayrollRun() {
        return employeePayrollRun;
    }

    /**
     * @return The deduction's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The amount of money that is withheld from an employee's gross pay by the employee.
     */
    @JsonProperty("employee_deduction")
    public Optional<Double> getEmployeeDeduction() {
        return employeeDeduction;
    }

    /**
     * @return The amount of money that is withheld on behalf of an employee by the company.
     */
    @JsonProperty("company_deduction")
    public Optional<Double> getCompanyDeduction() {
        return companyDeduction;
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
        return other instanceof Deduction && equalTo((Deduction) other);
    }

    private boolean equalTo(Deduction other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && employeePayrollRun.equals(other.employeePayrollRun)
                && name.equals(other.name)
                && employeeDeduction.equals(other.employeeDeduction)
                && companyDeduction.equals(other.companyDeduction)
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
                this.employeePayrollRun,
                this.name,
                this.employeeDeduction,
                this.companyDeduction,
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

        private Optional<String> employeePayrollRun = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<Double> employeeDeduction = Optional.empty();

        private Optional<Double> companyDeduction = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Deduction other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            employeePayrollRun(other.getEmployeePayrollRun());
            name(other.getName());
            employeeDeduction(other.getEmployeeDeduction());
            companyDeduction(other.getCompanyDeduction());
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

        @JsonSetter(value = "employee_payroll_run", nulls = Nulls.SKIP)
        public Builder employeePayrollRun(Optional<String> employeePayrollRun) {
            this.employeePayrollRun = employeePayrollRun;
            return this;
        }

        public Builder employeePayrollRun(String employeePayrollRun) {
            this.employeePayrollRun = Optional.of(employeePayrollRun);
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "employee_deduction", nulls = Nulls.SKIP)
        public Builder employeeDeduction(Optional<Double> employeeDeduction) {
            this.employeeDeduction = employeeDeduction;
            return this;
        }

        public Builder employeeDeduction(Double employeeDeduction) {
            this.employeeDeduction = Optional.of(employeeDeduction);
            return this;
        }

        @JsonSetter(value = "company_deduction", nulls = Nulls.SKIP)
        public Builder companyDeduction(Optional<Double> companyDeduction) {
            this.companyDeduction = companyDeduction;
            return this;
        }

        public Builder companyDeduction(Double companyDeduction) {
            this.companyDeduction = Optional.of(companyDeduction);
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

        public Deduction build() {
            return new Deduction(
                    id,
                    remoteId,
                    employeePayrollRun,
                    name,
                    employeeDeduction,
                    companyDeduction,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

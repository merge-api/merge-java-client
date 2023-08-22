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
@JsonDeserialize(builder = Earning.Builder.class)
public final class Earning {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> employeePayrollRun;

    private final Optional<Double> amount;

    private final Optional<EarningType> type;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Earning(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> employeePayrollRun,
            Optional<Double> amount,
            Optional<EarningType> type,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.employeePayrollRun = employeePayrollRun;
        this.amount = amount;
        this.type = type;
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
     * @return The amount earned.
     */
    @JsonProperty("amount")
    public Optional<Double> getAmount() {
        return amount;
    }

    /**
     * @return The type of earning.
     * <ul>
     * <li><code>SALARY</code> - SALARY</li>
     * <li><code>REIMBURSEMENT</code> - REIMBURSEMENT</li>
     * <li><code>OVERTIME</code> - OVERTIME</li>
     * <li><code>BONUS</code> - BONUS</li>
     * </ul>
     */
    @JsonProperty("type")
    public Optional<EarningType> getType() {
        return type;
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
        return other instanceof Earning && equalTo((Earning) other);
    }

    private boolean equalTo(Earning other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && employeePayrollRun.equals(other.employeePayrollRun)
                && amount.equals(other.amount)
                && type.equals(other.type)
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
                this.amount,
                this.type,
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

        private Optional<Double> amount = Optional.empty();

        private Optional<EarningType> type = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Earning other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            employeePayrollRun(other.getEmployeePayrollRun());
            amount(other.getAmount());
            type(other.getType());
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

        @JsonSetter(value = "amount", nulls = Nulls.SKIP)
        public Builder amount(Optional<Double> amount) {
            this.amount = amount;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = Optional.of(amount);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<EarningType> type) {
            this.type = type;
            return this;
        }

        public Builder type(EarningType type) {
            this.type = Optional.of(type);
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

        public Earning build() {
            return new Earning(
                    id,
                    remoteId,
                    employeePayrollRun,
                    amount,
                    type,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

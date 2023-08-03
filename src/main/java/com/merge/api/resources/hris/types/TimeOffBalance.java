package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TimeOffBalance.Builder.class)
public final class TimeOffBalance {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> employee;

    private final Optional<Double> balance;

    private final Optional<Double> used;

    private final Optional<TimeOffBalancePolicyType> policyType;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private TimeOffBalance(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> employee,
            Optional<Double> balance,
            Optional<Double> used,
            Optional<TimeOffBalancePolicyType> policyType,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.employee = employee;
        this.balance = balance;
        this.used = used;
        this.policyType = policyType;
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
     * @return The employee the balance belongs to.
     */
    @JsonProperty("employee")
    public Optional<String> getEmployee() {
        return employee;
    }

    /**
     * @return The current remaining PTO balance, always measured in terms of hours.
     */
    @JsonProperty("balance")
    public Optional<Double> getBalance() {
        return balance;
    }

    /**
     * @return The amount of PTO used in terms of hours.
     */
    @JsonProperty("used")
    public Optional<Double> getUsed() {
        return used;
    }

    /**
     * @return The policy type of this time off balance.
     * <ul>
     * <li><code>VACATION</code> - VACATION</li>
     * <li><code>SICK</code> - SICK</li>
     * <li><code>PERSONAL</code> - PERSONAL</li>
     * <li><code>JURY_DUTY</code> - JURY_DUTY</li>
     * <li><code>VOLUNTEER</code> - VOLUNTEER</li>
     * <li><code>BEREAVEMENT</code> - BEREAVEMENT</li>
     * </ul>
     */
    @JsonProperty("policy_type")
    public Optional<TimeOffBalancePolicyType> getPolicyType() {
        return policyType;
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
        return other instanceof TimeOffBalance && equalTo((TimeOffBalance) other);
    }

    private boolean equalTo(TimeOffBalance other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && employee.equals(other.employee)
                && balance.equals(other.balance)
                && used.equals(other.used)
                && policyType.equals(other.policyType)
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
                this.balance,
                this.used,
                this.policyType,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "TimeOffBalance{" + "id: " + id + ", remoteId: " + remoteId + ", employee: " + employee + ", balance: "
                + balance + ", used: " + used + ", policyType: " + policyType + ", remoteWasDeleted: "
                + remoteWasDeleted + ", modifiedAt: " + modifiedAt + ", fieldMappings: " + fieldMappings
                + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> employee = Optional.empty();

        private Optional<Double> balance = Optional.empty();

        private Optional<Double> used = Optional.empty();

        private Optional<TimeOffBalancePolicyType> policyType = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(TimeOffBalance other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            employee(other.getEmployee());
            balance(other.getBalance());
            used(other.getUsed());
            policyType(other.getPolicyType());
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
        public Builder employee(Optional<String> employee) {
            this.employee = employee;
            return this;
        }

        public Builder employee(String employee) {
            this.employee = Optional.of(employee);
            return this;
        }

        @JsonSetter(value = "balance", nulls = Nulls.SKIP)
        public Builder balance(Optional<Double> balance) {
            this.balance = balance;
            return this;
        }

        public Builder balance(Double balance) {
            this.balance = Optional.of(balance);
            return this;
        }

        @JsonSetter(value = "used", nulls = Nulls.SKIP)
        public Builder used(Optional<Double> used) {
            this.used = used;
            return this;
        }

        public Builder used(Double used) {
            this.used = Optional.of(used);
            return this;
        }

        @JsonSetter(value = "policy_type", nulls = Nulls.SKIP)
        public Builder policyType(Optional<TimeOffBalancePolicyType> policyType) {
            this.policyType = policyType;
            return this;
        }

        public Builder policyType(TimeOffBalancePolicyType policyType) {
            this.policyType = Optional.of(policyType);
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

        public TimeOffBalance build() {
            return new TimeOffBalance(
                    id,
                    remoteId,
                    employee,
                    balance,
                    used,
                    policyType,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}
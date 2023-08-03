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
@JsonDeserialize(builder = BankInfo.Builder.class)
public final class BankInfo {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> employee;

    private final Optional<String> accountNumber;

    private final Optional<String> routingNumber;

    private final Optional<String> bankName;

    private final Optional<BankInfoAccountType> accountType;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private BankInfo(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> employee,
            Optional<String> accountNumber,
            Optional<String> routingNumber,
            Optional<String> bankName,
            Optional<BankInfoAccountType> accountType,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.employee = employee;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
        this.bankName = bankName;
        this.accountType = accountType;
        this.remoteCreatedAt = remoteCreatedAt;
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
     * @return The employee with this bank account.
     */
    @JsonProperty("employee")
    public Optional<String> getEmployee() {
        return employee;
    }

    /**
     * @return The account number.
     */
    @JsonProperty("account_number")
    public Optional<String> getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return The routing number.
     */
    @JsonProperty("routing_number")
    public Optional<String> getRoutingNumber() {
        return routingNumber;
    }

    /**
     * @return The bank name.
     */
    @JsonProperty("bank_name")
    public Optional<String> getBankName() {
        return bankName;
    }

    /**
     * @return The bank account type
     * <ul>
     * <li><code>SAVINGS</code> - SAVINGS</li>
     * <li><code>CHECKING</code> - CHECKING</li>
     * </ul>
     */
    @JsonProperty("account_type")
    public Optional<BankInfoAccountType> getAccountType() {
        return accountType;
    }

    /**
     * @return When the matching bank object was created in the third party system.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
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
        return other instanceof BankInfo && equalTo((BankInfo) other);
    }

    private boolean equalTo(BankInfo other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && employee.equals(other.employee)
                && accountNumber.equals(other.accountNumber)
                && routingNumber.equals(other.routingNumber)
                && bankName.equals(other.bankName)
                && accountType.equals(other.accountType)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
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
                this.accountNumber,
                this.routingNumber,
                this.bankName,
                this.accountType,
                this.remoteCreatedAt,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "BankInfo{" + "id: " + id + ", remoteId: " + remoteId + ", employee: " + employee + ", accountNumber: "
                + accountNumber + ", routingNumber: " + routingNumber + ", bankName: " + bankName + ", accountType: "
                + accountType + ", remoteCreatedAt: " + remoteCreatedAt + ", remoteWasDeleted: " + remoteWasDeleted
                + ", modifiedAt: " + modifiedAt + ", fieldMappings: " + fieldMappings + ", remoteData: " + remoteData
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> employee = Optional.empty();

        private Optional<String> accountNumber = Optional.empty();

        private Optional<String> routingNumber = Optional.empty();

        private Optional<String> bankName = Optional.empty();

        private Optional<BankInfoAccountType> accountType = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(BankInfo other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            employee(other.getEmployee());
            accountNumber(other.getAccountNumber());
            routingNumber(other.getRoutingNumber());
            bankName(other.getBankName());
            accountType(other.getAccountType());
            remoteCreatedAt(other.getRemoteCreatedAt());
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

        @JsonSetter(value = "account_number", nulls = Nulls.SKIP)
        public Builder accountNumber(Optional<String> accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = Optional.of(accountNumber);
            return this;
        }

        @JsonSetter(value = "routing_number", nulls = Nulls.SKIP)
        public Builder routingNumber(Optional<String> routingNumber) {
            this.routingNumber = routingNumber;
            return this;
        }

        public Builder routingNumber(String routingNumber) {
            this.routingNumber = Optional.of(routingNumber);
            return this;
        }

        @JsonSetter(value = "bank_name", nulls = Nulls.SKIP)
        public Builder bankName(Optional<String> bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder bankName(String bankName) {
            this.bankName = Optional.of(bankName);
            return this;
        }

        @JsonSetter(value = "account_type", nulls = Nulls.SKIP)
        public Builder accountType(Optional<BankInfoAccountType> accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder accountType(BankInfoAccountType accountType) {
            this.accountType = Optional.of(accountType);
            return this;
        }

        @JsonSetter(value = "remote_created_at", nulls = Nulls.SKIP)
        public Builder remoteCreatedAt(Optional<OffsetDateTime> remoteCreatedAt) {
            this.remoteCreatedAt = remoteCreatedAt;
            return this;
        }

        public Builder remoteCreatedAt(OffsetDateTime remoteCreatedAt) {
            this.remoteCreatedAt = Optional.of(remoteCreatedAt);
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

        public BankInfo build() {
            return new BankInfo(
                    id,
                    remoteId,
                    employee,
                    accountNumber,
                    routingNumber,
                    bankName,
                    accountType,
                    remoteCreatedAt,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

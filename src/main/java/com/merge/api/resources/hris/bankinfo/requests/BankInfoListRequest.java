package com.merge.api.resources.hris.bankinfo.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.hris.bankinfo.types.BankInfoListRequestAccountType;
import com.merge.api.resources.hris.bankinfo.types.BankInfoListRequestOrderBy;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BankInfoListRequest.Builder.class)
public final class BankInfoListRequest {
    private final Optional<BankInfoListRequestAccountType> accountType;

    private final Optional<String> bankName;

    private final Optional<OffsetDateTime> createdAfter;

    private final Optional<OffsetDateTime> createdBefore;

    private final Optional<String> cursor;

    private final Optional<String> employeeId;

    private final Optional<String> expand;

    private final Optional<Boolean> includeDeletedData;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<OffsetDateTime> modifiedAfter;

    private final Optional<OffsetDateTime> modifiedBefore;

    private final Optional<BankInfoListRequestOrderBy> orderBy;

    private final Optional<Integer> pageSize;

    private final Optional<String> remoteFields;

    private final Optional<String> remoteId;

    private final Optional<String> showEnumOrigins;

    private BankInfoListRequest(
            Optional<BankInfoListRequestAccountType> accountType,
            Optional<String> bankName,
            Optional<OffsetDateTime> createdAfter,
            Optional<OffsetDateTime> createdBefore,
            Optional<String> cursor,
            Optional<String> employeeId,
            Optional<String> expand,
            Optional<Boolean> includeDeletedData,
            Optional<Boolean> includeRemoteData,
            Optional<OffsetDateTime> modifiedAfter,
            Optional<OffsetDateTime> modifiedBefore,
            Optional<BankInfoListRequestOrderBy> orderBy,
            Optional<Integer> pageSize,
            Optional<String> remoteFields,
            Optional<String> remoteId,
            Optional<String> showEnumOrigins) {
        this.accountType = accountType;
        this.bankName = bankName;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.cursor = cursor;
        this.employeeId = employeeId;
        this.expand = expand;
        this.includeDeletedData = includeDeletedData;
        this.includeRemoteData = includeRemoteData;
        this.modifiedAfter = modifiedAfter;
        this.modifiedBefore = modifiedBefore;
        this.orderBy = orderBy;
        this.pageSize = pageSize;
        this.remoteFields = remoteFields;
        this.remoteId = remoteId;
        this.showEnumOrigins = showEnumOrigins;
    }

    /**
     * @return If provided, will only return BankInfo's with this account type. Options: ('SAVINGS', 'CHECKING')
     * <ul>
     * <li><code>SAVINGS</code> - SAVINGS</li>
     * <li><code>CHECKING</code> - CHECKING</li>
     * </ul>
     */
    @JsonProperty("account_type")
    public Optional<BankInfoListRequestAccountType> getAccountType() {
        return accountType;
    }

    /**
     * @return If provided, will only return BankInfo's with this bank name.
     */
    @JsonProperty("bank_name")
    public Optional<String> getBankName() {
        return bankName;
    }

    /**
     * @return If provided, will only return objects created after this datetime.
     */
    @JsonProperty("created_after")
    public Optional<OffsetDateTime> getCreatedAfter() {
        return createdAfter;
    }

    /**
     * @return If provided, will only return objects created before this datetime.
     */
    @JsonProperty("created_before")
    public Optional<OffsetDateTime> getCreatedBefore() {
        return createdBefore;
    }

    /**
     * @return The pagination cursor value.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return If provided, will only return bank accounts for this employee.
     */
    @JsonProperty("employee_id")
    public Optional<String> getEmployeeId() {
        return employeeId;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<String> getExpand() {
        return expand;
    }

    /**
     * @return Whether to include data that was marked as deleted by third party webhooks.
     */
    @JsonProperty("include_deleted_data")
    public Optional<Boolean> getIncludeDeletedData() {
        return includeDeletedData;
    }

    /**
     * @return Whether to include the original data Merge fetched from the third-party to produce these models.
     */
    @JsonProperty("include_remote_data")
    public Optional<Boolean> getIncludeRemoteData() {
        return includeRemoteData;
    }

    /**
     * @return If provided, only objects synced by Merge after this date time will be returned.
     */
    @JsonProperty("modified_after")
    public Optional<OffsetDateTime> getModifiedAfter() {
        return modifiedAfter;
    }

    /**
     * @return If provided, only objects synced by Merge before this date time will be returned.
     */
    @JsonProperty("modified_before")
    public Optional<OffsetDateTime> getModifiedBefore() {
        return modifiedBefore;
    }

    /**
     * @return Overrides the default ordering for this endpoint.
     */
    @JsonProperty("order_by")
    public Optional<BankInfoListRequestOrderBy> getOrderBy() {
        return orderBy;
    }

    /**
     * @return Number of results to return per page.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    /**
     * @return Deprecated. Use show_enum_origins.
     */
    @JsonProperty("remote_fields")
    public Optional<String> getRemoteFields() {
        return remoteFields;
    }

    /**
     * @return The API provider's ID for the given object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return Which fields should be returned in non-normalized form.
     */
    @JsonProperty("show_enum_origins")
    public Optional<String> getShowEnumOrigins() {
        return showEnumOrigins;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BankInfoListRequest && equalTo((BankInfoListRequest) other);
    }

    private boolean equalTo(BankInfoListRequest other) {
        return accountType.equals(other.accountType)
                && bankName.equals(other.bankName)
                && createdAfter.equals(other.createdAfter)
                && createdBefore.equals(other.createdBefore)
                && cursor.equals(other.cursor)
                && employeeId.equals(other.employeeId)
                && expand.equals(other.expand)
                && includeDeletedData.equals(other.includeDeletedData)
                && includeRemoteData.equals(other.includeRemoteData)
                && modifiedAfter.equals(other.modifiedAfter)
                && modifiedBefore.equals(other.modifiedBefore)
                && orderBy.equals(other.orderBy)
                && pageSize.equals(other.pageSize)
                && remoteFields.equals(other.remoteFields)
                && remoteId.equals(other.remoteId)
                && showEnumOrigins.equals(other.showEnumOrigins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.accountType,
                this.bankName,
                this.createdAfter,
                this.createdBefore,
                this.cursor,
                this.employeeId,
                this.expand,
                this.includeDeletedData,
                this.includeRemoteData,
                this.modifiedAfter,
                this.modifiedBefore,
                this.orderBy,
                this.pageSize,
                this.remoteFields,
                this.remoteId,
                this.showEnumOrigins);
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
        private Optional<BankInfoListRequestAccountType> accountType = Optional.empty();

        private Optional<String> bankName = Optional.empty();

        private Optional<OffsetDateTime> createdAfter = Optional.empty();

        private Optional<OffsetDateTime> createdBefore = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<String> employeeId = Optional.empty();

        private Optional<String> expand = Optional.empty();

        private Optional<Boolean> includeDeletedData = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<OffsetDateTime> modifiedAfter = Optional.empty();

        private Optional<OffsetDateTime> modifiedBefore = Optional.empty();

        private Optional<BankInfoListRequestOrderBy> orderBy = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> remoteFields = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> showEnumOrigins = Optional.empty();

        private Builder() {}

        public Builder from(BankInfoListRequest other) {
            accountType(other.getAccountType());
            bankName(other.getBankName());
            createdAfter(other.getCreatedAfter());
            createdBefore(other.getCreatedBefore());
            cursor(other.getCursor());
            employeeId(other.getEmployeeId());
            expand(other.getExpand());
            includeDeletedData(other.getIncludeDeletedData());
            includeRemoteData(other.getIncludeRemoteData());
            modifiedAfter(other.getModifiedAfter());
            modifiedBefore(other.getModifiedBefore());
            orderBy(other.getOrderBy());
            pageSize(other.getPageSize());
            remoteFields(other.getRemoteFields());
            remoteId(other.getRemoteId());
            showEnumOrigins(other.getShowEnumOrigins());
            return this;
        }

        @JsonSetter(value = "account_type", nulls = Nulls.SKIP)
        public Builder accountType(Optional<BankInfoListRequestAccountType> accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder accountType(BankInfoListRequestAccountType accountType) {
            this.accountType = Optional.of(accountType);
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

        @JsonSetter(value = "created_after", nulls = Nulls.SKIP)
        public Builder createdAfter(Optional<OffsetDateTime> createdAfter) {
            this.createdAfter = createdAfter;
            return this;
        }

        public Builder createdAfter(OffsetDateTime createdAfter) {
            this.createdAfter = Optional.of(createdAfter);
            return this;
        }

        @JsonSetter(value = "created_before", nulls = Nulls.SKIP)
        public Builder createdBefore(Optional<OffsetDateTime> createdBefore) {
            this.createdBefore = createdBefore;
            return this;
        }

        public Builder createdBefore(OffsetDateTime createdBefore) {
            this.createdBefore = Optional.of(createdBefore);
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.of(cursor);
            return this;
        }

        @JsonSetter(value = "employee_id", nulls = Nulls.SKIP)
        public Builder employeeId(Optional<String> employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = Optional.of(employeeId);
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<String> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(String expand) {
            this.expand = Optional.of(expand);
            return this;
        }

        @JsonSetter(value = "include_deleted_data", nulls = Nulls.SKIP)
        public Builder includeDeletedData(Optional<Boolean> includeDeletedData) {
            this.includeDeletedData = includeDeletedData;
            return this;
        }

        public Builder includeDeletedData(Boolean includeDeletedData) {
            this.includeDeletedData = Optional.of(includeDeletedData);
            return this;
        }

        @JsonSetter(value = "include_remote_data", nulls = Nulls.SKIP)
        public Builder includeRemoteData(Optional<Boolean> includeRemoteData) {
            this.includeRemoteData = includeRemoteData;
            return this;
        }

        public Builder includeRemoteData(Boolean includeRemoteData) {
            this.includeRemoteData = Optional.of(includeRemoteData);
            return this;
        }

        @JsonSetter(value = "modified_after", nulls = Nulls.SKIP)
        public Builder modifiedAfter(Optional<OffsetDateTime> modifiedAfter) {
            this.modifiedAfter = modifiedAfter;
            return this;
        }

        public Builder modifiedAfter(OffsetDateTime modifiedAfter) {
            this.modifiedAfter = Optional.of(modifiedAfter);
            return this;
        }

        @JsonSetter(value = "modified_before", nulls = Nulls.SKIP)
        public Builder modifiedBefore(Optional<OffsetDateTime> modifiedBefore) {
            this.modifiedBefore = modifiedBefore;
            return this;
        }

        public Builder modifiedBefore(OffsetDateTime modifiedBefore) {
            this.modifiedBefore = Optional.of(modifiedBefore);
            return this;
        }

        @JsonSetter(value = "order_by", nulls = Nulls.SKIP)
        public Builder orderBy(Optional<BankInfoListRequestOrderBy> orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public Builder orderBy(BankInfoListRequestOrderBy orderBy) {
            this.orderBy = Optional.of(orderBy);
            return this;
        }

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.of(pageSize);
            return this;
        }

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<String> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(String remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
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

        @JsonSetter(value = "show_enum_origins", nulls = Nulls.SKIP)
        public Builder showEnumOrigins(Optional<String> showEnumOrigins) {
            this.showEnumOrigins = showEnumOrigins;
            return this;
        }

        public Builder showEnumOrigins(String showEnumOrigins) {
            this.showEnumOrigins = Optional.of(showEnumOrigins);
            return this;
        }

        public BankInfoListRequest build() {
            return new BankInfoListRequest(
                    accountType,
                    bankName,
                    createdAfter,
                    createdBefore,
                    cursor,
                    employeeId,
                    expand,
                    includeDeletedData,
                    includeRemoteData,
                    modifiedAfter,
                    modifiedBefore,
                    orderBy,
                    pageSize,
                    remoteFields,
                    remoteId,
                    showEnumOrigins);
        }
    }
}

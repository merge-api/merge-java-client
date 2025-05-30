/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.accounting.invoices.requests;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.legacy.api.core.ObjectMappers;
import com.merge.legacy.api.resources.accounting.invoices.types.InvoicesListRequestExpand;
import com.merge.legacy.api.resources.accounting.invoices.types.InvoicesListRequestStatus;
import com.merge.legacy.api.resources.accounting.invoices.types.InvoicesListRequestType;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = InvoicesListRequest.Builder.class)
public final class InvoicesListRequest {
    private final Optional<String> companyId;

    private final Optional<String> contactId;

    private final Optional<OffsetDateTime> createdAfter;

    private final Optional<OffsetDateTime> createdBefore;

    private final Optional<String> cursor;

    private final Optional<InvoicesListRequestExpand> expand;

    private final Optional<Boolean> includeDeletedData;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeRemoteFields;

    private final Optional<Boolean> includeShellData;

    private final Optional<OffsetDateTime> issueDateAfter;

    private final Optional<OffsetDateTime> issueDateBefore;

    private final Optional<OffsetDateTime> modifiedAfter;

    private final Optional<OffsetDateTime> modifiedBefore;

    private final Optional<String> number;

    private final Optional<Integer> pageSize;

    private final Optional<String> remoteFields;

    private final Optional<String> remoteId;

    private final Optional<String> showEnumOrigins;

    private final Optional<InvoicesListRequestStatus> status;

    private final Optional<InvoicesListRequestType> type;

    private final Map<String, Object> additionalProperties;

    private InvoicesListRequest(
            Optional<String> companyId,
            Optional<String> contactId,
            Optional<OffsetDateTime> createdAfter,
            Optional<OffsetDateTime> createdBefore,
            Optional<String> cursor,
            Optional<InvoicesListRequestExpand> expand,
            Optional<Boolean> includeDeletedData,
            Optional<Boolean> includeRemoteData,
            Optional<Boolean> includeRemoteFields,
            Optional<Boolean> includeShellData,
            Optional<OffsetDateTime> issueDateAfter,
            Optional<OffsetDateTime> issueDateBefore,
            Optional<OffsetDateTime> modifiedAfter,
            Optional<OffsetDateTime> modifiedBefore,
            Optional<String> number,
            Optional<Integer> pageSize,
            Optional<String> remoteFields,
            Optional<String> remoteId,
            Optional<String> showEnumOrigins,
            Optional<InvoicesListRequestStatus> status,
            Optional<InvoicesListRequestType> type,
            Map<String, Object> additionalProperties) {
        this.companyId = companyId;
        this.contactId = contactId;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.cursor = cursor;
        this.expand = expand;
        this.includeDeletedData = includeDeletedData;
        this.includeRemoteData = includeRemoteData;
        this.includeRemoteFields = includeRemoteFields;
        this.includeShellData = includeShellData;
        this.issueDateAfter = issueDateAfter;
        this.issueDateBefore = issueDateBefore;
        this.modifiedAfter = modifiedAfter;
        this.modifiedBefore = modifiedBefore;
        this.number = number;
        this.pageSize = pageSize;
        this.remoteFields = remoteFields;
        this.remoteId = remoteId;
        this.showEnumOrigins = showEnumOrigins;
        this.status = status;
        this.type = type;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return If provided, will only return invoices for this company.
     */
    @JsonProperty("company_id")
    public Optional<String> getCompanyId() {
        return companyId;
    }

    /**
     * @return If provided, will only return invoices for this contact.
     */
    @JsonProperty("contact_id")
    public Optional<String> getContactId() {
        return contactId;
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
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<InvoicesListRequestExpand> getExpand() {
        return expand;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
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
     * @return Whether to include all remote fields, including fields that Merge did not map to common models, in a normalized format.
     */
    @JsonProperty("include_remote_fields")
    public Optional<Boolean> getIncludeRemoteFields() {
        return includeRemoteFields;
    }

    /**
     * @return Whether to include shell records. Shell records are empty records (they may contain some metadata but all other fields are null).
     */
    @JsonProperty("include_shell_data")
    public Optional<Boolean> getIncludeShellData() {
        return includeShellData;
    }

    /**
     * @return If provided, will only return objects created after this datetime.
     */
    @JsonProperty("issue_date_after")
    public Optional<OffsetDateTime> getIssueDateAfter() {
        return issueDateAfter;
    }

    /**
     * @return If provided, will only return objects created before this datetime.
     */
    @JsonProperty("issue_date_before")
    public Optional<OffsetDateTime> getIssueDateBefore() {
        return issueDateBefore;
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
     * @return If provided, will only return Invoices with this number.
     */
    @JsonProperty("number")
    public Optional<String> getNumber() {
        return number;
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
     * @return A comma separated list of enum field names for which you'd like the original values to be returned, instead of Merge's normalized enum values. <a href="https://help.merge.dev/en/articles/8950958-show_enum_origins-query-parameter">Learn more</a>
     */
    @JsonProperty("show_enum_origins")
    public Optional<String> getShowEnumOrigins() {
        return showEnumOrigins;
    }

    /**
     * @return If provided, will only return Invoices with this status.
     * <ul>
     * <li><code>PAID</code> - PAID</li>
     * <li><code>DRAFT</code> - DRAFT</li>
     * <li><code>SUBMITTED</code> - SUBMITTED</li>
     * <li><code>PARTIALLY_PAID</code> - PARTIALLY_PAID</li>
     * <li><code>OPEN</code> - OPEN</li>
     * <li><code>VOID</code> - VOID</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<InvoicesListRequestStatus> getStatus() {
        return status;
    }

    /**
     * @return If provided, will only return Invoices with this type.
     * <ul>
     * <li><code>ACCOUNTS_RECEIVABLE</code> - ACCOUNTS_RECEIVABLE</li>
     * <li><code>ACCOUNTS_PAYABLE</code> - ACCOUNTS_PAYABLE</li>
     * </ul>
     */
    @JsonProperty("type")
    public Optional<InvoicesListRequestType> getType() {
        return type;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof InvoicesListRequest && equalTo((InvoicesListRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(InvoicesListRequest other) {
        return companyId.equals(other.companyId)
                && contactId.equals(other.contactId)
                && createdAfter.equals(other.createdAfter)
                && createdBefore.equals(other.createdBefore)
                && cursor.equals(other.cursor)
                && expand.equals(other.expand)
                && includeDeletedData.equals(other.includeDeletedData)
                && includeRemoteData.equals(other.includeRemoteData)
                && includeRemoteFields.equals(other.includeRemoteFields)
                && includeShellData.equals(other.includeShellData)
                && issueDateAfter.equals(other.issueDateAfter)
                && issueDateBefore.equals(other.issueDateBefore)
                && modifiedAfter.equals(other.modifiedAfter)
                && modifiedBefore.equals(other.modifiedBefore)
                && number.equals(other.number)
                && pageSize.equals(other.pageSize)
                && remoteFields.equals(other.remoteFields)
                && remoteId.equals(other.remoteId)
                && showEnumOrigins.equals(other.showEnumOrigins)
                && status.equals(other.status)
                && type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.companyId,
                this.contactId,
                this.createdAfter,
                this.createdBefore,
                this.cursor,
                this.expand,
                this.includeDeletedData,
                this.includeRemoteData,
                this.includeRemoteFields,
                this.includeShellData,
                this.issueDateAfter,
                this.issueDateBefore,
                this.modifiedAfter,
                this.modifiedBefore,
                this.number,
                this.pageSize,
                this.remoteFields,
                this.remoteId,
                this.showEnumOrigins,
                this.status,
                this.type);
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
        private Optional<String> companyId = Optional.empty();

        private Optional<String> contactId = Optional.empty();

        private Optional<OffsetDateTime> createdAfter = Optional.empty();

        private Optional<OffsetDateTime> createdBefore = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<InvoicesListRequestExpand> expand = Optional.empty();

        private Optional<Boolean> includeDeletedData = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeRemoteFields = Optional.empty();

        private Optional<Boolean> includeShellData = Optional.empty();

        private Optional<OffsetDateTime> issueDateAfter = Optional.empty();

        private Optional<OffsetDateTime> issueDateBefore = Optional.empty();

        private Optional<OffsetDateTime> modifiedAfter = Optional.empty();

        private Optional<OffsetDateTime> modifiedBefore = Optional.empty();

        private Optional<String> number = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> remoteFields = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> showEnumOrigins = Optional.empty();

        private Optional<InvoicesListRequestStatus> status = Optional.empty();

        private Optional<InvoicesListRequestType> type = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(InvoicesListRequest other) {
            companyId(other.getCompanyId());
            contactId(other.getContactId());
            createdAfter(other.getCreatedAfter());
            createdBefore(other.getCreatedBefore());
            cursor(other.getCursor());
            expand(other.getExpand());
            includeDeletedData(other.getIncludeDeletedData());
            includeRemoteData(other.getIncludeRemoteData());
            includeRemoteFields(other.getIncludeRemoteFields());
            includeShellData(other.getIncludeShellData());
            issueDateAfter(other.getIssueDateAfter());
            issueDateBefore(other.getIssueDateBefore());
            modifiedAfter(other.getModifiedAfter());
            modifiedBefore(other.getModifiedBefore());
            number(other.getNumber());
            pageSize(other.getPageSize());
            remoteFields(other.getRemoteFields());
            remoteId(other.getRemoteId());
            showEnumOrigins(other.getShowEnumOrigins());
            status(other.getStatus());
            type(other.getType());
            return this;
        }

        @JsonSetter(value = "company_id", nulls = Nulls.SKIP)
        public Builder companyId(Optional<String> companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder companyId(String companyId) {
            this.companyId = Optional.ofNullable(companyId);
            return this;
        }

        @JsonSetter(value = "contact_id", nulls = Nulls.SKIP)
        public Builder contactId(Optional<String> contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder contactId(String contactId) {
            this.contactId = Optional.ofNullable(contactId);
            return this;
        }

        @JsonSetter(value = "created_after", nulls = Nulls.SKIP)
        public Builder createdAfter(Optional<OffsetDateTime> createdAfter) {
            this.createdAfter = createdAfter;
            return this;
        }

        public Builder createdAfter(OffsetDateTime createdAfter) {
            this.createdAfter = Optional.ofNullable(createdAfter);
            return this;
        }

        @JsonSetter(value = "created_before", nulls = Nulls.SKIP)
        public Builder createdBefore(Optional<OffsetDateTime> createdBefore) {
            this.createdBefore = createdBefore;
            return this;
        }

        public Builder createdBefore(OffsetDateTime createdBefore) {
            this.createdBefore = Optional.ofNullable(createdBefore);
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<InvoicesListRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(InvoicesListRequestExpand expand) {
            this.expand = Optional.ofNullable(expand);
            return this;
        }

        @JsonSetter(value = "include_deleted_data", nulls = Nulls.SKIP)
        public Builder includeDeletedData(Optional<Boolean> includeDeletedData) {
            this.includeDeletedData = includeDeletedData;
            return this;
        }

        public Builder includeDeletedData(Boolean includeDeletedData) {
            this.includeDeletedData = Optional.ofNullable(includeDeletedData);
            return this;
        }

        @JsonSetter(value = "include_remote_data", nulls = Nulls.SKIP)
        public Builder includeRemoteData(Optional<Boolean> includeRemoteData) {
            this.includeRemoteData = includeRemoteData;
            return this;
        }

        public Builder includeRemoteData(Boolean includeRemoteData) {
            this.includeRemoteData = Optional.ofNullable(includeRemoteData);
            return this;
        }

        @JsonSetter(value = "include_remote_fields", nulls = Nulls.SKIP)
        public Builder includeRemoteFields(Optional<Boolean> includeRemoteFields) {
            this.includeRemoteFields = includeRemoteFields;
            return this;
        }

        public Builder includeRemoteFields(Boolean includeRemoteFields) {
            this.includeRemoteFields = Optional.ofNullable(includeRemoteFields);
            return this;
        }

        @JsonSetter(value = "include_shell_data", nulls = Nulls.SKIP)
        public Builder includeShellData(Optional<Boolean> includeShellData) {
            this.includeShellData = includeShellData;
            return this;
        }

        public Builder includeShellData(Boolean includeShellData) {
            this.includeShellData = Optional.ofNullable(includeShellData);
            return this;
        }

        @JsonSetter(value = "issue_date_after", nulls = Nulls.SKIP)
        public Builder issueDateAfter(Optional<OffsetDateTime> issueDateAfter) {
            this.issueDateAfter = issueDateAfter;
            return this;
        }

        public Builder issueDateAfter(OffsetDateTime issueDateAfter) {
            this.issueDateAfter = Optional.ofNullable(issueDateAfter);
            return this;
        }

        @JsonSetter(value = "issue_date_before", nulls = Nulls.SKIP)
        public Builder issueDateBefore(Optional<OffsetDateTime> issueDateBefore) {
            this.issueDateBefore = issueDateBefore;
            return this;
        }

        public Builder issueDateBefore(OffsetDateTime issueDateBefore) {
            this.issueDateBefore = Optional.ofNullable(issueDateBefore);
            return this;
        }

        @JsonSetter(value = "modified_after", nulls = Nulls.SKIP)
        public Builder modifiedAfter(Optional<OffsetDateTime> modifiedAfter) {
            this.modifiedAfter = modifiedAfter;
            return this;
        }

        public Builder modifiedAfter(OffsetDateTime modifiedAfter) {
            this.modifiedAfter = Optional.ofNullable(modifiedAfter);
            return this;
        }

        @JsonSetter(value = "modified_before", nulls = Nulls.SKIP)
        public Builder modifiedBefore(Optional<OffsetDateTime> modifiedBefore) {
            this.modifiedBefore = modifiedBefore;
            return this;
        }

        public Builder modifiedBefore(OffsetDateTime modifiedBefore) {
            this.modifiedBefore = Optional.ofNullable(modifiedBefore);
            return this;
        }

        @JsonSetter(value = "number", nulls = Nulls.SKIP)
        public Builder number(Optional<String> number) {
            this.number = number;
            return this;
        }

        public Builder number(String number) {
            this.number = Optional.ofNullable(number);
            return this;
        }

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.ofNullable(pageSize);
            return this;
        }

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<String> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(String remoteFields) {
            this.remoteFields = Optional.ofNullable(remoteFields);
            return this;
        }

        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.ofNullable(remoteId);
            return this;
        }

        @JsonSetter(value = "show_enum_origins", nulls = Nulls.SKIP)
        public Builder showEnumOrigins(Optional<String> showEnumOrigins) {
            this.showEnumOrigins = showEnumOrigins;
            return this;
        }

        public Builder showEnumOrigins(String showEnumOrigins) {
            this.showEnumOrigins = Optional.ofNullable(showEnumOrigins);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<InvoicesListRequestStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(InvoicesListRequestStatus status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<InvoicesListRequestType> type) {
            this.type = type;
            return this;
        }

        public Builder type(InvoicesListRequestType type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        public InvoicesListRequest build() {
            return new InvoicesListRequest(
                    companyId,
                    contactId,
                    createdAfter,
                    createdBefore,
                    cursor,
                    expand,
                    includeDeletedData,
                    includeRemoteData,
                    includeRemoteFields,
                    includeShellData,
                    issueDateAfter,
                    issueDateBefore,
                    modifiedAfter,
                    modifiedBefore,
                    number,
                    pageSize,
                    remoteFields,
                    remoteId,
                    showEnumOrigins,
                    status,
                    type,
                    additionalProperties);
        }
    }
}

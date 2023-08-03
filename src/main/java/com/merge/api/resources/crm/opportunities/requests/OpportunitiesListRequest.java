package com.merge.api.resources.crm.opportunities.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.resources.crm.types.OpportunitiesListRequestExpand;
import com.merge.api.resources.crm.types.OpportunitiesListRequestStatus;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = OpportunitiesListRequest.Builder.class)
public final class OpportunitiesListRequest {
    private final Optional<String> accountId;

    private final Optional<OffsetDateTime> createdAfter;

    private final Optional<OffsetDateTime> createdBefore;

    private final Optional<String> cursor;

    private final Optional<OpportunitiesListRequestExpand> expand;

    private final Optional<Boolean> includeDeletedData;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeRemoteFields;

    private final Optional<OffsetDateTime> modifiedAfter;

    private final Optional<OffsetDateTime> modifiedBefore;

    private final Optional<String> ownerId;

    private final Optional<Integer> pageSize;

    private final Optional<String> remoteFields;

    private final Optional<String> remoteId;

    private final Optional<String> showEnumOrigins;

    private final Optional<String> stageId;

    private final Optional<OpportunitiesListRequestStatus> status;

    private OpportunitiesListRequest(
            Optional<String> accountId,
            Optional<OffsetDateTime> createdAfter,
            Optional<OffsetDateTime> createdBefore,
            Optional<String> cursor,
            Optional<OpportunitiesListRequestExpand> expand,
            Optional<Boolean> includeDeletedData,
            Optional<Boolean> includeRemoteData,
            Optional<Boolean> includeRemoteFields,
            Optional<OffsetDateTime> modifiedAfter,
            Optional<OffsetDateTime> modifiedBefore,
            Optional<String> ownerId,
            Optional<Integer> pageSize,
            Optional<String> remoteFields,
            Optional<String> remoteId,
            Optional<String> showEnumOrigins,
            Optional<String> stageId,
            Optional<OpportunitiesListRequestStatus> status) {
        this.accountId = accountId;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.cursor = cursor;
        this.expand = expand;
        this.includeDeletedData = includeDeletedData;
        this.includeRemoteData = includeRemoteData;
        this.includeRemoteFields = includeRemoteFields;
        this.modifiedAfter = modifiedAfter;
        this.modifiedBefore = modifiedBefore;
        this.ownerId = ownerId;
        this.pageSize = pageSize;
        this.remoteFields = remoteFields;
        this.remoteId = remoteId;
        this.showEnumOrigins = showEnumOrigins;
        this.stageId = stageId;
        this.status = status;
    }

    /**
     * @return If provided, will only return opportunities with this account.
     */
    @JsonProperty("account_id")
    public Optional<String> getAccountId() {
        return accountId;
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
    public Optional<OpportunitiesListRequestExpand> getExpand() {
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
     * @return Whether to include all remote fields, including fields that Merge did not map to common models, in a normalized format.
     */
    @JsonProperty("include_remote_fields")
    public Optional<Boolean> getIncludeRemoteFields() {
        return includeRemoteFields;
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
     * @return If provided, will only return opportunities with this owner.
     */
    @JsonProperty("owner_id")
    public Optional<String> getOwnerId() {
        return ownerId;
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

    /**
     * @return If provided, will only return opportunities with this stage.
     */
    @JsonProperty("stage_id")
    public Optional<String> getStageId() {
        return stageId;
    }

    /**
     * @return If provided, will only return opportunities with this status. Options: ('OPEN', 'WON', 'LOST')
     * <ul>
     * <li><code>OPEN</code> - OPEN</li>
     * <li><code>WON</code> - WON</li>
     * <li><code>LOST</code> - LOST</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<OpportunitiesListRequestStatus> getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OpportunitiesListRequest && equalTo((OpportunitiesListRequest) other);
    }

    private boolean equalTo(OpportunitiesListRequest other) {
        return accountId.equals(other.accountId)
                && createdAfter.equals(other.createdAfter)
                && createdBefore.equals(other.createdBefore)
                && cursor.equals(other.cursor)
                && expand.equals(other.expand)
                && includeDeletedData.equals(other.includeDeletedData)
                && includeRemoteData.equals(other.includeRemoteData)
                && includeRemoteFields.equals(other.includeRemoteFields)
                && modifiedAfter.equals(other.modifiedAfter)
                && modifiedBefore.equals(other.modifiedBefore)
                && ownerId.equals(other.ownerId)
                && pageSize.equals(other.pageSize)
                && remoteFields.equals(other.remoteFields)
                && remoteId.equals(other.remoteId)
                && showEnumOrigins.equals(other.showEnumOrigins)
                && stageId.equals(other.stageId)
                && status.equals(other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.accountId,
                this.createdAfter,
                this.createdBefore,
                this.cursor,
                this.expand,
                this.includeDeletedData,
                this.includeRemoteData,
                this.includeRemoteFields,
                this.modifiedAfter,
                this.modifiedBefore,
                this.ownerId,
                this.pageSize,
                this.remoteFields,
                this.remoteId,
                this.showEnumOrigins,
                this.stageId,
                this.status);
    }

    @Override
    public String toString() {
        return "OpportunitiesListRequest{" + "accountId: " + accountId + ", createdAfter: " + createdAfter
                + ", createdBefore: " + createdBefore + ", cursor: " + cursor + ", expand: " + expand
                + ", includeDeletedData: " + includeDeletedData + ", includeRemoteData: " + includeRemoteData
                + ", includeRemoteFields: " + includeRemoteFields + ", modifiedAfter: " + modifiedAfter
                + ", modifiedBefore: " + modifiedBefore + ", ownerId: " + ownerId + ", pageSize: " + pageSize
                + ", remoteFields: " + remoteFields + ", remoteId: " + remoteId + ", showEnumOrigins: "
                + showEnumOrigins + ", stageId: " + stageId + ", status: " + status + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> accountId = Optional.empty();

        private Optional<OffsetDateTime> createdAfter = Optional.empty();

        private Optional<OffsetDateTime> createdBefore = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<OpportunitiesListRequestExpand> expand = Optional.empty();

        private Optional<Boolean> includeDeletedData = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeRemoteFields = Optional.empty();

        private Optional<OffsetDateTime> modifiedAfter = Optional.empty();

        private Optional<OffsetDateTime> modifiedBefore = Optional.empty();

        private Optional<String> ownerId = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> remoteFields = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> showEnumOrigins = Optional.empty();

        private Optional<String> stageId = Optional.empty();

        private Optional<OpportunitiesListRequestStatus> status = Optional.empty();

        private Builder() {}

        public Builder from(OpportunitiesListRequest other) {
            accountId(other.getAccountId());
            createdAfter(other.getCreatedAfter());
            createdBefore(other.getCreatedBefore());
            cursor(other.getCursor());
            expand(other.getExpand());
            includeDeletedData(other.getIncludeDeletedData());
            includeRemoteData(other.getIncludeRemoteData());
            includeRemoteFields(other.getIncludeRemoteFields());
            modifiedAfter(other.getModifiedAfter());
            modifiedBefore(other.getModifiedBefore());
            ownerId(other.getOwnerId());
            pageSize(other.getPageSize());
            remoteFields(other.getRemoteFields());
            remoteId(other.getRemoteId());
            showEnumOrigins(other.getShowEnumOrigins());
            stageId(other.getStageId());
            status(other.getStatus());
            return this;
        }

        @JsonSetter(value = "account_id", nulls = Nulls.SKIP)
        public Builder accountId(Optional<String> accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = Optional.of(accountId);
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

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<OpportunitiesListRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(OpportunitiesListRequestExpand expand) {
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

        @JsonSetter(value = "include_remote_fields", nulls = Nulls.SKIP)
        public Builder includeRemoteFields(Optional<Boolean> includeRemoteFields) {
            this.includeRemoteFields = includeRemoteFields;
            return this;
        }

        public Builder includeRemoteFields(Boolean includeRemoteFields) {
            this.includeRemoteFields = Optional.of(includeRemoteFields);
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

        @JsonSetter(value = "owner_id", nulls = Nulls.SKIP)
        public Builder ownerId(Optional<String> ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder ownerId(String ownerId) {
            this.ownerId = Optional.of(ownerId);
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

        @JsonSetter(value = "stage_id", nulls = Nulls.SKIP)
        public Builder stageId(Optional<String> stageId) {
            this.stageId = stageId;
            return this;
        }

        public Builder stageId(String stageId) {
            this.stageId = Optional.of(stageId);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<OpportunitiesListRequestStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(OpportunitiesListRequestStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        public OpportunitiesListRequest build() {
            return new OpportunitiesListRequest(
                    accountId,
                    createdAfter,
                    createdBefore,
                    cursor,
                    expand,
                    includeDeletedData,
                    includeRemoteData,
                    includeRemoteFields,
                    modifiedAfter,
                    modifiedBefore,
                    ownerId,
                    pageSize,
                    remoteFields,
                    remoteId,
                    showEnumOrigins,
                    stageId,
                    status);
        }
    }
}

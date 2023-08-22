package com.merge.api.resources.ticketing.tickets.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.ticketing.types.TicketsListRequestExpand;
import com.merge.api.resources.ticketing.types.TicketsListRequestPriority;
import com.merge.api.resources.ticketing.types.TicketsListRequestRemoteFields;
import com.merge.api.resources.ticketing.types.TicketsListRequestShowEnumOrigins;
import com.merge.api.resources.ticketing.types.TicketsListRequestStatus;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TicketsListRequest.Builder.class)
public final class TicketsListRequest {
    private final Optional<String> accountId;

    private final Optional<String> assigneeIds;

    private final Optional<String> collectionIds;

    private final Optional<OffsetDateTime> completedAfter;

    private final Optional<OffsetDateTime> completedBefore;

    private final Optional<String> contactId;

    private final Optional<OffsetDateTime> createdAfter;

    private final Optional<OffsetDateTime> createdBefore;

    private final Optional<String> cursor;

    private final Optional<OffsetDateTime> dueAfter;

    private final Optional<OffsetDateTime> dueBefore;

    private final Optional<TicketsListRequestExpand> expand;

    private final Optional<Boolean> includeDeletedData;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeRemoteFields;

    private final Optional<OffsetDateTime> modifiedAfter;

    private final Optional<OffsetDateTime> modifiedBefore;

    private final Optional<Integer> pageSize;

    private final Optional<String> parentTicketId;

    private final Optional<TicketsListRequestPriority> priority;

    private final Optional<String> projectId;

    private final Optional<OffsetDateTime> remoteCreatedAfter;

    private final Optional<OffsetDateTime> remoteCreatedBefore;

    private final Optional<TicketsListRequestRemoteFields> remoteFields;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> remoteUpdatedAfter;

    private final Optional<OffsetDateTime> remoteUpdatedBefore;

    private final Optional<TicketsListRequestShowEnumOrigins> showEnumOrigins;

    private final Optional<TicketsListRequestStatus> status;

    private final Optional<String> tags;

    private final Optional<String> ticketType;

    private TicketsListRequest(
            Optional<String> accountId,
            Optional<String> assigneeIds,
            Optional<String> collectionIds,
            Optional<OffsetDateTime> completedAfter,
            Optional<OffsetDateTime> completedBefore,
            Optional<String> contactId,
            Optional<OffsetDateTime> createdAfter,
            Optional<OffsetDateTime> createdBefore,
            Optional<String> cursor,
            Optional<OffsetDateTime> dueAfter,
            Optional<OffsetDateTime> dueBefore,
            Optional<TicketsListRequestExpand> expand,
            Optional<Boolean> includeDeletedData,
            Optional<Boolean> includeRemoteData,
            Optional<Boolean> includeRemoteFields,
            Optional<OffsetDateTime> modifiedAfter,
            Optional<OffsetDateTime> modifiedBefore,
            Optional<Integer> pageSize,
            Optional<String> parentTicketId,
            Optional<TicketsListRequestPriority> priority,
            Optional<String> projectId,
            Optional<OffsetDateTime> remoteCreatedAfter,
            Optional<OffsetDateTime> remoteCreatedBefore,
            Optional<TicketsListRequestRemoteFields> remoteFields,
            Optional<String> remoteId,
            Optional<OffsetDateTime> remoteUpdatedAfter,
            Optional<OffsetDateTime> remoteUpdatedBefore,
            Optional<TicketsListRequestShowEnumOrigins> showEnumOrigins,
            Optional<TicketsListRequestStatus> status,
            Optional<String> tags,
            Optional<String> ticketType) {
        this.accountId = accountId;
        this.assigneeIds = assigneeIds;
        this.collectionIds = collectionIds;
        this.completedAfter = completedAfter;
        this.completedBefore = completedBefore;
        this.contactId = contactId;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.cursor = cursor;
        this.dueAfter = dueAfter;
        this.dueBefore = dueBefore;
        this.expand = expand;
        this.includeDeletedData = includeDeletedData;
        this.includeRemoteData = includeRemoteData;
        this.includeRemoteFields = includeRemoteFields;
        this.modifiedAfter = modifiedAfter;
        this.modifiedBefore = modifiedBefore;
        this.pageSize = pageSize;
        this.parentTicketId = parentTicketId;
        this.priority = priority;
        this.projectId = projectId;
        this.remoteCreatedAfter = remoteCreatedAfter;
        this.remoteCreatedBefore = remoteCreatedBefore;
        this.remoteFields = remoteFields;
        this.remoteId = remoteId;
        this.remoteUpdatedAfter = remoteUpdatedAfter;
        this.remoteUpdatedBefore = remoteUpdatedBefore;
        this.showEnumOrigins = showEnumOrigins;
        this.status = status;
        this.tags = tags;
        this.ticketType = ticketType;
    }

    /**
     * @return If provided, will only return tickets for this account.
     */
    @JsonProperty("account_id")
    public Optional<String> getAccountId() {
        return accountId;
    }

    /**
     * @return If provided, will only return tickets assigned to the assignee_ids; multiple assignee_ids can be separated by commas.
     */
    @JsonProperty("assignee_ids")
    public Optional<String> getAssigneeIds() {
        return assigneeIds;
    }

    /**
     * @return If provided, will only return tickets assigned to the collection_ids; multiple collection_ids can be separated by commas.
     */
    @JsonProperty("collection_ids")
    public Optional<String> getCollectionIds() {
        return collectionIds;
    }

    /**
     * @return If provided, will only return tickets completed after this datetime.
     */
    @JsonProperty("completed_after")
    public Optional<OffsetDateTime> getCompletedAfter() {
        return completedAfter;
    }

    /**
     * @return If provided, will only return tickets completed before this datetime.
     */
    @JsonProperty("completed_before")
    public Optional<OffsetDateTime> getCompletedBefore() {
        return completedBefore;
    }

    /**
     * @return If provided, will only return tickets for this contact.
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
     * @return If provided, will only return tickets due after this datetime.
     */
    @JsonProperty("due_after")
    public Optional<OffsetDateTime> getDueAfter() {
        return dueAfter;
    }

    /**
     * @return If provided, will only return tickets due before this datetime.
     */
    @JsonProperty("due_before")
    public Optional<OffsetDateTime> getDueBefore() {
        return dueBefore;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<TicketsListRequestExpand> getExpand() {
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
     * @return Number of results to return per page.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    /**
     * @return If provided, will only return sub tickets of the parent_ticket_id.
     */
    @JsonProperty("parent_ticket_id")
    public Optional<String> getParentTicketId() {
        return parentTicketId;
    }

    /**
     * @return If provided, will only return tickets of this priority.
     * <ul>
     * <li><code>URGENT</code> - URGENT</li>
     * <li><code>HIGH</code> - HIGH</li>
     * <li><code>NORMAL</code> - NORMAL</li>
     * <li><code>LOW</code> - LOW</li>
     * </ul>
     */
    @JsonProperty("priority")
    public Optional<TicketsListRequestPriority> getPriority() {
        return priority;
    }

    /**
     * @return If provided, will only return tickets for this project.
     */
    @JsonProperty("project_id")
    public Optional<String> getProjectId() {
        return projectId;
    }

    /**
     * @return If provided, will only return tickets created in the third party platform after this datetime.
     */
    @JsonProperty("remote_created_after")
    public Optional<OffsetDateTime> getRemoteCreatedAfter() {
        return remoteCreatedAfter;
    }

    /**
     * @return If provided, will only return tickets created in the third party platform before this datetime.
     */
    @JsonProperty("remote_created_before")
    public Optional<OffsetDateTime> getRemoteCreatedBefore() {
        return remoteCreatedBefore;
    }

    /**
     * @return Deprecated. Use show_enum_origins.
     */
    @JsonProperty("remote_fields")
    public Optional<TicketsListRequestRemoteFields> getRemoteFields() {
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
     * @return If provided, will only return tickets updated in the third party platform after this datetime.
     */
    @JsonProperty("remote_updated_after")
    public Optional<OffsetDateTime> getRemoteUpdatedAfter() {
        return remoteUpdatedAfter;
    }

    /**
     * @return If provided, will only return tickets updated in the third party platform before this datetime.
     */
    @JsonProperty("remote_updated_before")
    public Optional<OffsetDateTime> getRemoteUpdatedBefore() {
        return remoteUpdatedBefore;
    }

    /**
     * @return Which fields should be returned in non-normalized form.
     */
    @JsonProperty("show_enum_origins")
    public Optional<TicketsListRequestShowEnumOrigins> getShowEnumOrigins() {
        return showEnumOrigins;
    }

    /**
     * @return If provided, will only return tickets of this status.
     * <ul>
     * <li><code>OPEN</code> - OPEN</li>
     * <li><code>CLOSED</code> - CLOSED</li>
     * <li><code>IN_PROGRESS</code> - IN_PROGRESS</li>
     * <li><code>ON_HOLD</code> - ON_HOLD</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<TicketsListRequestStatus> getStatus() {
        return status;
    }

    /**
     * @return If provided, will only return tickets matching the tags; multiple tags can be separated by commas.
     */
    @JsonProperty("tags")
    public Optional<String> getTags() {
        return tags;
    }

    /**
     * @return If provided, will only return tickets of this type.
     */
    @JsonProperty("ticket_type")
    public Optional<String> getTicketType() {
        return ticketType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TicketsListRequest && equalTo((TicketsListRequest) other);
    }

    private boolean equalTo(TicketsListRequest other) {
        return accountId.equals(other.accountId)
                && assigneeIds.equals(other.assigneeIds)
                && collectionIds.equals(other.collectionIds)
                && completedAfter.equals(other.completedAfter)
                && completedBefore.equals(other.completedBefore)
                && contactId.equals(other.contactId)
                && createdAfter.equals(other.createdAfter)
                && createdBefore.equals(other.createdBefore)
                && cursor.equals(other.cursor)
                && dueAfter.equals(other.dueAfter)
                && dueBefore.equals(other.dueBefore)
                && expand.equals(other.expand)
                && includeDeletedData.equals(other.includeDeletedData)
                && includeRemoteData.equals(other.includeRemoteData)
                && includeRemoteFields.equals(other.includeRemoteFields)
                && modifiedAfter.equals(other.modifiedAfter)
                && modifiedBefore.equals(other.modifiedBefore)
                && pageSize.equals(other.pageSize)
                && parentTicketId.equals(other.parentTicketId)
                && priority.equals(other.priority)
                && projectId.equals(other.projectId)
                && remoteCreatedAfter.equals(other.remoteCreatedAfter)
                && remoteCreatedBefore.equals(other.remoteCreatedBefore)
                && remoteFields.equals(other.remoteFields)
                && remoteId.equals(other.remoteId)
                && remoteUpdatedAfter.equals(other.remoteUpdatedAfter)
                && remoteUpdatedBefore.equals(other.remoteUpdatedBefore)
                && showEnumOrigins.equals(other.showEnumOrigins)
                && status.equals(other.status)
                && tags.equals(other.tags)
                && ticketType.equals(other.ticketType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.accountId,
                this.assigneeIds,
                this.collectionIds,
                this.completedAfter,
                this.completedBefore,
                this.contactId,
                this.createdAfter,
                this.createdBefore,
                this.cursor,
                this.dueAfter,
                this.dueBefore,
                this.expand,
                this.includeDeletedData,
                this.includeRemoteData,
                this.includeRemoteFields,
                this.modifiedAfter,
                this.modifiedBefore,
                this.pageSize,
                this.parentTicketId,
                this.priority,
                this.projectId,
                this.remoteCreatedAfter,
                this.remoteCreatedBefore,
                this.remoteFields,
                this.remoteId,
                this.remoteUpdatedAfter,
                this.remoteUpdatedBefore,
                this.showEnumOrigins,
                this.status,
                this.tags,
                this.ticketType);
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
        private Optional<String> accountId = Optional.empty();

        private Optional<String> assigneeIds = Optional.empty();

        private Optional<String> collectionIds = Optional.empty();

        private Optional<OffsetDateTime> completedAfter = Optional.empty();

        private Optional<OffsetDateTime> completedBefore = Optional.empty();

        private Optional<String> contactId = Optional.empty();

        private Optional<OffsetDateTime> createdAfter = Optional.empty();

        private Optional<OffsetDateTime> createdBefore = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<OffsetDateTime> dueAfter = Optional.empty();

        private Optional<OffsetDateTime> dueBefore = Optional.empty();

        private Optional<TicketsListRequestExpand> expand = Optional.empty();

        private Optional<Boolean> includeDeletedData = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeRemoteFields = Optional.empty();

        private Optional<OffsetDateTime> modifiedAfter = Optional.empty();

        private Optional<OffsetDateTime> modifiedBefore = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> parentTicketId = Optional.empty();

        private Optional<TicketsListRequestPriority> priority = Optional.empty();

        private Optional<String> projectId = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAfter = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedBefore = Optional.empty();

        private Optional<TicketsListRequestRemoteFields> remoteFields = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAfter = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedBefore = Optional.empty();

        private Optional<TicketsListRequestShowEnumOrigins> showEnumOrigins = Optional.empty();

        private Optional<TicketsListRequestStatus> status = Optional.empty();

        private Optional<String> tags = Optional.empty();

        private Optional<String> ticketType = Optional.empty();

        private Builder() {}

        public Builder from(TicketsListRequest other) {
            accountId(other.getAccountId());
            assigneeIds(other.getAssigneeIds());
            collectionIds(other.getCollectionIds());
            completedAfter(other.getCompletedAfter());
            completedBefore(other.getCompletedBefore());
            contactId(other.getContactId());
            createdAfter(other.getCreatedAfter());
            createdBefore(other.getCreatedBefore());
            cursor(other.getCursor());
            dueAfter(other.getDueAfter());
            dueBefore(other.getDueBefore());
            expand(other.getExpand());
            includeDeletedData(other.getIncludeDeletedData());
            includeRemoteData(other.getIncludeRemoteData());
            includeRemoteFields(other.getIncludeRemoteFields());
            modifiedAfter(other.getModifiedAfter());
            modifiedBefore(other.getModifiedBefore());
            pageSize(other.getPageSize());
            parentTicketId(other.getParentTicketId());
            priority(other.getPriority());
            projectId(other.getProjectId());
            remoteCreatedAfter(other.getRemoteCreatedAfter());
            remoteCreatedBefore(other.getRemoteCreatedBefore());
            remoteFields(other.getRemoteFields());
            remoteId(other.getRemoteId());
            remoteUpdatedAfter(other.getRemoteUpdatedAfter());
            remoteUpdatedBefore(other.getRemoteUpdatedBefore());
            showEnumOrigins(other.getShowEnumOrigins());
            status(other.getStatus());
            tags(other.getTags());
            ticketType(other.getTicketType());
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

        @JsonSetter(value = "assignee_ids", nulls = Nulls.SKIP)
        public Builder assigneeIds(Optional<String> assigneeIds) {
            this.assigneeIds = assigneeIds;
            return this;
        }

        public Builder assigneeIds(String assigneeIds) {
            this.assigneeIds = Optional.of(assigneeIds);
            return this;
        }

        @JsonSetter(value = "collection_ids", nulls = Nulls.SKIP)
        public Builder collectionIds(Optional<String> collectionIds) {
            this.collectionIds = collectionIds;
            return this;
        }

        public Builder collectionIds(String collectionIds) {
            this.collectionIds = Optional.of(collectionIds);
            return this;
        }

        @JsonSetter(value = "completed_after", nulls = Nulls.SKIP)
        public Builder completedAfter(Optional<OffsetDateTime> completedAfter) {
            this.completedAfter = completedAfter;
            return this;
        }

        public Builder completedAfter(OffsetDateTime completedAfter) {
            this.completedAfter = Optional.of(completedAfter);
            return this;
        }

        @JsonSetter(value = "completed_before", nulls = Nulls.SKIP)
        public Builder completedBefore(Optional<OffsetDateTime> completedBefore) {
            this.completedBefore = completedBefore;
            return this;
        }

        public Builder completedBefore(OffsetDateTime completedBefore) {
            this.completedBefore = Optional.of(completedBefore);
            return this;
        }

        @JsonSetter(value = "contact_id", nulls = Nulls.SKIP)
        public Builder contactId(Optional<String> contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder contactId(String contactId) {
            this.contactId = Optional.of(contactId);
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

        @JsonSetter(value = "due_after", nulls = Nulls.SKIP)
        public Builder dueAfter(Optional<OffsetDateTime> dueAfter) {
            this.dueAfter = dueAfter;
            return this;
        }

        public Builder dueAfter(OffsetDateTime dueAfter) {
            this.dueAfter = Optional.of(dueAfter);
            return this;
        }

        @JsonSetter(value = "due_before", nulls = Nulls.SKIP)
        public Builder dueBefore(Optional<OffsetDateTime> dueBefore) {
            this.dueBefore = dueBefore;
            return this;
        }

        public Builder dueBefore(OffsetDateTime dueBefore) {
            this.dueBefore = Optional.of(dueBefore);
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<TicketsListRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(TicketsListRequestExpand expand) {
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

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.of(pageSize);
            return this;
        }

        @JsonSetter(value = "parent_ticket_id", nulls = Nulls.SKIP)
        public Builder parentTicketId(Optional<String> parentTicketId) {
            this.parentTicketId = parentTicketId;
            return this;
        }

        public Builder parentTicketId(String parentTicketId) {
            this.parentTicketId = Optional.of(parentTicketId);
            return this;
        }

        @JsonSetter(value = "priority", nulls = Nulls.SKIP)
        public Builder priority(Optional<TicketsListRequestPriority> priority) {
            this.priority = priority;
            return this;
        }

        public Builder priority(TicketsListRequestPriority priority) {
            this.priority = Optional.of(priority);
            return this;
        }

        @JsonSetter(value = "project_id", nulls = Nulls.SKIP)
        public Builder projectId(Optional<String> projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder projectId(String projectId) {
            this.projectId = Optional.of(projectId);
            return this;
        }

        @JsonSetter(value = "remote_created_after", nulls = Nulls.SKIP)
        public Builder remoteCreatedAfter(Optional<OffsetDateTime> remoteCreatedAfter) {
            this.remoteCreatedAfter = remoteCreatedAfter;
            return this;
        }

        public Builder remoteCreatedAfter(OffsetDateTime remoteCreatedAfter) {
            this.remoteCreatedAfter = Optional.of(remoteCreatedAfter);
            return this;
        }

        @JsonSetter(value = "remote_created_before", nulls = Nulls.SKIP)
        public Builder remoteCreatedBefore(Optional<OffsetDateTime> remoteCreatedBefore) {
            this.remoteCreatedBefore = remoteCreatedBefore;
            return this;
        }

        public Builder remoteCreatedBefore(OffsetDateTime remoteCreatedBefore) {
            this.remoteCreatedBefore = Optional.of(remoteCreatedBefore);
            return this;
        }

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<TicketsListRequestRemoteFields> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(TicketsListRequestRemoteFields remoteFields) {
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

        @JsonSetter(value = "remote_updated_after", nulls = Nulls.SKIP)
        public Builder remoteUpdatedAfter(Optional<OffsetDateTime> remoteUpdatedAfter) {
            this.remoteUpdatedAfter = remoteUpdatedAfter;
            return this;
        }

        public Builder remoteUpdatedAfter(OffsetDateTime remoteUpdatedAfter) {
            this.remoteUpdatedAfter = Optional.of(remoteUpdatedAfter);
            return this;
        }

        @JsonSetter(value = "remote_updated_before", nulls = Nulls.SKIP)
        public Builder remoteUpdatedBefore(Optional<OffsetDateTime> remoteUpdatedBefore) {
            this.remoteUpdatedBefore = remoteUpdatedBefore;
            return this;
        }

        public Builder remoteUpdatedBefore(OffsetDateTime remoteUpdatedBefore) {
            this.remoteUpdatedBefore = Optional.of(remoteUpdatedBefore);
            return this;
        }

        @JsonSetter(value = "show_enum_origins", nulls = Nulls.SKIP)
        public Builder showEnumOrigins(Optional<TicketsListRequestShowEnumOrigins> showEnumOrigins) {
            this.showEnumOrigins = showEnumOrigins;
            return this;
        }

        public Builder showEnumOrigins(TicketsListRequestShowEnumOrigins showEnumOrigins) {
            this.showEnumOrigins = Optional.of(showEnumOrigins);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<TicketsListRequestStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(TicketsListRequestStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public Builder tags(Optional<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = Optional.of(tags);
            return this;
        }

        @JsonSetter(value = "ticket_type", nulls = Nulls.SKIP)
        public Builder ticketType(Optional<String> ticketType) {
            this.ticketType = ticketType;
            return this;
        }

        public Builder ticketType(String ticketType) {
            this.ticketType = Optional.of(ticketType);
            return this;
        }

        public TicketsListRequest build() {
            return new TicketsListRequest(
                    accountId,
                    assigneeIds,
                    collectionIds,
                    completedAfter,
                    completedBefore,
                    contactId,
                    createdAfter,
                    createdBefore,
                    cursor,
                    dueAfter,
                    dueBefore,
                    expand,
                    includeDeletedData,
                    includeRemoteData,
                    includeRemoteFields,
                    modifiedAfter,
                    modifiedBefore,
                    pageSize,
                    parentTicketId,
                    priority,
                    projectId,
                    remoteCreatedAfter,
                    remoteCreatedBefore,
                    remoteFields,
                    remoteId,
                    remoteUpdatedAfter,
                    remoteUpdatedBefore,
                    showEnumOrigins,
                    status,
                    tags,
                    ticketType);
        }
    }
}

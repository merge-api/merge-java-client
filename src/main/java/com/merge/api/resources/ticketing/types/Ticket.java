package com.merge.api.resources.ticketing.types;

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
@JsonDeserialize(builder = Ticket.Builder.class)
public final class Ticket {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> name;

    private final Optional<List<Optional<TicketAssigneesItem>>> assignees;

    private final Optional<TicketCreator> creator;

    private final Optional<OffsetDateTime> dueDate;

    private final Optional<TicketStatus> status;

    private final Optional<String> description;

    private final Optional<List<Optional<TicketCollectionsItem>>> collections;

    private final Optional<String> ticketType;

    private final Optional<TicketAccount> account;

    private final Optional<TicketContact> contact;

    private final Optional<TicketParentTicket> parentTicket;

    private final Optional<List<Optional<TicketAttachmentsItem>>> attachments;

    private final Optional<List<Optional<String>>> tags;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<OffsetDateTime> completedAt;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<String> ticketUrl;

    private final Optional<TicketPriority> priority;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private final Optional<List<RemoteField>> remoteFields;

    private Ticket(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> name,
            Optional<List<Optional<TicketAssigneesItem>>> assignees,
            Optional<TicketCreator> creator,
            Optional<OffsetDateTime> dueDate,
            Optional<TicketStatus> status,
            Optional<String> description,
            Optional<List<Optional<TicketCollectionsItem>>> collections,
            Optional<String> ticketType,
            Optional<TicketAccount> account,
            Optional<TicketContact> contact,
            Optional<TicketParentTicket> parentTicket,
            Optional<List<Optional<TicketAttachmentsItem>>> attachments,
            Optional<List<Optional<String>>> tags,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<OffsetDateTime> completedAt,
            Optional<Boolean> remoteWasDeleted,
            Optional<String> ticketUrl,
            Optional<TicketPriority> priority,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData,
            Optional<List<RemoteField>> remoteFields) {
        this.id = id;
        this.remoteId = remoteId;
        this.name = name;
        this.assignees = assignees;
        this.creator = creator;
        this.dueDate = dueDate;
        this.status = status;
        this.description = description;
        this.collections = collections;
        this.ticketType = ticketType;
        this.account = account;
        this.contact = contact;
        this.parentTicket = parentTicket;
        this.attachments = attachments;
        this.tags = tags;
        this.remoteCreatedAt = remoteCreatedAt;
        this.remoteUpdatedAt = remoteUpdatedAt;
        this.completedAt = completedAt;
        this.remoteWasDeleted = remoteWasDeleted;
        this.ticketUrl = ticketUrl;
        this.priority = priority;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
        this.remoteFields = remoteFields;
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
     * @return The ticket's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("assignees")
    public Optional<List<Optional<TicketAssigneesItem>>> getAssignees() {
        return assignees;
    }

    /**
     * @return The user who created this ticket.
     */
    @JsonProperty("creator")
    public Optional<TicketCreator> getCreator() {
        return creator;
    }

    /**
     * @return The ticket's due date.
     */
    @JsonProperty("due_date")
    public Optional<OffsetDateTime> getDueDate() {
        return dueDate;
    }

    /**
     * @return The current status of the ticket.
     * <ul>
     * <li><code>OPEN</code> - OPEN</li>
     * <li><code>CLOSED</code> - CLOSED</li>
     * <li><code>IN_PROGRESS</code> - IN_PROGRESS</li>
     * <li><code>ON_HOLD</code> - ON_HOLD</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<TicketStatus> getStatus() {
        return status;
    }

    /**
     * @return The ticket’s description. HTML version of description is mapped if supported by the third-party platform.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("collections")
    public Optional<List<Optional<TicketCollectionsItem>>> getCollections() {
        return collections;
    }

    /**
     * @return The ticket's type.
     */
    @JsonProperty("ticket_type")
    public Optional<String> getTicketType() {
        return ticketType;
    }

    /**
     * @return The account associated with the ticket.
     */
    @JsonProperty("account")
    public Optional<TicketAccount> getAccount() {
        return account;
    }

    /**
     * @return The contact associated with the ticket.
     */
    @JsonProperty("contact")
    public Optional<TicketContact> getContact() {
        return contact;
    }

    /**
     * @return The ticket's parent ticket.
     */
    @JsonProperty("parent_ticket")
    public Optional<TicketParentTicket> getParentTicket() {
        return parentTicket;
    }

    @JsonProperty("attachments")
    public Optional<List<Optional<TicketAttachmentsItem>>> getAttachments() {
        return attachments;
    }

    @JsonProperty("tags")
    public Optional<List<Optional<String>>> getTags() {
        return tags;
    }

    /**
     * @return When the third party's ticket was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return When the third party's ticket was updated.
     */
    @JsonProperty("remote_updated_at")
    public Optional<OffsetDateTime> getRemoteUpdatedAt() {
        return remoteUpdatedAt;
    }

    /**
     * @return When the ticket was completed.
     */
    @JsonProperty("completed_at")
    public Optional<OffsetDateTime> getCompletedAt() {
        return completedAt;
    }

    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    /**
     * @return The 3rd party url of the Ticket.
     */
    @JsonProperty("ticket_url")
    public Optional<String> getTicketUrl() {
        return ticketUrl;
    }

    /**
     * @return The priority or urgency of the Ticket.
     * <ul>
     * <li><code>URGENT</code> - URGENT</li>
     * <li><code>HIGH</code> - HIGH</li>
     * <li><code>NORMAL</code> - NORMAL</li>
     * <li><code>LOW</code> - LOW</li>
     * </ul>
     */
    @JsonProperty("priority")
    public Optional<TicketPriority> getPriority() {
        return priority;
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

    @JsonProperty("remote_fields")
    public Optional<List<RemoteField>> getRemoteFields() {
        return remoteFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Ticket && equalTo((Ticket) other);
    }

    private boolean equalTo(Ticket other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && name.equals(other.name)
                && assignees.equals(other.assignees)
                && creator.equals(other.creator)
                && dueDate.equals(other.dueDate)
                && status.equals(other.status)
                && description.equals(other.description)
                && collections.equals(other.collections)
                && ticketType.equals(other.ticketType)
                && account.equals(other.account)
                && contact.equals(other.contact)
                && parentTicket.equals(other.parentTicket)
                && attachments.equals(other.attachments)
                && tags.equals(other.tags)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && remoteUpdatedAt.equals(other.remoteUpdatedAt)
                && completedAt.equals(other.completedAt)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && ticketUrl.equals(other.ticketUrl)
                && priority.equals(other.priority)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData)
                && remoteFields.equals(other.remoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.name,
                this.assignees,
                this.creator,
                this.dueDate,
                this.status,
                this.description,
                this.collections,
                this.ticketType,
                this.account,
                this.contact,
                this.parentTicket,
                this.attachments,
                this.tags,
                this.remoteCreatedAt,
                this.remoteUpdatedAt,
                this.completedAt,
                this.remoteWasDeleted,
                this.ticketUrl,
                this.priority,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData,
                this.remoteFields);
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

        private Optional<String> name = Optional.empty();

        private Optional<List<Optional<TicketAssigneesItem>>> assignees = Optional.empty();

        private Optional<TicketCreator> creator = Optional.empty();

        private Optional<OffsetDateTime> dueDate = Optional.empty();

        private Optional<TicketStatus> status = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<List<Optional<TicketCollectionsItem>>> collections = Optional.empty();

        private Optional<String> ticketType = Optional.empty();

        private Optional<TicketAccount> account = Optional.empty();

        private Optional<TicketContact> contact = Optional.empty();

        private Optional<TicketParentTicket> parentTicket = Optional.empty();

        private Optional<List<Optional<TicketAttachmentsItem>>> attachments = Optional.empty();

        private Optional<List<Optional<String>>> tags = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<OffsetDateTime> completedAt = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<String> ticketUrl = Optional.empty();

        private Optional<TicketPriority> priority = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Optional<List<RemoteField>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(Ticket other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            name(other.getName());
            assignees(other.getAssignees());
            creator(other.getCreator());
            dueDate(other.getDueDate());
            status(other.getStatus());
            description(other.getDescription());
            collections(other.getCollections());
            ticketType(other.getTicketType());
            account(other.getAccount());
            contact(other.getContact());
            parentTicket(other.getParentTicket());
            attachments(other.getAttachments());
            tags(other.getTags());
            remoteCreatedAt(other.getRemoteCreatedAt());
            remoteUpdatedAt(other.getRemoteUpdatedAt());
            completedAt(other.getCompletedAt());
            remoteWasDeleted(other.getRemoteWasDeleted());
            ticketUrl(other.getTicketUrl());
            priority(other.getPriority());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
            remoteFields(other.getRemoteFields());
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "assignees", nulls = Nulls.SKIP)
        public Builder assignees(Optional<List<Optional<TicketAssigneesItem>>> assignees) {
            this.assignees = assignees;
            return this;
        }

        public Builder assignees(List<Optional<TicketAssigneesItem>> assignees) {
            this.assignees = Optional.of(assignees);
            return this;
        }

        @JsonSetter(value = "creator", nulls = Nulls.SKIP)
        public Builder creator(Optional<TicketCreator> creator) {
            this.creator = creator;
            return this;
        }

        public Builder creator(TicketCreator creator) {
            this.creator = Optional.of(creator);
            return this;
        }

        @JsonSetter(value = "due_date", nulls = Nulls.SKIP)
        public Builder dueDate(Optional<OffsetDateTime> dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder dueDate(OffsetDateTime dueDate) {
            this.dueDate = Optional.of(dueDate);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<TicketStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(TicketStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "collections", nulls = Nulls.SKIP)
        public Builder collections(Optional<List<Optional<TicketCollectionsItem>>> collections) {
            this.collections = collections;
            return this;
        }

        public Builder collections(List<Optional<TicketCollectionsItem>> collections) {
            this.collections = Optional.of(collections);
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

        @JsonSetter(value = "account", nulls = Nulls.SKIP)
        public Builder account(Optional<TicketAccount> account) {
            this.account = account;
            return this;
        }

        public Builder account(TicketAccount account) {
            this.account = Optional.of(account);
            return this;
        }

        @JsonSetter(value = "contact", nulls = Nulls.SKIP)
        public Builder contact(Optional<TicketContact> contact) {
            this.contact = contact;
            return this;
        }

        public Builder contact(TicketContact contact) {
            this.contact = Optional.of(contact);
            return this;
        }

        @JsonSetter(value = "parent_ticket", nulls = Nulls.SKIP)
        public Builder parentTicket(Optional<TicketParentTicket> parentTicket) {
            this.parentTicket = parentTicket;
            return this;
        }

        public Builder parentTicket(TicketParentTicket parentTicket) {
            this.parentTicket = Optional.of(parentTicket);
            return this;
        }

        @JsonSetter(value = "attachments", nulls = Nulls.SKIP)
        public Builder attachments(Optional<List<Optional<TicketAttachmentsItem>>> attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder attachments(List<Optional<TicketAttachmentsItem>> attachments) {
            this.attachments = Optional.of(attachments);
            return this;
        }

        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public Builder tags(Optional<List<Optional<String>>> tags) {
            this.tags = tags;
            return this;
        }

        public Builder tags(List<Optional<String>> tags) {
            this.tags = Optional.of(tags);
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

        @JsonSetter(value = "remote_updated_at", nulls = Nulls.SKIP)
        public Builder remoteUpdatedAt(Optional<OffsetDateTime> remoteUpdatedAt) {
            this.remoteUpdatedAt = remoteUpdatedAt;
            return this;
        }

        public Builder remoteUpdatedAt(OffsetDateTime remoteUpdatedAt) {
            this.remoteUpdatedAt = Optional.of(remoteUpdatedAt);
            return this;
        }

        @JsonSetter(value = "completed_at", nulls = Nulls.SKIP)
        public Builder completedAt(Optional<OffsetDateTime> completedAt) {
            this.completedAt = completedAt;
            return this;
        }

        public Builder completedAt(OffsetDateTime completedAt) {
            this.completedAt = Optional.of(completedAt);
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

        @JsonSetter(value = "ticket_url", nulls = Nulls.SKIP)
        public Builder ticketUrl(Optional<String> ticketUrl) {
            this.ticketUrl = ticketUrl;
            return this;
        }

        public Builder ticketUrl(String ticketUrl) {
            this.ticketUrl = Optional.of(ticketUrl);
            return this;
        }

        @JsonSetter(value = "priority", nulls = Nulls.SKIP)
        public Builder priority(Optional<TicketPriority> priority) {
            this.priority = priority;
            return this;
        }

        public Builder priority(TicketPriority priority) {
            this.priority = Optional.of(priority);
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

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<List<RemoteField>> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(List<RemoteField> remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
            return this;
        }

        public Ticket build() {
            return new Ticket(
                    id,
                    remoteId,
                    name,
                    assignees,
                    creator,
                    dueDate,
                    status,
                    description,
                    collections,
                    ticketType,
                    account,
                    contact,
                    parentTicket,
                    attachments,
                    tags,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    completedAt,
                    remoteWasDeleted,
                    ticketUrl,
                    priority,
                    modifiedAt,
                    fieldMappings,
                    remoteData,
                    remoteFields);
        }
    }
}

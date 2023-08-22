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
@JsonDeserialize(builder = TicketRequest.Builder.class)
public final class TicketRequest {
    private final Optional<String> name;

    private final Optional<List<Optional<TicketRequestAssigneesItem>>> assignees;

    private final Optional<TicketRequestCreator> creator;

    private final Optional<OffsetDateTime> dueDate;

    private final Optional<TicketRequestStatus> status;

    private final Optional<String> description;

    private final Optional<List<Optional<TicketRequestCollectionsItem>>> collections;

    private final Optional<String> ticketType;

    private final Optional<TicketRequestAccount> account;

    private final Optional<TicketRequestContact> contact;

    private final Optional<TicketRequestParentTicket> parentTicket;

    private final Optional<List<Optional<TicketRequestAttachmentsItem>>> attachments;

    private final Optional<List<Optional<String>>> tags;

    private final Optional<OffsetDateTime> completedAt;

    private final Optional<String> ticketUrl;

    private final Optional<TicketRequestPriority> priority;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Optional<List<RemoteFieldRequest>> remoteFields;

    private TicketRequest(
            Optional<String> name,
            Optional<List<Optional<TicketRequestAssigneesItem>>> assignees,
            Optional<TicketRequestCreator> creator,
            Optional<OffsetDateTime> dueDate,
            Optional<TicketRequestStatus> status,
            Optional<String> description,
            Optional<List<Optional<TicketRequestCollectionsItem>>> collections,
            Optional<String> ticketType,
            Optional<TicketRequestAccount> account,
            Optional<TicketRequestContact> contact,
            Optional<TicketRequestParentTicket> parentTicket,
            Optional<List<Optional<TicketRequestAttachmentsItem>>> attachments,
            Optional<List<Optional<String>>> tags,
            Optional<OffsetDateTime> completedAt,
            Optional<String> ticketUrl,
            Optional<TicketRequestPriority> priority,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Optional<List<RemoteFieldRequest>> remoteFields) {
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
        this.completedAt = completedAt;
        this.ticketUrl = ticketUrl;
        this.priority = priority;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
        this.remoteFields = remoteFields;
    }

    /**
     * @return The ticket's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("assignees")
    public Optional<List<Optional<TicketRequestAssigneesItem>>> getAssignees() {
        return assignees;
    }

    /**
     * @return The user who created this ticket.
     */
    @JsonProperty("creator")
    public Optional<TicketRequestCreator> getCreator() {
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
    public Optional<TicketRequestStatus> getStatus() {
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
    public Optional<List<Optional<TicketRequestCollectionsItem>>> getCollections() {
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
    public Optional<TicketRequestAccount> getAccount() {
        return account;
    }

    /**
     * @return The contact associated with the ticket.
     */
    @JsonProperty("contact")
    public Optional<TicketRequestContact> getContact() {
        return contact;
    }

    /**
     * @return The ticket's parent ticket.
     */
    @JsonProperty("parent_ticket")
    public Optional<TicketRequestParentTicket> getParentTicket() {
        return parentTicket;
    }

    @JsonProperty("attachments")
    public Optional<List<Optional<TicketRequestAttachmentsItem>>> getAttachments() {
        return attachments;
    }

    @JsonProperty("tags")
    public Optional<List<Optional<String>>> getTags() {
        return tags;
    }

    /**
     * @return When the ticket was completed.
     */
    @JsonProperty("completed_at")
    public Optional<OffsetDateTime> getCompletedAt() {
        return completedAt;
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
    public Optional<TicketRequestPriority> getPriority() {
        return priority;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @JsonProperty("remote_fields")
    public Optional<List<RemoteFieldRequest>> getRemoteFields() {
        return remoteFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TicketRequest && equalTo((TicketRequest) other);
    }

    private boolean equalTo(TicketRequest other) {
        return name.equals(other.name)
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
                && completedAt.equals(other.completedAt)
                && ticketUrl.equals(other.ticketUrl)
                && priority.equals(other.priority)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams)
                && remoteFields.equals(other.remoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
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
                this.completedAt,
                this.ticketUrl,
                this.priority,
                this.integrationParams,
                this.linkedAccountParams,
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
        private Optional<String> name = Optional.empty();

        private Optional<List<Optional<TicketRequestAssigneesItem>>> assignees = Optional.empty();

        private Optional<TicketRequestCreator> creator = Optional.empty();

        private Optional<OffsetDateTime> dueDate = Optional.empty();

        private Optional<TicketRequestStatus> status = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<List<Optional<TicketRequestCollectionsItem>>> collections = Optional.empty();

        private Optional<String> ticketType = Optional.empty();

        private Optional<TicketRequestAccount> account = Optional.empty();

        private Optional<TicketRequestContact> contact = Optional.empty();

        private Optional<TicketRequestParentTicket> parentTicket = Optional.empty();

        private Optional<List<Optional<TicketRequestAttachmentsItem>>> attachments = Optional.empty();

        private Optional<List<Optional<String>>> tags = Optional.empty();

        private Optional<OffsetDateTime> completedAt = Optional.empty();

        private Optional<String> ticketUrl = Optional.empty();

        private Optional<TicketRequestPriority> priority = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Optional<List<RemoteFieldRequest>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(TicketRequest other) {
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
            completedAt(other.getCompletedAt());
            ticketUrl(other.getTicketUrl());
            priority(other.getPriority());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            remoteFields(other.getRemoteFields());
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
        public Builder assignees(Optional<List<Optional<TicketRequestAssigneesItem>>> assignees) {
            this.assignees = assignees;
            return this;
        }

        public Builder assignees(List<Optional<TicketRequestAssigneesItem>> assignees) {
            this.assignees = Optional.of(assignees);
            return this;
        }

        @JsonSetter(value = "creator", nulls = Nulls.SKIP)
        public Builder creator(Optional<TicketRequestCreator> creator) {
            this.creator = creator;
            return this;
        }

        public Builder creator(TicketRequestCreator creator) {
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
        public Builder status(Optional<TicketRequestStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(TicketRequestStatus status) {
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
        public Builder collections(Optional<List<Optional<TicketRequestCollectionsItem>>> collections) {
            this.collections = collections;
            return this;
        }

        public Builder collections(List<Optional<TicketRequestCollectionsItem>> collections) {
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
        public Builder account(Optional<TicketRequestAccount> account) {
            this.account = account;
            return this;
        }

        public Builder account(TicketRequestAccount account) {
            this.account = Optional.of(account);
            return this;
        }

        @JsonSetter(value = "contact", nulls = Nulls.SKIP)
        public Builder contact(Optional<TicketRequestContact> contact) {
            this.contact = contact;
            return this;
        }

        public Builder contact(TicketRequestContact contact) {
            this.contact = Optional.of(contact);
            return this;
        }

        @JsonSetter(value = "parent_ticket", nulls = Nulls.SKIP)
        public Builder parentTicket(Optional<TicketRequestParentTicket> parentTicket) {
            this.parentTicket = parentTicket;
            return this;
        }

        public Builder parentTicket(TicketRequestParentTicket parentTicket) {
            this.parentTicket = Optional.of(parentTicket);
            return this;
        }

        @JsonSetter(value = "attachments", nulls = Nulls.SKIP)
        public Builder attachments(Optional<List<Optional<TicketRequestAttachmentsItem>>> attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder attachments(List<Optional<TicketRequestAttachmentsItem>> attachments) {
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

        @JsonSetter(value = "completed_at", nulls = Nulls.SKIP)
        public Builder completedAt(Optional<OffsetDateTime> completedAt) {
            this.completedAt = completedAt;
            return this;
        }

        public Builder completedAt(OffsetDateTime completedAt) {
            this.completedAt = Optional.of(completedAt);
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
        public Builder priority(Optional<TicketRequestPriority> priority) {
            this.priority = priority;
            return this;
        }

        public Builder priority(TicketRequestPriority priority) {
            this.priority = Optional.of(priority);
            return this;
        }

        @JsonSetter(value = "integration_params", nulls = Nulls.SKIP)
        public Builder integrationParams(Optional<Map<String, JsonNode>> integrationParams) {
            this.integrationParams = integrationParams;
            return this;
        }

        public Builder integrationParams(Map<String, JsonNode> integrationParams) {
            this.integrationParams = Optional.of(integrationParams);
            return this;
        }

        @JsonSetter(value = "linked_account_params", nulls = Nulls.SKIP)
        public Builder linkedAccountParams(Optional<Map<String, JsonNode>> linkedAccountParams) {
            this.linkedAccountParams = linkedAccountParams;
            return this;
        }

        public Builder linkedAccountParams(Map<String, JsonNode> linkedAccountParams) {
            this.linkedAccountParams = Optional.of(linkedAccountParams);
            return this;
        }

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<List<RemoteFieldRequest>> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(List<RemoteFieldRequest> remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
            return this;
        }

        public TicketRequest build() {
            return new TicketRequest(
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
                    completedAt,
                    ticketUrl,
                    priority,
                    integrationParams,
                    linkedAccountParams,
                    remoteFields);
        }
    }
}

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
@JsonDeserialize(builder = PatchedTicketRequest.Builder.class)
public final class PatchedTicketRequest {
    private final Optional<String> name;

    private final Optional<List<Optional<String>>> assignees;

    private final Optional<String> creator;

    private final Optional<OffsetDateTime> dueDate;

    private final Optional<PatchedTicketRequestStatus> status;

    private final Optional<String> description;

    private final Optional<List<Optional<String>>> collections;

    private final Optional<String> ticketType;

    private final Optional<String> account;

    private final Optional<String> contact;

    private final Optional<String> parentTicket;

    private final Optional<List<Optional<String>>> tags;

    private final Optional<OffsetDateTime> completedAt;

    private final Optional<String> ticketUrl;

    private final Optional<PatchedTicketRequestPriority> priority;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Optional<List<RemoteFieldRequest>> remoteFields;

    private PatchedTicketRequest(
            Optional<String> name,
            Optional<List<Optional<String>>> assignees,
            Optional<String> creator,
            Optional<OffsetDateTime> dueDate,
            Optional<PatchedTicketRequestStatus> status,
            Optional<String> description,
            Optional<List<Optional<String>>> collections,
            Optional<String> ticketType,
            Optional<String> account,
            Optional<String> contact,
            Optional<String> parentTicket,
            Optional<List<Optional<String>>> tags,
            Optional<OffsetDateTime> completedAt,
            Optional<String> ticketUrl,
            Optional<PatchedTicketRequestPriority> priority,
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
    public Optional<List<Optional<String>>> getAssignees() {
        return assignees;
    }

    /**
     * @return The user who created this ticket.
     */
    @JsonProperty("creator")
    public Optional<String> getCreator() {
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
    public Optional<PatchedTicketRequestStatus> getStatus() {
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
    public Optional<List<Optional<String>>> getCollections() {
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
    public Optional<String> getAccount() {
        return account;
    }

    /**
     * @return The contact associated with the ticket.
     */
    @JsonProperty("contact")
    public Optional<String> getContact() {
        return contact;
    }

    /**
     * @return The ticket's parent ticket.
     */
    @JsonProperty("parent_ticket")
    public Optional<String> getParentTicket() {
        return parentTicket;
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
    public Optional<PatchedTicketRequestPriority> getPriority() {
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
        return other instanceof PatchedTicketRequest && equalTo((PatchedTicketRequest) other);
    }

    private boolean equalTo(PatchedTicketRequest other) {
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

        private Optional<List<Optional<String>>> assignees = Optional.empty();

        private Optional<String> creator = Optional.empty();

        private Optional<OffsetDateTime> dueDate = Optional.empty();

        private Optional<PatchedTicketRequestStatus> status = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<List<Optional<String>>> collections = Optional.empty();

        private Optional<String> ticketType = Optional.empty();

        private Optional<String> account = Optional.empty();

        private Optional<String> contact = Optional.empty();

        private Optional<String> parentTicket = Optional.empty();

        private Optional<List<Optional<String>>> tags = Optional.empty();

        private Optional<OffsetDateTime> completedAt = Optional.empty();

        private Optional<String> ticketUrl = Optional.empty();

        private Optional<PatchedTicketRequestPriority> priority = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Optional<List<RemoteFieldRequest>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(PatchedTicketRequest other) {
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
        public Builder assignees(Optional<List<Optional<String>>> assignees) {
            this.assignees = assignees;
            return this;
        }

        public Builder assignees(List<Optional<String>> assignees) {
            this.assignees = Optional.of(assignees);
            return this;
        }

        @JsonSetter(value = "creator", nulls = Nulls.SKIP)
        public Builder creator(Optional<String> creator) {
            this.creator = creator;
            return this;
        }

        public Builder creator(String creator) {
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
        public Builder status(Optional<PatchedTicketRequestStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(PatchedTicketRequestStatus status) {
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
        public Builder collections(Optional<List<Optional<String>>> collections) {
            this.collections = collections;
            return this;
        }

        public Builder collections(List<Optional<String>> collections) {
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
        public Builder account(Optional<String> account) {
            this.account = account;
            return this;
        }

        public Builder account(String account) {
            this.account = Optional.of(account);
            return this;
        }

        @JsonSetter(value = "contact", nulls = Nulls.SKIP)
        public Builder contact(Optional<String> contact) {
            this.contact = contact;
            return this;
        }

        public Builder contact(String contact) {
            this.contact = Optional.of(contact);
            return this;
        }

        @JsonSetter(value = "parent_ticket", nulls = Nulls.SKIP)
        public Builder parentTicket(Optional<String> parentTicket) {
            this.parentTicket = parentTicket;
            return this;
        }

        public Builder parentTicket(String parentTicket) {
            this.parentTicket = Optional.of(parentTicket);
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
        public Builder priority(Optional<PatchedTicketRequestPriority> priority) {
            this.priority = priority;
            return this;
        }

        public Builder priority(PatchedTicketRequestPriority priority) {
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

        public PatchedTicketRequest build() {
            return new PatchedTicketRequest(
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

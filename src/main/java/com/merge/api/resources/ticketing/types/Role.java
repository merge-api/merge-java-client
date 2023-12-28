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
@JsonDeserialize(builder = Role.Builder.class)
public final class Role {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> name;

    private final Optional<List<Optional<RoleTicketActionsItem>>> ticketActions;

    private final Optional<RoleTicketAccess> ticketAccess;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Role(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> name,
            Optional<List<Optional<RoleTicketActionsItem>>> ticketActions,
            Optional<RoleTicketAccess> ticketAccess,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.name = name;
        this.ticketActions = ticketActions;
        this.ticketAccess = ticketAccess;
        this.remoteWasDeleted = remoteWasDeleted;
        this.createdAt = createdAt;
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
     * @return The name of the Role.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The set of actions that a User with this Role can perform. Possible enum values include: <code>VIEW</code>, <code>CREATE</code>, <code>EDIT</code>, <code>DELETE</code>, <code>CLOSE</code>, and <code>ASSIGN</code>.
     */
    @JsonProperty("ticket_actions")
    public Optional<List<Optional<RoleTicketActionsItem>>> getTicketActions() {
        return ticketActions;
    }

    /**
     * @return The level of Ticket access that a User with this Role can perform.
     * <ul>
     * <li><code>ALL</code> - ALL</li>
     * <li><code>ASSIGNED_ONLY</code> - ASSIGNED_ONLY</li>
     * <li><code>TEAM_ONLY</code> - TEAM_ONLY</li>
     * </ul>
     */
    @JsonProperty("ticket_access")
    public Optional<RoleTicketAccess> getTicketAccess() {
        return ticketAccess;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
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
        return other instanceof Role && equalTo((Role) other);
    }

    private boolean equalTo(Role other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && name.equals(other.name)
                && ticketActions.equals(other.ticketActions)
                && ticketAccess.equals(other.ticketAccess)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.name,
                this.ticketActions,
                this.ticketAccess,
                this.remoteWasDeleted,
                this.createdAt,
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

        private Optional<String> name = Optional.empty();

        private Optional<List<Optional<RoleTicketActionsItem>>> ticketActions = Optional.empty();

        private Optional<RoleTicketAccess> ticketAccess = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Role other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            name(other.getName());
            ticketActions(other.getTicketActions());
            ticketAccess(other.getTicketAccess());
            remoteWasDeleted(other.getRemoteWasDeleted());
            createdAt(other.getCreatedAt());
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "ticket_actions", nulls = Nulls.SKIP)
        public Builder ticketActions(Optional<List<Optional<RoleTicketActionsItem>>> ticketActions) {
            this.ticketActions = ticketActions;
            return this;
        }

        public Builder ticketActions(List<Optional<RoleTicketActionsItem>> ticketActions) {
            this.ticketActions = Optional.of(ticketActions);
            return this;
        }

        @JsonSetter(value = "ticket_access", nulls = Nulls.SKIP)
        public Builder ticketAccess(Optional<RoleTicketAccess> ticketAccess) {
            this.ticketAccess = ticketAccess;
            return this;
        }

        public Builder ticketAccess(RoleTicketAccess ticketAccess) {
            this.ticketAccess = Optional.of(ticketAccess);
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

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
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

        public Role build() {
            return new Role(
                    id,
                    remoteId,
                    name,
                    ticketActions,
                    ticketAccess,
                    remoteWasDeleted,
                    createdAt,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

package com.merge.api.resources.crm.types;

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
@JsonDeserialize(builder = Note.Builder.class)
public final class Note {
    private final Optional<NoteOwner> owner;

    private final Optional<String> content;

    private final Optional<NoteContact> contact;

    private final Optional<NoteAccount> account;

    private final Optional<NoteOpportunity> opportunity;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private final Optional<List<RemoteField>> remoteFields;

    private Note(
            Optional<NoteOwner> owner,
            Optional<String> content,
            Optional<NoteContact> contact,
            Optional<NoteAccount> account,
            Optional<NoteOpportunity> opportunity,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<Boolean> remoteWasDeleted,
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData,
            Optional<List<RemoteField>> remoteFields) {
        this.owner = owner;
        this.content = content;
        this.contact = contact;
        this.account = account;
        this.opportunity = opportunity;
        this.remoteUpdatedAt = remoteUpdatedAt;
        this.remoteCreatedAt = remoteCreatedAt;
        this.remoteWasDeleted = remoteWasDeleted;
        this.id = id;
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
        this.remoteFields = remoteFields;
    }

    /**
     * @return The note's owner.
     */
    @JsonProperty("owner")
    public Optional<NoteOwner> getOwner() {
        return owner;
    }

    /**
     * @return The note's content.
     */
    @JsonProperty("content")
    public Optional<String> getContent() {
        return content;
    }

    /**
     * @return The note's contact.
     */
    @JsonProperty("contact")
    public Optional<NoteContact> getContact() {
        return contact;
    }

    /**
     * @return The note's account.
     */
    @JsonProperty("account")
    public Optional<NoteAccount> getAccount() {
        return account;
    }

    /**
     * @return The note's opportunity.
     */
    @JsonProperty("opportunity")
    public Optional<NoteOpportunity> getOpportunity() {
        return opportunity;
    }

    /**
     * @return When the third party's lead was updated.
     */
    @JsonProperty("remote_updated_at")
    public Optional<OffsetDateTime> getRemoteUpdatedAt() {
        return remoteUpdatedAt;
    }

    /**
     * @return When the third party's lead was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
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

    @JsonProperty("remote_fields")
    public Optional<List<RemoteField>> getRemoteFields() {
        return remoteFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Note && equalTo((Note) other);
    }

    private boolean equalTo(Note other) {
        return owner.equals(other.owner)
                && content.equals(other.content)
                && contact.equals(other.contact)
                && account.equals(other.account)
                && opportunity.equals(other.opportunity)
                && remoteUpdatedAt.equals(other.remoteUpdatedAt)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData)
                && remoteFields.equals(other.remoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.owner,
                this.content,
                this.contact,
                this.account,
                this.opportunity,
                this.remoteUpdatedAt,
                this.remoteCreatedAt,
                this.remoteWasDeleted,
                this.id,
                this.remoteId,
                this.createdAt,
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
        private Optional<NoteOwner> owner = Optional.empty();

        private Optional<String> content = Optional.empty();

        private Optional<NoteContact> contact = Optional.empty();

        private Optional<NoteAccount> account = Optional.empty();

        private Optional<NoteOpportunity> opportunity = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Optional<List<RemoteField>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(Note other) {
            owner(other.getOwner());
            content(other.getContent());
            contact(other.getContact());
            account(other.getAccount());
            opportunity(other.getOpportunity());
            remoteUpdatedAt(other.getRemoteUpdatedAt());
            remoteCreatedAt(other.getRemoteCreatedAt());
            remoteWasDeleted(other.getRemoteWasDeleted());
            id(other.getId());
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
            remoteFields(other.getRemoteFields());
            return this;
        }

        @JsonSetter(value = "owner", nulls = Nulls.SKIP)
        public Builder owner(Optional<NoteOwner> owner) {
            this.owner = owner;
            return this;
        }

        public Builder owner(NoteOwner owner) {
            this.owner = Optional.of(owner);
            return this;
        }

        @JsonSetter(value = "content", nulls = Nulls.SKIP)
        public Builder content(Optional<String> content) {
            this.content = content;
            return this;
        }

        public Builder content(String content) {
            this.content = Optional.of(content);
            return this;
        }

        @JsonSetter(value = "contact", nulls = Nulls.SKIP)
        public Builder contact(Optional<NoteContact> contact) {
            this.contact = contact;
            return this;
        }

        public Builder contact(NoteContact contact) {
            this.contact = Optional.of(contact);
            return this;
        }

        @JsonSetter(value = "account", nulls = Nulls.SKIP)
        public Builder account(Optional<NoteAccount> account) {
            this.account = account;
            return this;
        }

        public Builder account(NoteAccount account) {
            this.account = Optional.of(account);
            return this;
        }

        @JsonSetter(value = "opportunity", nulls = Nulls.SKIP)
        public Builder opportunity(Optional<NoteOpportunity> opportunity) {
            this.opportunity = opportunity;
            return this;
        }

        public Builder opportunity(NoteOpportunity opportunity) {
            this.opportunity = Optional.of(opportunity);
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

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<List<RemoteField>> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(List<RemoteField> remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
            return this;
        }

        public Note build() {
            return new Note(
                    owner,
                    content,
                    contact,
                    account,
                    opportunity,
                    remoteUpdatedAt,
                    remoteCreatedAt,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    createdAt,
                    modifiedAt,
                    fieldMappings,
                    remoteData,
                    remoteFields);
        }
    }
}

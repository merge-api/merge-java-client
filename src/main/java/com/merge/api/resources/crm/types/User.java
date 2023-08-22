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
@JsonDeserialize(builder = User.Builder.class)
public final class User {
    private final Optional<String> name;

    private final Optional<String> email;

    private final Optional<Boolean> isActive;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private final Optional<List<RemoteField>> remoteFields;

    private User(
            Optional<String> name,
            Optional<String> email,
            Optional<Boolean> isActive,
            Optional<Boolean> remoteWasDeleted,
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData,
            Optional<List<RemoteField>> remoteFields) {
        this.name = name;
        this.email = email;
        this.isActive = isActive;
        this.remoteWasDeleted = remoteWasDeleted;
        this.id = id;
        this.remoteId = remoteId;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
        this.remoteFields = remoteFields;
    }

    /**
     * @return The user's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The user's email address.
     */
    @JsonProperty("email")
    public Optional<String> getEmail() {
        return email;
    }

    /**
     * @return Whether or not the user is active.
     */
    @JsonProperty("is_active")
    public Optional<Boolean> getIsActive() {
        return isActive;
    }

    /**
     * @return Indicates whether or not this object has been deleted by third party webhooks.
     */
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
        return other instanceof User && equalTo((User) other);
    }

    private boolean equalTo(User other) {
        return name.equals(other.name)
                && email.equals(other.email)
                && isActive.equals(other.isActive)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData)
                && remoteFields.equals(other.remoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.name,
                this.email,
                this.isActive,
                this.remoteWasDeleted,
                this.id,
                this.remoteId,
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
        private Optional<String> name = Optional.empty();

        private Optional<String> email = Optional.empty();

        private Optional<Boolean> isActive = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Optional<List<RemoteField>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(User other) {
            name(other.getName());
            email(other.getEmail());
            isActive(other.getIsActive());
            remoteWasDeleted(other.getRemoteWasDeleted());
            id(other.getId());
            remoteId(other.getRemoteId());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
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

        @JsonSetter(value = "email", nulls = Nulls.SKIP)
        public Builder email(Optional<String> email) {
            this.email = email;
            return this;
        }

        public Builder email(String email) {
            this.email = Optional.of(email);
            return this;
        }

        @JsonSetter(value = "is_active", nulls = Nulls.SKIP)
        public Builder isActive(Optional<Boolean> isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = Optional.of(isActive);
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

        public User build() {
            return new User(
                    name,
                    email,
                    isActive,
                    remoteWasDeleted,
                    id,
                    remoteId,
                    modifiedAt,
                    fieldMappings,
                    remoteData,
                    remoteFields);
        }
    }
}

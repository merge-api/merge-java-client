package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RemoteUser.Builder.class)
public final class RemoteUser {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> firstName;

    private final Optional<String> lastName;

    private final Optional<String> email;

    private final Optional<Boolean> disabled;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<RemoteUserAccessRole> accessRole;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private RemoteUser(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<String> email,
            Optional<Boolean> disabled,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<RemoteUserAccessRole> accessRole,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.disabled = disabled;
        this.remoteCreatedAt = remoteCreatedAt;
        this.accessRole = accessRole;
        this.remoteWasDeleted = remoteWasDeleted;
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
     * @return The user's first name.
     */
    @JsonProperty("first_name")
    public Optional<String> getFirstName() {
        return firstName;
    }

    /**
     * @return The user's last name.
     */
    @JsonProperty("last_name")
    public Optional<String> getLastName() {
        return lastName;
    }

    /**
     * @return The user's email.
     */
    @JsonProperty("email")
    public Optional<String> getEmail() {
        return email;
    }

    /**
     * @return Whether the user's account had been disabled.
     */
    @JsonProperty("disabled")
    public Optional<Boolean> getDisabled() {
        return disabled;
    }

    /**
     * @return When the third party's user was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return The user's role.
     * <ul>
     * <li><code>SUPER_ADMIN</code> - SUPER_ADMIN</li>
     * <li><code>ADMIN</code> - ADMIN</li>
     * <li><code>TEAM_MEMBER</code> - TEAM_MEMBER</li>
     * <li><code>LIMITED_TEAM_MEMBER</code> - LIMITED_TEAM_MEMBER</li>
     * <li><code>INTERVIEWER</code> - INTERVIEWER</li>
     * </ul>
     */
    @JsonProperty("access_role")
    public Optional<RemoteUserAccessRole> getAccessRole() {
        return accessRole;
    }

    /**
     * @return Indicates whether or not this object has been deleted by third party webhooks.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
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
        return other instanceof RemoteUser && equalTo((RemoteUser) other);
    }

    private boolean equalTo(RemoteUser other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && email.equals(other.email)
                && disabled.equals(other.disabled)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && accessRole.equals(other.accessRole)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.firstName,
                this.lastName,
                this.email,
                this.disabled,
                this.remoteCreatedAt,
                this.accessRole,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "RemoteUser{" + "id: " + id + ", remoteId: " + remoteId + ", firstName: " + firstName + ", lastName: "
                + lastName + ", email: " + email + ", disabled: " + disabled + ", remoteCreatedAt: " + remoteCreatedAt
                + ", accessRole: " + accessRole + ", remoteWasDeleted: " + remoteWasDeleted + ", modifiedAt: "
                + modifiedAt + ", fieldMappings: " + fieldMappings + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> firstName = Optional.empty();

        private Optional<String> lastName = Optional.empty();

        private Optional<String> email = Optional.empty();

        private Optional<Boolean> disabled = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<RemoteUserAccessRole> accessRole = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(RemoteUser other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            firstName(other.getFirstName());
            lastName(other.getLastName());
            email(other.getEmail());
            disabled(other.getDisabled());
            remoteCreatedAt(other.getRemoteCreatedAt());
            accessRole(other.getAccessRole());
            remoteWasDeleted(other.getRemoteWasDeleted());
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

        @JsonSetter(value = "first_name", nulls = Nulls.SKIP)
        public Builder firstName(Optional<String> firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = Optional.of(firstName);
            return this;
        }

        @JsonSetter(value = "last_name", nulls = Nulls.SKIP)
        public Builder lastName(Optional<String> lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = Optional.of(lastName);
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

        @JsonSetter(value = "disabled", nulls = Nulls.SKIP)
        public Builder disabled(Optional<Boolean> disabled) {
            this.disabled = disabled;
            return this;
        }

        public Builder disabled(Boolean disabled) {
            this.disabled = Optional.of(disabled);
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

        @JsonSetter(value = "access_role", nulls = Nulls.SKIP)
        public Builder accessRole(Optional<RemoteUserAccessRole> accessRole) {
            this.accessRole = accessRole;
            return this;
        }

        public Builder accessRole(RemoteUserAccessRole accessRole) {
            this.accessRole = Optional.of(accessRole);
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

        public RemoteUser build() {
            return new RemoteUser(
                    id,
                    remoteId,
                    firstName,
                    lastName,
                    email,
                    disabled,
                    remoteCreatedAt,
                    accessRole,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

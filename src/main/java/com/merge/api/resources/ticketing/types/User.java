package com.merge.api.resources.ticketing.types;

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
@JsonDeserialize(builder = User.Builder.class)
public final class User {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> name;

    private final Optional<String> emailAddress;

    private final Optional<Boolean> isActive;

    private final Optional<List<Optional<UserTeamsItem>>> teams;

    private final Optional<String> avatar;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private User(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> name,
            Optional<String> emailAddress,
            Optional<Boolean> isActive,
            Optional<List<Optional<UserTeamsItem>>> teams,
            Optional<String> avatar,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.name = name;
        this.emailAddress = emailAddress;
        this.isActive = isActive;
        this.teams = teams;
        this.avatar = avatar;
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
     * @return The user's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The user's email address.
     */
    @JsonProperty("email_address")
    public Optional<String> getEmailAddress() {
        return emailAddress;
    }

    /**
     * @return Whether or not the user is active.
     */
    @JsonProperty("is_active")
    public Optional<Boolean> getIsActive() {
        return isActive;
    }

    @JsonProperty("teams")
    public Optional<List<Optional<UserTeamsItem>>> getTeams() {
        return teams;
    }

    /**
     * @return The user's avatar picture.
     */
    @JsonProperty("avatar")
    public Optional<String> getAvatar() {
        return avatar;
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
        return other instanceof User && equalTo((User) other);
    }

    private boolean equalTo(User other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && name.equals(other.name)
                && emailAddress.equals(other.emailAddress)
                && isActive.equals(other.isActive)
                && teams.equals(other.teams)
                && avatar.equals(other.avatar)
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
                this.name,
                this.emailAddress,
                this.isActive,
                this.teams,
                this.avatar,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "User{" + "id: " + id + ", remoteId: " + remoteId + ", name: " + name + ", emailAddress: " + emailAddress
                + ", isActive: " + isActive + ", teams: " + teams + ", avatar: " + avatar + ", remoteWasDeleted: "
                + remoteWasDeleted + ", modifiedAt: " + modifiedAt + ", fieldMappings: " + fieldMappings
                + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> emailAddress = Optional.empty();

        private Optional<Boolean> isActive = Optional.empty();

        private Optional<List<Optional<UserTeamsItem>>> teams = Optional.empty();

        private Optional<String> avatar = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(User other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            name(other.getName());
            emailAddress(other.getEmailAddress());
            isActive(other.getIsActive());
            teams(other.getTeams());
            avatar(other.getAvatar());
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "email_address", nulls = Nulls.SKIP)
        public Builder emailAddress(Optional<String> emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = Optional.of(emailAddress);
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

        @JsonSetter(value = "teams", nulls = Nulls.SKIP)
        public Builder teams(Optional<List<Optional<UserTeamsItem>>> teams) {
            this.teams = teams;
            return this;
        }

        public Builder teams(List<Optional<UserTeamsItem>> teams) {
            this.teams = Optional.of(teams);
            return this;
        }

        @JsonSetter(value = "avatar", nulls = Nulls.SKIP)
        public Builder avatar(Optional<String> avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder avatar(String avatar) {
            this.avatar = Optional.of(avatar);
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

        public User build() {
            return new User(
                    id,
                    remoteId,
                    name,
                    emailAddress,
                    isActive,
                    teams,
                    avatar,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

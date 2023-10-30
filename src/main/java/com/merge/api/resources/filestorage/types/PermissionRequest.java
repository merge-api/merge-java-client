package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PermissionRequest.Builder.class)
public final class PermissionRequest {
    private final Optional<String> remoteId;

    private final Optional<PermissionRequestUser> user;

    private final Optional<PermissionRequestGroup> group;

    private final Optional<PermissionRequestType> type;

    private final Optional<List<Optional<PermissionRequestRolesItem>>> roles;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private PermissionRequest(
            Optional<String> remoteId,
            Optional<PermissionRequestUser> user,
            Optional<PermissionRequestGroup> group,
            Optional<PermissionRequestType> type,
            Optional<List<Optional<PermissionRequestRolesItem>>> roles,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.remoteId = remoteId;
        this.user = user;
        this.group = group;
        this.type = type;
        this.roles = roles;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return The user that is granted this permission.
     */
    @JsonProperty("user")
    public Optional<PermissionRequestUser> getUser() {
        return user;
    }

    /**
     * @return The group that is granted this permission.
     */
    @JsonProperty("group")
    public Optional<PermissionRequestGroup> getGroup() {
        return group;
    }

    /**
     * @return Denotes what type of people have access to the file.
     * <ul>
     * <li><code>USER</code> - USER</li>
     * <li><code>GROUP</code> - GROUP</li>
     * <li><code>COMPANY</code> - COMPANY</li>
     * <li><code>ANYONE</code> - ANYONE</li>
     * </ul>
     */
    @JsonProperty("type")
    public Optional<PermissionRequestType> getType() {
        return type;
    }

    /**
     * @return The permissions that the user or group has for the File or Folder. It is possible for a user or group to have multiple roles, such as viewing &amp; uploading. Possible values include: <code>READ</code>, <code>WRITE</code>, <code>OWNER</code>. In cases where there is no clear mapping, the original value passed through will be returned.
     */
    @JsonProperty("roles")
    public Optional<List<Optional<PermissionRequestRolesItem>>> getRoles() {
        return roles;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PermissionRequest && equalTo((PermissionRequest) other);
    }

    private boolean equalTo(PermissionRequest other) {
        return remoteId.equals(other.remoteId)
                && user.equals(other.user)
                && group.equals(other.group)
                && type.equals(other.type)
                && roles.equals(other.roles)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.remoteId,
                this.user,
                this.group,
                this.type,
                this.roles,
                this.integrationParams,
                this.linkedAccountParams);
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
        private Optional<String> remoteId = Optional.empty();

        private Optional<PermissionRequestUser> user = Optional.empty();

        private Optional<PermissionRequestGroup> group = Optional.empty();

        private Optional<PermissionRequestType> type = Optional.empty();

        private Optional<List<Optional<PermissionRequestRolesItem>>> roles = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(PermissionRequest other) {
            remoteId(other.getRemoteId());
            user(other.getUser());
            group(other.getGroup());
            type(other.getType());
            roles(other.getRoles());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
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

        @JsonSetter(value = "user", nulls = Nulls.SKIP)
        public Builder user(Optional<PermissionRequestUser> user) {
            this.user = user;
            return this;
        }

        public Builder user(PermissionRequestUser user) {
            this.user = Optional.of(user);
            return this;
        }

        @JsonSetter(value = "group", nulls = Nulls.SKIP)
        public Builder group(Optional<PermissionRequestGroup> group) {
            this.group = group;
            return this;
        }

        public Builder group(PermissionRequestGroup group) {
            this.group = Optional.of(group);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<PermissionRequestType> type) {
            this.type = type;
            return this;
        }

        public Builder type(PermissionRequestType type) {
            this.type = Optional.of(type);
            return this;
        }

        @JsonSetter(value = "roles", nulls = Nulls.SKIP)
        public Builder roles(Optional<List<Optional<PermissionRequestRolesItem>>> roles) {
            this.roles = roles;
            return this;
        }

        public Builder roles(List<Optional<PermissionRequestRolesItem>> roles) {
            this.roles = Optional.of(roles);
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

        public PermissionRequest build() {
            return new PermissionRequest(remoteId, user, group, type, roles, integrationParams, linkedAccountParams);
        }
    }
}

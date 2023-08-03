package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FolderRequest.Builder.class)
public final class FolderRequest {
    private final Optional<String> name;

    private final Optional<String> folderUrl;

    private final Optional<Integer> size;

    private final Optional<String> description;

    private final Optional<String> parentFolder;

    private final Optional<String> drive;

    private final List<String> permissions;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private FolderRequest(
            Optional<String> name,
            Optional<String> folderUrl,
            Optional<Integer> size,
            Optional<String> description,
            Optional<String> parentFolder,
            Optional<String> drive,
            List<String> permissions,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.name = name;
        this.folderUrl = folderUrl;
        this.size = size;
        this.description = description;
        this.parentFolder = parentFolder;
        this.drive = drive;
        this.permissions = permissions;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The folder's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The URL to access the folder.
     */
    @JsonProperty("folder_url")
    public Optional<String> getFolderUrl() {
        return folderUrl;
    }

    /**
     * @return The folder's size, in bytes.
     */
    @JsonProperty("size")
    public Optional<Integer> getSize() {
        return size;
    }

    /**
     * @return The folder's description.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The folder that the folder belongs to.
     */
    @JsonProperty("parent_folder")
    public Optional<String> getParentFolder() {
        return parentFolder;
    }

    /**
     * @return The drive that the folder belongs to.
     */
    @JsonProperty("drive")
    public Optional<String> getDrive() {
        return drive;
    }

    /**
     * @return The Permission object is used to represent a user's or group's access to a File or Folder. Permissions are unexpanded by default. Use the query param <code>expand=permissions</code> to see more details under <code>GET /folders</code>.
     */
    @JsonProperty("permissions")
    public List<String> getPermissions() {
        return permissions;
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
        return other instanceof FolderRequest && equalTo((FolderRequest) other);
    }

    private boolean equalTo(FolderRequest other) {
        return name.equals(other.name)
                && folderUrl.equals(other.folderUrl)
                && size.equals(other.size)
                && description.equals(other.description)
                && parentFolder.equals(other.parentFolder)
                && drive.equals(other.drive)
                && permissions.equals(other.permissions)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.name,
                this.folderUrl,
                this.size,
                this.description,
                this.parentFolder,
                this.drive,
                this.permissions,
                this.integrationParams,
                this.linkedAccountParams);
    }

    @Override
    public String toString() {
        return "FolderRequest{" + "name: " + name + ", folderUrl: " + folderUrl + ", size: " + size + ", description: "
                + description + ", parentFolder: " + parentFolder + ", drive: " + drive + ", permissions: "
                + permissions + ", integrationParams: " + integrationParams + ", linkedAccountParams: "
                + linkedAccountParams + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> name = Optional.empty();

        private Optional<String> folderUrl = Optional.empty();

        private Optional<Integer> size = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> parentFolder = Optional.empty();

        private Optional<String> drive = Optional.empty();

        private List<String> permissions = new ArrayList<>();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(FolderRequest other) {
            name(other.getName());
            folderUrl(other.getFolderUrl());
            size(other.getSize());
            description(other.getDescription());
            parentFolder(other.getParentFolder());
            drive(other.getDrive());
            permissions(other.getPermissions());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
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

        @JsonSetter(value = "folder_url", nulls = Nulls.SKIP)
        public Builder folderUrl(Optional<String> folderUrl) {
            this.folderUrl = folderUrl;
            return this;
        }

        public Builder folderUrl(String folderUrl) {
            this.folderUrl = Optional.of(folderUrl);
            return this;
        }

        @JsonSetter(value = "size", nulls = Nulls.SKIP)
        public Builder size(Optional<Integer> size) {
            this.size = size;
            return this;
        }

        public Builder size(Integer size) {
            this.size = Optional.of(size);
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

        @JsonSetter(value = "parent_folder", nulls = Nulls.SKIP)
        public Builder parentFolder(Optional<String> parentFolder) {
            this.parentFolder = parentFolder;
            return this;
        }

        public Builder parentFolder(String parentFolder) {
            this.parentFolder = Optional.of(parentFolder);
            return this;
        }

        @JsonSetter(value = "drive", nulls = Nulls.SKIP)
        public Builder drive(Optional<String> drive) {
            this.drive = drive;
            return this;
        }

        public Builder drive(String drive) {
            this.drive = Optional.of(drive);
            return this;
        }

        @JsonSetter(value = "permissions", nulls = Nulls.SKIP)
        public Builder permissions(List<String> permissions) {
            this.permissions.clear();
            this.permissions.addAll(permissions);
            return this;
        }

        public Builder addPermissions(String permissions) {
            this.permissions.add(permissions);
            return this;
        }

        public Builder addAllPermissions(List<String> permissions) {
            this.permissions.addAll(permissions);
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

        public FolderRequest build() {
            return new FolderRequest(
                    name,
                    folderUrl,
                    size,
                    description,
                    parentFolder,
                    drive,
                    permissions,
                    integrationParams,
                    linkedAccountParams);
        }
    }
}

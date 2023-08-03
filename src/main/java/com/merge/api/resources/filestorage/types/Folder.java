package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Folder.Builder.class)
public final class Folder {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> name;

    private final Optional<String> folderUrl;

    private final Optional<Integer> size;

    private final Optional<String> description;

    private final Optional<String> parentFolder;

    private final Optional<String> drive;

    private final List<String> permissions;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<Optional<Map<String, JsonNode>>>> remoteData;

    private Folder(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> name,
            Optional<String> folderUrl,
            Optional<Integer> size,
            Optional<String> description,
            Optional<String> parentFolder,
            Optional<String> drive,
            List<String> permissions,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<Optional<Map<String, JsonNode>>>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.name = name;
        this.folderUrl = folderUrl;
        this.size = size;
        this.description = description;
        this.parentFolder = parentFolder;
        this.drive = drive;
        this.permissions = permissions;
        this.remoteCreatedAt = remoteCreatedAt;
        this.remoteUpdatedAt = remoteUpdatedAt;
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

    /**
     * @return When the third party's folder was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return When the third party's folder was updated.
     */
    @JsonProperty("remote_updated_at")
    public Optional<OffsetDateTime> getRemoteUpdatedAt() {
        return remoteUpdatedAt;
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
    public Optional<List<Optional<Map<String, JsonNode>>>> getRemoteData() {
        return remoteData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Folder && equalTo((Folder) other);
    }

    private boolean equalTo(Folder other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && name.equals(other.name)
                && folderUrl.equals(other.folderUrl)
                && size.equals(other.size)
                && description.equals(other.description)
                && parentFolder.equals(other.parentFolder)
                && drive.equals(other.drive)
                && permissions.equals(other.permissions)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && remoteUpdatedAt.equals(other.remoteUpdatedAt)
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
                this.folderUrl,
                this.size,
                this.description,
                this.parentFolder,
                this.drive,
                this.permissions,
                this.remoteCreatedAt,
                this.remoteUpdatedAt,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "Folder{" + "id: " + id + ", remoteId: " + remoteId + ", name: " + name + ", folderUrl: " + folderUrl
                + ", size: " + size + ", description: " + description + ", parentFolder: " + parentFolder + ", drive: "
                + drive + ", permissions: " + permissions + ", remoteCreatedAt: " + remoteCreatedAt
                + ", remoteUpdatedAt: " + remoteUpdatedAt + ", remoteWasDeleted: " + remoteWasDeleted + ", modifiedAt: "
                + modifiedAt + ", fieldMappings: " + fieldMappings + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> folderUrl = Optional.empty();

        private Optional<Integer> size = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> parentFolder = Optional.empty();

        private Optional<String> drive = Optional.empty();

        private List<String> permissions = new ArrayList<>();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<Optional<Map<String, JsonNode>>>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Folder other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            name(other.getName());
            folderUrl(other.getFolderUrl());
            size(other.getSize());
            description(other.getDescription());
            parentFolder(other.getParentFolder());
            drive(other.getDrive());
            permissions(other.getPermissions());
            remoteCreatedAt(other.getRemoteCreatedAt());
            remoteUpdatedAt(other.getRemoteUpdatedAt());
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
        public Builder remoteData(Optional<List<Optional<Map<String, JsonNode>>>> remoteData) {
            this.remoteData = remoteData;
            return this;
        }

        public Builder remoteData(List<Optional<Map<String, JsonNode>>> remoteData) {
            this.remoteData = Optional.of(remoteData);
            return this;
        }

        public Folder build() {
            return new Folder(
                    id,
                    remoteId,
                    name,
                    folderUrl,
                    size,
                    description,
                    parentFolder,
                    drive,
                    permissions,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

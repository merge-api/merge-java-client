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
@JsonDeserialize(builder = File.Builder.class)
public final class File {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> name;

    private final Optional<String> fileUrl;

    private final Optional<String> fileThumbnailUrl;

    private final Optional<Integer> size;

    private final Optional<String> mimeType;

    private final Optional<String> description;

    private final Optional<String> folder;

    private final List<String> permissions;

    private final Optional<String> drive;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<Optional<Map<String, JsonNode>>>> remoteData;

    private File(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> name,
            Optional<String> fileUrl,
            Optional<String> fileThumbnailUrl,
            Optional<Integer> size,
            Optional<String> mimeType,
            Optional<String> description,
            Optional<String> folder,
            List<String> permissions,
            Optional<String> drive,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<Optional<Map<String, JsonNode>>>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.name = name;
        this.fileUrl = fileUrl;
        this.fileThumbnailUrl = fileThumbnailUrl;
        this.size = size;
        this.mimeType = mimeType;
        this.description = description;
        this.folder = folder;
        this.permissions = permissions;
        this.drive = drive;
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
     * @return The file's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The URL to access the file.
     */
    @JsonProperty("file_url")
    public Optional<String> getFileUrl() {
        return fileUrl;
    }

    /**
     * @return The URL that produces a thumbnail preview of the file. Typically an image.
     */
    @JsonProperty("file_thumbnail_url")
    public Optional<String> getFileThumbnailUrl() {
        return fileThumbnailUrl;
    }

    /**
     * @return The file's size, in bytes.
     */
    @JsonProperty("size")
    public Optional<Integer> getSize() {
        return size;
    }

    /**
     * @return The file's mime type.
     */
    @JsonProperty("mime_type")
    public Optional<String> getMimeType() {
        return mimeType;
    }

    /**
     * @return The file's description.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The folder that the file belongs to.
     */
    @JsonProperty("folder")
    public Optional<String> getFolder() {
        return folder;
    }

    /**
     * @return The Permission object is used to represent a user's or group's access to a File or Folder. Permissions are unexpanded by default. Use the query param <code>expand=permissions</code> to see more details under <code>GET /files</code>.
     */
    @JsonProperty("permissions")
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     * @return The drive that the file belongs to.
     */
    @JsonProperty("drive")
    public Optional<String> getDrive() {
        return drive;
    }

    /**
     * @return When the third party's file was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return When the third party's file was updated.
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
        return other instanceof File && equalTo((File) other);
    }

    private boolean equalTo(File other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && name.equals(other.name)
                && fileUrl.equals(other.fileUrl)
                && fileThumbnailUrl.equals(other.fileThumbnailUrl)
                && size.equals(other.size)
                && mimeType.equals(other.mimeType)
                && description.equals(other.description)
                && folder.equals(other.folder)
                && permissions.equals(other.permissions)
                && drive.equals(other.drive)
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
                this.fileUrl,
                this.fileThumbnailUrl,
                this.size,
                this.mimeType,
                this.description,
                this.folder,
                this.permissions,
                this.drive,
                this.remoteCreatedAt,
                this.remoteUpdatedAt,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "File{" + "id: " + id + ", remoteId: " + remoteId + ", name: " + name + ", fileUrl: " + fileUrl
                + ", fileThumbnailUrl: " + fileThumbnailUrl + ", size: " + size + ", mimeType: " + mimeType
                + ", description: " + description + ", folder: " + folder + ", permissions: " + permissions
                + ", drive: " + drive + ", remoteCreatedAt: " + remoteCreatedAt + ", remoteUpdatedAt: "
                + remoteUpdatedAt + ", remoteWasDeleted: " + remoteWasDeleted + ", modifiedAt: " + modifiedAt
                + ", fieldMappings: " + fieldMappings + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> fileUrl = Optional.empty();

        private Optional<String> fileThumbnailUrl = Optional.empty();

        private Optional<Integer> size = Optional.empty();

        private Optional<String> mimeType = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> folder = Optional.empty();

        private List<String> permissions = new ArrayList<>();

        private Optional<String> drive = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<Optional<Map<String, JsonNode>>>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(File other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            name(other.getName());
            fileUrl(other.getFileUrl());
            fileThumbnailUrl(other.getFileThumbnailUrl());
            size(other.getSize());
            mimeType(other.getMimeType());
            description(other.getDescription());
            folder(other.getFolder());
            permissions(other.getPermissions());
            drive(other.getDrive());
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

        @JsonSetter(value = "file_url", nulls = Nulls.SKIP)
        public Builder fileUrl(Optional<String> fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        public Builder fileUrl(String fileUrl) {
            this.fileUrl = Optional.of(fileUrl);
            return this;
        }

        @JsonSetter(value = "file_thumbnail_url", nulls = Nulls.SKIP)
        public Builder fileThumbnailUrl(Optional<String> fileThumbnailUrl) {
            this.fileThumbnailUrl = fileThumbnailUrl;
            return this;
        }

        public Builder fileThumbnailUrl(String fileThumbnailUrl) {
            this.fileThumbnailUrl = Optional.of(fileThumbnailUrl);
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

        @JsonSetter(value = "mime_type", nulls = Nulls.SKIP)
        public Builder mimeType(Optional<String> mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Builder mimeType(String mimeType) {
            this.mimeType = Optional.of(mimeType);
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

        @JsonSetter(value = "folder", nulls = Nulls.SKIP)
        public Builder folder(Optional<String> folder) {
            this.folder = folder;
            return this;
        }

        public Builder folder(String folder) {
            this.folder = Optional.of(folder);
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

        @JsonSetter(value = "drive", nulls = Nulls.SKIP)
        public Builder drive(Optional<String> drive) {
            this.drive = drive;
            return this;
        }

        public Builder drive(String drive) {
            this.drive = Optional.of(drive);
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

        public File build() {
            return new File(
                    id,
                    remoteId,
                    name,
                    fileUrl,
                    fileThumbnailUrl,
                    size,
                    mimeType,
                    description,
                    folder,
                    permissions,
                    drive,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

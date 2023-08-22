package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FileRequest.Builder.class)
public final class FileRequest {
    private final Optional<String> name;

    private final Optional<String> fileUrl;

    private final Optional<String> fileThumbnailUrl;

    private final Optional<Integer> size;

    private final Optional<String> mimeType;

    private final Optional<String> description;

    private final Optional<String> folder;

    private final List<String> permissions;

    private final Optional<String> drive;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private FileRequest(
            Optional<String> name,
            Optional<String> fileUrl,
            Optional<String> fileThumbnailUrl,
            Optional<Integer> size,
            Optional<String> mimeType,
            Optional<String> description,
            Optional<String> folder,
            List<String> permissions,
            Optional<String> drive,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.name = name;
        this.fileUrl = fileUrl;
        this.fileThumbnailUrl = fileThumbnailUrl;
        this.size = size;
        this.mimeType = mimeType;
        this.description = description;
        this.folder = folder;
        this.permissions = permissions;
        this.drive = drive;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
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
        return other instanceof FileRequest && equalTo((FileRequest) other);
    }

    private boolean equalTo(FileRequest other) {
        return name.equals(other.name)
                && fileUrl.equals(other.fileUrl)
                && fileThumbnailUrl.equals(other.fileThumbnailUrl)
                && size.equals(other.size)
                && mimeType.equals(other.mimeType)
                && description.equals(other.description)
                && folder.equals(other.folder)
                && permissions.equals(other.permissions)
                && drive.equals(other.drive)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.name,
                this.fileUrl,
                this.fileThumbnailUrl,
                this.size,
                this.mimeType,
                this.description,
                this.folder,
                this.permissions,
                this.drive,
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
        private Optional<String> name = Optional.empty();

        private Optional<String> fileUrl = Optional.empty();

        private Optional<String> fileThumbnailUrl = Optional.empty();

        private Optional<Integer> size = Optional.empty();

        private Optional<String> mimeType = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> folder = Optional.empty();

        private List<String> permissions = new ArrayList<>();

        private Optional<String> drive = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(FileRequest other) {
            name(other.getName());
            fileUrl(other.getFileUrl());
            fileThumbnailUrl(other.getFileThumbnailUrl());
            size(other.getSize());
            mimeType(other.getMimeType());
            description(other.getDescription());
            folder(other.getFolder());
            permissions(other.getPermissions());
            drive(other.getDrive());
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

        public FileRequest build() {
            return new FileRequest(
                    name,
                    fileUrl,
                    fileThumbnailUrl,
                    size,
                    mimeType,
                    description,
                    folder,
                    permissions,
                    drive,
                    integrationParams,
                    linkedAccountParams);
        }
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.filestorage.files.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import com.merge.api.resources.filestorage.files.types.FilesListRequestExpand;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FilesListRequest.Builder.class)
public final class FilesListRequest {
    private final Optional<OffsetDateTime> createdAfter;

    private final Optional<OffsetDateTime> createdBefore;

    private final Optional<String> cursor;

    private final Optional<String> driveId;

    private final Optional<FilesListRequestExpand> expand;

    private final Optional<String> folderId;

    private final Optional<Boolean> includeDeletedData;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeShellData;

    private final Optional<String> mimeType;

    private final Optional<OffsetDateTime> modifiedAfter;

    private final Optional<OffsetDateTime> modifiedBefore;

    private final Optional<String> name;

    private final Optional<Integer> pageSize;

    private final Optional<String> remoteId;

    private final Map<String, Object> additionalProperties;

    private FilesListRequest(
            Optional<OffsetDateTime> createdAfter,
            Optional<OffsetDateTime> createdBefore,
            Optional<String> cursor,
            Optional<String> driveId,
            Optional<FilesListRequestExpand> expand,
            Optional<String> folderId,
            Optional<Boolean> includeDeletedData,
            Optional<Boolean> includeRemoteData,
            Optional<Boolean> includeShellData,
            Optional<String> mimeType,
            Optional<OffsetDateTime> modifiedAfter,
            Optional<OffsetDateTime> modifiedBefore,
            Optional<String> name,
            Optional<Integer> pageSize,
            Optional<String> remoteId,
            Map<String, Object> additionalProperties) {
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.cursor = cursor;
        this.driveId = driveId;
        this.expand = expand;
        this.folderId = folderId;
        this.includeDeletedData = includeDeletedData;
        this.includeRemoteData = includeRemoteData;
        this.includeShellData = includeShellData;
        this.mimeType = mimeType;
        this.modifiedAfter = modifiedAfter;
        this.modifiedBefore = modifiedBefore;
        this.name = name;
        this.pageSize = pageSize;
        this.remoteId = remoteId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return If provided, will only return objects created after this datetime.
     */
    @JsonProperty("created_after")
    public Optional<OffsetDateTime> getCreatedAfter() {
        return createdAfter;
    }

    /**
     * @return If provided, will only return objects created before this datetime.
     */
    @JsonProperty("created_before")
    public Optional<OffsetDateTime> getCreatedBefore() {
        return createdBefore;
    }

    /**
     * @return The pagination cursor value.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return Specifying a drive id returns only the files in that drive. Specifying null returns only the files outside the top-level drive.
     */
    @JsonProperty("drive_id")
    public Optional<String> getDriveId() {
        return driveId;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<FilesListRequestExpand> getExpand() {
        return expand;
    }

    /**
     * @return Specifying a folder id returns only the files in that folder. Specifying null returns only the files in root directory.
     */
    @JsonProperty("folder_id")
    public Optional<String> getFolderId() {
        return folderId;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
     */
    @JsonProperty("include_deleted_data")
    public Optional<Boolean> getIncludeDeletedData() {
        return includeDeletedData;
    }

    /**
     * @return Whether to include the original data Merge fetched from the third-party to produce these models.
     */
    @JsonProperty("include_remote_data")
    public Optional<Boolean> getIncludeRemoteData() {
        return includeRemoteData;
    }

    /**
     * @return Whether to include shell records. Shell records are empty records (they may contain some metadata but all other fields are null).
     */
    @JsonProperty("include_shell_data")
    public Optional<Boolean> getIncludeShellData() {
        return includeShellData;
    }

    /**
     * @return If provided, will only return files with these mime_types. Multiple values can be separated by commas.
     */
    @JsonProperty("mime_type")
    public Optional<String> getMimeType() {
        return mimeType;
    }

    /**
     * @return If provided, only objects synced by Merge after this date time will be returned.
     */
    @JsonProperty("modified_after")
    public Optional<OffsetDateTime> getModifiedAfter() {
        return modifiedAfter;
    }

    /**
     * @return If provided, only objects synced by Merge before this date time will be returned.
     */
    @JsonProperty("modified_before")
    public Optional<OffsetDateTime> getModifiedBefore() {
        return modifiedBefore;
    }

    /**
     * @return If provided, will only return files with this name. This performs an exact match.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return Number of results to return per page.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    /**
     * @return The API provider's ID for the given object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FilesListRequest && equalTo((FilesListRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FilesListRequest other) {
        return createdAfter.equals(other.createdAfter)
                && createdBefore.equals(other.createdBefore)
                && cursor.equals(other.cursor)
                && driveId.equals(other.driveId)
                && expand.equals(other.expand)
                && folderId.equals(other.folderId)
                && includeDeletedData.equals(other.includeDeletedData)
                && includeRemoteData.equals(other.includeRemoteData)
                && includeShellData.equals(other.includeShellData)
                && mimeType.equals(other.mimeType)
                && modifiedAfter.equals(other.modifiedAfter)
                && modifiedBefore.equals(other.modifiedBefore)
                && name.equals(other.name)
                && pageSize.equals(other.pageSize)
                && remoteId.equals(other.remoteId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.createdAfter,
                this.createdBefore,
                this.cursor,
                this.driveId,
                this.expand,
                this.folderId,
                this.includeDeletedData,
                this.includeRemoteData,
                this.includeShellData,
                this.mimeType,
                this.modifiedAfter,
                this.modifiedBefore,
                this.name,
                this.pageSize,
                this.remoteId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<OffsetDateTime> createdAfter = Optional.empty();

        private Optional<OffsetDateTime> createdBefore = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<String> driveId = Optional.empty();

        private Optional<FilesListRequestExpand> expand = Optional.empty();

        private Optional<String> folderId = Optional.empty();

        private Optional<Boolean> includeDeletedData = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeShellData = Optional.empty();

        private Optional<String> mimeType = Optional.empty();

        private Optional<OffsetDateTime> modifiedAfter = Optional.empty();

        private Optional<OffsetDateTime> modifiedBefore = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(FilesListRequest other) {
            createdAfter(other.getCreatedAfter());
            createdBefore(other.getCreatedBefore());
            cursor(other.getCursor());
            driveId(other.getDriveId());
            expand(other.getExpand());
            folderId(other.getFolderId());
            includeDeletedData(other.getIncludeDeletedData());
            includeRemoteData(other.getIncludeRemoteData());
            includeShellData(other.getIncludeShellData());
            mimeType(other.getMimeType());
            modifiedAfter(other.getModifiedAfter());
            modifiedBefore(other.getModifiedBefore());
            name(other.getName());
            pageSize(other.getPageSize());
            remoteId(other.getRemoteId());
            return this;
        }

        @JsonSetter(value = "created_after", nulls = Nulls.SKIP)
        public Builder createdAfter(Optional<OffsetDateTime> createdAfter) {
            this.createdAfter = createdAfter;
            return this;
        }

        public Builder createdAfter(OffsetDateTime createdAfter) {
            this.createdAfter = Optional.of(createdAfter);
            return this;
        }

        @JsonSetter(value = "created_before", nulls = Nulls.SKIP)
        public Builder createdBefore(Optional<OffsetDateTime> createdBefore) {
            this.createdBefore = createdBefore;
            return this;
        }

        public Builder createdBefore(OffsetDateTime createdBefore) {
            this.createdBefore = Optional.of(createdBefore);
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.of(cursor);
            return this;
        }

        @JsonSetter(value = "drive_id", nulls = Nulls.SKIP)
        public Builder driveId(Optional<String> driveId) {
            this.driveId = driveId;
            return this;
        }

        public Builder driveId(String driveId) {
            this.driveId = Optional.of(driveId);
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<FilesListRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(FilesListRequestExpand expand) {
            this.expand = Optional.of(expand);
            return this;
        }

        @JsonSetter(value = "folder_id", nulls = Nulls.SKIP)
        public Builder folderId(Optional<String> folderId) {
            this.folderId = folderId;
            return this;
        }

        public Builder folderId(String folderId) {
            this.folderId = Optional.of(folderId);
            return this;
        }

        @JsonSetter(value = "include_deleted_data", nulls = Nulls.SKIP)
        public Builder includeDeletedData(Optional<Boolean> includeDeletedData) {
            this.includeDeletedData = includeDeletedData;
            return this;
        }

        public Builder includeDeletedData(Boolean includeDeletedData) {
            this.includeDeletedData = Optional.of(includeDeletedData);
            return this;
        }

        @JsonSetter(value = "include_remote_data", nulls = Nulls.SKIP)
        public Builder includeRemoteData(Optional<Boolean> includeRemoteData) {
            this.includeRemoteData = includeRemoteData;
            return this;
        }

        public Builder includeRemoteData(Boolean includeRemoteData) {
            this.includeRemoteData = Optional.of(includeRemoteData);
            return this;
        }

        @JsonSetter(value = "include_shell_data", nulls = Nulls.SKIP)
        public Builder includeShellData(Optional<Boolean> includeShellData) {
            this.includeShellData = includeShellData;
            return this;
        }

        public Builder includeShellData(Boolean includeShellData) {
            this.includeShellData = Optional.of(includeShellData);
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

        @JsonSetter(value = "modified_after", nulls = Nulls.SKIP)
        public Builder modifiedAfter(Optional<OffsetDateTime> modifiedAfter) {
            this.modifiedAfter = modifiedAfter;
            return this;
        }

        public Builder modifiedAfter(OffsetDateTime modifiedAfter) {
            this.modifiedAfter = Optional.of(modifiedAfter);
            return this;
        }

        @JsonSetter(value = "modified_before", nulls = Nulls.SKIP)
        public Builder modifiedBefore(Optional<OffsetDateTime> modifiedBefore) {
            this.modifiedBefore = modifiedBefore;
            return this;
        }

        public Builder modifiedBefore(OffsetDateTime modifiedBefore) {
            this.modifiedBefore = Optional.of(modifiedBefore);
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

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.of(pageSize);
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

        public FilesListRequest build() {
            return new FilesListRequest(
                    createdAfter,
                    createdBefore,
                    cursor,
                    driveId,
                    expand,
                    folderId,
                    includeDeletedData,
                    includeRemoteData,
                    includeShellData,
                    mimeType,
                    modifiedAfter,
                    modifiedBefore,
                    name,
                    pageSize,
                    remoteId,
                    additionalProperties);
        }
    }
}

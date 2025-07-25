/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Attachment.Builder.class)
public final class Attachment {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<String> fileName;

    private final Optional<String> fileUrl;

    private final Optional<String> candidate;

    private final Optional<AttachmentAttachmentType> attachmentType;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private final Map<String, Object> additionalProperties;

    private Attachment(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<String> fileName,
            Optional<String> fileUrl,
            Optional<String> candidate,
            Optional<AttachmentAttachmentType> attachmentType,
            Optional<Boolean> remoteWasDeleted,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.candidate = candidate;
        this.attachmentType = attachmentType;
        this.remoteWasDeleted = remoteWasDeleted;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
        this.additionalProperties = additionalProperties;
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
     * @return The datetime that this object was created by Merge.
     */
    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The datetime that this object was modified by Merge.
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    /**
     * @return The attachment's name.
     */
    @JsonProperty("file_name")
    public Optional<String> getFileName() {
        return fileName;
    }

    /**
     * @return The attachment's url.
     */
    @JsonProperty("file_url")
    public Optional<String> getFileUrl() {
        return fileUrl;
    }

    /**
     * @return
     */
    @JsonProperty("candidate")
    public Optional<String> getCandidate() {
        return candidate;
    }

    /**
     * @return The attachment's type.
     * <ul>
     * <li><code>RESUME</code> - RESUME</li>
     * <li><code>COVER_LETTER</code> - COVER_LETTER</li>
     * <li><code>OFFER_LETTER</code> - OFFER_LETTER</li>
     * <li><code>OTHER</code> - OTHER</li>
     * </ul>
     */
    @JsonProperty("attachment_type")
    public Optional<AttachmentAttachmentType> getAttachmentType() {
        return attachmentType;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    @JsonProperty("field_mappings")
    public Optional<Map<String, JsonNode>> getFieldMappings() {
        return fieldMappings;
    }

    @JsonProperty("remote_data")
    public Optional<List<RemoteData>> getRemoteData() {
        return remoteData;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Attachment && equalTo((Attachment) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Attachment other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && fileName.equals(other.fileName)
                && fileUrl.equals(other.fileUrl)
                && candidate.equals(other.candidate)
                && attachmentType.equals(other.attachmentType)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.createdAt,
                this.modifiedAt,
                this.fileName,
                this.fileUrl,
                this.candidate,
                this.attachmentType,
                this.remoteWasDeleted,
                this.fieldMappings,
                this.remoteData);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<String> fileName = Optional.empty();

        private Optional<String> fileUrl = Optional.empty();

        private Optional<String> candidate = Optional.empty();

        private Optional<AttachmentAttachmentType> attachmentType = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Attachment other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            fileName(other.getFileName());
            fileUrl(other.getFileUrl());
            candidate(other.getCandidate());
            attachmentType(other.getAttachmentType());
            remoteWasDeleted(other.getRemoteWasDeleted());
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
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * <p>The third-party API ID of the matching object.</p>
         */
        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.ofNullable(remoteId);
            return this;
        }

        /**
         * <p>The datetime that this object was created by Merge.</p>
         */
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * <p>The datetime that this object was modified by Merge.</p>
         */
        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.ofNullable(modifiedAt);
            return this;
        }

        /**
         * <p>The attachment's name.</p>
         */
        @JsonSetter(value = "file_name", nulls = Nulls.SKIP)
        public Builder fileName(Optional<String> fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = Optional.ofNullable(fileName);
            return this;
        }

        /**
         * <p>The attachment's url.</p>
         */
        @JsonSetter(value = "file_url", nulls = Nulls.SKIP)
        public Builder fileUrl(Optional<String> fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        public Builder fileUrl(String fileUrl) {
            this.fileUrl = Optional.ofNullable(fileUrl);
            return this;
        }

        @JsonSetter(value = "candidate", nulls = Nulls.SKIP)
        public Builder candidate(Optional<String> candidate) {
            this.candidate = candidate;
            return this;
        }

        public Builder candidate(String candidate) {
            this.candidate = Optional.ofNullable(candidate);
            return this;
        }

        /**
         * <p>The attachment's type.</p>
         * <ul>
         * <li><code>RESUME</code> - RESUME</li>
         * <li><code>COVER_LETTER</code> - COVER_LETTER</li>
         * <li><code>OFFER_LETTER</code> - OFFER_LETTER</li>
         * <li><code>OTHER</code> - OTHER</li>
         * </ul>
         */
        @JsonSetter(value = "attachment_type", nulls = Nulls.SKIP)
        public Builder attachmentType(Optional<AttachmentAttachmentType> attachmentType) {
            this.attachmentType = attachmentType;
            return this;
        }

        public Builder attachmentType(AttachmentAttachmentType attachmentType) {
            this.attachmentType = Optional.ofNullable(attachmentType);
            return this;
        }

        /**
         * <p>Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.</p>
         */
        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.ofNullable(remoteWasDeleted);
            return this;
        }

        @JsonSetter(value = "field_mappings", nulls = Nulls.SKIP)
        public Builder fieldMappings(Optional<Map<String, JsonNode>> fieldMappings) {
            this.fieldMappings = fieldMappings;
            return this;
        }

        public Builder fieldMappings(Map<String, JsonNode> fieldMappings) {
            this.fieldMappings = Optional.ofNullable(fieldMappings);
            return this;
        }

        @JsonSetter(value = "remote_data", nulls = Nulls.SKIP)
        public Builder remoteData(Optional<List<RemoteData>> remoteData) {
            this.remoteData = remoteData;
            return this;
        }

        public Builder remoteData(List<RemoteData> remoteData) {
            this.remoteData = Optional.ofNullable(remoteData);
            return this;
        }

        public Attachment build() {
            return new Attachment(
                    id,
                    remoteId,
                    createdAt,
                    modifiedAt,
                    fileName,
                    fileUrl,
                    candidate,
                    attachmentType,
                    remoteWasDeleted,
                    fieldMappings,
                    remoteData,
                    additionalProperties);
        }
    }
}

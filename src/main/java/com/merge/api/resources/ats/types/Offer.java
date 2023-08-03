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
@JsonDeserialize(builder = Offer.Builder.class)
public final class Offer {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> application;

    private final Optional<String> creator;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<OffsetDateTime> closedAt;

    private final Optional<OffsetDateTime> sentAt;

    private final Optional<OffsetDateTime> startDate;

    private final Optional<OfferStatus> status;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Offer(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> application,
            Optional<String> creator,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<OffsetDateTime> closedAt,
            Optional<OffsetDateTime> sentAt,
            Optional<OffsetDateTime> startDate,
            Optional<OfferStatus> status,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.application = application;
        this.creator = creator;
        this.remoteCreatedAt = remoteCreatedAt;
        this.closedAt = closedAt;
        this.sentAt = sentAt;
        this.startDate = startDate;
        this.status = status;
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
     * @return The application who is receiving the offer.
     */
    @JsonProperty("application")
    public Optional<String> getApplication() {
        return application;
    }

    /**
     * @return The user who created the offer.
     */
    @JsonProperty("creator")
    public Optional<String> getCreator() {
        return creator;
    }

    /**
     * @return When the third party's offer was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return When the offer was closed.
     */
    @JsonProperty("closed_at")
    public Optional<OffsetDateTime> getClosedAt() {
        return closedAt;
    }

    /**
     * @return When the offer was sent.
     */
    @JsonProperty("sent_at")
    public Optional<OffsetDateTime> getSentAt() {
        return sentAt;
    }

    /**
     * @return The employment start date on the offer.
     */
    @JsonProperty("start_date")
    public Optional<OffsetDateTime> getStartDate() {
        return startDate;
    }

    /**
     * @return The offer's status.
     * <ul>
     * <li><code>DRAFT</code> - DRAFT</li>
     * <li><code>APPROVAL-SENT</code> - APPROVAL-SENT</li>
     * <li><code>APPROVED</code> - APPROVED</li>
     * <li><code>SENT</code> - SENT</li>
     * <li><code>SENT-MANUALLY</code> - SENT-MANUALLY</li>
     * <li><code>OPENED</code> - OPENED</li>
     * <li><code>DENIED</code> - DENIED</li>
     * <li><code>SIGNED</code> - SIGNED</li>
     * <li><code>DEPRECATED</code> - DEPRECATED</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<OfferStatus> getStatus() {
        return status;
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
        return other instanceof Offer && equalTo((Offer) other);
    }

    private boolean equalTo(Offer other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && application.equals(other.application)
                && creator.equals(other.creator)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && closedAt.equals(other.closedAt)
                && sentAt.equals(other.sentAt)
                && startDate.equals(other.startDate)
                && status.equals(other.status)
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
                this.application,
                this.creator,
                this.remoteCreatedAt,
                this.closedAt,
                this.sentAt,
                this.startDate,
                this.status,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "Offer{" + "id: " + id + ", remoteId: " + remoteId + ", application: " + application + ", creator: "
                + creator + ", remoteCreatedAt: " + remoteCreatedAt + ", closedAt: " + closedAt + ", sentAt: " + sentAt
                + ", startDate: " + startDate + ", status: " + status + ", remoteWasDeleted: " + remoteWasDeleted
                + ", modifiedAt: " + modifiedAt + ", fieldMappings: " + fieldMappings + ", remoteData: " + remoteData
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> application = Optional.empty();

        private Optional<String> creator = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<OffsetDateTime> closedAt = Optional.empty();

        private Optional<OffsetDateTime> sentAt = Optional.empty();

        private Optional<OffsetDateTime> startDate = Optional.empty();

        private Optional<OfferStatus> status = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Offer other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            application(other.getApplication());
            creator(other.getCreator());
            remoteCreatedAt(other.getRemoteCreatedAt());
            closedAt(other.getClosedAt());
            sentAt(other.getSentAt());
            startDate(other.getStartDate());
            status(other.getStatus());
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

        @JsonSetter(value = "application", nulls = Nulls.SKIP)
        public Builder application(Optional<String> application) {
            this.application = application;
            return this;
        }

        public Builder application(String application) {
            this.application = Optional.of(application);
            return this;
        }

        @JsonSetter(value = "creator", nulls = Nulls.SKIP)
        public Builder creator(Optional<String> creator) {
            this.creator = creator;
            return this;
        }

        public Builder creator(String creator) {
            this.creator = Optional.of(creator);
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

        @JsonSetter(value = "closed_at", nulls = Nulls.SKIP)
        public Builder closedAt(Optional<OffsetDateTime> closedAt) {
            this.closedAt = closedAt;
            return this;
        }

        public Builder closedAt(OffsetDateTime closedAt) {
            this.closedAt = Optional.of(closedAt);
            return this;
        }

        @JsonSetter(value = "sent_at", nulls = Nulls.SKIP)
        public Builder sentAt(Optional<OffsetDateTime> sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        public Builder sentAt(OffsetDateTime sentAt) {
            this.sentAt = Optional.of(sentAt);
            return this;
        }

        @JsonSetter(value = "start_date", nulls = Nulls.SKIP)
        public Builder startDate(Optional<OffsetDateTime> startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder startDate(OffsetDateTime startDate) {
            this.startDate = Optional.of(startDate);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<OfferStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(OfferStatus status) {
            this.status = Optional.of(status);
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

        public Offer build() {
            return new Offer(
                    id,
                    remoteId,
                    application,
                    creator,
                    remoteCreatedAt,
                    closedAt,
                    sentAt,
                    startDate,
                    status,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

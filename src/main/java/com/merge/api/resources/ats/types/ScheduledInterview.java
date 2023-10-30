package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ScheduledInterview.Builder.class)
public final class ScheduledInterview {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<ScheduledInterviewApplication> application;

    private final Optional<ScheduledInterviewJobInterviewStage> jobInterviewStage;

    private final Optional<ScheduledInterviewOrganizer> organizer;

    private final Optional<List<Optional<ScheduledInterviewInterviewersItem>>> interviewers;

    private final Optional<String> location;

    private final Optional<OffsetDateTime> startAt;

    private final Optional<OffsetDateTime> endAt;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<ScheduledInterviewStatus> status;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private ScheduledInterview(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<ScheduledInterviewApplication> application,
            Optional<ScheduledInterviewJobInterviewStage> jobInterviewStage,
            Optional<ScheduledInterviewOrganizer> organizer,
            Optional<List<Optional<ScheduledInterviewInterviewersItem>>> interviewers,
            Optional<String> location,
            Optional<OffsetDateTime> startAt,
            Optional<OffsetDateTime> endAt,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<ScheduledInterviewStatus> status,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.application = application;
        this.jobInterviewStage = jobInterviewStage;
        this.organizer = organizer;
        this.interviewers = interviewers;
        this.location = location;
        this.startAt = startAt;
        this.endAt = endAt;
        this.remoteCreatedAt = remoteCreatedAt;
        this.remoteUpdatedAt = remoteUpdatedAt;
        this.status = status;
        this.remoteWasDeleted = remoteWasDeleted;
        this.createdAt = createdAt;
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
     * @return The application being interviewed.
     */
    @JsonProperty("application")
    public Optional<ScheduledInterviewApplication> getApplication() {
        return application;
    }

    /**
     * @return The stage of the interview.
     */
    @JsonProperty("job_interview_stage")
    public Optional<ScheduledInterviewJobInterviewStage> getJobInterviewStage() {
        return jobInterviewStage;
    }

    /**
     * @return The user organizing the interview.
     */
    @JsonProperty("organizer")
    public Optional<ScheduledInterviewOrganizer> getOrganizer() {
        return organizer;
    }

    /**
     * @return Array of <code>RemoteUser</code> IDs.
     */
    @JsonProperty("interviewers")
    public Optional<List<Optional<ScheduledInterviewInterviewersItem>>> getInterviewers() {
        return interviewers;
    }

    /**
     * @return The interview's location.
     */
    @JsonProperty("location")
    public Optional<String> getLocation() {
        return location;
    }

    /**
     * @return When the interview was started.
     */
    @JsonProperty("start_at")
    public Optional<OffsetDateTime> getStartAt() {
        return startAt;
    }

    /**
     * @return When the interview was ended.
     */
    @JsonProperty("end_at")
    public Optional<OffsetDateTime> getEndAt() {
        return endAt;
    }

    /**
     * @return When the third party's interview was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return When the third party's interview was updated.
     */
    @JsonProperty("remote_updated_at")
    public Optional<OffsetDateTime> getRemoteUpdatedAt() {
        return remoteUpdatedAt;
    }

    /**
     * @return The interview's status.
     * <ul>
     * <li><code>SCHEDULED</code> - SCHEDULED</li>
     * <li><code>AWAITING_FEEDBACK</code> - AWAITING_FEEDBACK</li>
     * <li><code>COMPLETE</code> - COMPLETE</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<ScheduledInterviewStatus> getStatus() {
        return status;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
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
        return other instanceof ScheduledInterview && equalTo((ScheduledInterview) other);
    }

    private boolean equalTo(ScheduledInterview other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && application.equals(other.application)
                && jobInterviewStage.equals(other.jobInterviewStage)
                && organizer.equals(other.organizer)
                && interviewers.equals(other.interviewers)
                && location.equals(other.location)
                && startAt.equals(other.startAt)
                && endAt.equals(other.endAt)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && remoteUpdatedAt.equals(other.remoteUpdatedAt)
                && status.equals(other.status)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && createdAt.equals(other.createdAt)
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
                this.jobInterviewStage,
                this.organizer,
                this.interviewers,
                this.location,
                this.startAt,
                this.endAt,
                this.remoteCreatedAt,
                this.remoteUpdatedAt,
                this.status,
                this.remoteWasDeleted,
                this.createdAt,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<ScheduledInterviewApplication> application = Optional.empty();

        private Optional<ScheduledInterviewJobInterviewStage> jobInterviewStage = Optional.empty();

        private Optional<ScheduledInterviewOrganizer> organizer = Optional.empty();

        private Optional<List<Optional<ScheduledInterviewInterviewersItem>>> interviewers = Optional.empty();

        private Optional<String> location = Optional.empty();

        private Optional<OffsetDateTime> startAt = Optional.empty();

        private Optional<OffsetDateTime> endAt = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<ScheduledInterviewStatus> status = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(ScheduledInterview other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            application(other.getApplication());
            jobInterviewStage(other.getJobInterviewStage());
            organizer(other.getOrganizer());
            interviewers(other.getInterviewers());
            location(other.getLocation());
            startAt(other.getStartAt());
            endAt(other.getEndAt());
            remoteCreatedAt(other.getRemoteCreatedAt());
            remoteUpdatedAt(other.getRemoteUpdatedAt());
            status(other.getStatus());
            remoteWasDeleted(other.getRemoteWasDeleted());
            createdAt(other.getCreatedAt());
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
        public Builder application(Optional<ScheduledInterviewApplication> application) {
            this.application = application;
            return this;
        }

        public Builder application(ScheduledInterviewApplication application) {
            this.application = Optional.of(application);
            return this;
        }

        @JsonSetter(value = "job_interview_stage", nulls = Nulls.SKIP)
        public Builder jobInterviewStage(Optional<ScheduledInterviewJobInterviewStage> jobInterviewStage) {
            this.jobInterviewStage = jobInterviewStage;
            return this;
        }

        public Builder jobInterviewStage(ScheduledInterviewJobInterviewStage jobInterviewStage) {
            this.jobInterviewStage = Optional.of(jobInterviewStage);
            return this;
        }

        @JsonSetter(value = "organizer", nulls = Nulls.SKIP)
        public Builder organizer(Optional<ScheduledInterviewOrganizer> organizer) {
            this.organizer = organizer;
            return this;
        }

        public Builder organizer(ScheduledInterviewOrganizer organizer) {
            this.organizer = Optional.of(organizer);
            return this;
        }

        @JsonSetter(value = "interviewers", nulls = Nulls.SKIP)
        public Builder interviewers(Optional<List<Optional<ScheduledInterviewInterviewersItem>>> interviewers) {
            this.interviewers = interviewers;
            return this;
        }

        public Builder interviewers(List<Optional<ScheduledInterviewInterviewersItem>> interviewers) {
            this.interviewers = Optional.of(interviewers);
            return this;
        }

        @JsonSetter(value = "location", nulls = Nulls.SKIP)
        public Builder location(Optional<String> location) {
            this.location = location;
            return this;
        }

        public Builder location(String location) {
            this.location = Optional.of(location);
            return this;
        }

        @JsonSetter(value = "start_at", nulls = Nulls.SKIP)
        public Builder startAt(Optional<OffsetDateTime> startAt) {
            this.startAt = startAt;
            return this;
        }

        public Builder startAt(OffsetDateTime startAt) {
            this.startAt = Optional.of(startAt);
            return this;
        }

        @JsonSetter(value = "end_at", nulls = Nulls.SKIP)
        public Builder endAt(Optional<OffsetDateTime> endAt) {
            this.endAt = endAt;
            return this;
        }

        public Builder endAt(OffsetDateTime endAt) {
            this.endAt = Optional.of(endAt);
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

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<ScheduledInterviewStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(ScheduledInterviewStatus status) {
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

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
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

        public ScheduledInterview build() {
            return new ScheduledInterview(
                    id,
                    remoteId,
                    application,
                    jobInterviewStage,
                    organizer,
                    interviewers,
                    location,
                    startAt,
                    endAt,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    status,
                    remoteWasDeleted,
                    createdAt,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

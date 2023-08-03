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
@JsonDeserialize(builder = Application.Builder.class)
public final class Application {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> candidate;

    private final Optional<String> job;

    private final Optional<OffsetDateTime> appliedAt;

    private final Optional<OffsetDateTime> rejectedAt;

    private final Optional<String> source;

    private final Optional<String> creditedTo;

    private final Optional<String> currentStage;

    private final Optional<String> rejectReason;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Application(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> candidate,
            Optional<String> job,
            Optional<OffsetDateTime> appliedAt,
            Optional<OffsetDateTime> rejectedAt,
            Optional<String> source,
            Optional<String> creditedTo,
            Optional<String> currentStage,
            Optional<String> rejectReason,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.candidate = candidate;
        this.job = job;
        this.appliedAt = appliedAt;
        this.rejectedAt = rejectedAt;
        this.source = source;
        this.creditedTo = creditedTo;
        this.currentStage = currentStage;
        this.rejectReason = rejectReason;
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
     * @return The candidate applying.
     */
    @JsonProperty("candidate")
    public Optional<String> getCandidate() {
        return candidate;
    }

    /**
     * @return The job being applied for.
     */
    @JsonProperty("job")
    public Optional<String> getJob() {
        return job;
    }

    /**
     * @return When the application was submitted.
     */
    @JsonProperty("applied_at")
    public Optional<OffsetDateTime> getAppliedAt() {
        return appliedAt;
    }

    /**
     * @return When the application was rejected.
     */
    @JsonProperty("rejected_at")
    public Optional<OffsetDateTime> getRejectedAt() {
        return rejectedAt;
    }

    /**
     * @return The application's source.
     */
    @JsonProperty("source")
    public Optional<String> getSource() {
        return source;
    }

    /**
     * @return The user credited for this application.
     */
    @JsonProperty("credited_to")
    public Optional<String> getCreditedTo() {
        return creditedTo;
    }

    /**
     * @return The application's current stage.
     */
    @JsonProperty("current_stage")
    public Optional<String> getCurrentStage() {
        return currentStage;
    }

    /**
     * @return The application's reason for rejection.
     */
    @JsonProperty("reject_reason")
    public Optional<String> getRejectReason() {
        return rejectReason;
    }

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
        return other instanceof Application && equalTo((Application) other);
    }

    private boolean equalTo(Application other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && candidate.equals(other.candidate)
                && job.equals(other.job)
                && appliedAt.equals(other.appliedAt)
                && rejectedAt.equals(other.rejectedAt)
                && source.equals(other.source)
                && creditedTo.equals(other.creditedTo)
                && currentStage.equals(other.currentStage)
                && rejectReason.equals(other.rejectReason)
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
                this.candidate,
                this.job,
                this.appliedAt,
                this.rejectedAt,
                this.source,
                this.creditedTo,
                this.currentStage,
                this.rejectReason,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "Application{" + "id: " + id + ", remoteId: " + remoteId + ", candidate: " + candidate + ", job: " + job
                + ", appliedAt: " + appliedAt + ", rejectedAt: " + rejectedAt + ", source: " + source + ", creditedTo: "
                + creditedTo + ", currentStage: " + currentStage + ", rejectReason: " + rejectReason
                + ", remoteWasDeleted: " + remoteWasDeleted + ", modifiedAt: " + modifiedAt + ", fieldMappings: "
                + fieldMappings + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> candidate = Optional.empty();

        private Optional<String> job = Optional.empty();

        private Optional<OffsetDateTime> appliedAt = Optional.empty();

        private Optional<OffsetDateTime> rejectedAt = Optional.empty();

        private Optional<String> source = Optional.empty();

        private Optional<String> creditedTo = Optional.empty();

        private Optional<String> currentStage = Optional.empty();

        private Optional<String> rejectReason = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Application other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            candidate(other.getCandidate());
            job(other.getJob());
            appliedAt(other.getAppliedAt());
            rejectedAt(other.getRejectedAt());
            source(other.getSource());
            creditedTo(other.getCreditedTo());
            currentStage(other.getCurrentStage());
            rejectReason(other.getRejectReason());
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

        @JsonSetter(value = "candidate", nulls = Nulls.SKIP)
        public Builder candidate(Optional<String> candidate) {
            this.candidate = candidate;
            return this;
        }

        public Builder candidate(String candidate) {
            this.candidate = Optional.of(candidate);
            return this;
        }

        @JsonSetter(value = "job", nulls = Nulls.SKIP)
        public Builder job(Optional<String> job) {
            this.job = job;
            return this;
        }

        public Builder job(String job) {
            this.job = Optional.of(job);
            return this;
        }

        @JsonSetter(value = "applied_at", nulls = Nulls.SKIP)
        public Builder appliedAt(Optional<OffsetDateTime> appliedAt) {
            this.appliedAt = appliedAt;
            return this;
        }

        public Builder appliedAt(OffsetDateTime appliedAt) {
            this.appliedAt = Optional.of(appliedAt);
            return this;
        }

        @JsonSetter(value = "rejected_at", nulls = Nulls.SKIP)
        public Builder rejectedAt(Optional<OffsetDateTime> rejectedAt) {
            this.rejectedAt = rejectedAt;
            return this;
        }

        public Builder rejectedAt(OffsetDateTime rejectedAt) {
            this.rejectedAt = Optional.of(rejectedAt);
            return this;
        }

        @JsonSetter(value = "source", nulls = Nulls.SKIP)
        public Builder source(Optional<String> source) {
            this.source = source;
            return this;
        }

        public Builder source(String source) {
            this.source = Optional.of(source);
            return this;
        }

        @JsonSetter(value = "credited_to", nulls = Nulls.SKIP)
        public Builder creditedTo(Optional<String> creditedTo) {
            this.creditedTo = creditedTo;
            return this;
        }

        public Builder creditedTo(String creditedTo) {
            this.creditedTo = Optional.of(creditedTo);
            return this;
        }

        @JsonSetter(value = "current_stage", nulls = Nulls.SKIP)
        public Builder currentStage(Optional<String> currentStage) {
            this.currentStage = currentStage;
            return this;
        }

        public Builder currentStage(String currentStage) {
            this.currentStage = Optional.of(currentStage);
            return this;
        }

        @JsonSetter(value = "reject_reason", nulls = Nulls.SKIP)
        public Builder rejectReason(Optional<String> rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public Builder rejectReason(String rejectReason) {
            this.rejectReason = Optional.of(rejectReason);
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

        public Application build() {
            return new Application(
                    id,
                    remoteId,
                    candidate,
                    job,
                    appliedAt,
                    rejectedAt,
                    source,
                    creditedTo,
                    currentStage,
                    rejectReason,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

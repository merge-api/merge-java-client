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
@JsonDeserialize(builder = Scorecard.Builder.class)
public final class Scorecard {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<ScorecardApplication> application;

    private final Optional<ScorecardInterview> interview;

    private final Optional<ScorecardInterviewer> interviewer;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<OffsetDateTime> submittedAt;

    private final Optional<ScorecardOverallRecommendation> overallRecommendation;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Scorecard(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<ScorecardApplication> application,
            Optional<ScorecardInterview> interview,
            Optional<ScorecardInterviewer> interviewer,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<OffsetDateTime> submittedAt,
            Optional<ScorecardOverallRecommendation> overallRecommendation,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.application = application;
        this.interview = interview;
        this.interviewer = interviewer;
        this.remoteCreatedAt = remoteCreatedAt;
        this.submittedAt = submittedAt;
        this.overallRecommendation = overallRecommendation;
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
     * @return The application being scored.
     */
    @JsonProperty("application")
    public Optional<ScorecardApplication> getApplication() {
        return application;
    }

    /**
     * @return The interview being scored.
     */
    @JsonProperty("interview")
    public Optional<ScorecardInterview> getInterview() {
        return interview;
    }

    /**
     * @return The interviewer doing the scoring.
     */
    @JsonProperty("interviewer")
    public Optional<ScorecardInterviewer> getInterviewer() {
        return interviewer;
    }

    /**
     * @return When the third party's scorecard was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return When the scorecard was submitted.
     */
    @JsonProperty("submitted_at")
    public Optional<OffsetDateTime> getSubmittedAt() {
        return submittedAt;
    }

    /**
     * @return The inteviewer's recommendation.
     * <ul>
     * <li><code>DEFINITELY_NO</code> - DEFINITELY_NO</li>
     * <li><code>NO</code> - NO</li>
     * <li><code>YES</code> - YES</li>
     * <li><code>STRONG_YES</code> - STRONG_YES</li>
     * <li><code>NO_DECISION</code> - NO_DECISION</li>
     * </ul>
     */
    @JsonProperty("overall_recommendation")
    public Optional<ScorecardOverallRecommendation> getOverallRecommendation() {
        return overallRecommendation;
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
        return other instanceof Scorecard && equalTo((Scorecard) other);
    }

    private boolean equalTo(Scorecard other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && application.equals(other.application)
                && interview.equals(other.interview)
                && interviewer.equals(other.interviewer)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && submittedAt.equals(other.submittedAt)
                && overallRecommendation.equals(other.overallRecommendation)
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
                this.interview,
                this.interviewer,
                this.remoteCreatedAt,
                this.submittedAt,
                this.overallRecommendation,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "Scorecard{" + "id: " + id + ", remoteId: " + remoteId + ", application: " + application
                + ", interview: " + interview + ", interviewer: " + interviewer + ", remoteCreatedAt: "
                + remoteCreatedAt + ", submittedAt: " + submittedAt + ", overallRecommendation: "
                + overallRecommendation + ", remoteWasDeleted: " + remoteWasDeleted + ", modifiedAt: " + modifiedAt
                + ", fieldMappings: " + fieldMappings + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<ScorecardApplication> application = Optional.empty();

        private Optional<ScorecardInterview> interview = Optional.empty();

        private Optional<ScorecardInterviewer> interviewer = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<OffsetDateTime> submittedAt = Optional.empty();

        private Optional<ScorecardOverallRecommendation> overallRecommendation = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Scorecard other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            application(other.getApplication());
            interview(other.getInterview());
            interviewer(other.getInterviewer());
            remoteCreatedAt(other.getRemoteCreatedAt());
            submittedAt(other.getSubmittedAt());
            overallRecommendation(other.getOverallRecommendation());
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
        public Builder application(Optional<ScorecardApplication> application) {
            this.application = application;
            return this;
        }

        public Builder application(ScorecardApplication application) {
            this.application = Optional.of(application);
            return this;
        }

        @JsonSetter(value = "interview", nulls = Nulls.SKIP)
        public Builder interview(Optional<ScorecardInterview> interview) {
            this.interview = interview;
            return this;
        }

        public Builder interview(ScorecardInterview interview) {
            this.interview = Optional.of(interview);
            return this;
        }

        @JsonSetter(value = "interviewer", nulls = Nulls.SKIP)
        public Builder interviewer(Optional<ScorecardInterviewer> interviewer) {
            this.interviewer = interviewer;
            return this;
        }

        public Builder interviewer(ScorecardInterviewer interviewer) {
            this.interviewer = Optional.of(interviewer);
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

        @JsonSetter(value = "submitted_at", nulls = Nulls.SKIP)
        public Builder submittedAt(Optional<OffsetDateTime> submittedAt) {
            this.submittedAt = submittedAt;
            return this;
        }

        public Builder submittedAt(OffsetDateTime submittedAt) {
            this.submittedAt = Optional.of(submittedAt);
            return this;
        }

        @JsonSetter(value = "overall_recommendation", nulls = Nulls.SKIP)
        public Builder overallRecommendation(Optional<ScorecardOverallRecommendation> overallRecommendation) {
            this.overallRecommendation = overallRecommendation;
            return this;
        }

        public Builder overallRecommendation(ScorecardOverallRecommendation overallRecommendation) {
            this.overallRecommendation = Optional.of(overallRecommendation);
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

        public Scorecard build() {
            return new Scorecard(
                    id,
                    remoteId,
                    application,
                    interview,
                    interviewer,
                    remoteCreatedAt,
                    submittedAt,
                    overallRecommendation,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

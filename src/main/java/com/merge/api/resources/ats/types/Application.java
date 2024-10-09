/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ats.types;

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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Application.Builder.class)
public final class Application {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<ApplicationCandidate> candidate;

    private final Optional<ApplicationJob> job;

    private final Optional<OffsetDateTime> appliedAt;

    private final Optional<OffsetDateTime> rejectedAt;

    private final Optional<List<Optional<ApplicationOffersItem>>> offers;

    private final Optional<String> source;

    private final Optional<ApplicationCreditedTo> creditedTo;

    private final Optional<List<ApplicationScreeningQuestionAnswersItem>> screeningQuestionAnswers;

    private final Optional<ApplicationCurrentStage> currentStage;

    private final Optional<ApplicationRejectReason> rejectReason;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private final Map<String, Object> additionalProperties;

    private Application(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<ApplicationCandidate> candidate,
            Optional<ApplicationJob> job,
            Optional<OffsetDateTime> appliedAt,
            Optional<OffsetDateTime> rejectedAt,
            Optional<List<Optional<ApplicationOffersItem>>> offers,
            Optional<String> source,
            Optional<ApplicationCreditedTo> creditedTo,
            Optional<List<ApplicationScreeningQuestionAnswersItem>> screeningQuestionAnswers,
            Optional<ApplicationCurrentStage> currentStage,
            Optional<ApplicationRejectReason> rejectReason,
            Optional<Boolean> remoteWasDeleted,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.candidate = candidate;
        this.job = job;
        this.appliedAt = appliedAt;
        this.rejectedAt = rejectedAt;
        this.offers = offers;
        this.source = source;
        this.creditedTo = creditedTo;
        this.screeningQuestionAnswers = screeningQuestionAnswers;
        this.currentStage = currentStage;
        this.rejectReason = rejectReason;
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
     * @return The candidate applying.
     */
    @JsonProperty("candidate")
    public Optional<ApplicationCandidate> getCandidate() {
        return candidate;
    }

    /**
     * @return The job being applied for.
     */
    @JsonProperty("job")
    public Optional<ApplicationJob> getJob() {
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

    @JsonProperty("offers")
    public Optional<List<Optional<ApplicationOffersItem>>> getOffers() {
        return offers;
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
    public Optional<ApplicationCreditedTo> getCreditedTo() {
        return creditedTo;
    }

    @JsonProperty("screening_question_answers")
    public Optional<List<ApplicationScreeningQuestionAnswersItem>> getScreeningQuestionAnswers() {
        return screeningQuestionAnswers;
    }

    /**
     * @return The application's current stage.
     */
    @JsonProperty("current_stage")
    public Optional<ApplicationCurrentStage> getCurrentStage() {
        return currentStage;
    }

    /**
     * @return The application's reason for rejection.
     */
    @JsonProperty("reject_reason")
    public Optional<ApplicationRejectReason> getRejectReason() {
        return rejectReason;
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
        return other instanceof Application && equalTo((Application) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Application other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && candidate.equals(other.candidate)
                && job.equals(other.job)
                && appliedAt.equals(other.appliedAt)
                && rejectedAt.equals(other.rejectedAt)
                && offers.equals(other.offers)
                && source.equals(other.source)
                && creditedTo.equals(other.creditedTo)
                && screeningQuestionAnswers.equals(other.screeningQuestionAnswers)
                && currentStage.equals(other.currentStage)
                && rejectReason.equals(other.rejectReason)
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
                this.candidate,
                this.job,
                this.appliedAt,
                this.rejectedAt,
                this.offers,
                this.source,
                this.creditedTo,
                this.screeningQuestionAnswers,
                this.currentStage,
                this.rejectReason,
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

        private Optional<ApplicationCandidate> candidate = Optional.empty();

        private Optional<ApplicationJob> job = Optional.empty();

        private Optional<OffsetDateTime> appliedAt = Optional.empty();

        private Optional<OffsetDateTime> rejectedAt = Optional.empty();

        private Optional<List<Optional<ApplicationOffersItem>>> offers = Optional.empty();

        private Optional<String> source = Optional.empty();

        private Optional<ApplicationCreditedTo> creditedTo = Optional.empty();

        private Optional<List<ApplicationScreeningQuestionAnswersItem>> screeningQuestionAnswers = Optional.empty();

        private Optional<ApplicationCurrentStage> currentStage = Optional.empty();

        private Optional<ApplicationRejectReason> rejectReason = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Application other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            candidate(other.getCandidate());
            job(other.getJob());
            appliedAt(other.getAppliedAt());
            rejectedAt(other.getRejectedAt());
            offers(other.getOffers());
            source(other.getSource());
            creditedTo(other.getCreditedTo());
            screeningQuestionAnswers(other.getScreeningQuestionAnswers());
            currentStage(other.getCurrentStage());
            rejectReason(other.getRejectReason());
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

        @JsonSetter(value = "candidate", nulls = Nulls.SKIP)
        public Builder candidate(Optional<ApplicationCandidate> candidate) {
            this.candidate = candidate;
            return this;
        }

        public Builder candidate(ApplicationCandidate candidate) {
            this.candidate = Optional.of(candidate);
            return this;
        }

        @JsonSetter(value = "job", nulls = Nulls.SKIP)
        public Builder job(Optional<ApplicationJob> job) {
            this.job = job;
            return this;
        }

        public Builder job(ApplicationJob job) {
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

        @JsonSetter(value = "offers", nulls = Nulls.SKIP)
        public Builder offers(Optional<List<Optional<ApplicationOffersItem>>> offers) {
            this.offers = offers;
            return this;
        }

        public Builder offers(List<Optional<ApplicationOffersItem>> offers) {
            this.offers = Optional.of(offers);
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
        public Builder creditedTo(Optional<ApplicationCreditedTo> creditedTo) {
            this.creditedTo = creditedTo;
            return this;
        }

        public Builder creditedTo(ApplicationCreditedTo creditedTo) {
            this.creditedTo = Optional.of(creditedTo);
            return this;
        }

        @JsonSetter(value = "screening_question_answers", nulls = Nulls.SKIP)
        public Builder screeningQuestionAnswers(
                Optional<List<ApplicationScreeningQuestionAnswersItem>> screeningQuestionAnswers) {
            this.screeningQuestionAnswers = screeningQuestionAnswers;
            return this;
        }

        public Builder screeningQuestionAnswers(
                List<ApplicationScreeningQuestionAnswersItem> screeningQuestionAnswers) {
            this.screeningQuestionAnswers = Optional.of(screeningQuestionAnswers);
            return this;
        }

        @JsonSetter(value = "current_stage", nulls = Nulls.SKIP)
        public Builder currentStage(Optional<ApplicationCurrentStage> currentStage) {
            this.currentStage = currentStage;
            return this;
        }

        public Builder currentStage(ApplicationCurrentStage currentStage) {
            this.currentStage = Optional.of(currentStage);
            return this;
        }

        @JsonSetter(value = "reject_reason", nulls = Nulls.SKIP)
        public Builder rejectReason(Optional<ApplicationRejectReason> rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public Builder rejectReason(ApplicationRejectReason rejectReason) {
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
                    createdAt,
                    modifiedAt,
                    candidate,
                    job,
                    appliedAt,
                    rejectedAt,
                    offers,
                    source,
                    creditedTo,
                    screeningQuestionAnswers,
                    currentStage,
                    rejectReason,
                    remoteWasDeleted,
                    fieldMappings,
                    remoteData,
                    additionalProperties);
        }
    }
}

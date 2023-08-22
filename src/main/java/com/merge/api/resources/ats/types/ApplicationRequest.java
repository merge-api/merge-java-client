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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ApplicationRequest.Builder.class)
public final class ApplicationRequest {
    private final Optional<ApplicationRequestCandidate> candidate;

    private final Optional<ApplicationRequestJob> job;

    private final Optional<OffsetDateTime> appliedAt;

    private final Optional<OffsetDateTime> rejectedAt;

    private final Optional<String> source;

    private final Optional<ApplicationRequestCreditedTo> creditedTo;

    private final Optional<ApplicationRequestCurrentStage> currentStage;

    private final Optional<ApplicationRequestRejectReason> rejectReason;

    private final Optional<String> remoteTemplateId;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private ApplicationRequest(
            Optional<ApplicationRequestCandidate> candidate,
            Optional<ApplicationRequestJob> job,
            Optional<OffsetDateTime> appliedAt,
            Optional<OffsetDateTime> rejectedAt,
            Optional<String> source,
            Optional<ApplicationRequestCreditedTo> creditedTo,
            Optional<ApplicationRequestCurrentStage> currentStage,
            Optional<ApplicationRequestRejectReason> rejectReason,
            Optional<String> remoteTemplateId,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.candidate = candidate;
        this.job = job;
        this.appliedAt = appliedAt;
        this.rejectedAt = rejectedAt;
        this.source = source;
        this.creditedTo = creditedTo;
        this.currentStage = currentStage;
        this.rejectReason = rejectReason;
        this.remoteTemplateId = remoteTemplateId;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The candidate applying.
     */
    @JsonProperty("candidate")
    public Optional<ApplicationRequestCandidate> getCandidate() {
        return candidate;
    }

    /**
     * @return The job being applied for.
     */
    @JsonProperty("job")
    public Optional<ApplicationRequestJob> getJob() {
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
    public Optional<ApplicationRequestCreditedTo> getCreditedTo() {
        return creditedTo;
    }

    /**
     * @return The application's current stage.
     */
    @JsonProperty("current_stage")
    public Optional<ApplicationRequestCurrentStage> getCurrentStage() {
        return currentStage;
    }

    /**
     * @return The application's reason for rejection.
     */
    @JsonProperty("reject_reason")
    public Optional<ApplicationRequestRejectReason> getRejectReason() {
        return rejectReason;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("remote_template_id")
    public Optional<String> getRemoteTemplateId() {
        return remoteTemplateId;
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
        return other instanceof ApplicationRequest && equalTo((ApplicationRequest) other);
    }

    private boolean equalTo(ApplicationRequest other) {
        return candidate.equals(other.candidate)
                && job.equals(other.job)
                && appliedAt.equals(other.appliedAt)
                && rejectedAt.equals(other.rejectedAt)
                && source.equals(other.source)
                && creditedTo.equals(other.creditedTo)
                && currentStage.equals(other.currentStage)
                && rejectReason.equals(other.rejectReason)
                && remoteTemplateId.equals(other.remoteTemplateId)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.candidate,
                this.job,
                this.appliedAt,
                this.rejectedAt,
                this.source,
                this.creditedTo,
                this.currentStage,
                this.rejectReason,
                this.remoteTemplateId,
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
        private Optional<ApplicationRequestCandidate> candidate = Optional.empty();

        private Optional<ApplicationRequestJob> job = Optional.empty();

        private Optional<OffsetDateTime> appliedAt = Optional.empty();

        private Optional<OffsetDateTime> rejectedAt = Optional.empty();

        private Optional<String> source = Optional.empty();

        private Optional<ApplicationRequestCreditedTo> creditedTo = Optional.empty();

        private Optional<ApplicationRequestCurrentStage> currentStage = Optional.empty();

        private Optional<ApplicationRequestRejectReason> rejectReason = Optional.empty();

        private Optional<String> remoteTemplateId = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(ApplicationRequest other) {
            candidate(other.getCandidate());
            job(other.getJob());
            appliedAt(other.getAppliedAt());
            rejectedAt(other.getRejectedAt());
            source(other.getSource());
            creditedTo(other.getCreditedTo());
            currentStage(other.getCurrentStage());
            rejectReason(other.getRejectReason());
            remoteTemplateId(other.getRemoteTemplateId());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            return this;
        }

        @JsonSetter(value = "candidate", nulls = Nulls.SKIP)
        public Builder candidate(Optional<ApplicationRequestCandidate> candidate) {
            this.candidate = candidate;
            return this;
        }

        public Builder candidate(ApplicationRequestCandidate candidate) {
            this.candidate = Optional.of(candidate);
            return this;
        }

        @JsonSetter(value = "job", nulls = Nulls.SKIP)
        public Builder job(Optional<ApplicationRequestJob> job) {
            this.job = job;
            return this;
        }

        public Builder job(ApplicationRequestJob job) {
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
        public Builder creditedTo(Optional<ApplicationRequestCreditedTo> creditedTo) {
            this.creditedTo = creditedTo;
            return this;
        }

        public Builder creditedTo(ApplicationRequestCreditedTo creditedTo) {
            this.creditedTo = Optional.of(creditedTo);
            return this;
        }

        @JsonSetter(value = "current_stage", nulls = Nulls.SKIP)
        public Builder currentStage(Optional<ApplicationRequestCurrentStage> currentStage) {
            this.currentStage = currentStage;
            return this;
        }

        public Builder currentStage(ApplicationRequestCurrentStage currentStage) {
            this.currentStage = Optional.of(currentStage);
            return this;
        }

        @JsonSetter(value = "reject_reason", nulls = Nulls.SKIP)
        public Builder rejectReason(Optional<ApplicationRequestRejectReason> rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public Builder rejectReason(ApplicationRequestRejectReason rejectReason) {
            this.rejectReason = Optional.of(rejectReason);
            return this;
        }

        @JsonSetter(value = "remote_template_id", nulls = Nulls.SKIP)
        public Builder remoteTemplateId(Optional<String> remoteTemplateId) {
            this.remoteTemplateId = remoteTemplateId;
            return this;
        }

        public Builder remoteTemplateId(String remoteTemplateId) {
            this.remoteTemplateId = Optional.of(remoteTemplateId);
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

        public ApplicationRequest build() {
            return new ApplicationRequest(
                    candidate,
                    job,
                    appliedAt,
                    rejectedAt,
                    source,
                    creditedTo,
                    currentStage,
                    rejectReason,
                    remoteTemplateId,
                    integrationParams,
                    linkedAccountParams);
        }
    }
}

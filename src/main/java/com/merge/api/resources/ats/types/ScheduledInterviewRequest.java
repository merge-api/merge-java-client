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
@JsonDeserialize(builder = ScheduledInterviewRequest.Builder.class)
public final class ScheduledInterviewRequest {
    private final Optional<ScheduledInterviewRequestApplication> application;

    private final Optional<ScheduledInterviewRequestJobInterviewStage> jobInterviewStage;

    private final Optional<ScheduledInterviewRequestOrganizer> organizer;

    private final Optional<List<Optional<ScheduledInterviewRequestInterviewersItem>>> interviewers;

    private final Optional<String> location;

    private final Optional<OffsetDateTime> startAt;

    private final Optional<OffsetDateTime> endAt;

    private final Optional<ScheduledInterviewRequestStatus> status;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private ScheduledInterviewRequest(
            Optional<ScheduledInterviewRequestApplication> application,
            Optional<ScheduledInterviewRequestJobInterviewStage> jobInterviewStage,
            Optional<ScheduledInterviewRequestOrganizer> organizer,
            Optional<List<Optional<ScheduledInterviewRequestInterviewersItem>>> interviewers,
            Optional<String> location,
            Optional<OffsetDateTime> startAt,
            Optional<OffsetDateTime> endAt,
            Optional<ScheduledInterviewRequestStatus> status,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.application = application;
        this.jobInterviewStage = jobInterviewStage;
        this.organizer = organizer;
        this.interviewers = interviewers;
        this.location = location;
        this.startAt = startAt;
        this.endAt = endAt;
        this.status = status;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The application being interviewed.
     */
    @JsonProperty("application")
    public Optional<ScheduledInterviewRequestApplication> getApplication() {
        return application;
    }

    /**
     * @return The stage of the interview.
     */
    @JsonProperty("job_interview_stage")
    public Optional<ScheduledInterviewRequestJobInterviewStage> getJobInterviewStage() {
        return jobInterviewStage;
    }

    /**
     * @return The user organizing the interview.
     */
    @JsonProperty("organizer")
    public Optional<ScheduledInterviewRequestOrganizer> getOrganizer() {
        return organizer;
    }

    /**
     * @return Array of <code>RemoteUser</code> IDs.
     */
    @JsonProperty("interviewers")
    public Optional<List<Optional<ScheduledInterviewRequestInterviewersItem>>> getInterviewers() {
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
     * @return The interview's status.
     * <ul>
     * <li><code>SCHEDULED</code> - SCHEDULED</li>
     * <li><code>AWAITING_FEEDBACK</code> - AWAITING_FEEDBACK</li>
     * <li><code>COMPLETE</code> - COMPLETE</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<ScheduledInterviewRequestStatus> getStatus() {
        return status;
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
        return other instanceof ScheduledInterviewRequest && equalTo((ScheduledInterviewRequest) other);
    }

    private boolean equalTo(ScheduledInterviewRequest other) {
        return application.equals(other.application)
                && jobInterviewStage.equals(other.jobInterviewStage)
                && organizer.equals(other.organizer)
                && interviewers.equals(other.interviewers)
                && location.equals(other.location)
                && startAt.equals(other.startAt)
                && endAt.equals(other.endAt)
                && status.equals(other.status)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.application,
                this.jobInterviewStage,
                this.organizer,
                this.interviewers,
                this.location,
                this.startAt,
                this.endAt,
                this.status,
                this.integrationParams,
                this.linkedAccountParams);
    }

    @Override
    public String toString() {
        return "ScheduledInterviewRequest{" + "application: " + application + ", jobInterviewStage: "
                + jobInterviewStage + ", organizer: " + organizer + ", interviewers: " + interviewers + ", location: "
                + location + ", startAt: " + startAt + ", endAt: " + endAt + ", status: " + status
                + ", integrationParams: " + integrationParams + ", linkedAccountParams: " + linkedAccountParams + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<ScheduledInterviewRequestApplication> application = Optional.empty();

        private Optional<ScheduledInterviewRequestJobInterviewStage> jobInterviewStage = Optional.empty();

        private Optional<ScheduledInterviewRequestOrganizer> organizer = Optional.empty();

        private Optional<List<Optional<ScheduledInterviewRequestInterviewersItem>>> interviewers = Optional.empty();

        private Optional<String> location = Optional.empty();

        private Optional<OffsetDateTime> startAt = Optional.empty();

        private Optional<OffsetDateTime> endAt = Optional.empty();

        private Optional<ScheduledInterviewRequestStatus> status = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(ScheduledInterviewRequest other) {
            application(other.getApplication());
            jobInterviewStage(other.getJobInterviewStage());
            organizer(other.getOrganizer());
            interviewers(other.getInterviewers());
            location(other.getLocation());
            startAt(other.getStartAt());
            endAt(other.getEndAt());
            status(other.getStatus());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            return this;
        }

        @JsonSetter(value = "application", nulls = Nulls.SKIP)
        public Builder application(Optional<ScheduledInterviewRequestApplication> application) {
            this.application = application;
            return this;
        }

        public Builder application(ScheduledInterviewRequestApplication application) {
            this.application = Optional.of(application);
            return this;
        }

        @JsonSetter(value = "job_interview_stage", nulls = Nulls.SKIP)
        public Builder jobInterviewStage(Optional<ScheduledInterviewRequestJobInterviewStage> jobInterviewStage) {
            this.jobInterviewStage = jobInterviewStage;
            return this;
        }

        public Builder jobInterviewStage(ScheduledInterviewRequestJobInterviewStage jobInterviewStage) {
            this.jobInterviewStage = Optional.of(jobInterviewStage);
            return this;
        }

        @JsonSetter(value = "organizer", nulls = Nulls.SKIP)
        public Builder organizer(Optional<ScheduledInterviewRequestOrganizer> organizer) {
            this.organizer = organizer;
            return this;
        }

        public Builder organizer(ScheduledInterviewRequestOrganizer organizer) {
            this.organizer = Optional.of(organizer);
            return this;
        }

        @JsonSetter(value = "interviewers", nulls = Nulls.SKIP)
        public Builder interviewers(Optional<List<Optional<ScheduledInterviewRequestInterviewersItem>>> interviewers) {
            this.interviewers = interviewers;
            return this;
        }

        public Builder interviewers(List<Optional<ScheduledInterviewRequestInterviewersItem>> interviewers) {
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

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<ScheduledInterviewRequestStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(ScheduledInterviewRequestStatus status) {
            this.status = Optional.of(status);
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

        public ScheduledInterviewRequest build() {
            return new ScheduledInterviewRequest(
                    application,
                    jobInterviewStage,
                    organizer,
                    interviewers,
                    location,
                    startAt,
                    endAt,
                    status,
                    integrationParams,
                    linkedAccountParams);
        }
    }
}

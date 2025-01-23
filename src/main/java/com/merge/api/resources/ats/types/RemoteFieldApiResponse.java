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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = RemoteFieldApiResponse.Builder.class)
public final class RemoteFieldApiResponse {
    private final Optional<List<RemoteFieldApi>> activity;

    private final Optional<List<RemoteFieldApi>> application;

    private final Optional<List<RemoteFieldApi>> attachment;

    private final Optional<List<RemoteFieldApi>> candidate;

    private final Optional<List<RemoteFieldApi>> department;

    private final Optional<List<RemoteFieldApi>> eeoc;

    private final Optional<List<RemoteFieldApi>> scheduledInterview;

    private final Optional<List<RemoteFieldApi>> job;

    private final Optional<List<RemoteFieldApi>> jobPosting;

    private final Optional<List<RemoteFieldApi>> jobInterviewStage;

    private final Optional<List<RemoteFieldApi>> offer;

    private final Optional<List<RemoteFieldApi>> office;

    private final Optional<List<RemoteFieldApi>> rejectReason;

    private final Optional<List<RemoteFieldApi>> scorecard;

    private final Optional<List<RemoteFieldApi>> tag;

    private final Optional<List<RemoteFieldApi>> remoteUser;

    private final Map<String, Object> additionalProperties;

    private RemoteFieldApiResponse(
            Optional<List<RemoteFieldApi>> activity,
            Optional<List<RemoteFieldApi>> application,
            Optional<List<RemoteFieldApi>> attachment,
            Optional<List<RemoteFieldApi>> candidate,
            Optional<List<RemoteFieldApi>> department,
            Optional<List<RemoteFieldApi>> eeoc,
            Optional<List<RemoteFieldApi>> scheduledInterview,
            Optional<List<RemoteFieldApi>> job,
            Optional<List<RemoteFieldApi>> jobPosting,
            Optional<List<RemoteFieldApi>> jobInterviewStage,
            Optional<List<RemoteFieldApi>> offer,
            Optional<List<RemoteFieldApi>> office,
            Optional<List<RemoteFieldApi>> rejectReason,
            Optional<List<RemoteFieldApi>> scorecard,
            Optional<List<RemoteFieldApi>> tag,
            Optional<List<RemoteFieldApi>> remoteUser,
            Map<String, Object> additionalProperties) {
        this.activity = activity;
        this.application = application;
        this.attachment = attachment;
        this.candidate = candidate;
        this.department = department;
        this.eeoc = eeoc;
        this.scheduledInterview = scheduledInterview;
        this.job = job;
        this.jobPosting = jobPosting;
        this.jobInterviewStage = jobInterviewStage;
        this.offer = offer;
        this.office = office;
        this.rejectReason = rejectReason;
        this.scorecard = scorecard;
        this.tag = tag;
        this.remoteUser = remoteUser;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("Activity")
    public Optional<List<RemoteFieldApi>> getActivity() {
        return activity;
    }

    @JsonProperty("Application")
    public Optional<List<RemoteFieldApi>> getApplication() {
        return application;
    }

    @JsonProperty("Attachment")
    public Optional<List<RemoteFieldApi>> getAttachment() {
        return attachment;
    }

    @JsonProperty("Candidate")
    public Optional<List<RemoteFieldApi>> getCandidate() {
        return candidate;
    }

    @JsonProperty("Department")
    public Optional<List<RemoteFieldApi>> getDepartment() {
        return department;
    }

    @JsonProperty("EEOC")
    public Optional<List<RemoteFieldApi>> getEeoc() {
        return eeoc;
    }

    @JsonProperty("ScheduledInterview")
    public Optional<List<RemoteFieldApi>> getScheduledInterview() {
        return scheduledInterview;
    }

    @JsonProperty("Job")
    public Optional<List<RemoteFieldApi>> getJob() {
        return job;
    }

    @JsonProperty("JobPosting")
    public Optional<List<RemoteFieldApi>> getJobPosting() {
        return jobPosting;
    }

    @JsonProperty("JobInterviewStage")
    public Optional<List<RemoteFieldApi>> getJobInterviewStage() {
        return jobInterviewStage;
    }

    @JsonProperty("Offer")
    public Optional<List<RemoteFieldApi>> getOffer() {
        return offer;
    }

    @JsonProperty("Office")
    public Optional<List<RemoteFieldApi>> getOffice() {
        return office;
    }

    @JsonProperty("RejectReason")
    public Optional<List<RemoteFieldApi>> getRejectReason() {
        return rejectReason;
    }

    @JsonProperty("Scorecard")
    public Optional<List<RemoteFieldApi>> getScorecard() {
        return scorecard;
    }

    @JsonProperty("Tag")
    public Optional<List<RemoteFieldApi>> getTag() {
        return tag;
    }

    @JsonProperty("RemoteUser")
    public Optional<List<RemoteFieldApi>> getRemoteUser() {
        return remoteUser;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteFieldApiResponse && equalTo((RemoteFieldApiResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RemoteFieldApiResponse other) {
        return activity.equals(other.activity)
                && application.equals(other.application)
                && attachment.equals(other.attachment)
                && candidate.equals(other.candidate)
                && department.equals(other.department)
                && eeoc.equals(other.eeoc)
                && scheduledInterview.equals(other.scheduledInterview)
                && job.equals(other.job)
                && jobPosting.equals(other.jobPosting)
                && jobInterviewStage.equals(other.jobInterviewStage)
                && offer.equals(other.offer)
                && office.equals(other.office)
                && rejectReason.equals(other.rejectReason)
                && scorecard.equals(other.scorecard)
                && tag.equals(other.tag)
                && remoteUser.equals(other.remoteUser);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.activity,
                this.application,
                this.attachment,
                this.candidate,
                this.department,
                this.eeoc,
                this.scheduledInterview,
                this.job,
                this.jobPosting,
                this.jobInterviewStage,
                this.offer,
                this.office,
                this.rejectReason,
                this.scorecard,
                this.tag,
                this.remoteUser);
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
        private Optional<List<RemoteFieldApi>> activity = Optional.empty();

        private Optional<List<RemoteFieldApi>> application = Optional.empty();

        private Optional<List<RemoteFieldApi>> attachment = Optional.empty();

        private Optional<List<RemoteFieldApi>> candidate = Optional.empty();

        private Optional<List<RemoteFieldApi>> department = Optional.empty();

        private Optional<List<RemoteFieldApi>> eeoc = Optional.empty();

        private Optional<List<RemoteFieldApi>> scheduledInterview = Optional.empty();

        private Optional<List<RemoteFieldApi>> job = Optional.empty();

        private Optional<List<RemoteFieldApi>> jobPosting = Optional.empty();

        private Optional<List<RemoteFieldApi>> jobInterviewStage = Optional.empty();

        private Optional<List<RemoteFieldApi>> offer = Optional.empty();

        private Optional<List<RemoteFieldApi>> office = Optional.empty();

        private Optional<List<RemoteFieldApi>> rejectReason = Optional.empty();

        private Optional<List<RemoteFieldApi>> scorecard = Optional.empty();

        private Optional<List<RemoteFieldApi>> tag = Optional.empty();

        private Optional<List<RemoteFieldApi>> remoteUser = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(RemoteFieldApiResponse other) {
            activity(other.getActivity());
            application(other.getApplication());
            attachment(other.getAttachment());
            candidate(other.getCandidate());
            department(other.getDepartment());
            eeoc(other.getEeoc());
            scheduledInterview(other.getScheduledInterview());
            job(other.getJob());
            jobPosting(other.getJobPosting());
            jobInterviewStage(other.getJobInterviewStage());
            offer(other.getOffer());
            office(other.getOffice());
            rejectReason(other.getRejectReason());
            scorecard(other.getScorecard());
            tag(other.getTag());
            remoteUser(other.getRemoteUser());
            return this;
        }

        @JsonSetter(value = "Activity", nulls = Nulls.SKIP)
        public Builder activity(Optional<List<RemoteFieldApi>> activity) {
            this.activity = activity;
            return this;
        }

        public Builder activity(List<RemoteFieldApi> activity) {
            this.activity = Optional.ofNullable(activity);
            return this;
        }

        @JsonSetter(value = "Application", nulls = Nulls.SKIP)
        public Builder application(Optional<List<RemoteFieldApi>> application) {
            this.application = application;
            return this;
        }

        public Builder application(List<RemoteFieldApi> application) {
            this.application = Optional.ofNullable(application);
            return this;
        }

        @JsonSetter(value = "Attachment", nulls = Nulls.SKIP)
        public Builder attachment(Optional<List<RemoteFieldApi>> attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder attachment(List<RemoteFieldApi> attachment) {
            this.attachment = Optional.ofNullable(attachment);
            return this;
        }

        @JsonSetter(value = "Candidate", nulls = Nulls.SKIP)
        public Builder candidate(Optional<List<RemoteFieldApi>> candidate) {
            this.candidate = candidate;
            return this;
        }

        public Builder candidate(List<RemoteFieldApi> candidate) {
            this.candidate = Optional.ofNullable(candidate);
            return this;
        }

        @JsonSetter(value = "Department", nulls = Nulls.SKIP)
        public Builder department(Optional<List<RemoteFieldApi>> department) {
            this.department = department;
            return this;
        }

        public Builder department(List<RemoteFieldApi> department) {
            this.department = Optional.ofNullable(department);
            return this;
        }

        @JsonSetter(value = "EEOC", nulls = Nulls.SKIP)
        public Builder eeoc(Optional<List<RemoteFieldApi>> eeoc) {
            this.eeoc = eeoc;
            return this;
        }

        public Builder eeoc(List<RemoteFieldApi> eeoc) {
            this.eeoc = Optional.ofNullable(eeoc);
            return this;
        }

        @JsonSetter(value = "ScheduledInterview", nulls = Nulls.SKIP)
        public Builder scheduledInterview(Optional<List<RemoteFieldApi>> scheduledInterview) {
            this.scheduledInterview = scheduledInterview;
            return this;
        }

        public Builder scheduledInterview(List<RemoteFieldApi> scheduledInterview) {
            this.scheduledInterview = Optional.ofNullable(scheduledInterview);
            return this;
        }

        @JsonSetter(value = "Job", nulls = Nulls.SKIP)
        public Builder job(Optional<List<RemoteFieldApi>> job) {
            this.job = job;
            return this;
        }

        public Builder job(List<RemoteFieldApi> job) {
            this.job = Optional.ofNullable(job);
            return this;
        }

        @JsonSetter(value = "JobPosting", nulls = Nulls.SKIP)
        public Builder jobPosting(Optional<List<RemoteFieldApi>> jobPosting) {
            this.jobPosting = jobPosting;
            return this;
        }

        public Builder jobPosting(List<RemoteFieldApi> jobPosting) {
            this.jobPosting = Optional.ofNullable(jobPosting);
            return this;
        }

        @JsonSetter(value = "JobInterviewStage", nulls = Nulls.SKIP)
        public Builder jobInterviewStage(Optional<List<RemoteFieldApi>> jobInterviewStage) {
            this.jobInterviewStage = jobInterviewStage;
            return this;
        }

        public Builder jobInterviewStage(List<RemoteFieldApi> jobInterviewStage) {
            this.jobInterviewStage = Optional.ofNullable(jobInterviewStage);
            return this;
        }

        @JsonSetter(value = "Offer", nulls = Nulls.SKIP)
        public Builder offer(Optional<List<RemoteFieldApi>> offer) {
            this.offer = offer;
            return this;
        }

        public Builder offer(List<RemoteFieldApi> offer) {
            this.offer = Optional.ofNullable(offer);
            return this;
        }

        @JsonSetter(value = "Office", nulls = Nulls.SKIP)
        public Builder office(Optional<List<RemoteFieldApi>> office) {
            this.office = office;
            return this;
        }

        public Builder office(List<RemoteFieldApi> office) {
            this.office = Optional.ofNullable(office);
            return this;
        }

        @JsonSetter(value = "RejectReason", nulls = Nulls.SKIP)
        public Builder rejectReason(Optional<List<RemoteFieldApi>> rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public Builder rejectReason(List<RemoteFieldApi> rejectReason) {
            this.rejectReason = Optional.ofNullable(rejectReason);
            return this;
        }

        @JsonSetter(value = "Scorecard", nulls = Nulls.SKIP)
        public Builder scorecard(Optional<List<RemoteFieldApi>> scorecard) {
            this.scorecard = scorecard;
            return this;
        }

        public Builder scorecard(List<RemoteFieldApi> scorecard) {
            this.scorecard = Optional.ofNullable(scorecard);
            return this;
        }

        @JsonSetter(value = "Tag", nulls = Nulls.SKIP)
        public Builder tag(Optional<List<RemoteFieldApi>> tag) {
            this.tag = tag;
            return this;
        }

        public Builder tag(List<RemoteFieldApi> tag) {
            this.tag = Optional.ofNullable(tag);
            return this;
        }

        @JsonSetter(value = "RemoteUser", nulls = Nulls.SKIP)
        public Builder remoteUser(Optional<List<RemoteFieldApi>> remoteUser) {
            this.remoteUser = remoteUser;
            return this;
        }

        public Builder remoteUser(List<RemoteFieldApi> remoteUser) {
            this.remoteUser = Optional.ofNullable(remoteUser);
            return this;
        }

        public RemoteFieldApiResponse build() {
            return new RemoteFieldApiResponse(
                    activity,
                    application,
                    attachment,
                    candidate,
                    department,
                    eeoc,
                    scheduledInterview,
                    job,
                    jobPosting,
                    jobInterviewStage,
                    offer,
                    office,
                    rejectReason,
                    scorecard,
                    tag,
                    remoteUser,
                    additionalProperties);
        }
    }
}

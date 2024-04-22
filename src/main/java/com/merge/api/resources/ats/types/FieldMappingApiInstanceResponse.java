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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FieldMappingApiInstanceResponse.Builder.class)
public final class FieldMappingApiInstanceResponse {
    private final Optional<List<FieldMappingApiInstance>> activity;

    private final Optional<List<FieldMappingApiInstance>> application;

    private final Optional<List<FieldMappingApiInstance>> attachment;

    private final Optional<List<FieldMappingApiInstance>> candidate;

    private final Optional<List<FieldMappingApiInstance>> department;

    private final Optional<List<FieldMappingApiInstance>> eeoc;

    private final Optional<List<FieldMappingApiInstance>> scheduledInterview;

    private final Optional<List<FieldMappingApiInstance>> job;

    private final Optional<List<FieldMappingApiInstance>> jobPosting;

    private final Optional<List<FieldMappingApiInstance>> jobInterviewStage;

    private final Optional<List<FieldMappingApiInstance>> offer;

    private final Optional<List<FieldMappingApiInstance>> office;

    private final Optional<List<FieldMappingApiInstance>> rejectReason;

    private final Optional<List<FieldMappingApiInstance>> scorecard;

    private final Optional<List<FieldMappingApiInstance>> tag;

    private final Optional<List<FieldMappingApiInstance>> remoteUser;

    private final Map<String, Object> additionalProperties;

    private FieldMappingApiInstanceResponse(
            Optional<List<FieldMappingApiInstance>> activity,
            Optional<List<FieldMappingApiInstance>> application,
            Optional<List<FieldMappingApiInstance>> attachment,
            Optional<List<FieldMappingApiInstance>> candidate,
            Optional<List<FieldMappingApiInstance>> department,
            Optional<List<FieldMappingApiInstance>> eeoc,
            Optional<List<FieldMappingApiInstance>> scheduledInterview,
            Optional<List<FieldMappingApiInstance>> job,
            Optional<List<FieldMappingApiInstance>> jobPosting,
            Optional<List<FieldMappingApiInstance>> jobInterviewStage,
            Optional<List<FieldMappingApiInstance>> offer,
            Optional<List<FieldMappingApiInstance>> office,
            Optional<List<FieldMappingApiInstance>> rejectReason,
            Optional<List<FieldMappingApiInstance>> scorecard,
            Optional<List<FieldMappingApiInstance>> tag,
            Optional<List<FieldMappingApiInstance>> remoteUser,
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
    public Optional<List<FieldMappingApiInstance>> getActivity() {
        return activity;
    }

    @JsonProperty("Application")
    public Optional<List<FieldMappingApiInstance>> getApplication() {
        return application;
    }

    @JsonProperty("Attachment")
    public Optional<List<FieldMappingApiInstance>> getAttachment() {
        return attachment;
    }

    @JsonProperty("Candidate")
    public Optional<List<FieldMappingApiInstance>> getCandidate() {
        return candidate;
    }

    @JsonProperty("Department")
    public Optional<List<FieldMappingApiInstance>> getDepartment() {
        return department;
    }

    @JsonProperty("EEOC")
    public Optional<List<FieldMappingApiInstance>> getEeoc() {
        return eeoc;
    }

    @JsonProperty("ScheduledInterview")
    public Optional<List<FieldMappingApiInstance>> getScheduledInterview() {
        return scheduledInterview;
    }

    @JsonProperty("Job")
    public Optional<List<FieldMappingApiInstance>> getJob() {
        return job;
    }

    @JsonProperty("JobPosting")
    public Optional<List<FieldMappingApiInstance>> getJobPosting() {
        return jobPosting;
    }

    @JsonProperty("JobInterviewStage")
    public Optional<List<FieldMappingApiInstance>> getJobInterviewStage() {
        return jobInterviewStage;
    }

    @JsonProperty("Offer")
    public Optional<List<FieldMappingApiInstance>> getOffer() {
        return offer;
    }

    @JsonProperty("Office")
    public Optional<List<FieldMappingApiInstance>> getOffice() {
        return office;
    }

    @JsonProperty("RejectReason")
    public Optional<List<FieldMappingApiInstance>> getRejectReason() {
        return rejectReason;
    }

    @JsonProperty("Scorecard")
    public Optional<List<FieldMappingApiInstance>> getScorecard() {
        return scorecard;
    }

    @JsonProperty("Tag")
    public Optional<List<FieldMappingApiInstance>> getTag() {
        return tag;
    }

    @JsonProperty("RemoteUser")
    public Optional<List<FieldMappingApiInstance>> getRemoteUser() {
        return remoteUser;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FieldMappingApiInstanceResponse && equalTo((FieldMappingApiInstanceResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FieldMappingApiInstanceResponse other) {
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
        private Optional<List<FieldMappingApiInstance>> activity = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> application = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> attachment = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> candidate = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> department = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> eeoc = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> scheduledInterview = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> job = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> jobPosting = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> jobInterviewStage = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> offer = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> office = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> rejectReason = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> scorecard = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> tag = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> remoteUser = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(FieldMappingApiInstanceResponse other) {
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
        public Builder activity(Optional<List<FieldMappingApiInstance>> activity) {
            this.activity = activity;
            return this;
        }

        public Builder activity(List<FieldMappingApiInstance> activity) {
            this.activity = Optional.of(activity);
            return this;
        }

        @JsonSetter(value = "Application", nulls = Nulls.SKIP)
        public Builder application(Optional<List<FieldMappingApiInstance>> application) {
            this.application = application;
            return this;
        }

        public Builder application(List<FieldMappingApiInstance> application) {
            this.application = Optional.of(application);
            return this;
        }

        @JsonSetter(value = "Attachment", nulls = Nulls.SKIP)
        public Builder attachment(Optional<List<FieldMappingApiInstance>> attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder attachment(List<FieldMappingApiInstance> attachment) {
            this.attachment = Optional.of(attachment);
            return this;
        }

        @JsonSetter(value = "Candidate", nulls = Nulls.SKIP)
        public Builder candidate(Optional<List<FieldMappingApiInstance>> candidate) {
            this.candidate = candidate;
            return this;
        }

        public Builder candidate(List<FieldMappingApiInstance> candidate) {
            this.candidate = Optional.of(candidate);
            return this;
        }

        @JsonSetter(value = "Department", nulls = Nulls.SKIP)
        public Builder department(Optional<List<FieldMappingApiInstance>> department) {
            this.department = department;
            return this;
        }

        public Builder department(List<FieldMappingApiInstance> department) {
            this.department = Optional.of(department);
            return this;
        }

        @JsonSetter(value = "EEOC", nulls = Nulls.SKIP)
        public Builder eeoc(Optional<List<FieldMappingApiInstance>> eeoc) {
            this.eeoc = eeoc;
            return this;
        }

        public Builder eeoc(List<FieldMappingApiInstance> eeoc) {
            this.eeoc = Optional.of(eeoc);
            return this;
        }

        @JsonSetter(value = "ScheduledInterview", nulls = Nulls.SKIP)
        public Builder scheduledInterview(Optional<List<FieldMappingApiInstance>> scheduledInterview) {
            this.scheduledInterview = scheduledInterview;
            return this;
        }

        public Builder scheduledInterview(List<FieldMappingApiInstance> scheduledInterview) {
            this.scheduledInterview = Optional.of(scheduledInterview);
            return this;
        }

        @JsonSetter(value = "Job", nulls = Nulls.SKIP)
        public Builder job(Optional<List<FieldMappingApiInstance>> job) {
            this.job = job;
            return this;
        }

        public Builder job(List<FieldMappingApiInstance> job) {
            this.job = Optional.of(job);
            return this;
        }

        @JsonSetter(value = "JobPosting", nulls = Nulls.SKIP)
        public Builder jobPosting(Optional<List<FieldMappingApiInstance>> jobPosting) {
            this.jobPosting = jobPosting;
            return this;
        }

        public Builder jobPosting(List<FieldMappingApiInstance> jobPosting) {
            this.jobPosting = Optional.of(jobPosting);
            return this;
        }

        @JsonSetter(value = "JobInterviewStage", nulls = Nulls.SKIP)
        public Builder jobInterviewStage(Optional<List<FieldMappingApiInstance>> jobInterviewStage) {
            this.jobInterviewStage = jobInterviewStage;
            return this;
        }

        public Builder jobInterviewStage(List<FieldMappingApiInstance> jobInterviewStage) {
            this.jobInterviewStage = Optional.of(jobInterviewStage);
            return this;
        }

        @JsonSetter(value = "Offer", nulls = Nulls.SKIP)
        public Builder offer(Optional<List<FieldMappingApiInstance>> offer) {
            this.offer = offer;
            return this;
        }

        public Builder offer(List<FieldMappingApiInstance> offer) {
            this.offer = Optional.of(offer);
            return this;
        }

        @JsonSetter(value = "Office", nulls = Nulls.SKIP)
        public Builder office(Optional<List<FieldMappingApiInstance>> office) {
            this.office = office;
            return this;
        }

        public Builder office(List<FieldMappingApiInstance> office) {
            this.office = Optional.of(office);
            return this;
        }

        @JsonSetter(value = "RejectReason", nulls = Nulls.SKIP)
        public Builder rejectReason(Optional<List<FieldMappingApiInstance>> rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public Builder rejectReason(List<FieldMappingApiInstance> rejectReason) {
            this.rejectReason = Optional.of(rejectReason);
            return this;
        }

        @JsonSetter(value = "Scorecard", nulls = Nulls.SKIP)
        public Builder scorecard(Optional<List<FieldMappingApiInstance>> scorecard) {
            this.scorecard = scorecard;
            return this;
        }

        public Builder scorecard(List<FieldMappingApiInstance> scorecard) {
            this.scorecard = Optional.of(scorecard);
            return this;
        }

        @JsonSetter(value = "Tag", nulls = Nulls.SKIP)
        public Builder tag(Optional<List<FieldMappingApiInstance>> tag) {
            this.tag = tag;
            return this;
        }

        public Builder tag(List<FieldMappingApiInstance> tag) {
            this.tag = Optional.of(tag);
            return this;
        }

        @JsonSetter(value = "RemoteUser", nulls = Nulls.SKIP)
        public Builder remoteUser(Optional<List<FieldMappingApiInstance>> remoteUser) {
            this.remoteUser = remoteUser;
            return this;
        }

        public Builder remoteUser(List<FieldMappingApiInstance> remoteUser) {
            this.remoteUser = Optional.of(remoteUser);
            return this;
        }

        public FieldMappingApiInstanceResponse build() {
            return new FieldMappingApiInstanceResponse(
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

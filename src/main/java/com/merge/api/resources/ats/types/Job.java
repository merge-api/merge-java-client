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
@JsonDeserialize(builder = Job.Builder.class)
public final class Job {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<String> code;

    private final Optional<JobStatus> status;

    private final Optional<List<Url>> jobPostingUrls;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<Boolean> confidential;

    private final Optional<List<Optional<String>>> departments;

    private final Optional<List<Optional<String>>> offices;

    private final Optional<List<Optional<String>>> hiringManagers;

    private final Optional<List<Optional<String>>> recruiters;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Job(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> name,
            Optional<String> description,
            Optional<String> code,
            Optional<JobStatus> status,
            Optional<List<Url>> jobPostingUrls,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<Boolean> confidential,
            Optional<List<Optional<String>>> departments,
            Optional<List<Optional<String>>> offices,
            Optional<List<Optional<String>>> hiringManagers,
            Optional<List<Optional<String>>> recruiters,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.name = name;
        this.description = description;
        this.code = code;
        this.status = status;
        this.jobPostingUrls = jobPostingUrls;
        this.remoteCreatedAt = remoteCreatedAt;
        this.remoteUpdatedAt = remoteUpdatedAt;
        this.confidential = confidential;
        this.departments = departments;
        this.offices = offices;
        this.hiringManagers = hiringManagers;
        this.recruiters = recruiters;
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
     * @return The job's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The job's description.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The job's code. Typically an additional identifier used to reference the particular job that is displayed on the ATS.
     */
    @JsonProperty("code")
    public Optional<String> getCode() {
        return code;
    }

    /**
     * @return The job's status.
     * <ul>
     * <li><code>OPEN</code> - OPEN</li>
     * <li><code>CLOSED</code> - CLOSED</li>
     * <li><code>DRAFT</code> - DRAFT</li>
     * <li><code>ARCHIVED</code> - ARCHIVED</li>
     * <li><code>PENDING</code> - PENDING</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<JobStatus> getStatus() {
        return status;
    }

    @JsonProperty("job_posting_urls")
    public Optional<List<Url>> getJobPostingUrls() {
        return jobPostingUrls;
    }

    /**
     * @return When the third party's job was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return When the third party's job was updated.
     */
    @JsonProperty("remote_updated_at")
    public Optional<OffsetDateTime> getRemoteUpdatedAt() {
        return remoteUpdatedAt;
    }

    /**
     * @return Whether the job is confidential.
     */
    @JsonProperty("confidential")
    public Optional<Boolean> getConfidential() {
        return confidential;
    }

    /**
     * @return IDs of <code>Department</code> objects for this <code>Job</code>.
     */
    @JsonProperty("departments")
    public Optional<List<Optional<String>>> getDepartments() {
        return departments;
    }

    /**
     * @return IDs of <code>Office</code> objects for this <code>Job</code>.
     */
    @JsonProperty("offices")
    public Optional<List<Optional<String>>> getOffices() {
        return offices;
    }

    /**
     * @return IDs of <code>RemoteUser</code> objects that serve as hiring managers for this <code>Job</code>.
     */
    @JsonProperty("hiring_managers")
    public Optional<List<Optional<String>>> getHiringManagers() {
        return hiringManagers;
    }

    /**
     * @return IDs of <code>RemoteUser</code> objects that serve as recruiters for this <code>Job</code>.
     */
    @JsonProperty("recruiters")
    public Optional<List<Optional<String>>> getRecruiters() {
        return recruiters;
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
        return other instanceof Job && equalTo((Job) other);
    }

    private boolean equalTo(Job other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && name.equals(other.name)
                && description.equals(other.description)
                && code.equals(other.code)
                && status.equals(other.status)
                && jobPostingUrls.equals(other.jobPostingUrls)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && remoteUpdatedAt.equals(other.remoteUpdatedAt)
                && confidential.equals(other.confidential)
                && departments.equals(other.departments)
                && offices.equals(other.offices)
                && hiringManagers.equals(other.hiringManagers)
                && recruiters.equals(other.recruiters)
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
                this.name,
                this.description,
                this.code,
                this.status,
                this.jobPostingUrls,
                this.remoteCreatedAt,
                this.remoteUpdatedAt,
                this.confidential,
                this.departments,
                this.offices,
                this.hiringManagers,
                this.recruiters,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "Job{" + "id: " + id + ", remoteId: " + remoteId + ", name: " + name + ", description: " + description
                + ", code: " + code + ", status: " + status + ", jobPostingUrls: " + jobPostingUrls
                + ", remoteCreatedAt: " + remoteCreatedAt + ", remoteUpdatedAt: " + remoteUpdatedAt + ", confidential: "
                + confidential + ", departments: " + departments + ", offices: " + offices + ", hiringManagers: "
                + hiringManagers + ", recruiters: " + recruiters + ", remoteWasDeleted: " + remoteWasDeleted
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

        private Optional<String> name = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> code = Optional.empty();

        private Optional<JobStatus> status = Optional.empty();

        private Optional<List<Url>> jobPostingUrls = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<Boolean> confidential = Optional.empty();

        private Optional<List<Optional<String>>> departments = Optional.empty();

        private Optional<List<Optional<String>>> offices = Optional.empty();

        private Optional<List<Optional<String>>> hiringManagers = Optional.empty();

        private Optional<List<Optional<String>>> recruiters = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Job other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            name(other.getName());
            description(other.getDescription());
            code(other.getCode());
            status(other.getStatus());
            jobPostingUrls(other.getJobPostingUrls());
            remoteCreatedAt(other.getRemoteCreatedAt());
            remoteUpdatedAt(other.getRemoteUpdatedAt());
            confidential(other.getConfidential());
            departments(other.getDepartments());
            offices(other.getOffices());
            hiringManagers(other.getHiringManagers());
            recruiters(other.getRecruiters());
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "code", nulls = Nulls.SKIP)
        public Builder code(Optional<String> code) {
            this.code = code;
            return this;
        }

        public Builder code(String code) {
            this.code = Optional.of(code);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<JobStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(JobStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "job_posting_urls", nulls = Nulls.SKIP)
        public Builder jobPostingUrls(Optional<List<Url>> jobPostingUrls) {
            this.jobPostingUrls = jobPostingUrls;
            return this;
        }

        public Builder jobPostingUrls(List<Url> jobPostingUrls) {
            this.jobPostingUrls = Optional.of(jobPostingUrls);
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

        @JsonSetter(value = "confidential", nulls = Nulls.SKIP)
        public Builder confidential(Optional<Boolean> confidential) {
            this.confidential = confidential;
            return this;
        }

        public Builder confidential(Boolean confidential) {
            this.confidential = Optional.of(confidential);
            return this;
        }

        @JsonSetter(value = "departments", nulls = Nulls.SKIP)
        public Builder departments(Optional<List<Optional<String>>> departments) {
            this.departments = departments;
            return this;
        }

        public Builder departments(List<Optional<String>> departments) {
            this.departments = Optional.of(departments);
            return this;
        }

        @JsonSetter(value = "offices", nulls = Nulls.SKIP)
        public Builder offices(Optional<List<Optional<String>>> offices) {
            this.offices = offices;
            return this;
        }

        public Builder offices(List<Optional<String>> offices) {
            this.offices = Optional.of(offices);
            return this;
        }

        @JsonSetter(value = "hiring_managers", nulls = Nulls.SKIP)
        public Builder hiringManagers(Optional<List<Optional<String>>> hiringManagers) {
            this.hiringManagers = hiringManagers;
            return this;
        }

        public Builder hiringManagers(List<Optional<String>> hiringManagers) {
            this.hiringManagers = Optional.of(hiringManagers);
            return this;
        }

        @JsonSetter(value = "recruiters", nulls = Nulls.SKIP)
        public Builder recruiters(Optional<List<Optional<String>>> recruiters) {
            this.recruiters = recruiters;
            return this;
        }

        public Builder recruiters(List<Optional<String>> recruiters) {
            this.recruiters = Optional.of(recruiters);
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

        public Job build() {
            return new Job(
                    id,
                    remoteId,
                    name,
                    description,
                    code,
                    status,
                    jobPostingUrls,
                    remoteCreatedAt,
                    remoteUpdatedAt,
                    confidential,
                    departments,
                    offices,
                    hiringManagers,
                    recruiters,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

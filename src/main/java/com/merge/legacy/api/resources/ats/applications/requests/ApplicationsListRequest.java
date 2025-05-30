/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.legacy.api.resources.ats.applications.requests;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.legacy.api.core.ObjectMappers;
import com.merge.legacy.api.resources.ats.applications.types.ApplicationsListRequestExpand;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ApplicationsListRequest.Builder.class)
public final class ApplicationsListRequest {
    private final Optional<String> candidateId;

    private final Optional<OffsetDateTime> createdAfter;

    private final Optional<OffsetDateTime> createdBefore;

    private final Optional<String> creditedToId;

    private final Optional<String> currentStageId;

    private final Optional<String> cursor;

    private final Optional<ApplicationsListRequestExpand> expand;

    private final Optional<Boolean> includeDeletedData;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeShellData;

    private final Optional<String> jobId;

    private final Optional<OffsetDateTime> modifiedAfter;

    private final Optional<OffsetDateTime> modifiedBefore;

    private final Optional<Integer> pageSize;

    private final Optional<String> rejectReasonId;

    private final Optional<String> remoteId;

    private final Optional<String> source;

    private final Map<String, Object> additionalProperties;

    private ApplicationsListRequest(
            Optional<String> candidateId,
            Optional<OffsetDateTime> createdAfter,
            Optional<OffsetDateTime> createdBefore,
            Optional<String> creditedToId,
            Optional<String> currentStageId,
            Optional<String> cursor,
            Optional<ApplicationsListRequestExpand> expand,
            Optional<Boolean> includeDeletedData,
            Optional<Boolean> includeRemoteData,
            Optional<Boolean> includeShellData,
            Optional<String> jobId,
            Optional<OffsetDateTime> modifiedAfter,
            Optional<OffsetDateTime> modifiedBefore,
            Optional<Integer> pageSize,
            Optional<String> rejectReasonId,
            Optional<String> remoteId,
            Optional<String> source,
            Map<String, Object> additionalProperties) {
        this.candidateId = candidateId;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.creditedToId = creditedToId;
        this.currentStageId = currentStageId;
        this.cursor = cursor;
        this.expand = expand;
        this.includeDeletedData = includeDeletedData;
        this.includeRemoteData = includeRemoteData;
        this.includeShellData = includeShellData;
        this.jobId = jobId;
        this.modifiedAfter = modifiedAfter;
        this.modifiedBefore = modifiedBefore;
        this.pageSize = pageSize;
        this.rejectReasonId = rejectReasonId;
        this.remoteId = remoteId;
        this.source = source;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return If provided, will only return applications for this candidate.
     */
    @JsonProperty("candidate_id")
    public Optional<String> getCandidateId() {
        return candidateId;
    }

    /**
     * @return If provided, will only return objects created after this datetime.
     */
    @JsonProperty("created_after")
    public Optional<OffsetDateTime> getCreatedAfter() {
        return createdAfter;
    }

    /**
     * @return If provided, will only return objects created before this datetime.
     */
    @JsonProperty("created_before")
    public Optional<OffsetDateTime> getCreatedBefore() {
        return createdBefore;
    }

    /**
     * @return If provided, will only return applications credited to this user.
     */
    @JsonProperty("credited_to_id")
    public Optional<String> getCreditedToId() {
        return creditedToId;
    }

    /**
     * @return If provided, will only return applications at this interview stage.
     */
    @JsonProperty("current_stage_id")
    public Optional<String> getCurrentStageId() {
        return currentStageId;
    }

    /**
     * @return The pagination cursor value.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<ApplicationsListRequestExpand> getExpand() {
        return expand;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
     */
    @JsonProperty("include_deleted_data")
    public Optional<Boolean> getIncludeDeletedData() {
        return includeDeletedData;
    }

    /**
     * @return Whether to include the original data Merge fetched from the third-party to produce these models.
     */
    @JsonProperty("include_remote_data")
    public Optional<Boolean> getIncludeRemoteData() {
        return includeRemoteData;
    }

    /**
     * @return Whether to include shell records. Shell records are empty records (they may contain some metadata but all other fields are null).
     */
    @JsonProperty("include_shell_data")
    public Optional<Boolean> getIncludeShellData() {
        return includeShellData;
    }

    /**
     * @return If provided, will only return applications for this job.
     */
    @JsonProperty("job_id")
    public Optional<String> getJobId() {
        return jobId;
    }

    /**
     * @return If provided, only objects synced by Merge after this date time will be returned.
     */
    @JsonProperty("modified_after")
    public Optional<OffsetDateTime> getModifiedAfter() {
        return modifiedAfter;
    }

    /**
     * @return If provided, only objects synced by Merge before this date time will be returned.
     */
    @JsonProperty("modified_before")
    public Optional<OffsetDateTime> getModifiedBefore() {
        return modifiedBefore;
    }

    /**
     * @return Number of results to return per page.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    /**
     * @return If provided, will only return applications with this reject reason.
     */
    @JsonProperty("reject_reason_id")
    public Optional<String> getRejectReasonId() {
        return rejectReasonId;
    }

    /**
     * @return The API provider's ID for the given object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return If provided, will only return applications with this source.
     */
    @JsonProperty("source")
    public Optional<String> getSource() {
        return source;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ApplicationsListRequest && equalTo((ApplicationsListRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ApplicationsListRequest other) {
        return candidateId.equals(other.candidateId)
                && createdAfter.equals(other.createdAfter)
                && createdBefore.equals(other.createdBefore)
                && creditedToId.equals(other.creditedToId)
                && currentStageId.equals(other.currentStageId)
                && cursor.equals(other.cursor)
                && expand.equals(other.expand)
                && includeDeletedData.equals(other.includeDeletedData)
                && includeRemoteData.equals(other.includeRemoteData)
                && includeShellData.equals(other.includeShellData)
                && jobId.equals(other.jobId)
                && modifiedAfter.equals(other.modifiedAfter)
                && modifiedBefore.equals(other.modifiedBefore)
                && pageSize.equals(other.pageSize)
                && rejectReasonId.equals(other.rejectReasonId)
                && remoteId.equals(other.remoteId)
                && source.equals(other.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.candidateId,
                this.createdAfter,
                this.createdBefore,
                this.creditedToId,
                this.currentStageId,
                this.cursor,
                this.expand,
                this.includeDeletedData,
                this.includeRemoteData,
                this.includeShellData,
                this.jobId,
                this.modifiedAfter,
                this.modifiedBefore,
                this.pageSize,
                this.rejectReasonId,
                this.remoteId,
                this.source);
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
        private Optional<String> candidateId = Optional.empty();

        private Optional<OffsetDateTime> createdAfter = Optional.empty();

        private Optional<OffsetDateTime> createdBefore = Optional.empty();

        private Optional<String> creditedToId = Optional.empty();

        private Optional<String> currentStageId = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<ApplicationsListRequestExpand> expand = Optional.empty();

        private Optional<Boolean> includeDeletedData = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeShellData = Optional.empty();

        private Optional<String> jobId = Optional.empty();

        private Optional<OffsetDateTime> modifiedAfter = Optional.empty();

        private Optional<OffsetDateTime> modifiedBefore = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> rejectReasonId = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> source = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ApplicationsListRequest other) {
            candidateId(other.getCandidateId());
            createdAfter(other.getCreatedAfter());
            createdBefore(other.getCreatedBefore());
            creditedToId(other.getCreditedToId());
            currentStageId(other.getCurrentStageId());
            cursor(other.getCursor());
            expand(other.getExpand());
            includeDeletedData(other.getIncludeDeletedData());
            includeRemoteData(other.getIncludeRemoteData());
            includeShellData(other.getIncludeShellData());
            jobId(other.getJobId());
            modifiedAfter(other.getModifiedAfter());
            modifiedBefore(other.getModifiedBefore());
            pageSize(other.getPageSize());
            rejectReasonId(other.getRejectReasonId());
            remoteId(other.getRemoteId());
            source(other.getSource());
            return this;
        }

        @JsonSetter(value = "candidate_id", nulls = Nulls.SKIP)
        public Builder candidateId(Optional<String> candidateId) {
            this.candidateId = candidateId;
            return this;
        }

        public Builder candidateId(String candidateId) {
            this.candidateId = Optional.ofNullable(candidateId);
            return this;
        }

        @JsonSetter(value = "created_after", nulls = Nulls.SKIP)
        public Builder createdAfter(Optional<OffsetDateTime> createdAfter) {
            this.createdAfter = createdAfter;
            return this;
        }

        public Builder createdAfter(OffsetDateTime createdAfter) {
            this.createdAfter = Optional.ofNullable(createdAfter);
            return this;
        }

        @JsonSetter(value = "created_before", nulls = Nulls.SKIP)
        public Builder createdBefore(Optional<OffsetDateTime> createdBefore) {
            this.createdBefore = createdBefore;
            return this;
        }

        public Builder createdBefore(OffsetDateTime createdBefore) {
            this.createdBefore = Optional.ofNullable(createdBefore);
            return this;
        }

        @JsonSetter(value = "credited_to_id", nulls = Nulls.SKIP)
        public Builder creditedToId(Optional<String> creditedToId) {
            this.creditedToId = creditedToId;
            return this;
        }

        public Builder creditedToId(String creditedToId) {
            this.creditedToId = Optional.ofNullable(creditedToId);
            return this;
        }

        @JsonSetter(value = "current_stage_id", nulls = Nulls.SKIP)
        public Builder currentStageId(Optional<String> currentStageId) {
            this.currentStageId = currentStageId;
            return this;
        }

        public Builder currentStageId(String currentStageId) {
            this.currentStageId = Optional.ofNullable(currentStageId);
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<ApplicationsListRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(ApplicationsListRequestExpand expand) {
            this.expand = Optional.ofNullable(expand);
            return this;
        }

        @JsonSetter(value = "include_deleted_data", nulls = Nulls.SKIP)
        public Builder includeDeletedData(Optional<Boolean> includeDeletedData) {
            this.includeDeletedData = includeDeletedData;
            return this;
        }

        public Builder includeDeletedData(Boolean includeDeletedData) {
            this.includeDeletedData = Optional.ofNullable(includeDeletedData);
            return this;
        }

        @JsonSetter(value = "include_remote_data", nulls = Nulls.SKIP)
        public Builder includeRemoteData(Optional<Boolean> includeRemoteData) {
            this.includeRemoteData = includeRemoteData;
            return this;
        }

        public Builder includeRemoteData(Boolean includeRemoteData) {
            this.includeRemoteData = Optional.ofNullable(includeRemoteData);
            return this;
        }

        @JsonSetter(value = "include_shell_data", nulls = Nulls.SKIP)
        public Builder includeShellData(Optional<Boolean> includeShellData) {
            this.includeShellData = includeShellData;
            return this;
        }

        public Builder includeShellData(Boolean includeShellData) {
            this.includeShellData = Optional.ofNullable(includeShellData);
            return this;
        }

        @JsonSetter(value = "job_id", nulls = Nulls.SKIP)
        public Builder jobId(Optional<String> jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder jobId(String jobId) {
            this.jobId = Optional.ofNullable(jobId);
            return this;
        }

        @JsonSetter(value = "modified_after", nulls = Nulls.SKIP)
        public Builder modifiedAfter(Optional<OffsetDateTime> modifiedAfter) {
            this.modifiedAfter = modifiedAfter;
            return this;
        }

        public Builder modifiedAfter(OffsetDateTime modifiedAfter) {
            this.modifiedAfter = Optional.ofNullable(modifiedAfter);
            return this;
        }

        @JsonSetter(value = "modified_before", nulls = Nulls.SKIP)
        public Builder modifiedBefore(Optional<OffsetDateTime> modifiedBefore) {
            this.modifiedBefore = modifiedBefore;
            return this;
        }

        public Builder modifiedBefore(OffsetDateTime modifiedBefore) {
            this.modifiedBefore = Optional.ofNullable(modifiedBefore);
            return this;
        }

        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.ofNullable(pageSize);
            return this;
        }

        @JsonSetter(value = "reject_reason_id", nulls = Nulls.SKIP)
        public Builder rejectReasonId(Optional<String> rejectReasonId) {
            this.rejectReasonId = rejectReasonId;
            return this;
        }

        public Builder rejectReasonId(String rejectReasonId) {
            this.rejectReasonId = Optional.ofNullable(rejectReasonId);
            return this;
        }

        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.ofNullable(remoteId);
            return this;
        }

        @JsonSetter(value = "source", nulls = Nulls.SKIP)
        public Builder source(Optional<String> source) {
            this.source = source;
            return this;
        }

        public Builder source(String source) {
            this.source = Optional.ofNullable(source);
            return this;
        }

        public ApplicationsListRequest build() {
            return new ApplicationsListRequest(
                    candidateId,
                    createdAfter,
                    createdBefore,
                    creditedToId,
                    currentStageId,
                    cursor,
                    expand,
                    includeDeletedData,
                    includeRemoteData,
                    includeShellData,
                    jobId,
                    modifiedAfter,
                    modifiedBefore,
                    pageSize,
                    rejectReasonId,
                    remoteId,
                    source,
                    additionalProperties);
        }
    }
}

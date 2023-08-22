package com.merge.api.resources.ats.applications.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UpdateApplicationStageRequest.Builder.class)
public final class UpdateApplicationStageRequest {
    private final Optional<Boolean> isDebugMode;

    private final Optional<Boolean> runAsync;

    private final Optional<String> jobInterviewStage;

    private final Optional<String> remoteUserId;

    private UpdateApplicationStageRequest(
            Optional<Boolean> isDebugMode,
            Optional<Boolean> runAsync,
            Optional<String> jobInterviewStage,
            Optional<String> remoteUserId) {
        this.isDebugMode = isDebugMode;
        this.runAsync = runAsync;
        this.jobInterviewStage = jobInterviewStage;
        this.remoteUserId = remoteUserId;
    }

    /**
     * @return Whether to include debug fields (such as log file links) in the response.
     */
    @JsonProperty("is_debug_mode")
    public Optional<Boolean> getIsDebugMode() {
        return isDebugMode;
    }

    /**
     * @return Whether or not third-party updates should be run asynchronously.
     */
    @JsonProperty("run_async")
    public Optional<Boolean> getRunAsync() {
        return runAsync;
    }

    /**
     * @return The interview stage to move the application to.
     */
    @JsonProperty("job_interview_stage")
    public Optional<String> getJobInterviewStage() {
        return jobInterviewStage;
    }

    /**
     * @return &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("remote_user_id")
    public Optional<String> getRemoteUserId() {
        return remoteUserId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateApplicationStageRequest && equalTo((UpdateApplicationStageRequest) other);
    }

    private boolean equalTo(UpdateApplicationStageRequest other) {
        return isDebugMode.equals(other.isDebugMode)
                && runAsync.equals(other.runAsync)
                && jobInterviewStage.equals(other.jobInterviewStage)
                && remoteUserId.equals(other.remoteUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isDebugMode, this.runAsync, this.jobInterviewStage, this.remoteUserId);
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
        private Optional<Boolean> isDebugMode = Optional.empty();

        private Optional<Boolean> runAsync = Optional.empty();

        private Optional<String> jobInterviewStage = Optional.empty();

        private Optional<String> remoteUserId = Optional.empty();

        private Builder() {}

        public Builder from(UpdateApplicationStageRequest other) {
            isDebugMode(other.getIsDebugMode());
            runAsync(other.getRunAsync());
            jobInterviewStage(other.getJobInterviewStage());
            remoteUserId(other.getRemoteUserId());
            return this;
        }

        @JsonSetter(value = "is_debug_mode", nulls = Nulls.SKIP)
        public Builder isDebugMode(Optional<Boolean> isDebugMode) {
            this.isDebugMode = isDebugMode;
            return this;
        }

        public Builder isDebugMode(Boolean isDebugMode) {
            this.isDebugMode = Optional.of(isDebugMode);
            return this;
        }

        @JsonSetter(value = "run_async", nulls = Nulls.SKIP)
        public Builder runAsync(Optional<Boolean> runAsync) {
            this.runAsync = runAsync;
            return this;
        }

        public Builder runAsync(Boolean runAsync) {
            this.runAsync = Optional.of(runAsync);
            return this;
        }

        @JsonSetter(value = "job_interview_stage", nulls = Nulls.SKIP)
        public Builder jobInterviewStage(Optional<String> jobInterviewStage) {
            this.jobInterviewStage = jobInterviewStage;
            return this;
        }

        public Builder jobInterviewStage(String jobInterviewStage) {
            this.jobInterviewStage = Optional.of(jobInterviewStage);
            return this;
        }

        @JsonSetter(value = "remote_user_id", nulls = Nulls.SKIP)
        public Builder remoteUserId(Optional<String> remoteUserId) {
            this.remoteUserId = remoteUserId;
            return this;
        }

        public Builder remoteUserId(String remoteUserId) {
            this.remoteUserId = Optional.of(remoteUserId);
            return this;
        }

        public UpdateApplicationStageRequest build() {
            return new UpdateApplicationStageRequest(isDebugMode, runAsync, jobInterviewStage, remoteUserId);
        }
    }
}

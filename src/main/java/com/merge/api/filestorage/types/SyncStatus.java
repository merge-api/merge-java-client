/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.filestorage.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SyncStatus.Builder.class)
public final class SyncStatus {
    private final String modelName;

    private final String modelId;

    private final Optional<OffsetDateTime> lastSyncStart;

    private final Optional<OffsetDateTime> nextSyncStart;

    private final Optional<SyncStatusLastSyncResult> lastSyncResult;

    private final Optional<OffsetDateTime> lastSyncFinished;

    private final SyncStatusStatus status;

    private final boolean isInitialSync;

    private final Optional<SelectiveSyncConfigurationsUsageEnum> selectiveSyncConfigurationsUsage;

    private final Map<String, Object> additionalProperties;

    private SyncStatus(
            String modelName,
            String modelId,
            Optional<OffsetDateTime> lastSyncStart,
            Optional<OffsetDateTime> nextSyncStart,
            Optional<SyncStatusLastSyncResult> lastSyncResult,
            Optional<OffsetDateTime> lastSyncFinished,
            SyncStatusStatus status,
            boolean isInitialSync,
            Optional<SelectiveSyncConfigurationsUsageEnum> selectiveSyncConfigurationsUsage,
            Map<String, Object> additionalProperties) {
        this.modelName = modelName;
        this.modelId = modelId;
        this.lastSyncStart = lastSyncStart;
        this.nextSyncStart = nextSyncStart;
        this.lastSyncResult = lastSyncResult;
        this.lastSyncFinished = lastSyncFinished;
        this.status = status;
        this.isInitialSync = isInitialSync;
        this.selectiveSyncConfigurationsUsage = selectiveSyncConfigurationsUsage;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("model_name")
    public String getModelName() {
        return modelName;
    }

    @JsonProperty("model_id")
    public String getModelId() {
        return modelId;
    }

    @JsonProperty("last_sync_start")
    public Optional<OffsetDateTime> getLastSyncStart() {
        return lastSyncStart;
    }

    @JsonProperty("next_sync_start")
    public Optional<OffsetDateTime> getNextSyncStart() {
        return nextSyncStart;
    }

    @JsonProperty("last_sync_result")
    public Optional<SyncStatusLastSyncResult> getLastSyncResult() {
        return lastSyncResult;
    }

    @JsonProperty("last_sync_finished")
    public Optional<OffsetDateTime> getLastSyncFinished() {
        return lastSyncFinished;
    }

    @JsonProperty("status")
    public SyncStatusStatus getStatus() {
        return status;
    }

    @JsonProperty("is_initial_sync")
    public boolean getIsInitialSync() {
        return isInitialSync;
    }

    @JsonProperty("selective_sync_configurations_usage")
    public Optional<SelectiveSyncConfigurationsUsageEnum> getSelectiveSyncConfigurationsUsage() {
        return selectiveSyncConfigurationsUsage;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SyncStatus && equalTo((SyncStatus) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SyncStatus other) {
        return modelName.equals(other.modelName)
                && modelId.equals(other.modelId)
                && lastSyncStart.equals(other.lastSyncStart)
                && nextSyncStart.equals(other.nextSyncStart)
                && lastSyncResult.equals(other.lastSyncResult)
                && lastSyncFinished.equals(other.lastSyncFinished)
                && status.equals(other.status)
                && isInitialSync == other.isInitialSync
                && selectiveSyncConfigurationsUsage.equals(other.selectiveSyncConfigurationsUsage);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.modelName,
                this.modelId,
                this.lastSyncStart,
                this.nextSyncStart,
                this.lastSyncResult,
                this.lastSyncFinished,
                this.status,
                this.isInitialSync,
                this.selectiveSyncConfigurationsUsage);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelNameStage builder() {
        return new Builder();
    }

    public interface ModelNameStage {
        ModelIdStage modelName(@NotNull String modelName);

        Builder from(SyncStatus other);
    }

    public interface ModelIdStage {
        StatusStage modelId(@NotNull String modelId);
    }

    public interface StatusStage {
        IsInitialSyncStage status(@NotNull SyncStatusStatus status);
    }

    public interface IsInitialSyncStage {
        _FinalStage isInitialSync(boolean isInitialSync);
    }

    public interface _FinalStage {
        SyncStatus build();

        _FinalStage lastSyncStart(Optional<OffsetDateTime> lastSyncStart);

        _FinalStage lastSyncStart(OffsetDateTime lastSyncStart);

        _FinalStage nextSyncStart(Optional<OffsetDateTime> nextSyncStart);

        _FinalStage nextSyncStart(OffsetDateTime nextSyncStart);

        _FinalStage lastSyncResult(Optional<SyncStatusLastSyncResult> lastSyncResult);

        _FinalStage lastSyncResult(SyncStatusLastSyncResult lastSyncResult);

        _FinalStage lastSyncFinished(Optional<OffsetDateTime> lastSyncFinished);

        _FinalStage lastSyncFinished(OffsetDateTime lastSyncFinished);

        _FinalStage selectiveSyncConfigurationsUsage(
                Optional<SelectiveSyncConfigurationsUsageEnum> selectiveSyncConfigurationsUsage);

        _FinalStage selectiveSyncConfigurationsUsage(
                SelectiveSyncConfigurationsUsageEnum selectiveSyncConfigurationsUsage);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements ModelNameStage, ModelIdStage, StatusStage, IsInitialSyncStage, _FinalStage {
        private String modelName;

        private String modelId;

        private SyncStatusStatus status;

        private boolean isInitialSync;

        private Optional<SelectiveSyncConfigurationsUsageEnum> selectiveSyncConfigurationsUsage = Optional.empty();

        private Optional<OffsetDateTime> lastSyncFinished = Optional.empty();

        private Optional<SyncStatusLastSyncResult> lastSyncResult = Optional.empty();

        private Optional<OffsetDateTime> nextSyncStart = Optional.empty();

        private Optional<OffsetDateTime> lastSyncStart = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(SyncStatus other) {
            modelName(other.getModelName());
            modelId(other.getModelId());
            lastSyncStart(other.getLastSyncStart());
            nextSyncStart(other.getNextSyncStart());
            lastSyncResult(other.getLastSyncResult());
            lastSyncFinished(other.getLastSyncFinished());
            status(other.getStatus());
            isInitialSync(other.getIsInitialSync());
            selectiveSyncConfigurationsUsage(other.getSelectiveSyncConfigurationsUsage());
            return this;
        }

        @java.lang.Override
        @JsonSetter("model_name")
        public ModelIdStage modelName(@NotNull String modelName) {
            this.modelName = modelName;
            return this;
        }

        @java.lang.Override
        @JsonSetter("model_id")
        public StatusStage modelId(@NotNull String modelId) {
            this.modelId = modelId;
            return this;
        }

        @java.lang.Override
        @JsonSetter("status")
        public IsInitialSyncStage status(@NotNull SyncStatusStatus status) {
            this.status = status;
            return this;
        }

        @java.lang.Override
        @JsonSetter("is_initial_sync")
        public _FinalStage isInitialSync(boolean isInitialSync) {
            this.isInitialSync = isInitialSync;
            return this;
        }

        @java.lang.Override
        public _FinalStage selectiveSyncConfigurationsUsage(
                SelectiveSyncConfigurationsUsageEnum selectiveSyncConfigurationsUsage) {
            this.selectiveSyncConfigurationsUsage = Optional.ofNullable(selectiveSyncConfigurationsUsage);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "selective_sync_configurations_usage", nulls = Nulls.SKIP)
        public _FinalStage selectiveSyncConfigurationsUsage(
                Optional<SelectiveSyncConfigurationsUsageEnum> selectiveSyncConfigurationsUsage) {
            this.selectiveSyncConfigurationsUsage = selectiveSyncConfigurationsUsage;
            return this;
        }

        @java.lang.Override
        public _FinalStage lastSyncFinished(OffsetDateTime lastSyncFinished) {
            this.lastSyncFinished = Optional.ofNullable(lastSyncFinished);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "last_sync_finished", nulls = Nulls.SKIP)
        public _FinalStage lastSyncFinished(Optional<OffsetDateTime> lastSyncFinished) {
            this.lastSyncFinished = lastSyncFinished;
            return this;
        }

        @java.lang.Override
        public _FinalStage lastSyncResult(SyncStatusLastSyncResult lastSyncResult) {
            this.lastSyncResult = Optional.ofNullable(lastSyncResult);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "last_sync_result", nulls = Nulls.SKIP)
        public _FinalStage lastSyncResult(Optional<SyncStatusLastSyncResult> lastSyncResult) {
            this.lastSyncResult = lastSyncResult;
            return this;
        }

        @java.lang.Override
        public _FinalStage nextSyncStart(OffsetDateTime nextSyncStart) {
            this.nextSyncStart = Optional.ofNullable(nextSyncStart);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "next_sync_start", nulls = Nulls.SKIP)
        public _FinalStage nextSyncStart(Optional<OffsetDateTime> nextSyncStart) {
            this.nextSyncStart = nextSyncStart;
            return this;
        }

        @java.lang.Override
        public _FinalStage lastSyncStart(OffsetDateTime lastSyncStart) {
            this.lastSyncStart = Optional.ofNullable(lastSyncStart);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "last_sync_start", nulls = Nulls.SKIP)
        public _FinalStage lastSyncStart(Optional<OffsetDateTime> lastSyncStart) {
            this.lastSyncStart = lastSyncStart;
            return this;
        }

        @java.lang.Override
        public SyncStatus build() {
            return new SyncStatus(
                    modelName,
                    modelId,
                    lastSyncStart,
                    nextSyncStart,
                    lastSyncResult,
                    lastSyncFinished,
                    status,
                    isInitialSync,
                    selectiveSyncConfigurationsUsage,
                    additionalProperties);
        }
    }
}

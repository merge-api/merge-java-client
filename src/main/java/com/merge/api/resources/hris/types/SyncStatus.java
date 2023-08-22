package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SyncStatus.Builder.class)
public final class SyncStatus {
    private final String modelName;

    private final String modelId;

    private final Optional<OffsetDateTime> lastSyncStart;

    private final Optional<OffsetDateTime> nextSyncStart;

    private final SyncStatusStatusEnum status;

    private final boolean isInitialSync;

    private final Optional<SelectiveSyncConfigurationsUsageEnum> selectiveSyncConfigurationsUsage;

    private SyncStatus(
            String modelName,
            String modelId,
            Optional<OffsetDateTime> lastSyncStart,
            Optional<OffsetDateTime> nextSyncStart,
            SyncStatusStatusEnum status,
            boolean isInitialSync,
            Optional<SelectiveSyncConfigurationsUsageEnum> selectiveSyncConfigurationsUsage) {
        this.modelName = modelName;
        this.modelId = modelId;
        this.lastSyncStart = lastSyncStart;
        this.nextSyncStart = nextSyncStart;
        this.status = status;
        this.isInitialSync = isInitialSync;
        this.selectiveSyncConfigurationsUsage = selectiveSyncConfigurationsUsage;
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

    @JsonProperty("status")
    public SyncStatusStatusEnum getStatus() {
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SyncStatus && equalTo((SyncStatus) other);
    }

    private boolean equalTo(SyncStatus other) {
        return modelName.equals(other.modelName)
                && modelId.equals(other.modelId)
                && lastSyncStart.equals(other.lastSyncStart)
                && nextSyncStart.equals(other.nextSyncStart)
                && status.equals(other.status)
                && isInitialSync == other.isInitialSync
                && selectiveSyncConfigurationsUsage.equals(other.selectiveSyncConfigurationsUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.modelName,
                this.modelId,
                this.lastSyncStart,
                this.nextSyncStart,
                this.status,
                this.isInitialSync,
                this.selectiveSyncConfigurationsUsage);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelNameStage builder() {
        return new Builder();
    }

    public interface ModelNameStage {
        ModelIdStage modelName(String modelName);

        Builder from(SyncStatus other);
    }

    public interface ModelIdStage {
        StatusStage modelId(String modelId);
    }

    public interface StatusStage {
        IsInitialSyncStage status(SyncStatusStatusEnum status);
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

        private SyncStatusStatusEnum status;

        private boolean isInitialSync;

        private Optional<SelectiveSyncConfigurationsUsageEnum> selectiveSyncConfigurationsUsage = Optional.empty();

        private Optional<OffsetDateTime> nextSyncStart = Optional.empty();

        private Optional<OffsetDateTime> lastSyncStart = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(SyncStatus other) {
            modelName(other.getModelName());
            modelId(other.getModelId());
            lastSyncStart(other.getLastSyncStart());
            nextSyncStart(other.getNextSyncStart());
            status(other.getStatus());
            isInitialSync(other.getIsInitialSync());
            selectiveSyncConfigurationsUsage(other.getSelectiveSyncConfigurationsUsage());
            return this;
        }

        @Override
        @JsonSetter("model_name")
        public ModelIdStage modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        @Override
        @JsonSetter("model_id")
        public StatusStage modelId(String modelId) {
            this.modelId = modelId;
            return this;
        }

        @Override
        @JsonSetter("status")
        public IsInitialSyncStage status(SyncStatusStatusEnum status) {
            this.status = status;
            return this;
        }

        @Override
        @JsonSetter("is_initial_sync")
        public _FinalStage isInitialSync(boolean isInitialSync) {
            this.isInitialSync = isInitialSync;
            return this;
        }

        @Override
        public _FinalStage selectiveSyncConfigurationsUsage(
                SelectiveSyncConfigurationsUsageEnum selectiveSyncConfigurationsUsage) {
            this.selectiveSyncConfigurationsUsage = Optional.of(selectiveSyncConfigurationsUsage);
            return this;
        }

        @Override
        @JsonSetter(value = "selective_sync_configurations_usage", nulls = Nulls.SKIP)
        public _FinalStage selectiveSyncConfigurationsUsage(
                Optional<SelectiveSyncConfigurationsUsageEnum> selectiveSyncConfigurationsUsage) {
            this.selectiveSyncConfigurationsUsage = selectiveSyncConfigurationsUsage;
            return this;
        }

        @Override
        public _FinalStage nextSyncStart(OffsetDateTime nextSyncStart) {
            this.nextSyncStart = Optional.of(nextSyncStart);
            return this;
        }

        @Override
        @JsonSetter(value = "next_sync_start", nulls = Nulls.SKIP)
        public _FinalStage nextSyncStart(Optional<OffsetDateTime> nextSyncStart) {
            this.nextSyncStart = nextSyncStart;
            return this;
        }

        @Override
        public _FinalStage lastSyncStart(OffsetDateTime lastSyncStart) {
            this.lastSyncStart = Optional.of(lastSyncStart);
            return this;
        }

        @Override
        @JsonSetter(value = "last_sync_start", nulls = Nulls.SKIP)
        public _FinalStage lastSyncStart(Optional<OffsetDateTime> lastSyncStart) {
            this.lastSyncStart = lastSyncStart;
            return this;
        }

        @Override
        public SyncStatus build() {
            return new SyncStatus(
                    modelName,
                    modelId,
                    lastSyncStart,
                    nextSyncStart,
                    status,
                    isInitialSync,
                    selectiveSyncConfigurationsUsage);
        }
    }
}

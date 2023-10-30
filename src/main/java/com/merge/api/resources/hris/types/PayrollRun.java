package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PayrollRun.Builder.class)
public final class PayrollRun {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<PayrollRunRunState> runState;

    private final Optional<PayrollRunRunType> runType;

    private final Optional<OffsetDateTime> startDate;

    private final Optional<OffsetDateTime> endDate;

    private final Optional<OffsetDateTime> checkDate;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private PayrollRun(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<PayrollRunRunState> runState,
            Optional<PayrollRunRunType> runType,
            Optional<OffsetDateTime> startDate,
            Optional<OffsetDateTime> endDate,
            Optional<OffsetDateTime> checkDate,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.runState = runState;
        this.runType = runType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkDate = checkDate;
        this.remoteWasDeleted = remoteWasDeleted;
        this.createdAt = createdAt;
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
     * @return The state of the payroll run
     * <ul>
     * <li><code>PAID</code> - PAID</li>
     * <li><code>DRAFT</code> - DRAFT</li>
     * <li><code>APPROVED</code> - APPROVED</li>
     * <li><code>FAILED</code> - FAILED</li>
     * <li><code>CLOSED</code> - CLOSED</li>
     * </ul>
     */
    @JsonProperty("run_state")
    public Optional<PayrollRunRunState> getRunState() {
        return runState;
    }

    /**
     * @return The type of the payroll run
     * <ul>
     * <li><code>REGULAR</code> - REGULAR</li>
     * <li><code>OFF_CYCLE</code> - OFF_CYCLE</li>
     * <li><code>CORRECTION</code> - CORRECTION</li>
     * <li><code>TERMINATION</code> - TERMINATION</li>
     * <li><code>SIGN_ON_BONUS</code> - SIGN_ON_BONUS</li>
     * </ul>
     */
    @JsonProperty("run_type")
    public Optional<PayrollRunRunType> getRunType() {
        return runType;
    }

    /**
     * @return The day and time the payroll run started.
     */
    @JsonProperty("start_date")
    public Optional<OffsetDateTime> getStartDate() {
        return startDate;
    }

    /**
     * @return The day and time the payroll run ended.
     */
    @JsonProperty("end_date")
    public Optional<OffsetDateTime> getEndDate() {
        return endDate;
    }

    /**
     * @return The day and time the payroll run was checked.
     */
    @JsonProperty("check_date")
    public Optional<OffsetDateTime> getCheckDate() {
        return checkDate;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
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
        return other instanceof PayrollRun && equalTo((PayrollRun) other);
    }

    private boolean equalTo(PayrollRun other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && runState.equals(other.runState)
                && runType.equals(other.runType)
                && startDate.equals(other.startDate)
                && endDate.equals(other.endDate)
                && checkDate.equals(other.checkDate)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.runState,
                this.runType,
                this.startDate,
                this.endDate,
                this.checkDate,
                this.remoteWasDeleted,
                this.createdAt,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<PayrollRunRunState> runState = Optional.empty();

        private Optional<PayrollRunRunType> runType = Optional.empty();

        private Optional<OffsetDateTime> startDate = Optional.empty();

        private Optional<OffsetDateTime> endDate = Optional.empty();

        private Optional<OffsetDateTime> checkDate = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(PayrollRun other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            runState(other.getRunState());
            runType(other.getRunType());
            startDate(other.getStartDate());
            endDate(other.getEndDate());
            checkDate(other.getCheckDate());
            remoteWasDeleted(other.getRemoteWasDeleted());
            createdAt(other.getCreatedAt());
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

        @JsonSetter(value = "run_state", nulls = Nulls.SKIP)
        public Builder runState(Optional<PayrollRunRunState> runState) {
            this.runState = runState;
            return this;
        }

        public Builder runState(PayrollRunRunState runState) {
            this.runState = Optional.of(runState);
            return this;
        }

        @JsonSetter(value = "run_type", nulls = Nulls.SKIP)
        public Builder runType(Optional<PayrollRunRunType> runType) {
            this.runType = runType;
            return this;
        }

        public Builder runType(PayrollRunRunType runType) {
            this.runType = Optional.of(runType);
            return this;
        }

        @JsonSetter(value = "start_date", nulls = Nulls.SKIP)
        public Builder startDate(Optional<OffsetDateTime> startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder startDate(OffsetDateTime startDate) {
            this.startDate = Optional.of(startDate);
            return this;
        }

        @JsonSetter(value = "end_date", nulls = Nulls.SKIP)
        public Builder endDate(Optional<OffsetDateTime> endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder endDate(OffsetDateTime endDate) {
            this.endDate = Optional.of(endDate);
            return this;
        }

        @JsonSetter(value = "check_date", nulls = Nulls.SKIP)
        public Builder checkDate(Optional<OffsetDateTime> checkDate) {
            this.checkDate = checkDate;
            return this;
        }

        public Builder checkDate(OffsetDateTime checkDate) {
            this.checkDate = Optional.of(checkDate);
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

        public PayrollRun build() {
            return new PayrollRun(
                    id,
                    remoteId,
                    runState,
                    runType,
                    startDate,
                    endDate,
                    checkDate,
                    remoteWasDeleted,
                    createdAt,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

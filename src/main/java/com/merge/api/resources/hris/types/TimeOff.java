/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.hris.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TimeOff.Builder.class)
public final class TimeOff {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<TimeOffEmployee> employee;

    private final Optional<TimeOffApprover> approver;

    private final Optional<TimeOffStatus> status;

    private final Optional<String> employeeNote;

    private final Optional<TimeOffUnits> units;

    private final Optional<Double> amount;

    private final Optional<TimeOffRequestType> requestType;

    private final Optional<OffsetDateTime> startTime;

    private final Optional<OffsetDateTime> endTime;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private final Map<String, Object> additionalProperties;

    private TimeOff(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<TimeOffEmployee> employee,
            Optional<TimeOffApprover> approver,
            Optional<TimeOffStatus> status,
            Optional<String> employeeNote,
            Optional<TimeOffUnits> units,
            Optional<Double> amount,
            Optional<TimeOffRequestType> requestType,
            Optional<OffsetDateTime> startTime,
            Optional<OffsetDateTime> endTime,
            Optional<Boolean> remoteWasDeleted,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.employee = employee;
        this.approver = approver;
        this.status = status;
        this.employeeNote = employeeNote;
        this.units = units;
        this.amount = amount;
        this.requestType = requestType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remoteWasDeleted = remoteWasDeleted;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
        this.additionalProperties = additionalProperties;
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
     * @return The datetime that this object was created by Merge.
     */
    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The datetime that this object was modified by Merge.
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    /**
     * @return The employee requesting time off.
     */
    @JsonProperty("employee")
    public Optional<TimeOffEmployee> getEmployee() {
        return employee;
    }

    /**
     * @return The Merge ID of the employee with the ability to approve the time off request.
     */
    @JsonProperty("approver")
    public Optional<TimeOffApprover> getApprover() {
        return approver;
    }

    /**
     * @return The status of this time off request.
     * <ul>
     * <li><code>REQUESTED</code> - REQUESTED</li>
     * <li><code>APPROVED</code> - APPROVED</li>
     * <li><code>DECLINED</code> - DECLINED</li>
     * <li><code>CANCELLED</code> - CANCELLED</li>
     * <li><code>DELETED</code> - DELETED</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<TimeOffStatus> getStatus() {
        return status;
    }

    /**
     * @return The employee note for this time off request.
     */
    @JsonProperty("employee_note")
    public Optional<String> getEmployeeNote() {
        return employeeNote;
    }

    /**
     * @return The measurement that the third-party integration uses to count time requested.
     * <ul>
     * <li><code>HOURS</code> - HOURS</li>
     * <li><code>DAYS</code> - DAYS</li>
     * </ul>
     */
    @JsonProperty("units")
    public Optional<TimeOffUnits> getUnits() {
        return units;
    }

    /**
     * @return The time off quantity measured by the prescribed “units”.
     */
    @JsonProperty("amount")
    public Optional<Double> getAmount() {
        return amount;
    }

    /**
     * @return The type of time off request.
     * <ul>
     * <li><code>VACATION</code> - VACATION</li>
     * <li><code>SICK</code> - SICK</li>
     * <li><code>PERSONAL</code> - PERSONAL</li>
     * <li><code>JURY_DUTY</code> - JURY_DUTY</li>
     * <li><code>VOLUNTEER</code> - VOLUNTEER</li>
     * <li><code>BEREAVEMENT</code> - BEREAVEMENT</li>
     * </ul>
     */
    @JsonProperty("request_type")
    public Optional<TimeOffRequestType> getRequestType() {
        return requestType;
    }

    /**
     * @return The day and time of the start of the time requested off.
     */
    @JsonProperty("start_time")
    public Optional<OffsetDateTime> getStartTime() {
        return startTime;
    }

    /**
     * @return The day and time of the end of the time requested off.
     */
    @JsonProperty("end_time")
    public Optional<OffsetDateTime> getEndTime() {
        return endTime;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    @JsonProperty("field_mappings")
    public Optional<Map<String, JsonNode>> getFieldMappings() {
        return fieldMappings;
    }

    @JsonProperty("remote_data")
    public Optional<List<RemoteData>> getRemoteData() {
        return remoteData;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TimeOff && equalTo((TimeOff) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TimeOff other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && employee.equals(other.employee)
                && approver.equals(other.approver)
                && status.equals(other.status)
                && employeeNote.equals(other.employeeNote)
                && units.equals(other.units)
                && amount.equals(other.amount)
                && requestType.equals(other.requestType)
                && startTime.equals(other.startTime)
                && endTime.equals(other.endTime)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.createdAt,
                this.modifiedAt,
                this.employee,
                this.approver,
                this.status,
                this.employeeNote,
                this.units,
                this.amount,
                this.requestType,
                this.startTime,
                this.endTime,
                this.remoteWasDeleted,
                this.fieldMappings,
                this.remoteData);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<TimeOffEmployee> employee = Optional.empty();

        private Optional<TimeOffApprover> approver = Optional.empty();

        private Optional<TimeOffStatus> status = Optional.empty();

        private Optional<String> employeeNote = Optional.empty();

        private Optional<TimeOffUnits> units = Optional.empty();

        private Optional<Double> amount = Optional.empty();

        private Optional<TimeOffRequestType> requestType = Optional.empty();

        private Optional<OffsetDateTime> startTime = Optional.empty();

        private Optional<OffsetDateTime> endTime = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(TimeOff other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            employee(other.getEmployee());
            approver(other.getApprover());
            status(other.getStatus());
            employeeNote(other.getEmployeeNote());
            units(other.getUnits());
            amount(other.getAmount());
            requestType(other.getRequestType());
            startTime(other.getStartTime());
            endTime(other.getEndTime());
            remoteWasDeleted(other.getRemoteWasDeleted());
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

        @JsonSetter(value = "employee", nulls = Nulls.SKIP)
        public Builder employee(Optional<TimeOffEmployee> employee) {
            this.employee = employee;
            return this;
        }

        public Builder employee(TimeOffEmployee employee) {
            this.employee = Optional.of(employee);
            return this;
        }

        @JsonSetter(value = "approver", nulls = Nulls.SKIP)
        public Builder approver(Optional<TimeOffApprover> approver) {
            this.approver = approver;
            return this;
        }

        public Builder approver(TimeOffApprover approver) {
            this.approver = Optional.of(approver);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<TimeOffStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(TimeOffStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "employee_note", nulls = Nulls.SKIP)
        public Builder employeeNote(Optional<String> employeeNote) {
            this.employeeNote = employeeNote;
            return this;
        }

        public Builder employeeNote(String employeeNote) {
            this.employeeNote = Optional.of(employeeNote);
            return this;
        }

        @JsonSetter(value = "units", nulls = Nulls.SKIP)
        public Builder units(Optional<TimeOffUnits> units) {
            this.units = units;
            return this;
        }

        public Builder units(TimeOffUnits units) {
            this.units = Optional.of(units);
            return this;
        }

        @JsonSetter(value = "amount", nulls = Nulls.SKIP)
        public Builder amount(Optional<Double> amount) {
            this.amount = amount;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = Optional.of(amount);
            return this;
        }

        @JsonSetter(value = "request_type", nulls = Nulls.SKIP)
        public Builder requestType(Optional<TimeOffRequestType> requestType) {
            this.requestType = requestType;
            return this;
        }

        public Builder requestType(TimeOffRequestType requestType) {
            this.requestType = Optional.of(requestType);
            return this;
        }

        @JsonSetter(value = "start_time", nulls = Nulls.SKIP)
        public Builder startTime(Optional<OffsetDateTime> startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder startTime(OffsetDateTime startTime) {
            this.startTime = Optional.of(startTime);
            return this;
        }

        @JsonSetter(value = "end_time", nulls = Nulls.SKIP)
        public Builder endTime(Optional<OffsetDateTime> endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder endTime(OffsetDateTime endTime) {
            this.endTime = Optional.of(endTime);
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

        public TimeOff build() {
            return new TimeOff(
                    id,
                    remoteId,
                    createdAt,
                    modifiedAt,
                    employee,
                    approver,
                    status,
                    employeeNote,
                    units,
                    amount,
                    requestType,
                    startTime,
                    endTime,
                    remoteWasDeleted,
                    fieldMappings,
                    remoteData,
                    additionalProperties);
        }
    }
}

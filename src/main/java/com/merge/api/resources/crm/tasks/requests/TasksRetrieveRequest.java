package com.merge.api.resources.crm.tasks.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.resources.crm.types.TasksRetrieveRequestExpand;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TasksRetrieveRequest.Builder.class)
public final class TasksRetrieveRequest {
    private final Optional<TasksRetrieveRequestExpand> expand;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeRemoteFields;

    private TasksRetrieveRequest(
            Optional<TasksRetrieveRequestExpand> expand,
            Optional<Boolean> includeRemoteData,
            Optional<Boolean> includeRemoteFields) {
        this.expand = expand;
        this.includeRemoteData = includeRemoteData;
        this.includeRemoteFields = includeRemoteFields;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<TasksRetrieveRequestExpand> getExpand() {
        return expand;
    }

    /**
     * @return Whether to include the original data Merge fetched from the third-party to produce these models.
     */
    @JsonProperty("include_remote_data")
    public Optional<Boolean> getIncludeRemoteData() {
        return includeRemoteData;
    }

    /**
     * @return Whether to include all remote fields, including fields that Merge did not map to common models, in a normalized format.
     */
    @JsonProperty("include_remote_fields")
    public Optional<Boolean> getIncludeRemoteFields() {
        return includeRemoteFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TasksRetrieveRequest && equalTo((TasksRetrieveRequest) other);
    }

    private boolean equalTo(TasksRetrieveRequest other) {
        return expand.equals(other.expand)
                && includeRemoteData.equals(other.includeRemoteData)
                && includeRemoteFields.equals(other.includeRemoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.expand, this.includeRemoteData, this.includeRemoteFields);
    }

    @Override
    public String toString() {
        return "TasksRetrieveRequest{" + "expand: " + expand + ", includeRemoteData: " + includeRemoteData
                + ", includeRemoteFields: " + includeRemoteFields + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<TasksRetrieveRequestExpand> expand = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeRemoteFields = Optional.empty();

        private Builder() {}

        public Builder from(TasksRetrieveRequest other) {
            expand(other.getExpand());
            includeRemoteData(other.getIncludeRemoteData());
            includeRemoteFields(other.getIncludeRemoteFields());
            return this;
        }

        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<TasksRetrieveRequestExpand> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(TasksRetrieveRequestExpand expand) {
            this.expand = Optional.of(expand);
            return this;
        }

        @JsonSetter(value = "include_remote_data", nulls = Nulls.SKIP)
        public Builder includeRemoteData(Optional<Boolean> includeRemoteData) {
            this.includeRemoteData = includeRemoteData;
            return this;
        }

        public Builder includeRemoteData(Boolean includeRemoteData) {
            this.includeRemoteData = Optional.of(includeRemoteData);
            return this;
        }

        @JsonSetter(value = "include_remote_fields", nulls = Nulls.SKIP)
        public Builder includeRemoteFields(Optional<Boolean> includeRemoteFields) {
            this.includeRemoteFields = includeRemoteFields;
            return this;
        }

        public Builder includeRemoteFields(Boolean includeRemoteFields) {
            this.includeRemoteFields = Optional.of(includeRemoteFields);
            return this;
        }

        public TasksRetrieveRequest build() {
            return new TasksRetrieveRequest(expand, includeRemoteData, includeRemoteFields);
        }
    }
}

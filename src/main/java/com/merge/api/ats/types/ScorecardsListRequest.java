/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ScorecardsListRequest.Builder.class)
public final class ScorecardsListRequest {
    private final Optional<List<ScorecardsListRequestExpandItem>> expand;

    private final Optional<String> applicationId;

    private final Optional<OffsetDateTime> createdAfter;

    private final Optional<OffsetDateTime> createdBefore;

    private final Optional<String> cursor;

    private final Optional<Boolean> includeDeletedData;

    private final Optional<Boolean> includeRemoteData;

    private final Optional<Boolean> includeShellData;

    private final Optional<String> interviewId;

    private final Optional<String> interviewerId;

    private final Optional<OffsetDateTime> modifiedAfter;

    private final Optional<OffsetDateTime> modifiedBefore;

    private final Optional<Integer> pageSize;

    private final Optional<String> remoteFields;

    private final Optional<String> remoteId;

    private final Optional<String> showEnumOrigins;

    private final Map<String, Object> additionalProperties;

    private ScorecardsListRequest(
            Optional<List<ScorecardsListRequestExpandItem>> expand,
            Optional<String> applicationId,
            Optional<OffsetDateTime> createdAfter,
            Optional<OffsetDateTime> createdBefore,
            Optional<String> cursor,
            Optional<Boolean> includeDeletedData,
            Optional<Boolean> includeRemoteData,
            Optional<Boolean> includeShellData,
            Optional<String> interviewId,
            Optional<String> interviewerId,
            Optional<OffsetDateTime> modifiedAfter,
            Optional<OffsetDateTime> modifiedBefore,
            Optional<Integer> pageSize,
            Optional<String> remoteFields,
            Optional<String> remoteId,
            Optional<String> showEnumOrigins,
            Map<String, Object> additionalProperties) {
        this.expand = expand;
        this.applicationId = applicationId;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.cursor = cursor;
        this.includeDeletedData = includeDeletedData;
        this.includeRemoteData = includeRemoteData;
        this.includeShellData = includeShellData;
        this.interviewId = interviewId;
        this.interviewerId = interviewerId;
        this.modifiedAfter = modifiedAfter;
        this.modifiedBefore = modifiedBefore;
        this.pageSize = pageSize;
        this.remoteFields = remoteFields;
        this.remoteId = remoteId;
        this.showEnumOrigins = showEnumOrigins;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.
     */
    @JsonProperty("expand")
    public Optional<List<ScorecardsListRequestExpandItem>> getExpand() {
        return expand;
    }

    /**
     * @return If provided, will only return scorecards for this application.
     */
    @JsonProperty("application_id")
    public Optional<String> getApplicationId() {
        return applicationId;
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
     * @return The pagination cursor value.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
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
     * @return If provided, will only return scorecards for this interview.
     */
    @JsonProperty("interview_id")
    public Optional<String> getInterviewId() {
        return interviewId;
    }

    /**
     * @return If provided, will only return scorecards for this interviewer.
     */
    @JsonProperty("interviewer_id")
    public Optional<String> getInterviewerId() {
        return interviewerId;
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
     * @return Deprecated. Use show_enum_origins.
     */
    @JsonProperty("remote_fields")
    public Optional<String> getRemoteFields() {
        return remoteFields;
    }

    /**
     * @return The API provider's ID for the given object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return A comma separated list of enum field names for which you'd like the original values to be returned, instead of Merge's normalized enum values. <a href="https://help.merge.dev/en/articles/8950958-show_enum_origins-query-parameter">Learn more</a>
     */
    @JsonProperty("show_enum_origins")
    public Optional<String> getShowEnumOrigins() {
        return showEnumOrigins;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ScorecardsListRequest && equalTo((ScorecardsListRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ScorecardsListRequest other) {
        return expand.equals(other.expand)
                && applicationId.equals(other.applicationId)
                && createdAfter.equals(other.createdAfter)
                && createdBefore.equals(other.createdBefore)
                && cursor.equals(other.cursor)
                && includeDeletedData.equals(other.includeDeletedData)
                && includeRemoteData.equals(other.includeRemoteData)
                && includeShellData.equals(other.includeShellData)
                && interviewId.equals(other.interviewId)
                && interviewerId.equals(other.interviewerId)
                && modifiedAfter.equals(other.modifiedAfter)
                && modifiedBefore.equals(other.modifiedBefore)
                && pageSize.equals(other.pageSize)
                && remoteFields.equals(other.remoteFields)
                && remoteId.equals(other.remoteId)
                && showEnumOrigins.equals(other.showEnumOrigins);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.expand,
                this.applicationId,
                this.createdAfter,
                this.createdBefore,
                this.cursor,
                this.includeDeletedData,
                this.includeRemoteData,
                this.includeShellData,
                this.interviewId,
                this.interviewerId,
                this.modifiedAfter,
                this.modifiedBefore,
                this.pageSize,
                this.remoteFields,
                this.remoteId,
                this.showEnumOrigins);
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
        private Optional<List<ScorecardsListRequestExpandItem>> expand = Optional.empty();

        private Optional<String> applicationId = Optional.empty();

        private Optional<OffsetDateTime> createdAfter = Optional.empty();

        private Optional<OffsetDateTime> createdBefore = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<Boolean> includeDeletedData = Optional.empty();

        private Optional<Boolean> includeRemoteData = Optional.empty();

        private Optional<Boolean> includeShellData = Optional.empty();

        private Optional<String> interviewId = Optional.empty();

        private Optional<String> interviewerId = Optional.empty();

        private Optional<OffsetDateTime> modifiedAfter = Optional.empty();

        private Optional<OffsetDateTime> modifiedBefore = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> remoteFields = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> showEnumOrigins = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ScorecardsListRequest other) {
            expand(other.getExpand());
            applicationId(other.getApplicationId());
            createdAfter(other.getCreatedAfter());
            createdBefore(other.getCreatedBefore());
            cursor(other.getCursor());
            includeDeletedData(other.getIncludeDeletedData());
            includeRemoteData(other.getIncludeRemoteData());
            includeShellData(other.getIncludeShellData());
            interviewId(other.getInterviewId());
            interviewerId(other.getInterviewerId());
            modifiedAfter(other.getModifiedAfter());
            modifiedBefore(other.getModifiedBefore());
            pageSize(other.getPageSize());
            remoteFields(other.getRemoteFields());
            remoteId(other.getRemoteId());
            showEnumOrigins(other.getShowEnumOrigins());
            return this;
        }

        /**
         * <p>Which relations should be returned in expanded form. Multiple relation names should be comma separated without spaces.</p>
         */
        @JsonSetter(value = "expand", nulls = Nulls.SKIP)
        public Builder expand(Optional<List<ScorecardsListRequestExpandItem>> expand) {
            this.expand = expand;
            return this;
        }

        public Builder expand(List<ScorecardsListRequestExpandItem> expand) {
            this.expand = Optional.ofNullable(expand);
            return this;
        }

        public Builder expand(ScorecardsListRequestExpandItem expand) {
            this.expand = Optional.of(Collections.singletonList(expand));
            return this;
        }

        /**
         * <p>If provided, will only return scorecards for this application.</p>
         */
        @JsonSetter(value = "application_id", nulls = Nulls.SKIP)
        public Builder applicationId(Optional<String> applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        public Builder applicationId(String applicationId) {
            this.applicationId = Optional.ofNullable(applicationId);
            return this;
        }

        /**
         * <p>If provided, will only return objects created after this datetime.</p>
         */
        @JsonSetter(value = "created_after", nulls = Nulls.SKIP)
        public Builder createdAfter(Optional<OffsetDateTime> createdAfter) {
            this.createdAfter = createdAfter;
            return this;
        }

        public Builder createdAfter(OffsetDateTime createdAfter) {
            this.createdAfter = Optional.ofNullable(createdAfter);
            return this;
        }

        /**
         * <p>If provided, will only return objects created before this datetime.</p>
         */
        @JsonSetter(value = "created_before", nulls = Nulls.SKIP)
        public Builder createdBefore(Optional<OffsetDateTime> createdBefore) {
            this.createdBefore = createdBefore;
            return this;
        }

        public Builder createdBefore(OffsetDateTime createdBefore) {
            this.createdBefore = Optional.ofNullable(createdBefore);
            return this;
        }

        /**
         * <p>The pagination cursor value.</p>
         */
        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        /**
         * <p>Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.</p>
         */
        @JsonSetter(value = "include_deleted_data", nulls = Nulls.SKIP)
        public Builder includeDeletedData(Optional<Boolean> includeDeletedData) {
            this.includeDeletedData = includeDeletedData;
            return this;
        }

        public Builder includeDeletedData(Boolean includeDeletedData) {
            this.includeDeletedData = Optional.ofNullable(includeDeletedData);
            return this;
        }

        /**
         * <p>Whether to include the original data Merge fetched from the third-party to produce these models.</p>
         */
        @JsonSetter(value = "include_remote_data", nulls = Nulls.SKIP)
        public Builder includeRemoteData(Optional<Boolean> includeRemoteData) {
            this.includeRemoteData = includeRemoteData;
            return this;
        }

        public Builder includeRemoteData(Boolean includeRemoteData) {
            this.includeRemoteData = Optional.ofNullable(includeRemoteData);
            return this;
        }

        /**
         * <p>Whether to include shell records. Shell records are empty records (they may contain some metadata but all other fields are null).</p>
         */
        @JsonSetter(value = "include_shell_data", nulls = Nulls.SKIP)
        public Builder includeShellData(Optional<Boolean> includeShellData) {
            this.includeShellData = includeShellData;
            return this;
        }

        public Builder includeShellData(Boolean includeShellData) {
            this.includeShellData = Optional.ofNullable(includeShellData);
            return this;
        }

        /**
         * <p>If provided, will only return scorecards for this interview.</p>
         */
        @JsonSetter(value = "interview_id", nulls = Nulls.SKIP)
        public Builder interviewId(Optional<String> interviewId) {
            this.interviewId = interviewId;
            return this;
        }

        public Builder interviewId(String interviewId) {
            this.interviewId = Optional.ofNullable(interviewId);
            return this;
        }

        /**
         * <p>If provided, will only return scorecards for this interviewer.</p>
         */
        @JsonSetter(value = "interviewer_id", nulls = Nulls.SKIP)
        public Builder interviewerId(Optional<String> interviewerId) {
            this.interviewerId = interviewerId;
            return this;
        }

        public Builder interviewerId(String interviewerId) {
            this.interviewerId = Optional.ofNullable(interviewerId);
            return this;
        }

        /**
         * <p>If provided, only objects synced by Merge after this date time will be returned.</p>
         */
        @JsonSetter(value = "modified_after", nulls = Nulls.SKIP)
        public Builder modifiedAfter(Optional<OffsetDateTime> modifiedAfter) {
            this.modifiedAfter = modifiedAfter;
            return this;
        }

        public Builder modifiedAfter(OffsetDateTime modifiedAfter) {
            this.modifiedAfter = Optional.ofNullable(modifiedAfter);
            return this;
        }

        /**
         * <p>If provided, only objects synced by Merge before this date time will be returned.</p>
         */
        @JsonSetter(value = "modified_before", nulls = Nulls.SKIP)
        public Builder modifiedBefore(Optional<OffsetDateTime> modifiedBefore) {
            this.modifiedBefore = modifiedBefore;
            return this;
        }

        public Builder modifiedBefore(OffsetDateTime modifiedBefore) {
            this.modifiedBefore = Optional.ofNullable(modifiedBefore);
            return this;
        }

        /**
         * <p>Number of results to return per page.</p>
         */
        @JsonSetter(value = "page_size", nulls = Nulls.SKIP)
        public Builder pageSize(Optional<Integer> pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = Optional.ofNullable(pageSize);
            return this;
        }

        /**
         * <p>Deprecated. Use show_enum_origins.</p>
         */
        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<String> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(String remoteFields) {
            this.remoteFields = Optional.ofNullable(remoteFields);
            return this;
        }

        /**
         * <p>The API provider's ID for the given object.</p>
         */
        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.ofNullable(remoteId);
            return this;
        }

        /**
         * <p>A comma separated list of enum field names for which you'd like the original values to be returned, instead of Merge's normalized enum values. <a href="https://help.merge.dev/en/articles/8950958-show_enum_origins-query-parameter">Learn more</a></p>
         */
        @JsonSetter(value = "show_enum_origins", nulls = Nulls.SKIP)
        public Builder showEnumOrigins(Optional<String> showEnumOrigins) {
            this.showEnumOrigins = showEnumOrigins;
            return this;
        }

        public Builder showEnumOrigins(String showEnumOrigins) {
            this.showEnumOrigins = Optional.ofNullable(showEnumOrigins);
            return this;
        }

        public ScorecardsListRequest build() {
            return new ScorecardsListRequest(
                    expand,
                    applicationId,
                    createdAfter,
                    createdBefore,
                    cursor,
                    includeDeletedData,
                    includeRemoteData,
                    includeShellData,
                    interviewId,
                    interviewerId,
                    modifiedAfter,
                    modifiedBefore,
                    pageSize,
                    remoteFields,
                    remoteId,
                    showEnumOrigins,
                    additionalProperties);
        }
    }
}

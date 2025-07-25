/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = IssuesListRequest.Builder.class)
public final class IssuesListRequest {
    private final Optional<String> accountToken;

    private final Optional<String> cursor;

    private final Optional<String> endDate;

    private final Optional<String> endUserOrganizationName;

    private final Optional<OffsetDateTime> firstIncidentTimeAfter;

    private final Optional<OffsetDateTime> firstIncidentTimeBefore;

    private final Optional<String> includeMuted;

    private final Optional<String> integrationName;

    private final Optional<OffsetDateTime> lastIncidentTimeAfter;

    private final Optional<OffsetDateTime> lastIncidentTimeBefore;

    private final Optional<String> linkedAccountId;

    private final Optional<Integer> pageSize;

    private final Optional<String> startDate;

    private final Optional<IssuesListRequestStatus> status;

    private final Map<String, Object> additionalProperties;

    private IssuesListRequest(
            Optional<String> accountToken,
            Optional<String> cursor,
            Optional<String> endDate,
            Optional<String> endUserOrganizationName,
            Optional<OffsetDateTime> firstIncidentTimeAfter,
            Optional<OffsetDateTime> firstIncidentTimeBefore,
            Optional<String> includeMuted,
            Optional<String> integrationName,
            Optional<OffsetDateTime> lastIncidentTimeAfter,
            Optional<OffsetDateTime> lastIncidentTimeBefore,
            Optional<String> linkedAccountId,
            Optional<Integer> pageSize,
            Optional<String> startDate,
            Optional<IssuesListRequestStatus> status,
            Map<String, Object> additionalProperties) {
        this.accountToken = accountToken;
        this.cursor = cursor;
        this.endDate = endDate;
        this.endUserOrganizationName = endUserOrganizationName;
        this.firstIncidentTimeAfter = firstIncidentTimeAfter;
        this.firstIncidentTimeBefore = firstIncidentTimeBefore;
        this.includeMuted = includeMuted;
        this.integrationName = integrationName;
        this.lastIncidentTimeAfter = lastIncidentTimeAfter;
        this.lastIncidentTimeBefore = lastIncidentTimeBefore;
        this.linkedAccountId = linkedAccountId;
        this.pageSize = pageSize;
        this.startDate = startDate;
        this.status = status;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("account_token")
    public Optional<String> getAccountToken() {
        return accountToken;
    }

    /**
     * @return The pagination cursor value.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return If included, will only include issues whose most recent action occurred before this time
     */
    @JsonProperty("end_date")
    public Optional<String> getEndDate() {
        return endDate;
    }

    @JsonProperty("end_user_organization_name")
    public Optional<String> getEndUserOrganizationName() {
        return endUserOrganizationName;
    }

    /**
     * @return If provided, will only return issues whose first incident time was after this datetime.
     */
    @JsonProperty("first_incident_time_after")
    public Optional<OffsetDateTime> getFirstIncidentTimeAfter() {
        return firstIncidentTimeAfter;
    }

    /**
     * @return If provided, will only return issues whose first incident time was before this datetime.
     */
    @JsonProperty("first_incident_time_before")
    public Optional<OffsetDateTime> getFirstIncidentTimeBefore() {
        return firstIncidentTimeBefore;
    }

    /**
     * @return If true, will include muted issues
     */
    @JsonProperty("include_muted")
    public Optional<String> getIncludeMuted() {
        return includeMuted;
    }

    @JsonProperty("integration_name")
    public Optional<String> getIntegrationName() {
        return integrationName;
    }

    /**
     * @return If provided, will only return issues whose last incident time was after this datetime.
     */
    @JsonProperty("last_incident_time_after")
    public Optional<OffsetDateTime> getLastIncidentTimeAfter() {
        return lastIncidentTimeAfter;
    }

    /**
     * @return If provided, will only return issues whose last incident time was before this datetime.
     */
    @JsonProperty("last_incident_time_before")
    public Optional<OffsetDateTime> getLastIncidentTimeBefore() {
        return lastIncidentTimeBefore;
    }

    /**
     * @return If provided, will only include issues pertaining to the linked account passed in.
     */
    @JsonProperty("linked_account_id")
    public Optional<String> getLinkedAccountId() {
        return linkedAccountId;
    }

    /**
     * @return Number of results to return per page.
     */
    @JsonProperty("page_size")
    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    /**
     * @return If included, will only include issues whose most recent action occurred after this time
     */
    @JsonProperty("start_date")
    public Optional<String> getStartDate() {
        return startDate;
    }

    /**
     * @return Status of the issue. Options: ('ONGOING', 'RESOLVED')
     * <ul>
     * <li><code>ONGOING</code> - ONGOING</li>
     * <li><code>RESOLVED</code> - RESOLVED</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<IssuesListRequestStatus> getStatus() {
        return status;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof IssuesListRequest && equalTo((IssuesListRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(IssuesListRequest other) {
        return accountToken.equals(other.accountToken)
                && cursor.equals(other.cursor)
                && endDate.equals(other.endDate)
                && endUserOrganizationName.equals(other.endUserOrganizationName)
                && firstIncidentTimeAfter.equals(other.firstIncidentTimeAfter)
                && firstIncidentTimeBefore.equals(other.firstIncidentTimeBefore)
                && includeMuted.equals(other.includeMuted)
                && integrationName.equals(other.integrationName)
                && lastIncidentTimeAfter.equals(other.lastIncidentTimeAfter)
                && lastIncidentTimeBefore.equals(other.lastIncidentTimeBefore)
                && linkedAccountId.equals(other.linkedAccountId)
                && pageSize.equals(other.pageSize)
                && startDate.equals(other.startDate)
                && status.equals(other.status);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.accountToken,
                this.cursor,
                this.endDate,
                this.endUserOrganizationName,
                this.firstIncidentTimeAfter,
                this.firstIncidentTimeBefore,
                this.includeMuted,
                this.integrationName,
                this.lastIncidentTimeAfter,
                this.lastIncidentTimeBefore,
                this.linkedAccountId,
                this.pageSize,
                this.startDate,
                this.status);
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
        private Optional<String> accountToken = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<String> endDate = Optional.empty();

        private Optional<String> endUserOrganizationName = Optional.empty();

        private Optional<OffsetDateTime> firstIncidentTimeAfter = Optional.empty();

        private Optional<OffsetDateTime> firstIncidentTimeBefore = Optional.empty();

        private Optional<String> includeMuted = Optional.empty();

        private Optional<String> integrationName = Optional.empty();

        private Optional<OffsetDateTime> lastIncidentTimeAfter = Optional.empty();

        private Optional<OffsetDateTime> lastIncidentTimeBefore = Optional.empty();

        private Optional<String> linkedAccountId = Optional.empty();

        private Optional<Integer> pageSize = Optional.empty();

        private Optional<String> startDate = Optional.empty();

        private Optional<IssuesListRequestStatus> status = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(IssuesListRequest other) {
            accountToken(other.getAccountToken());
            cursor(other.getCursor());
            endDate(other.getEndDate());
            endUserOrganizationName(other.getEndUserOrganizationName());
            firstIncidentTimeAfter(other.getFirstIncidentTimeAfter());
            firstIncidentTimeBefore(other.getFirstIncidentTimeBefore());
            includeMuted(other.getIncludeMuted());
            integrationName(other.getIntegrationName());
            lastIncidentTimeAfter(other.getLastIncidentTimeAfter());
            lastIncidentTimeBefore(other.getLastIncidentTimeBefore());
            linkedAccountId(other.getLinkedAccountId());
            pageSize(other.getPageSize());
            startDate(other.getStartDate());
            status(other.getStatus());
            return this;
        }

        @JsonSetter(value = "account_token", nulls = Nulls.SKIP)
        public Builder accountToken(Optional<String> accountToken) {
            this.accountToken = accountToken;
            return this;
        }

        public Builder accountToken(String accountToken) {
            this.accountToken = Optional.ofNullable(accountToken);
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
         * <p>If included, will only include issues whose most recent action occurred before this time</p>
         */
        @JsonSetter(value = "end_date", nulls = Nulls.SKIP)
        public Builder endDate(Optional<String> endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder endDate(String endDate) {
            this.endDate = Optional.ofNullable(endDate);
            return this;
        }

        @JsonSetter(value = "end_user_organization_name", nulls = Nulls.SKIP)
        public Builder endUserOrganizationName(Optional<String> endUserOrganizationName) {
            this.endUserOrganizationName = endUserOrganizationName;
            return this;
        }

        public Builder endUserOrganizationName(String endUserOrganizationName) {
            this.endUserOrganizationName = Optional.ofNullable(endUserOrganizationName);
            return this;
        }

        /**
         * <p>If provided, will only return issues whose first incident time was after this datetime.</p>
         */
        @JsonSetter(value = "first_incident_time_after", nulls = Nulls.SKIP)
        public Builder firstIncidentTimeAfter(Optional<OffsetDateTime> firstIncidentTimeAfter) {
            this.firstIncidentTimeAfter = firstIncidentTimeAfter;
            return this;
        }

        public Builder firstIncidentTimeAfter(OffsetDateTime firstIncidentTimeAfter) {
            this.firstIncidentTimeAfter = Optional.ofNullable(firstIncidentTimeAfter);
            return this;
        }

        /**
         * <p>If provided, will only return issues whose first incident time was before this datetime.</p>
         */
        @JsonSetter(value = "first_incident_time_before", nulls = Nulls.SKIP)
        public Builder firstIncidentTimeBefore(Optional<OffsetDateTime> firstIncidentTimeBefore) {
            this.firstIncidentTimeBefore = firstIncidentTimeBefore;
            return this;
        }

        public Builder firstIncidentTimeBefore(OffsetDateTime firstIncidentTimeBefore) {
            this.firstIncidentTimeBefore = Optional.ofNullable(firstIncidentTimeBefore);
            return this;
        }

        /**
         * <p>If true, will include muted issues</p>
         */
        @JsonSetter(value = "include_muted", nulls = Nulls.SKIP)
        public Builder includeMuted(Optional<String> includeMuted) {
            this.includeMuted = includeMuted;
            return this;
        }

        public Builder includeMuted(String includeMuted) {
            this.includeMuted = Optional.ofNullable(includeMuted);
            return this;
        }

        @JsonSetter(value = "integration_name", nulls = Nulls.SKIP)
        public Builder integrationName(Optional<String> integrationName) {
            this.integrationName = integrationName;
            return this;
        }

        public Builder integrationName(String integrationName) {
            this.integrationName = Optional.ofNullable(integrationName);
            return this;
        }

        /**
         * <p>If provided, will only return issues whose last incident time was after this datetime.</p>
         */
        @JsonSetter(value = "last_incident_time_after", nulls = Nulls.SKIP)
        public Builder lastIncidentTimeAfter(Optional<OffsetDateTime> lastIncidentTimeAfter) {
            this.lastIncidentTimeAfter = lastIncidentTimeAfter;
            return this;
        }

        public Builder lastIncidentTimeAfter(OffsetDateTime lastIncidentTimeAfter) {
            this.lastIncidentTimeAfter = Optional.ofNullable(lastIncidentTimeAfter);
            return this;
        }

        /**
         * <p>If provided, will only return issues whose last incident time was before this datetime.</p>
         */
        @JsonSetter(value = "last_incident_time_before", nulls = Nulls.SKIP)
        public Builder lastIncidentTimeBefore(Optional<OffsetDateTime> lastIncidentTimeBefore) {
            this.lastIncidentTimeBefore = lastIncidentTimeBefore;
            return this;
        }

        public Builder lastIncidentTimeBefore(OffsetDateTime lastIncidentTimeBefore) {
            this.lastIncidentTimeBefore = Optional.ofNullable(lastIncidentTimeBefore);
            return this;
        }

        /**
         * <p>If provided, will only include issues pertaining to the linked account passed in.</p>
         */
        @JsonSetter(value = "linked_account_id", nulls = Nulls.SKIP)
        public Builder linkedAccountId(Optional<String> linkedAccountId) {
            this.linkedAccountId = linkedAccountId;
            return this;
        }

        public Builder linkedAccountId(String linkedAccountId) {
            this.linkedAccountId = Optional.ofNullable(linkedAccountId);
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
         * <p>If included, will only include issues whose most recent action occurred after this time</p>
         */
        @JsonSetter(value = "start_date", nulls = Nulls.SKIP)
        public Builder startDate(Optional<String> startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder startDate(String startDate) {
            this.startDate = Optional.ofNullable(startDate);
            return this;
        }

        /**
         * <p>Status of the issue. Options: ('ONGOING', 'RESOLVED')</p>
         * <ul>
         * <li><code>ONGOING</code> - ONGOING</li>
         * <li><code>RESOLVED</code> - RESOLVED</li>
         * </ul>
         */
        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<IssuesListRequestStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(IssuesListRequestStatus status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        public IssuesListRequest build() {
            return new IssuesListRequest(
                    accountToken,
                    cursor,
                    endDate,
                    endUserOrganizationName,
                    firstIncidentTimeAfter,
                    firstIncidentTimeBefore,
                    includeMuted,
                    integrationName,
                    lastIncidentTimeAfter,
                    lastIncidentTimeBefore,
                    linkedAccountId,
                    pageSize,
                    startDate,
                    status,
                    additionalProperties);
        }
    }
}

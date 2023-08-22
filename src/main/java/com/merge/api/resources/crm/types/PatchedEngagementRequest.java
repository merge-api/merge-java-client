package com.merge.api.resources.crm.types;

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
@JsonDeserialize(builder = PatchedEngagementRequest.Builder.class)
public final class PatchedEngagementRequest {
    private final Optional<String> owner;

    private final Optional<String> content;

    private final Optional<String> subject;

    private final Optional<PatchedEngagementRequestDirection> direction;

    private final Optional<String> engagementType;

    private final Optional<OffsetDateTime> startTime;

    private final Optional<OffsetDateTime> endTime;

    private final Optional<String> account;

    private final Optional<List<Optional<String>>> contacts;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Optional<List<RemoteFieldRequest>> remoteFields;

    private PatchedEngagementRequest(
            Optional<String> owner,
            Optional<String> content,
            Optional<String> subject,
            Optional<PatchedEngagementRequestDirection> direction,
            Optional<String> engagementType,
            Optional<OffsetDateTime> startTime,
            Optional<OffsetDateTime> endTime,
            Optional<String> account,
            Optional<List<Optional<String>>> contacts,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Optional<List<RemoteFieldRequest>> remoteFields) {
        this.owner = owner;
        this.content = content;
        this.subject = subject;
        this.direction = direction;
        this.engagementType = engagementType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.account = account;
        this.contacts = contacts;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
        this.remoteFields = remoteFields;
    }

    /**
     * @return The engagement's owner.
     */
    @JsonProperty("owner")
    public Optional<String> getOwner() {
        return owner;
    }

    /**
     * @return The engagement's content.
     */
    @JsonProperty("content")
    public Optional<String> getContent() {
        return content;
    }

    /**
     * @return The engagement's subject.
     */
    @JsonProperty("subject")
    public Optional<String> getSubject() {
        return subject;
    }

    /**
     * @return The engagement's direction.
     * <ul>
     * <li><code>INBOUND</code> - INBOUND</li>
     * <li><code>OUTBOUND</code> - OUTBOUND</li>
     * </ul>
     */
    @JsonProperty("direction")
    public Optional<PatchedEngagementRequestDirection> getDirection() {
        return direction;
    }

    /**
     * @return The engagement type of the engagement.
     */
    @JsonProperty("engagement_type")
    public Optional<String> getEngagementType() {
        return engagementType;
    }

    /**
     * @return The time at which the engagement started.
     */
    @JsonProperty("start_time")
    public Optional<OffsetDateTime> getStartTime() {
        return startTime;
    }

    /**
     * @return The time at which the engagement ended.
     */
    @JsonProperty("end_time")
    public Optional<OffsetDateTime> getEndTime() {
        return endTime;
    }

    /**
     * @return The account of the engagement.
     */
    @JsonProperty("account")
    public Optional<String> getAccount() {
        return account;
    }

    @JsonProperty("contacts")
    public Optional<List<Optional<String>>> getContacts() {
        return contacts;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @JsonProperty("remote_fields")
    public Optional<List<RemoteFieldRequest>> getRemoteFields() {
        return remoteFields;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PatchedEngagementRequest && equalTo((PatchedEngagementRequest) other);
    }

    private boolean equalTo(PatchedEngagementRequest other) {
        return owner.equals(other.owner)
                && content.equals(other.content)
                && subject.equals(other.subject)
                && direction.equals(other.direction)
                && engagementType.equals(other.engagementType)
                && startTime.equals(other.startTime)
                && endTime.equals(other.endTime)
                && account.equals(other.account)
                && contacts.equals(other.contacts)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams)
                && remoteFields.equals(other.remoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.owner,
                this.content,
                this.subject,
                this.direction,
                this.engagementType,
                this.startTime,
                this.endTime,
                this.account,
                this.contacts,
                this.integrationParams,
                this.linkedAccountParams,
                this.remoteFields);
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
        private Optional<String> owner = Optional.empty();

        private Optional<String> content = Optional.empty();

        private Optional<String> subject = Optional.empty();

        private Optional<PatchedEngagementRequestDirection> direction = Optional.empty();

        private Optional<String> engagementType = Optional.empty();

        private Optional<OffsetDateTime> startTime = Optional.empty();

        private Optional<OffsetDateTime> endTime = Optional.empty();

        private Optional<String> account = Optional.empty();

        private Optional<List<Optional<String>>> contacts = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Optional<List<RemoteFieldRequest>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(PatchedEngagementRequest other) {
            owner(other.getOwner());
            content(other.getContent());
            subject(other.getSubject());
            direction(other.getDirection());
            engagementType(other.getEngagementType());
            startTime(other.getStartTime());
            endTime(other.getEndTime());
            account(other.getAccount());
            contacts(other.getContacts());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            remoteFields(other.getRemoteFields());
            return this;
        }

        @JsonSetter(value = "owner", nulls = Nulls.SKIP)
        public Builder owner(Optional<String> owner) {
            this.owner = owner;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = Optional.of(owner);
            return this;
        }

        @JsonSetter(value = "content", nulls = Nulls.SKIP)
        public Builder content(Optional<String> content) {
            this.content = content;
            return this;
        }

        public Builder content(String content) {
            this.content = Optional.of(content);
            return this;
        }

        @JsonSetter(value = "subject", nulls = Nulls.SKIP)
        public Builder subject(Optional<String> subject) {
            this.subject = subject;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = Optional.of(subject);
            return this;
        }

        @JsonSetter(value = "direction", nulls = Nulls.SKIP)
        public Builder direction(Optional<PatchedEngagementRequestDirection> direction) {
            this.direction = direction;
            return this;
        }

        public Builder direction(PatchedEngagementRequestDirection direction) {
            this.direction = Optional.of(direction);
            return this;
        }

        @JsonSetter(value = "engagement_type", nulls = Nulls.SKIP)
        public Builder engagementType(Optional<String> engagementType) {
            this.engagementType = engagementType;
            return this;
        }

        public Builder engagementType(String engagementType) {
            this.engagementType = Optional.of(engagementType);
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

        @JsonSetter(value = "account", nulls = Nulls.SKIP)
        public Builder account(Optional<String> account) {
            this.account = account;
            return this;
        }

        public Builder account(String account) {
            this.account = Optional.of(account);
            return this;
        }

        @JsonSetter(value = "contacts", nulls = Nulls.SKIP)
        public Builder contacts(Optional<List<Optional<String>>> contacts) {
            this.contacts = contacts;
            return this;
        }

        public Builder contacts(List<Optional<String>> contacts) {
            this.contacts = Optional.of(contacts);
            return this;
        }

        @JsonSetter(value = "integration_params", nulls = Nulls.SKIP)
        public Builder integrationParams(Optional<Map<String, JsonNode>> integrationParams) {
            this.integrationParams = integrationParams;
            return this;
        }

        public Builder integrationParams(Map<String, JsonNode> integrationParams) {
            this.integrationParams = Optional.of(integrationParams);
            return this;
        }

        @JsonSetter(value = "linked_account_params", nulls = Nulls.SKIP)
        public Builder linkedAccountParams(Optional<Map<String, JsonNode>> linkedAccountParams) {
            this.linkedAccountParams = linkedAccountParams;
            return this;
        }

        public Builder linkedAccountParams(Map<String, JsonNode> linkedAccountParams) {
            this.linkedAccountParams = Optional.of(linkedAccountParams);
            return this;
        }

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<List<RemoteFieldRequest>> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(List<RemoteFieldRequest> remoteFields) {
            this.remoteFields = Optional.of(remoteFields);
            return this;
        }

        public PatchedEngagementRequest build() {
            return new PatchedEngagementRequest(
                    owner,
                    content,
                    subject,
                    direction,
                    engagementType,
                    startTime,
                    endTime,
                    account,
                    contacts,
                    integrationParams,
                    linkedAccountParams,
                    remoteFields);
        }
    }
}

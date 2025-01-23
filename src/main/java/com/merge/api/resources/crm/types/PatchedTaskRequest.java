/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.crm.types;

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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PatchedTaskRequest.Builder.class)
public final class PatchedTaskRequest {
    private final Optional<String> subject;

    private final Optional<String> content;

    private final Optional<String> owner;

    private final Optional<String> account;

    private final Optional<String> opportunity;

    private final Optional<OffsetDateTime> completedDate;

    private final Optional<OffsetDateTime> dueDate;

    private final Optional<PatchedTaskRequestStatus> status;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Optional<List<RemoteFieldRequest>> remoteFields;

    private final Map<String, Object> additionalProperties;

    private PatchedTaskRequest(
            Optional<String> subject,
            Optional<String> content,
            Optional<String> owner,
            Optional<String> account,
            Optional<String> opportunity,
            Optional<OffsetDateTime> completedDate,
            Optional<OffsetDateTime> dueDate,
            Optional<PatchedTaskRequestStatus> status,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Optional<List<RemoteFieldRequest>> remoteFields,
            Map<String, Object> additionalProperties) {
        this.subject = subject;
        this.content = content;
        this.owner = owner;
        this.account = account;
        this.opportunity = opportunity;
        this.completedDate = completedDate;
        this.dueDate = dueDate;
        this.status = status;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
        this.remoteFields = remoteFields;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The task's subject.
     */
    @JsonProperty("subject")
    public Optional<String> getSubject() {
        return subject;
    }

    /**
     * @return The task's content.
     */
    @JsonProperty("content")
    public Optional<String> getContent() {
        return content;
    }

    /**
     * @return The task's owner.
     */
    @JsonProperty("owner")
    public Optional<String> getOwner() {
        return owner;
    }

    /**
     * @return The task's account.
     */
    @JsonProperty("account")
    public Optional<String> getAccount() {
        return account;
    }

    /**
     * @return The task's opportunity.
     */
    @JsonProperty("opportunity")
    public Optional<String> getOpportunity() {
        return opportunity;
    }

    /**
     * @return When the task is completed.
     */
    @JsonProperty("completed_date")
    public Optional<OffsetDateTime> getCompletedDate() {
        return completedDate;
    }

    /**
     * @return When the task is due.
     */
    @JsonProperty("due_date")
    public Optional<OffsetDateTime> getDueDate() {
        return dueDate;
    }

    /**
     * @return The task's status.
     * <ul>
     * <li><code>OPEN</code> - OPEN</li>
     * <li><code>CLOSED</code> - CLOSED</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<PatchedTaskRequestStatus> getStatus() {
        return status;
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

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PatchedTaskRequest && equalTo((PatchedTaskRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PatchedTaskRequest other) {
        return subject.equals(other.subject)
                && content.equals(other.content)
                && owner.equals(other.owner)
                && account.equals(other.account)
                && opportunity.equals(other.opportunity)
                && completedDate.equals(other.completedDate)
                && dueDate.equals(other.dueDate)
                && status.equals(other.status)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams)
                && remoteFields.equals(other.remoteFields);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.subject,
                this.content,
                this.owner,
                this.account,
                this.opportunity,
                this.completedDate,
                this.dueDate,
                this.status,
                this.integrationParams,
                this.linkedAccountParams,
                this.remoteFields);
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
        private Optional<String> subject = Optional.empty();

        private Optional<String> content = Optional.empty();

        private Optional<String> owner = Optional.empty();

        private Optional<String> account = Optional.empty();

        private Optional<String> opportunity = Optional.empty();

        private Optional<OffsetDateTime> completedDate = Optional.empty();

        private Optional<OffsetDateTime> dueDate = Optional.empty();

        private Optional<PatchedTaskRequestStatus> status = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Optional<List<RemoteFieldRequest>> remoteFields = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(PatchedTaskRequest other) {
            subject(other.getSubject());
            content(other.getContent());
            owner(other.getOwner());
            account(other.getAccount());
            opportunity(other.getOpportunity());
            completedDate(other.getCompletedDate());
            dueDate(other.getDueDate());
            status(other.getStatus());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            remoteFields(other.getRemoteFields());
            return this;
        }

        @JsonSetter(value = "subject", nulls = Nulls.SKIP)
        public Builder subject(Optional<String> subject) {
            this.subject = subject;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = Optional.ofNullable(subject);
            return this;
        }

        @JsonSetter(value = "content", nulls = Nulls.SKIP)
        public Builder content(Optional<String> content) {
            this.content = content;
            return this;
        }

        public Builder content(String content) {
            this.content = Optional.ofNullable(content);
            return this;
        }

        @JsonSetter(value = "owner", nulls = Nulls.SKIP)
        public Builder owner(Optional<String> owner) {
            this.owner = owner;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = Optional.ofNullable(owner);
            return this;
        }

        @JsonSetter(value = "account", nulls = Nulls.SKIP)
        public Builder account(Optional<String> account) {
            this.account = account;
            return this;
        }

        public Builder account(String account) {
            this.account = Optional.ofNullable(account);
            return this;
        }

        @JsonSetter(value = "opportunity", nulls = Nulls.SKIP)
        public Builder opportunity(Optional<String> opportunity) {
            this.opportunity = opportunity;
            return this;
        }

        public Builder opportunity(String opportunity) {
            this.opportunity = Optional.ofNullable(opportunity);
            return this;
        }

        @JsonSetter(value = "completed_date", nulls = Nulls.SKIP)
        public Builder completedDate(Optional<OffsetDateTime> completedDate) {
            this.completedDate = completedDate;
            return this;
        }

        public Builder completedDate(OffsetDateTime completedDate) {
            this.completedDate = Optional.ofNullable(completedDate);
            return this;
        }

        @JsonSetter(value = "due_date", nulls = Nulls.SKIP)
        public Builder dueDate(Optional<OffsetDateTime> dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder dueDate(OffsetDateTime dueDate) {
            this.dueDate = Optional.ofNullable(dueDate);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<PatchedTaskRequestStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(PatchedTaskRequestStatus status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @JsonSetter(value = "integration_params", nulls = Nulls.SKIP)
        public Builder integrationParams(Optional<Map<String, JsonNode>> integrationParams) {
            this.integrationParams = integrationParams;
            return this;
        }

        public Builder integrationParams(Map<String, JsonNode> integrationParams) {
            this.integrationParams = Optional.ofNullable(integrationParams);
            return this;
        }

        @JsonSetter(value = "linked_account_params", nulls = Nulls.SKIP)
        public Builder linkedAccountParams(Optional<Map<String, JsonNode>> linkedAccountParams) {
            this.linkedAccountParams = linkedAccountParams;
            return this;
        }

        public Builder linkedAccountParams(Map<String, JsonNode> linkedAccountParams) {
            this.linkedAccountParams = Optional.ofNullable(linkedAccountParams);
            return this;
        }

        @JsonSetter(value = "remote_fields", nulls = Nulls.SKIP)
        public Builder remoteFields(Optional<List<RemoteFieldRequest>> remoteFields) {
            this.remoteFields = remoteFields;
            return this;
        }

        public Builder remoteFields(List<RemoteFieldRequest> remoteFields) {
            this.remoteFields = Optional.ofNullable(remoteFields);
            return this;
        }

        public PatchedTaskRequest build() {
            return new PatchedTaskRequest(
                    subject,
                    content,
                    owner,
                    account,
                    opportunity,
                    completedDate,
                    dueDate,
                    status,
                    integrationParams,
                    linkedAccountParams,
                    remoteFields,
                    additionalProperties);
        }
    }
}

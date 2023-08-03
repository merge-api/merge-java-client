package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = NoteRequest.Builder.class)
public final class NoteRequest {
    private final Optional<String> owner;

    private final Optional<String> content;

    private final Optional<String> contact;

    private final Optional<String> account;

    private final Optional<String> opportunity;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Optional<List<RemoteFieldRequest>> remoteFields;

    private NoteRequest(
            Optional<String> owner,
            Optional<String> content,
            Optional<String> contact,
            Optional<String> account,
            Optional<String> opportunity,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Optional<List<RemoteFieldRequest>> remoteFields) {
        this.owner = owner;
        this.content = content;
        this.contact = contact;
        this.account = account;
        this.opportunity = opportunity;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
        this.remoteFields = remoteFields;
    }

    /**
     * @return The note's owner.
     */
    @JsonProperty("owner")
    public Optional<String> getOwner() {
        return owner;
    }

    /**
     * @return The note's content.
     */
    @JsonProperty("content")
    public Optional<String> getContent() {
        return content;
    }

    /**
     * @return The note's contact.
     */
    @JsonProperty("contact")
    public Optional<String> getContact() {
        return contact;
    }

    /**
     * @return The note's account.
     */
    @JsonProperty("account")
    public Optional<String> getAccount() {
        return account;
    }

    /**
     * @return The note's opportunity.
     */
    @JsonProperty("opportunity")
    public Optional<String> getOpportunity() {
        return opportunity;
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
        return other instanceof NoteRequest && equalTo((NoteRequest) other);
    }

    private boolean equalTo(NoteRequest other) {
        return owner.equals(other.owner)
                && content.equals(other.content)
                && contact.equals(other.contact)
                && account.equals(other.account)
                && opportunity.equals(other.opportunity)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams)
                && remoteFields.equals(other.remoteFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.owner,
                this.content,
                this.contact,
                this.account,
                this.opportunity,
                this.integrationParams,
                this.linkedAccountParams,
                this.remoteFields);
    }

    @Override
    public String toString() {
        return "NoteRequest{" + "owner: " + owner + ", content: " + content + ", contact: " + contact + ", account: "
                + account + ", opportunity: " + opportunity + ", integrationParams: " + integrationParams
                + ", linkedAccountParams: " + linkedAccountParams + ", remoteFields: " + remoteFields + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> owner = Optional.empty();

        private Optional<String> content = Optional.empty();

        private Optional<String> contact = Optional.empty();

        private Optional<String> account = Optional.empty();

        private Optional<String> opportunity = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Optional<List<RemoteFieldRequest>> remoteFields = Optional.empty();

        private Builder() {}

        public Builder from(NoteRequest other) {
            owner(other.getOwner());
            content(other.getContent());
            contact(other.getContact());
            account(other.getAccount());
            opportunity(other.getOpportunity());
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

        @JsonSetter(value = "contact", nulls = Nulls.SKIP)
        public Builder contact(Optional<String> contact) {
            this.contact = contact;
            return this;
        }

        public Builder contact(String contact) {
            this.contact = Optional.of(contact);
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

        @JsonSetter(value = "opportunity", nulls = Nulls.SKIP)
        public Builder opportunity(Optional<String> opportunity) {
            this.opportunity = opportunity;
            return this;
        }

        public Builder opportunity(String opportunity) {
            this.opportunity = Optional.of(opportunity);
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

        public NoteRequest build() {
            return new NoteRequest(
                    owner,
                    content,
                    contact,
                    account,
                    opportunity,
                    integrationParams,
                    linkedAccountParams,
                    remoteFields);
        }
    }
}

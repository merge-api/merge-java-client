package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CommentRequest.Builder.class)
public final class CommentRequest {
    private final Optional<String> user;

    private final Optional<String> contact;

    private final Optional<String> body;

    private final Optional<String> htmlBody;

    private final Optional<String> ticket;

    private final Optional<Boolean> isPrivate;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private CommentRequest(
            Optional<String> user,
            Optional<String> contact,
            Optional<String> body,
            Optional<String> htmlBody,
            Optional<String> ticket,
            Optional<Boolean> isPrivate,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.user = user;
        this.contact = contact;
        this.body = body;
        this.htmlBody = htmlBody;
        this.ticket = ticket;
        this.isPrivate = isPrivate;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The author of the Comment, if the author is a User.
     */
    @JsonProperty("user")
    public Optional<String> getUser() {
        return user;
    }

    /**
     * @return The author of the Comment, if the author is a Contact.
     */
    @JsonProperty("contact")
    public Optional<String> getContact() {
        return contact;
    }

    /**
     * @return The comment's text body.
     */
    @JsonProperty("body")
    public Optional<String> getBody() {
        return body;
    }

    /**
     * @return The comment's text body formatted as html.
     */
    @JsonProperty("html_body")
    public Optional<String> getHtmlBody() {
        return htmlBody;
    }

    /**
     * @return The ticket associated with the comment.
     */
    @JsonProperty("ticket")
    public Optional<String> getTicket() {
        return ticket;
    }

    /**
     * @return Whether or not the comment is internal.
     */
    @JsonProperty("is_private")
    public Optional<Boolean> getIsPrivate() {
        return isPrivate;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CommentRequest && equalTo((CommentRequest) other);
    }

    private boolean equalTo(CommentRequest other) {
        return user.equals(other.user)
                && contact.equals(other.contact)
                && body.equals(other.body)
                && htmlBody.equals(other.htmlBody)
                && ticket.equals(other.ticket)
                && isPrivate.equals(other.isPrivate)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.user,
                this.contact,
                this.body,
                this.htmlBody,
                this.ticket,
                this.isPrivate,
                this.integrationParams,
                this.linkedAccountParams);
    }

    @Override
    public String toString() {
        return "CommentRequest{" + "user: " + user + ", contact: " + contact + ", body: " + body + ", htmlBody: "
                + htmlBody + ", ticket: " + ticket + ", isPrivate: " + isPrivate + ", integrationParams: "
                + integrationParams + ", linkedAccountParams: " + linkedAccountParams + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> user = Optional.empty();

        private Optional<String> contact = Optional.empty();

        private Optional<String> body = Optional.empty();

        private Optional<String> htmlBody = Optional.empty();

        private Optional<String> ticket = Optional.empty();

        private Optional<Boolean> isPrivate = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(CommentRequest other) {
            user(other.getUser());
            contact(other.getContact());
            body(other.getBody());
            htmlBody(other.getHtmlBody());
            ticket(other.getTicket());
            isPrivate(other.getIsPrivate());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            return this;
        }

        @JsonSetter(value = "user", nulls = Nulls.SKIP)
        public Builder user(Optional<String> user) {
            this.user = user;
            return this;
        }

        public Builder user(String user) {
            this.user = Optional.of(user);
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

        @JsonSetter(value = "body", nulls = Nulls.SKIP)
        public Builder body(Optional<String> body) {
            this.body = body;
            return this;
        }

        public Builder body(String body) {
            this.body = Optional.of(body);
            return this;
        }

        @JsonSetter(value = "html_body", nulls = Nulls.SKIP)
        public Builder htmlBody(Optional<String> htmlBody) {
            this.htmlBody = htmlBody;
            return this;
        }

        public Builder htmlBody(String htmlBody) {
            this.htmlBody = Optional.of(htmlBody);
            return this;
        }

        @JsonSetter(value = "ticket", nulls = Nulls.SKIP)
        public Builder ticket(Optional<String> ticket) {
            this.ticket = ticket;
            return this;
        }

        public Builder ticket(String ticket) {
            this.ticket = Optional.of(ticket);
            return this;
        }

        @JsonSetter(value = "is_private", nulls = Nulls.SKIP)
        public Builder isPrivate(Optional<Boolean> isPrivate) {
            this.isPrivate = isPrivate;
            return this;
        }

        public Builder isPrivate(Boolean isPrivate) {
            this.isPrivate = Optional.of(isPrivate);
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

        public CommentRequest build() {
            return new CommentRequest(
                    user, contact, body, htmlBody, ticket, isPrivate, integrationParams, linkedAccountParams);
        }
    }
}
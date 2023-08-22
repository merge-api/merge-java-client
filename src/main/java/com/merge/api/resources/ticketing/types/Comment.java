package com.merge.api.resources.ticketing.types;

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
@JsonDeserialize(builder = Comment.Builder.class)
public final class Comment {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<CommentUser> user;

    private final Optional<CommentContact> contact;

    private final Optional<String> body;

    private final Optional<String> htmlBody;

    private final Optional<CommentTicket> ticket;

    private final Optional<Boolean> isPrivate;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Comment(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<CommentUser> user,
            Optional<CommentContact> contact,
            Optional<String> body,
            Optional<String> htmlBody,
            Optional<CommentTicket> ticket,
            Optional<Boolean> isPrivate,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.user = user;
        this.contact = contact;
        this.body = body;
        this.htmlBody = htmlBody;
        this.ticket = ticket;
        this.isPrivate = isPrivate;
        this.remoteCreatedAt = remoteCreatedAt;
        this.remoteWasDeleted = remoteWasDeleted;
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
     * @return The author of the Comment, if the author is a User.
     */
    @JsonProperty("user")
    public Optional<CommentUser> getUser() {
        return user;
    }

    /**
     * @return The author of the Comment, if the author is a Contact.
     */
    @JsonProperty("contact")
    public Optional<CommentContact> getContact() {
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
    public Optional<CommentTicket> getTicket() {
        return ticket;
    }

    /**
     * @return Whether or not the comment is internal.
     */
    @JsonProperty("is_private")
    public Optional<Boolean> getIsPrivate() {
        return isPrivate;
    }

    /**
     * @return When the third party's comment was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
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
        return other instanceof Comment && equalTo((Comment) other);
    }

    private boolean equalTo(Comment other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && user.equals(other.user)
                && contact.equals(other.contact)
                && body.equals(other.body)
                && htmlBody.equals(other.htmlBody)
                && ticket.equals(other.ticket)
                && isPrivate.equals(other.isPrivate)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.user,
                this.contact,
                this.body,
                this.htmlBody,
                this.ticket,
                this.isPrivate,
                this.remoteCreatedAt,
                this.remoteWasDeleted,
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

        private Optional<CommentUser> user = Optional.empty();

        private Optional<CommentContact> contact = Optional.empty();

        private Optional<String> body = Optional.empty();

        private Optional<String> htmlBody = Optional.empty();

        private Optional<CommentTicket> ticket = Optional.empty();

        private Optional<Boolean> isPrivate = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Comment other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            user(other.getUser());
            contact(other.getContact());
            body(other.getBody());
            htmlBody(other.getHtmlBody());
            ticket(other.getTicket());
            isPrivate(other.getIsPrivate());
            remoteCreatedAt(other.getRemoteCreatedAt());
            remoteWasDeleted(other.getRemoteWasDeleted());
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

        @JsonSetter(value = "user", nulls = Nulls.SKIP)
        public Builder user(Optional<CommentUser> user) {
            this.user = user;
            return this;
        }

        public Builder user(CommentUser user) {
            this.user = Optional.of(user);
            return this;
        }

        @JsonSetter(value = "contact", nulls = Nulls.SKIP)
        public Builder contact(Optional<CommentContact> contact) {
            this.contact = contact;
            return this;
        }

        public Builder contact(CommentContact contact) {
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
        public Builder ticket(Optional<CommentTicket> ticket) {
            this.ticket = ticket;
            return this;
        }

        public Builder ticket(CommentTicket ticket) {
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

        @JsonSetter(value = "remote_created_at", nulls = Nulls.SKIP)
        public Builder remoteCreatedAt(Optional<OffsetDateTime> remoteCreatedAt) {
            this.remoteCreatedAt = remoteCreatedAt;
            return this;
        }

        public Builder remoteCreatedAt(OffsetDateTime remoteCreatedAt) {
            this.remoteCreatedAt = Optional.of(remoteCreatedAt);
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

        public Comment build() {
            return new Comment(
                    id,
                    remoteId,
                    user,
                    contact,
                    body,
                    htmlBody,
                    ticket,
                    isPrivate,
                    remoteCreatedAt,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

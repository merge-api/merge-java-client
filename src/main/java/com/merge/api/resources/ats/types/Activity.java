package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Activity.Builder.class)
public final class Activity {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<ActivityUser> user;

    private final Optional<OffsetDateTime> remoteCreatedAt;

    private final Optional<ActivityActivityType> activityType;

    private final Optional<String> subject;

    private final Optional<String> body;

    private final Optional<ActivityVisibility> visibility;

    private final Optional<String> candidate;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Activity(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<ActivityUser> user,
            Optional<OffsetDateTime> remoteCreatedAt,
            Optional<ActivityActivityType> activityType,
            Optional<String> subject,
            Optional<String> body,
            Optional<ActivityVisibility> visibility,
            Optional<String> candidate,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.user = user;
        this.remoteCreatedAt = remoteCreatedAt;
        this.activityType = activityType;
        this.subject = subject;
        this.body = body;
        this.visibility = visibility;
        this.candidate = candidate;
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
     * @return The user that performed the action.
     */
    @JsonProperty("user")
    public Optional<ActivityUser> getUser() {
        return user;
    }

    /**
     * @return When the third party's activity was created.
     */
    @JsonProperty("remote_created_at")
    public Optional<OffsetDateTime> getRemoteCreatedAt() {
        return remoteCreatedAt;
    }

    /**
     * @return The activity's type.
     * <ul>
     * <li><code>NOTE</code> - NOTE</li>
     * <li><code>EMAIL</code> - EMAIL</li>
     * <li><code>OTHER</code> - OTHER</li>
     * </ul>
     */
    @JsonProperty("activity_type")
    public Optional<ActivityActivityType> getActivityType() {
        return activityType;
    }

    /**
     * @return The activity's subject.
     */
    @JsonProperty("subject")
    public Optional<String> getSubject() {
        return subject;
    }

    /**
     * @return The activity's body.
     */
    @JsonProperty("body")
    public Optional<String> getBody() {
        return body;
    }

    /**
     * @return The activity's visibility.
     * <ul>
     * <li><code>ADMIN_ONLY</code> - ADMIN_ONLY</li>
     * <li><code>PUBLIC</code> - PUBLIC</li>
     * <li><code>PRIVATE</code> - PRIVATE</li>
     * </ul>
     */
    @JsonProperty("visibility")
    public Optional<ActivityVisibility> getVisibility() {
        return visibility;
    }

    /**
     * @return The activity’s candidate.
     */
    @JsonProperty("candidate")
    public Optional<String> getCandidate() {
        return candidate;
    }

    /**
     * @return Indicates whether or not this object has been deleted by third party webhooks.
     */
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
        return other instanceof Activity && equalTo((Activity) other);
    }

    private boolean equalTo(Activity other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && user.equals(other.user)
                && remoteCreatedAt.equals(other.remoteCreatedAt)
                && activityType.equals(other.activityType)
                && subject.equals(other.subject)
                && body.equals(other.body)
                && visibility.equals(other.visibility)
                && candidate.equals(other.candidate)
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
                this.remoteCreatedAt,
                this.activityType,
                this.subject,
                this.body,
                this.visibility,
                this.candidate,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
    }

    @Override
    public String toString() {
        return "Activity{" + "id: " + id + ", remoteId: " + remoteId + ", user: " + user + ", remoteCreatedAt: "
                + remoteCreatedAt + ", activityType: " + activityType + ", subject: " + subject + ", body: " + body
                + ", visibility: " + visibility + ", candidate: " + candidate + ", remoteWasDeleted: "
                + remoteWasDeleted + ", modifiedAt: " + modifiedAt + ", fieldMappings: " + fieldMappings
                + ", remoteData: " + remoteData + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<ActivityUser> user = Optional.empty();

        private Optional<OffsetDateTime> remoteCreatedAt = Optional.empty();

        private Optional<ActivityActivityType> activityType = Optional.empty();

        private Optional<String> subject = Optional.empty();

        private Optional<String> body = Optional.empty();

        private Optional<ActivityVisibility> visibility = Optional.empty();

        private Optional<String> candidate = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Activity other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            user(other.getUser());
            remoteCreatedAt(other.getRemoteCreatedAt());
            activityType(other.getActivityType());
            subject(other.getSubject());
            body(other.getBody());
            visibility(other.getVisibility());
            candidate(other.getCandidate());
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
        public Builder user(Optional<ActivityUser> user) {
            this.user = user;
            return this;
        }

        public Builder user(ActivityUser user) {
            this.user = Optional.of(user);
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

        @JsonSetter(value = "activity_type", nulls = Nulls.SKIP)
        public Builder activityType(Optional<ActivityActivityType> activityType) {
            this.activityType = activityType;
            return this;
        }

        public Builder activityType(ActivityActivityType activityType) {
            this.activityType = Optional.of(activityType);
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

        @JsonSetter(value = "body", nulls = Nulls.SKIP)
        public Builder body(Optional<String> body) {
            this.body = body;
            return this;
        }

        public Builder body(String body) {
            this.body = Optional.of(body);
            return this;
        }

        @JsonSetter(value = "visibility", nulls = Nulls.SKIP)
        public Builder visibility(Optional<ActivityVisibility> visibility) {
            this.visibility = visibility;
            return this;
        }

        public Builder visibility(ActivityVisibility visibility) {
            this.visibility = Optional.of(visibility);
            return this;
        }

        @JsonSetter(value = "candidate", nulls = Nulls.SKIP)
        public Builder candidate(Optional<String> candidate) {
            this.candidate = candidate;
            return this;
        }

        public Builder candidate(String candidate) {
            this.candidate = Optional.of(candidate);
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

        public Activity build() {
            return new Activity(
                    id,
                    remoteId,
                    user,
                    remoteCreatedAt,
                    activityType,
                    subject,
                    body,
                    visibility,
                    candidate,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

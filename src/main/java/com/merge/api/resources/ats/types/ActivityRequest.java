package com.merge.api.resources.ats.types;

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
@JsonDeserialize(builder = ActivityRequest.Builder.class)
public final class ActivityRequest {
    private final Optional<String> user;

    private final Optional<ActivityRequestActivityType> activityType;

    private final Optional<String> subject;

    private final Optional<String> body;

    private final Optional<ActivityRequestVisibility> visibility;

    private final Optional<String> candidate;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private ActivityRequest(
            Optional<String> user,
            Optional<ActivityRequestActivityType> activityType,
            Optional<String> subject,
            Optional<String> body,
            Optional<ActivityRequestVisibility> visibility,
            Optional<String> candidate,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.user = user;
        this.activityType = activityType;
        this.subject = subject;
        this.body = body;
        this.visibility = visibility;
        this.candidate = candidate;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The user that performed the action.
     */
    @JsonProperty("user")
    public Optional<String> getUser() {
        return user;
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
    public Optional<ActivityRequestActivityType> getActivityType() {
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
    public Optional<ActivityRequestVisibility> getVisibility() {
        return visibility;
    }

    /**
     * @return The activity’s candidate.
     */
    @JsonProperty("candidate")
    public Optional<String> getCandidate() {
        return candidate;
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
        return other instanceof ActivityRequest && equalTo((ActivityRequest) other);
    }

    private boolean equalTo(ActivityRequest other) {
        return user.equals(other.user)
                && activityType.equals(other.activityType)
                && subject.equals(other.subject)
                && body.equals(other.body)
                && visibility.equals(other.visibility)
                && candidate.equals(other.candidate)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.user,
                this.activityType,
                this.subject,
                this.body,
                this.visibility,
                this.candidate,
                this.integrationParams,
                this.linkedAccountParams);
    }

    @Override
    public String toString() {
        return "ActivityRequest{" + "user: " + user + ", activityType: " + activityType + ", subject: " + subject
                + ", body: " + body + ", visibility: " + visibility + ", candidate: " + candidate
                + ", integrationParams: " + integrationParams + ", linkedAccountParams: " + linkedAccountParams + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> user = Optional.empty();

        private Optional<ActivityRequestActivityType> activityType = Optional.empty();

        private Optional<String> subject = Optional.empty();

        private Optional<String> body = Optional.empty();

        private Optional<ActivityRequestVisibility> visibility = Optional.empty();

        private Optional<String> candidate = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(ActivityRequest other) {
            user(other.getUser());
            activityType(other.getActivityType());
            subject(other.getSubject());
            body(other.getBody());
            visibility(other.getVisibility());
            candidate(other.getCandidate());
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

        @JsonSetter(value = "activity_type", nulls = Nulls.SKIP)
        public Builder activityType(Optional<ActivityRequestActivityType> activityType) {
            this.activityType = activityType;
            return this;
        }

        public Builder activityType(ActivityRequestActivityType activityType) {
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
        public Builder visibility(Optional<ActivityRequestVisibility> visibility) {
            this.visibility = visibility;
            return this;
        }

        public Builder visibility(ActivityRequestVisibility visibility) {
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

        public ActivityRequest build() {
            return new ActivityRequest(
                    user, activityType, subject, body, visibility, candidate, integrationParams, linkedAccountParams);
        }
    }
}

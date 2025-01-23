/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ats.types;

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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ScreeningQuestionAnswerRequest.Builder.class)
public final class ScreeningQuestionAnswerRequest {
    private final Optional<String> remoteId;

    private final Optional<ScreeningQuestionAnswerRequestQuestion> question;

    private final Optional<String> answer;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Map<String, Object> additionalProperties;

    private ScreeningQuestionAnswerRequest(
            Optional<String> remoteId,
            Optional<ScreeningQuestionAnswerRequestQuestion> question,
            Optional<String> answer,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Map<String, Object> additionalProperties) {
        this.remoteId = remoteId;
        this.question = question;
        this.answer = answer;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return The screening question associated with the candidate’s answer. To determine the data type of the answer, you can expand on the screening question by adding <code>screening_question_answers.question</code> to the <code>expand</code> query parameter.
     */
    @JsonProperty("question")
    public Optional<ScreeningQuestionAnswerRequestQuestion> getQuestion() {
        return question;
    }

    /**
     * @return The candidate’s response to the screening question.
     */
    @JsonProperty("answer")
    public Optional<String> getAnswer() {
        return answer;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ScreeningQuestionAnswerRequest && equalTo((ScreeningQuestionAnswerRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ScreeningQuestionAnswerRequest other) {
        return remoteId.equals(other.remoteId)
                && question.equals(other.question)
                && answer.equals(other.answer)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.remoteId, this.question, this.answer, this.integrationParams, this.linkedAccountParams);
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
        private Optional<String> remoteId = Optional.empty();

        private Optional<ScreeningQuestionAnswerRequestQuestion> question = Optional.empty();

        private Optional<String> answer = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ScreeningQuestionAnswerRequest other) {
            remoteId(other.getRemoteId());
            question(other.getQuestion());
            answer(other.getAnswer());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            return this;
        }

        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.ofNullable(remoteId);
            return this;
        }

        @JsonSetter(value = "question", nulls = Nulls.SKIP)
        public Builder question(Optional<ScreeningQuestionAnswerRequestQuestion> question) {
            this.question = question;
            return this;
        }

        public Builder question(ScreeningQuestionAnswerRequestQuestion question) {
            this.question = Optional.ofNullable(question);
            return this;
        }

        @JsonSetter(value = "answer", nulls = Nulls.SKIP)
        public Builder answer(Optional<String> answer) {
            this.answer = answer;
            return this;
        }

        public Builder answer(String answer) {
            this.answer = Optional.ofNullable(answer);
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

        public ScreeningQuestionAnswerRequest build() {
            return new ScreeningQuestionAnswerRequest(
                    remoteId, question, answer, integrationParams, linkedAccountParams, additionalProperties);
        }
    }
}

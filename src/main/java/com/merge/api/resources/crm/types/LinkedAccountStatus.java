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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LinkedAccountStatus.Builder.class)
public final class LinkedAccountStatus {
    private final String linkedAccountStatus;

    private final boolean canMakeRequest;

    private final Map<String, Object> additionalProperties;

    private LinkedAccountStatus(
            String linkedAccountStatus, boolean canMakeRequest, Map<String, Object> additionalProperties) {
        this.linkedAccountStatus = linkedAccountStatus;
        this.canMakeRequest = canMakeRequest;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("linked_account_status")
    public String getLinkedAccountStatus() {
        return linkedAccountStatus;
    }

    @JsonProperty("can_make_request")
    public boolean getCanMakeRequest() {
        return canMakeRequest;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LinkedAccountStatus && equalTo((LinkedAccountStatus) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LinkedAccountStatus other) {
        return linkedAccountStatus.equals(other.linkedAccountStatus) && canMakeRequest == other.canMakeRequest;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.linkedAccountStatus, this.canMakeRequest);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LinkedAccountStatusStage builder() {
        return new Builder();
    }

    public interface LinkedAccountStatusStage {
        CanMakeRequestStage linkedAccountStatus(@NotNull String linkedAccountStatus);

        Builder from(LinkedAccountStatus other);
    }

    public interface CanMakeRequestStage {
        _FinalStage canMakeRequest(boolean canMakeRequest);
    }

    public interface _FinalStage {
        LinkedAccountStatus build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LinkedAccountStatusStage, CanMakeRequestStage, _FinalStage {
        private String linkedAccountStatus;

        private boolean canMakeRequest;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LinkedAccountStatus other) {
            linkedAccountStatus(other.getLinkedAccountStatus());
            canMakeRequest(other.getCanMakeRequest());
            return this;
        }

        @java.lang.Override
        @JsonSetter("linked_account_status")
        public CanMakeRequestStage linkedAccountStatus(@NotNull String linkedAccountStatus) {
            this.linkedAccountStatus = linkedAccountStatus;
            return this;
        }

        @java.lang.Override
        @JsonSetter("can_make_request")
        public _FinalStage canMakeRequest(boolean canMakeRequest) {
            this.canMakeRequest = canMakeRequest;
            return this;
        }

        @java.lang.Override
        public LinkedAccountStatus build() {
            return new LinkedAccountStatus(linkedAccountStatus, canMakeRequest, additionalProperties);
        }
    }
}

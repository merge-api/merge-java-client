package com.merge.api.resources.filestorage.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LinkedAccountStatus.Builder.class)
public final class LinkedAccountStatus {
    private final String linkedAccountStatus;

    private final boolean canMakeRequest;

    private LinkedAccountStatus(String linkedAccountStatus, boolean canMakeRequest) {
        this.linkedAccountStatus = linkedAccountStatus;
        this.canMakeRequest = canMakeRequest;
    }

    @JsonProperty("linked_account_status")
    public String getLinkedAccountStatus() {
        return linkedAccountStatus;
    }

    @JsonProperty("can_make_request")
    public boolean getCanMakeRequest() {
        return canMakeRequest;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LinkedAccountStatus && equalTo((LinkedAccountStatus) other);
    }

    private boolean equalTo(LinkedAccountStatus other) {
        return linkedAccountStatus.equals(other.linkedAccountStatus) && canMakeRequest == other.canMakeRequest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.linkedAccountStatus, this.canMakeRequest);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LinkedAccountStatusStage builder() {
        return new Builder();
    }

    public interface LinkedAccountStatusStage {
        CanMakeRequestStage linkedAccountStatus(String linkedAccountStatus);

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

        private Builder() {}

        @Override
        public Builder from(LinkedAccountStatus other) {
            linkedAccountStatus(other.getLinkedAccountStatus());
            canMakeRequest(other.getCanMakeRequest());
            return this;
        }

        @Override
        @JsonSetter("linked_account_status")
        public CanMakeRequestStage linkedAccountStatus(String linkedAccountStatus) {
            this.linkedAccountStatus = linkedAccountStatus;
            return this;
        }

        @Override
        @JsonSetter("can_make_request")
        public _FinalStage canMakeRequest(boolean canMakeRequest) {
            this.canMakeRequest = canMakeRequest;
            return this;
        }

        @Override
        public LinkedAccountStatus build() {
            return new LinkedAccountStatus(linkedAccountStatus, canMakeRequest);
        }
    }
}

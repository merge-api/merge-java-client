package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LinkedAccountSelectiveSyncConfigurationRequest.Builder.class)
public final class LinkedAccountSelectiveSyncConfigurationRequest {
    private final List<LinkedAccountConditionRequest> linkedAccountConditions;

    private LinkedAccountSelectiveSyncConfigurationRequest(
            List<LinkedAccountConditionRequest> linkedAccountConditions) {
        this.linkedAccountConditions = linkedAccountConditions;
    }

    /**
     * @return The conditions belonging to a selective sync.
     */
    @JsonProperty("linked_account_conditions")
    public List<LinkedAccountConditionRequest> getLinkedAccountConditions() {
        return linkedAccountConditions;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LinkedAccountSelectiveSyncConfigurationRequest
                && equalTo((LinkedAccountSelectiveSyncConfigurationRequest) other);
    }

    private boolean equalTo(LinkedAccountSelectiveSyncConfigurationRequest other) {
        return linkedAccountConditions.equals(other.linkedAccountConditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.linkedAccountConditions);
    }

    @Override
    public String toString() {
        return "LinkedAccountSelectiveSyncConfigurationRequest{" + "linkedAccountConditions: " + linkedAccountConditions
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<LinkedAccountConditionRequest> linkedAccountConditions = new ArrayList<>();

        private Builder() {}

        public Builder from(LinkedAccountSelectiveSyncConfigurationRequest other) {
            linkedAccountConditions(other.getLinkedAccountConditions());
            return this;
        }

        @JsonSetter(value = "linked_account_conditions", nulls = Nulls.SKIP)
        public Builder linkedAccountConditions(List<LinkedAccountConditionRequest> linkedAccountConditions) {
            this.linkedAccountConditions.clear();
            this.linkedAccountConditions.addAll(linkedAccountConditions);
            return this;
        }

        public Builder addLinkedAccountConditions(LinkedAccountConditionRequest linkedAccountConditions) {
            this.linkedAccountConditions.add(linkedAccountConditions);
            return this;
        }

        public Builder addAllLinkedAccountConditions(List<LinkedAccountConditionRequest> linkedAccountConditions) {
            this.linkedAccountConditions.addAll(linkedAccountConditions);
            return this;
        }

        public LinkedAccountSelectiveSyncConfigurationRequest build() {
            return new LinkedAccountSelectiveSyncConfigurationRequest(linkedAccountConditions);
        }
    }
}

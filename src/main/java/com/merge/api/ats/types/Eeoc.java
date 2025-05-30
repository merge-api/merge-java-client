/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

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
@JsonDeserialize(builder = Eeoc.Builder.class)
public final class Eeoc {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<EeocCandidate> candidate;

    private final Optional<OffsetDateTime> submittedAt;

    private final Optional<RaceEnum> race;

    private final Optional<GenderEnum> gender;

    private final Optional<VeteranStatusEnum> veteranStatus;

    private final Optional<DisabilityStatusEnum> disabilityStatus;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private final Map<String, Object> additionalProperties;

    private Eeoc(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<EeocCandidate> candidate,
            Optional<OffsetDateTime> submittedAt,
            Optional<RaceEnum> race,
            Optional<GenderEnum> gender,
            Optional<VeteranStatusEnum> veteranStatus,
            Optional<DisabilityStatusEnum> disabilityStatus,
            Optional<Boolean> remoteWasDeleted,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.candidate = candidate;
        this.submittedAt = submittedAt;
        this.race = race;
        this.gender = gender;
        this.veteranStatus = veteranStatus;
        this.disabilityStatus = disabilityStatus;
        this.remoteWasDeleted = remoteWasDeleted;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
        this.additionalProperties = additionalProperties;
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
     * @return The datetime that this object was created by Merge.
     */
    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The datetime that this object was modified by Merge.
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    /**
     * @return The candidate being represented.
     */
    @JsonProperty("candidate")
    public Optional<EeocCandidate> getCandidate() {
        return candidate;
    }

    /**
     * @return When the information was submitted.
     */
    @JsonProperty("submitted_at")
    public Optional<OffsetDateTime> getSubmittedAt() {
        return submittedAt;
    }

    /**
     * @return The candidate's race.
     * <ul>
     * <li><code>AMERICAN_INDIAN_OR_ALASKAN_NATIVE</code> - AMERICAN_INDIAN_OR_ALASKAN_NATIVE</li>
     * <li><code>ASIAN</code> - ASIAN</li>
     * <li><code>BLACK_OR_AFRICAN_AMERICAN</code> - BLACK_OR_AFRICAN_AMERICAN</li>
     * <li><code>HISPANIC_OR_LATINO</code> - HISPANIC_OR_LATINO</li>
     * <li><code>WHITE</code> - WHITE</li>
     * <li><code>NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER</code> - NATIVE_HAWAIIAN_OR_OTHER_PACIFIC_ISLANDER</li>
     * <li><code>TWO_OR_MORE_RACES</code> - TWO_OR_MORE_RACES</li>
     * <li><code>DECLINE_TO_SELF_IDENTIFY</code> - DECLINE_TO_SELF_IDENTIFY</li>
     * </ul>
     */
    @JsonProperty("race")
    public Optional<RaceEnum> getRace() {
        return race;
    }

    /**
     * @return The candidate's gender.
     * <ul>
     * <li><code>MALE</code> - MALE</li>
     * <li><code>FEMALE</code> - FEMALE</li>
     * <li><code>NON-BINARY</code> - NON-BINARY</li>
     * <li><code>OTHER</code> - OTHER</li>
     * <li><code>DECLINE_TO_SELF_IDENTIFY</code> - DECLINE_TO_SELF_IDENTIFY</li>
     * </ul>
     */
    @JsonProperty("gender")
    public Optional<GenderEnum> getGender() {
        return gender;
    }

    /**
     * @return The candidate's veteran status.
     * <ul>
     * <li><code>I_AM_NOT_A_PROTECTED_VETERAN</code> - I_AM_NOT_A_PROTECTED_VETERAN</li>
     * <li><code>I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN</code> - I_IDENTIFY_AS_ONE_OR_MORE_OF_THE_CLASSIFICATIONS_OF_A_PROTECTED_VETERAN</li>
     * <li><code>I_DONT_WISH_TO_ANSWER</code> - I_DONT_WISH_TO_ANSWER</li>
     * </ul>
     */
    @JsonProperty("veteran_status")
    public Optional<VeteranStatusEnum> getVeteranStatus() {
        return veteranStatus;
    }

    /**
     * @return The candidate's disability status.
     * <ul>
     * <li><code>YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY</code> - YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY</li>
     * <li><code>NO_I_DONT_HAVE_A_DISABILITY</code> - NO_I_DONT_HAVE_A_DISABILITY</li>
     * <li><code>I_DONT_WISH_TO_ANSWER</code> - I_DONT_WISH_TO_ANSWER</li>
     * </ul>
     */
    @JsonProperty("disability_status")
    public Optional<DisabilityStatusEnum> getDisabilityStatus() {
        return disabilityStatus;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    @JsonProperty("field_mappings")
    public Optional<Map<String, JsonNode>> getFieldMappings() {
        return fieldMappings;
    }

    @JsonProperty("remote_data")
    public Optional<List<RemoteData>> getRemoteData() {
        return remoteData;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Eeoc && equalTo((Eeoc) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Eeoc other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && candidate.equals(other.candidate)
                && submittedAt.equals(other.submittedAt)
                && race.equals(other.race)
                && gender.equals(other.gender)
                && veteranStatus.equals(other.veteranStatus)
                && disabilityStatus.equals(other.disabilityStatus)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.createdAt,
                this.modifiedAt,
                this.candidate,
                this.submittedAt,
                this.race,
                this.gender,
                this.veteranStatus,
                this.disabilityStatus,
                this.remoteWasDeleted,
                this.fieldMappings,
                this.remoteData);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<EeocCandidate> candidate = Optional.empty();

        private Optional<OffsetDateTime> submittedAt = Optional.empty();

        private Optional<RaceEnum> race = Optional.empty();

        private Optional<GenderEnum> gender = Optional.empty();

        private Optional<VeteranStatusEnum> veteranStatus = Optional.empty();

        private Optional<DisabilityStatusEnum> disabilityStatus = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Eeoc other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            candidate(other.getCandidate());
            submittedAt(other.getSubmittedAt());
            race(other.getRace());
            gender(other.getGender());
            veteranStatus(other.getVeteranStatus());
            disabilityStatus(other.getDisabilityStatus());
            remoteWasDeleted(other.getRemoteWasDeleted());
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
            this.id = Optional.ofNullable(id);
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

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.ofNullable(modifiedAt);
            return this;
        }

        @JsonSetter(value = "candidate", nulls = Nulls.SKIP)
        public Builder candidate(Optional<EeocCandidate> candidate) {
            this.candidate = candidate;
            return this;
        }

        public Builder candidate(EeocCandidate candidate) {
            this.candidate = Optional.ofNullable(candidate);
            return this;
        }

        @JsonSetter(value = "submitted_at", nulls = Nulls.SKIP)
        public Builder submittedAt(Optional<OffsetDateTime> submittedAt) {
            this.submittedAt = submittedAt;
            return this;
        }

        public Builder submittedAt(OffsetDateTime submittedAt) {
            this.submittedAt = Optional.ofNullable(submittedAt);
            return this;
        }

        @JsonSetter(value = "race", nulls = Nulls.SKIP)
        public Builder race(Optional<RaceEnum> race) {
            this.race = race;
            return this;
        }

        public Builder race(RaceEnum race) {
            this.race = Optional.ofNullable(race);
            return this;
        }

        @JsonSetter(value = "gender", nulls = Nulls.SKIP)
        public Builder gender(Optional<GenderEnum> gender) {
            this.gender = gender;
            return this;
        }

        public Builder gender(GenderEnum gender) {
            this.gender = Optional.ofNullable(gender);
            return this;
        }

        @JsonSetter(value = "veteran_status", nulls = Nulls.SKIP)
        public Builder veteranStatus(Optional<VeteranStatusEnum> veteranStatus) {
            this.veteranStatus = veteranStatus;
            return this;
        }

        public Builder veteranStatus(VeteranStatusEnum veteranStatus) {
            this.veteranStatus = Optional.ofNullable(veteranStatus);
            return this;
        }

        @JsonSetter(value = "disability_status", nulls = Nulls.SKIP)
        public Builder disabilityStatus(Optional<DisabilityStatusEnum> disabilityStatus) {
            this.disabilityStatus = disabilityStatus;
            return this;
        }

        public Builder disabilityStatus(DisabilityStatusEnum disabilityStatus) {
            this.disabilityStatus = Optional.ofNullable(disabilityStatus);
            return this;
        }

        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.ofNullable(remoteWasDeleted);
            return this;
        }

        @JsonSetter(value = "field_mappings", nulls = Nulls.SKIP)
        public Builder fieldMappings(Optional<Map<String, JsonNode>> fieldMappings) {
            this.fieldMappings = fieldMappings;
            return this;
        }

        public Builder fieldMappings(Map<String, JsonNode> fieldMappings) {
            this.fieldMappings = Optional.ofNullable(fieldMappings);
            return this;
        }

        @JsonSetter(value = "remote_data", nulls = Nulls.SKIP)
        public Builder remoteData(Optional<List<RemoteData>> remoteData) {
            this.remoteData = remoteData;
            return this;
        }

        public Builder remoteData(List<RemoteData> remoteData) {
            this.remoteData = Optional.ofNullable(remoteData);
            return this;
        }

        public Eeoc build() {
            return new Eeoc(
                    id,
                    remoteId,
                    createdAt,
                    modifiedAt,
                    candidate,
                    submittedAt,
                    race,
                    gender,
                    veteranStatus,
                    disabilityStatus,
                    remoteWasDeleted,
                    fieldMappings,
                    remoteData,
                    additionalProperties);
        }
    }
}

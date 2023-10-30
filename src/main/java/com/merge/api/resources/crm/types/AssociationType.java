package com.merge.api.resources.crm.types;

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
@JsonDeserialize(builder = AssociationType.Builder.class)
public final class AssociationType {
    private final Optional<Map<String, JsonNode>> sourceObjectClass;

    private final Optional<List<AssociationSubType>> targetObjectClasses;

    private final Optional<String> remoteKeyName;

    private final Optional<String> displayName;

    private final Optional<AssociationTypeCardinality> cardinality;

    private final Optional<Boolean> isRequired;

    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private AssociationType(
            Optional<Map<String, JsonNode>> sourceObjectClass,
            Optional<List<AssociationSubType>> targetObjectClasses,
            Optional<String> remoteKeyName,
            Optional<String> displayName,
            Optional<AssociationTypeCardinality> cardinality,
            Optional<Boolean> isRequired,
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt) {
        this.sourceObjectClass = sourceObjectClass;
        this.targetObjectClasses = targetObjectClasses;
        this.remoteKeyName = remoteKeyName;
        this.displayName = displayName;
        this.cardinality = cardinality;
        this.isRequired = isRequired;
        this.id = id;
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    @JsonProperty("source_object_class")
    public Optional<Map<String, JsonNode>> getSourceObjectClass() {
        return sourceObjectClass;
    }

    @JsonProperty("target_object_classes")
    public Optional<List<AssociationSubType>> getTargetObjectClasses() {
        return targetObjectClasses;
    }

    @JsonProperty("remote_key_name")
    public Optional<String> getRemoteKeyName() {
        return remoteKeyName;
    }

    @JsonProperty("display_name")
    public Optional<String> getDisplayName() {
        return displayName;
    }

    @JsonProperty("cardinality")
    public Optional<AssociationTypeCardinality> getCardinality() {
        return cardinality;
    }

    @JsonProperty("is_required")
    public Optional<Boolean> getIsRequired() {
        return isRequired;
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

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssociationType && equalTo((AssociationType) other);
    }

    private boolean equalTo(AssociationType other) {
        return sourceObjectClass.equals(other.sourceObjectClass)
                && targetObjectClasses.equals(other.targetObjectClasses)
                && remoteKeyName.equals(other.remoteKeyName)
                && displayName.equals(other.displayName)
                && cardinality.equals(other.cardinality)
                && isRequired.equals(other.isRequired)
                && id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.sourceObjectClass,
                this.targetObjectClasses,
                this.remoteKeyName,
                this.displayName,
                this.cardinality,
                this.isRequired,
                this.id,
                this.remoteId,
                this.createdAt,
                this.modifiedAt);
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
        private Optional<Map<String, JsonNode>> sourceObjectClass = Optional.empty();

        private Optional<List<AssociationSubType>> targetObjectClasses = Optional.empty();

        private Optional<String> remoteKeyName = Optional.empty();

        private Optional<String> displayName = Optional.empty();

        private Optional<AssociationTypeCardinality> cardinality = Optional.empty();

        private Optional<Boolean> isRequired = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(AssociationType other) {
            sourceObjectClass(other.getSourceObjectClass());
            targetObjectClasses(other.getTargetObjectClasses());
            remoteKeyName(other.getRemoteKeyName());
            displayName(other.getDisplayName());
            cardinality(other.getCardinality());
            isRequired(other.getIsRequired());
            id(other.getId());
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            return this;
        }

        @JsonSetter(value = "source_object_class", nulls = Nulls.SKIP)
        public Builder sourceObjectClass(Optional<Map<String, JsonNode>> sourceObjectClass) {
            this.sourceObjectClass = sourceObjectClass;
            return this;
        }

        public Builder sourceObjectClass(Map<String, JsonNode> sourceObjectClass) {
            this.sourceObjectClass = Optional.of(sourceObjectClass);
            return this;
        }

        @JsonSetter(value = "target_object_classes", nulls = Nulls.SKIP)
        public Builder targetObjectClasses(Optional<List<AssociationSubType>> targetObjectClasses) {
            this.targetObjectClasses = targetObjectClasses;
            return this;
        }

        public Builder targetObjectClasses(List<AssociationSubType> targetObjectClasses) {
            this.targetObjectClasses = Optional.of(targetObjectClasses);
            return this;
        }

        @JsonSetter(value = "remote_key_name", nulls = Nulls.SKIP)
        public Builder remoteKeyName(Optional<String> remoteKeyName) {
            this.remoteKeyName = remoteKeyName;
            return this;
        }

        public Builder remoteKeyName(String remoteKeyName) {
            this.remoteKeyName = Optional.of(remoteKeyName);
            return this;
        }

        @JsonSetter(value = "display_name", nulls = Nulls.SKIP)
        public Builder displayName(Optional<String> displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = Optional.of(displayName);
            return this;
        }

        @JsonSetter(value = "cardinality", nulls = Nulls.SKIP)
        public Builder cardinality(Optional<AssociationTypeCardinality> cardinality) {
            this.cardinality = cardinality;
            return this;
        }

        public Builder cardinality(AssociationTypeCardinality cardinality) {
            this.cardinality = Optional.of(cardinality);
            return this;
        }

        @JsonSetter(value = "is_required", nulls = Nulls.SKIP)
        public Builder isRequired(Optional<Boolean> isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        public Builder isRequired(Boolean isRequired) {
            this.isRequired = Optional.of(isRequired);
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

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
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

        public AssociationType build() {
            return new AssociationType(
                    sourceObjectClass,
                    targetObjectClasses,
                    remoteKeyName,
                    displayName,
                    cardinality,
                    isRequired,
                    id,
                    remoteId,
                    createdAt,
                    modifiedAt);
        }
    }
}

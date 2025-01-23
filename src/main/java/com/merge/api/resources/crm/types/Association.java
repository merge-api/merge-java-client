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
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Association.Builder.class)
public final class Association {
    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<String> sourceObject;

    private final Optional<String> targetObject;

    private final Optional<AssociationAssociationType> associationType;

    private final Map<String, Object> additionalProperties;

    private Association(
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<String> sourceObject,
            Optional<String> targetObject,
            Optional<AssociationAssociationType> associationType,
            Map<String, Object> additionalProperties) {
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.sourceObject = sourceObject;
        this.targetObject = targetObject;
        this.associationType = associationType;
        this.additionalProperties = additionalProperties;
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

    @JsonProperty("source_object")
    public Optional<String> getSourceObject() {
        return sourceObject;
    }

    @JsonProperty("target_object")
    public Optional<String> getTargetObject() {
        return targetObject;
    }

    /**
     * @return The association type the association belongs to.
     */
    @JsonProperty("association_type")
    public Optional<AssociationAssociationType> getAssociationType() {
        return associationType;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Association && equalTo((Association) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Association other) {
        return createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && sourceObject.equals(other.sourceObject)
                && targetObject.equals(other.targetObject)
                && associationType.equals(other.associationType);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.createdAt, this.modifiedAt, this.sourceObject, this.targetObject, this.associationType);
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
        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<String> sourceObject = Optional.empty();

        private Optional<String> targetObject = Optional.empty();

        private Optional<AssociationAssociationType> associationType = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Association other) {
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            sourceObject(other.getSourceObject());
            targetObject(other.getTargetObject());
            associationType(other.getAssociationType());
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

        @JsonSetter(value = "source_object", nulls = Nulls.SKIP)
        public Builder sourceObject(Optional<String> sourceObject) {
            this.sourceObject = sourceObject;
            return this;
        }

        public Builder sourceObject(String sourceObject) {
            this.sourceObject = Optional.ofNullable(sourceObject);
            return this;
        }

        @JsonSetter(value = "target_object", nulls = Nulls.SKIP)
        public Builder targetObject(Optional<String> targetObject) {
            this.targetObject = targetObject;
            return this;
        }

        public Builder targetObject(String targetObject) {
            this.targetObject = Optional.ofNullable(targetObject);
            return this;
        }

        @JsonSetter(value = "association_type", nulls = Nulls.SKIP)
        public Builder associationType(Optional<AssociationAssociationType> associationType) {
            this.associationType = associationType;
            return this;
        }

        public Builder associationType(AssociationAssociationType associationType) {
            this.associationType = Optional.ofNullable(associationType);
            return this;
        }

        public Association build() {
            return new Association(
                    createdAt, modifiedAt, sourceObject, targetObject, associationType, additionalProperties);
        }
    }
}

package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssociationTypeRequestRequest.Builder.class)
public final class AssociationTypeRequestRequest {
    private final ObjectClassDescriptionRequest sourceObjectClass;

    private final List<ObjectClassDescriptionRequest> targetObjectClasses;

    private final String remoteKeyName;

    private final Optional<String> displayName;

    private final Optional<CardinalityEnum> cardinality;

    private final Optional<Boolean> isRequired;

    private AssociationTypeRequestRequest(
            ObjectClassDescriptionRequest sourceObjectClass,
            List<ObjectClassDescriptionRequest> targetObjectClasses,
            String remoteKeyName,
            Optional<String> displayName,
            Optional<CardinalityEnum> cardinality,
            Optional<Boolean> isRequired) {
        this.sourceObjectClass = sourceObjectClass;
        this.targetObjectClasses = targetObjectClasses;
        this.remoteKeyName = remoteKeyName;
        this.displayName = displayName;
        this.cardinality = cardinality;
        this.isRequired = isRequired;
    }

    @JsonProperty("source_object_class")
    public ObjectClassDescriptionRequest getSourceObjectClass() {
        return sourceObjectClass;
    }

    @JsonProperty("target_object_classes")
    public List<ObjectClassDescriptionRequest> getTargetObjectClasses() {
        return targetObjectClasses;
    }

    @JsonProperty("remote_key_name")
    public String getRemoteKeyName() {
        return remoteKeyName;
    }

    @JsonProperty("display_name")
    public Optional<String> getDisplayName() {
        return displayName;
    }

    @JsonProperty("cardinality")
    public Optional<CardinalityEnum> getCardinality() {
        return cardinality;
    }

    @JsonProperty("is_required")
    public Optional<Boolean> getIsRequired() {
        return isRequired;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssociationTypeRequestRequest && equalTo((AssociationTypeRequestRequest) other);
    }

    private boolean equalTo(AssociationTypeRequestRequest other) {
        return sourceObjectClass.equals(other.sourceObjectClass)
                && targetObjectClasses.equals(other.targetObjectClasses)
                && remoteKeyName.equals(other.remoteKeyName)
                && displayName.equals(other.displayName)
                && cardinality.equals(other.cardinality)
                && isRequired.equals(other.isRequired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.sourceObjectClass,
                this.targetObjectClasses,
                this.remoteKeyName,
                this.displayName,
                this.cardinality,
                this.isRequired);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SourceObjectClassStage builder() {
        return new Builder();
    }

    public interface SourceObjectClassStage {
        RemoteKeyNameStage sourceObjectClass(ObjectClassDescriptionRequest sourceObjectClass);

        Builder from(AssociationTypeRequestRequest other);
    }

    public interface RemoteKeyNameStage {
        _FinalStage remoteKeyName(String remoteKeyName);
    }

    public interface _FinalStage {
        AssociationTypeRequestRequest build();

        _FinalStage targetObjectClasses(List<ObjectClassDescriptionRequest> targetObjectClasses);

        _FinalStage addTargetObjectClasses(ObjectClassDescriptionRequest targetObjectClasses);

        _FinalStage addAllTargetObjectClasses(List<ObjectClassDescriptionRequest> targetObjectClasses);

        _FinalStage displayName(Optional<String> displayName);

        _FinalStage displayName(String displayName);

        _FinalStage cardinality(Optional<CardinalityEnum> cardinality);

        _FinalStage cardinality(CardinalityEnum cardinality);

        _FinalStage isRequired(Optional<Boolean> isRequired);

        _FinalStage isRequired(Boolean isRequired);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SourceObjectClassStage, RemoteKeyNameStage, _FinalStage {
        private ObjectClassDescriptionRequest sourceObjectClass;

        private String remoteKeyName;

        private Optional<Boolean> isRequired = Optional.empty();

        private Optional<CardinalityEnum> cardinality = Optional.empty();

        private Optional<String> displayName = Optional.empty();

        private List<ObjectClassDescriptionRequest> targetObjectClasses = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(AssociationTypeRequestRequest other) {
            sourceObjectClass(other.getSourceObjectClass());
            targetObjectClasses(other.getTargetObjectClasses());
            remoteKeyName(other.getRemoteKeyName());
            displayName(other.getDisplayName());
            cardinality(other.getCardinality());
            isRequired(other.getIsRequired());
            return this;
        }

        @Override
        @JsonSetter("source_object_class")
        public RemoteKeyNameStage sourceObjectClass(ObjectClassDescriptionRequest sourceObjectClass) {
            this.sourceObjectClass = sourceObjectClass;
            return this;
        }

        @Override
        @JsonSetter("remote_key_name")
        public _FinalStage remoteKeyName(String remoteKeyName) {
            this.remoteKeyName = remoteKeyName;
            return this;
        }

        @Override
        public _FinalStage isRequired(Boolean isRequired) {
            this.isRequired = Optional.of(isRequired);
            return this;
        }

        @Override
        @JsonSetter(value = "is_required", nulls = Nulls.SKIP)
        public _FinalStage isRequired(Optional<Boolean> isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        @Override
        public _FinalStage cardinality(CardinalityEnum cardinality) {
            this.cardinality = Optional.of(cardinality);
            return this;
        }

        @Override
        @JsonSetter(value = "cardinality", nulls = Nulls.SKIP)
        public _FinalStage cardinality(Optional<CardinalityEnum> cardinality) {
            this.cardinality = cardinality;
            return this;
        }

        @Override
        public _FinalStage displayName(String displayName) {
            this.displayName = Optional.of(displayName);
            return this;
        }

        @Override
        @JsonSetter(value = "display_name", nulls = Nulls.SKIP)
        public _FinalStage displayName(Optional<String> displayName) {
            this.displayName = displayName;
            return this;
        }

        @Override
        public _FinalStage addAllTargetObjectClasses(List<ObjectClassDescriptionRequest> targetObjectClasses) {
            this.targetObjectClasses.addAll(targetObjectClasses);
            return this;
        }

        @Override
        public _FinalStage addTargetObjectClasses(ObjectClassDescriptionRequest targetObjectClasses) {
            this.targetObjectClasses.add(targetObjectClasses);
            return this;
        }

        @Override
        @JsonSetter(value = "target_object_classes", nulls = Nulls.SKIP)
        public _FinalStage targetObjectClasses(List<ObjectClassDescriptionRequest> targetObjectClasses) {
            this.targetObjectClasses.clear();
            this.targetObjectClasses.addAll(targetObjectClasses);
            return this;
        }

        @Override
        public AssociationTypeRequestRequest build() {
            return new AssociationTypeRequestRequest(
                    sourceObjectClass, targetObjectClasses, remoteKeyName, displayName, cardinality, isRequired);
        }
    }
}

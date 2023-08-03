package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssociationSubType.Builder.class)
public final class AssociationSubType {
    private final Optional<String> id;

    private final Optional<String> originType;

    private final Optional<OffsetDateTime> modifiedAt;

    private AssociationSubType(Optional<String> id, Optional<String> originType, Optional<OffsetDateTime> modifiedAt) {
        this.id = id;
        this.originType = originType;
        this.modifiedAt = modifiedAt;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("origin_type")
    public Optional<String> getOriginType() {
        return originType;
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
        return other instanceof AssociationSubType && equalTo((AssociationSubType) other);
    }

    private boolean equalTo(AssociationSubType other) {
        return id.equals(other.id) && originType.equals(other.originType) && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.originType, this.modifiedAt);
    }

    @Override
    public String toString() {
        return "AssociationSubType{" + "id: " + id + ", originType: " + originType + ", modifiedAt: " + modifiedAt
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> originType = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(AssociationSubType other) {
            id(other.getId());
            originType(other.getOriginType());
            modifiedAt(other.getModifiedAt());
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

        @JsonSetter(value = "origin_type", nulls = Nulls.SKIP)
        public Builder originType(Optional<String> originType) {
            this.originType = originType;
            return this;
        }

        public Builder originType(String originType) {
            this.originType = Optional.of(originType);
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

        public AssociationSubType build() {
            return new AssociationSubType(id, originType, modifiedAt);
        }
    }
}

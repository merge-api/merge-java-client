/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.accounting.types;

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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TaxComponent.Builder.class)
public final class TaxComponent {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<String> name;

    private final Optional<String> rate;

    private final Optional<Boolean> isCompound;

    private final Optional<TaxComponentComponentType> componentType;

    private final Optional<Boolean> remoteWasDeleted;

    private final Map<String, Object> additionalProperties;

    private TaxComponent(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<String> name,
            Optional<String> rate,
            Optional<Boolean> isCompound,
            Optional<TaxComponentComponentType> componentType,
            Optional<Boolean> remoteWasDeleted,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.name = name;
        this.rate = rate;
        this.isCompound = isCompound;
        this.componentType = componentType;
        this.remoteWasDeleted = remoteWasDeleted;
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
     * @return The tax rate’s name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The tax component’s rate.
     */
    @JsonProperty("rate")
    public Optional<String> getRate() {
        return rate;
    }

    /**
     * @return <p>True if the tax component is compound, False if not.</p>
     */
    @JsonProperty("is_compound")
    public Optional<Boolean> getIsCompound() {
        return isCompound;
    }

    /**
     * @return <p>PURCHASE if the tax component corresponds to a purchase tax or SALES if the tax component corresponds to a sales tax.</p>
     * <ul>
     * <li><code>SALES</code> - SALES</li>
     * <li><code>PURCHASE</code> - PURCHASE</li>
     * </ul>
     */
    @JsonProperty("component_type")
    public Optional<TaxComponentComponentType> getComponentType() {
        return componentType;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TaxComponent && equalTo((TaxComponent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TaxComponent other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && name.equals(other.name)
                && rate.equals(other.rate)
                && isCompound.equals(other.isCompound)
                && componentType.equals(other.componentType)
                && remoteWasDeleted.equals(other.remoteWasDeleted);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.createdAt,
                this.modifiedAt,
                this.name,
                this.rate,
                this.isCompound,
                this.componentType,
                this.remoteWasDeleted);
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

        private Optional<String> name = Optional.empty();

        private Optional<String> rate = Optional.empty();

        private Optional<Boolean> isCompound = Optional.empty();

        private Optional<TaxComponentComponentType> componentType = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(TaxComponent other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            name(other.getName());
            rate(other.getRate());
            isCompound(other.getIsCompound());
            componentType(other.getComponentType());
            remoteWasDeleted(other.getRemoteWasDeleted());
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "rate", nulls = Nulls.SKIP)
        public Builder rate(Optional<String> rate) {
            this.rate = rate;
            return this;
        }

        public Builder rate(String rate) {
            this.rate = Optional.of(rate);
            return this;
        }

        @JsonSetter(value = "is_compound", nulls = Nulls.SKIP)
        public Builder isCompound(Optional<Boolean> isCompound) {
            this.isCompound = isCompound;
            return this;
        }

        public Builder isCompound(Boolean isCompound) {
            this.isCompound = Optional.of(isCompound);
            return this;
        }

        @JsonSetter(value = "component_type", nulls = Nulls.SKIP)
        public Builder componentType(Optional<TaxComponentComponentType> componentType) {
            this.componentType = componentType;
            return this;
        }

        public Builder componentType(TaxComponentComponentType componentType) {
            this.componentType = Optional.of(componentType);
            return this;
        }

        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.of(remoteWasDeleted);
            return this;
        }

        public TaxComponent build() {
            return new TaxComponent(
                    id,
                    remoteId,
                    createdAt,
                    modifiedAt,
                    name,
                    rate,
                    isCompound,
                    componentType,
                    remoteWasDeleted,
                    additionalProperties);
        }
    }
}

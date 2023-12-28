package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PaymentLineItem.Builder.class)
public final class PaymentLineItem {
    private final Optional<String> appliedAmount;

    private final Optional<OffsetDateTime> appliedDate;

    private final Optional<String> remoteId;

    private final Optional<String> relatedObjectId;

    private final Optional<String> relatedObjectType;

    private final Optional<String> id;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private PaymentLineItem(
            Optional<String> appliedAmount,
            Optional<OffsetDateTime> appliedDate,
            Optional<String> remoteId,
            Optional<String> relatedObjectId,
            Optional<String> relatedObjectType,
            Optional<String> id,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt) {
        this.appliedAmount = appliedAmount;
        this.appliedDate = appliedDate;
        this.remoteId = remoteId;
        this.relatedObjectId = relatedObjectId;
        this.relatedObjectType = relatedObjectType;
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    /**
     * @return The amount being applied to the transaction.
     */
    @JsonProperty("applied_amount")
    public Optional<String> getAppliedAmount() {
        return appliedAmount;
    }

    /**
     * @return The date the payment portion is applied.
     */
    @JsonProperty("applied_date")
    public Optional<OffsetDateTime> getAppliedDate() {
        return appliedDate;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    /**
     * @return The Merge ID of the transaction the payment portion is being applied to.
     */
    @JsonProperty("related_object_id")
    public Optional<String> getRelatedObjectId() {
        return relatedObjectId;
    }

    /**
     * @return The type of transaction the payment portion is being applied to. Possible values include: INVOICE, JOURNAL_ENTRY, or CREDIT_NOTE.
     */
    @JsonProperty("related_object_type")
    public Optional<String> getRelatedObjectType() {
        return relatedObjectType;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
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
        return other instanceof PaymentLineItem && equalTo((PaymentLineItem) other);
    }

    private boolean equalTo(PaymentLineItem other) {
        return appliedAmount.equals(other.appliedAmount)
                && appliedDate.equals(other.appliedDate)
                && remoteId.equals(other.remoteId)
                && relatedObjectId.equals(other.relatedObjectId)
                && relatedObjectType.equals(other.relatedObjectType)
                && id.equals(other.id)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.appliedAmount,
                this.appliedDate,
                this.remoteId,
                this.relatedObjectId,
                this.relatedObjectType,
                this.id,
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
        private Optional<String> appliedAmount = Optional.empty();

        private Optional<OffsetDateTime> appliedDate = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> relatedObjectId = Optional.empty();

        private Optional<String> relatedObjectType = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(PaymentLineItem other) {
            appliedAmount(other.getAppliedAmount());
            appliedDate(other.getAppliedDate());
            remoteId(other.getRemoteId());
            relatedObjectId(other.getRelatedObjectId());
            relatedObjectType(other.getRelatedObjectType());
            id(other.getId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            return this;
        }

        @JsonSetter(value = "applied_amount", nulls = Nulls.SKIP)
        public Builder appliedAmount(Optional<String> appliedAmount) {
            this.appliedAmount = appliedAmount;
            return this;
        }

        public Builder appliedAmount(String appliedAmount) {
            this.appliedAmount = Optional.of(appliedAmount);
            return this;
        }

        @JsonSetter(value = "applied_date", nulls = Nulls.SKIP)
        public Builder appliedDate(Optional<OffsetDateTime> appliedDate) {
            this.appliedDate = appliedDate;
            return this;
        }

        public Builder appliedDate(OffsetDateTime appliedDate) {
            this.appliedDate = Optional.of(appliedDate);
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

        @JsonSetter(value = "related_object_id", nulls = Nulls.SKIP)
        public Builder relatedObjectId(Optional<String> relatedObjectId) {
            this.relatedObjectId = relatedObjectId;
            return this;
        }

        public Builder relatedObjectId(String relatedObjectId) {
            this.relatedObjectId = Optional.of(relatedObjectId);
            return this;
        }

        @JsonSetter(value = "related_object_type", nulls = Nulls.SKIP)
        public Builder relatedObjectType(Optional<String> relatedObjectType) {
            this.relatedObjectType = relatedObjectType;
            return this;
        }

        public Builder relatedObjectType(String relatedObjectType) {
            this.relatedObjectType = Optional.of(relatedObjectType);
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

        public PaymentLineItem build() {
            return new PaymentLineItem(
                    appliedAmount,
                    appliedDate,
                    remoteId,
                    relatedObjectId,
                    relatedObjectType,
                    id,
                    createdAt,
                    modifiedAt);
        }
    }
}

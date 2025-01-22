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
@JsonDeserialize(builder = CreditNoteApplyLineForInvoice.Builder.class)
public final class CreditNoteApplyLineForInvoice {
    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<CreditNoteApplyLineForInvoiceCreditNote> creditNote;

    private final Optional<OffsetDateTime> appliedDate;

    private final Optional<String> appliedAmount;

    private final Optional<Boolean> remoteWasDeleted;

    private final Map<String, Object> additionalProperties;

    private CreditNoteApplyLineForInvoice(
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<CreditNoteApplyLineForInvoiceCreditNote> creditNote,
            Optional<OffsetDateTime> appliedDate,
            Optional<String> appliedAmount,
            Optional<Boolean> remoteWasDeleted,
            Map<String, Object> additionalProperties) {
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.creditNote = creditNote;
        this.appliedDate = appliedDate;
        this.appliedAmount = appliedAmount;
        this.remoteWasDeleted = remoteWasDeleted;
        this.additionalProperties = additionalProperties;
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

    @JsonProperty("credit_note")
    public Optional<CreditNoteApplyLineForInvoiceCreditNote> getCreditNote() {
        return creditNote;
    }

    /**
     * @return Date that the credit note is applied to the invoice.
     */
    @JsonProperty("applied_date")
    public Optional<OffsetDateTime> getAppliedDate() {
        return appliedDate;
    }

    /**
     * @return The amount of the Credit Note applied to the invoice.
     */
    @JsonProperty("applied_amount")
    public Optional<String> getAppliedAmount() {
        return appliedAmount;
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
        return other instanceof CreditNoteApplyLineForInvoice && equalTo((CreditNoteApplyLineForInvoice) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreditNoteApplyLineForInvoice other) {
        return remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && creditNote.equals(other.creditNote)
                && appliedDate.equals(other.appliedDate)
                && appliedAmount.equals(other.appliedAmount)
                && remoteWasDeleted.equals(other.remoteWasDeleted);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.remoteId,
                this.createdAt,
                this.modifiedAt,
                this.creditNote,
                this.appliedDate,
                this.appliedAmount,
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
        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<CreditNoteApplyLineForInvoiceCreditNote> creditNote = Optional.empty();

        private Optional<OffsetDateTime> appliedDate = Optional.empty();

        private Optional<String> appliedAmount = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreditNoteApplyLineForInvoice other) {
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            creditNote(other.getCreditNote());
            appliedDate(other.getAppliedDate());
            appliedAmount(other.getAppliedAmount());
            remoteWasDeleted(other.getRemoteWasDeleted());
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

        @JsonSetter(value = "credit_note", nulls = Nulls.SKIP)
        public Builder creditNote(Optional<CreditNoteApplyLineForInvoiceCreditNote> creditNote) {
            this.creditNote = creditNote;
            return this;
        }

        public Builder creditNote(CreditNoteApplyLineForInvoiceCreditNote creditNote) {
            this.creditNote = Optional.of(creditNote);
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

        @JsonSetter(value = "applied_amount", nulls = Nulls.SKIP)
        public Builder appliedAmount(Optional<String> appliedAmount) {
            this.appliedAmount = appliedAmount;
            return this;
        }

        public Builder appliedAmount(String appliedAmount) {
            this.appliedAmount = Optional.of(appliedAmount);
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

        public CreditNoteApplyLineForInvoice build() {
            return new CreditNoteApplyLineForInvoice(
                    remoteId,
                    createdAt,
                    modifiedAt,
                    creditNote,
                    appliedDate,
                    appliedAmount,
                    remoteWasDeleted,
                    additionalProperties);
        }
    }
}

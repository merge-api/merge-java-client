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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreditNoteApplyLineForCreditNoteRequest.Builder.class)
public final class CreditNoteApplyLineForCreditNoteRequest {
    private final Optional<String> remoteId;

    private final Optional<CreditNoteApplyLineForCreditNoteRequestInvoice> invoice;

    private final Optional<OffsetDateTime> appliedDate;

    private final Optional<String> appliedAmount;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Map<String, Object> additionalProperties;

    private CreditNoteApplyLineForCreditNoteRequest(
            Optional<String> remoteId,
            Optional<CreditNoteApplyLineForCreditNoteRequestInvoice> invoice,
            Optional<OffsetDateTime> appliedDate,
            Optional<String> appliedAmount,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Map<String, Object> additionalProperties) {
        this.remoteId = remoteId;
        this.invoice = invoice;
        this.appliedDate = appliedDate;
        this.appliedAmount = appliedAmount;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    @JsonProperty("invoice")
    public Optional<CreditNoteApplyLineForCreditNoteRequestInvoice> getInvoice() {
        return invoice;
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

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreditNoteApplyLineForCreditNoteRequest
                && equalTo((CreditNoteApplyLineForCreditNoteRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreditNoteApplyLineForCreditNoteRequest other) {
        return remoteId.equals(other.remoteId)
                && invoice.equals(other.invoice)
                && appliedDate.equals(other.appliedDate)
                && appliedAmount.equals(other.appliedAmount)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.remoteId,
                this.invoice,
                this.appliedDate,
                this.appliedAmount,
                this.integrationParams,
                this.linkedAccountParams);
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

        private Optional<CreditNoteApplyLineForCreditNoteRequestInvoice> invoice = Optional.empty();

        private Optional<OffsetDateTime> appliedDate = Optional.empty();

        private Optional<String> appliedAmount = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreditNoteApplyLineForCreditNoteRequest other) {
            remoteId(other.getRemoteId());
            invoice(other.getInvoice());
            appliedDate(other.getAppliedDate());
            appliedAmount(other.getAppliedAmount());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
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

        @JsonSetter(value = "invoice", nulls = Nulls.SKIP)
        public Builder invoice(Optional<CreditNoteApplyLineForCreditNoteRequestInvoice> invoice) {
            this.invoice = invoice;
            return this;
        }

        public Builder invoice(CreditNoteApplyLineForCreditNoteRequestInvoice invoice) {
            this.invoice = Optional.ofNullable(invoice);
            return this;
        }

        @JsonSetter(value = "applied_date", nulls = Nulls.SKIP)
        public Builder appliedDate(Optional<OffsetDateTime> appliedDate) {
            this.appliedDate = appliedDate;
            return this;
        }

        public Builder appliedDate(OffsetDateTime appliedDate) {
            this.appliedDate = Optional.ofNullable(appliedDate);
            return this;
        }

        @JsonSetter(value = "applied_amount", nulls = Nulls.SKIP)
        public Builder appliedAmount(Optional<String> appliedAmount) {
            this.appliedAmount = appliedAmount;
            return this;
        }

        public Builder appliedAmount(String appliedAmount) {
            this.appliedAmount = Optional.ofNullable(appliedAmount);
            return this;
        }

        @JsonSetter(value = "integration_params", nulls = Nulls.SKIP)
        public Builder integrationParams(Optional<Map<String, JsonNode>> integrationParams) {
            this.integrationParams = integrationParams;
            return this;
        }

        public Builder integrationParams(Map<String, JsonNode> integrationParams) {
            this.integrationParams = Optional.ofNullable(integrationParams);
            return this;
        }

        @JsonSetter(value = "linked_account_params", nulls = Nulls.SKIP)
        public Builder linkedAccountParams(Optional<Map<String, JsonNode>> linkedAccountParams) {
            this.linkedAccountParams = linkedAccountParams;
            return this;
        }

        public Builder linkedAccountParams(Map<String, JsonNode> linkedAccountParams) {
            this.linkedAccountParams = Optional.ofNullable(linkedAccountParams);
            return this;
        }

        public CreditNoteApplyLineForCreditNoteRequest build() {
            return new CreditNoteApplyLineForCreditNoteRequest(
                    remoteId,
                    invoice,
                    appliedDate,
                    appliedAmount,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties);
        }
    }
}

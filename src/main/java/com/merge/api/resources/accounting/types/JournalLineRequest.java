package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = JournalLineRequest.Builder.class)
public final class JournalLineRequest {
    private final Optional<String> remoteId;

    private final Optional<JournalLineRequestAccount> account;

    private final Optional<Double> netAmount;

    private final Optional<JournalLineRequestTrackingCategory> trackingCategory;

    private final Optional<List<Optional<JournalLineRequestTrackingCategoriesItem>>> trackingCategories;

    private final Optional<String> contact;

    private final Optional<String> description;

    private final Optional<String> exchangeRate;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private JournalLineRequest(
            Optional<String> remoteId,
            Optional<JournalLineRequestAccount> account,
            Optional<Double> netAmount,
            Optional<JournalLineRequestTrackingCategory> trackingCategory,
            Optional<List<Optional<JournalLineRequestTrackingCategoriesItem>>> trackingCategories,
            Optional<String> contact,
            Optional<String> description,
            Optional<String> exchangeRate,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams) {
        this.remoteId = remoteId;
        this.account = account;
        this.netAmount = netAmount;
        this.trackingCategory = trackingCategory;
        this.trackingCategories = trackingCategories;
        this.contact = contact;
        this.description = description;
        this.exchangeRate = exchangeRate;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    @JsonProperty("account")
    public Optional<JournalLineRequestAccount> getAccount() {
        return account;
    }

    /**
     * @return The value of the line item including taxes and other fees.
     */
    @JsonProperty("net_amount")
    public Optional<Double> getNetAmount() {
        return netAmount;
    }

    @JsonProperty("tracking_category")
    public Optional<JournalLineRequestTrackingCategory> getTrackingCategory() {
        return trackingCategory;
    }

    @JsonProperty("tracking_categories")
    public Optional<List<Optional<JournalLineRequestTrackingCategoriesItem>>> getTrackingCategories() {
        return trackingCategories;
    }

    @JsonProperty("contact")
    public Optional<String> getContact() {
        return contact;
    }

    /**
     * @return The line's description.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The journal line item's exchange rate.
     */
    @JsonProperty("exchange_rate")
    public Optional<String> getExchangeRate() {
        return exchangeRate;
    }

    @JsonProperty("integration_params")
    public Optional<Map<String, JsonNode>> getIntegrationParams() {
        return integrationParams;
    }

    @JsonProperty("linked_account_params")
    public Optional<Map<String, JsonNode>> getLinkedAccountParams() {
        return linkedAccountParams;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof JournalLineRequest && equalTo((JournalLineRequest) other);
    }

    private boolean equalTo(JournalLineRequest other) {
        return remoteId.equals(other.remoteId)
                && account.equals(other.account)
                && netAmount.equals(other.netAmount)
                && trackingCategory.equals(other.trackingCategory)
                && trackingCategories.equals(other.trackingCategories)
                && contact.equals(other.contact)
                && description.equals(other.description)
                && exchangeRate.equals(other.exchangeRate)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.remoteId,
                this.account,
                this.netAmount,
                this.trackingCategory,
                this.trackingCategories,
                this.contact,
                this.description,
                this.exchangeRate,
                this.integrationParams,
                this.linkedAccountParams);
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
        private Optional<String> remoteId = Optional.empty();

        private Optional<JournalLineRequestAccount> account = Optional.empty();

        private Optional<Double> netAmount = Optional.empty();

        private Optional<JournalLineRequestTrackingCategory> trackingCategory = Optional.empty();

        private Optional<List<Optional<JournalLineRequestTrackingCategoriesItem>>> trackingCategories =
                Optional.empty();

        private Optional<String> contact = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> exchangeRate = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        private Builder() {}

        public Builder from(JournalLineRequest other) {
            remoteId(other.getRemoteId());
            account(other.getAccount());
            netAmount(other.getNetAmount());
            trackingCategory(other.getTrackingCategory());
            trackingCategories(other.getTrackingCategories());
            contact(other.getContact());
            description(other.getDescription());
            exchangeRate(other.getExchangeRate());
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
            this.remoteId = Optional.of(remoteId);
            return this;
        }

        @JsonSetter(value = "account", nulls = Nulls.SKIP)
        public Builder account(Optional<JournalLineRequestAccount> account) {
            this.account = account;
            return this;
        }

        public Builder account(JournalLineRequestAccount account) {
            this.account = Optional.of(account);
            return this;
        }

        @JsonSetter(value = "net_amount", nulls = Nulls.SKIP)
        public Builder netAmount(Optional<Double> netAmount) {
            this.netAmount = netAmount;
            return this;
        }

        public Builder netAmount(Double netAmount) {
            this.netAmount = Optional.of(netAmount);
            return this;
        }

        @JsonSetter(value = "tracking_category", nulls = Nulls.SKIP)
        public Builder trackingCategory(Optional<JournalLineRequestTrackingCategory> trackingCategory) {
            this.trackingCategory = trackingCategory;
            return this;
        }

        public Builder trackingCategory(JournalLineRequestTrackingCategory trackingCategory) {
            this.trackingCategory = Optional.of(trackingCategory);
            return this;
        }

        @JsonSetter(value = "tracking_categories", nulls = Nulls.SKIP)
        public Builder trackingCategories(
                Optional<List<Optional<JournalLineRequestTrackingCategoriesItem>>> trackingCategories) {
            this.trackingCategories = trackingCategories;
            return this;
        }

        public Builder trackingCategories(List<Optional<JournalLineRequestTrackingCategoriesItem>> trackingCategories) {
            this.trackingCategories = Optional.of(trackingCategories);
            return this;
        }

        @JsonSetter(value = "contact", nulls = Nulls.SKIP)
        public Builder contact(Optional<String> contact) {
            this.contact = contact;
            return this;
        }

        public Builder contact(String contact) {
            this.contact = Optional.of(contact);
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "exchange_rate", nulls = Nulls.SKIP)
        public Builder exchangeRate(Optional<String> exchangeRate) {
            this.exchangeRate = exchangeRate;
            return this;
        }

        public Builder exchangeRate(String exchangeRate) {
            this.exchangeRate = Optional.of(exchangeRate);
            return this;
        }

        @JsonSetter(value = "integration_params", nulls = Nulls.SKIP)
        public Builder integrationParams(Optional<Map<String, JsonNode>> integrationParams) {
            this.integrationParams = integrationParams;
            return this;
        }

        public Builder integrationParams(Map<String, JsonNode> integrationParams) {
            this.integrationParams = Optional.of(integrationParams);
            return this;
        }

        @JsonSetter(value = "linked_account_params", nulls = Nulls.SKIP)
        public Builder linkedAccountParams(Optional<Map<String, JsonNode>> linkedAccountParams) {
            this.linkedAccountParams = linkedAccountParams;
            return this;
        }

        public Builder linkedAccountParams(Map<String, JsonNode> linkedAccountParams) {
            this.linkedAccountParams = Optional.of(linkedAccountParams);
            return this;
        }

        public JournalLineRequest build() {
            return new JournalLineRequest(
                    remoteId,
                    account,
                    netAmount,
                    trackingCategory,
                    trackingCategories,
                    contact,
                    description,
                    exchangeRate,
                    integrationParams,
                    linkedAccountParams);
        }
    }
}

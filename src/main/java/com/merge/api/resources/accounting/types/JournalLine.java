package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = JournalLine.Builder.class)
public final class JournalLine {
    private final Optional<String> remoteId;

    private final Optional<JournalLineAccount> account;

    private final Optional<Double> netAmount;

    private final Optional<JournalLineTrackingCategory> trackingCategory;

    private final Optional<List<Optional<JournalLineTrackingCategoriesItem>>> trackingCategories;

    private final Optional<String> contact;

    private final Optional<String> description;

    private final Optional<String> exchangeRate;

    private final Optional<OffsetDateTime> modifiedAt;

    private JournalLine(
            Optional<String> remoteId,
            Optional<JournalLineAccount> account,
            Optional<Double> netAmount,
            Optional<JournalLineTrackingCategory> trackingCategory,
            Optional<List<Optional<JournalLineTrackingCategoriesItem>>> trackingCategories,
            Optional<String> contact,
            Optional<String> description,
            Optional<String> exchangeRate,
            Optional<OffsetDateTime> modifiedAt) {
        this.remoteId = remoteId;
        this.account = account;
        this.netAmount = netAmount;
        this.trackingCategory = trackingCategory;
        this.trackingCategories = trackingCategories;
        this.contact = contact;
        this.description = description;
        this.exchangeRate = exchangeRate;
        this.modifiedAt = modifiedAt;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
    }

    @JsonProperty("account")
    public Optional<JournalLineAccount> getAccount() {
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
    public Optional<JournalLineTrackingCategory> getTrackingCategory() {
        return trackingCategory;
    }

    @JsonProperty("tracking_categories")
    public Optional<List<Optional<JournalLineTrackingCategoriesItem>>> getTrackingCategories() {
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
        return other instanceof JournalLine && equalTo((JournalLine) other);
    }

    private boolean equalTo(JournalLine other) {
        return remoteId.equals(other.remoteId)
                && account.equals(other.account)
                && netAmount.equals(other.netAmount)
                && trackingCategory.equals(other.trackingCategory)
                && trackingCategories.equals(other.trackingCategories)
                && contact.equals(other.contact)
                && description.equals(other.description)
                && exchangeRate.equals(other.exchangeRate)
                && modifiedAt.equals(other.modifiedAt);
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
                this.modifiedAt);
    }

    @Override
    public String toString() {
        return "JournalLine{" + "remoteId: " + remoteId + ", account: " + account + ", netAmount: " + netAmount
                + ", trackingCategory: " + trackingCategory + ", trackingCategories: " + trackingCategories
                + ", contact: " + contact + ", description: " + description + ", exchangeRate: " + exchangeRate
                + ", modifiedAt: " + modifiedAt + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> remoteId = Optional.empty();

        private Optional<JournalLineAccount> account = Optional.empty();

        private Optional<Double> netAmount = Optional.empty();

        private Optional<JournalLineTrackingCategory> trackingCategory = Optional.empty();

        private Optional<List<Optional<JournalLineTrackingCategoriesItem>>> trackingCategories = Optional.empty();

        private Optional<String> contact = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> exchangeRate = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(JournalLine other) {
            remoteId(other.getRemoteId());
            account(other.getAccount());
            netAmount(other.getNetAmount());
            trackingCategory(other.getTrackingCategory());
            trackingCategories(other.getTrackingCategories());
            contact(other.getContact());
            description(other.getDescription());
            exchangeRate(other.getExchangeRate());
            modifiedAt(other.getModifiedAt());
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
        public Builder account(Optional<JournalLineAccount> account) {
            this.account = account;
            return this;
        }

        public Builder account(JournalLineAccount account) {
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
        public Builder trackingCategory(Optional<JournalLineTrackingCategory> trackingCategory) {
            this.trackingCategory = trackingCategory;
            return this;
        }

        public Builder trackingCategory(JournalLineTrackingCategory trackingCategory) {
            this.trackingCategory = Optional.of(trackingCategory);
            return this;
        }

        @JsonSetter(value = "tracking_categories", nulls = Nulls.SKIP)
        public Builder trackingCategories(
                Optional<List<Optional<JournalLineTrackingCategoriesItem>>> trackingCategories) {
            this.trackingCategories = trackingCategories;
            return this;
        }

        public Builder trackingCategories(List<Optional<JournalLineTrackingCategoriesItem>> trackingCategories) {
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

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.of(modifiedAt);
            return this;
        }

        public JournalLine build() {
            return new JournalLine(
                    remoteId,
                    account,
                    netAmount,
                    trackingCategory,
                    trackingCategories,
                    contact,
                    description,
                    exchangeRate,
                    modifiedAt);
        }
    }
}

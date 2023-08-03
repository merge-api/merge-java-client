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
@JsonDeserialize(builder = ExpenseLine.Builder.class)
public final class ExpenseLine {
    private final Optional<String> remoteId;

    private final Optional<String> item;

    private final Optional<Double> netAmount;

    private final Optional<String> trackingCategory;

    private final Optional<List<Optional<String>>> trackingCategories;

    private final Optional<String> company;

    private final Optional<String> account;

    private final Optional<String> contact;

    private final Optional<String> description;

    private final Optional<String> exchangeRate;

    private final Optional<OffsetDateTime> modifiedAt;

    private ExpenseLine(
            Optional<String> remoteId,
            Optional<String> item,
            Optional<Double> netAmount,
            Optional<String> trackingCategory,
            Optional<List<Optional<String>>> trackingCategories,
            Optional<String> company,
            Optional<String> account,
            Optional<String> contact,
            Optional<String> description,
            Optional<String> exchangeRate,
            Optional<OffsetDateTime> modifiedAt) {
        this.remoteId = remoteId;
        this.item = item;
        this.netAmount = netAmount;
        this.trackingCategory = trackingCategory;
        this.trackingCategories = trackingCategories;
        this.company = company;
        this.account = account;
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

    /**
     * @return The line's item.
     */
    @JsonProperty("item")
    public Optional<String> getItem() {
        return item;
    }

    /**
     * @return The line's net amount.
     */
    @JsonProperty("net_amount")
    public Optional<Double> getNetAmount() {
        return netAmount;
    }

    @JsonProperty("tracking_category")
    public Optional<String> getTrackingCategory() {
        return trackingCategory;
    }

    @JsonProperty("tracking_categories")
    public Optional<List<Optional<String>>> getTrackingCategories() {
        return trackingCategories;
    }

    /**
     * @return The company the line belongs to.
     */
    @JsonProperty("company")
    public Optional<String> getCompany() {
        return company;
    }

    /**
     * @return The expense's payment account.
     */
    @JsonProperty("account")
    public Optional<String> getAccount() {
        return account;
    }

    /**
     * @return The expense's contact.
     */
    @JsonProperty("contact")
    public Optional<String> getContact() {
        return contact;
    }

    /**
     * @return The description of the item that was purchased by the company.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The expense line item's exchange rate.
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
        return other instanceof ExpenseLine && equalTo((ExpenseLine) other);
    }

    private boolean equalTo(ExpenseLine other) {
        return remoteId.equals(other.remoteId)
                && item.equals(other.item)
                && netAmount.equals(other.netAmount)
                && trackingCategory.equals(other.trackingCategory)
                && trackingCategories.equals(other.trackingCategories)
                && company.equals(other.company)
                && account.equals(other.account)
                && contact.equals(other.contact)
                && description.equals(other.description)
                && exchangeRate.equals(other.exchangeRate)
                && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.remoteId,
                this.item,
                this.netAmount,
                this.trackingCategory,
                this.trackingCategories,
                this.company,
                this.account,
                this.contact,
                this.description,
                this.exchangeRate,
                this.modifiedAt);
    }

    @Override
    public String toString() {
        return "ExpenseLine{" + "remoteId: " + remoteId + ", item: " + item + ", netAmount: " + netAmount
                + ", trackingCategory: " + trackingCategory + ", trackingCategories: " + trackingCategories
                + ", company: " + company + ", account: " + account + ", contact: " + contact + ", description: "
                + description + ", exchangeRate: " + exchangeRate + ", modifiedAt: " + modifiedAt + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> remoteId = Optional.empty();

        private Optional<String> item = Optional.empty();

        private Optional<Double> netAmount = Optional.empty();

        private Optional<String> trackingCategory = Optional.empty();

        private Optional<List<Optional<String>>> trackingCategories = Optional.empty();

        private Optional<String> company = Optional.empty();

        private Optional<String> account = Optional.empty();

        private Optional<String> contact = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> exchangeRate = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(ExpenseLine other) {
            remoteId(other.getRemoteId());
            item(other.getItem());
            netAmount(other.getNetAmount());
            trackingCategory(other.getTrackingCategory());
            trackingCategories(other.getTrackingCategories());
            company(other.getCompany());
            account(other.getAccount());
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

        @JsonSetter(value = "item", nulls = Nulls.SKIP)
        public Builder item(Optional<String> item) {
            this.item = item;
            return this;
        }

        public Builder item(String item) {
            this.item = Optional.of(item);
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
        public Builder trackingCategory(Optional<String> trackingCategory) {
            this.trackingCategory = trackingCategory;
            return this;
        }

        public Builder trackingCategory(String trackingCategory) {
            this.trackingCategory = Optional.of(trackingCategory);
            return this;
        }

        @JsonSetter(value = "tracking_categories", nulls = Nulls.SKIP)
        public Builder trackingCategories(Optional<List<Optional<String>>> trackingCategories) {
            this.trackingCategories = trackingCategories;
            return this;
        }

        public Builder trackingCategories(List<Optional<String>> trackingCategories) {
            this.trackingCategories = Optional.of(trackingCategories);
            return this;
        }

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<String> company) {
            this.company = company;
            return this;
        }

        public Builder company(String company) {
            this.company = Optional.of(company);
            return this;
        }

        @JsonSetter(value = "account", nulls = Nulls.SKIP)
        public Builder account(Optional<String> account) {
            this.account = account;
            return this;
        }

        public Builder account(String account) {
            this.account = Optional.of(account);
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

        public ExpenseLine build() {
            return new ExpenseLine(
                    remoteId,
                    item,
                    netAmount,
                    trackingCategory,
                    trackingCategories,
                    company,
                    account,
                    contact,
                    description,
                    exchangeRate,
                    modifiedAt);
        }
    }
}

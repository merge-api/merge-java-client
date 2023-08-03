package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreditNoteLineItem.Builder.class)
public final class CreditNoteLineItem {
    private final Optional<String> item;

    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<String> quantity;

    private final Optional<String> memo;

    private final Optional<String> unitPrice;

    private final Optional<String> taxRate;

    private final Optional<String> totalLineAmount;

    private final Optional<String> trackingCategory;

    private final List<String> trackingCategories;

    private final Optional<String> account;

    private final Optional<String> company;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> modifiedAt;

    private CreditNoteLineItem(
            Optional<String> item,
            Optional<String> name,
            Optional<String> description,
            Optional<String> quantity,
            Optional<String> memo,
            Optional<String> unitPrice,
            Optional<String> taxRate,
            Optional<String> totalLineAmount,
            Optional<String> trackingCategory,
            List<String> trackingCategories,
            Optional<String> account,
            Optional<String> company,
            Optional<String> remoteId,
            Optional<OffsetDateTime> modifiedAt) {
        this.item = item;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.memo = memo;
        this.unitPrice = unitPrice;
        this.taxRate = taxRate;
        this.totalLineAmount = totalLineAmount;
        this.trackingCategory = trackingCategory;
        this.trackingCategories = trackingCategories;
        this.account = account;
        this.company = company;
        this.remoteId = remoteId;
        this.modifiedAt = modifiedAt;
    }

    @JsonProperty("item")
    public Optional<String> getItem() {
        return item;
    }

    /**
     * @return The credit note line item's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The description of the item that is owed.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The credit note line item's quantity.
     */
    @JsonProperty("quantity")
    public Optional<String> getQuantity() {
        return quantity;
    }

    /**
     * @return The credit note line item's memo.
     */
    @JsonProperty("memo")
    public Optional<String> getMemo() {
        return memo;
    }

    /**
     * @return The credit note line item's unit price.
     */
    @JsonProperty("unit_price")
    public Optional<String> getUnitPrice() {
        return unitPrice;
    }

    /**
     * @return The credit note line item's tax rate.
     */
    @JsonProperty("tax_rate")
    public Optional<String> getTaxRate() {
        return taxRate;
    }

    /**
     * @return The credit note line item's total.
     */
    @JsonProperty("total_line_amount")
    public Optional<String> getTotalLineAmount() {
        return totalLineAmount;
    }

    /**
     * @return The credit note line item's associated tracking category.
     */
    @JsonProperty("tracking_category")
    public Optional<String> getTrackingCategory() {
        return trackingCategory;
    }

    /**
     * @return The credit note line item's associated tracking categories.
     */
    @JsonProperty("tracking_categories")
    public List<String> getTrackingCategories() {
        return trackingCategories;
    }

    /**
     * @return The credit note line item's account.
     */
    @JsonProperty("account")
    public Optional<String> getAccount() {
        return account;
    }

    /**
     * @return The company the credit note belongs to.
     */
    @JsonProperty("company")
    public Optional<String> getCompany() {
        return company;
    }

    /**
     * @return The third-party API ID of the matching object.
     */
    @JsonProperty("remote_id")
    public Optional<String> getRemoteId() {
        return remoteId;
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
        return other instanceof CreditNoteLineItem && equalTo((CreditNoteLineItem) other);
    }

    private boolean equalTo(CreditNoteLineItem other) {
        return item.equals(other.item)
                && name.equals(other.name)
                && description.equals(other.description)
                && quantity.equals(other.quantity)
                && memo.equals(other.memo)
                && unitPrice.equals(other.unitPrice)
                && taxRate.equals(other.taxRate)
                && totalLineAmount.equals(other.totalLineAmount)
                && trackingCategory.equals(other.trackingCategory)
                && trackingCategories.equals(other.trackingCategories)
                && account.equals(other.account)
                && company.equals(other.company)
                && remoteId.equals(other.remoteId)
                && modifiedAt.equals(other.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.item,
                this.name,
                this.description,
                this.quantity,
                this.memo,
                this.unitPrice,
                this.taxRate,
                this.totalLineAmount,
                this.trackingCategory,
                this.trackingCategories,
                this.account,
                this.company,
                this.remoteId,
                this.modifiedAt);
    }

    @Override
    public String toString() {
        return "CreditNoteLineItem{" + "item: " + item + ", name: " + name + ", description: " + description
                + ", quantity: " + quantity + ", memo: " + memo + ", unitPrice: " + unitPrice + ", taxRate: " + taxRate
                + ", totalLineAmount: " + totalLineAmount + ", trackingCategory: " + trackingCategory
                + ", trackingCategories: " + trackingCategories + ", account: " + account + ", company: " + company
                + ", remoteId: " + remoteId + ", modifiedAt: " + modifiedAt + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> item = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> quantity = Optional.empty();

        private Optional<String> memo = Optional.empty();

        private Optional<String> unitPrice = Optional.empty();

        private Optional<String> taxRate = Optional.empty();

        private Optional<String> totalLineAmount = Optional.empty();

        private Optional<String> trackingCategory = Optional.empty();

        private List<String> trackingCategories = new ArrayList<>();

        private Optional<String> account = Optional.empty();

        private Optional<String> company = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Builder() {}

        public Builder from(CreditNoteLineItem other) {
            item(other.getItem());
            name(other.getName());
            description(other.getDescription());
            quantity(other.getQuantity());
            memo(other.getMemo());
            unitPrice(other.getUnitPrice());
            taxRate(other.getTaxRate());
            totalLineAmount(other.getTotalLineAmount());
            trackingCategory(other.getTrackingCategory());
            trackingCategories(other.getTrackingCategories());
            account(other.getAccount());
            company(other.getCompany());
            remoteId(other.getRemoteId());
            modifiedAt(other.getModifiedAt());
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
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

        @JsonSetter(value = "quantity", nulls = Nulls.SKIP)
        public Builder quantity(Optional<String> quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder quantity(String quantity) {
            this.quantity = Optional.of(quantity);
            return this;
        }

        @JsonSetter(value = "memo", nulls = Nulls.SKIP)
        public Builder memo(Optional<String> memo) {
            this.memo = memo;
            return this;
        }

        public Builder memo(String memo) {
            this.memo = Optional.of(memo);
            return this;
        }

        @JsonSetter(value = "unit_price", nulls = Nulls.SKIP)
        public Builder unitPrice(Optional<String> unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder unitPrice(String unitPrice) {
            this.unitPrice = Optional.of(unitPrice);
            return this;
        }

        @JsonSetter(value = "tax_rate", nulls = Nulls.SKIP)
        public Builder taxRate(Optional<String> taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        public Builder taxRate(String taxRate) {
            this.taxRate = Optional.of(taxRate);
            return this;
        }

        @JsonSetter(value = "total_line_amount", nulls = Nulls.SKIP)
        public Builder totalLineAmount(Optional<String> totalLineAmount) {
            this.totalLineAmount = totalLineAmount;
            return this;
        }

        public Builder totalLineAmount(String totalLineAmount) {
            this.totalLineAmount = Optional.of(totalLineAmount);
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
        public Builder trackingCategories(List<String> trackingCategories) {
            this.trackingCategories.clear();
            this.trackingCategories.addAll(trackingCategories);
            return this;
        }

        public Builder addTrackingCategories(String trackingCategories) {
            this.trackingCategories.add(trackingCategories);
            return this;
        }

        public Builder addAllTrackingCategories(List<String> trackingCategories) {
            this.trackingCategories.addAll(trackingCategories);
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

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<String> company) {
            this.company = company;
            return this;
        }

        public Builder company(String company) {
            this.company = Optional.of(company);
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

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.of(modifiedAt);
            return this;
        }

        public CreditNoteLineItem build() {
            return new CreditNoteLineItem(
                    item,
                    name,
                    description,
                    quantity,
                    memo,
                    unitPrice,
                    taxRate,
                    totalLineAmount,
                    trackingCategory,
                    trackingCategories,
                    account,
                    company,
                    remoteId,
                    modifiedAt);
        }
    }
}

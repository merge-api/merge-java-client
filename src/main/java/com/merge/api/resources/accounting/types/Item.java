package com.merge.api.resources.accounting.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Item.Builder.class)
public final class Item {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<String> name;

    private final Optional<ItemStatus> status;

    private final Optional<Double> unitPrice;

    private final Optional<Double> purchasePrice;

    private final Optional<ItemPurchaseAccount> purchaseAccount;

    private final Optional<ItemSalesAccount> salesAccount;

    private final Optional<ItemCompany> company;

    private final Optional<OffsetDateTime> remoteUpdatedAt;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<Map<String, JsonNode>> fieldMappings;

    private final Optional<List<RemoteData>> remoteData;

    private Item(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<String> name,
            Optional<ItemStatus> status,
            Optional<Double> unitPrice,
            Optional<Double> purchasePrice,
            Optional<ItemPurchaseAccount> purchaseAccount,
            Optional<ItemSalesAccount> salesAccount,
            Optional<ItemCompany> company,
            Optional<OffsetDateTime> remoteUpdatedAt,
            Optional<Boolean> remoteWasDeleted,
            Optional<OffsetDateTime> modifiedAt,
            Optional<Map<String, JsonNode>> fieldMappings,
            Optional<List<RemoteData>> remoteData) {
        this.id = id;
        this.remoteId = remoteId;
        this.name = name;
        this.status = status;
        this.unitPrice = unitPrice;
        this.purchasePrice = purchasePrice;
        this.purchaseAccount = purchaseAccount;
        this.salesAccount = salesAccount;
        this.company = company;
        this.remoteUpdatedAt = remoteUpdatedAt;
        this.remoteWasDeleted = remoteWasDeleted;
        this.modifiedAt = modifiedAt;
        this.fieldMappings = fieldMappings;
        this.remoteData = remoteData;
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
     * @return The item's name.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return The item's status.
     * <ul>
     * <li><code>ACTIVE</code> - ACTIVE</li>
     * <li><code>ARCHIVED</code> - ARCHIVED</li>
     * </ul>
     */
    @JsonProperty("status")
    public Optional<ItemStatus> getStatus() {
        return status;
    }

    /**
     * @return The item's unit price.
     */
    @JsonProperty("unit_price")
    public Optional<Double> getUnitPrice() {
        return unitPrice;
    }

    /**
     * @return The price at which the item is purchased from a vendor.
     */
    @JsonProperty("purchase_price")
    public Optional<Double> getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * @return References the default account used to record a purchase of the item.
     */
    @JsonProperty("purchase_account")
    public Optional<ItemPurchaseAccount> getPurchaseAccount() {
        return purchaseAccount;
    }

    /**
     * @return References the default account used to record a sale.
     */
    @JsonProperty("sales_account")
    public Optional<ItemSalesAccount> getSalesAccount() {
        return salesAccount;
    }

    /**
     * @return The company the item belongs to.
     */
    @JsonProperty("company")
    public Optional<ItemCompany> getCompany() {
        return company;
    }

    /**
     * @return When the third party's item note was updated.
     */
    @JsonProperty("remote_updated_at")
    public Optional<OffsetDateTime> getRemoteUpdatedAt() {
        return remoteUpdatedAt;
    }

    /**
     * @return Indicates whether or not this object has been deleted by third party webhooks.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    /**
     * @return This is the datetime that this object was last updated by Merge
     */
    @JsonProperty("modified_at")
    public Optional<OffsetDateTime> getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("field_mappings")
    public Optional<Map<String, JsonNode>> getFieldMappings() {
        return fieldMappings;
    }

    @JsonProperty("remote_data")
    public Optional<List<RemoteData>> getRemoteData() {
        return remoteData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Item && equalTo((Item) other);
    }

    private boolean equalTo(Item other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && name.equals(other.name)
                && status.equals(other.status)
                && unitPrice.equals(other.unitPrice)
                && purchasePrice.equals(other.purchasePrice)
                && purchaseAccount.equals(other.purchaseAccount)
                && salesAccount.equals(other.salesAccount)
                && company.equals(other.company)
                && remoteUpdatedAt.equals(other.remoteUpdatedAt)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && modifiedAt.equals(other.modifiedAt)
                && fieldMappings.equals(other.fieldMappings)
                && remoteData.equals(other.remoteData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.name,
                this.status,
                this.unitPrice,
                this.purchasePrice,
                this.purchaseAccount,
                this.salesAccount,
                this.company,
                this.remoteUpdatedAt,
                this.remoteWasDeleted,
                this.modifiedAt,
                this.fieldMappings,
                this.remoteData);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<ItemStatus> status = Optional.empty();

        private Optional<Double> unitPrice = Optional.empty();

        private Optional<Double> purchasePrice = Optional.empty();

        private Optional<ItemPurchaseAccount> purchaseAccount = Optional.empty();

        private Optional<ItemSalesAccount> salesAccount = Optional.empty();

        private Optional<ItemCompany> company = Optional.empty();

        private Optional<OffsetDateTime> remoteUpdatedAt = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<Map<String, JsonNode>> fieldMappings = Optional.empty();

        private Optional<List<RemoteData>> remoteData = Optional.empty();

        private Builder() {}

        public Builder from(Item other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            name(other.getName());
            status(other.getStatus());
            unitPrice(other.getUnitPrice());
            purchasePrice(other.getPurchasePrice());
            purchaseAccount(other.getPurchaseAccount());
            salesAccount(other.getSalesAccount());
            company(other.getCompany());
            remoteUpdatedAt(other.getRemoteUpdatedAt());
            remoteWasDeleted(other.getRemoteWasDeleted());
            modifiedAt(other.getModifiedAt());
            fieldMappings(other.getFieldMappings());
            remoteData(other.getRemoteData());
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<ItemStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(ItemStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "unit_price", nulls = Nulls.SKIP)
        public Builder unitPrice(Optional<Double> unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder unitPrice(Double unitPrice) {
            this.unitPrice = Optional.of(unitPrice);
            return this;
        }

        @JsonSetter(value = "purchase_price", nulls = Nulls.SKIP)
        public Builder purchasePrice(Optional<Double> purchasePrice) {
            this.purchasePrice = purchasePrice;
            return this;
        }

        public Builder purchasePrice(Double purchasePrice) {
            this.purchasePrice = Optional.of(purchasePrice);
            return this;
        }

        @JsonSetter(value = "purchase_account", nulls = Nulls.SKIP)
        public Builder purchaseAccount(Optional<ItemPurchaseAccount> purchaseAccount) {
            this.purchaseAccount = purchaseAccount;
            return this;
        }

        public Builder purchaseAccount(ItemPurchaseAccount purchaseAccount) {
            this.purchaseAccount = Optional.of(purchaseAccount);
            return this;
        }

        @JsonSetter(value = "sales_account", nulls = Nulls.SKIP)
        public Builder salesAccount(Optional<ItemSalesAccount> salesAccount) {
            this.salesAccount = salesAccount;
            return this;
        }

        public Builder salesAccount(ItemSalesAccount salesAccount) {
            this.salesAccount = Optional.of(salesAccount);
            return this;
        }

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<ItemCompany> company) {
            this.company = company;
            return this;
        }

        public Builder company(ItemCompany company) {
            this.company = Optional.of(company);
            return this;
        }

        @JsonSetter(value = "remote_updated_at", nulls = Nulls.SKIP)
        public Builder remoteUpdatedAt(Optional<OffsetDateTime> remoteUpdatedAt) {
            this.remoteUpdatedAt = remoteUpdatedAt;
            return this;
        }

        public Builder remoteUpdatedAt(OffsetDateTime remoteUpdatedAt) {
            this.remoteUpdatedAt = Optional.of(remoteUpdatedAt);
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

        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.of(modifiedAt);
            return this;
        }

        @JsonSetter(value = "field_mappings", nulls = Nulls.SKIP)
        public Builder fieldMappings(Optional<Map<String, JsonNode>> fieldMappings) {
            this.fieldMappings = fieldMappings;
            return this;
        }

        public Builder fieldMappings(Map<String, JsonNode> fieldMappings) {
            this.fieldMappings = Optional.of(fieldMappings);
            return this;
        }

        @JsonSetter(value = "remote_data", nulls = Nulls.SKIP)
        public Builder remoteData(Optional<List<RemoteData>> remoteData) {
            this.remoteData = remoteData;
            return this;
        }

        public Builder remoteData(List<RemoteData> remoteData) {
            this.remoteData = Optional.of(remoteData);
            return this;
        }

        public Item build() {
            return new Item(
                    id,
                    remoteId,
                    name,
                    status,
                    unitPrice,
                    purchasePrice,
                    purchaseAccount,
                    salesAccount,
                    company,
                    remoteUpdatedAt,
                    remoteWasDeleted,
                    modifiedAt,
                    fieldMappings,
                    remoteData);
        }
    }
}

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreditNoteLineItemRequest.Builder.class)
public final class CreditNoteLineItemRequest {
    private final Optional<String> remoteId;

    private final Optional<CreditNoteLineItemRequestItem> item;

    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<String> quantity;

    private final Optional<String> memo;

    private final Optional<String> unitPrice;

    private final Optional<String> taxRate;

    private final Optional<String> totalLineAmount;

    private final Optional<String> trackingCategory;

    private final Optional<List<Optional<String>>> trackingCategories;

    private final Optional<String> account;

    private final Optional<CreditNoteLineItemRequestCompany> company;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Map<String, Object> additionalProperties;

    private CreditNoteLineItemRequest(
            Optional<String> remoteId,
            Optional<CreditNoteLineItemRequestItem> item,
            Optional<String> name,
            Optional<String> description,
            Optional<String> quantity,
            Optional<String> memo,
            Optional<String> unitPrice,
            Optional<String> taxRate,
            Optional<String> totalLineAmount,
            Optional<String> trackingCategory,
            Optional<List<Optional<String>>> trackingCategories,
            Optional<String> account,
            Optional<CreditNoteLineItemRequestCompany> company,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Map<String, Object> additionalProperties) {
        this.remoteId = remoteId;
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

    @JsonProperty("item")
    public Optional<CreditNoteLineItemRequestItem> getItem() {
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
     * @return The tax rate that applies to this line item.
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
    public Optional<List<Optional<String>>> getTrackingCategories() {
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
    public Optional<CreditNoteLineItemRequestCompany> getCompany() {
        return company;
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
        return other instanceof CreditNoteLineItemRequest && equalTo((CreditNoteLineItemRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreditNoteLineItemRequest other) {
        return remoteId.equals(other.remoteId)
                && item.equals(other.item)
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
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.remoteId,
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

        private Optional<CreditNoteLineItemRequestItem> item = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> quantity = Optional.empty();

        private Optional<String> memo = Optional.empty();

        private Optional<String> unitPrice = Optional.empty();

        private Optional<String> taxRate = Optional.empty();

        private Optional<String> totalLineAmount = Optional.empty();

        private Optional<String> trackingCategory = Optional.empty();

        private Optional<List<Optional<String>>> trackingCategories = Optional.empty();

        private Optional<String> account = Optional.empty();

        private Optional<CreditNoteLineItemRequestCompany> company = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreditNoteLineItemRequest other) {
            remoteId(other.getRemoteId());
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

        @JsonSetter(value = "item", nulls = Nulls.SKIP)
        public Builder item(Optional<CreditNoteLineItemRequestItem> item) {
            this.item = item;
            return this;
        }

        public Builder item(CreditNoteLineItemRequestItem item) {
            this.item = Optional.ofNullable(item);
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        @JsonSetter(value = "quantity", nulls = Nulls.SKIP)
        public Builder quantity(Optional<String> quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder quantity(String quantity) {
            this.quantity = Optional.ofNullable(quantity);
            return this;
        }

        @JsonSetter(value = "memo", nulls = Nulls.SKIP)
        public Builder memo(Optional<String> memo) {
            this.memo = memo;
            return this;
        }

        public Builder memo(String memo) {
            this.memo = Optional.ofNullable(memo);
            return this;
        }

        @JsonSetter(value = "unit_price", nulls = Nulls.SKIP)
        public Builder unitPrice(Optional<String> unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder unitPrice(String unitPrice) {
            this.unitPrice = Optional.ofNullable(unitPrice);
            return this;
        }

        @JsonSetter(value = "tax_rate", nulls = Nulls.SKIP)
        public Builder taxRate(Optional<String> taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        public Builder taxRate(String taxRate) {
            this.taxRate = Optional.ofNullable(taxRate);
            return this;
        }

        @JsonSetter(value = "total_line_amount", nulls = Nulls.SKIP)
        public Builder totalLineAmount(Optional<String> totalLineAmount) {
            this.totalLineAmount = totalLineAmount;
            return this;
        }

        public Builder totalLineAmount(String totalLineAmount) {
            this.totalLineAmount = Optional.ofNullable(totalLineAmount);
            return this;
        }

        @JsonSetter(value = "tracking_category", nulls = Nulls.SKIP)
        public Builder trackingCategory(Optional<String> trackingCategory) {
            this.trackingCategory = trackingCategory;
            return this;
        }

        public Builder trackingCategory(String trackingCategory) {
            this.trackingCategory = Optional.ofNullable(trackingCategory);
            return this;
        }

        @JsonSetter(value = "tracking_categories", nulls = Nulls.SKIP)
        public Builder trackingCategories(Optional<List<Optional<String>>> trackingCategories) {
            this.trackingCategories = trackingCategories;
            return this;
        }

        public Builder trackingCategories(List<Optional<String>> trackingCategories) {
            this.trackingCategories = Optional.ofNullable(trackingCategories);
            return this;
        }

        @JsonSetter(value = "account", nulls = Nulls.SKIP)
        public Builder account(Optional<String> account) {
            this.account = account;
            return this;
        }

        public Builder account(String account) {
            this.account = Optional.ofNullable(account);
            return this;
        }

        @JsonSetter(value = "company", nulls = Nulls.SKIP)
        public Builder company(Optional<CreditNoteLineItemRequestCompany> company) {
            this.company = company;
            return this;
        }

        public Builder company(CreditNoteLineItemRequestCompany company) {
            this.company = Optional.ofNullable(company);
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

        public CreditNoteLineItemRequest build() {
            return new CreditNoteLineItemRequest(
                    remoteId,
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
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties);
        }
    }
}

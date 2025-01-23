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
@JsonDeserialize(builder = BankFeedTransactionRequestRequest.Builder.class)
public final class BankFeedTransactionRequestRequest {
    private final Optional<BankFeedTransactionRequestRequestBankFeedAccount> bankFeedAccount;

    private final Optional<OffsetDateTime> transactionDate;

    private final Optional<OffsetDateTime> postedDate;

    private final Optional<Double> amount;

    private final Optional<String> description;

    private final Optional<String> transactionType;

    private final Optional<String> payee;

    private final Optional<BankFeedTransactionRequestRequestCreditOrDebit> creditOrDebit;

    private final Optional<String> sourceTransactionId;

    private final Optional<Map<String, JsonNode>> integrationParams;

    private final Optional<Map<String, JsonNode>> linkedAccountParams;

    private final Map<String, Object> additionalProperties;

    private BankFeedTransactionRequestRequest(
            Optional<BankFeedTransactionRequestRequestBankFeedAccount> bankFeedAccount,
            Optional<OffsetDateTime> transactionDate,
            Optional<OffsetDateTime> postedDate,
            Optional<Double> amount,
            Optional<String> description,
            Optional<String> transactionType,
            Optional<String> payee,
            Optional<BankFeedTransactionRequestRequestCreditOrDebit> creditOrDebit,
            Optional<String> sourceTransactionId,
            Optional<Map<String, JsonNode>> integrationParams,
            Optional<Map<String, JsonNode>> linkedAccountParams,
            Map<String, Object> additionalProperties) {
        this.bankFeedAccount = bankFeedAccount;
        this.transactionDate = transactionDate;
        this.postedDate = postedDate;
        this.amount = amount;
        this.description = description;
        this.transactionType = transactionType;
        this.payee = payee;
        this.creditOrDebit = creditOrDebit;
        this.sourceTransactionId = sourceTransactionId;
        this.integrationParams = integrationParams;
        this.linkedAccountParams = linkedAccountParams;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The bank feed account associated with the transaction.
     */
    @JsonProperty("bank_feed_account")
    public Optional<BankFeedTransactionRequestRequestBankFeedAccount> getBankFeedAccount() {
        return bankFeedAccount;
    }

    /**
     * @return The date that the transaction occurred.
     */
    @JsonProperty("transaction_date")
    public Optional<OffsetDateTime> getTransactionDate() {
        return transactionDate;
    }

    /**
     * @return The date the transaction was posted to the bank account.
     */
    @JsonProperty("posted_date")
    public Optional<OffsetDateTime> getPostedDate() {
        return postedDate;
    }

    /**
     * @return The amount of the transaction.
     */
    @JsonProperty("amount")
    public Optional<Double> getAmount() {
        return amount;
    }

    /**
     * @return The description of the transaction.
     */
    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return The underlying type of the transaction.
     */
    @JsonProperty("transaction_type")
    public Optional<String> getTransactionType() {
        return transactionType;
    }

    /**
     * @return The person or merchant who initiated the transaction, or alternatively, to whom the transaction was paid.
     */
    @JsonProperty("payee")
    public Optional<String> getPayee() {
        return payee;
    }

    /**
     * @return If the transaction is of type debit or credit.
     * <ul>
     * <li><code>CREDIT</code> - CREDIT</li>
     * <li><code>DEBIT</code> - DEBIT</li>
     * </ul>
     */
    @JsonProperty("credit_or_debit")
    public Optional<BankFeedTransactionRequestRequestCreditOrDebit> getCreditOrDebit() {
        return creditOrDebit;
    }

    /**
     * @return The customer’s identifier for the transaction.
     */
    @JsonProperty("source_transaction_id")
    public Optional<String> getSourceTransactionId() {
        return sourceTransactionId;
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
        return other instanceof BankFeedTransactionRequestRequest && equalTo((BankFeedTransactionRequestRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BankFeedTransactionRequestRequest other) {
        return bankFeedAccount.equals(other.bankFeedAccount)
                && transactionDate.equals(other.transactionDate)
                && postedDate.equals(other.postedDate)
                && amount.equals(other.amount)
                && description.equals(other.description)
                && transactionType.equals(other.transactionType)
                && payee.equals(other.payee)
                && creditOrDebit.equals(other.creditOrDebit)
                && sourceTransactionId.equals(other.sourceTransactionId)
                && integrationParams.equals(other.integrationParams)
                && linkedAccountParams.equals(other.linkedAccountParams);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.bankFeedAccount,
                this.transactionDate,
                this.postedDate,
                this.amount,
                this.description,
                this.transactionType,
                this.payee,
                this.creditOrDebit,
                this.sourceTransactionId,
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
        private Optional<BankFeedTransactionRequestRequestBankFeedAccount> bankFeedAccount = Optional.empty();

        private Optional<OffsetDateTime> transactionDate = Optional.empty();

        private Optional<OffsetDateTime> postedDate = Optional.empty();

        private Optional<Double> amount = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> transactionType = Optional.empty();

        private Optional<String> payee = Optional.empty();

        private Optional<BankFeedTransactionRequestRequestCreditOrDebit> creditOrDebit = Optional.empty();

        private Optional<String> sourceTransactionId = Optional.empty();

        private Optional<Map<String, JsonNode>> integrationParams = Optional.empty();

        private Optional<Map<String, JsonNode>> linkedAccountParams = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BankFeedTransactionRequestRequest other) {
            bankFeedAccount(other.getBankFeedAccount());
            transactionDate(other.getTransactionDate());
            postedDate(other.getPostedDate());
            amount(other.getAmount());
            description(other.getDescription());
            transactionType(other.getTransactionType());
            payee(other.getPayee());
            creditOrDebit(other.getCreditOrDebit());
            sourceTransactionId(other.getSourceTransactionId());
            integrationParams(other.getIntegrationParams());
            linkedAccountParams(other.getLinkedAccountParams());
            return this;
        }

        @JsonSetter(value = "bank_feed_account", nulls = Nulls.SKIP)
        public Builder bankFeedAccount(Optional<BankFeedTransactionRequestRequestBankFeedAccount> bankFeedAccount) {
            this.bankFeedAccount = bankFeedAccount;
            return this;
        }

        public Builder bankFeedAccount(BankFeedTransactionRequestRequestBankFeedAccount bankFeedAccount) {
            this.bankFeedAccount = Optional.ofNullable(bankFeedAccount);
            return this;
        }

        @JsonSetter(value = "transaction_date", nulls = Nulls.SKIP)
        public Builder transactionDate(Optional<OffsetDateTime> transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public Builder transactionDate(OffsetDateTime transactionDate) {
            this.transactionDate = Optional.ofNullable(transactionDate);
            return this;
        }

        @JsonSetter(value = "posted_date", nulls = Nulls.SKIP)
        public Builder postedDate(Optional<OffsetDateTime> postedDate) {
            this.postedDate = postedDate;
            return this;
        }

        public Builder postedDate(OffsetDateTime postedDate) {
            this.postedDate = Optional.ofNullable(postedDate);
            return this;
        }

        @JsonSetter(value = "amount", nulls = Nulls.SKIP)
        public Builder amount(Optional<Double> amount) {
            this.amount = amount;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = Optional.ofNullable(amount);
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

        @JsonSetter(value = "transaction_type", nulls = Nulls.SKIP)
        public Builder transactionType(Optional<String> transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder transactionType(String transactionType) {
            this.transactionType = Optional.ofNullable(transactionType);
            return this;
        }

        @JsonSetter(value = "payee", nulls = Nulls.SKIP)
        public Builder payee(Optional<String> payee) {
            this.payee = payee;
            return this;
        }

        public Builder payee(String payee) {
            this.payee = Optional.ofNullable(payee);
            return this;
        }

        @JsonSetter(value = "credit_or_debit", nulls = Nulls.SKIP)
        public Builder creditOrDebit(Optional<BankFeedTransactionRequestRequestCreditOrDebit> creditOrDebit) {
            this.creditOrDebit = creditOrDebit;
            return this;
        }

        public Builder creditOrDebit(BankFeedTransactionRequestRequestCreditOrDebit creditOrDebit) {
            this.creditOrDebit = Optional.ofNullable(creditOrDebit);
            return this;
        }

        @JsonSetter(value = "source_transaction_id", nulls = Nulls.SKIP)
        public Builder sourceTransactionId(Optional<String> sourceTransactionId) {
            this.sourceTransactionId = sourceTransactionId;
            return this;
        }

        public Builder sourceTransactionId(String sourceTransactionId) {
            this.sourceTransactionId = Optional.ofNullable(sourceTransactionId);
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

        public BankFeedTransactionRequestRequest build() {
            return new BankFeedTransactionRequestRequest(
                    bankFeedAccount,
                    transactionDate,
                    postedDate,
                    amount,
                    description,
                    transactionType,
                    payee,
                    creditOrDebit,
                    sourceTransactionId,
                    integrationParams,
                    linkedAccountParams,
                    additionalProperties);
        }
    }
}

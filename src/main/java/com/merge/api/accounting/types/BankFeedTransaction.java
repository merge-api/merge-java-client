/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.accounting.types;

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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = BankFeedTransaction.Builder.class)
public final class BankFeedTransaction {
    private final Optional<String> id;

    private final Optional<String> remoteId;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> modifiedAt;

    private final Optional<BankFeedTransactionBankFeedAccount> bankFeedAccount;

    private final Optional<OffsetDateTime> transactionDate;

    private final Optional<OffsetDateTime> postedDate;

    private final Optional<Double> amount;

    private final Optional<String> description;

    private final Optional<String> transactionType;

    private final Optional<String> payee;

    private final Optional<BankFeedTransactionCreditOrDebit> creditOrDebit;

    private final Optional<String> sourceTransactionId;

    private final Optional<Boolean> remoteWasDeleted;

    private final Optional<Boolean> isProcessed;

    private final Map<String, Object> additionalProperties;

    private BankFeedTransaction(
            Optional<String> id,
            Optional<String> remoteId,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> modifiedAt,
            Optional<BankFeedTransactionBankFeedAccount> bankFeedAccount,
            Optional<OffsetDateTime> transactionDate,
            Optional<OffsetDateTime> postedDate,
            Optional<Double> amount,
            Optional<String> description,
            Optional<String> transactionType,
            Optional<String> payee,
            Optional<BankFeedTransactionCreditOrDebit> creditOrDebit,
            Optional<String> sourceTransactionId,
            Optional<Boolean> remoteWasDeleted,
            Optional<Boolean> isProcessed,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.remoteId = remoteId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.bankFeedAccount = bankFeedAccount;
        this.transactionDate = transactionDate;
        this.postedDate = postedDate;
        this.amount = amount;
        this.description = description;
        this.transactionType = transactionType;
        this.payee = payee;
        this.creditOrDebit = creditOrDebit;
        this.sourceTransactionId = sourceTransactionId;
        this.remoteWasDeleted = remoteWasDeleted;
        this.isProcessed = isProcessed;
        this.additionalProperties = additionalProperties;
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

    /**
     * @return The bank feed account associated with the transaction.
     */
    @JsonProperty("bank_feed_account")
    public Optional<BankFeedTransactionBankFeedAccount> getBankFeedAccount() {
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
    public Optional<BankFeedTransactionCreditOrDebit> getCreditOrDebit() {
        return creditOrDebit;
    }

    /**
     * @return The customer’s identifier for the transaction.
     */
    @JsonProperty("source_transaction_id")
    public Optional<String> getSourceTransactionId() {
        return sourceTransactionId;
    }

    /**
     * @return Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.
     */
    @JsonProperty("remote_was_deleted")
    public Optional<Boolean> getRemoteWasDeleted() {
        return remoteWasDeleted;
    }

    /**
     * @return Whether or not this transaction has been processed by the external system. For example, NetSuite writes this field as True when the SuiteApp has processed the transaction.
     */
    @JsonProperty("is_processed")
    public Optional<Boolean> getIsProcessed() {
        return isProcessed;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BankFeedTransaction && equalTo((BankFeedTransaction) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BankFeedTransaction other) {
        return id.equals(other.id)
                && remoteId.equals(other.remoteId)
                && createdAt.equals(other.createdAt)
                && modifiedAt.equals(other.modifiedAt)
                && bankFeedAccount.equals(other.bankFeedAccount)
                && transactionDate.equals(other.transactionDate)
                && postedDate.equals(other.postedDate)
                && amount.equals(other.amount)
                && description.equals(other.description)
                && transactionType.equals(other.transactionType)
                && payee.equals(other.payee)
                && creditOrDebit.equals(other.creditOrDebit)
                && sourceTransactionId.equals(other.sourceTransactionId)
                && remoteWasDeleted.equals(other.remoteWasDeleted)
                && isProcessed.equals(other.isProcessed);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.remoteId,
                this.createdAt,
                this.modifiedAt,
                this.bankFeedAccount,
                this.transactionDate,
                this.postedDate,
                this.amount,
                this.description,
                this.transactionType,
                this.payee,
                this.creditOrDebit,
                this.sourceTransactionId,
                this.remoteWasDeleted,
                this.isProcessed);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> remoteId = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<OffsetDateTime> modifiedAt = Optional.empty();

        private Optional<BankFeedTransactionBankFeedAccount> bankFeedAccount = Optional.empty();

        private Optional<OffsetDateTime> transactionDate = Optional.empty();

        private Optional<OffsetDateTime> postedDate = Optional.empty();

        private Optional<Double> amount = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> transactionType = Optional.empty();

        private Optional<String> payee = Optional.empty();

        private Optional<BankFeedTransactionCreditOrDebit> creditOrDebit = Optional.empty();

        private Optional<String> sourceTransactionId = Optional.empty();

        private Optional<Boolean> remoteWasDeleted = Optional.empty();

        private Optional<Boolean> isProcessed = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BankFeedTransaction other) {
            id(other.getId());
            remoteId(other.getRemoteId());
            createdAt(other.getCreatedAt());
            modifiedAt(other.getModifiedAt());
            bankFeedAccount(other.getBankFeedAccount());
            transactionDate(other.getTransactionDate());
            postedDate(other.getPostedDate());
            amount(other.getAmount());
            description(other.getDescription());
            transactionType(other.getTransactionType());
            payee(other.getPayee());
            creditOrDebit(other.getCreditOrDebit());
            sourceTransactionId(other.getSourceTransactionId());
            remoteWasDeleted(other.getRemoteWasDeleted());
            isProcessed(other.getIsProcessed());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * <p>The third-party API ID of the matching object.</p>
         */
        @JsonSetter(value = "remote_id", nulls = Nulls.SKIP)
        public Builder remoteId(Optional<String> remoteId) {
            this.remoteId = remoteId;
            return this;
        }

        public Builder remoteId(String remoteId) {
            this.remoteId = Optional.ofNullable(remoteId);
            return this;
        }

        /**
         * <p>The datetime that this object was created by Merge.</p>
         */
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * <p>The datetime that this object was modified by Merge.</p>
         */
        @JsonSetter(value = "modified_at", nulls = Nulls.SKIP)
        public Builder modifiedAt(Optional<OffsetDateTime> modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedAt(OffsetDateTime modifiedAt) {
            this.modifiedAt = Optional.ofNullable(modifiedAt);
            return this;
        }

        /**
         * <p>The bank feed account associated with the transaction.</p>
         */
        @JsonSetter(value = "bank_feed_account", nulls = Nulls.SKIP)
        public Builder bankFeedAccount(Optional<BankFeedTransactionBankFeedAccount> bankFeedAccount) {
            this.bankFeedAccount = bankFeedAccount;
            return this;
        }

        public Builder bankFeedAccount(BankFeedTransactionBankFeedAccount bankFeedAccount) {
            this.bankFeedAccount = Optional.ofNullable(bankFeedAccount);
            return this;
        }

        /**
         * <p>The date that the transaction occurred.</p>
         */
        @JsonSetter(value = "transaction_date", nulls = Nulls.SKIP)
        public Builder transactionDate(Optional<OffsetDateTime> transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public Builder transactionDate(OffsetDateTime transactionDate) {
            this.transactionDate = Optional.ofNullable(transactionDate);
            return this;
        }

        /**
         * <p>The date the transaction was posted to the bank account.</p>
         */
        @JsonSetter(value = "posted_date", nulls = Nulls.SKIP)
        public Builder postedDate(Optional<OffsetDateTime> postedDate) {
            this.postedDate = postedDate;
            return this;
        }

        public Builder postedDate(OffsetDateTime postedDate) {
            this.postedDate = Optional.ofNullable(postedDate);
            return this;
        }

        /**
         * <p>The amount of the transaction.</p>
         */
        @JsonSetter(value = "amount", nulls = Nulls.SKIP)
        public Builder amount(Optional<Double> amount) {
            this.amount = amount;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = Optional.ofNullable(amount);
            return this;
        }

        /**
         * <p>The description of the transaction.</p>
         */
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * <p>The underlying type of the transaction.</p>
         */
        @JsonSetter(value = "transaction_type", nulls = Nulls.SKIP)
        public Builder transactionType(Optional<String> transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder transactionType(String transactionType) {
            this.transactionType = Optional.ofNullable(transactionType);
            return this;
        }

        /**
         * <p>The person or merchant who initiated the transaction, or alternatively, to whom the transaction was paid.</p>
         */
        @JsonSetter(value = "payee", nulls = Nulls.SKIP)
        public Builder payee(Optional<String> payee) {
            this.payee = payee;
            return this;
        }

        public Builder payee(String payee) {
            this.payee = Optional.ofNullable(payee);
            return this;
        }

        /**
         * <p>If the transaction is of type debit or credit.</p>
         * <ul>
         * <li><code>CREDIT</code> - CREDIT</li>
         * <li><code>DEBIT</code> - DEBIT</li>
         * </ul>
         */
        @JsonSetter(value = "credit_or_debit", nulls = Nulls.SKIP)
        public Builder creditOrDebit(Optional<BankFeedTransactionCreditOrDebit> creditOrDebit) {
            this.creditOrDebit = creditOrDebit;
            return this;
        }

        public Builder creditOrDebit(BankFeedTransactionCreditOrDebit creditOrDebit) {
            this.creditOrDebit = Optional.ofNullable(creditOrDebit);
            return this;
        }

        /**
         * <p>The customer’s identifier for the transaction.</p>
         */
        @JsonSetter(value = "source_transaction_id", nulls = Nulls.SKIP)
        public Builder sourceTransactionId(Optional<String> sourceTransactionId) {
            this.sourceTransactionId = sourceTransactionId;
            return this;
        }

        public Builder sourceTransactionId(String sourceTransactionId) {
            this.sourceTransactionId = Optional.ofNullable(sourceTransactionId);
            return this;
        }

        /**
         * <p>Indicates whether or not this object has been deleted in the third party platform. Full coverage deletion detection is a premium add-on. Native deletion detection is offered for free with limited coverage. <a href="https://docs.merge.dev/integrations/hris/supported-features/">Learn more</a>.</p>
         */
        @JsonSetter(value = "remote_was_deleted", nulls = Nulls.SKIP)
        public Builder remoteWasDeleted(Optional<Boolean> remoteWasDeleted) {
            this.remoteWasDeleted = remoteWasDeleted;
            return this;
        }

        public Builder remoteWasDeleted(Boolean remoteWasDeleted) {
            this.remoteWasDeleted = Optional.ofNullable(remoteWasDeleted);
            return this;
        }

        /**
         * <p>Whether or not this transaction has been processed by the external system. For example, NetSuite writes this field as True when the SuiteApp has processed the transaction.</p>
         */
        @JsonSetter(value = "is_processed", nulls = Nulls.SKIP)
        public Builder isProcessed(Optional<Boolean> isProcessed) {
            this.isProcessed = isProcessed;
            return this;
        }

        public Builder isProcessed(Boolean isProcessed) {
            this.isProcessed = Optional.ofNullable(isProcessed);
            return this;
        }

        public BankFeedTransaction build() {
            return new BankFeedTransaction(
                    id,
                    remoteId,
                    createdAt,
                    modifiedAt,
                    bankFeedAccount,
                    transactionDate,
                    postedDate,
                    amount,
                    description,
                    transactionType,
                    payee,
                    creditOrDebit,
                    sourceTransactionId,
                    remoteWasDeleted,
                    isProcessed,
                    additionalProperties);
        }
    }
}

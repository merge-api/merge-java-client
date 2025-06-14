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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = FieldMappingApiInstanceResponse.Builder.class)
public final class FieldMappingApiInstanceResponse {
    private final Optional<List<FieldMappingApiInstance>> account;

    private final Optional<List<FieldMappingApiInstance>> accountingAttachment;

    private final Optional<List<FieldMappingApiInstance>> balanceSheet;

    private final Optional<List<FieldMappingApiInstance>> cashFlowStatement;

    private final Optional<List<FieldMappingApiInstance>> companyInfo;

    private final Optional<List<FieldMappingApiInstance>> contact;

    private final Optional<List<FieldMappingApiInstance>> incomeStatement;

    private final Optional<List<FieldMappingApiInstance>> creditNote;

    private final Optional<List<FieldMappingApiInstance>> item;

    private final Optional<List<FieldMappingApiInstance>> purchaseOrder;

    private final Optional<List<FieldMappingApiInstance>> trackingCategory;

    private final Optional<List<FieldMappingApiInstance>> journalEntry;

    private final Optional<List<FieldMappingApiInstance>> taxRate;

    private final Optional<List<FieldMappingApiInstance>> invoice;

    private final Optional<List<FieldMappingApiInstance>> payment;

    private final Optional<List<FieldMappingApiInstance>> expense;

    private final Optional<List<FieldMappingApiInstance>> vendorCredit;

    private final Optional<List<FieldMappingApiInstance>> transaction;

    private final Optional<List<FieldMappingApiInstance>> accountingPeriod;

    private final Optional<List<FieldMappingApiInstance>> generalLedgerTransaction;

    private final Optional<List<FieldMappingApiInstance>> bankFeedAccount;

    private final Optional<List<FieldMappingApiInstance>> employee;

    private final Optional<List<FieldMappingApiInstance>> paymentMethod;

    private final Optional<List<FieldMappingApiInstance>> project;

    private final Optional<List<FieldMappingApiInstance>> paymentTerm;

    private final Map<String, Object> additionalProperties;

    private FieldMappingApiInstanceResponse(
            Optional<List<FieldMappingApiInstance>> account,
            Optional<List<FieldMappingApiInstance>> accountingAttachment,
            Optional<List<FieldMappingApiInstance>> balanceSheet,
            Optional<List<FieldMappingApiInstance>> cashFlowStatement,
            Optional<List<FieldMappingApiInstance>> companyInfo,
            Optional<List<FieldMappingApiInstance>> contact,
            Optional<List<FieldMappingApiInstance>> incomeStatement,
            Optional<List<FieldMappingApiInstance>> creditNote,
            Optional<List<FieldMappingApiInstance>> item,
            Optional<List<FieldMappingApiInstance>> purchaseOrder,
            Optional<List<FieldMappingApiInstance>> trackingCategory,
            Optional<List<FieldMappingApiInstance>> journalEntry,
            Optional<List<FieldMappingApiInstance>> taxRate,
            Optional<List<FieldMappingApiInstance>> invoice,
            Optional<List<FieldMappingApiInstance>> payment,
            Optional<List<FieldMappingApiInstance>> expense,
            Optional<List<FieldMappingApiInstance>> vendorCredit,
            Optional<List<FieldMappingApiInstance>> transaction,
            Optional<List<FieldMappingApiInstance>> accountingPeriod,
            Optional<List<FieldMappingApiInstance>> generalLedgerTransaction,
            Optional<List<FieldMappingApiInstance>> bankFeedAccount,
            Optional<List<FieldMappingApiInstance>> employee,
            Optional<List<FieldMappingApiInstance>> paymentMethod,
            Optional<List<FieldMappingApiInstance>> project,
            Optional<List<FieldMappingApiInstance>> paymentTerm,
            Map<String, Object> additionalProperties) {
        this.account = account;
        this.accountingAttachment = accountingAttachment;
        this.balanceSheet = balanceSheet;
        this.cashFlowStatement = cashFlowStatement;
        this.companyInfo = companyInfo;
        this.contact = contact;
        this.incomeStatement = incomeStatement;
        this.creditNote = creditNote;
        this.item = item;
        this.purchaseOrder = purchaseOrder;
        this.trackingCategory = trackingCategory;
        this.journalEntry = journalEntry;
        this.taxRate = taxRate;
        this.invoice = invoice;
        this.payment = payment;
        this.expense = expense;
        this.vendorCredit = vendorCredit;
        this.transaction = transaction;
        this.accountingPeriod = accountingPeriod;
        this.generalLedgerTransaction = generalLedgerTransaction;
        this.bankFeedAccount = bankFeedAccount;
        this.employee = employee;
        this.paymentMethod = paymentMethod;
        this.project = project;
        this.paymentTerm = paymentTerm;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("Account")
    public Optional<List<FieldMappingApiInstance>> getAccount() {
        return account;
    }

    @JsonProperty("AccountingAttachment")
    public Optional<List<FieldMappingApiInstance>> getAccountingAttachment() {
        return accountingAttachment;
    }

    @JsonProperty("BalanceSheet")
    public Optional<List<FieldMappingApiInstance>> getBalanceSheet() {
        return balanceSheet;
    }

    @JsonProperty("CashFlowStatement")
    public Optional<List<FieldMappingApiInstance>> getCashFlowStatement() {
        return cashFlowStatement;
    }

    @JsonProperty("CompanyInfo")
    public Optional<List<FieldMappingApiInstance>> getCompanyInfo() {
        return companyInfo;
    }

    @JsonProperty("Contact")
    public Optional<List<FieldMappingApiInstance>> getContact() {
        return contact;
    }

    @JsonProperty("IncomeStatement")
    public Optional<List<FieldMappingApiInstance>> getIncomeStatement() {
        return incomeStatement;
    }

    @JsonProperty("CreditNote")
    public Optional<List<FieldMappingApiInstance>> getCreditNote() {
        return creditNote;
    }

    @JsonProperty("Item")
    public Optional<List<FieldMappingApiInstance>> getItem() {
        return item;
    }

    @JsonProperty("PurchaseOrder")
    public Optional<List<FieldMappingApiInstance>> getPurchaseOrder() {
        return purchaseOrder;
    }

    @JsonProperty("TrackingCategory")
    public Optional<List<FieldMappingApiInstance>> getTrackingCategory() {
        return trackingCategory;
    }

    @JsonProperty("JournalEntry")
    public Optional<List<FieldMappingApiInstance>> getJournalEntry() {
        return journalEntry;
    }

    @JsonProperty("TaxRate")
    public Optional<List<FieldMappingApiInstance>> getTaxRate() {
        return taxRate;
    }

    @JsonProperty("Invoice")
    public Optional<List<FieldMappingApiInstance>> getInvoice() {
        return invoice;
    }

    @JsonProperty("Payment")
    public Optional<List<FieldMappingApiInstance>> getPayment() {
        return payment;
    }

    @JsonProperty("Expense")
    public Optional<List<FieldMappingApiInstance>> getExpense() {
        return expense;
    }

    @JsonProperty("VendorCredit")
    public Optional<List<FieldMappingApiInstance>> getVendorCredit() {
        return vendorCredit;
    }

    @JsonProperty("Transaction")
    public Optional<List<FieldMappingApiInstance>> getTransaction() {
        return transaction;
    }

    @JsonProperty("AccountingPeriod")
    public Optional<List<FieldMappingApiInstance>> getAccountingPeriod() {
        return accountingPeriod;
    }

    @JsonProperty("GeneralLedgerTransaction")
    public Optional<List<FieldMappingApiInstance>> getGeneralLedgerTransaction() {
        return generalLedgerTransaction;
    }

    @JsonProperty("BankFeedAccount")
    public Optional<List<FieldMappingApiInstance>> getBankFeedAccount() {
        return bankFeedAccount;
    }

    @JsonProperty("Employee")
    public Optional<List<FieldMappingApiInstance>> getEmployee() {
        return employee;
    }

    @JsonProperty("PaymentMethod")
    public Optional<List<FieldMappingApiInstance>> getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("Project")
    public Optional<List<FieldMappingApiInstance>> getProject() {
        return project;
    }

    @JsonProperty("PaymentTerm")
    public Optional<List<FieldMappingApiInstance>> getPaymentTerm() {
        return paymentTerm;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FieldMappingApiInstanceResponse && equalTo((FieldMappingApiInstanceResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FieldMappingApiInstanceResponse other) {
        return account.equals(other.account)
                && accountingAttachment.equals(other.accountingAttachment)
                && balanceSheet.equals(other.balanceSheet)
                && cashFlowStatement.equals(other.cashFlowStatement)
                && companyInfo.equals(other.companyInfo)
                && contact.equals(other.contact)
                && incomeStatement.equals(other.incomeStatement)
                && creditNote.equals(other.creditNote)
                && item.equals(other.item)
                && purchaseOrder.equals(other.purchaseOrder)
                && trackingCategory.equals(other.trackingCategory)
                && journalEntry.equals(other.journalEntry)
                && taxRate.equals(other.taxRate)
                && invoice.equals(other.invoice)
                && payment.equals(other.payment)
                && expense.equals(other.expense)
                && vendorCredit.equals(other.vendorCredit)
                && transaction.equals(other.transaction)
                && accountingPeriod.equals(other.accountingPeriod)
                && generalLedgerTransaction.equals(other.generalLedgerTransaction)
                && bankFeedAccount.equals(other.bankFeedAccount)
                && employee.equals(other.employee)
                && paymentMethod.equals(other.paymentMethod)
                && project.equals(other.project)
                && paymentTerm.equals(other.paymentTerm);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.account,
                this.accountingAttachment,
                this.balanceSheet,
                this.cashFlowStatement,
                this.companyInfo,
                this.contact,
                this.incomeStatement,
                this.creditNote,
                this.item,
                this.purchaseOrder,
                this.trackingCategory,
                this.journalEntry,
                this.taxRate,
                this.invoice,
                this.payment,
                this.expense,
                this.vendorCredit,
                this.transaction,
                this.accountingPeriod,
                this.generalLedgerTransaction,
                this.bankFeedAccount,
                this.employee,
                this.paymentMethod,
                this.project,
                this.paymentTerm);
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
        private Optional<List<FieldMappingApiInstance>> account = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> accountingAttachment = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> balanceSheet = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> cashFlowStatement = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> companyInfo = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> contact = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> incomeStatement = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> creditNote = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> item = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> purchaseOrder = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> trackingCategory = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> journalEntry = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> taxRate = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> invoice = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> payment = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> expense = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> vendorCredit = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> transaction = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> accountingPeriod = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> generalLedgerTransaction = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> bankFeedAccount = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> employee = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> paymentMethod = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> project = Optional.empty();

        private Optional<List<FieldMappingApiInstance>> paymentTerm = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(FieldMappingApiInstanceResponse other) {
            account(other.getAccount());
            accountingAttachment(other.getAccountingAttachment());
            balanceSheet(other.getBalanceSheet());
            cashFlowStatement(other.getCashFlowStatement());
            companyInfo(other.getCompanyInfo());
            contact(other.getContact());
            incomeStatement(other.getIncomeStatement());
            creditNote(other.getCreditNote());
            item(other.getItem());
            purchaseOrder(other.getPurchaseOrder());
            trackingCategory(other.getTrackingCategory());
            journalEntry(other.getJournalEntry());
            taxRate(other.getTaxRate());
            invoice(other.getInvoice());
            payment(other.getPayment());
            expense(other.getExpense());
            vendorCredit(other.getVendorCredit());
            transaction(other.getTransaction());
            accountingPeriod(other.getAccountingPeriod());
            generalLedgerTransaction(other.getGeneralLedgerTransaction());
            bankFeedAccount(other.getBankFeedAccount());
            employee(other.getEmployee());
            paymentMethod(other.getPaymentMethod());
            project(other.getProject());
            paymentTerm(other.getPaymentTerm());
            return this;
        }

        @JsonSetter(value = "Account", nulls = Nulls.SKIP)
        public Builder account(Optional<List<FieldMappingApiInstance>> account) {
            this.account = account;
            return this;
        }

        public Builder account(List<FieldMappingApiInstance> account) {
            this.account = Optional.ofNullable(account);
            return this;
        }

        @JsonSetter(value = "AccountingAttachment", nulls = Nulls.SKIP)
        public Builder accountingAttachment(Optional<List<FieldMappingApiInstance>> accountingAttachment) {
            this.accountingAttachment = accountingAttachment;
            return this;
        }

        public Builder accountingAttachment(List<FieldMappingApiInstance> accountingAttachment) {
            this.accountingAttachment = Optional.ofNullable(accountingAttachment);
            return this;
        }

        @JsonSetter(value = "BalanceSheet", nulls = Nulls.SKIP)
        public Builder balanceSheet(Optional<List<FieldMappingApiInstance>> balanceSheet) {
            this.balanceSheet = balanceSheet;
            return this;
        }

        public Builder balanceSheet(List<FieldMappingApiInstance> balanceSheet) {
            this.balanceSheet = Optional.ofNullable(balanceSheet);
            return this;
        }

        @JsonSetter(value = "CashFlowStatement", nulls = Nulls.SKIP)
        public Builder cashFlowStatement(Optional<List<FieldMappingApiInstance>> cashFlowStatement) {
            this.cashFlowStatement = cashFlowStatement;
            return this;
        }

        public Builder cashFlowStatement(List<FieldMappingApiInstance> cashFlowStatement) {
            this.cashFlowStatement = Optional.ofNullable(cashFlowStatement);
            return this;
        }

        @JsonSetter(value = "CompanyInfo", nulls = Nulls.SKIP)
        public Builder companyInfo(Optional<List<FieldMappingApiInstance>> companyInfo) {
            this.companyInfo = companyInfo;
            return this;
        }

        public Builder companyInfo(List<FieldMappingApiInstance> companyInfo) {
            this.companyInfo = Optional.ofNullable(companyInfo);
            return this;
        }

        @JsonSetter(value = "Contact", nulls = Nulls.SKIP)
        public Builder contact(Optional<List<FieldMappingApiInstance>> contact) {
            this.contact = contact;
            return this;
        }

        public Builder contact(List<FieldMappingApiInstance> contact) {
            this.contact = Optional.ofNullable(contact);
            return this;
        }

        @JsonSetter(value = "IncomeStatement", nulls = Nulls.SKIP)
        public Builder incomeStatement(Optional<List<FieldMappingApiInstance>> incomeStatement) {
            this.incomeStatement = incomeStatement;
            return this;
        }

        public Builder incomeStatement(List<FieldMappingApiInstance> incomeStatement) {
            this.incomeStatement = Optional.ofNullable(incomeStatement);
            return this;
        }

        @JsonSetter(value = "CreditNote", nulls = Nulls.SKIP)
        public Builder creditNote(Optional<List<FieldMappingApiInstance>> creditNote) {
            this.creditNote = creditNote;
            return this;
        }

        public Builder creditNote(List<FieldMappingApiInstance> creditNote) {
            this.creditNote = Optional.ofNullable(creditNote);
            return this;
        }

        @JsonSetter(value = "Item", nulls = Nulls.SKIP)
        public Builder item(Optional<List<FieldMappingApiInstance>> item) {
            this.item = item;
            return this;
        }

        public Builder item(List<FieldMappingApiInstance> item) {
            this.item = Optional.ofNullable(item);
            return this;
        }

        @JsonSetter(value = "PurchaseOrder", nulls = Nulls.SKIP)
        public Builder purchaseOrder(Optional<List<FieldMappingApiInstance>> purchaseOrder) {
            this.purchaseOrder = purchaseOrder;
            return this;
        }

        public Builder purchaseOrder(List<FieldMappingApiInstance> purchaseOrder) {
            this.purchaseOrder = Optional.ofNullable(purchaseOrder);
            return this;
        }

        @JsonSetter(value = "TrackingCategory", nulls = Nulls.SKIP)
        public Builder trackingCategory(Optional<List<FieldMappingApiInstance>> trackingCategory) {
            this.trackingCategory = trackingCategory;
            return this;
        }

        public Builder trackingCategory(List<FieldMappingApiInstance> trackingCategory) {
            this.trackingCategory = Optional.ofNullable(trackingCategory);
            return this;
        }

        @JsonSetter(value = "JournalEntry", nulls = Nulls.SKIP)
        public Builder journalEntry(Optional<List<FieldMappingApiInstance>> journalEntry) {
            this.journalEntry = journalEntry;
            return this;
        }

        public Builder journalEntry(List<FieldMappingApiInstance> journalEntry) {
            this.journalEntry = Optional.ofNullable(journalEntry);
            return this;
        }

        @JsonSetter(value = "TaxRate", nulls = Nulls.SKIP)
        public Builder taxRate(Optional<List<FieldMappingApiInstance>> taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        public Builder taxRate(List<FieldMappingApiInstance> taxRate) {
            this.taxRate = Optional.ofNullable(taxRate);
            return this;
        }

        @JsonSetter(value = "Invoice", nulls = Nulls.SKIP)
        public Builder invoice(Optional<List<FieldMappingApiInstance>> invoice) {
            this.invoice = invoice;
            return this;
        }

        public Builder invoice(List<FieldMappingApiInstance> invoice) {
            this.invoice = Optional.ofNullable(invoice);
            return this;
        }

        @JsonSetter(value = "Payment", nulls = Nulls.SKIP)
        public Builder payment(Optional<List<FieldMappingApiInstance>> payment) {
            this.payment = payment;
            return this;
        }

        public Builder payment(List<FieldMappingApiInstance> payment) {
            this.payment = Optional.ofNullable(payment);
            return this;
        }

        @JsonSetter(value = "Expense", nulls = Nulls.SKIP)
        public Builder expense(Optional<List<FieldMappingApiInstance>> expense) {
            this.expense = expense;
            return this;
        }

        public Builder expense(List<FieldMappingApiInstance> expense) {
            this.expense = Optional.ofNullable(expense);
            return this;
        }

        @JsonSetter(value = "VendorCredit", nulls = Nulls.SKIP)
        public Builder vendorCredit(Optional<List<FieldMappingApiInstance>> vendorCredit) {
            this.vendorCredit = vendorCredit;
            return this;
        }

        public Builder vendorCredit(List<FieldMappingApiInstance> vendorCredit) {
            this.vendorCredit = Optional.ofNullable(vendorCredit);
            return this;
        }

        @JsonSetter(value = "Transaction", nulls = Nulls.SKIP)
        public Builder transaction(Optional<List<FieldMappingApiInstance>> transaction) {
            this.transaction = transaction;
            return this;
        }

        public Builder transaction(List<FieldMappingApiInstance> transaction) {
            this.transaction = Optional.ofNullable(transaction);
            return this;
        }

        @JsonSetter(value = "AccountingPeriod", nulls = Nulls.SKIP)
        public Builder accountingPeriod(Optional<List<FieldMappingApiInstance>> accountingPeriod) {
            this.accountingPeriod = accountingPeriod;
            return this;
        }

        public Builder accountingPeriod(List<FieldMappingApiInstance> accountingPeriod) {
            this.accountingPeriod = Optional.ofNullable(accountingPeriod);
            return this;
        }

        @JsonSetter(value = "GeneralLedgerTransaction", nulls = Nulls.SKIP)
        public Builder generalLedgerTransaction(Optional<List<FieldMappingApiInstance>> generalLedgerTransaction) {
            this.generalLedgerTransaction = generalLedgerTransaction;
            return this;
        }

        public Builder generalLedgerTransaction(List<FieldMappingApiInstance> generalLedgerTransaction) {
            this.generalLedgerTransaction = Optional.ofNullable(generalLedgerTransaction);
            return this;
        }

        @JsonSetter(value = "BankFeedAccount", nulls = Nulls.SKIP)
        public Builder bankFeedAccount(Optional<List<FieldMappingApiInstance>> bankFeedAccount) {
            this.bankFeedAccount = bankFeedAccount;
            return this;
        }

        public Builder bankFeedAccount(List<FieldMappingApiInstance> bankFeedAccount) {
            this.bankFeedAccount = Optional.ofNullable(bankFeedAccount);
            return this;
        }

        @JsonSetter(value = "Employee", nulls = Nulls.SKIP)
        public Builder employee(Optional<List<FieldMappingApiInstance>> employee) {
            this.employee = employee;
            return this;
        }

        public Builder employee(List<FieldMappingApiInstance> employee) {
            this.employee = Optional.ofNullable(employee);
            return this;
        }

        @JsonSetter(value = "PaymentMethod", nulls = Nulls.SKIP)
        public Builder paymentMethod(Optional<List<FieldMappingApiInstance>> paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder paymentMethod(List<FieldMappingApiInstance> paymentMethod) {
            this.paymentMethod = Optional.ofNullable(paymentMethod);
            return this;
        }

        @JsonSetter(value = "Project", nulls = Nulls.SKIP)
        public Builder project(Optional<List<FieldMappingApiInstance>> project) {
            this.project = project;
            return this;
        }

        public Builder project(List<FieldMappingApiInstance> project) {
            this.project = Optional.ofNullable(project);
            return this;
        }

        @JsonSetter(value = "PaymentTerm", nulls = Nulls.SKIP)
        public Builder paymentTerm(Optional<List<FieldMappingApiInstance>> paymentTerm) {
            this.paymentTerm = paymentTerm;
            return this;
        }

        public Builder paymentTerm(List<FieldMappingApiInstance> paymentTerm) {
            this.paymentTerm = Optional.ofNullable(paymentTerm);
            return this;
        }

        public FieldMappingApiInstanceResponse build() {
            return new FieldMappingApiInstanceResponse(
                    account,
                    accountingAttachment,
                    balanceSheet,
                    cashFlowStatement,
                    companyInfo,
                    contact,
                    incomeStatement,
                    creditNote,
                    item,
                    purchaseOrder,
                    trackingCategory,
                    journalEntry,
                    taxRate,
                    invoice,
                    payment,
                    expense,
                    vendorCredit,
                    transaction,
                    accountingPeriod,
                    generalLedgerTransaction,
                    bankFeedAccount,
                    employee,
                    paymentMethod,
                    project,
                    paymentTerm,
                    additionalProperties);
        }
    }
}

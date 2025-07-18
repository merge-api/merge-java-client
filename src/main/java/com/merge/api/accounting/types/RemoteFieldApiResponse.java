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
@JsonDeserialize(builder = RemoteFieldApiResponse.Builder.class)
public final class RemoteFieldApiResponse {
    private final Optional<List<RemoteFieldApi>> account;

    private final Optional<List<RemoteFieldApi>> accountingAttachment;

    private final Optional<List<RemoteFieldApi>> balanceSheet;

    private final Optional<List<RemoteFieldApi>> cashFlowStatement;

    private final Optional<List<RemoteFieldApi>> companyInfo;

    private final Optional<List<RemoteFieldApi>> contact;

    private final Optional<List<RemoteFieldApi>> incomeStatement;

    private final Optional<List<RemoteFieldApi>> creditNote;

    private final Optional<List<RemoteFieldApi>> item;

    private final Optional<List<RemoteFieldApi>> purchaseOrder;

    private final Optional<List<RemoteFieldApi>> trackingCategory;

    private final Optional<List<RemoteFieldApi>> journalEntry;

    private final Optional<List<RemoteFieldApi>> taxRate;

    private final Optional<List<RemoteFieldApi>> invoice;

    private final Optional<List<RemoteFieldApi>> payment;

    private final Optional<List<RemoteFieldApi>> expense;

    private final Optional<List<RemoteFieldApi>> vendorCredit;

    private final Optional<List<RemoteFieldApi>> transaction;

    private final Optional<List<RemoteFieldApi>> accountingPeriod;

    private final Optional<List<RemoteFieldApi>> generalLedgerTransaction;

    private final Optional<List<RemoteFieldApi>> bankFeedAccount;

    private final Optional<List<RemoteFieldApi>> employee;

    private final Optional<List<RemoteFieldApi>> paymentMethod;

    private final Optional<List<RemoteFieldApi>> project;

    private final Optional<List<RemoteFieldApi>> paymentTerm;

    private final Map<String, Object> additionalProperties;

    private RemoteFieldApiResponse(
            Optional<List<RemoteFieldApi>> account,
            Optional<List<RemoteFieldApi>> accountingAttachment,
            Optional<List<RemoteFieldApi>> balanceSheet,
            Optional<List<RemoteFieldApi>> cashFlowStatement,
            Optional<List<RemoteFieldApi>> companyInfo,
            Optional<List<RemoteFieldApi>> contact,
            Optional<List<RemoteFieldApi>> incomeStatement,
            Optional<List<RemoteFieldApi>> creditNote,
            Optional<List<RemoteFieldApi>> item,
            Optional<List<RemoteFieldApi>> purchaseOrder,
            Optional<List<RemoteFieldApi>> trackingCategory,
            Optional<List<RemoteFieldApi>> journalEntry,
            Optional<List<RemoteFieldApi>> taxRate,
            Optional<List<RemoteFieldApi>> invoice,
            Optional<List<RemoteFieldApi>> payment,
            Optional<List<RemoteFieldApi>> expense,
            Optional<List<RemoteFieldApi>> vendorCredit,
            Optional<List<RemoteFieldApi>> transaction,
            Optional<List<RemoteFieldApi>> accountingPeriod,
            Optional<List<RemoteFieldApi>> generalLedgerTransaction,
            Optional<List<RemoteFieldApi>> bankFeedAccount,
            Optional<List<RemoteFieldApi>> employee,
            Optional<List<RemoteFieldApi>> paymentMethod,
            Optional<List<RemoteFieldApi>> project,
            Optional<List<RemoteFieldApi>> paymentTerm,
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
    public Optional<List<RemoteFieldApi>> getAccount() {
        return account;
    }

    @JsonProperty("AccountingAttachment")
    public Optional<List<RemoteFieldApi>> getAccountingAttachment() {
        return accountingAttachment;
    }

    @JsonProperty("BalanceSheet")
    public Optional<List<RemoteFieldApi>> getBalanceSheet() {
        return balanceSheet;
    }

    @JsonProperty("CashFlowStatement")
    public Optional<List<RemoteFieldApi>> getCashFlowStatement() {
        return cashFlowStatement;
    }

    @JsonProperty("CompanyInfo")
    public Optional<List<RemoteFieldApi>> getCompanyInfo() {
        return companyInfo;
    }

    @JsonProperty("Contact")
    public Optional<List<RemoteFieldApi>> getContact() {
        return contact;
    }

    @JsonProperty("IncomeStatement")
    public Optional<List<RemoteFieldApi>> getIncomeStatement() {
        return incomeStatement;
    }

    @JsonProperty("CreditNote")
    public Optional<List<RemoteFieldApi>> getCreditNote() {
        return creditNote;
    }

    @JsonProperty("Item")
    public Optional<List<RemoteFieldApi>> getItem() {
        return item;
    }

    @JsonProperty("PurchaseOrder")
    public Optional<List<RemoteFieldApi>> getPurchaseOrder() {
        return purchaseOrder;
    }

    @JsonProperty("TrackingCategory")
    public Optional<List<RemoteFieldApi>> getTrackingCategory() {
        return trackingCategory;
    }

    @JsonProperty("JournalEntry")
    public Optional<List<RemoteFieldApi>> getJournalEntry() {
        return journalEntry;
    }

    @JsonProperty("TaxRate")
    public Optional<List<RemoteFieldApi>> getTaxRate() {
        return taxRate;
    }

    @JsonProperty("Invoice")
    public Optional<List<RemoteFieldApi>> getInvoice() {
        return invoice;
    }

    @JsonProperty("Payment")
    public Optional<List<RemoteFieldApi>> getPayment() {
        return payment;
    }

    @JsonProperty("Expense")
    public Optional<List<RemoteFieldApi>> getExpense() {
        return expense;
    }

    @JsonProperty("VendorCredit")
    public Optional<List<RemoteFieldApi>> getVendorCredit() {
        return vendorCredit;
    }

    @JsonProperty("Transaction")
    public Optional<List<RemoteFieldApi>> getTransaction() {
        return transaction;
    }

    @JsonProperty("AccountingPeriod")
    public Optional<List<RemoteFieldApi>> getAccountingPeriod() {
        return accountingPeriod;
    }

    @JsonProperty("GeneralLedgerTransaction")
    public Optional<List<RemoteFieldApi>> getGeneralLedgerTransaction() {
        return generalLedgerTransaction;
    }

    @JsonProperty("BankFeedAccount")
    public Optional<List<RemoteFieldApi>> getBankFeedAccount() {
        return bankFeedAccount;
    }

    @JsonProperty("Employee")
    public Optional<List<RemoteFieldApi>> getEmployee() {
        return employee;
    }

    @JsonProperty("PaymentMethod")
    public Optional<List<RemoteFieldApi>> getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("Project")
    public Optional<List<RemoteFieldApi>> getProject() {
        return project;
    }

    @JsonProperty("PaymentTerm")
    public Optional<List<RemoteFieldApi>> getPaymentTerm() {
        return paymentTerm;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RemoteFieldApiResponse && equalTo((RemoteFieldApiResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RemoteFieldApiResponse other) {
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
        private Optional<List<RemoteFieldApi>> account = Optional.empty();

        private Optional<List<RemoteFieldApi>> accountingAttachment = Optional.empty();

        private Optional<List<RemoteFieldApi>> balanceSheet = Optional.empty();

        private Optional<List<RemoteFieldApi>> cashFlowStatement = Optional.empty();

        private Optional<List<RemoteFieldApi>> companyInfo = Optional.empty();

        private Optional<List<RemoteFieldApi>> contact = Optional.empty();

        private Optional<List<RemoteFieldApi>> incomeStatement = Optional.empty();

        private Optional<List<RemoteFieldApi>> creditNote = Optional.empty();

        private Optional<List<RemoteFieldApi>> item = Optional.empty();

        private Optional<List<RemoteFieldApi>> purchaseOrder = Optional.empty();

        private Optional<List<RemoteFieldApi>> trackingCategory = Optional.empty();

        private Optional<List<RemoteFieldApi>> journalEntry = Optional.empty();

        private Optional<List<RemoteFieldApi>> taxRate = Optional.empty();

        private Optional<List<RemoteFieldApi>> invoice = Optional.empty();

        private Optional<List<RemoteFieldApi>> payment = Optional.empty();

        private Optional<List<RemoteFieldApi>> expense = Optional.empty();

        private Optional<List<RemoteFieldApi>> vendorCredit = Optional.empty();

        private Optional<List<RemoteFieldApi>> transaction = Optional.empty();

        private Optional<List<RemoteFieldApi>> accountingPeriod = Optional.empty();

        private Optional<List<RemoteFieldApi>> generalLedgerTransaction = Optional.empty();

        private Optional<List<RemoteFieldApi>> bankFeedAccount = Optional.empty();

        private Optional<List<RemoteFieldApi>> employee = Optional.empty();

        private Optional<List<RemoteFieldApi>> paymentMethod = Optional.empty();

        private Optional<List<RemoteFieldApi>> project = Optional.empty();

        private Optional<List<RemoteFieldApi>> paymentTerm = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(RemoteFieldApiResponse other) {
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
        public Builder account(Optional<List<RemoteFieldApi>> account) {
            this.account = account;
            return this;
        }

        public Builder account(List<RemoteFieldApi> account) {
            this.account = Optional.ofNullable(account);
            return this;
        }

        @JsonSetter(value = "AccountingAttachment", nulls = Nulls.SKIP)
        public Builder accountingAttachment(Optional<List<RemoteFieldApi>> accountingAttachment) {
            this.accountingAttachment = accountingAttachment;
            return this;
        }

        public Builder accountingAttachment(List<RemoteFieldApi> accountingAttachment) {
            this.accountingAttachment = Optional.ofNullable(accountingAttachment);
            return this;
        }

        @JsonSetter(value = "BalanceSheet", nulls = Nulls.SKIP)
        public Builder balanceSheet(Optional<List<RemoteFieldApi>> balanceSheet) {
            this.balanceSheet = balanceSheet;
            return this;
        }

        public Builder balanceSheet(List<RemoteFieldApi> balanceSheet) {
            this.balanceSheet = Optional.ofNullable(balanceSheet);
            return this;
        }

        @JsonSetter(value = "CashFlowStatement", nulls = Nulls.SKIP)
        public Builder cashFlowStatement(Optional<List<RemoteFieldApi>> cashFlowStatement) {
            this.cashFlowStatement = cashFlowStatement;
            return this;
        }

        public Builder cashFlowStatement(List<RemoteFieldApi> cashFlowStatement) {
            this.cashFlowStatement = Optional.ofNullable(cashFlowStatement);
            return this;
        }

        @JsonSetter(value = "CompanyInfo", nulls = Nulls.SKIP)
        public Builder companyInfo(Optional<List<RemoteFieldApi>> companyInfo) {
            this.companyInfo = companyInfo;
            return this;
        }

        public Builder companyInfo(List<RemoteFieldApi> companyInfo) {
            this.companyInfo = Optional.ofNullable(companyInfo);
            return this;
        }

        @JsonSetter(value = "Contact", nulls = Nulls.SKIP)
        public Builder contact(Optional<List<RemoteFieldApi>> contact) {
            this.contact = contact;
            return this;
        }

        public Builder contact(List<RemoteFieldApi> contact) {
            this.contact = Optional.ofNullable(contact);
            return this;
        }

        @JsonSetter(value = "IncomeStatement", nulls = Nulls.SKIP)
        public Builder incomeStatement(Optional<List<RemoteFieldApi>> incomeStatement) {
            this.incomeStatement = incomeStatement;
            return this;
        }

        public Builder incomeStatement(List<RemoteFieldApi> incomeStatement) {
            this.incomeStatement = Optional.ofNullable(incomeStatement);
            return this;
        }

        @JsonSetter(value = "CreditNote", nulls = Nulls.SKIP)
        public Builder creditNote(Optional<List<RemoteFieldApi>> creditNote) {
            this.creditNote = creditNote;
            return this;
        }

        public Builder creditNote(List<RemoteFieldApi> creditNote) {
            this.creditNote = Optional.ofNullable(creditNote);
            return this;
        }

        @JsonSetter(value = "Item", nulls = Nulls.SKIP)
        public Builder item(Optional<List<RemoteFieldApi>> item) {
            this.item = item;
            return this;
        }

        public Builder item(List<RemoteFieldApi> item) {
            this.item = Optional.ofNullable(item);
            return this;
        }

        @JsonSetter(value = "PurchaseOrder", nulls = Nulls.SKIP)
        public Builder purchaseOrder(Optional<List<RemoteFieldApi>> purchaseOrder) {
            this.purchaseOrder = purchaseOrder;
            return this;
        }

        public Builder purchaseOrder(List<RemoteFieldApi> purchaseOrder) {
            this.purchaseOrder = Optional.ofNullable(purchaseOrder);
            return this;
        }

        @JsonSetter(value = "TrackingCategory", nulls = Nulls.SKIP)
        public Builder trackingCategory(Optional<List<RemoteFieldApi>> trackingCategory) {
            this.trackingCategory = trackingCategory;
            return this;
        }

        public Builder trackingCategory(List<RemoteFieldApi> trackingCategory) {
            this.trackingCategory = Optional.ofNullable(trackingCategory);
            return this;
        }

        @JsonSetter(value = "JournalEntry", nulls = Nulls.SKIP)
        public Builder journalEntry(Optional<List<RemoteFieldApi>> journalEntry) {
            this.journalEntry = journalEntry;
            return this;
        }

        public Builder journalEntry(List<RemoteFieldApi> journalEntry) {
            this.journalEntry = Optional.ofNullable(journalEntry);
            return this;
        }

        @JsonSetter(value = "TaxRate", nulls = Nulls.SKIP)
        public Builder taxRate(Optional<List<RemoteFieldApi>> taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        public Builder taxRate(List<RemoteFieldApi> taxRate) {
            this.taxRate = Optional.ofNullable(taxRate);
            return this;
        }

        @JsonSetter(value = "Invoice", nulls = Nulls.SKIP)
        public Builder invoice(Optional<List<RemoteFieldApi>> invoice) {
            this.invoice = invoice;
            return this;
        }

        public Builder invoice(List<RemoteFieldApi> invoice) {
            this.invoice = Optional.ofNullable(invoice);
            return this;
        }

        @JsonSetter(value = "Payment", nulls = Nulls.SKIP)
        public Builder payment(Optional<List<RemoteFieldApi>> payment) {
            this.payment = payment;
            return this;
        }

        public Builder payment(List<RemoteFieldApi> payment) {
            this.payment = Optional.ofNullable(payment);
            return this;
        }

        @JsonSetter(value = "Expense", nulls = Nulls.SKIP)
        public Builder expense(Optional<List<RemoteFieldApi>> expense) {
            this.expense = expense;
            return this;
        }

        public Builder expense(List<RemoteFieldApi> expense) {
            this.expense = Optional.ofNullable(expense);
            return this;
        }

        @JsonSetter(value = "VendorCredit", nulls = Nulls.SKIP)
        public Builder vendorCredit(Optional<List<RemoteFieldApi>> vendorCredit) {
            this.vendorCredit = vendorCredit;
            return this;
        }

        public Builder vendorCredit(List<RemoteFieldApi> vendorCredit) {
            this.vendorCredit = Optional.ofNullable(vendorCredit);
            return this;
        }

        @JsonSetter(value = "Transaction", nulls = Nulls.SKIP)
        public Builder transaction(Optional<List<RemoteFieldApi>> transaction) {
            this.transaction = transaction;
            return this;
        }

        public Builder transaction(List<RemoteFieldApi> transaction) {
            this.transaction = Optional.ofNullable(transaction);
            return this;
        }

        @JsonSetter(value = "AccountingPeriod", nulls = Nulls.SKIP)
        public Builder accountingPeriod(Optional<List<RemoteFieldApi>> accountingPeriod) {
            this.accountingPeriod = accountingPeriod;
            return this;
        }

        public Builder accountingPeriod(List<RemoteFieldApi> accountingPeriod) {
            this.accountingPeriod = Optional.ofNullable(accountingPeriod);
            return this;
        }

        @JsonSetter(value = "GeneralLedgerTransaction", nulls = Nulls.SKIP)
        public Builder generalLedgerTransaction(Optional<List<RemoteFieldApi>> generalLedgerTransaction) {
            this.generalLedgerTransaction = generalLedgerTransaction;
            return this;
        }

        public Builder generalLedgerTransaction(List<RemoteFieldApi> generalLedgerTransaction) {
            this.generalLedgerTransaction = Optional.ofNullable(generalLedgerTransaction);
            return this;
        }

        @JsonSetter(value = "BankFeedAccount", nulls = Nulls.SKIP)
        public Builder bankFeedAccount(Optional<List<RemoteFieldApi>> bankFeedAccount) {
            this.bankFeedAccount = bankFeedAccount;
            return this;
        }

        public Builder bankFeedAccount(List<RemoteFieldApi> bankFeedAccount) {
            this.bankFeedAccount = Optional.ofNullable(bankFeedAccount);
            return this;
        }

        @JsonSetter(value = "Employee", nulls = Nulls.SKIP)
        public Builder employee(Optional<List<RemoteFieldApi>> employee) {
            this.employee = employee;
            return this;
        }

        public Builder employee(List<RemoteFieldApi> employee) {
            this.employee = Optional.ofNullable(employee);
            return this;
        }

        @JsonSetter(value = "PaymentMethod", nulls = Nulls.SKIP)
        public Builder paymentMethod(Optional<List<RemoteFieldApi>> paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder paymentMethod(List<RemoteFieldApi> paymentMethod) {
            this.paymentMethod = Optional.ofNullable(paymentMethod);
            return this;
        }

        @JsonSetter(value = "Project", nulls = Nulls.SKIP)
        public Builder project(Optional<List<RemoteFieldApi>> project) {
            this.project = project;
            return this;
        }

        public Builder project(List<RemoteFieldApi> project) {
            this.project = Optional.ofNullable(project);
            return this;
        }

        @JsonSetter(value = "PaymentTerm", nulls = Nulls.SKIP)
        public Builder paymentTerm(Optional<List<RemoteFieldApi>> paymentTerm) {
            this.paymentTerm = paymentTerm;
            return this;
        }

        public Builder paymentTerm(List<RemoteFieldApi> paymentTerm) {
            this.paymentTerm = Optional.ofNullable(paymentTerm);
            return this;
        }

        public RemoteFieldApiResponse build() {
            return new RemoteFieldApiResponse(
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

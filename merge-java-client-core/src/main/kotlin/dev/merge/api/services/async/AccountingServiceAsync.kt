@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async

import dev.merge.api.services.async.accounting.AccountDetailServiceAsync
import dev.merge.api.services.async.accounting.AccountServiceAsync
import dev.merge.api.services.async.accounting.AccountTokenServiceAsync
import dev.merge.api.services.async.accounting.AddressServiceAsync
import dev.merge.api.services.async.accounting.AttachmentServiceAsync
import dev.merge.api.services.async.accounting.AvailableActionServiceAsync
import dev.merge.api.services.async.accounting.BalanceSheetServiceAsync
import dev.merge.api.services.async.accounting.CashFlowStatementServiceAsync
import dev.merge.api.services.async.accounting.CommonModelScopeServiceAsync
import dev.merge.api.services.async.accounting.CompanyInfoServiceAsync
import dev.merge.api.services.async.accounting.ContactServiceAsync
import dev.merge.api.services.async.accounting.CreditNoteServiceAsync
import dev.merge.api.services.async.accounting.ExpenseServiceAsync
import dev.merge.api.services.async.accounting.IncomeStatementServiceAsync
import dev.merge.api.services.async.accounting.InvoiceServiceAsync
import dev.merge.api.services.async.accounting.IssueServiceAsync
import dev.merge.api.services.async.accounting.ItemServiceAsync
import dev.merge.api.services.async.accounting.JournalEntryServiceAsync
import dev.merge.api.services.async.accounting.LinkTokenServiceAsync
import dev.merge.api.services.async.accounting.LinkedAccountServiceAsync
import dev.merge.api.services.async.accounting.PassthroughRequestServiceAsync
import dev.merge.api.services.async.accounting.PaymentServiceAsync
import dev.merge.api.services.async.accounting.PhoneNumberServiceAsync
import dev.merge.api.services.async.accounting.PurchaseOrderServiceAsync
import dev.merge.api.services.async.accounting.RemoteKeyServiceAsync
import dev.merge.api.services.async.accounting.SelectiveSyncServiceAsync
import dev.merge.api.services.async.accounting.SyncStatusServiceAsync
import dev.merge.api.services.async.accounting.TaxRateServiceAsync
import dev.merge.api.services.async.accounting.TrackingCategoryServiceAsync
import dev.merge.api.services.async.accounting.TransactionServiceAsync
import dev.merge.api.services.async.accounting.VendorCreditServiceAsync
import dev.merge.api.services.async.accounting.WebhookReceiverServiceAsync

interface AccountingServiceAsync {

    fun accounts(): AccountServiceAsync

    fun addresses(): AddressServiceAsync

    fun attachments(): AttachmentServiceAsync

    fun balanceSheets(): BalanceSheetServiceAsync

    fun cashFlowStatements(): CashFlowStatementServiceAsync

    fun companyInfo(): CompanyInfoServiceAsync

    fun contacts(): ContactServiceAsync

    fun creditNotes(): CreditNoteServiceAsync

    fun expenses(): ExpenseServiceAsync

    fun incomeStatements(): IncomeStatementServiceAsync

    fun invoices(): InvoiceServiceAsync

    fun items(): ItemServiceAsync

    fun journalEntries(): JournalEntryServiceAsync

    fun payments(): PaymentServiceAsync

    fun phoneNumbers(): PhoneNumberServiceAsync

    fun purchaseOrders(): PurchaseOrderServiceAsync

    fun taxRates(): TaxRateServiceAsync

    fun trackingCategories(): TrackingCategoryServiceAsync

    fun transactions(): TransactionServiceAsync

    fun vendorCredits(): VendorCreditServiceAsync

    fun accountDetails(): AccountDetailServiceAsync

    fun accountTokens(): AccountTokenServiceAsync

    fun linkTokens(): LinkTokenServiceAsync

    fun availableActions(): AvailableActionServiceAsync

    fun remoteKeys(): RemoteKeyServiceAsync

    fun issues(): IssueServiceAsync

    fun commonModelScopes(): CommonModelScopeServiceAsync

    fun passthroughRequests(): PassthroughRequestServiceAsync

    fun syncStatus(): SyncStatusServiceAsync

    fun webhookReceivers(): WebhookReceiverServiceAsync

    fun linkedAccounts(): LinkedAccountServiceAsync

    fun selectiveSync(): SelectiveSyncServiceAsync
}

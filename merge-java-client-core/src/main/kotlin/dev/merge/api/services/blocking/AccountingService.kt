@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking

import dev.merge.api.services.blocking.accounting.AccountDetailService
import dev.merge.api.services.blocking.accounting.AccountService
import dev.merge.api.services.blocking.accounting.AccountTokenService
import dev.merge.api.services.blocking.accounting.AddressService
import dev.merge.api.services.blocking.accounting.AttachmentService
import dev.merge.api.services.blocking.accounting.AvailableActionService
import dev.merge.api.services.blocking.accounting.BalanceSheetService
import dev.merge.api.services.blocking.accounting.CashFlowStatementService
import dev.merge.api.services.blocking.accounting.CommonModelScopeService
import dev.merge.api.services.blocking.accounting.CompanyInfoService
import dev.merge.api.services.blocking.accounting.ContactService
import dev.merge.api.services.blocking.accounting.CreditNoteService
import dev.merge.api.services.blocking.accounting.ExpenseService
import dev.merge.api.services.blocking.accounting.IncomeStatementService
import dev.merge.api.services.blocking.accounting.InvoiceService
import dev.merge.api.services.blocking.accounting.IssueService
import dev.merge.api.services.blocking.accounting.ItemService
import dev.merge.api.services.blocking.accounting.JournalEntryService
import dev.merge.api.services.blocking.accounting.LinkTokenService
import dev.merge.api.services.blocking.accounting.LinkedAccountService
import dev.merge.api.services.blocking.accounting.PassthroughRequestService
import dev.merge.api.services.blocking.accounting.PaymentService
import dev.merge.api.services.blocking.accounting.PhoneNumberService
import dev.merge.api.services.blocking.accounting.PurchaseOrderService
import dev.merge.api.services.blocking.accounting.RemoteKeyService
import dev.merge.api.services.blocking.accounting.SelectiveSyncService
import dev.merge.api.services.blocking.accounting.SyncStatusService
import dev.merge.api.services.blocking.accounting.TaxRateService
import dev.merge.api.services.blocking.accounting.TrackingCategoryService
import dev.merge.api.services.blocking.accounting.TransactionService
import dev.merge.api.services.blocking.accounting.VendorCreditService
import dev.merge.api.services.blocking.accounting.WebhookReceiverService

interface AccountingService {

    fun accounts(): AccountService

    fun addresses(): AddressService

    fun attachments(): AttachmentService

    fun balanceSheets(): BalanceSheetService

    fun cashFlowStatements(): CashFlowStatementService

    fun companyInfo(): CompanyInfoService

    fun contacts(): ContactService

    fun creditNotes(): CreditNoteService

    fun expenses(): ExpenseService

    fun incomeStatements(): IncomeStatementService

    fun invoices(): InvoiceService

    fun items(): ItemService

    fun journalEntries(): JournalEntryService

    fun payments(): PaymentService

    fun phoneNumbers(): PhoneNumberService

    fun purchaseOrders(): PurchaseOrderService

    fun taxRates(): TaxRateService

    fun trackingCategories(): TrackingCategoryService

    fun transactions(): TransactionService

    fun vendorCredits(): VendorCreditService

    fun accountDetails(): AccountDetailService

    fun accountTokens(): AccountTokenService

    fun linkTokens(): LinkTokenService

    fun availableActions(): AvailableActionService

    fun remoteKeys(): RemoteKeyService

    fun issues(): IssueService

    fun commonModelScopes(): CommonModelScopeService

    fun passthroughRequests(): PassthroughRequestService

    fun syncStatus(): SyncStatusService

    fun webhookReceivers(): WebhookReceiverService

    fun linkedAccounts(): LinkedAccountService

    fun selectiveSync(): SelectiveSyncService
}

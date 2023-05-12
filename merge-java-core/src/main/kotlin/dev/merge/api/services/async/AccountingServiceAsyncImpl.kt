package dev.merge.api.services.async

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.async.accounting.AccountDetailServiceAsync
import dev.merge.api.services.async.accounting.AccountDetailServiceAsyncImpl
import dev.merge.api.services.async.accounting.AccountServiceAsync
import dev.merge.api.services.async.accounting.AccountServiceAsyncImpl
import dev.merge.api.services.async.accounting.AccountTokenServiceAsync
import dev.merge.api.services.async.accounting.AccountTokenServiceAsyncImpl
import dev.merge.api.services.async.accounting.AddressServiceAsync
import dev.merge.api.services.async.accounting.AddressServiceAsyncImpl
import dev.merge.api.services.async.accounting.AttachmentServiceAsync
import dev.merge.api.services.async.accounting.AttachmentServiceAsyncImpl
import dev.merge.api.services.async.accounting.AvailableActionServiceAsync
import dev.merge.api.services.async.accounting.AvailableActionServiceAsyncImpl
import dev.merge.api.services.async.accounting.BalanceSheetServiceAsync
import dev.merge.api.services.async.accounting.BalanceSheetServiceAsyncImpl
import dev.merge.api.services.async.accounting.CashFlowStatementServiceAsync
import dev.merge.api.services.async.accounting.CashFlowStatementServiceAsyncImpl
import dev.merge.api.services.async.accounting.CommonModelScopeServiceAsync
import dev.merge.api.services.async.accounting.CommonModelScopeServiceAsyncImpl
import dev.merge.api.services.async.accounting.CompanyInfoServiceAsync
import dev.merge.api.services.async.accounting.CompanyInfoServiceAsyncImpl
import dev.merge.api.services.async.accounting.ContactServiceAsync
import dev.merge.api.services.async.accounting.ContactServiceAsyncImpl
import dev.merge.api.services.async.accounting.CreditNoteServiceAsync
import dev.merge.api.services.async.accounting.CreditNoteServiceAsyncImpl
import dev.merge.api.services.async.accounting.ExpenseServiceAsync
import dev.merge.api.services.async.accounting.ExpenseServiceAsyncImpl
import dev.merge.api.services.async.accounting.IncomeStatementServiceAsync
import dev.merge.api.services.async.accounting.IncomeStatementServiceAsyncImpl
import dev.merge.api.services.async.accounting.InvoiceServiceAsync
import dev.merge.api.services.async.accounting.InvoiceServiceAsyncImpl
import dev.merge.api.services.async.accounting.IssueServiceAsync
import dev.merge.api.services.async.accounting.IssueServiceAsyncImpl
import dev.merge.api.services.async.accounting.ItemServiceAsync
import dev.merge.api.services.async.accounting.ItemServiceAsyncImpl
import dev.merge.api.services.async.accounting.JournalEntryServiceAsync
import dev.merge.api.services.async.accounting.JournalEntryServiceAsyncImpl
import dev.merge.api.services.async.accounting.LinkTokenServiceAsync
import dev.merge.api.services.async.accounting.LinkTokenServiceAsyncImpl
import dev.merge.api.services.async.accounting.LinkedAccountServiceAsync
import dev.merge.api.services.async.accounting.LinkedAccountServiceAsyncImpl
import dev.merge.api.services.async.accounting.PassthroughRequestServiceAsync
import dev.merge.api.services.async.accounting.PassthroughRequestServiceAsyncImpl
import dev.merge.api.services.async.accounting.PaymentServiceAsync
import dev.merge.api.services.async.accounting.PaymentServiceAsyncImpl
import dev.merge.api.services.async.accounting.PhoneNumberServiceAsync
import dev.merge.api.services.async.accounting.PhoneNumberServiceAsyncImpl
import dev.merge.api.services.async.accounting.PurchaseOrderServiceAsync
import dev.merge.api.services.async.accounting.PurchaseOrderServiceAsyncImpl
import dev.merge.api.services.async.accounting.RemoteKeyServiceAsync
import dev.merge.api.services.async.accounting.RemoteKeyServiceAsyncImpl
import dev.merge.api.services.async.accounting.SelectiveSyncServiceAsync
import dev.merge.api.services.async.accounting.SelectiveSyncServiceAsyncImpl
import dev.merge.api.services.async.accounting.SyncStatusServiceAsync
import dev.merge.api.services.async.accounting.SyncStatusServiceAsyncImpl
import dev.merge.api.services.async.accounting.TaxRateServiceAsync
import dev.merge.api.services.async.accounting.TaxRateServiceAsyncImpl
import dev.merge.api.services.async.accounting.TrackingCategoryServiceAsync
import dev.merge.api.services.async.accounting.TrackingCategoryServiceAsyncImpl
import dev.merge.api.services.async.accounting.TransactionServiceAsync
import dev.merge.api.services.async.accounting.TransactionServiceAsyncImpl
import dev.merge.api.services.async.accounting.VendorCreditServiceAsync
import dev.merge.api.services.async.accounting.VendorCreditServiceAsyncImpl
import dev.merge.api.services.async.accounting.WebhookReceiverServiceAsync
import dev.merge.api.services.async.accounting.WebhookReceiverServiceAsyncImpl
import dev.merge.api.services.errorHandler

class AccountingServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AccountingServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val accounts: AccountServiceAsync by lazy { AccountServiceAsyncImpl(clientOptions) }

    private val addresses: AddressServiceAsync by lazy { AddressServiceAsyncImpl(clientOptions) }

    private val attachments: AttachmentServiceAsync by lazy {
        AttachmentServiceAsyncImpl(clientOptions)
    }

    private val balanceSheets: BalanceSheetServiceAsync by lazy {
        BalanceSheetServiceAsyncImpl(clientOptions)
    }

    private val cashFlowStatements: CashFlowStatementServiceAsync by lazy {
        CashFlowStatementServiceAsyncImpl(clientOptions)
    }

    private val companyInfo: CompanyInfoServiceAsync by lazy {
        CompanyInfoServiceAsyncImpl(clientOptions)
    }

    private val contacts: ContactServiceAsync by lazy { ContactServiceAsyncImpl(clientOptions) }

    private val creditNotes: CreditNoteServiceAsync by lazy {
        CreditNoteServiceAsyncImpl(clientOptions)
    }

    private val expenses: ExpenseServiceAsync by lazy { ExpenseServiceAsyncImpl(clientOptions) }

    private val incomeStatements: IncomeStatementServiceAsync by lazy {
        IncomeStatementServiceAsyncImpl(clientOptions)
    }

    private val invoices: InvoiceServiceAsync by lazy { InvoiceServiceAsyncImpl(clientOptions) }

    private val items: ItemServiceAsync by lazy { ItemServiceAsyncImpl(clientOptions) }

    private val journalEntries: JournalEntryServiceAsync by lazy {
        JournalEntryServiceAsyncImpl(clientOptions)
    }

    private val payments: PaymentServiceAsync by lazy { PaymentServiceAsyncImpl(clientOptions) }

    private val phoneNumbers: PhoneNumberServiceAsync by lazy {
        PhoneNumberServiceAsyncImpl(clientOptions)
    }

    private val purchaseOrders: PurchaseOrderServiceAsync by lazy {
        PurchaseOrderServiceAsyncImpl(clientOptions)
    }

    private val taxRates: TaxRateServiceAsync by lazy { TaxRateServiceAsyncImpl(clientOptions) }

    private val trackingCategories: TrackingCategoryServiceAsync by lazy {
        TrackingCategoryServiceAsyncImpl(clientOptions)
    }

    private val transactions: TransactionServiceAsync by lazy {
        TransactionServiceAsyncImpl(clientOptions)
    }

    private val vendorCredits: VendorCreditServiceAsync by lazy {
        VendorCreditServiceAsyncImpl(clientOptions)
    }

    private val accountDetails: AccountDetailServiceAsync by lazy {
        AccountDetailServiceAsyncImpl(clientOptions)
    }

    private val accountTokens: AccountTokenServiceAsync by lazy {
        AccountTokenServiceAsyncImpl(clientOptions)
    }

    private val linkTokens: LinkTokenServiceAsync by lazy {
        LinkTokenServiceAsyncImpl(clientOptions)
    }

    private val availableActions: AvailableActionServiceAsync by lazy {
        AvailableActionServiceAsyncImpl(clientOptions)
    }

    private val remoteKeys: RemoteKeyServiceAsync by lazy {
        RemoteKeyServiceAsyncImpl(clientOptions)
    }

    private val issues: IssueServiceAsync by lazy { IssueServiceAsyncImpl(clientOptions) }

    private val commonModelScopes: CommonModelScopeServiceAsync by lazy {
        CommonModelScopeServiceAsyncImpl(clientOptions)
    }

    private val passthroughRequests: PassthroughRequestServiceAsync by lazy {
        PassthroughRequestServiceAsyncImpl(clientOptions)
    }

    private val syncStatus: SyncStatusServiceAsync by lazy {
        SyncStatusServiceAsyncImpl(clientOptions)
    }

    private val webhookReceivers: WebhookReceiverServiceAsync by lazy {
        WebhookReceiverServiceAsyncImpl(clientOptions)
    }

    private val linkedAccounts: LinkedAccountServiceAsync by lazy {
        LinkedAccountServiceAsyncImpl(clientOptions)
    }

    private val selectiveSync: SelectiveSyncServiceAsync by lazy {
        SelectiveSyncServiceAsyncImpl(clientOptions)
    }

    override fun accounts(): AccountServiceAsync = accounts

    override fun addresses(): AddressServiceAsync = addresses

    override fun attachments(): AttachmentServiceAsync = attachments

    override fun balanceSheets(): BalanceSheetServiceAsync = balanceSheets

    override fun cashFlowStatements(): CashFlowStatementServiceAsync = cashFlowStatements

    override fun companyInfo(): CompanyInfoServiceAsync = companyInfo

    override fun contacts(): ContactServiceAsync = contacts

    override fun creditNotes(): CreditNoteServiceAsync = creditNotes

    override fun expenses(): ExpenseServiceAsync = expenses

    override fun incomeStatements(): IncomeStatementServiceAsync = incomeStatements

    override fun invoices(): InvoiceServiceAsync = invoices

    override fun items(): ItemServiceAsync = items

    override fun journalEntries(): JournalEntryServiceAsync = journalEntries

    override fun payments(): PaymentServiceAsync = payments

    override fun phoneNumbers(): PhoneNumberServiceAsync = phoneNumbers

    override fun purchaseOrders(): PurchaseOrderServiceAsync = purchaseOrders

    override fun taxRates(): TaxRateServiceAsync = taxRates

    override fun trackingCategories(): TrackingCategoryServiceAsync = trackingCategories

    override fun transactions(): TransactionServiceAsync = transactions

    override fun vendorCredits(): VendorCreditServiceAsync = vendorCredits

    override fun accountDetails(): AccountDetailServiceAsync = accountDetails

    override fun accountTokens(): AccountTokenServiceAsync = accountTokens

    override fun linkTokens(): LinkTokenServiceAsync = linkTokens

    override fun availableActions(): AvailableActionServiceAsync = availableActions

    override fun remoteKeys(): RemoteKeyServiceAsync = remoteKeys

    override fun issues(): IssueServiceAsync = issues

    override fun commonModelScopes(): CommonModelScopeServiceAsync = commonModelScopes

    override fun passthroughRequests(): PassthroughRequestServiceAsync = passthroughRequests

    override fun syncStatus(): SyncStatusServiceAsync = syncStatus

    override fun webhookReceivers(): WebhookReceiverServiceAsync = webhookReceivers

    override fun linkedAccounts(): LinkedAccountServiceAsync = linkedAccounts

    override fun selectiveSync(): SelectiveSyncServiceAsync = selectiveSync
}

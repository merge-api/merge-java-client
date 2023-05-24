package dev.merge.api.services.blocking

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.blocking.accounting.AccountDetailService
import dev.merge.api.services.blocking.accounting.AccountDetailServiceImpl
import dev.merge.api.services.blocking.accounting.AccountService
import dev.merge.api.services.blocking.accounting.AccountServiceImpl
import dev.merge.api.services.blocking.accounting.AccountTokenService
import dev.merge.api.services.blocking.accounting.AccountTokenServiceImpl
import dev.merge.api.services.blocking.accounting.AddressService
import dev.merge.api.services.blocking.accounting.AddressServiceImpl
import dev.merge.api.services.blocking.accounting.AttachmentService
import dev.merge.api.services.blocking.accounting.AttachmentServiceImpl
import dev.merge.api.services.blocking.accounting.AvailableActionService
import dev.merge.api.services.blocking.accounting.AvailableActionServiceImpl
import dev.merge.api.services.blocking.accounting.BalanceSheetService
import dev.merge.api.services.blocking.accounting.BalanceSheetServiceImpl
import dev.merge.api.services.blocking.accounting.CashFlowStatementService
import dev.merge.api.services.blocking.accounting.CashFlowStatementServiceImpl
import dev.merge.api.services.blocking.accounting.CommonModelScopeService
import dev.merge.api.services.blocking.accounting.CommonModelScopeServiceImpl
import dev.merge.api.services.blocking.accounting.CompanyInfoService
import dev.merge.api.services.blocking.accounting.CompanyInfoServiceImpl
import dev.merge.api.services.blocking.accounting.ContactService
import dev.merge.api.services.blocking.accounting.ContactServiceImpl
import dev.merge.api.services.blocking.accounting.CreditNoteService
import dev.merge.api.services.blocking.accounting.CreditNoteServiceImpl
import dev.merge.api.services.blocking.accounting.ExpenseService
import dev.merge.api.services.blocking.accounting.ExpenseServiceImpl
import dev.merge.api.services.blocking.accounting.IncomeStatementService
import dev.merge.api.services.blocking.accounting.IncomeStatementServiceImpl
import dev.merge.api.services.blocking.accounting.InvoiceService
import dev.merge.api.services.blocking.accounting.InvoiceServiceImpl
import dev.merge.api.services.blocking.accounting.IssueService
import dev.merge.api.services.blocking.accounting.IssueServiceImpl
import dev.merge.api.services.blocking.accounting.ItemService
import dev.merge.api.services.blocking.accounting.ItemServiceImpl
import dev.merge.api.services.blocking.accounting.JournalEntryService
import dev.merge.api.services.blocking.accounting.JournalEntryServiceImpl
import dev.merge.api.services.blocking.accounting.LinkTokenService
import dev.merge.api.services.blocking.accounting.LinkTokenServiceImpl
import dev.merge.api.services.blocking.accounting.LinkedAccountService
import dev.merge.api.services.blocking.accounting.LinkedAccountServiceImpl
import dev.merge.api.services.blocking.accounting.PassthroughRequestService
import dev.merge.api.services.blocking.accounting.PassthroughRequestServiceImpl
import dev.merge.api.services.blocking.accounting.PaymentService
import dev.merge.api.services.blocking.accounting.PaymentServiceImpl
import dev.merge.api.services.blocking.accounting.PhoneNumberService
import dev.merge.api.services.blocking.accounting.PhoneNumberServiceImpl
import dev.merge.api.services.blocking.accounting.PurchaseOrderService
import dev.merge.api.services.blocking.accounting.PurchaseOrderServiceImpl
import dev.merge.api.services.blocking.accounting.RemoteKeyService
import dev.merge.api.services.blocking.accounting.RemoteKeyServiceImpl
import dev.merge.api.services.blocking.accounting.SelectiveSyncService
import dev.merge.api.services.blocking.accounting.SelectiveSyncServiceImpl
import dev.merge.api.services.blocking.accounting.SyncStatusService
import dev.merge.api.services.blocking.accounting.SyncStatusServiceImpl
import dev.merge.api.services.blocking.accounting.TaxRateService
import dev.merge.api.services.blocking.accounting.TaxRateServiceImpl
import dev.merge.api.services.blocking.accounting.TrackingCategoryService
import dev.merge.api.services.blocking.accounting.TrackingCategoryServiceImpl
import dev.merge.api.services.blocking.accounting.TransactionService
import dev.merge.api.services.blocking.accounting.TransactionServiceImpl
import dev.merge.api.services.blocking.accounting.VendorCreditService
import dev.merge.api.services.blocking.accounting.VendorCreditServiceImpl
import dev.merge.api.services.blocking.accounting.WebhookReceiverService
import dev.merge.api.services.blocking.accounting.WebhookReceiverServiceImpl
import dev.merge.api.services.errorHandler

class AccountingServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AccountingService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptions) }

    private val addresses: AddressService by lazy { AddressServiceImpl(clientOptions) }

    private val attachments: AttachmentService by lazy { AttachmentServiceImpl(clientOptions) }

    private val balanceSheets: BalanceSheetService by lazy {
        BalanceSheetServiceImpl(clientOptions)
    }

    private val cashFlowStatements: CashFlowStatementService by lazy {
        CashFlowStatementServiceImpl(clientOptions)
    }

    private val companyInfo: CompanyInfoService by lazy { CompanyInfoServiceImpl(clientOptions) }

    private val contacts: ContactService by lazy { ContactServiceImpl(clientOptions) }

    private val creditNotes: CreditNoteService by lazy { CreditNoteServiceImpl(clientOptions) }

    private val expenses: ExpenseService by lazy { ExpenseServiceImpl(clientOptions) }

    private val incomeStatements: IncomeStatementService by lazy {
        IncomeStatementServiceImpl(clientOptions)
    }

    private val invoices: InvoiceService by lazy { InvoiceServiceImpl(clientOptions) }

    private val items: ItemService by lazy { ItemServiceImpl(clientOptions) }

    private val journalEntries: JournalEntryService by lazy {
        JournalEntryServiceImpl(clientOptions)
    }

    private val payments: PaymentService by lazy { PaymentServiceImpl(clientOptions) }

    private val phoneNumbers: PhoneNumberService by lazy { PhoneNumberServiceImpl(clientOptions) }

    private val purchaseOrders: PurchaseOrderService by lazy {
        PurchaseOrderServiceImpl(clientOptions)
    }

    private val taxRates: TaxRateService by lazy { TaxRateServiceImpl(clientOptions) }

    private val trackingCategories: TrackingCategoryService by lazy {
        TrackingCategoryServiceImpl(clientOptions)
    }

    private val transactions: TransactionService by lazy { TransactionServiceImpl(clientOptions) }

    private val vendorCredits: VendorCreditService by lazy {
        VendorCreditServiceImpl(clientOptions)
    }

    private val accountDetails: AccountDetailService by lazy {
        AccountDetailServiceImpl(clientOptions)
    }

    private val accountTokens: AccountTokenService by lazy {
        AccountTokenServiceImpl(clientOptions)
    }

    private val linkTokens: LinkTokenService by lazy { LinkTokenServiceImpl(clientOptions) }

    private val availableActions: AvailableActionService by lazy {
        AvailableActionServiceImpl(clientOptions)
    }

    private val remoteKeys: RemoteKeyService by lazy { RemoteKeyServiceImpl(clientOptions) }

    private val issues: IssueService by lazy { IssueServiceImpl(clientOptions) }

    private val commonModelScopes: CommonModelScopeService by lazy {
        CommonModelScopeServiceImpl(clientOptions)
    }

    private val passthroughRequests: PassthroughRequestService by lazy {
        PassthroughRequestServiceImpl(clientOptions)
    }

    private val syncStatus: SyncStatusService by lazy { SyncStatusServiceImpl(clientOptions) }

    private val webhookReceivers: WebhookReceiverService by lazy {
        WebhookReceiverServiceImpl(clientOptions)
    }

    private val linkedAccounts: LinkedAccountService by lazy {
        LinkedAccountServiceImpl(clientOptions)
    }

    private val selectiveSync: SelectiveSyncService by lazy {
        SelectiveSyncServiceImpl(clientOptions)
    }

    override fun accounts(): AccountService = accounts

    override fun addresses(): AddressService = addresses

    override fun attachments(): AttachmentService = attachments

    override fun balanceSheets(): BalanceSheetService = balanceSheets

    override fun cashFlowStatements(): CashFlowStatementService = cashFlowStatements

    override fun companyInfo(): CompanyInfoService = companyInfo

    override fun contacts(): ContactService = contacts

    override fun creditNotes(): CreditNoteService = creditNotes

    override fun expenses(): ExpenseService = expenses

    override fun incomeStatements(): IncomeStatementService = incomeStatements

    override fun invoices(): InvoiceService = invoices

    override fun items(): ItemService = items

    override fun journalEntries(): JournalEntryService = journalEntries

    override fun payments(): PaymentService = payments

    override fun phoneNumbers(): PhoneNumberService = phoneNumbers

    override fun purchaseOrders(): PurchaseOrderService = purchaseOrders

    override fun taxRates(): TaxRateService = taxRates

    override fun trackingCategories(): TrackingCategoryService = trackingCategories

    override fun transactions(): TransactionService = transactions

    override fun vendorCredits(): VendorCreditService = vendorCredits

    override fun accountDetails(): AccountDetailService = accountDetails

    override fun accountTokens(): AccountTokenService = accountTokens

    override fun linkTokens(): LinkTokenService = linkTokens

    override fun availableActions(): AvailableActionService = availableActions

    override fun remoteKeys(): RemoteKeyService = remoteKeys

    override fun issues(): IssueService = issues

    override fun commonModelScopes(): CommonModelScopeService = commonModelScopes

    override fun passthroughRequests(): PassthroughRequestService = passthroughRequests

    override fun syncStatus(): SyncStatusService = syncStatus

    override fun webhookReceivers(): WebhookReceiverService = webhookReceivers

    override fun linkedAccounts(): LinkedAccountService = linkedAccounts

    override fun selectiveSync(): SelectiveSyncService = selectiveSync
}

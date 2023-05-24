package dev.merge.api.services.async

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.async.hris.AccountDetailServiceAsync
import dev.merge.api.services.async.hris.AccountDetailServiceAsyncImpl
import dev.merge.api.services.async.hris.AccountTokenServiceAsync
import dev.merge.api.services.async.hris.AccountTokenServiceAsyncImpl
import dev.merge.api.services.async.hris.AvailableActionServiceAsync
import dev.merge.api.services.async.hris.AvailableActionServiceAsyncImpl
import dev.merge.api.services.async.hris.BankServiceAsync
import dev.merge.api.services.async.hris.BankServiceAsyncImpl
import dev.merge.api.services.async.hris.BenefitServiceAsync
import dev.merge.api.services.async.hris.BenefitServiceAsyncImpl
import dev.merge.api.services.async.hris.CommonModelScopeServiceAsync
import dev.merge.api.services.async.hris.CommonModelScopeServiceAsyncImpl
import dev.merge.api.services.async.hris.CompanyServiceAsync
import dev.merge.api.services.async.hris.CompanyServiceAsyncImpl
import dev.merge.api.services.async.hris.EmployeePayrollRunServiceAsync
import dev.merge.api.services.async.hris.EmployeePayrollRunServiceAsyncImpl
import dev.merge.api.services.async.hris.EmployeeServiceAsync
import dev.merge.api.services.async.hris.EmployeeServiceAsyncImpl
import dev.merge.api.services.async.hris.EmploymentServiceAsync
import dev.merge.api.services.async.hris.EmploymentServiceAsyncImpl
import dev.merge.api.services.async.hris.GroupServiceAsync
import dev.merge.api.services.async.hris.GroupServiceAsyncImpl
import dev.merge.api.services.async.hris.IssueServiceAsync
import dev.merge.api.services.async.hris.IssueServiceAsyncImpl
import dev.merge.api.services.async.hris.LinkTokenServiceAsync
import dev.merge.api.services.async.hris.LinkTokenServiceAsyncImpl
import dev.merge.api.services.async.hris.LinkedAccountServiceAsync
import dev.merge.api.services.async.hris.LinkedAccountServiceAsyncImpl
import dev.merge.api.services.async.hris.LocationServiceAsync
import dev.merge.api.services.async.hris.LocationServiceAsyncImpl
import dev.merge.api.services.async.hris.PassthroughRequestServiceAsync
import dev.merge.api.services.async.hris.PassthroughRequestServiceAsyncImpl
import dev.merge.api.services.async.hris.PayGroupServiceAsync
import dev.merge.api.services.async.hris.PayGroupServiceAsyncImpl
import dev.merge.api.services.async.hris.PayrollRunServiceAsync
import dev.merge.api.services.async.hris.PayrollRunServiceAsyncImpl
import dev.merge.api.services.async.hris.RemoteKeyServiceAsync
import dev.merge.api.services.async.hris.RemoteKeyServiceAsyncImpl
import dev.merge.api.services.async.hris.SelectiveSyncServiceAsync
import dev.merge.api.services.async.hris.SelectiveSyncServiceAsyncImpl
import dev.merge.api.services.async.hris.SyncStatusServiceAsync
import dev.merge.api.services.async.hris.SyncStatusServiceAsyncImpl
import dev.merge.api.services.async.hris.TeamServiceAsync
import dev.merge.api.services.async.hris.TeamServiceAsyncImpl
import dev.merge.api.services.async.hris.TimeOffBalanceServiceAsync
import dev.merge.api.services.async.hris.TimeOffBalanceServiceAsyncImpl
import dev.merge.api.services.async.hris.TimeOffServiceAsync
import dev.merge.api.services.async.hris.TimeOffServiceAsyncImpl
import dev.merge.api.services.async.hris.WebhookReceiverServiceAsync
import dev.merge.api.services.async.hris.WebhookReceiverServiceAsyncImpl
import dev.merge.api.services.errorHandler

class HrisServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : HrisServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val banks: BankServiceAsync by lazy { BankServiceAsyncImpl(clientOptions) }

    private val benefits: BenefitServiceAsync by lazy { BenefitServiceAsyncImpl(clientOptions) }

    private val companies: CompanyServiceAsync by lazy { CompanyServiceAsyncImpl(clientOptions) }

    private val employeePayrollRuns: EmployeePayrollRunServiceAsync by lazy {
        EmployeePayrollRunServiceAsyncImpl(clientOptions)
    }

    private val employees: EmployeeServiceAsync by lazy { EmployeeServiceAsyncImpl(clientOptions) }

    private val employments: EmploymentServiceAsync by lazy {
        EmploymentServiceAsyncImpl(clientOptions)
    }

    private val groups: GroupServiceAsync by lazy { GroupServiceAsyncImpl(clientOptions) }

    private val locations: LocationServiceAsync by lazy { LocationServiceAsyncImpl(clientOptions) }

    private val payGroups: PayGroupServiceAsync by lazy { PayGroupServiceAsyncImpl(clientOptions) }

    private val payrollRuns: PayrollRunServiceAsync by lazy {
        PayrollRunServiceAsyncImpl(clientOptions)
    }

    private val teams: TeamServiceAsync by lazy { TeamServiceAsyncImpl(clientOptions) }

    private val timeOff: TimeOffServiceAsync by lazy { TimeOffServiceAsyncImpl(clientOptions) }

    private val timeOffBalances: TimeOffBalanceServiceAsync by lazy {
        TimeOffBalanceServiceAsyncImpl(clientOptions)
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

    override fun banks(): BankServiceAsync = banks

    override fun benefits(): BenefitServiceAsync = benefits

    override fun companies(): CompanyServiceAsync = companies

    override fun employeePayrollRuns(): EmployeePayrollRunServiceAsync = employeePayrollRuns

    override fun employees(): EmployeeServiceAsync = employees

    override fun employments(): EmploymentServiceAsync = employments

    override fun groups(): GroupServiceAsync = groups

    override fun locations(): LocationServiceAsync = locations

    override fun payGroups(): PayGroupServiceAsync = payGroups

    override fun payrollRuns(): PayrollRunServiceAsync = payrollRuns

    override fun teams(): TeamServiceAsync = teams

    override fun timeOff(): TimeOffServiceAsync = timeOff

    override fun timeOffBalances(): TimeOffBalanceServiceAsync = timeOffBalances

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

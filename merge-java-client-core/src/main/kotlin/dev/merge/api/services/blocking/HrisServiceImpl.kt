package dev.merge.api.services.blocking

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.blocking.hris.AccountDetailService
import dev.merge.api.services.blocking.hris.AccountDetailServiceImpl
import dev.merge.api.services.blocking.hris.AccountTokenService
import dev.merge.api.services.blocking.hris.AccountTokenServiceImpl
import dev.merge.api.services.blocking.hris.AvailableActionService
import dev.merge.api.services.blocking.hris.AvailableActionServiceImpl
import dev.merge.api.services.blocking.hris.BankService
import dev.merge.api.services.blocking.hris.BankServiceImpl
import dev.merge.api.services.blocking.hris.BenefitService
import dev.merge.api.services.blocking.hris.BenefitServiceImpl
import dev.merge.api.services.blocking.hris.CommonModelScopeService
import dev.merge.api.services.blocking.hris.CommonModelScopeServiceImpl
import dev.merge.api.services.blocking.hris.CompanyService
import dev.merge.api.services.blocking.hris.CompanyServiceImpl
import dev.merge.api.services.blocking.hris.EmployeePayrollRunService
import dev.merge.api.services.blocking.hris.EmployeePayrollRunServiceImpl
import dev.merge.api.services.blocking.hris.EmployeeService
import dev.merge.api.services.blocking.hris.EmployeeServiceImpl
import dev.merge.api.services.blocking.hris.EmploymentService
import dev.merge.api.services.blocking.hris.EmploymentServiceImpl
import dev.merge.api.services.blocking.hris.GroupService
import dev.merge.api.services.blocking.hris.GroupServiceImpl
import dev.merge.api.services.blocking.hris.IssueService
import dev.merge.api.services.blocking.hris.IssueServiceImpl
import dev.merge.api.services.blocking.hris.LinkTokenService
import dev.merge.api.services.blocking.hris.LinkTokenServiceImpl
import dev.merge.api.services.blocking.hris.LinkedAccountService
import dev.merge.api.services.blocking.hris.LinkedAccountServiceImpl
import dev.merge.api.services.blocking.hris.LocationService
import dev.merge.api.services.blocking.hris.LocationServiceImpl
import dev.merge.api.services.blocking.hris.PassthroughRequestService
import dev.merge.api.services.blocking.hris.PassthroughRequestServiceImpl
import dev.merge.api.services.blocking.hris.PayGroupService
import dev.merge.api.services.blocking.hris.PayGroupServiceImpl
import dev.merge.api.services.blocking.hris.PayrollRunService
import dev.merge.api.services.blocking.hris.PayrollRunServiceImpl
import dev.merge.api.services.blocking.hris.RemoteKeyService
import dev.merge.api.services.blocking.hris.RemoteKeyServiceImpl
import dev.merge.api.services.blocking.hris.SelectiveSyncService
import dev.merge.api.services.blocking.hris.SelectiveSyncServiceImpl
import dev.merge.api.services.blocking.hris.SyncStatusService
import dev.merge.api.services.blocking.hris.SyncStatusServiceImpl
import dev.merge.api.services.blocking.hris.TeamService
import dev.merge.api.services.blocking.hris.TeamServiceImpl
import dev.merge.api.services.blocking.hris.TimeOffBalanceService
import dev.merge.api.services.blocking.hris.TimeOffBalanceServiceImpl
import dev.merge.api.services.blocking.hris.TimeOffService
import dev.merge.api.services.blocking.hris.TimeOffServiceImpl
import dev.merge.api.services.blocking.hris.WebhookReceiverService
import dev.merge.api.services.blocking.hris.WebhookReceiverServiceImpl
import dev.merge.api.services.errorHandler

class HrisServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : HrisService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val banks: BankService by lazy { BankServiceImpl(clientOptions) }

    private val benefits: BenefitService by lazy { BenefitServiceImpl(clientOptions) }

    private val companies: CompanyService by lazy { CompanyServiceImpl(clientOptions) }

    private val employeePayrollRuns: EmployeePayrollRunService by lazy {
        EmployeePayrollRunServiceImpl(clientOptions)
    }

    private val employees: EmployeeService by lazy { EmployeeServiceImpl(clientOptions) }

    private val employments: EmploymentService by lazy { EmploymentServiceImpl(clientOptions) }

    private val groups: GroupService by lazy { GroupServiceImpl(clientOptions) }

    private val locations: LocationService by lazy { LocationServiceImpl(clientOptions) }

    private val payGroups: PayGroupService by lazy { PayGroupServiceImpl(clientOptions) }

    private val payrollRuns: PayrollRunService by lazy { PayrollRunServiceImpl(clientOptions) }

    private val teams: TeamService by lazy { TeamServiceImpl(clientOptions) }

    private val timeOff: TimeOffService by lazy { TimeOffServiceImpl(clientOptions) }

    private val timeOffBalances: TimeOffBalanceService by lazy {
        TimeOffBalanceServiceImpl(clientOptions)
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

    override fun banks(): BankService = banks

    override fun benefits(): BenefitService = benefits

    override fun companies(): CompanyService = companies

    override fun employeePayrollRuns(): EmployeePayrollRunService = employeePayrollRuns

    override fun employees(): EmployeeService = employees

    override fun employments(): EmploymentService = employments

    override fun groups(): GroupService = groups

    override fun locations(): LocationService = locations

    override fun payGroups(): PayGroupService = payGroups

    override fun payrollRuns(): PayrollRunService = payrollRuns

    override fun teams(): TeamService = teams

    override fun timeOff(): TimeOffService = timeOff

    override fun timeOffBalances(): TimeOffBalanceService = timeOffBalances

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

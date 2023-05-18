@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking

import dev.merge.api.services.blocking.hris.AccountDetailService
import dev.merge.api.services.blocking.hris.AccountTokenService
import dev.merge.api.services.blocking.hris.AvailableActionService
import dev.merge.api.services.blocking.hris.BankService
import dev.merge.api.services.blocking.hris.BenefitService
import dev.merge.api.services.blocking.hris.CommonModelScopeService
import dev.merge.api.services.blocking.hris.CompanyService
import dev.merge.api.services.blocking.hris.EmployeePayrollRunService
import dev.merge.api.services.blocking.hris.EmployeeService
import dev.merge.api.services.blocking.hris.EmploymentService
import dev.merge.api.services.blocking.hris.GroupService
import dev.merge.api.services.blocking.hris.IssueService
import dev.merge.api.services.blocking.hris.LinkTokenService
import dev.merge.api.services.blocking.hris.LinkedAccountService
import dev.merge.api.services.blocking.hris.LocationService
import dev.merge.api.services.blocking.hris.PassthroughRequestService
import dev.merge.api.services.blocking.hris.PayGroupService
import dev.merge.api.services.blocking.hris.PayrollRunService
import dev.merge.api.services.blocking.hris.RemoteKeyService
import dev.merge.api.services.blocking.hris.SelectiveSyncService
import dev.merge.api.services.blocking.hris.SyncStatusService
import dev.merge.api.services.blocking.hris.TeamService
import dev.merge.api.services.blocking.hris.TimeOffBalanceService
import dev.merge.api.services.blocking.hris.TimeOffService
import dev.merge.api.services.blocking.hris.WebhookReceiverService

interface HrisService {

    fun banks(): BankService

    fun benefits(): BenefitService

    fun companies(): CompanyService

    fun employeePayrollRuns(): EmployeePayrollRunService

    fun employees(): EmployeeService

    fun employments(): EmploymentService

    fun groups(): GroupService

    fun locations(): LocationService

    fun payGroups(): PayGroupService

    fun payrollRuns(): PayrollRunService

    fun teams(): TeamService

    fun timeOff(): TimeOffService

    fun timeOffBalances(): TimeOffBalanceService

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

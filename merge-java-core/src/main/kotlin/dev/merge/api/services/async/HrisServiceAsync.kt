@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async

import dev.merge.api.services.async.hris.AccountDetailServiceAsync
import dev.merge.api.services.async.hris.AccountTokenServiceAsync
import dev.merge.api.services.async.hris.AvailableActionServiceAsync
import dev.merge.api.services.async.hris.BankServiceAsync
import dev.merge.api.services.async.hris.BenefitServiceAsync
import dev.merge.api.services.async.hris.CommonModelScopeServiceAsync
import dev.merge.api.services.async.hris.CompanyServiceAsync
import dev.merge.api.services.async.hris.EmployeePayrollRunServiceAsync
import dev.merge.api.services.async.hris.EmployeeServiceAsync
import dev.merge.api.services.async.hris.EmploymentServiceAsync
import dev.merge.api.services.async.hris.GroupServiceAsync
import dev.merge.api.services.async.hris.IssueServiceAsync
import dev.merge.api.services.async.hris.LinkTokenServiceAsync
import dev.merge.api.services.async.hris.LinkedAccountServiceAsync
import dev.merge.api.services.async.hris.LocationServiceAsync
import dev.merge.api.services.async.hris.PassthroughRequestServiceAsync
import dev.merge.api.services.async.hris.PayGroupServiceAsync
import dev.merge.api.services.async.hris.PayrollRunServiceAsync
import dev.merge.api.services.async.hris.RemoteKeyServiceAsync
import dev.merge.api.services.async.hris.SelectiveSyncServiceAsync
import dev.merge.api.services.async.hris.SyncStatusServiceAsync
import dev.merge.api.services.async.hris.TeamServiceAsync
import dev.merge.api.services.async.hris.TimeOffBalanceServiceAsync
import dev.merge.api.services.async.hris.TimeOffServiceAsync
import dev.merge.api.services.async.hris.WebhookReceiverServiceAsync

interface HrisServiceAsync {

    fun banks(): BankServiceAsync

    fun benefits(): BenefitServiceAsync

    fun companies(): CompanyServiceAsync

    fun employeePayrollRuns(): EmployeePayrollRunServiceAsync

    fun employees(): EmployeeServiceAsync

    fun employments(): EmploymentServiceAsync

    fun groups(): GroupServiceAsync

    fun locations(): LocationServiceAsync

    fun payGroups(): PayGroupServiceAsync

    fun payrollRuns(): PayrollRunServiceAsync

    fun teams(): TeamServiceAsync

    fun timeOff(): TimeOffServiceAsync

    fun timeOffBalances(): TimeOffBalanceServiceAsync

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

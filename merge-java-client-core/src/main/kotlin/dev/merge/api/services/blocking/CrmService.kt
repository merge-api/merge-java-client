@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking

import dev.merge.api.services.blocking.crm.AccountDetailService
import dev.merge.api.services.blocking.crm.AccountService
import dev.merge.api.services.blocking.crm.AccountTokenService
import dev.merge.api.services.blocking.crm.AvailableActionService
import dev.merge.api.services.blocking.crm.CommonModelScopeService
import dev.merge.api.services.blocking.crm.ContactService
import dev.merge.api.services.blocking.crm.CustomObjectClassService
import dev.merge.api.services.blocking.crm.CustomObjectService
import dev.merge.api.services.blocking.crm.EngagementService
import dev.merge.api.services.blocking.crm.EngagementTypeService
import dev.merge.api.services.blocking.crm.IssueService
import dev.merge.api.services.blocking.crm.LeadService
import dev.merge.api.services.blocking.crm.LinkTokenService
import dev.merge.api.services.blocking.crm.LinkedAccountService
import dev.merge.api.services.blocking.crm.NoteService
import dev.merge.api.services.blocking.crm.OpportunityService
import dev.merge.api.services.blocking.crm.PassthroughRequestService
import dev.merge.api.services.blocking.crm.RemoteKeyService
import dev.merge.api.services.blocking.crm.SelectiveSyncService
import dev.merge.api.services.blocking.crm.StageService
import dev.merge.api.services.blocking.crm.SyncStatusService
import dev.merge.api.services.blocking.crm.TaskService
import dev.merge.api.services.blocking.crm.UserService
import dev.merge.api.services.blocking.crm.WebhookReceiverService

interface CrmService {

    fun accounts(): AccountService

    fun contacts(): ContactService

    fun customObjectClasses(): CustomObjectClassService

    fun customObjects(): CustomObjectService

    fun engagementTypes(): EngagementTypeService

    fun engagements(): EngagementService

    fun leads(): LeadService

    fun notes(): NoteService

    fun opportunities(): OpportunityService

    fun stages(): StageService

    fun tasks(): TaskService

    fun users(): UserService

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

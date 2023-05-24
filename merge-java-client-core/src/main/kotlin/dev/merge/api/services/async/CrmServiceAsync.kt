@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async

import dev.merge.api.services.async.crm.AccountDetailServiceAsync
import dev.merge.api.services.async.crm.AccountServiceAsync
import dev.merge.api.services.async.crm.AccountTokenServiceAsync
import dev.merge.api.services.async.crm.AvailableActionServiceAsync
import dev.merge.api.services.async.crm.CommonModelScopeServiceAsync
import dev.merge.api.services.async.crm.ContactServiceAsync
import dev.merge.api.services.async.crm.CustomObjectClassServiceAsync
import dev.merge.api.services.async.crm.CustomObjectServiceAsync
import dev.merge.api.services.async.crm.EngagementServiceAsync
import dev.merge.api.services.async.crm.EngagementTypeServiceAsync
import dev.merge.api.services.async.crm.IssueServiceAsync
import dev.merge.api.services.async.crm.LeadServiceAsync
import dev.merge.api.services.async.crm.LinkTokenServiceAsync
import dev.merge.api.services.async.crm.LinkedAccountServiceAsync
import dev.merge.api.services.async.crm.NoteServiceAsync
import dev.merge.api.services.async.crm.OpportunityServiceAsync
import dev.merge.api.services.async.crm.PassthroughRequestServiceAsync
import dev.merge.api.services.async.crm.RemoteKeyServiceAsync
import dev.merge.api.services.async.crm.SelectiveSyncServiceAsync
import dev.merge.api.services.async.crm.StageServiceAsync
import dev.merge.api.services.async.crm.SyncStatusServiceAsync
import dev.merge.api.services.async.crm.TaskServiceAsync
import dev.merge.api.services.async.crm.UserServiceAsync
import dev.merge.api.services.async.crm.WebhookReceiverServiceAsync

interface CrmServiceAsync {

    fun accounts(): AccountServiceAsync

    fun contacts(): ContactServiceAsync

    fun customObjectClasses(): CustomObjectClassServiceAsync

    fun customObjects(): CustomObjectServiceAsync

    fun engagementTypes(): EngagementTypeServiceAsync

    fun engagements(): EngagementServiceAsync

    fun leads(): LeadServiceAsync

    fun notes(): NoteServiceAsync

    fun opportunities(): OpportunityServiceAsync

    fun stages(): StageServiceAsync

    fun tasks(): TaskServiceAsync

    fun users(): UserServiceAsync

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

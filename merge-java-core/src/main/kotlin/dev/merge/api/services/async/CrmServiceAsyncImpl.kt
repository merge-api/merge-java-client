package dev.merge.api.services.async

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.async.crm.AccountDetailServiceAsync
import dev.merge.api.services.async.crm.AccountDetailServiceAsyncImpl
import dev.merge.api.services.async.crm.AccountServiceAsync
import dev.merge.api.services.async.crm.AccountServiceAsyncImpl
import dev.merge.api.services.async.crm.AccountTokenServiceAsync
import dev.merge.api.services.async.crm.AccountTokenServiceAsyncImpl
import dev.merge.api.services.async.crm.AvailableActionServiceAsync
import dev.merge.api.services.async.crm.AvailableActionServiceAsyncImpl
import dev.merge.api.services.async.crm.CommonModelScopeServiceAsync
import dev.merge.api.services.async.crm.CommonModelScopeServiceAsyncImpl
import dev.merge.api.services.async.crm.ContactServiceAsync
import dev.merge.api.services.async.crm.ContactServiceAsyncImpl
import dev.merge.api.services.async.crm.CustomObjectClassServiceAsync
import dev.merge.api.services.async.crm.CustomObjectClassServiceAsyncImpl
import dev.merge.api.services.async.crm.CustomObjectServiceAsync
import dev.merge.api.services.async.crm.CustomObjectServiceAsyncImpl
import dev.merge.api.services.async.crm.EngagementServiceAsync
import dev.merge.api.services.async.crm.EngagementServiceAsyncImpl
import dev.merge.api.services.async.crm.EngagementTypeServiceAsync
import dev.merge.api.services.async.crm.EngagementTypeServiceAsyncImpl
import dev.merge.api.services.async.crm.IssueServiceAsync
import dev.merge.api.services.async.crm.IssueServiceAsyncImpl
import dev.merge.api.services.async.crm.LeadServiceAsync
import dev.merge.api.services.async.crm.LeadServiceAsyncImpl
import dev.merge.api.services.async.crm.LinkTokenServiceAsync
import dev.merge.api.services.async.crm.LinkTokenServiceAsyncImpl
import dev.merge.api.services.async.crm.LinkedAccountServiceAsync
import dev.merge.api.services.async.crm.LinkedAccountServiceAsyncImpl
import dev.merge.api.services.async.crm.NoteServiceAsync
import dev.merge.api.services.async.crm.NoteServiceAsyncImpl
import dev.merge.api.services.async.crm.OpportunityServiceAsync
import dev.merge.api.services.async.crm.OpportunityServiceAsyncImpl
import dev.merge.api.services.async.crm.PassthroughRequestServiceAsync
import dev.merge.api.services.async.crm.PassthroughRequestServiceAsyncImpl
import dev.merge.api.services.async.crm.RemoteKeyServiceAsync
import dev.merge.api.services.async.crm.RemoteKeyServiceAsyncImpl
import dev.merge.api.services.async.crm.SelectiveSyncServiceAsync
import dev.merge.api.services.async.crm.SelectiveSyncServiceAsyncImpl
import dev.merge.api.services.async.crm.StageServiceAsync
import dev.merge.api.services.async.crm.StageServiceAsyncImpl
import dev.merge.api.services.async.crm.SyncStatusServiceAsync
import dev.merge.api.services.async.crm.SyncStatusServiceAsyncImpl
import dev.merge.api.services.async.crm.TaskServiceAsync
import dev.merge.api.services.async.crm.TaskServiceAsyncImpl
import dev.merge.api.services.async.crm.UserServiceAsync
import dev.merge.api.services.async.crm.UserServiceAsyncImpl
import dev.merge.api.services.async.crm.WebhookReceiverServiceAsync
import dev.merge.api.services.async.crm.WebhookReceiverServiceAsyncImpl
import dev.merge.api.services.errorHandler

class CrmServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CrmServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val accounts: AccountServiceAsync by lazy { AccountServiceAsyncImpl(clientOptions) }

    private val contacts: ContactServiceAsync by lazy { ContactServiceAsyncImpl(clientOptions) }

    private val customObjectClasses: CustomObjectClassServiceAsync by lazy {
        CustomObjectClassServiceAsyncImpl(clientOptions)
    }

    private val customObjects: CustomObjectServiceAsync by lazy {
        CustomObjectServiceAsyncImpl(clientOptions)
    }

    private val engagementTypes: EngagementTypeServiceAsync by lazy {
        EngagementTypeServiceAsyncImpl(clientOptions)
    }

    private val engagements: EngagementServiceAsync by lazy {
        EngagementServiceAsyncImpl(clientOptions)
    }

    private val leads: LeadServiceAsync by lazy { LeadServiceAsyncImpl(clientOptions) }

    private val notes: NoteServiceAsync by lazy { NoteServiceAsyncImpl(clientOptions) }

    private val opportunities: OpportunityServiceAsync by lazy {
        OpportunityServiceAsyncImpl(clientOptions)
    }

    private val stages: StageServiceAsync by lazy { StageServiceAsyncImpl(clientOptions) }

    private val tasks: TaskServiceAsync by lazy { TaskServiceAsyncImpl(clientOptions) }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptions) }

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

    override fun contacts(): ContactServiceAsync = contacts

    override fun customObjectClasses(): CustomObjectClassServiceAsync = customObjectClasses

    override fun customObjects(): CustomObjectServiceAsync = customObjects

    override fun engagementTypes(): EngagementTypeServiceAsync = engagementTypes

    override fun engagements(): EngagementServiceAsync = engagements

    override fun leads(): LeadServiceAsync = leads

    override fun notes(): NoteServiceAsync = notes

    override fun opportunities(): OpportunityServiceAsync = opportunities

    override fun stages(): StageServiceAsync = stages

    override fun tasks(): TaskServiceAsync = tasks

    override fun users(): UserServiceAsync = users

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

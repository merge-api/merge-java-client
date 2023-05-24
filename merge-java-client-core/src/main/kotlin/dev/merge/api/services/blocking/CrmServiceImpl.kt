package dev.merge.api.services.blocking

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.blocking.crm.AccountDetailService
import dev.merge.api.services.blocking.crm.AccountDetailServiceImpl
import dev.merge.api.services.blocking.crm.AccountService
import dev.merge.api.services.blocking.crm.AccountServiceImpl
import dev.merge.api.services.blocking.crm.AccountTokenService
import dev.merge.api.services.blocking.crm.AccountTokenServiceImpl
import dev.merge.api.services.blocking.crm.AvailableActionService
import dev.merge.api.services.blocking.crm.AvailableActionServiceImpl
import dev.merge.api.services.blocking.crm.CommonModelScopeService
import dev.merge.api.services.blocking.crm.CommonModelScopeServiceImpl
import dev.merge.api.services.blocking.crm.ContactService
import dev.merge.api.services.blocking.crm.ContactServiceImpl
import dev.merge.api.services.blocking.crm.CustomObjectClassService
import dev.merge.api.services.blocking.crm.CustomObjectClassServiceImpl
import dev.merge.api.services.blocking.crm.CustomObjectService
import dev.merge.api.services.blocking.crm.CustomObjectServiceImpl
import dev.merge.api.services.blocking.crm.EngagementService
import dev.merge.api.services.blocking.crm.EngagementServiceImpl
import dev.merge.api.services.blocking.crm.EngagementTypeService
import dev.merge.api.services.blocking.crm.EngagementTypeServiceImpl
import dev.merge.api.services.blocking.crm.IssueService
import dev.merge.api.services.blocking.crm.IssueServiceImpl
import dev.merge.api.services.blocking.crm.LeadService
import dev.merge.api.services.blocking.crm.LeadServiceImpl
import dev.merge.api.services.blocking.crm.LinkTokenService
import dev.merge.api.services.blocking.crm.LinkTokenServiceImpl
import dev.merge.api.services.blocking.crm.LinkedAccountService
import dev.merge.api.services.blocking.crm.LinkedAccountServiceImpl
import dev.merge.api.services.blocking.crm.NoteService
import dev.merge.api.services.blocking.crm.NoteServiceImpl
import dev.merge.api.services.blocking.crm.OpportunityService
import dev.merge.api.services.blocking.crm.OpportunityServiceImpl
import dev.merge.api.services.blocking.crm.PassthroughRequestService
import dev.merge.api.services.blocking.crm.PassthroughRequestServiceImpl
import dev.merge.api.services.blocking.crm.RemoteKeyService
import dev.merge.api.services.blocking.crm.RemoteKeyServiceImpl
import dev.merge.api.services.blocking.crm.SelectiveSyncService
import dev.merge.api.services.blocking.crm.SelectiveSyncServiceImpl
import dev.merge.api.services.blocking.crm.StageService
import dev.merge.api.services.blocking.crm.StageServiceImpl
import dev.merge.api.services.blocking.crm.SyncStatusService
import dev.merge.api.services.blocking.crm.SyncStatusServiceImpl
import dev.merge.api.services.blocking.crm.TaskService
import dev.merge.api.services.blocking.crm.TaskServiceImpl
import dev.merge.api.services.blocking.crm.UserService
import dev.merge.api.services.blocking.crm.UserServiceImpl
import dev.merge.api.services.blocking.crm.WebhookReceiverService
import dev.merge.api.services.blocking.crm.WebhookReceiverServiceImpl
import dev.merge.api.services.errorHandler

class CrmServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : CrmService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptions) }

    private val contacts: ContactService by lazy { ContactServiceImpl(clientOptions) }

    private val customObjectClasses: CustomObjectClassService by lazy {
        CustomObjectClassServiceImpl(clientOptions)
    }

    private val customObjects: CustomObjectService by lazy {
        CustomObjectServiceImpl(clientOptions)
    }

    private val engagementTypes: EngagementTypeService by lazy {
        EngagementTypeServiceImpl(clientOptions)
    }

    private val engagements: EngagementService by lazy { EngagementServiceImpl(clientOptions) }

    private val leads: LeadService by lazy { LeadServiceImpl(clientOptions) }

    private val notes: NoteService by lazy { NoteServiceImpl(clientOptions) }

    private val opportunities: OpportunityService by lazy { OpportunityServiceImpl(clientOptions) }

    private val stages: StageService by lazy { StageServiceImpl(clientOptions) }

    private val tasks: TaskService by lazy { TaskServiceImpl(clientOptions) }

    private val users: UserService by lazy { UserServiceImpl(clientOptions) }

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

    override fun contacts(): ContactService = contacts

    override fun customObjectClasses(): CustomObjectClassService = customObjectClasses

    override fun customObjects(): CustomObjectService = customObjects

    override fun engagementTypes(): EngagementTypeService = engagementTypes

    override fun engagements(): EngagementService = engagements

    override fun leads(): LeadService = leads

    override fun notes(): NoteService = notes

    override fun opportunities(): OpportunityService = opportunities

    override fun stages(): StageService = stages

    override fun tasks(): TaskService = tasks

    override fun users(): UserService = users

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

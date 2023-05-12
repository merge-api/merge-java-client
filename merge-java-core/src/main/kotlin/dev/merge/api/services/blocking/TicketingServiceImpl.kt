package dev.merge.api.services.blocking

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.blocking.ticketing.AccountDetailService
import dev.merge.api.services.blocking.ticketing.AccountDetailServiceImpl
import dev.merge.api.services.blocking.ticketing.AccountService
import dev.merge.api.services.blocking.ticketing.AccountServiceImpl
import dev.merge.api.services.blocking.ticketing.AccountTokenService
import dev.merge.api.services.blocking.ticketing.AccountTokenServiceImpl
import dev.merge.api.services.blocking.ticketing.AttachmentService
import dev.merge.api.services.blocking.ticketing.AttachmentServiceImpl
import dev.merge.api.services.blocking.ticketing.AvailableActionService
import dev.merge.api.services.blocking.ticketing.AvailableActionServiceImpl
import dev.merge.api.services.blocking.ticketing.CollectionService
import dev.merge.api.services.blocking.ticketing.CollectionServiceImpl
import dev.merge.api.services.blocking.ticketing.CommentService
import dev.merge.api.services.blocking.ticketing.CommentServiceImpl
import dev.merge.api.services.blocking.ticketing.CommonModelScopeService
import dev.merge.api.services.blocking.ticketing.CommonModelScopeServiceImpl
import dev.merge.api.services.blocking.ticketing.ContactService
import dev.merge.api.services.blocking.ticketing.ContactServiceImpl
import dev.merge.api.services.blocking.ticketing.IssueService
import dev.merge.api.services.blocking.ticketing.IssueServiceImpl
import dev.merge.api.services.blocking.ticketing.LinkTokenService
import dev.merge.api.services.blocking.ticketing.LinkTokenServiceImpl
import dev.merge.api.services.blocking.ticketing.LinkedAccountService
import dev.merge.api.services.blocking.ticketing.LinkedAccountServiceImpl
import dev.merge.api.services.blocking.ticketing.PassthroughRequestService
import dev.merge.api.services.blocking.ticketing.PassthroughRequestServiceImpl
import dev.merge.api.services.blocking.ticketing.ProjectService
import dev.merge.api.services.blocking.ticketing.ProjectServiceImpl
import dev.merge.api.services.blocking.ticketing.RemoteKeyService
import dev.merge.api.services.blocking.ticketing.RemoteKeyServiceImpl
import dev.merge.api.services.blocking.ticketing.SelectiveSyncService
import dev.merge.api.services.blocking.ticketing.SelectiveSyncServiceImpl
import dev.merge.api.services.blocking.ticketing.SyncStatusService
import dev.merge.api.services.blocking.ticketing.SyncStatusServiceImpl
import dev.merge.api.services.blocking.ticketing.TagService
import dev.merge.api.services.blocking.ticketing.TagServiceImpl
import dev.merge.api.services.blocking.ticketing.TeamService
import dev.merge.api.services.blocking.ticketing.TeamServiceImpl
import dev.merge.api.services.blocking.ticketing.TicketService
import dev.merge.api.services.blocking.ticketing.TicketServiceImpl
import dev.merge.api.services.blocking.ticketing.UserService
import dev.merge.api.services.blocking.ticketing.UserServiceImpl
import dev.merge.api.services.blocking.ticketing.WebhookReceiverService
import dev.merge.api.services.blocking.ticketing.WebhookReceiverServiceImpl
import dev.merge.api.services.errorHandler

class TicketingServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : TicketingService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptions) }

    private val attachments: AttachmentService by lazy { AttachmentServiceImpl(clientOptions) }

    private val collections: CollectionService by lazy { CollectionServiceImpl(clientOptions) }

    private val comments: CommentService by lazy { CommentServiceImpl(clientOptions) }

    private val contacts: ContactService by lazy { ContactServiceImpl(clientOptions) }

    private val projects: ProjectService by lazy { ProjectServiceImpl(clientOptions) }

    private val tags: TagService by lazy { TagServiceImpl(clientOptions) }

    private val teams: TeamService by lazy { TeamServiceImpl(clientOptions) }

    private val tickets: TicketService by lazy { TicketServiceImpl(clientOptions) }

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

    override fun attachments(): AttachmentService = attachments

    override fun collections(): CollectionService = collections

    override fun comments(): CommentService = comments

    override fun contacts(): ContactService = contacts

    override fun projects(): ProjectService = projects

    override fun tags(): TagService = tags

    override fun teams(): TeamService = teams

    override fun tickets(): TicketService = tickets

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

package dev.merge.api.services.async

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.async.ticketing.AccountDetailServiceAsync
import dev.merge.api.services.async.ticketing.AccountDetailServiceAsyncImpl
import dev.merge.api.services.async.ticketing.AccountServiceAsync
import dev.merge.api.services.async.ticketing.AccountServiceAsyncImpl
import dev.merge.api.services.async.ticketing.AccountTokenServiceAsync
import dev.merge.api.services.async.ticketing.AccountTokenServiceAsyncImpl
import dev.merge.api.services.async.ticketing.AttachmentServiceAsync
import dev.merge.api.services.async.ticketing.AttachmentServiceAsyncImpl
import dev.merge.api.services.async.ticketing.AvailableActionServiceAsync
import dev.merge.api.services.async.ticketing.AvailableActionServiceAsyncImpl
import dev.merge.api.services.async.ticketing.CollectionServiceAsync
import dev.merge.api.services.async.ticketing.CollectionServiceAsyncImpl
import dev.merge.api.services.async.ticketing.CommentServiceAsync
import dev.merge.api.services.async.ticketing.CommentServiceAsyncImpl
import dev.merge.api.services.async.ticketing.CommonModelScopeServiceAsync
import dev.merge.api.services.async.ticketing.CommonModelScopeServiceAsyncImpl
import dev.merge.api.services.async.ticketing.ContactServiceAsync
import dev.merge.api.services.async.ticketing.ContactServiceAsyncImpl
import dev.merge.api.services.async.ticketing.IssueServiceAsync
import dev.merge.api.services.async.ticketing.IssueServiceAsyncImpl
import dev.merge.api.services.async.ticketing.LinkTokenServiceAsync
import dev.merge.api.services.async.ticketing.LinkTokenServiceAsyncImpl
import dev.merge.api.services.async.ticketing.LinkedAccountServiceAsync
import dev.merge.api.services.async.ticketing.LinkedAccountServiceAsyncImpl
import dev.merge.api.services.async.ticketing.PassthroughRequestServiceAsync
import dev.merge.api.services.async.ticketing.PassthroughRequestServiceAsyncImpl
import dev.merge.api.services.async.ticketing.ProjectServiceAsync
import dev.merge.api.services.async.ticketing.ProjectServiceAsyncImpl
import dev.merge.api.services.async.ticketing.RemoteKeyServiceAsync
import dev.merge.api.services.async.ticketing.RemoteKeyServiceAsyncImpl
import dev.merge.api.services.async.ticketing.SelectiveSyncServiceAsync
import dev.merge.api.services.async.ticketing.SelectiveSyncServiceAsyncImpl
import dev.merge.api.services.async.ticketing.SyncStatusServiceAsync
import dev.merge.api.services.async.ticketing.SyncStatusServiceAsyncImpl
import dev.merge.api.services.async.ticketing.TagServiceAsync
import dev.merge.api.services.async.ticketing.TagServiceAsyncImpl
import dev.merge.api.services.async.ticketing.TeamServiceAsync
import dev.merge.api.services.async.ticketing.TeamServiceAsyncImpl
import dev.merge.api.services.async.ticketing.TicketServiceAsync
import dev.merge.api.services.async.ticketing.TicketServiceAsyncImpl
import dev.merge.api.services.async.ticketing.UserServiceAsync
import dev.merge.api.services.async.ticketing.UserServiceAsyncImpl
import dev.merge.api.services.async.ticketing.WebhookReceiverServiceAsync
import dev.merge.api.services.async.ticketing.WebhookReceiverServiceAsyncImpl
import dev.merge.api.services.errorHandler

class TicketingServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TicketingServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val accounts: AccountServiceAsync by lazy { AccountServiceAsyncImpl(clientOptions) }

    private val attachments: AttachmentServiceAsync by lazy {
        AttachmentServiceAsyncImpl(clientOptions)
    }

    private val collections: CollectionServiceAsync by lazy {
        CollectionServiceAsyncImpl(clientOptions)
    }

    private val comments: CommentServiceAsync by lazy { CommentServiceAsyncImpl(clientOptions) }

    private val contacts: ContactServiceAsync by lazy { ContactServiceAsyncImpl(clientOptions) }

    private val projects: ProjectServiceAsync by lazy { ProjectServiceAsyncImpl(clientOptions) }

    private val tags: TagServiceAsync by lazy { TagServiceAsyncImpl(clientOptions) }

    private val teams: TeamServiceAsync by lazy { TeamServiceAsyncImpl(clientOptions) }

    private val tickets: TicketServiceAsync by lazy { TicketServiceAsyncImpl(clientOptions) }

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

    override fun attachments(): AttachmentServiceAsync = attachments

    override fun collections(): CollectionServiceAsync = collections

    override fun comments(): CommentServiceAsync = comments

    override fun contacts(): ContactServiceAsync = contacts

    override fun projects(): ProjectServiceAsync = projects

    override fun tags(): TagServiceAsync = tags

    override fun teams(): TeamServiceAsync = teams

    override fun tickets(): TicketServiceAsync = tickets

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

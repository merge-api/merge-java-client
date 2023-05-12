package dev.merge.api.services.blocking

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.blocking.marketing.AccountDetailService
import dev.merge.api.services.blocking.marketing.AccountDetailServiceImpl
import dev.merge.api.services.blocking.marketing.AccountTokenService
import dev.merge.api.services.blocking.marketing.AccountTokenServiceImpl
import dev.merge.api.services.blocking.marketing.ActionService
import dev.merge.api.services.blocking.marketing.ActionServiceImpl
import dev.merge.api.services.blocking.marketing.AutomationService
import dev.merge.api.services.blocking.marketing.AutomationServiceImpl
import dev.merge.api.services.blocking.marketing.AvailableActionService
import dev.merge.api.services.blocking.marketing.AvailableActionServiceImpl
import dev.merge.api.services.blocking.marketing.CampaignService
import dev.merge.api.services.blocking.marketing.CampaignServiceImpl
import dev.merge.api.services.blocking.marketing.CommonModelScopeService
import dev.merge.api.services.blocking.marketing.CommonModelScopeServiceImpl
import dev.merge.api.services.blocking.marketing.ContactListService
import dev.merge.api.services.blocking.marketing.ContactListServiceImpl
import dev.merge.api.services.blocking.marketing.ContactService
import dev.merge.api.services.blocking.marketing.ContactServiceImpl
import dev.merge.api.services.blocking.marketing.EmailService
import dev.merge.api.services.blocking.marketing.EmailServiceImpl
import dev.merge.api.services.blocking.marketing.EventService
import dev.merge.api.services.blocking.marketing.EventServiceImpl
import dev.merge.api.services.blocking.marketing.IssueService
import dev.merge.api.services.blocking.marketing.IssueServiceImpl
import dev.merge.api.services.blocking.marketing.LinkTokenService
import dev.merge.api.services.blocking.marketing.LinkTokenServiceImpl
import dev.merge.api.services.blocking.marketing.LinkedAccountService
import dev.merge.api.services.blocking.marketing.LinkedAccountServiceImpl
import dev.merge.api.services.blocking.marketing.MessageService
import dev.merge.api.services.blocking.marketing.MessageServiceImpl
import dev.merge.api.services.blocking.marketing.PassthroughRequestService
import dev.merge.api.services.blocking.marketing.PassthroughRequestServiceImpl
import dev.merge.api.services.blocking.marketing.RemoteKeyService
import dev.merge.api.services.blocking.marketing.RemoteKeyServiceImpl
import dev.merge.api.services.blocking.marketing.SelectiveSyncService
import dev.merge.api.services.blocking.marketing.SelectiveSyncServiceImpl
import dev.merge.api.services.blocking.marketing.SyncStatusService
import dev.merge.api.services.blocking.marketing.SyncStatusServiceImpl
import dev.merge.api.services.blocking.marketing.TemplateService
import dev.merge.api.services.blocking.marketing.TemplateServiceImpl
import dev.merge.api.services.blocking.marketing.UserService
import dev.merge.api.services.blocking.marketing.UserServiceImpl
import dev.merge.api.services.blocking.marketing.WebhookReceiverService
import dev.merge.api.services.blocking.marketing.WebhookReceiverServiceImpl
import dev.merge.api.services.errorHandler

class MarketingServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : MarketingService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val actions: ActionService by lazy { ActionServiceImpl(clientOptions) }

    private val automations: AutomationService by lazy { AutomationServiceImpl(clientOptions) }

    private val campaigns: CampaignService by lazy { CampaignServiceImpl(clientOptions) }

    private val contacts: ContactService by lazy { ContactServiceImpl(clientOptions) }

    private val emails: EmailService by lazy { EmailServiceImpl(clientOptions) }

    private val events: EventService by lazy { EventServiceImpl(clientOptions) }

    private val contactLists: ContactListService by lazy { ContactListServiceImpl(clientOptions) }

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptions) }

    private val templates: TemplateService by lazy { TemplateServiceImpl(clientOptions) }

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

    override fun actions(): ActionService = actions

    override fun automations(): AutomationService = automations

    override fun campaigns(): CampaignService = campaigns

    override fun contacts(): ContactService = contacts

    override fun emails(): EmailService = emails

    override fun events(): EventService = events

    override fun contactLists(): ContactListService = contactLists

    override fun messages(): MessageService = messages

    override fun templates(): TemplateService = templates

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

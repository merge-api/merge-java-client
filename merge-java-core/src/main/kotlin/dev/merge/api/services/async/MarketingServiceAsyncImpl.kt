package dev.merge.api.services.async

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.async.marketing.AccountDetailServiceAsync
import dev.merge.api.services.async.marketing.AccountDetailServiceAsyncImpl
import dev.merge.api.services.async.marketing.AccountTokenServiceAsync
import dev.merge.api.services.async.marketing.AccountTokenServiceAsyncImpl
import dev.merge.api.services.async.marketing.ActionServiceAsync
import dev.merge.api.services.async.marketing.ActionServiceAsyncImpl
import dev.merge.api.services.async.marketing.AutomationServiceAsync
import dev.merge.api.services.async.marketing.AutomationServiceAsyncImpl
import dev.merge.api.services.async.marketing.AvailableActionServiceAsync
import dev.merge.api.services.async.marketing.AvailableActionServiceAsyncImpl
import dev.merge.api.services.async.marketing.CampaignServiceAsync
import dev.merge.api.services.async.marketing.CampaignServiceAsyncImpl
import dev.merge.api.services.async.marketing.CommonModelScopeServiceAsync
import dev.merge.api.services.async.marketing.CommonModelScopeServiceAsyncImpl
import dev.merge.api.services.async.marketing.ContactListServiceAsync
import dev.merge.api.services.async.marketing.ContactListServiceAsyncImpl
import dev.merge.api.services.async.marketing.ContactServiceAsync
import dev.merge.api.services.async.marketing.ContactServiceAsyncImpl
import dev.merge.api.services.async.marketing.EmailServiceAsync
import dev.merge.api.services.async.marketing.EmailServiceAsyncImpl
import dev.merge.api.services.async.marketing.EventServiceAsync
import dev.merge.api.services.async.marketing.EventServiceAsyncImpl
import dev.merge.api.services.async.marketing.IssueServiceAsync
import dev.merge.api.services.async.marketing.IssueServiceAsyncImpl
import dev.merge.api.services.async.marketing.LinkTokenServiceAsync
import dev.merge.api.services.async.marketing.LinkTokenServiceAsyncImpl
import dev.merge.api.services.async.marketing.LinkedAccountServiceAsync
import dev.merge.api.services.async.marketing.LinkedAccountServiceAsyncImpl
import dev.merge.api.services.async.marketing.MessageServiceAsync
import dev.merge.api.services.async.marketing.MessageServiceAsyncImpl
import dev.merge.api.services.async.marketing.PassthroughRequestServiceAsync
import dev.merge.api.services.async.marketing.PassthroughRequestServiceAsyncImpl
import dev.merge.api.services.async.marketing.RemoteKeyServiceAsync
import dev.merge.api.services.async.marketing.RemoteKeyServiceAsyncImpl
import dev.merge.api.services.async.marketing.SelectiveSyncServiceAsync
import dev.merge.api.services.async.marketing.SelectiveSyncServiceAsyncImpl
import dev.merge.api.services.async.marketing.SyncStatusServiceAsync
import dev.merge.api.services.async.marketing.SyncStatusServiceAsyncImpl
import dev.merge.api.services.async.marketing.TemplateServiceAsync
import dev.merge.api.services.async.marketing.TemplateServiceAsyncImpl
import dev.merge.api.services.async.marketing.UserServiceAsync
import dev.merge.api.services.async.marketing.UserServiceAsyncImpl
import dev.merge.api.services.async.marketing.WebhookReceiverServiceAsync
import dev.merge.api.services.async.marketing.WebhookReceiverServiceAsyncImpl
import dev.merge.api.services.errorHandler

class MarketingServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : MarketingServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val actions: ActionServiceAsync by lazy { ActionServiceAsyncImpl(clientOptions) }

    private val automations: AutomationServiceAsync by lazy {
        AutomationServiceAsyncImpl(clientOptions)
    }

    private val campaigns: CampaignServiceAsync by lazy { CampaignServiceAsyncImpl(clientOptions) }

    private val contacts: ContactServiceAsync by lazy { ContactServiceAsyncImpl(clientOptions) }

    private val emails: EmailServiceAsync by lazy { EmailServiceAsyncImpl(clientOptions) }

    private val events: EventServiceAsync by lazy { EventServiceAsyncImpl(clientOptions) }

    private val contactLists: ContactListServiceAsync by lazy {
        ContactListServiceAsyncImpl(clientOptions)
    }

    private val messages: MessageServiceAsync by lazy { MessageServiceAsyncImpl(clientOptions) }

    private val templates: TemplateServiceAsync by lazy { TemplateServiceAsyncImpl(clientOptions) }

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

    override fun actions(): ActionServiceAsync = actions

    override fun automations(): AutomationServiceAsync = automations

    override fun campaigns(): CampaignServiceAsync = campaigns

    override fun contacts(): ContactServiceAsync = contacts

    override fun emails(): EmailServiceAsync = emails

    override fun events(): EventServiceAsync = events

    override fun contactLists(): ContactListServiceAsync = contactLists

    override fun messages(): MessageServiceAsync = messages

    override fun templates(): TemplateServiceAsync = templates

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

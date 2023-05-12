@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking

import dev.merge.api.services.blocking.marketing.AccountDetailService
import dev.merge.api.services.blocking.marketing.AccountTokenService
import dev.merge.api.services.blocking.marketing.ActionService
import dev.merge.api.services.blocking.marketing.AutomationService
import dev.merge.api.services.blocking.marketing.AvailableActionService
import dev.merge.api.services.blocking.marketing.CampaignService
import dev.merge.api.services.blocking.marketing.CommonModelScopeService
import dev.merge.api.services.blocking.marketing.ContactListService
import dev.merge.api.services.blocking.marketing.ContactService
import dev.merge.api.services.blocking.marketing.EmailService
import dev.merge.api.services.blocking.marketing.EventService
import dev.merge.api.services.blocking.marketing.IssueService
import dev.merge.api.services.blocking.marketing.LinkTokenService
import dev.merge.api.services.blocking.marketing.LinkedAccountService
import dev.merge.api.services.blocking.marketing.MessageService
import dev.merge.api.services.blocking.marketing.PassthroughRequestService
import dev.merge.api.services.blocking.marketing.RemoteKeyService
import dev.merge.api.services.blocking.marketing.SelectiveSyncService
import dev.merge.api.services.blocking.marketing.SyncStatusService
import dev.merge.api.services.blocking.marketing.TemplateService
import dev.merge.api.services.blocking.marketing.UserService
import dev.merge.api.services.blocking.marketing.WebhookReceiverService

interface MarketingService {

    fun actions(): ActionService

    fun automations(): AutomationService

    fun campaigns(): CampaignService

    fun contacts(): ContactService

    fun emails(): EmailService

    fun events(): EventService

    fun contactLists(): ContactListService

    fun messages(): MessageService

    fun templates(): TemplateService

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

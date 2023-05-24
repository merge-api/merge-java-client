@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async

import dev.merge.api.services.async.marketing.AccountDetailServiceAsync
import dev.merge.api.services.async.marketing.AccountTokenServiceAsync
import dev.merge.api.services.async.marketing.ActionServiceAsync
import dev.merge.api.services.async.marketing.AutomationServiceAsync
import dev.merge.api.services.async.marketing.AvailableActionServiceAsync
import dev.merge.api.services.async.marketing.CampaignServiceAsync
import dev.merge.api.services.async.marketing.CommonModelScopeServiceAsync
import dev.merge.api.services.async.marketing.ContactListServiceAsync
import dev.merge.api.services.async.marketing.ContactServiceAsync
import dev.merge.api.services.async.marketing.EmailServiceAsync
import dev.merge.api.services.async.marketing.EventServiceAsync
import dev.merge.api.services.async.marketing.IssueServiceAsync
import dev.merge.api.services.async.marketing.LinkTokenServiceAsync
import dev.merge.api.services.async.marketing.LinkedAccountServiceAsync
import dev.merge.api.services.async.marketing.MessageServiceAsync
import dev.merge.api.services.async.marketing.PassthroughRequestServiceAsync
import dev.merge.api.services.async.marketing.RemoteKeyServiceAsync
import dev.merge.api.services.async.marketing.SelectiveSyncServiceAsync
import dev.merge.api.services.async.marketing.SyncStatusServiceAsync
import dev.merge.api.services.async.marketing.TemplateServiceAsync
import dev.merge.api.services.async.marketing.UserServiceAsync
import dev.merge.api.services.async.marketing.WebhookReceiverServiceAsync

interface MarketingServiceAsync {

    fun actions(): ActionServiceAsync

    fun automations(): AutomationServiceAsync

    fun campaigns(): CampaignServiceAsync

    fun contacts(): ContactServiceAsync

    fun emails(): EmailServiceAsync

    fun events(): EventServiceAsync

    fun contactLists(): ContactListServiceAsync

    fun messages(): MessageServiceAsync

    fun templates(): TemplateServiceAsync

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

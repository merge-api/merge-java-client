@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async

import dev.merge.api.services.async.ticketing.AccountDetailServiceAsync
import dev.merge.api.services.async.ticketing.AccountServiceAsync
import dev.merge.api.services.async.ticketing.AccountTokenServiceAsync
import dev.merge.api.services.async.ticketing.AttachmentServiceAsync
import dev.merge.api.services.async.ticketing.AvailableActionServiceAsync
import dev.merge.api.services.async.ticketing.CollectionServiceAsync
import dev.merge.api.services.async.ticketing.CommentServiceAsync
import dev.merge.api.services.async.ticketing.CommonModelScopeServiceAsync
import dev.merge.api.services.async.ticketing.ContactServiceAsync
import dev.merge.api.services.async.ticketing.IssueServiceAsync
import dev.merge.api.services.async.ticketing.LinkTokenServiceAsync
import dev.merge.api.services.async.ticketing.LinkedAccountServiceAsync
import dev.merge.api.services.async.ticketing.PassthroughRequestServiceAsync
import dev.merge.api.services.async.ticketing.ProjectServiceAsync
import dev.merge.api.services.async.ticketing.RemoteKeyServiceAsync
import dev.merge.api.services.async.ticketing.SelectiveSyncServiceAsync
import dev.merge.api.services.async.ticketing.SyncStatusServiceAsync
import dev.merge.api.services.async.ticketing.TagServiceAsync
import dev.merge.api.services.async.ticketing.TeamServiceAsync
import dev.merge.api.services.async.ticketing.TicketServiceAsync
import dev.merge.api.services.async.ticketing.UserServiceAsync
import dev.merge.api.services.async.ticketing.WebhookReceiverServiceAsync

interface TicketingServiceAsync {

    fun accounts(): AccountServiceAsync

    fun attachments(): AttachmentServiceAsync

    fun collections(): CollectionServiceAsync

    fun comments(): CommentServiceAsync

    fun contacts(): ContactServiceAsync

    fun projects(): ProjectServiceAsync

    fun tags(): TagServiceAsync

    fun teams(): TeamServiceAsync

    fun tickets(): TicketServiceAsync

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

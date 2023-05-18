@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking

import dev.merge.api.services.blocking.ticketing.AccountDetailService
import dev.merge.api.services.blocking.ticketing.AccountService
import dev.merge.api.services.blocking.ticketing.AccountTokenService
import dev.merge.api.services.blocking.ticketing.AttachmentService
import dev.merge.api.services.blocking.ticketing.AvailableActionService
import dev.merge.api.services.blocking.ticketing.CollectionService
import dev.merge.api.services.blocking.ticketing.CommentService
import dev.merge.api.services.blocking.ticketing.CommonModelScopeService
import dev.merge.api.services.blocking.ticketing.ContactService
import dev.merge.api.services.blocking.ticketing.IssueService
import dev.merge.api.services.blocking.ticketing.LinkTokenService
import dev.merge.api.services.blocking.ticketing.LinkedAccountService
import dev.merge.api.services.blocking.ticketing.PassthroughRequestService
import dev.merge.api.services.blocking.ticketing.ProjectService
import dev.merge.api.services.blocking.ticketing.RemoteKeyService
import dev.merge.api.services.blocking.ticketing.SelectiveSyncService
import dev.merge.api.services.blocking.ticketing.SyncStatusService
import dev.merge.api.services.blocking.ticketing.TagService
import dev.merge.api.services.blocking.ticketing.TeamService
import dev.merge.api.services.blocking.ticketing.TicketService
import dev.merge.api.services.blocking.ticketing.UserService
import dev.merge.api.services.blocking.ticketing.WebhookReceiverService

interface TicketingService {

    fun accounts(): AccountService

    fun attachments(): AttachmentService

    fun collections(): CollectionService

    fun comments(): CommentService

    fun contacts(): ContactService

    fun projects(): ProjectService

    fun tags(): TagService

    fun teams(): TeamService

    fun tickets(): TicketService

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

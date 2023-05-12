@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking

import dev.merge.api.services.blocking.fileStorage.AccountDetailService
import dev.merge.api.services.blocking.fileStorage.AccountTokenService
import dev.merge.api.services.blocking.fileStorage.AvailableActionService
import dev.merge.api.services.blocking.fileStorage.CommonModelScopeService
import dev.merge.api.services.blocking.fileStorage.DriveService
import dev.merge.api.services.blocking.fileStorage.FileService
import dev.merge.api.services.blocking.fileStorage.FolderService
import dev.merge.api.services.blocking.fileStorage.GroupService
import dev.merge.api.services.blocking.fileStorage.IssueService
import dev.merge.api.services.blocking.fileStorage.LinkTokenService
import dev.merge.api.services.blocking.fileStorage.LinkedAccountService
import dev.merge.api.services.blocking.fileStorage.PassthroughRequestService
import dev.merge.api.services.blocking.fileStorage.RemoteKeyService
import dev.merge.api.services.blocking.fileStorage.SelectiveSyncService
import dev.merge.api.services.blocking.fileStorage.SyncStatusService
import dev.merge.api.services.blocking.fileStorage.UserService
import dev.merge.api.services.blocking.fileStorage.WebhookReceiverService

interface FileStorageService {

    fun drives(): DriveService

    fun files(): FileService

    fun folders(): FolderService

    fun groups(): GroupService

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

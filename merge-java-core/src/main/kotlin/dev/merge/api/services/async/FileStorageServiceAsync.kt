@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async

import dev.merge.api.services.async.fileStorage.AccountDetailServiceAsync
import dev.merge.api.services.async.fileStorage.AccountTokenServiceAsync
import dev.merge.api.services.async.fileStorage.AvailableActionServiceAsync
import dev.merge.api.services.async.fileStorage.CommonModelScopeServiceAsync
import dev.merge.api.services.async.fileStorage.DriveServiceAsync
import dev.merge.api.services.async.fileStorage.FileServiceAsync
import dev.merge.api.services.async.fileStorage.FolderServiceAsync
import dev.merge.api.services.async.fileStorage.GroupServiceAsync
import dev.merge.api.services.async.fileStorage.IssueServiceAsync
import dev.merge.api.services.async.fileStorage.LinkTokenServiceAsync
import dev.merge.api.services.async.fileStorage.LinkedAccountServiceAsync
import dev.merge.api.services.async.fileStorage.PassthroughRequestServiceAsync
import dev.merge.api.services.async.fileStorage.RemoteKeyServiceAsync
import dev.merge.api.services.async.fileStorage.SelectiveSyncServiceAsync
import dev.merge.api.services.async.fileStorage.SyncStatusServiceAsync
import dev.merge.api.services.async.fileStorage.UserServiceAsync
import dev.merge.api.services.async.fileStorage.WebhookReceiverServiceAsync

interface FileStorageServiceAsync {

    fun drives(): DriveServiceAsync

    fun files(): FileServiceAsync

    fun folders(): FolderServiceAsync

    fun groups(): GroupServiceAsync

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

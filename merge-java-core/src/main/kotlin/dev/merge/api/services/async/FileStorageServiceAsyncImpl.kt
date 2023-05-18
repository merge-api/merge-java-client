package dev.merge.api.services.async

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.async.fileStorage.AccountDetailServiceAsync
import dev.merge.api.services.async.fileStorage.AccountDetailServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.AccountTokenServiceAsync
import dev.merge.api.services.async.fileStorage.AccountTokenServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.AvailableActionServiceAsync
import dev.merge.api.services.async.fileStorage.AvailableActionServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.CommonModelScopeServiceAsync
import dev.merge.api.services.async.fileStorage.CommonModelScopeServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.DriveServiceAsync
import dev.merge.api.services.async.fileStorage.DriveServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.FileServiceAsync
import dev.merge.api.services.async.fileStorage.FileServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.FolderServiceAsync
import dev.merge.api.services.async.fileStorage.FolderServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.GroupServiceAsync
import dev.merge.api.services.async.fileStorage.GroupServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.IssueServiceAsync
import dev.merge.api.services.async.fileStorage.IssueServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.LinkTokenServiceAsync
import dev.merge.api.services.async.fileStorage.LinkTokenServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.LinkedAccountServiceAsync
import dev.merge.api.services.async.fileStorage.LinkedAccountServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.PassthroughRequestServiceAsync
import dev.merge.api.services.async.fileStorage.PassthroughRequestServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.RemoteKeyServiceAsync
import dev.merge.api.services.async.fileStorage.RemoteKeyServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.SelectiveSyncServiceAsync
import dev.merge.api.services.async.fileStorage.SelectiveSyncServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.SyncStatusServiceAsync
import dev.merge.api.services.async.fileStorage.SyncStatusServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.UserServiceAsync
import dev.merge.api.services.async.fileStorage.UserServiceAsyncImpl
import dev.merge.api.services.async.fileStorage.WebhookReceiverServiceAsync
import dev.merge.api.services.async.fileStorage.WebhookReceiverServiceAsyncImpl
import dev.merge.api.services.errorHandler

class FileStorageServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : FileStorageServiceAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val drives: DriveServiceAsync by lazy { DriveServiceAsyncImpl(clientOptions) }

    private val files: FileServiceAsync by lazy { FileServiceAsyncImpl(clientOptions) }

    private val folders: FolderServiceAsync by lazy { FolderServiceAsyncImpl(clientOptions) }

    private val groups: GroupServiceAsync by lazy { GroupServiceAsyncImpl(clientOptions) }

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

    override fun drives(): DriveServiceAsync = drives

    override fun files(): FileServiceAsync = files

    override fun folders(): FolderServiceAsync = folders

    override fun groups(): GroupServiceAsync = groups

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

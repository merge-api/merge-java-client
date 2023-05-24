package dev.merge.api.services.blocking

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.services.blocking.fileStorage.AccountDetailService
import dev.merge.api.services.blocking.fileStorage.AccountDetailServiceImpl
import dev.merge.api.services.blocking.fileStorage.AccountTokenService
import dev.merge.api.services.blocking.fileStorage.AccountTokenServiceImpl
import dev.merge.api.services.blocking.fileStorage.AvailableActionService
import dev.merge.api.services.blocking.fileStorage.AvailableActionServiceImpl
import dev.merge.api.services.blocking.fileStorage.CommonModelScopeService
import dev.merge.api.services.blocking.fileStorage.CommonModelScopeServiceImpl
import dev.merge.api.services.blocking.fileStorage.DriveService
import dev.merge.api.services.blocking.fileStorage.DriveServiceImpl
import dev.merge.api.services.blocking.fileStorage.FileService
import dev.merge.api.services.blocking.fileStorage.FileServiceImpl
import dev.merge.api.services.blocking.fileStorage.FolderService
import dev.merge.api.services.blocking.fileStorage.FolderServiceImpl
import dev.merge.api.services.blocking.fileStorage.GroupService
import dev.merge.api.services.blocking.fileStorage.GroupServiceImpl
import dev.merge.api.services.blocking.fileStorage.IssueService
import dev.merge.api.services.blocking.fileStorage.IssueServiceImpl
import dev.merge.api.services.blocking.fileStorage.LinkTokenService
import dev.merge.api.services.blocking.fileStorage.LinkTokenServiceImpl
import dev.merge.api.services.blocking.fileStorage.LinkedAccountService
import dev.merge.api.services.blocking.fileStorage.LinkedAccountServiceImpl
import dev.merge.api.services.blocking.fileStorage.PassthroughRequestService
import dev.merge.api.services.blocking.fileStorage.PassthroughRequestServiceImpl
import dev.merge.api.services.blocking.fileStorage.RemoteKeyService
import dev.merge.api.services.blocking.fileStorage.RemoteKeyServiceImpl
import dev.merge.api.services.blocking.fileStorage.SelectiveSyncService
import dev.merge.api.services.blocking.fileStorage.SelectiveSyncServiceImpl
import dev.merge.api.services.blocking.fileStorage.SyncStatusService
import dev.merge.api.services.blocking.fileStorage.SyncStatusServiceImpl
import dev.merge.api.services.blocking.fileStorage.UserService
import dev.merge.api.services.blocking.fileStorage.UserServiceImpl
import dev.merge.api.services.blocking.fileStorage.WebhookReceiverService
import dev.merge.api.services.blocking.fileStorage.WebhookReceiverServiceImpl
import dev.merge.api.services.errorHandler

class FileStorageServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : FileStorageService {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val drives: DriveService by lazy { DriveServiceImpl(clientOptions) }

    private val files: FileService by lazy { FileServiceImpl(clientOptions) }

    private val folders: FolderService by lazy { FolderServiceImpl(clientOptions) }

    private val groups: GroupService by lazy { GroupServiceImpl(clientOptions) }

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

    override fun drives(): DriveService = drives

    override fun files(): FileService = files

    override fun folders(): FolderService = folders

    override fun groups(): GroupService = groups

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

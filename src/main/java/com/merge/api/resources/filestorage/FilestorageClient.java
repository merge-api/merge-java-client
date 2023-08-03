package com.merge.api.resources.filestorage;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.Suppliers;
import com.merge.api.resources.filestorage.accountdetails.AccountDetailsClient;
import com.merge.api.resources.filestorage.accounttoken.AccountTokenClient;
import com.merge.api.resources.filestorage.availableactions.AvailableActionsClient;
import com.merge.api.resources.filestorage.deleteaccount.DeleteAccountClient;
import com.merge.api.resources.filestorage.drives.DrivesClient;
import com.merge.api.resources.filestorage.files.FilesClient;
import com.merge.api.resources.filestorage.folders.FoldersClient;
import com.merge.api.resources.filestorage.forceresync.ForceResyncClient;
import com.merge.api.resources.filestorage.generatekey.GenerateKeyClient;
import com.merge.api.resources.filestorage.groups.GroupsClient;
import com.merge.api.resources.filestorage.issues.IssuesClient;
import com.merge.api.resources.filestorage.linkedaccounts.LinkedAccountsClient;
import com.merge.api.resources.filestorage.linktoken.LinkTokenClient;
import com.merge.api.resources.filestorage.passthrough.PassthroughClient;
import com.merge.api.resources.filestorage.regeneratekey.RegenerateKeyClient;
import com.merge.api.resources.filestorage.selectivesync.SelectiveSyncClient;
import com.merge.api.resources.filestorage.syncstatus.SyncStatusClient;
import com.merge.api.resources.filestorage.users.UsersClient;
import com.merge.api.resources.filestorage.webhookreceivers.WebhookReceiversClient;
import java.util.function.Supplier;

public class FilestorageClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AccountDetailsClient> accountDetailsClient;

    protected final Supplier<AccountTokenClient> accountTokenClient;

    protected final Supplier<AvailableActionsClient> availableActionsClient;

    protected final Supplier<DeleteAccountClient> deleteAccountClient;

    protected final Supplier<DrivesClient> drivesClient;

    protected final Supplier<FilesClient> filesClient;

    protected final Supplier<FoldersClient> foldersClient;

    protected final Supplier<GenerateKeyClient> generateKeyClient;

    protected final Supplier<GroupsClient> groupsClient;

    protected final Supplier<IssuesClient> issuesClient;

    protected final Supplier<LinkTokenClient> linkTokenClient;

    protected final Supplier<LinkedAccountsClient> linkedAccountsClient;

    protected final Supplier<PassthroughClient> passthroughClient;

    protected final Supplier<RegenerateKeyClient> regenerateKeyClient;

    protected final Supplier<SelectiveSyncClient> selectiveSyncClient;

    protected final Supplier<SyncStatusClient> syncStatusClient;

    protected final Supplier<ForceResyncClient> forceResyncClient;

    protected final Supplier<UsersClient> usersClient;

    protected final Supplier<WebhookReceiversClient> webhookReceiversClient;

    public FilestorageClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.accountDetailsClient = Suppliers.memoize(() -> new AccountDetailsClient(clientOptions));
        this.accountTokenClient = Suppliers.memoize(() -> new AccountTokenClient(clientOptions));
        this.availableActionsClient = Suppliers.memoize(() -> new AvailableActionsClient(clientOptions));
        this.deleteAccountClient = Suppliers.memoize(() -> new DeleteAccountClient(clientOptions));
        this.drivesClient = Suppliers.memoize(() -> new DrivesClient(clientOptions));
        this.filesClient = Suppliers.memoize(() -> new FilesClient(clientOptions));
        this.foldersClient = Suppliers.memoize(() -> new FoldersClient(clientOptions));
        this.generateKeyClient = Suppliers.memoize(() -> new GenerateKeyClient(clientOptions));
        this.groupsClient = Suppliers.memoize(() -> new GroupsClient(clientOptions));
        this.issuesClient = Suppliers.memoize(() -> new IssuesClient(clientOptions));
        this.linkTokenClient = Suppliers.memoize(() -> new LinkTokenClient(clientOptions));
        this.linkedAccountsClient = Suppliers.memoize(() -> new LinkedAccountsClient(clientOptions));
        this.passthroughClient = Suppliers.memoize(() -> new PassthroughClient(clientOptions));
        this.regenerateKeyClient = Suppliers.memoize(() -> new RegenerateKeyClient(clientOptions));
        this.selectiveSyncClient = Suppliers.memoize(() -> new SelectiveSyncClient(clientOptions));
        this.syncStatusClient = Suppliers.memoize(() -> new SyncStatusClient(clientOptions));
        this.forceResyncClient = Suppliers.memoize(() -> new ForceResyncClient(clientOptions));
        this.usersClient = Suppliers.memoize(() -> new UsersClient(clientOptions));
        this.webhookReceiversClient = Suppliers.memoize(() -> new WebhookReceiversClient(clientOptions));
    }

    public AccountDetailsClient accountDetails() {
        return this.accountDetailsClient.get();
    }

    public AccountTokenClient accountToken() {
        return this.accountTokenClient.get();
    }

    public AvailableActionsClient availableActions() {
        return this.availableActionsClient.get();
    }

    public DeleteAccountClient deleteAccount() {
        return this.deleteAccountClient.get();
    }

    public DrivesClient drives() {
        return this.drivesClient.get();
    }

    public FilesClient files() {
        return this.filesClient.get();
    }

    public FoldersClient folders() {
        return this.foldersClient.get();
    }

    public GenerateKeyClient generateKey() {
        return this.generateKeyClient.get();
    }

    public GroupsClient groups() {
        return this.groupsClient.get();
    }

    public IssuesClient issues() {
        return this.issuesClient.get();
    }

    public LinkTokenClient linkToken() {
        return this.linkTokenClient.get();
    }

    public LinkedAccountsClient linkedAccounts() {
        return this.linkedAccountsClient.get();
    }

    public PassthroughClient passthrough() {
        return this.passthroughClient.get();
    }

    public RegenerateKeyClient regenerateKey() {
        return this.regenerateKeyClient.get();
    }

    public SelectiveSyncClient selectiveSync() {
        return this.selectiveSyncClient.get();
    }

    public SyncStatusClient syncStatus() {
        return this.syncStatusClient.get();
    }

    public ForceResyncClient forceResync() {
        return this.forceResyncClient.get();
    }

    public UsersClient users() {
        return this.usersClient.get();
    }

    public WebhookReceiversClient webhookReceivers() {
        return this.webhookReceiversClient.get();
    }
}

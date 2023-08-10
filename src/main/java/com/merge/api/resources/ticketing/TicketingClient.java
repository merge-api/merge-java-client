package com.merge.api.resources.ticketing;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.Suppliers;
import com.merge.api.resources.ticketing.accountdetails.AccountDetailsClient;
import com.merge.api.resources.ticketing.accounts.AccountsClient;
import com.merge.api.resources.ticketing.accounttoken.AccountTokenClient;
import com.merge.api.resources.ticketing.asyncpassthrough.AsyncPassthroughClient;
import com.merge.api.resources.ticketing.attachments.AttachmentsClient;
import com.merge.api.resources.ticketing.availableactions.AvailableActionsClient;
import com.merge.api.resources.ticketing.collections.CollectionsClient;
import com.merge.api.resources.ticketing.comments.CommentsClient;
import com.merge.api.resources.ticketing.contacts.ContactsClient;
import com.merge.api.resources.ticketing.deleteaccount.DeleteAccountClient;
import com.merge.api.resources.ticketing.forceresync.ForceResyncClient;
import com.merge.api.resources.ticketing.generatekey.GenerateKeyClient;
import com.merge.api.resources.ticketing.issues.IssuesClient;
import com.merge.api.resources.ticketing.linkedaccounts.LinkedAccountsClient;
import com.merge.api.resources.ticketing.linktoken.LinkTokenClient;
import com.merge.api.resources.ticketing.passthrough.PassthroughClient;
import com.merge.api.resources.ticketing.projects.ProjectsClient;
import com.merge.api.resources.ticketing.regeneratekey.RegenerateKeyClient;
import com.merge.api.resources.ticketing.selectivesync.SelectiveSyncClient;
import com.merge.api.resources.ticketing.syncstatus.SyncStatusClient;
import com.merge.api.resources.ticketing.tags.TagsClient;
import com.merge.api.resources.ticketing.teams.TeamsClient;
import com.merge.api.resources.ticketing.tickets.TicketsClient;
import com.merge.api.resources.ticketing.users.UsersClient;
import com.merge.api.resources.ticketing.webhookreceivers.WebhookReceiversClient;
import java.util.function.Supplier;

public class TicketingClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AccountDetailsClient> accountDetailsClient;

    protected final Supplier<AccountTokenClient> accountTokenClient;

    protected final Supplier<AccountsClient> accountsClient;

    protected final Supplier<AsyncPassthroughClient> asyncPassthroughClient;

    protected final Supplier<AttachmentsClient> attachmentsClient;

    protected final Supplier<AvailableActionsClient> availableActionsClient;

    protected final Supplier<CollectionsClient> collectionsClient;

    protected final Supplier<CommentsClient> commentsClient;

    protected final Supplier<ContactsClient> contactsClient;

    protected final Supplier<DeleteAccountClient> deleteAccountClient;

    protected final Supplier<GenerateKeyClient> generateKeyClient;

    protected final Supplier<IssuesClient> issuesClient;

    protected final Supplier<LinkTokenClient> linkTokenClient;

    protected final Supplier<LinkedAccountsClient> linkedAccountsClient;

    protected final Supplier<PassthroughClient> passthroughClient;

    protected final Supplier<ProjectsClient> projectsClient;

    protected final Supplier<RegenerateKeyClient> regenerateKeyClient;

    protected final Supplier<SelectiveSyncClient> selectiveSyncClient;

    protected final Supplier<SyncStatusClient> syncStatusClient;

    protected final Supplier<ForceResyncClient> forceResyncClient;

    protected final Supplier<TagsClient> tagsClient;

    protected final Supplier<TeamsClient> teamsClient;

    protected final Supplier<TicketsClient> ticketsClient;

    protected final Supplier<UsersClient> usersClient;

    protected final Supplier<WebhookReceiversClient> webhookReceiversClient;

    public TicketingClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.accountDetailsClient = Suppliers.memoize(() -> new AccountDetailsClient(clientOptions));
        this.accountTokenClient = Suppliers.memoize(() -> new AccountTokenClient(clientOptions));
        this.accountsClient = Suppliers.memoize(() -> new AccountsClient(clientOptions));
        this.asyncPassthroughClient = Suppliers.memoize(() -> new AsyncPassthroughClient(clientOptions));
        this.attachmentsClient = Suppliers.memoize(() -> new AttachmentsClient(clientOptions));
        this.availableActionsClient = Suppliers.memoize(() -> new AvailableActionsClient(clientOptions));
        this.collectionsClient = Suppliers.memoize(() -> new CollectionsClient(clientOptions));
        this.commentsClient = Suppliers.memoize(() -> new CommentsClient(clientOptions));
        this.contactsClient = Suppliers.memoize(() -> new ContactsClient(clientOptions));
        this.deleteAccountClient = Suppliers.memoize(() -> new DeleteAccountClient(clientOptions));
        this.generateKeyClient = Suppliers.memoize(() -> new GenerateKeyClient(clientOptions));
        this.issuesClient = Suppliers.memoize(() -> new IssuesClient(clientOptions));
        this.linkTokenClient = Suppliers.memoize(() -> new LinkTokenClient(clientOptions));
        this.linkedAccountsClient = Suppliers.memoize(() -> new LinkedAccountsClient(clientOptions));
        this.passthroughClient = Suppliers.memoize(() -> new PassthroughClient(clientOptions));
        this.projectsClient = Suppliers.memoize(() -> new ProjectsClient(clientOptions));
        this.regenerateKeyClient = Suppliers.memoize(() -> new RegenerateKeyClient(clientOptions));
        this.selectiveSyncClient = Suppliers.memoize(() -> new SelectiveSyncClient(clientOptions));
        this.syncStatusClient = Suppliers.memoize(() -> new SyncStatusClient(clientOptions));
        this.forceResyncClient = Suppliers.memoize(() -> new ForceResyncClient(clientOptions));
        this.tagsClient = Suppliers.memoize(() -> new TagsClient(clientOptions));
        this.teamsClient = Suppliers.memoize(() -> new TeamsClient(clientOptions));
        this.ticketsClient = Suppliers.memoize(() -> new TicketsClient(clientOptions));
        this.usersClient = Suppliers.memoize(() -> new UsersClient(clientOptions));
        this.webhookReceiversClient = Suppliers.memoize(() -> new WebhookReceiversClient(clientOptions));
    }

    public AccountDetailsClient accountDetails() {
        return this.accountDetailsClient.get();
    }

    public AccountTokenClient accountToken() {
        return this.accountTokenClient.get();
    }

    public AccountsClient accounts() {
        return this.accountsClient.get();
    }

    public AsyncPassthroughClient asyncPassthrough() {
        return this.asyncPassthroughClient.get();
    }

    public AttachmentsClient attachments() {
        return this.attachmentsClient.get();
    }

    public AvailableActionsClient availableActions() {
        return this.availableActionsClient.get();
    }

    public CollectionsClient collections() {
        return this.collectionsClient.get();
    }

    public CommentsClient comments() {
        return this.commentsClient.get();
    }

    public ContactsClient contacts() {
        return this.contactsClient.get();
    }

    public DeleteAccountClient deleteAccount() {
        return this.deleteAccountClient.get();
    }

    public GenerateKeyClient generateKey() {
        return this.generateKeyClient.get();
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

    public ProjectsClient projects() {
        return this.projectsClient.get();
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

    public TagsClient tags() {
        return this.tagsClient.get();
    }

    public TeamsClient teams() {
        return this.teamsClient.get();
    }

    public TicketsClient tickets() {
        return this.ticketsClient.get();
    }

    public UsersClient users() {
        return this.usersClient.get();
    }

    public WebhookReceiversClient webhookReceivers() {
        return this.webhookReceiversClient.get();
    }
}

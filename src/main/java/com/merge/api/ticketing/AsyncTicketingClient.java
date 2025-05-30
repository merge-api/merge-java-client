/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ticketing;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.Suppliers;
import java.util.function.Supplier;

public class AsyncTicketingClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AsyncAccountDetailsClient> accountDetailsClient;

    protected final Supplier<AsyncAccountTokenClient> accountTokenClient;

    protected final Supplier<AsyncAccountsClient> accountsClient;

    protected final Supplier<AsyncAsyncPassthroughClient> asyncPassthroughClient;

    protected final Supplier<AsyncAttachmentsClient> attachmentsClient;

    protected final Supplier<AsyncAuditTrailClient> auditTrailClient;

    protected final Supplier<AsyncAvailableActionsClient> availableActionsClient;

    protected final Supplier<AsyncCollectionsClient> collectionsClient;

    protected final Supplier<AsyncCommentsClient> commentsClient;

    protected final Supplier<AsyncContactsClient> contactsClient;

    protected final Supplier<AsyncScopesClient> scopesClient;

    protected final Supplier<AsyncDeleteAccountClient> deleteAccountClient;

    protected final Supplier<AsyncFieldMappingClient> fieldMappingClient;

    protected final Supplier<AsyncGenerateKeyClient> generateKeyClient;

    protected final Supplier<AsyncIssuesClient> issuesClient;

    protected final Supplier<AsyncLinkTokenClient> linkTokenClient;

    protected final Supplier<AsyncLinkedAccountsClient> linkedAccountsClient;

    protected final Supplier<AsyncPassthroughClient> passthroughClient;

    protected final Supplier<AsyncProjectsClient> projectsClient;

    protected final Supplier<AsyncRegenerateKeyClient> regenerateKeyClient;

    protected final Supplier<AsyncRolesClient> rolesClient;

    protected final Supplier<AsyncSyncStatusClient> syncStatusClient;

    protected final Supplier<AsyncForceResyncClient> forceResyncClient;

    protected final Supplier<AsyncTagsClient> tagsClient;

    protected final Supplier<AsyncTeamsClient> teamsClient;

    protected final Supplier<AsyncTicketsClient> ticketsClient;

    protected final Supplier<AsyncUsersClient> usersClient;

    protected final Supplier<AsyncWebhookReceiversClient> webhookReceiversClient;

    public AsyncTicketingClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.accountDetailsClient = Suppliers.memoize(() -> new AsyncAccountDetailsClient(clientOptions));
        this.accountTokenClient = Suppliers.memoize(() -> new AsyncAccountTokenClient(clientOptions));
        this.accountsClient = Suppliers.memoize(() -> new AsyncAccountsClient(clientOptions));
        this.asyncPassthroughClient = Suppliers.memoize(() -> new AsyncAsyncPassthroughClient(clientOptions));
        this.attachmentsClient = Suppliers.memoize(() -> new AsyncAttachmentsClient(clientOptions));
        this.auditTrailClient = Suppliers.memoize(() -> new AsyncAuditTrailClient(clientOptions));
        this.availableActionsClient = Suppliers.memoize(() -> new AsyncAvailableActionsClient(clientOptions));
        this.collectionsClient = Suppliers.memoize(() -> new AsyncCollectionsClient(clientOptions));
        this.commentsClient = Suppliers.memoize(() -> new AsyncCommentsClient(clientOptions));
        this.contactsClient = Suppliers.memoize(() -> new AsyncContactsClient(clientOptions));
        this.scopesClient = Suppliers.memoize(() -> new AsyncScopesClient(clientOptions));
        this.deleteAccountClient = Suppliers.memoize(() -> new AsyncDeleteAccountClient(clientOptions));
        this.fieldMappingClient = Suppliers.memoize(() -> new AsyncFieldMappingClient(clientOptions));
        this.generateKeyClient = Suppliers.memoize(() -> new AsyncGenerateKeyClient(clientOptions));
        this.issuesClient = Suppliers.memoize(() -> new AsyncIssuesClient(clientOptions));
        this.linkTokenClient = Suppliers.memoize(() -> new AsyncLinkTokenClient(clientOptions));
        this.linkedAccountsClient = Suppliers.memoize(() -> new AsyncLinkedAccountsClient(clientOptions));
        this.passthroughClient = Suppliers.memoize(() -> new AsyncPassthroughClient(clientOptions));
        this.projectsClient = Suppliers.memoize(() -> new AsyncProjectsClient(clientOptions));
        this.regenerateKeyClient = Suppliers.memoize(() -> new AsyncRegenerateKeyClient(clientOptions));
        this.rolesClient = Suppliers.memoize(() -> new AsyncRolesClient(clientOptions));
        this.syncStatusClient = Suppliers.memoize(() -> new AsyncSyncStatusClient(clientOptions));
        this.forceResyncClient = Suppliers.memoize(() -> new AsyncForceResyncClient(clientOptions));
        this.tagsClient = Suppliers.memoize(() -> new AsyncTagsClient(clientOptions));
        this.teamsClient = Suppliers.memoize(() -> new AsyncTeamsClient(clientOptions));
        this.ticketsClient = Suppliers.memoize(() -> new AsyncTicketsClient(clientOptions));
        this.usersClient = Suppliers.memoize(() -> new AsyncUsersClient(clientOptions));
        this.webhookReceiversClient = Suppliers.memoize(() -> new AsyncWebhookReceiversClient(clientOptions));
    }

    public AsyncAccountDetailsClient accountDetails() {
        return this.accountDetailsClient.get();
    }

    public AsyncAccountTokenClient accountToken() {
        return this.accountTokenClient.get();
    }

    public AsyncAccountsClient accounts() {
        return this.accountsClient.get();
    }

    public AsyncAsyncPassthroughClient asyncPassthrough() {
        return this.asyncPassthroughClient.get();
    }

    public AsyncAttachmentsClient attachments() {
        return this.attachmentsClient.get();
    }

    public AsyncAuditTrailClient auditTrail() {
        return this.auditTrailClient.get();
    }

    public AsyncAvailableActionsClient availableActions() {
        return this.availableActionsClient.get();
    }

    public AsyncCollectionsClient collections() {
        return this.collectionsClient.get();
    }

    public AsyncCommentsClient comments() {
        return this.commentsClient.get();
    }

    public AsyncContactsClient contacts() {
        return this.contactsClient.get();
    }

    public AsyncScopesClient scopes() {
        return this.scopesClient.get();
    }

    public AsyncDeleteAccountClient deleteAccount() {
        return this.deleteAccountClient.get();
    }

    public AsyncFieldMappingClient fieldMapping() {
        return this.fieldMappingClient.get();
    }

    public AsyncGenerateKeyClient generateKey() {
        return this.generateKeyClient.get();
    }

    public AsyncIssuesClient issues() {
        return this.issuesClient.get();
    }

    public AsyncLinkTokenClient linkToken() {
        return this.linkTokenClient.get();
    }

    public AsyncLinkedAccountsClient linkedAccounts() {
        return this.linkedAccountsClient.get();
    }

    public AsyncPassthroughClient passthrough() {
        return this.passthroughClient.get();
    }

    public AsyncProjectsClient projects() {
        return this.projectsClient.get();
    }

    public AsyncRegenerateKeyClient regenerateKey() {
        return this.regenerateKeyClient.get();
    }

    public AsyncRolesClient roles() {
        return this.rolesClient.get();
    }

    public AsyncSyncStatusClient syncStatus() {
        return this.syncStatusClient.get();
    }

    public AsyncForceResyncClient forceResync() {
        return this.forceResyncClient.get();
    }

    public AsyncTagsClient tags() {
        return this.tagsClient.get();
    }

    public AsyncTeamsClient teams() {
        return this.teamsClient.get();
    }

    public AsyncTicketsClient tickets() {
        return this.ticketsClient.get();
    }

    public AsyncUsersClient users() {
        return this.usersClient.get();
    }

    public AsyncWebhookReceiversClient webhookReceivers() {
        return this.webhookReceiversClient.get();
    }
}

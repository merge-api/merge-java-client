/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api;

import com.merge.api.accounting.AsyncAccountingClient;
import com.merge.api.ats.AsyncAtsClient;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.Suppliers;
import com.merge.api.crm.AsyncCrmClient;
import com.merge.api.filestorage.AsyncFileStorageClient;
import com.merge.api.hris.AsyncHrisClient;
import com.merge.api.ticketing.AsyncTicketingClient;
import java.util.function.Supplier;

public class AsyncMergeApiClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AsyncAtsClient> atsClient;

    protected final Supplier<AsyncAccountingClient> accountingClient;

    protected final Supplier<AsyncCrmClient> crmClient;

    protected final Supplier<AsyncFileStorageClient> fileStorageClient;

    protected final Supplier<AsyncHrisClient> hrisClient;

    protected final Supplier<AsyncTicketingClient> ticketingClient;

    public AsyncMergeApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.atsClient = Suppliers.memoize(() -> new AsyncAtsClient(clientOptions));
        this.accountingClient = Suppliers.memoize(() -> new AsyncAccountingClient(clientOptions));
        this.crmClient = Suppliers.memoize(() -> new AsyncCrmClient(clientOptions));
        this.fileStorageClient = Suppliers.memoize(() -> new AsyncFileStorageClient(clientOptions));
        this.hrisClient = Suppliers.memoize(() -> new AsyncHrisClient(clientOptions));
        this.ticketingClient = Suppliers.memoize(() -> new AsyncTicketingClient(clientOptions));
    }

    public AsyncAtsClient ats() {
        return this.atsClient.get();
    }

    public AsyncAccountingClient accounting() {
        return this.accountingClient.get();
    }

    public AsyncCrmClient crm() {
        return this.crmClient.get();
    }

    public AsyncFileStorageClient fileStorage() {
        return this.fileStorageClient.get();
    }

    public AsyncHrisClient hris() {
        return this.hrisClient.get();
    }

    public AsyncTicketingClient ticketing() {
        return this.ticketingClient.get();
    }

    public static AsyncMergeApiClientBuilder builder() {
        return new AsyncMergeApiClientBuilder();
    }
}

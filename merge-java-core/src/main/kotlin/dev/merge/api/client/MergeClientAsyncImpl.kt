package dev.merge.api.client

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.*
import dev.merge.api.services.async.*
import dev.merge.api.services.errorHandler

class MergeClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : MergeClientAsync {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val sync: MergeClient by lazy { MergeClientImpl(clientOptions) }

    private val hris: HrisServiceAsync by lazy { HrisServiceAsyncImpl(clientOptions) }

    private val ats: AtsServiceAsync by lazy { AtsServiceAsyncImpl(clientOptions) }

    private val accounting: AccountingServiceAsync by lazy {
        AccountingServiceAsyncImpl(clientOptions)
    }

    private val ticketing: TicketingServiceAsync by lazy {
        TicketingServiceAsyncImpl(clientOptions)
    }

    private val crm: CrmServiceAsync by lazy { CrmServiceAsyncImpl(clientOptions) }

    private val marketing: MarketingServiceAsync by lazy {
        MarketingServiceAsyncImpl(clientOptions)
    }

    private val fileStorage: FileStorageServiceAsync by lazy {
        FileStorageServiceAsyncImpl(clientOptions)
    }

    override fun sync(): MergeClient = sync

    override fun hris(): HrisServiceAsync = hris

    override fun ats(): AtsServiceAsync = ats

    override fun accounting(): AccountingServiceAsync = accounting

    override fun ticketing(): TicketingServiceAsync = ticketing

    override fun crm(): CrmServiceAsync = crm

    override fun marketing(): MarketingServiceAsync = marketing

    override fun fileStorage(): FileStorageServiceAsync = fileStorage
}

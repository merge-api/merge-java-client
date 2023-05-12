package dev.merge.api.client

import dev.merge.api.core.ClientOptions
import dev.merge.api.core.http.HttpResponse.Handler
import dev.merge.api.errors.MergeError
import dev.merge.api.models.*
import dev.merge.api.services.blocking.*
import dev.merge.api.services.errorHandler

class MergeClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : MergeClient {

    private val errorHandler: Handler<MergeError> = errorHandler(clientOptions.jsonMapper)

    private val async: MergeClientAsync by lazy { MergeClientAsyncImpl(clientOptions) }

    private val hris: HrisService by lazy { HrisServiceImpl(clientOptions) }

    private val ats: AtsService by lazy { AtsServiceImpl(clientOptions) }

    private val accounting: AccountingService by lazy { AccountingServiceImpl(clientOptions) }

    private val ticketing: TicketingService by lazy { TicketingServiceImpl(clientOptions) }

    private val crm: CrmService by lazy { CrmServiceImpl(clientOptions) }

    private val marketing: MarketingService by lazy { MarketingServiceImpl(clientOptions) }

    private val fileStorage: FileStorageService by lazy { FileStorageServiceImpl(clientOptions) }

    override fun async(): MergeClientAsync = async

    override fun hris(): HrisService = hris

    override fun ats(): AtsService = ats

    override fun accounting(): AccountingService = accounting

    override fun ticketing(): TicketingService = ticketing

    override fun crm(): CrmService = crm

    override fun marketing(): MarketingService = marketing

    override fun fileStorage(): FileStorageService = fileStorage
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.client

import dev.merge.api.models.*
import dev.merge.api.services.blocking.*

interface MergeClient {

    fun async(): MergeClientAsync

    fun hris(): HrisService

    fun ats(): AtsService

    fun accounting(): AccountingService

    fun ticketing(): TicketingService

    fun crm(): CrmService

    fun marketing(): MarketingService

    fun fileStorage(): FileStorageService
}

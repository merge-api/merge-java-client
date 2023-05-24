@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.client

import dev.merge.api.models.*
import dev.merge.api.services.async.*

interface MergeClientAsync {

    fun sync(): MergeClient

    fun hris(): HrisServiceAsync

    fun ats(): AtsServiceAsync

    fun accounting(): AccountingServiceAsync

    fun ticketing(): TicketingServiceAsync

    fun crm(): CrmServiceAsync

    fun marketing(): MarketingServiceAsync

    fun fileStorage(): FileStorageServiceAsync
}

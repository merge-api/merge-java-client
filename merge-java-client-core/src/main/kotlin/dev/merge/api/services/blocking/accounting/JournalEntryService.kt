@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.JournalEntry
import dev.merge.api.models.accounting.JournalEntryCreateParams
import dev.merge.api.models.accounting.JournalEntryListPage
import dev.merge.api.models.accounting.JournalEntryListParams
import dev.merge.api.models.accounting.JournalEntryResponse
import dev.merge.api.models.accounting.JournalEntryRetrieveParams
import dev.merge.api.services.blocking.accounting.journalEntries.MetaService

interface JournalEntryService {

    fun meta(): MetaService

    /** Creates a `JournalEntry` object with the given values. */
    @JvmOverloads
    fun create(
        params: JournalEntryCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): JournalEntryResponse

    /** Returns a `JournalEntry` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: JournalEntryRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): JournalEntry

    /** Returns a list of `JournalEntry` objects. */
    @JvmOverloads
    fun list(
        params: JournalEntryListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): JournalEntryListPage
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.JournalEntry
import dev.merge.api.models.accounting.JournalEntryCreateParams
import dev.merge.api.models.accounting.JournalEntryListPageAsync
import dev.merge.api.models.accounting.JournalEntryListParams
import dev.merge.api.models.accounting.JournalEntryResponse
import dev.merge.api.models.accounting.JournalEntryRetrieveParams
import dev.merge.api.services.async.accounting.journalEntries.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface JournalEntryServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `JournalEntry` object with the given values. */
    @JvmOverloads
    fun create(
        params: JournalEntryCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<JournalEntryResponse>

    /** Returns a `JournalEntry` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: JournalEntryRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<JournalEntry>

    /** Returns a list of `JournalEntry` objects. */
    @JvmOverloads
    fun list(
        params: JournalEntryListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<JournalEntryListPageAsync>
}

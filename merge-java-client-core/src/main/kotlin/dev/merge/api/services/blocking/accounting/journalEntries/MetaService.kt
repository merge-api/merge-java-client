@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting.journalEntries

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.accounting.JournalEntryMetaForCreateParams

interface MetaService {

    /** Returns metadata for `JournalEntry` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: JournalEntryMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.CreditNote
import dev.merge.api.models.accounting.CreditNoteListPage
import dev.merge.api.models.accounting.CreditNoteListParams
import dev.merge.api.models.accounting.CreditNoteRetrieveParams

interface CreditNoteService {

    /** Returns a `CreditNote` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CreditNoteRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CreditNote

    /** Returns a list of `CreditNote` objects. */
    @JvmOverloads
    fun list(
        params: CreditNoteListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CreditNoteListPage
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting.invoices

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.accounting.InvoiceMetaForCreateParams

interface MetaService {

    /** Returns metadata for `Invoice` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: InvoiceMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

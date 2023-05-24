@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.Invoice
import dev.merge.api.models.accounting.InvoiceCreateParams
import dev.merge.api.models.accounting.InvoiceListPage
import dev.merge.api.models.accounting.InvoiceListParams
import dev.merge.api.models.accounting.InvoiceResponse
import dev.merge.api.models.accounting.InvoiceRetrieveParams
import dev.merge.api.services.blocking.accounting.invoices.MetaService

interface InvoiceService {

    fun meta(): MetaService

    /** Creates an `Invoice` object with the given values. */
    @JvmOverloads
    fun create(
        params: InvoiceCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InvoiceResponse

    /** Returns an `Invoice` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: InvoiceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Invoice

    /** Returns a list of `Invoice` objects. */
    @JvmOverloads
    fun list(
        params: InvoiceListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InvoiceListPage
}

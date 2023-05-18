@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.Invoice
import dev.merge.api.models.accounting.InvoiceCreateParams
import dev.merge.api.models.accounting.InvoiceListPageAsync
import dev.merge.api.models.accounting.InvoiceListParams
import dev.merge.api.models.accounting.InvoiceResponse
import dev.merge.api.models.accounting.InvoiceRetrieveParams
import dev.merge.api.services.async.accounting.invoices.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface InvoiceServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Invoice` object with the given values. */
    @JvmOverloads
    fun create(
        params: InvoiceCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<InvoiceResponse>

    /** Returns an `Invoice` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: InvoiceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Invoice>

    /** Returns a list of `Invoice` objects. */
    @JvmOverloads
    fun list(
        params: InvoiceListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<InvoiceListPageAsync>
}

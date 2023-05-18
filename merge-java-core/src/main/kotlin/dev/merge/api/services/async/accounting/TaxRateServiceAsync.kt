@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.TaxRate
import dev.merge.api.models.accounting.TaxRateListPageAsync
import dev.merge.api.models.accounting.TaxRateListParams
import dev.merge.api.models.accounting.TaxRateRetrieveParams
import java.util.concurrent.CompletableFuture

interface TaxRateServiceAsync {

    /** Returns a `TaxRate` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TaxRateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TaxRate>

    /** Returns a list of `TaxRate` objects. */
    @JvmOverloads
    fun list(
        params: TaxRateListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TaxRateListPageAsync>
}

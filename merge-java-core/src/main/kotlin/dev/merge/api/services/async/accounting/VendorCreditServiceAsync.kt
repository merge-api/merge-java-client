@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.VendorCredit
import dev.merge.api.models.accounting.VendorCreditListPageAsync
import dev.merge.api.models.accounting.VendorCreditListParams
import dev.merge.api.models.accounting.VendorCreditRetrieveParams
import java.util.concurrent.CompletableFuture

interface VendorCreditServiceAsync {

    /** Returns a `VendorCredit` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: VendorCreditRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<VendorCredit>

    /** Returns a list of `VendorCredit` objects. */
    @JvmOverloads
    fun list(
        params: VendorCreditListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<VendorCreditListPageAsync>
}

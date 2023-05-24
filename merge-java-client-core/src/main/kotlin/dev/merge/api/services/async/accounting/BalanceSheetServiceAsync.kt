@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.BalanceSheet
import dev.merge.api.models.accounting.BalanceSheetListPageAsync
import dev.merge.api.models.accounting.BalanceSheetListParams
import dev.merge.api.models.accounting.BalanceSheetRetrieveParams
import java.util.concurrent.CompletableFuture

interface BalanceSheetServiceAsync {

    /** Returns a `BalanceSheet` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: BalanceSheetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<BalanceSheet>

    /** Returns a list of `BalanceSheet` objects. */
    @JvmOverloads
    fun list(
        params: BalanceSheetListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<BalanceSheetListPageAsync>
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.Transaction
import dev.merge.api.models.accounting.TransactionListPageAsync
import dev.merge.api.models.accounting.TransactionListParams
import dev.merge.api.models.accounting.TransactionRetrieveParams
import java.util.concurrent.CompletableFuture

interface TransactionServiceAsync {

    /** Returns a `Transaction` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TransactionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Transaction>

    /** Returns a list of `Transaction` objects. */
    @JvmOverloads
    fun list(
        params: TransactionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TransactionListPageAsync>
}

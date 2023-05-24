@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.Transaction
import dev.merge.api.models.accounting.TransactionListPage
import dev.merge.api.models.accounting.TransactionListParams
import dev.merge.api.models.accounting.TransactionRetrieveParams

interface TransactionService {

    /** Returns a `Transaction` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TransactionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Transaction

    /** Returns a list of `Transaction` objects. */
    @JvmOverloads
    fun list(
        params: TransactionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TransactionListPage
}

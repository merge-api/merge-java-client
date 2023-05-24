@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.Expense
import dev.merge.api.models.accounting.ExpenseCreateParams
import dev.merge.api.models.accounting.ExpenseListPageAsync
import dev.merge.api.models.accounting.ExpenseListParams
import dev.merge.api.models.accounting.ExpenseResponse
import dev.merge.api.models.accounting.ExpenseRetrieveParams
import dev.merge.api.services.async.accounting.expenses.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface ExpenseServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Expense` object with the given values. */
    @JvmOverloads
    fun create(
        params: ExpenseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ExpenseResponse>

    /** Returns an `Expense` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ExpenseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Expense>

    /** Returns a list of `Expense` objects. */
    @JvmOverloads
    fun list(
        params: ExpenseListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ExpenseListPageAsync>
}

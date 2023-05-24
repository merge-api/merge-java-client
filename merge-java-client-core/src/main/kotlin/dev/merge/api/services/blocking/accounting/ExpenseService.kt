@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.Expense
import dev.merge.api.models.accounting.ExpenseCreateParams
import dev.merge.api.models.accounting.ExpenseListPage
import dev.merge.api.models.accounting.ExpenseListParams
import dev.merge.api.models.accounting.ExpenseResponse
import dev.merge.api.models.accounting.ExpenseRetrieveParams
import dev.merge.api.services.blocking.accounting.expenses.MetaService

interface ExpenseService {

    fun meta(): MetaService

    /** Creates an `Expense` object with the given values. */
    @JvmOverloads
    fun create(
        params: ExpenseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ExpenseResponse

    /** Returns an `Expense` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ExpenseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Expense

    /** Returns a list of `Expense` objects. */
    @JvmOverloads
    fun list(
        params: ExpenseListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ExpenseListPage
}

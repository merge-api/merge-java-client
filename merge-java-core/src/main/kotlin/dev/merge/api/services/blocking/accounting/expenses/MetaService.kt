@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting.expenses

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.accounting.ExpenseMetaForCreateParams

interface MetaService {

    /** Returns metadata for `Expense` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: ExpenseMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

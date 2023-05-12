@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.IncomeStatement
import dev.merge.api.models.accounting.IncomeStatementListPage
import dev.merge.api.models.accounting.IncomeStatementListParams
import dev.merge.api.models.accounting.IncomeStatementRetrieveParams

interface IncomeStatementService {

    /** Returns an `IncomeStatement` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: IncomeStatementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IncomeStatement

    /** Returns a list of `IncomeStatement` objects. */
    @JvmOverloads
    fun list(
        params: IncomeStatementListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IncomeStatementListPage
}

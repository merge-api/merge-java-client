@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.CashFlowStatement
import dev.merge.api.models.accounting.CashFlowStatementListPage
import dev.merge.api.models.accounting.CashFlowStatementListParams
import dev.merge.api.models.accounting.CashFlowStatementRetrieveParams

interface CashFlowStatementService {

    /** Returns a `CashFlowStatement` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CashFlowStatementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CashFlowStatement

    /** Returns a list of `CashFlowStatement` objects. */
    @JvmOverloads
    fun list(
        params: CashFlowStatementListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CashFlowStatementListPage
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.IncomeStatement
import dev.merge.api.models.accounting.IncomeStatementListPageAsync
import dev.merge.api.models.accounting.IncomeStatementListParams
import dev.merge.api.models.accounting.IncomeStatementRetrieveParams
import java.util.concurrent.CompletableFuture

interface IncomeStatementServiceAsync {

    /** Returns an `IncomeStatement` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: IncomeStatementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<IncomeStatement>

    /** Returns a list of `IncomeStatement` objects. */
    @JvmOverloads
    fun list(
        params: IncomeStatementListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<IncomeStatementListPageAsync>
}

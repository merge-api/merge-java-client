@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.BalanceSheet
import dev.merge.api.models.accounting.BalanceSheetListPage
import dev.merge.api.models.accounting.BalanceSheetListParams
import dev.merge.api.models.accounting.BalanceSheetRetrieveParams

interface BalanceSheetService {

    /** Returns a `BalanceSheet` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: BalanceSheetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BalanceSheet

    /** Returns a list of `BalanceSheet` objects. */
    @JvmOverloads
    fun list(
        params: BalanceSheetListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BalanceSheetListPage
}

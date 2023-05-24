@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.TimeOffBalance
import dev.merge.api.models.hris.TimeOffBalanceListPage
import dev.merge.api.models.hris.TimeOffBalanceListParams
import dev.merge.api.models.hris.TimeOffBalanceRetrieveParams

interface TimeOffBalanceService {

    /** Returns a `TimeOffBalance` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TimeOffBalanceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TimeOffBalance

    /** Returns a list of `TimeOffBalance` objects. */
    @JvmOverloads
    fun list(
        params: TimeOffBalanceListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TimeOffBalanceListPage
}

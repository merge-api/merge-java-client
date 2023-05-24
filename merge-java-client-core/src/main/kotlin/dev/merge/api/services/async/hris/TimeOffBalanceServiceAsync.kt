@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.TimeOffBalance
import dev.merge.api.models.hris.TimeOffBalanceListPageAsync
import dev.merge.api.models.hris.TimeOffBalanceListParams
import dev.merge.api.models.hris.TimeOffBalanceRetrieveParams
import java.util.concurrent.CompletableFuture

interface TimeOffBalanceServiceAsync {

    /** Returns a `TimeOffBalance` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TimeOffBalanceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TimeOffBalance>

    /** Returns a list of `TimeOffBalance` objects. */
    @JvmOverloads
    fun list(
        params: TimeOffBalanceListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TimeOffBalanceListPageAsync>
}

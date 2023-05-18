@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.TimeOff
import dev.merge.api.models.hris.TimeOffCreateParams
import dev.merge.api.models.hris.TimeOffListPageAsync
import dev.merge.api.models.hris.TimeOffListParams
import dev.merge.api.models.hris.TimeOffResponse
import dev.merge.api.models.hris.TimeOffRetrieveParams
import dev.merge.api.services.async.hris.timeOff.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface TimeOffServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `TimeOff` object with the given values. */
    @JvmOverloads
    fun create(
        params: TimeOffCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TimeOffResponse>

    /** Returns a `TimeOff` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TimeOffRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TimeOff>

    /** Returns a list of `TimeOff` objects. */
    @JvmOverloads
    fun list(
        params: TimeOffListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TimeOffListPageAsync>
}

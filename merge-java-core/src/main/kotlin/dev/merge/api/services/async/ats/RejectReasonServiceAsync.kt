@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.RejectReason
import dev.merge.api.models.ats.RejectReasonListPageAsync
import dev.merge.api.models.ats.RejectReasonListParams
import dev.merge.api.models.ats.RejectReasonRetrieveParams
import java.util.concurrent.CompletableFuture

interface RejectReasonServiceAsync {

    /** Returns a `RejectReason` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: RejectReasonRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<RejectReason>

    /** Returns a list of `RejectReason` objects. */
    @JvmOverloads
    fun list(
        params: RejectReasonListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<RejectReasonListPageAsync>
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Scorecard
import dev.merge.api.models.ats.ScorecardListPageAsync
import dev.merge.api.models.ats.ScorecardListParams
import dev.merge.api.models.ats.ScorecardRetrieveParams
import java.util.concurrent.CompletableFuture

interface ScorecardServiceAsync {

    /** Returns a `Scorecard` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ScorecardRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Scorecard>

    /** Returns a list of `Scorecard` objects. */
    @JvmOverloads
    fun list(
        params: ScorecardListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ScorecardListPageAsync>
}

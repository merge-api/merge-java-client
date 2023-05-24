@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Scorecard
import dev.merge.api.models.ats.ScorecardListPage
import dev.merge.api.models.ats.ScorecardListParams
import dev.merge.api.models.ats.ScorecardRetrieveParams

interface ScorecardService {

    /** Returns a `Scorecard` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ScorecardRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Scorecard

    /** Returns a list of `Scorecard` objects. */
    @JvmOverloads
    fun list(
        params: ScorecardListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ScorecardListPage
}

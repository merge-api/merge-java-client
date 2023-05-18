@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats.candidates

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.ats.CandidateMetaForCreateParams

interface MetaService {

    /** Returns metadata for `Candidate` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: CandidateMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

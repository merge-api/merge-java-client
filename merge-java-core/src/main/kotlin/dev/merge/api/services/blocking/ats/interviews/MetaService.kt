@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats.interviews

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.ats.InterviewMetaForCreateParams

interface MetaService {

    /** Returns metadata for `ScheduledInterview` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: InterviewMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

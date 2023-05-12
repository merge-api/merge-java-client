@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.InterviewCreateParams
import dev.merge.api.models.ats.InterviewListPage
import dev.merge.api.models.ats.InterviewListParams
import dev.merge.api.models.ats.InterviewRetrieveParams
import dev.merge.api.models.ats.ScheduledInterview
import dev.merge.api.models.ats.ScheduledInterviewResponse
import dev.merge.api.services.blocking.ats.interviews.MetaService

interface InterviewService {

    fun meta(): MetaService

    /** Creates a `ScheduledInterview` object with the given values. */
    @JvmOverloads
    fun create(
        params: InterviewCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ScheduledInterviewResponse

    /** Returns a `ScheduledInterview` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: InterviewRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ScheduledInterview

    /** Returns a list of `ScheduledInterview` objects. */
    @JvmOverloads
    fun list(
        params: InterviewListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InterviewListPage
}

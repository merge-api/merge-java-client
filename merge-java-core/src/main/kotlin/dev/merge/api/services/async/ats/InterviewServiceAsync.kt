@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.InterviewCreateParams
import dev.merge.api.models.ats.InterviewListPageAsync
import dev.merge.api.models.ats.InterviewListParams
import dev.merge.api.models.ats.InterviewRetrieveParams
import dev.merge.api.models.ats.ScheduledInterview
import dev.merge.api.models.ats.ScheduledInterviewResponse
import dev.merge.api.services.async.ats.interviews.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface InterviewServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates a `ScheduledInterview` object with the given values. */
    @JvmOverloads
    fun create(
        params: InterviewCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ScheduledInterviewResponse>

    /** Returns a `ScheduledInterview` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: InterviewRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ScheduledInterview>

    /** Returns a list of `ScheduledInterview` objects. */
    @JvmOverloads
    fun list(
        params: InterviewListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<InterviewListPageAsync>
}

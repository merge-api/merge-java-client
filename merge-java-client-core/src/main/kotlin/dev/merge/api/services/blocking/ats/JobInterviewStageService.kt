@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.JobInterviewStage
import dev.merge.api.models.ats.JobInterviewStageListPage
import dev.merge.api.models.ats.JobInterviewStageListParams
import dev.merge.api.models.ats.JobInterviewStageRetrieveParams

interface JobInterviewStageService {

    /** Returns a `JobInterviewStage` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: JobInterviewStageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): JobInterviewStage

    /** Returns a list of `JobInterviewStage` objects. */
    @JvmOverloads
    fun list(
        params: JobInterviewStageListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): JobInterviewStageListPage
}

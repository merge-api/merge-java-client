@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.JobInterviewStage
import dev.merge.api.models.ats.JobInterviewStageListPageAsync
import dev.merge.api.models.ats.JobInterviewStageListParams
import dev.merge.api.models.ats.JobInterviewStageRetrieveParams
import java.util.concurrent.CompletableFuture

interface JobInterviewStageServiceAsync {

    /** Returns a `JobInterviewStage` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: JobInterviewStageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<JobInterviewStage>

    /** Returns a list of `JobInterviewStage` objects. */
    @JvmOverloads
    fun list(
        params: JobInterviewStageListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<JobInterviewStageListPageAsync>
}

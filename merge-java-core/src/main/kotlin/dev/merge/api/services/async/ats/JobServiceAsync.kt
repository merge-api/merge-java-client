@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Job
import dev.merge.api.models.ats.JobListPageAsync
import dev.merge.api.models.ats.JobListParams
import dev.merge.api.models.ats.JobRetrieveParams
import java.util.concurrent.CompletableFuture

interface JobServiceAsync {

    /** Returns a `Job` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: JobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Job>

    /** Returns a list of `Job` objects. */
    @JvmOverloads
    fun list(
        params: JobListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<JobListPageAsync>
}

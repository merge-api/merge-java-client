@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Job
import dev.merge.api.models.ats.JobListPage
import dev.merge.api.models.ats.JobListParams
import dev.merge.api.models.ats.JobRetrieveParams

interface JobService {

    /** Returns a `Job` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: JobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Job

    /** Returns a list of `Job` objects. */
    @JvmOverloads
    fun list(
        params: JobListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): JobListPage
}

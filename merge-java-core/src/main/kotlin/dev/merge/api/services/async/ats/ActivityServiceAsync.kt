@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Activity
import dev.merge.api.models.ats.ActivityCreateParams
import dev.merge.api.models.ats.ActivityCreateResponse
import dev.merge.api.models.ats.ActivityListPageAsync
import dev.merge.api.models.ats.ActivityListParams
import dev.merge.api.models.ats.ActivityRetrieveParams
import dev.merge.api.services.async.ats.activities.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface ActivityServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Activity` object with the given values. */
    @JvmOverloads
    fun create(
        params: ActivityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ActivityCreateResponse>

    /** Returns an `Activity` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ActivityRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Activity>

    /** Returns a list of `Activity` objects. */
    @JvmOverloads
    fun list(
        params: ActivityListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ActivityListPageAsync>
}

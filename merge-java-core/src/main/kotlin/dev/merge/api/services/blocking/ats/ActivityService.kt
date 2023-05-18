@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Activity
import dev.merge.api.models.ats.ActivityCreateParams
import dev.merge.api.models.ats.ActivityCreateResponse
import dev.merge.api.models.ats.ActivityListPage
import dev.merge.api.models.ats.ActivityListParams
import dev.merge.api.models.ats.ActivityRetrieveParams
import dev.merge.api.services.blocking.ats.activities.MetaService

interface ActivityService {

    fun meta(): MetaService

    /** Creates an `Activity` object with the given values. */
    @JvmOverloads
    fun create(
        params: ActivityCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ActivityCreateResponse

    /** Returns an `Activity` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: ActivityRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Activity

    /** Returns a list of `Activity` objects. */
    @JvmOverloads
    fun list(
        params: ActivityListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ActivityListPage
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats.activities

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.ats.ActivityMetaForCreateParams

interface MetaService {

    /** Returns metadata for `Activity` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: ActivityMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

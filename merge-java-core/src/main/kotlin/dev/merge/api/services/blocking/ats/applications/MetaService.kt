@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats.applications

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.ats.ApplicationMetaForCreateParams

interface MetaService {

    /** Returns metadata for `Application` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: ApplicationMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

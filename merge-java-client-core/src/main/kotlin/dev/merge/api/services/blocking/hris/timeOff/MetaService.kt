@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris.timeOff

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.hris.TimeOffMetaForCreateParams

interface MetaService {

    /** Returns metadata for `TimeOff` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: TimeOffMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

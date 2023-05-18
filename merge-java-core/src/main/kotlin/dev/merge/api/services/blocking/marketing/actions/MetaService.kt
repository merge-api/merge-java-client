@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing.actions

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.marketing.ActionMetaForCreateParams

interface MetaService {

    /** Returns metadata for `MKTGAction` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: ActionMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

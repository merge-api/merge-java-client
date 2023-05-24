@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm.engagements

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.EngagementMetaForCreateParams
import dev.merge.api.models.crm.EngagementMetaForUpdateParams

interface MetaService {

    /** Returns metadata for `Engagement` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: EngagementMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse

    /** Returns metadata for `Engagement` PATCHs. */
    @JvmOverloads
    fun forUpdate(
        params: EngagementMetaForUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

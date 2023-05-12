@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing.campaigns

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.marketing.CampaignMetaForCreateParams

interface MetaService {

    /** Returns metadata for `MKTGCampaign` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: CampaignMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

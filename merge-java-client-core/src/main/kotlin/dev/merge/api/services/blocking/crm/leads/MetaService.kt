@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm.leads

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.LeadMetaForCreateParams

interface MetaService {

    /** Returns metadata for `Lead` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: LeadMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm.contacts

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.ContactMetaForCreateParams
import dev.merge.api.models.crm.ContactMetaForUpdateParams

interface MetaService {

    /** Returns metadata for `CRMContact` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: ContactMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse

    /** Returns metadata for `CRMContact` PATCHs. */
    @JvmOverloads
    fun forUpdate(
        params: ContactMetaForUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

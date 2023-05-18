@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing.contacts

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.marketing.ContactMetaForCreateParams

interface MetaService {

    /** Returns metadata for `MKTGContact` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: ContactMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

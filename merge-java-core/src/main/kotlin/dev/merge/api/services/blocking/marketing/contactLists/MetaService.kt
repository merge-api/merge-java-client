@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing.contactLists

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.marketing.ContactListMetaForCreateParams

interface MetaService {

    /** Returns metadata for `MKTGList` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: ContactListMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

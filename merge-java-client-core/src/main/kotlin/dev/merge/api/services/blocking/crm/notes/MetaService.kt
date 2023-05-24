@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.crm.notes

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.NoteMetaForCreateParams

interface MetaService {

    /** Returns metadata for `Note` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: NoteMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

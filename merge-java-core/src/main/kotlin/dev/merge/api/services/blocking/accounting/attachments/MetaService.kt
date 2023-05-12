@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting.attachments

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.accounting.AttachmentMetaForCreateParams

interface MetaService {

    /** Returns metadata for `AccountingAttachment` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: AttachmentMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Attachment
import dev.merge.api.models.ats.AttachmentCreateParams
import dev.merge.api.models.ats.AttachmentListPage
import dev.merge.api.models.ats.AttachmentListParams
import dev.merge.api.models.ats.AttachmentResponse
import dev.merge.api.models.ats.AttachmentRetrieveParams
import dev.merge.api.services.blocking.ats.attachments.MetaService

interface AttachmentService {

    fun meta(): MetaService

    /** Creates an `Attachment` object with the given values. */
    @JvmOverloads
    fun create(
        params: AttachmentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AttachmentResponse

    /** Returns an `Attachment` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: AttachmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Attachment

    /** Returns a list of `Attachment` objects. */
    @JvmOverloads
    fun list(
        params: AttachmentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AttachmentListPage
}

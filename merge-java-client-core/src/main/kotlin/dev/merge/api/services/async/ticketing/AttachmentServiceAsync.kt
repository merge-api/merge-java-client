@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Attachment
import dev.merge.api.models.ticketing.AttachmentCreateParams
import dev.merge.api.models.ticketing.AttachmentCreateResponse
import dev.merge.api.models.ticketing.AttachmentListPageAsync
import dev.merge.api.models.ticketing.AttachmentListParams
import dev.merge.api.models.ticketing.AttachmentRetrieveParams
import dev.merge.api.services.async.ticketing.attachments.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface AttachmentServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `Attachment` object with the given values. */
    @JvmOverloads
    fun create(
        params: AttachmentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AttachmentCreateResponse>

    /** Returns an `Attachment` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: AttachmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Attachment>

    /** Returns a list of `Attachment` objects. */
    @JvmOverloads
    fun list(
        params: AttachmentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AttachmentListPageAsync>
}

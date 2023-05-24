@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats.attachments

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.ats.AttachmentMetaForCreateParams
import java.util.concurrent.CompletableFuture

interface MetaServiceAsync {

    /** Returns metadata for `Attachment` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: AttachmentMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MetaResponse>
}

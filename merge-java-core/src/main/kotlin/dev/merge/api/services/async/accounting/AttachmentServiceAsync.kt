@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.AccountingAttachment
import dev.merge.api.models.accounting.AccountingAttachmentResponse
import dev.merge.api.models.accounting.AttachmentCreateParams
import dev.merge.api.models.accounting.AttachmentListPageAsync
import dev.merge.api.models.accounting.AttachmentListParams
import dev.merge.api.models.accounting.AttachmentRetrieveParams
import dev.merge.api.services.async.accounting.attachments.MetaServiceAsync
import java.util.concurrent.CompletableFuture

interface AttachmentServiceAsync {

    fun meta(): MetaServiceAsync

    /** Creates an `AccountingAttachment` object with the given values. */
    @JvmOverloads
    fun create(
        params: AttachmentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountingAttachmentResponse>

    /** Returns an `AccountingAttachment` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: AttachmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AccountingAttachment>

    /** Returns a list of `AccountingAttachment` objects. */
    @JvmOverloads
    fun list(
        params: AttachmentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<AttachmentListPageAsync>
}

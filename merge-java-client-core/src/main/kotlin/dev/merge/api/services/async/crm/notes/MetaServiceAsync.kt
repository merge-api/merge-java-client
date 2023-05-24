@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm.notes

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.crm.NoteMetaForCreateParams
import java.util.concurrent.CompletableFuture

interface MetaServiceAsync {

    /** Returns metadata for `Note` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: NoteMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MetaResponse>
}

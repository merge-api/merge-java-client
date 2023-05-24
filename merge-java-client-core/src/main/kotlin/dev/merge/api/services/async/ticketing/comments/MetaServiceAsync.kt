@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ticketing.comments

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.ticketing.CommentMetaForCreateParams
import java.util.concurrent.CompletableFuture

interface MetaServiceAsync {

    /** Returns metadata for `Comment` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: CommentMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MetaResponse>
}

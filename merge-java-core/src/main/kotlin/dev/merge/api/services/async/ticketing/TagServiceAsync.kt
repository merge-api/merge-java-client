@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Tag
import dev.merge.api.models.ticketing.TagListPageAsync
import dev.merge.api.models.ticketing.TagListParams
import dev.merge.api.models.ticketing.TagRetrieveParams
import java.util.concurrent.CompletableFuture

interface TagServiceAsync {

    /** Returns a `Tag` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TagRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Tag>

    /** Returns a list of `Tag` objects. */
    @JvmOverloads
    fun list(
        params: TagListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TagListPageAsync>
}

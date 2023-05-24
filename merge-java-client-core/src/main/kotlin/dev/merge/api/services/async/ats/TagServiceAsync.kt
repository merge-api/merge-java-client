@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.TagListPageAsync
import dev.merge.api.models.ats.TagListParams
import java.util.concurrent.CompletableFuture

interface TagServiceAsync {

    /** Returns a list of `Tag` objects. */
    @JvmOverloads
    fun list(
        params: TagListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<TagListPageAsync>
}

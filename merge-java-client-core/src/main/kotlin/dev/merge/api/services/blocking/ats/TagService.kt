@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.TagListPage
import dev.merge.api.models.ats.TagListParams

interface TagService {

    /** Returns a list of `Tag` objects. */
    @JvmOverloads
    fun list(
        params: TagListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TagListPage
}

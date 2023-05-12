@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.Tag
import dev.merge.api.models.ticketing.TagListPage
import dev.merge.api.models.ticketing.TagListParams
import dev.merge.api.models.ticketing.TagRetrieveParams

interface TagService {

    /** Returns a `Tag` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TagRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Tag

    /** Returns a list of `Tag` objects. */
    @JvmOverloads
    fun list(
        params: TagListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TagListPage
}

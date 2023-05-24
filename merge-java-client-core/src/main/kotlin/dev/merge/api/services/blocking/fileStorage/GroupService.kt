@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.fileStorage.Group
import dev.merge.api.models.fileStorage.GroupListPage
import dev.merge.api.models.fileStorage.GroupListParams
import dev.merge.api.models.fileStorage.GroupRetrieveParams

interface GroupService {

    /** Returns a `Group` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: GroupRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Group

    /** Returns a list of `Group` objects. */
    @JvmOverloads
    fun list(
        params: GroupListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): GroupListPage
}

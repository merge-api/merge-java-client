@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.Group
import dev.merge.api.models.hris.GroupListPageAsync
import dev.merge.api.models.hris.GroupListParams
import dev.merge.api.models.hris.GroupRetrieveParams
import java.util.concurrent.CompletableFuture

interface GroupServiceAsync {

    /** Returns a `Group` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: GroupRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Group>

    /** Returns a list of `Group` objects. */
    @JvmOverloads
    fun list(
        params: GroupListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<GroupListPageAsync>
}

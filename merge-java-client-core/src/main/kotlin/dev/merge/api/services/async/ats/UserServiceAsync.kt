@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.RemoteUser
import dev.merge.api.models.ats.UserListPageAsync
import dev.merge.api.models.ats.UserListParams
import dev.merge.api.models.ats.UserRetrieveParams
import java.util.concurrent.CompletableFuture

interface UserServiceAsync {

    /** Returns a `RemoteUser` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<RemoteUser>

    /** Returns a list of `RemoteUser` objects. */
    @JvmOverloads
    fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<UserListPageAsync>
}

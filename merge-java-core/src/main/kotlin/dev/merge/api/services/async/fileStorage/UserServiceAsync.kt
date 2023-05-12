@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.fileStorage.User
import dev.merge.api.models.fileStorage.UserListPageAsync
import dev.merge.api.models.fileStorage.UserListParams
import dev.merge.api.models.fileStorage.UserRetrieveParams
import java.util.concurrent.CompletableFuture

interface UserServiceAsync {

    /** Returns a `User` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<User>

    /** Returns a list of `User` objects. */
    @JvmOverloads
    fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<UserListPageAsync>
}

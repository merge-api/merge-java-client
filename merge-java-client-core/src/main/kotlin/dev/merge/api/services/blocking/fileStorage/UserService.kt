@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.fileStorage.User
import dev.merge.api.models.fileStorage.UserListPage
import dev.merge.api.models.fileStorage.UserListParams
import dev.merge.api.models.fileStorage.UserRetrieveParams

interface UserService {

    /** Returns a `User` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): User

    /** Returns a list of `User` objects. */
    @JvmOverloads
    fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): UserListPage
}

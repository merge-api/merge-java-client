@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ticketing.User
import dev.merge.api.models.ticketing.UserListPage
import dev.merge.api.models.ticketing.UserListParams
import dev.merge.api.models.ticketing.UserRetrieveParams

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

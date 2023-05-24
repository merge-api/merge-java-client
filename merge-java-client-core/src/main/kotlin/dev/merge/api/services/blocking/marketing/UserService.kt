@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.marketing.User
import dev.merge.api.models.marketing.UserListPage
import dev.merge.api.models.marketing.UserListParams
import dev.merge.api.models.marketing.UserRetrieveParams

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

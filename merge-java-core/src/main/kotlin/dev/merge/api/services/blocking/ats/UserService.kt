@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.RemoteUser
import dev.merge.api.models.ats.UserListPage
import dev.merge.api.models.ats.UserListParams
import dev.merge.api.models.ats.UserRetrieveParams

interface UserService {

    /** Returns a `RemoteUser` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RemoteUser

    /** Returns a list of `RemoteUser` objects. */
    @JvmOverloads
    fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): UserListPage
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ticketing.Collection
import dev.merge.api.models.ticketing.CollectionListPage
import dev.merge.api.models.ticketing.CollectionListParams
import dev.merge.api.models.ticketing.CollectionListUsersPage
import dev.merge.api.models.ticketing.CollectionListUsersParams
import dev.merge.api.models.ticketing.CollectionRetrieveParams

interface CollectionService {

    /** Returns a `Collection` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CollectionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Collection

    /** Returns a list of `Collection` objects. */
    @JvmOverloads
    fun list(
        params: CollectionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CollectionListPage

    /** Returns a list of `User` objects. */
    @JvmOverloads
    fun listUsers(
        params: CollectionListUsersParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CollectionListUsersPage
}

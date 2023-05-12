@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.crm

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.crm.User
import dev.merge.api.models.crm.UserIgnoreRowParams
import dev.merge.api.models.crm.UserListPageAsync
import dev.merge.api.models.crm.UserListParams
import dev.merge.api.models.crm.UserListRemoteFieldClassesPageAsync
import dev.merge.api.models.crm.UserListRemoteFieldClassesParams
import dev.merge.api.models.crm.UserRetrieveParams
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

    /**
     * Ignores a specific row based on the `model_id` in the url. These records will have their
     * properties set to null, and will not be updated in future syncs. The "reason" and "message"
     * fields in the request body will be stored for audit purposes.
     */
    @JvmOverloads
    fun ignoreRow(
        params: UserIgnoreRowParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Void>

    /** Returns a list of `RemoteFieldClass` objects. */
    @JvmOverloads
    fun listRemoteFieldClasses(
        params: UserListRemoteFieldClassesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<UserListRemoteFieldClassesPageAsync>
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.RemoteKey
import dev.merge.api.models.ticketing.RemoteKeyGenerateParams
import dev.merge.api.models.ticketing.RemoteKeyRegenerateParams
import java.util.concurrent.CompletableFuture

interface RemoteKeyServiceAsync {

    /** Create a remote key. */
    @JvmOverloads
    fun generate(
        params: RemoteKeyGenerateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<RemoteKey>

    /** Exchange remote keys. */
    @JvmOverloads
    fun regenerate(
        params: RemoteKeyRegenerateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<RemoteKey>
}

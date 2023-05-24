@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ticketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.RemoteResponse
import dev.merge.api.models.ticketing.PassthroughRequestSendParams
import java.util.concurrent.CompletableFuture

interface PassthroughRequestServiceAsync {

    /** Pull data from an endpoint not currently supported by Merge. */
    @JvmOverloads
    fun send(
        params: PassthroughRequestSendParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<RemoteResponse>
}

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.RemoteResponse
import dev.merge.api.models.marketing.PassthroughRequestSendParams

interface PassthroughRequestService {

    /** Pull data from an endpoint not currently supported by Merge. */
    @JvmOverloads
    fun send(
        params: PassthroughRequestSendParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RemoteResponse
}

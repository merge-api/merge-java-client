@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.marketing

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.RemoteKey
import dev.merge.api.models.marketing.RemoteKeyGenerateParams
import dev.merge.api.models.marketing.RemoteKeyRegenerateParams

interface RemoteKeyService {

    /** Create a remote key. */
    @JvmOverloads
    fun generate(
        params: RemoteKeyGenerateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RemoteKey

    /** Exchange remote keys. */
    @JvmOverloads
    fun regenerate(
        params: RemoteKeyRegenerateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RemoteKey
}

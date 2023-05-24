@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.LinkToken
import dev.merge.api.models.hris.LinkTokenCreateParams

interface LinkTokenService {

    /** Creates a link token to be used when linking a new end user. */
    @JvmOverloads
    fun create(
        params: LinkTokenCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LinkToken
}

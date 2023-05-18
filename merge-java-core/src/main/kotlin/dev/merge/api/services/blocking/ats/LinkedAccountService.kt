@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.LinkedAccountDeleteParams
import dev.merge.api.models.ats.LinkedAccountListPage
import dev.merge.api.models.ats.LinkedAccountListParams

interface LinkedAccountService {

    /** List linked accounts for your organization. */
    @JvmOverloads
    fun list(
        params: LinkedAccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LinkedAccountListPage

    /** Delete a linked account. */
    @JvmOverloads
    fun delete(
        params: LinkedAccountDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )
}

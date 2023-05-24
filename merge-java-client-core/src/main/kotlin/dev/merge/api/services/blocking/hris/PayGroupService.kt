@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.PayGroup
import dev.merge.api.models.hris.PayGroupListPage
import dev.merge.api.models.hris.PayGroupListParams
import dev.merge.api.models.hris.PayGroupRetrieveParams

interface PayGroupService {

    /** Returns a `PayGroup` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: PayGroupRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PayGroup

    /** Returns a list of `PayGroup` objects. */
    @JvmOverloads
    fun list(
        params: PayGroupListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PayGroupListPage
}

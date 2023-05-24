@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Office
import dev.merge.api.models.ats.OfficeListPage
import dev.merge.api.models.ats.OfficeListParams
import dev.merge.api.models.ats.OfficeRetrieveParams

interface OfficeService {

    /** Returns an `Office` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: OfficeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Office

    /** Returns a list of `Office` objects. */
    @JvmOverloads
    fun list(
        params: OfficeListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OfficeListPage
}

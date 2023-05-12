@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.accounting

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.accounting.TrackingCategory
import dev.merge.api.models.accounting.TrackingCategoryListPage
import dev.merge.api.models.accounting.TrackingCategoryListParams
import dev.merge.api.models.accounting.TrackingCategoryRetrieveParams

interface TrackingCategoryService {

    /** Returns a `TrackingCategory` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: TrackingCategoryRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TrackingCategory

    /** Returns a list of `TrackingCategory` objects. */
    @JvmOverloads
    fun list(
        params: TrackingCategoryListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TrackingCategoryListPage
}

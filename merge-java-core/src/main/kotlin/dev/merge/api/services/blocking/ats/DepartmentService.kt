@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Department
import dev.merge.api.models.ats.DepartmentListPage
import dev.merge.api.models.ats.DepartmentListParams
import dev.merge.api.models.ats.DepartmentRetrieveParams

interface DepartmentService {

    /** Returns a `Department` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: DepartmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Department

    /** Returns a list of `Department` objects. */
    @JvmOverloads
    fun list(
        params: DepartmentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DepartmentListPage
}

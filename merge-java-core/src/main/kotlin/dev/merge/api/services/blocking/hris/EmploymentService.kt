@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.Employment
import dev.merge.api.models.hris.EmploymentListPage
import dev.merge.api.models.hris.EmploymentListParams
import dev.merge.api.models.hris.EmploymentRetrieveParams

interface EmploymentService {

    /** Returns an `Employment` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EmploymentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Employment

    /** Returns a list of `Employment` objects. */
    @JvmOverloads
    fun list(
        params: EmploymentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EmploymentListPage
}

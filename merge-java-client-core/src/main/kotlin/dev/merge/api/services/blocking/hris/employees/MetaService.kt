@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris.employees

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.hris.EmployeeMetaForCreateParams

interface MetaService {

    /** Returns metadata for `Employee` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: EmployeeMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): MetaResponse
}

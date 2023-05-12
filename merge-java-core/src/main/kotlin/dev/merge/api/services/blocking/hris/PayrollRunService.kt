@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.PayrollRun
import dev.merge.api.models.hris.PayrollRunListPage
import dev.merge.api.models.hris.PayrollRunListParams
import dev.merge.api.models.hris.PayrollRunRetrieveParams

interface PayrollRunService {

    /** Returns a `PayrollRun` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: PayrollRunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PayrollRun

    /** Returns a list of `PayrollRun` objects. */
    @JvmOverloads
    fun list(
        params: PayrollRunListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PayrollRunListPage
}

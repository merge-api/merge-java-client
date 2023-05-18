@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.EmployeePayrollRun
import dev.merge.api.models.hris.EmployeePayrollRunListPageAsync
import dev.merge.api.models.hris.EmployeePayrollRunListParams
import dev.merge.api.models.hris.EmployeePayrollRunRetrieveParams
import java.util.concurrent.CompletableFuture

interface EmployeePayrollRunServiceAsync {

    /** Returns an `EmployeePayrollRun` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EmployeePayrollRunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EmployeePayrollRun>

    /** Returns a list of `EmployeePayrollRun` objects. */
    @JvmOverloads
    fun list(
        params: EmployeePayrollRunListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EmployeePayrollRunListPageAsync>
}

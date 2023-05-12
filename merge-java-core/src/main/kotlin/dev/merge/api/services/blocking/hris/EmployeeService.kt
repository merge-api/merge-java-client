@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.blocking.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.CreatedEmployeeResponse
import dev.merge.api.models.hris.Employee
import dev.merge.api.models.hris.EmployeeCreateParams
import dev.merge.api.models.hris.EmployeeIgnoreParams
import dev.merge.api.models.hris.EmployeeListPage
import dev.merge.api.models.hris.EmployeeListParams
import dev.merge.api.models.hris.EmployeeRetrieveParams
import dev.merge.api.services.blocking.hris.employees.MetaService

interface EmployeeService {

    fun meta(): MetaService

    /** Creates an `Employee` object with the given values. */
    @JvmOverloads
    fun create(
        params: EmployeeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CreatedEmployeeResponse

    /** Returns an `Employee` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EmployeeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Employee

    /** Returns a list of `Employee` objects. */
    @JvmOverloads
    fun list(
        params: EmployeeListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EmployeeListPage

    /**
     * Ignores a specific row based on the `model_id` in the url. These records will have their
     * properties set to null, and will not be updated in future syncs. The "reason" and "message"
     * fields in the request body will be stored for audit purposes.
     */
    @JvmOverloads
    fun ignore(params: EmployeeIgnoreParams, requestOptions: RequestOptions = RequestOptions.none())
}

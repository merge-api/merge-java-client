@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.ats

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.ats.Department
import dev.merge.api.models.ats.DepartmentListPageAsync
import dev.merge.api.models.ats.DepartmentListParams
import dev.merge.api.models.ats.DepartmentRetrieveParams
import java.util.concurrent.CompletableFuture

interface DepartmentServiceAsync {

    /** Returns a `Department` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: DepartmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Department>

    /** Returns a list of `Department` objects. */
    @JvmOverloads
    fun list(
        params: DepartmentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<DepartmentListPageAsync>
}

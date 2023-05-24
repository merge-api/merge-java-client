@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.Employment
import dev.merge.api.models.hris.EmploymentListPageAsync
import dev.merge.api.models.hris.EmploymentListParams
import dev.merge.api.models.hris.EmploymentRetrieveParams
import java.util.concurrent.CompletableFuture

interface EmploymentServiceAsync {

    /** Returns an `Employment` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: EmploymentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Employment>

    /** Returns a list of `Employment` objects. */
    @JvmOverloads
    fun list(
        params: EmploymentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<EmploymentListPageAsync>
}

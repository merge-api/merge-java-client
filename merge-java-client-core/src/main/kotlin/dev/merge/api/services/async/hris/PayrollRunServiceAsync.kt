@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.PayrollRun
import dev.merge.api.models.hris.PayrollRunListPageAsync
import dev.merge.api.models.hris.PayrollRunListParams
import dev.merge.api.models.hris.PayrollRunRetrieveParams
import java.util.concurrent.CompletableFuture

interface PayrollRunServiceAsync {

    /** Returns a `PayrollRun` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: PayrollRunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<PayrollRun>

    /** Returns a list of `PayrollRun` objects. */
    @JvmOverloads
    fun list(
        params: PayrollRunListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<PayrollRunListPageAsync>
}

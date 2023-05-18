@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.Company
import dev.merge.api.models.hris.CompanyListPageAsync
import dev.merge.api.models.hris.CompanyListParams
import dev.merge.api.models.hris.CompanyRetrieveParams
import java.util.concurrent.CompletableFuture

interface CompanyServiceAsync {

    /** Returns a `Company` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: CompanyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Company>

    /** Returns a list of `Company` objects. */
    @JvmOverloads
    fun list(
        params: CompanyListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<CompanyListPageAsync>
}

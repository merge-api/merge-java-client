@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.BankInfo
import dev.merge.api.models.hris.BankListPageAsync
import dev.merge.api.models.hris.BankListParams
import dev.merge.api.models.hris.BankRetrieveParams
import java.util.concurrent.CompletableFuture

interface BankServiceAsync {

    /** Returns a `BankInfo` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: BankRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<BankInfo>

    /** Returns a list of `BankInfo` objects. */
    @JvmOverloads
    fun list(
        params: BankListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<BankListPageAsync>
}

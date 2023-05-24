@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.hris

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.hris.PayGroup
import dev.merge.api.models.hris.PayGroupListPageAsync
import dev.merge.api.models.hris.PayGroupListParams
import dev.merge.api.models.hris.PayGroupRetrieveParams
import java.util.concurrent.CompletableFuture

interface PayGroupServiceAsync {

    /** Returns a `PayGroup` object with the given `id`. */
    @JvmOverloads
    fun retrieve(
        params: PayGroupRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<PayGroup>

    /** Returns a list of `PayGroup` objects. */
    @JvmOverloads
    fun list(
        params: PayGroupListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<PayGroupListPageAsync>
}

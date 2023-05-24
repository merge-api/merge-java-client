@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package dev.merge.api.services.async.accounting.purchaseOrders

import dev.merge.api.core.RequestOptions
import dev.merge.api.models.MetaResponse
import dev.merge.api.models.accounting.PurchaseOrderMetaForCreateParams
import java.util.concurrent.CompletableFuture

interface MetaServiceAsync {

    /** Returns metadata for `PurchaseOrder` POSTs. */
    @JvmOverloads
    fun forCreate(
        params: PurchaseOrderMetaForCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MetaResponse>
}
